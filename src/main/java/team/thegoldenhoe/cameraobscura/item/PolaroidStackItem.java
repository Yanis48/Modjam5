package team.thegoldenhoe.cameraobscura.item;

import java.util.List;
import java.util.UUID;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import team.thegoldenhoe.cameraobscura.init.COItems;

public class PolaroidStackItem extends Item {
	private static final int MAX_STORAGE = 6;

	public PolaroidStackItem(Settings settings) {
		super(settings);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		if (stack.getTag() == null) {
			tooltip.add(new LiteralText("Empty"));
		}

		tooltip.add(new LiteralText("Prints Remaining: " + getRemainingUses(stack)).formatted(Formatting.AQUA, Formatting.BOLD));
		tooltip.add(new LiteralText("Usable in polaroid camera").formatted(Formatting.DARK_PURPLE, Formatting.ITALIC));
	}

	public static int getUses(ItemStack stack) {
		CompoundTag root = stack.getTag();
		if (root != null) {
			return root.getInt("Uses");
		}
		return 0;
	}

	public static int getRemainingUses(ItemStack stack) {
		return MAX_STORAGE - getUses(stack);
	}

	public static void savePhoto(ItemStack stack, PlayerEntity user, UUID photoName) {
		CompoundTag root = stack.getOrCreateTag();
		if (root != null) {
			int uses = getUses(stack);
			root.putInt("Uses", uses + 1);

			ItemStack polaroidPhoto = new ItemStack(COItems.POLAROID_PHOTO);
			PolaroidPhotoItem.setPhoto(polaroidPhoto, photoName);
			user.inventory.insertStack(polaroidPhoto);

			if (getRemainingUses(stack) == 0) {
				stack.decrement(1);
			}
		}
	}
}
