package team.thegoldenhoe.cameraobscura.screen;

import net.minecraft.entity.player.PlayerInventory;
import team.thegoldenhoe.cameraobscura.registry.COScreenHandlers;
import team.thegoldenhoe.cameraobscura.util.CameraType;

public class VintageCameraScreenHandler extends SingleSlotCameraScreenHandler {

	public VintageCameraScreenHandler(int syncId, PlayerInventory playerInv) {
		super(COScreenHandlers.VINTAGE_CAMERA, syncId, playerInv, CameraType.VINTAGE);
	}
}
