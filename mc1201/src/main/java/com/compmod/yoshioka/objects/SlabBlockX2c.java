package com.compmod.yoshioka.objects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class SlabBlockX2c extends SlabBlock {

	protected static final VoxelShape BOTTOM_AABB_X2C = Block.box(0.0D, 4.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	protected static final VoxelShape TOP_AABB_X2C = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 12.0D, 16.0D);
	protected static final VoxelShape DOUBLE_AABB_X2C = Block.box(0.0D, 4.0D, 0.0D, 16.0D, 12.0D, 16.0D);

	public SlabBlockX2c (BlockBehaviour.Properties properties){
		super(properties);
	}

	@Override
	public VoxelShape getShape(BlockState p_56390_, BlockGetter p_56391_, BlockPos p_56392_, CollisionContext p_56393_) {
		SlabType slabtype = p_56390_.getValue(TYPE);
		switch (slabtype) {
			case DOUBLE:
				return DOUBLE_AABB_X2C;
			case TOP:
				return TOP_AABB_X2C;
			default:
				return BOTTOM_AABB_X2C;
		}
	}

}
