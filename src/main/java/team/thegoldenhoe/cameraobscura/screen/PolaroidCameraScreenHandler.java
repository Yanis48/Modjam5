package team.thegoldenhoe.cameraobscura.screen;

import net.minecraft.entity.player.PlayerInventory;
import team.thegoldenhoe.cameraobscura.registry.COScreenHandlers;
import team.thegoldenhoe.cameraobscura.util.CameraType;

public class PolaroidCameraScreenHandler extends SingleSlotCameraScreenHandler {
	private static final String POLAROID_CAMERA_TEXTURE = "polaroid_camera";

	public PolaroidCameraScreenHandler(int syncId, PlayerInventory playerInv) {
		super(COScreenHandlers.POLAROID_CAMERA, syncId, playerInv, CameraType.POLAROID);
	}

	@Override
	public String getScreenBackground() {
		return POLAROID_CAMERA_TEXTURE;
	}
}
