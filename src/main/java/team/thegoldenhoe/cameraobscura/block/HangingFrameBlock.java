package team.thegoldenhoe.cameraobscura.block;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import team.thegoldenhoe.cameraobscura.block.entity.HangingFrameBlockEntity;

public class HangingFrameBlock extends AbstractFrameBlock {

	public HangingFrameBlock(Settings settings) {
		super(settings);
	}

	@Override
	public BlockEntity createBlockEntity(BlockView world) {
		return new HangingFrameBlockEntity();
	}
}
