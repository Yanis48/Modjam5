package team.thegoldenhoe.cameraobscura.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import team.thegoldenhoe.cameraobscura.block.entity.HangingFrameBlockEntity;

public class HangingFrameBlock extends AbstractFrameBlock {

	public HangingFrameBlock(Settings settings) {
		super(settings);
	}

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new HangingFrameBlockEntity(pos, state);
	}
}
