package team.thegoldenhoe.cameraobscura.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.Identifier;
import team.thegoldenhoe.cameraobscura.CameraObscura;

@Environment(EnvType.CLIENT)
public class ClientUtils {

	public static Identifier bindTextureGui(String path) {
		Identifier id = CameraObscura.id(String.format("textures/gui/%s.png", path));
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, id);
		return id;
	}
}
