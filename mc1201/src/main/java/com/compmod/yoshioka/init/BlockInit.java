package com.compmod.yoshioka.init;

import com.compmod.yoshioka.CompMod;
import com.compmod.yoshioka.objects.SlabBlockVT;
import com.compmod.yoshioka.objects.SlabBlockX2;
import com.compmod.yoshioka.objects.SlabBlockX2c;

import net.minecraft.world.level.block.Block;
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

//**柱
	//深層岩
	public static final RegistryObject<Block> DeepslatePillar = BLOCKS.register("deepslate_pillar", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.4F, 2.0F).sound(SoundType.STONE)));

//**ハーフx2ブロック
	//深層岩
	public static final RegistryObject<Block> DeepslateHalfx2 = BLOCKS.register("deepslate_halfx2", () -> new SlabBlockX2(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.4F, 2.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DeepslateHalfx2c = BLOCKS.register("deepslate_halfx2c", () -> new SlabBlockX2c(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.4F, 2.0F).sound(SoundType.STONE)));

//**縦ハーフブロック
	//深層岩
	public static final RegistryObject<Block> DeepslateHalfvt = BLOCKS.register("deepslate_halfvt", () -> new SlabBlockVT(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.4F, 2.0F).sound(SoundType.STONE)));
}
