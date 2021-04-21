package team.thegoldenhoe.cameraobscura.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import team.thegoldenhoe.cameraobscura.client.screen.CameraScreen;
import team.thegoldenhoe.cameraobscura.init.COScreenHandlers;
import team.thegoldenhoe.cameraobscura.screen.DigitalCameraScreenHandler;
import team.thegoldenhoe.cameraobscura.screen.PolaroidCameraScreenHandler;
import team.thegoldenhoe.cameraobscura.screen.VintageCameraScreenHandler;

public class CameraObscuraClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ScreenRegistry.register(COScreenHandlers.DIGITAL_CAMERA, CameraScreen<DigitalCameraScreenHandler>::new);
		ScreenRegistry.register(COScreenHandlers.POLAROID_CAMERA, CameraScreen<PolaroidCameraScreenHandler>::new);
		ScreenRegistry.register(COScreenHandlers.VINTAGE_CAMERA, CameraScreen<VintageCameraScreenHandler>::new);
	}
}
