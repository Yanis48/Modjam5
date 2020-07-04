package team.thegoldenhoe.cameraobscura.screen;

import net.minecraft.entity.player.PlayerInventory;
import team.thegoldenhoe.cameraobscura.common.network.CameraType;
import team.thegoldenhoe.cameraobscura.registry.COScreenHandlers;

public class VintageCameraScreenHandler extends SingleSlotCameraScreenHandler {

	public VintageCameraScreenHandler(int syncId, PlayerInventory playerInv) {
		super(COScreenHandlers.VINTAGE_CAMERA, syncId, playerInv, CameraType.VINTAGE);
	}
}
