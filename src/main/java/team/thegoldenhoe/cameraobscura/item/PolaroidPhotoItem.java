package team.thegoldenhoe.cameraobscura.item;

import java.util.List;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class PolaroidPhotoItem extends Item {

	public PolaroidPhotoItem(Settings settings) {
		super(settings);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		if (stack.getTag() == null) {
			tooltip.add(new LiteralText("Empty"));
			tooltip.add(new LiteralText("Usable to craft a polaroid stack").formatted(Formatting.AQUA, Formatting.ITALIC));
			return;
		}

		if (stack.getTag().contains("Photo")) {
			tooltip.add(new LiteralText("Contains Photo").formatted(Formatting.ITALIC));
		}
	}
}
