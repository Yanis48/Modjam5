package team.thegoldenhoe.cameraobscura.network;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ServerPhoto {
    private ByteArrayOutputStream bytes;

    public ServerPhoto() {
        this.bytes = new ByteArrayOutputStream();
    }

    public void read(byte[] bytes) throws IOException {
        this.bytes.write(bytes);
    }

    public BufferedImage toImage() throws IOException {
        ByteArrayInputStream stream = new ByteArrayInputStream(this.bytes.toByteArray());
        return ImageIO.read(stream);
    }
}
