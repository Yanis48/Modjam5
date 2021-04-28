package team.thegoldenhoe.cameraobscura.screen;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import team.thegoldenhoe.cameraobscura.init.COScreenHandlers;
import team.thegoldenhoe.cameraobscura.util.CameraType;

public class PolaroidCameraScreenHandler extends SingleSlotCameraScreenHandler {
	private static final String POLAROID_CAMERA_TEXTURE = "polaroid_camera";

	public PolaroidCameraScreenHandler(int syncId, PlayerInventory playerInv) {
		this(syncId, playerInv, ItemStack.EMPTY);
	}

	public PolaroidCameraScreenHandler(int syncId, PlayerInventory playerInv, ItemStack camera) {
		super(COScreenHandlers.POLAROID_CAMERA, syncId, playerInv, camera, CameraType.POLAROID);
	}

	@Override
	public String getScreenBackground() {
		return POLAROID_CAMERA_TEXTURE;
	}
}
