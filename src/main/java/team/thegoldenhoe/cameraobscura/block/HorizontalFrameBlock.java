package team.thegoldenhoe.cameraobscura.block;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.world.BlockView;
import team.thegoldenhoe.cameraobscura.block.entity.HorizontalFrameBlockEntity;

public class HorizontalFrameBlock extends FrameBlock {

	public HorizontalFrameBlock(DyeColor color, Settings settings) {
		super(color, settings);
	}

	@Override
	public BlockEntity createBlockEntity(BlockView world) {
		return new HorizontalFrameBlockEntity();
	}
}
