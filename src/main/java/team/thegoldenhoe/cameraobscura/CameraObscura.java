package team.thegoldenhoe.cameraobscura;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import team.thegoldenhoe.cameraobscura.init.*;
import team.thegoldenhoe.cameraobscura.network.NetworkHandler;
import team.thegoldenhoe.cameraobscura.network.ServerPhotoManager;

public class CameraObscura implements ModInitializer {
	public static ServerPhotoManager photoManager;

	@Override
	public void onInitialize() {
		new COBlocks();
		new COBlockEntities();
		new COItems();
		new COItemGroups();
		new COScreenHandlers();
		new COSounds();

		ServerLifecycleEvents.SERVER_STARTED.register((server -> photoManager = new ServerPhotoManager(server)));

		NetworkHandler.init();
	}
}
