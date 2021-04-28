package team.thegoldenhoe.cameraobscura.item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class SdCardItem extends Item {
	private static final int MAX_STORAGE = 32;

	public SdCardItem(Settings settings) {
		super(settings);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		if (stack.getTag() == null) {
			tooltip.add(new LiteralText("Empty"));
		}

		tooltip.add(new LiteralText("Shots Remaining: " + getRemainingUses(stack)).formatted(Formatting.AQUA, Formatting.BOLD));
		tooltip.add(new LiteralText("Usable in digital camera").formatted(Formatting.WHITE, Formatting.ITALIC));
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

	public static List<UUID> getPhotos(ItemStack stack) {
		List<UUID> photos = new ArrayList<>();
		CompoundTag root = stack.getTag();
		if (root != null) {
			ListTag list = root.getList("Photos", 11);
			list.forEach(e -> photos.add(UUID.fromString(e.toString())));
		}
		return photos;
	}

	public static void savePhoto(ItemStack stack, UUID photoName) {
		CompoundTag root = stack.getOrCreateTag();
		if (root != null) {
			int uses = getUses(stack);
			root.putInt("Uses", uses + 1);

			if (!root.contains("Photos", 9)) {
				root.put("Photos", new ListTag());
			}
			root.getList("Photos", 11).add(NbtHelper.fromUuid(photoName));
		}
	}
}
