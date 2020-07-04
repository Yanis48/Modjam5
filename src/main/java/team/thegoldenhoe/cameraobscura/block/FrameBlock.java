package team.thegoldenhoe.cameraobscura.block;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.world.BlockView;
import team.thegoldenhoe.cameraobscura.block.entity.FrameBlockEntity;

public class FrameBlock extends AbstractFrameBlock {

	public FrameBlock(DyeColor color, Settings settings) {
		super(settings);
	}

	@Override
	public BlockEntity createBlockEntity(BlockView world) {
		return new FrameBlockEntity();
	}
}
