package team.thegoldenhoe.cameraobscura.client;

import java.awt.image.BufferedImage;

public interface PhotoFilter {
	BufferedImage getFilteredImage(BufferedImage src);
}
