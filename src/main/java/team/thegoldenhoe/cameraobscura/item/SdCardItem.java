package team.thegoldenhoe.cameraobscura.item;

import java.util.ArrayList;
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
import team.thegoldenhoe.cameraobscura.common.capability.CameraCapabilities;
import team.thegoldenhoe.cameraobscura.common.capability.ICameraStorageNBT;
import team.thegoldenhoe.cameraobscura.common.capability.ICameraStorageNBT.SDCardStorage;

public class SdCardItem extends Item {

	public SdCardItem(Settings settings) {
		super(settings);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		int numShotsRemaining = SDCardStorage.MAX_SAVES;
		if (stack.getTag() == null) {
			tooltip.add(new LiteralText("Empty"));
		}

		ICameraStorageNBT.SDCardStorage storage = stack.getCapability(CameraCapabilities.getSDCardStorageCapability(), null);
		if (storage != null) {
			ArrayList<String> paths = storage.getSavedImagePaths();
			numShotsRemaining = storage.getMaxSaves() - paths.size();
			tooltip.add(new LiteralText("Shots Remaining: " + numShotsRemaining).formatted(Formatting.AQUA, Formatting.BOLD));
			tooltip.add(new LiteralText("Usable in digital camera").formatted(Formatting.WHITE, Formatting.ITALIC));
		}
	}

	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
		return CameraCapabilities.getProvider(CameraCapabilities.getSDCardStorageCapability(), () -> {
			SDCardStorage ret = new SDCardStorage() {
				@Override
				public void saveImage(String path, EntityPlayer player) {
					super.saveImage(path, player);
					stack.setTagCompound(serializeNBT());
				}
			};
			if (stack.hasTagCompound()) {
				ret.deserializeNBT(stack.getTagCompound());
			}
			return ret;
		});
	}

}
