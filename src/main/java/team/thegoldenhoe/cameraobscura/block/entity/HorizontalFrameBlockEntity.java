package team.thegoldenhoe.cameraobscura.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import team.thegoldenhoe.cameraobscura.init.COBlockEntities;

public class HorizontalFrameBlockEntity extends AbstractFrameBlockEntity {

	public HorizontalFrameBlockEntity(BlockPos pos, BlockState state) {
		super(COBlockEntities.HORIZONTAL_FRAME, pos, state);
	}
}
