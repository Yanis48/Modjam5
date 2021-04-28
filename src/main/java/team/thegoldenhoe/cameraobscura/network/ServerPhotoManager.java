package team.thegoldenhoe.cameraobscura.network;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.WorldSavePath;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ServerPhotoManager {
    private static final String PHOTOS_DIRECTORY = "photos";
    private final File photosDirectory;
    private final Map<UUID, ServerPhoto> pendingPhotos;

    public ServerPhotoManager(MinecraftServer server) {
        File saveDirectory = server.getSavePath(WorldSavePath.ROOT).toFile();
        this.photosDirectory = new File(saveDirectory, PHOTOS_DIRECTORY);
        this.photosDirectory.mkdir();
        this.pendingPhotos = new HashMap<>();
    }

    public BufferedImage get(UUID name) {
        File photo = new File(this.photosDirectory, name.toString());

        if (photo.exists() && photo.isFile()) {
            try {
                return ImageIO.read(photo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public void put(PacketByteBuf buf) throws IOException {
        UUID name = buf.readUuid();
        byte[] bytes = buf.readByteArray();
        boolean isFinal = buf.readBoolean();

        if (this.pendingPhotos.containsKey(name)) {
            ServerPhoto photo = this.pendingPhotos.get(name);
            photo.read(bytes);
        } else {
            ServerPhoto photo = new ServerPhoto();
            photo.read(bytes);
            this.pendingPhotos.put(name, photo);
        }

        if (isFinal) {
            BufferedImage image = this.pendingPhotos.get(name).toImage();
            File file = new File(this.photosDirectory, name.toString() + ".png");
            ImageIO.write(image, "png", file);

            this.pendingPhotos.remove(name);
        }
    }
}
