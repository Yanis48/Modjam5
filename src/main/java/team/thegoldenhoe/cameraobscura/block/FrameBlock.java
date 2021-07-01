package team.thegoldenhoe.cameraobscura.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import team.thegoldenhoe.cameraobscura.block.entity.FrameBlockEntity;

public class FrameBlock extends AbstractFrameBlock {

	public FrameBlock(DyeColor color, Settings settings) {
		super(settings);
	}

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new FrameBlockEntity(pos, state);
	}
}
