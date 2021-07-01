package team.thegoldenhoe.cameraobscura.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import team.thegoldenhoe.cameraobscura.block.entity.HorizontalFrameBlockEntity;

public class HorizontalFrameBlock extends FrameBlock {

	public HorizontalFrameBlock(DyeColor color, Settings settings) {
		super(color, settings);
	}

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new HorizontalFrameBlockEntity(pos, state);
	}
}
