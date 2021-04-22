package team.thegoldenhoe.cameraobscura.item;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import team.thegoldenhoe.cameraobscura.client.PhotographHelper;
import team.thegoldenhoe.cameraobscura.util.CameraType;
import team.thegoldenhoe.cameraobscura.util.Utils;

public class CameraItem extends Item {
	private CameraType type;

	public CameraItem(CameraType type, Settings settings) {
		super(settings);
		this.type = type;
	}

	/**
	 * Called when the equipped item is right clicked.
	 */
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack stack = user.getStackInHand(hand);

		if (hand == Hand.OFF_HAND) {
			// If camera in both hands, take picture with main hand
			if (Utils.isCamera(user.getStackInHand(Hand.MAIN_HAND))) {
				return TypedActionResult.pass(stack);
			}
		}

		// Open gui if player is sneaking
		if (user.isSneaking()) {
			user.openHandledScreen(this.createScreenHandlerFactory());
			return TypedActionResult.success(stack);
		}

		if (world.isClient()) {
			this.takePicture();
			world.addParticle(ParticleTypes.FIREWORK, user.getPos().getX() + user.world.random.nextFloat(), user.getPos().getY() + user.world.random.nextFloat() + 1, user.getPos().getZ() + user.world.random.nextFloat(), 0.0D, 0.0D, 0.0D);
			user.playSound(this.type.getSound(), SoundCategory.MASTER, 1.0F, 5.0F);
		}

		return TypedActionResult.pass(stack);
	}

	private void takePicture() {
		MinecraftClient client = MinecraftClient.getInstance();
		// Store the setting previous to taking the picture
		final boolean hudHidden = client.options.hudHidden;

		client.options.hudHidden = true;
		PhotographHelper.capturePhotograph();
		client.options.hudHidden = hudHidden;
	}

	private NamedScreenHandlerFactory createScreenHandlerFactory() {
		return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> {
			return this.type.getScreenHandlerType().create(syncId, inventory);
		}, new LiteralText(""));
	}
}
