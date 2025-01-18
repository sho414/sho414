package com.compmod.yoshioka.init;

import com.compmod.yoshioka.CompMod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CompMod.MOD_ID);

	public static final RegistryObject<Item> DeepslatePillar = ITEMS.register("deepslate_pillar", () -> new BlockItem(BlockInit.DeepslatePillar.get(),new Item.Properties()));
	public static final RegistryObject<Item> DeepslateHalfx2 = ITEMS.register("deepslate_halfx2", () -> new BlockItem(BlockInit.DeepslateHalfx2.get(),new Item.Properties()));
}
