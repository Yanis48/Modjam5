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
import team.thegoldenhoe.cameraobscura.item.nbt.CameraData;

public class VintagePhotoItem extends Item {

	public VintagePhotoItem(Settings settings) {
		super(settings);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		if (stack.getTag() == null) {
			tooltip.add(new LiteralText("Empty"));
			tooltip.add(new LiteralText("Usable in vintage camera").formatted(Formatting.DARK_PURPLE, Formatting.ITALIC));
			return;
		}

		if (CameraData.getPhoto(stack) != null) {
			tooltip.add(new LiteralText("Contains Photo").formatted(Formatting.ITALIC));
		}
	}

	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
		return CameraCapabilities.getProvider(CameraCapabilities.getVintageStorageCapability(), () -> {
			VintageStorage ret = new VintageStorage() {

				@Override
				public void saveImage(String path, EntityPlayer player) {
					super.saveImage(path, player);
					stack.setTagCompound(serializeNBT());

					if (!player.world.isRemote) {
						stack.getTagCompound().setString("Photo", path);
					}
				}
			};

			if (stack.hasTagCompound()) {
				ret.deserializeNBT(stack.getTagCompound());
				// If a photo is already saved, update nbt to reflect that.
				// Prevents dupe saving.
				if (stack.getTagCompound().hasKey("Photo")) {
					String path = stack.getTagCompound().getString("Photo");
					ret.getSavedImagePaths().add(path);
					ret.serializeNBT();
				}
			}
			return ret;
		});
	}
}
