package team.thegoldenhoe.cameraobscura.item.camera;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import team.thegoldenhoe.cameraobscura.client.PhotographHelper;
import team.thegoldenhoe.cameraobscura.util.CameraType;
import team.thegoldenhoe.cameraobscura.util.Utils;

import java.util.UUID;

public abstract class CameraItem extends Item {
	private CameraType type;

	protected CameraItem(CameraType type, Settings settings) {
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
			user.openHandledScreen(this.createScreenHandlerFactory(stack));
			return TypedActionResult.success(stack);
		}

		if (this.canTakePhoto(stack)) {
			UUID photoName = UUID.randomUUID();
			if (world.isClient()) {
				this.takePicture(stack, photoName);
			}
			this.onTakePicture(stack, user, photoName);
		}

		return super.use(world, user, hand);
	}

	public CameraType getType() {
		return this.type;
	}

	protected abstract boolean canTakePhoto(ItemStack camera);

	protected void onTakePicture(ItemStack camera, PlayerEntity user, UUID photoName) {
		user.world.addParticle(ParticleTypes.FIREWORK, user.getPos().getX() + user.world.random.nextFloat(), user.getPos().getY() + user.world.random.nextFloat() + 1, user.getPos().getZ() + user.world.random.nextFloat(), 0.0D, 0.0D, 0.0D);
		user.playSound(this.type.getSound(), SoundCategory.MASTER, 1.0F, 5.0F);
	}

	protected abstract NamedScreenHandlerFactory createScreenHandlerFactory(ItemStack camera);

	private void takePicture(ItemStack stack, UUID photoName) {
		MinecraftClient client = MinecraftClient.getInstance();
		// Store the setting previous to taking the picture
		final boolean hudHidden = client.options.hudHidden;

		client.options.hudHidden = true;
		RenderSystem.recordRenderCall(() -> PhotographHelper.capturePhotograph(stack, photoName));
		RenderSystem.recordRenderCall(() -> client.options.hudHidden = hudHidden);
	}
}
