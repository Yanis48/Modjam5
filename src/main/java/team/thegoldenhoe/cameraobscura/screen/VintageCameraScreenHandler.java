package team.thegoldenhoe.cameraobscura.screen;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.Hand;
import team.thegoldenhoe.cameraobscura.common.network.CameraTypes;
import team.thegoldenhoe.cameraobscura.registry.COScreenHandlers;

public class VintageCameraScreenHandler extends SingleSlotCameraScreenHandler implements CameraScreenHandler {

	public VintageCameraScreenHandler(int syncId, PlayerInventory playerInv, ScreenHandlerContext context, Hand hand, String bgName) {
		super(COScreenHandlers.VINTAGE_CAMERA, syncId, playerInv, context, hand, bgName, CameraTypes.VINTAGE);
	}
}
