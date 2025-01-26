package com.compmod.yoshioka.objects;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class SlabBlockVT extends SlabBlock {

	public static final EnumProperty<SlabType> TYPE = BlockStateProperties.SLAB_TYPE;
	public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

	protected static final VoxelShape NORTH = Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);
	protected static final VoxelShape EAST = Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
	protected static final VoxelShape WEST = Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public SlabBlockVT (BlockBehaviour.Properties properties){
		super(properties);
		this.registerDefaultState(this.defaultBlockState()
				.setValue(TYPE, SlabType.BOTTOM)
				.setValue(WATERLOGGED, Boolean.valueOf(false))
				.setValue(FACING, Direction.NORTH)
				);
	}

	//BlockStateの定義を追加
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_56388_) {
		p_56388_.add(TYPE, WATERLOGGED, FACING);
	}

	@Override
	public VoxelShape getShape(BlockState p_56390_, BlockGetter p_56391_, BlockPos p_56392_, CollisionContext p_56393_) {
//		SlabType slabtype = p_56390_.getValue(TYPE);
		Direction direction = p_56390_.getValue(FACING);

		switch (direction) {
			case SOUTH:
				return SOUTH;
			case EAST:
				return EAST;
			case WEST:
				return WEST;
			default:
				return NORTH;
		}
	}

	//BlockStateに方向の取得処理を追加
	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext p_56361_) {
		BlockPos blockpos = p_56361_.getClickedPos();
//		BlockState blockstate = p_56361_.getLevel().getBlockState(blockpos);

		FluidState fluidstate = p_56361_.getLevel().getFluidState(blockpos);
		BlockState blockstate1 = this.defaultBlockState()
      		.setValue(TYPE, SlabType.BOTTOM)
      		.setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER))
      		.setValue(BlockStateProperties.HORIZONTAL_FACING, p_56361_.getHorizontalDirection().getOpposite());

		Direction direction = p_56361_.getClickedFace();
		return direction != Direction.DOWN &&
      		(direction == Direction.UP || !(p_56361_.getClickLocation().y - (double)blockpos.getY() > 0.5D))
      		? blockstate1
      		: blockstate1.setValue(TYPE, SlabType.TOP);
	}
}