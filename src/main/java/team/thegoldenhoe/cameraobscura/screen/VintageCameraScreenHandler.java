package team.thegoldenhoe.cameraobscura.screen;

import net.minecraft.entity.player.PlayerInventory;
import team.thegoldenhoe.cameraobscura.init.COScreenHandlers;
import team.thegoldenhoe.cameraobscura.util.CameraType;

public class VintageCameraScreenHandler extends SingleSlotCameraScreenHandler {
	private static final String VINTAGE_CAMERA_TEXTURE = "vintage_camera";

	public VintageCameraScreenHandler(int syncId, PlayerInventory playerInv) {
		super(COScreenHandlers.VINTAGE_CAMERA, syncId, playerInv, CameraType.VINTAGE);
	}

	@Override
	public String getScreenBackground() {
		return VINTAGE_CAMERA_TEXTURE;
	}
}
