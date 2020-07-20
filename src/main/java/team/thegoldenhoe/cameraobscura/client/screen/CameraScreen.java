package team.thegoldenhoe.cameraobscura.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import team.thegoldenhoe.cameraobscura.client.ClientUtils;
import team.thegoldenhoe.cameraobscura.screen.CameraScreenHandler;

public class CameraScreen<T extends CameraScreenHandler> extends HandledScreen<T> {

	public CameraScreen(T handler, PlayerInventory playerInventory, Text title) {
		super(handler, playerInventory, title);
	}

	@Override
	protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.disableLighting();
		ClientUtils.bindTextureGui(this.handler.getScreenBackground());
		this.drawTexture(matrices, this.x, this.y, 0, 0, this.x, this.y);
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		super.render(matrices, mouseX, mouseY, delta);
		this.drawMouseoverTooltip(matrices, mouseX, mouseY);
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of the items)
	 */
	@Override
	protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {

	}
}
