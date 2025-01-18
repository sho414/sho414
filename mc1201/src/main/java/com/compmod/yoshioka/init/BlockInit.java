package com.compmod.yoshioka.init;

import com.compmod.yoshioka.CompMod;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class BlockInit
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,CompMod.MOD_ID);

	//深層岩の柱
	public static final RegistryObject<Block> DeepslatePillar = BLOCKS.register("deepslate_pillar", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.4F, 2.0F).sound(SoundType.STONE)));

	//深層岩のハーフx2ブロック
	public static final RegistryObject<Block> DeepslateHalfx2 = BLOCKS.register("deepslate_halfx2", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.4F, 2.0F).sound(SoundType.STONE)));

}
