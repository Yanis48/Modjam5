package team.thegoldenhoe.cameraobscura.init;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.thegoldenhoe.cameraobscura.Info;
import team.thegoldenhoe.cameraobscura.block.entity.FrameBlockEntity;
import team.thegoldenhoe.cameraobscura.block.entity.HangingFrameBlockEntity;
import team.thegoldenhoe.cameraobscura.block.entity.HorizontalFrameBlockEntity;

public class COBlockEntities {
	private static final Block[] FRAMES = (Block[]) COTags.Blocks.FRAMES.values().toArray();
	private static final Block[] HORIZONTAL_FRAMES = (Block[]) COTags.Blocks.HORIZONTAL_FRAMES.values().toArray();
	private static final Block[] HANGING_FRAMES = (Block[]) COTags.Blocks.HANGING_FRAMES.values().toArray();

	public static final BlockEntityType<FrameBlockEntity> FRAME = register("frame", BlockEntityType.Builder.create(FrameBlockEntity::new, FRAMES));
	public static final BlockEntityType<HorizontalFrameBlockEntity> HORIZONTAL_FRAME = register("horizontal_frame", BlockEntityType.Builder.create(HorizontalFrameBlockEntity::new, HORIZONTAL_FRAMES));
	public static final BlockEntityType<HangingFrameBlockEntity> HANGING_FRAME = register("hanging_frame", BlockEntityType.Builder.create(HangingFrameBlockEntity::new, HANGING_FRAMES));

	private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType.Builder<T> builder) {
		return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Info.MODID, name), builder.build(null));
	}
}
