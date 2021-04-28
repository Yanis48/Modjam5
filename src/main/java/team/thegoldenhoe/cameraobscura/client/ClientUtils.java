package team.thegoldenhoe.cameraobscura.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;
import team.thegoldenhoe.cameraobscura.CameraObscura;

@Environment(EnvType.CLIENT)
public class ClientUtils {

	public static Identifier bindTextureGui(String path) {
		Identifier id = CameraObscura.id(String.format("textures/gui/%s.png", path));
		MinecraftClient.getInstance().getTextureManager().bindTexture(id);
		return id;
	}
}
