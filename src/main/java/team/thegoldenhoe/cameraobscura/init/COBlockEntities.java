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
	private static final Block[] FRAMES = {COBlocks.FRAME,
			COBlocks.WHITE_FRAME, COBlocks.ORANGE_FRAME, COBlocks.MAGENTA_FRAME, COBlocks.LIGHT_BLUE_FRAME,
			COBlocks.YELLOW_FRAME, COBlocks.LIME_FRAME, COBlocks.PINK_FRAME, COBlocks.GRAY_FRAME,
			COBlocks.LIGHT_GRAY_FRAME, COBlocks.CYAN_FRAME, COBlocks.PURPLE_FRAME, COBlocks.BLUE_FRAME,
			COBlocks.BROWN_FRAME, COBlocks.GREEN_FRAME, COBlocks.RED_FRAME, COBlocks.BLACK_FRAME};
	private static final Block[] HORIZONTAL_FRAMES = {COBlocks.HORIZONTAL_FRAME,
			COBlocks.WHITE_HORIZONTAL_FRAME, COBlocks.ORANGE_HORIZONTAL_FRAME, COBlocks.MAGENTA_HORIZONTAL_FRAME, COBlocks.LIGHT_BLUE_HORIZONTAL_FRAME,
			COBlocks.YELLOW_HORIZONTAL_FRAME, COBlocks.LIME_HORIZONTAL_FRAME, COBlocks.PINK_HORIZONTAL_FRAME, COBlocks.GRAY_HORIZONTAL_FRAME,
			COBlocks.LIGHT_GRAY_HORIZONTAL_FRAME, COBlocks.CYAN_HORIZONTAL_FRAME, COBlocks.PURPLE_HORIZONTAL_FRAME, COBlocks.BLUE_HORIZONTAL_FRAME,
			COBlocks.BROWN_HORIZONTAL_FRAME, COBlocks.GREEN_HORIZONTAL_FRAME, COBlocks.RED_HORIZONTAL_FRAME, COBlocks.BLACK_HORIZONTAL_FRAME};
	private static final Block[] HANGING_FRAMES = {COBlocks.HANGING_FRAME};

	public static final BlockEntityType<FrameBlockEntity> FRAME = register("frame", BlockEntityType.Builder.create(FrameBlockEntity::new, FRAMES));
	public static final BlockEntityType<HorizontalFrameBlockEntity> HORIZONTAL_FRAME = register("horizontal_frame", BlockEntityType.Builder.create(HorizontalFrameBlockEntity::new, HORIZONTAL_FRAMES));
	public static final BlockEntityType<HangingFrameBlockEntity> HANGING_FRAME = register("hanging_frame", BlockEntityType.Builder.create(HangingFrameBlockEntity::new, HANGING_FRAMES));

	private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType.Builder<T> builder) {
		return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Info.MODID, name), builder.build(null));
	}
}
