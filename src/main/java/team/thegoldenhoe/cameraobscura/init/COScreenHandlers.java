package team.thegoldenhoe.cameraobscura.init;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry.SimpleClientHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import team.thegoldenhoe.cameraobscura.Info;
import team.thegoldenhoe.cameraobscura.screen.DigitalCameraScreenHandler;
import team.thegoldenhoe.cameraobscura.screen.PolaroidCameraScreenHandler;
import team.thegoldenhoe.cameraobscura.screen.VintageCameraScreenHandler;

public class COScreenHandlers {

	public static final ScreenHandlerType<DigitalCameraScreenHandler> DIGITAL_CAMERA = register("digital_camera", DigitalCameraScreenHandler::new);
	public static final ScreenHandlerType<PolaroidCameraScreenHandler> POLAROID_CAMERA = register("polaroid_camera", PolaroidCameraScreenHandler::new);
	public static final ScreenHandlerType<VintageCameraScreenHandler> VINTAGE_CAMERA = register("vintage_camera", VintageCameraScreenHandler::new);

	private static <T extends ScreenHandler> ScreenHandlerType<T> register(String name, SimpleClientHandlerFactory<T> factory) {
		return ScreenHandlerRegistry.registerSimple(new Identifier(Info.MODID, name), factory);
	}
}
