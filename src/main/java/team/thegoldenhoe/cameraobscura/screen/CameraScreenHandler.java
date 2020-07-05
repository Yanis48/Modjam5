package team.thegoldenhoe.cameraobscura.screen;

import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public abstract class CameraScreenHandler extends ScreenHandler {

	protected CameraScreenHandler(ScreenHandlerType<?> type, int syncId) {
		super(type, syncId);
	}

	public abstract String getScreenBackground();
}
