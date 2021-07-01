package team.thegoldenhoe.cameraobscura.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import team.thegoldenhoe.cameraobscura.init.COBlockEntities;

public class FrameBlockEntity extends AbstractFrameBlockEntity {

	public FrameBlockEntity(BlockPos pos, BlockState state) {
		super(COBlockEntities.FRAME, pos, state);
	}
}
