package team.thegoldenhoe.cameraobscura.client;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.collection.DefaultedList;
import team.thegoldenhoe.cameraobscura.item.camera.CameraItem;
import team.thegoldenhoe.cameraobscura.item.FilterItem;
import team.thegoldenhoe.cameraobscura.item.camera.CameraStorage;
import team.thegoldenhoe.cameraobscura.network.NetworkHandler;
import team.thegoldenhoe.cameraobscura.util.Utils;

import javax.imageio.ImageIO;

public class PhotographHelper {

	/**
	 * Captures a screenshot (with GUI hidden) and saves it to the server's screenshots folder
	 */
	public static void capturePhotograph(ItemStack camera, UUID photoName) {
		try {
			final MinecraftClient client = MinecraftClient.getInstance();
			final List<PhotoFilter> filters = new ArrayList<>(2);

			switch (((CameraItem) camera.getItem()).getType()) {
				case DIGITAL:
					DefaultedList<ItemStack> stacks = CameraStorage.getItems(camera);
					stacks.forEach(stack -> {
						if (Utils.isFilter(stack)) {
							filters.add(((FilterItem) stack.getItem()).getFilter());
						}
					});
					break;
				case POLAROID:
					filters.add(PhotoFilters.VINTAGE);
					break;
				case VINTAGE:
					filters.add(PhotoFilters.BLACK_AND_WHITE);
					break;
				default: break;
			}

			NativeImage screenshot = ScreenshotRecorder.takeScreenshot(client.getWindow().getFramebufferWidth(), client.getWindow().getFramebufferHeight(), client.getFramebuffer());
			BufferedImage destImage = new BufferedImage(screenshot.getWidth(), screenshot.getHeight(), BufferedImage.TYPE_INT_ARGB);

			for (int x = 0; x < screenshot.getWidth(); x++) {
				for (int y = 0; y < screenshot.getHeight(); y++) {
					int argb = abgrToArgb(screenshot.getPixelColor(x, y));
					destImage.setRGB(x, y, argb);
				}
			}

			for (PhotoFilter filter : filters) {
				destImage = filter.getFilteredImage(destImage);
			}

			saveImage(destImage);

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			ImageIO.write(destImage, "png", stream);
			byte[] imageBytes = stream.toByteArray();
			ByteBuffer buffer = ByteBuffer.wrap(imageBytes);
			int bytePacketLength = 30000;

			while (buffer.hasRemaining()) {
				byte[] subImageBytes = new byte[Math.min(buffer.remaining(), bytePacketLength)];
				buffer.get(subImageBytes, 0, Math.min(buffer.remaining(), bytePacketLength));

				PacketByteBuf buf = PacketByteBufs.create();
				buf.writeUuid(photoName);
				buf.writeByteArray(subImageBytes);
				buf.writeBoolean(buffer.remaining() == 0);

				ClientPlayNetworking.send(NetworkHandler.SEND_PHOTO_CHANNEL, buf);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int abgrToArgb(int abgr) {
		int r = (abgr >> 16) & 0xFF;
		int b = abgr & 0xFF;
		return (abgr & 0xFF00FF00) | (b << 16) | r;
	}

	public static void saveImage(BufferedImage image) {
		final MinecraftClient client = MinecraftClient.getInstance();

		File directory = new File(client.runDirectory, "screenshots");
		directory.mkdir();

		File file = Utils.getTimestampedPNGFileForDirectory(directory);

		try {
			ImageIO.write(image,"png", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
