package team.thegoldenhoe.cameraobscura.screen;

import net.minecraft.entity.player.PlayerInventory;
import team.thegoldenhoe.cameraobscura.common.network.CameraType;
import team.thegoldenhoe.cameraobscura.registry.COScreenHandlers;

public class PolaroidCameraScreenHandler extends SingleSlotCameraScreenHandler {

	public PolaroidCameraScreenHandler(int syncId, PlayerInventory playerInv) {
		super(COScreenHandlers.POLAROID_CAMERA, syncId, playerInv, CameraType.POLAROID);
	}
}
