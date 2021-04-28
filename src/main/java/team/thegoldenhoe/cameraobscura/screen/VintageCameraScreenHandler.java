package team.thegoldenhoe.cameraobscura.screen;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import team.thegoldenhoe.cameraobscura.init.COScreenHandlers;
import team.thegoldenhoe.cameraobscura.util.CameraType;

public class VintageCameraScreenHandler extends SingleSlotCameraScreenHandler {
	private static final String VINTAGE_CAMERA_TEXTURE = "vintage_camera";

	public VintageCameraScreenHandler(int syncId, PlayerInventory playerInv) {
		this(syncId, playerInv, ItemStack.EMPTY);
	}

	public VintageCameraScreenHandler(int syncId, PlayerInventory playerInv, ItemStack camera) {
		super(COScreenHandlers.VINTAGE_CAMERA, syncId, playerInv, camera, CameraType.VINTAGE);
	}

	@Override
	public String getScreenBackground() {
		return VINTAGE_CAMERA_TEXTURE;
	}
}
