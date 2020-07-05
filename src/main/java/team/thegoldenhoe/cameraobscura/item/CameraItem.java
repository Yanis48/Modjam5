package team.thegoldenhoe.cameraobscura.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import team.thegoldenhoe.cameraobscura.util.CameraType;

public class CameraItem extends Item {
	private CameraType type;

	public CameraItem(CameraType type, Settings settings) {
		super(settings);
		this.type = type;
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack stack = user.getStackInHand(hand);

		// Open gui if player is sneaking
		if (user.isSneaking()) {
			user.openHandledScreen(this.createScreenHandlerFactory());
			return TypedActionResult.success(stack);
		} else {
			user.playSound(this.type.getSound(), SoundCategory.MASTER, 1.0F, 5.0F);
		}

		return TypedActionResult.pass(stack);
	}

	private NamedScreenHandlerFactory createScreenHandlerFactory() {
		return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> {
			return this.type.getScreenHandlerType().create(syncId, inventory);
		}, new LiteralText(""));
	}
}
