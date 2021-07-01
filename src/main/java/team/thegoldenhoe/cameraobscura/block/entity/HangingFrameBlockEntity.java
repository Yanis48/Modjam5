package team.thegoldenhoe.cameraobscura.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import team.thegoldenhoe.cameraobscura.init.COBlockEntities;

public class HangingFrameBlockEntity extends AbstractFrameBlockEntity {

	public HangingFrameBlockEntity(BlockPos pos, BlockState state) {
		super(COBlockEntities.HANGING_FRAME, pos, state);
	}
}
