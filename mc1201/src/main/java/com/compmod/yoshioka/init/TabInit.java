package com.compmod.yoshioka.init;

import com.compmod.yoshioka.CompMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TabInit {

	public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CompMod.MOD_ID);

	public static final RegistryObject<CreativeModeTab> YOSHITAB = CREATIVE_TABS.register("yoshioka_tab",
		() -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup." + CompMod.MOD_ID))
			.icon(() -> new ItemStack(BlockInit.DeepslatePillar.get()))
			.displayItems((enabledFeatures, entries) ->
			{
				entries.accept(BlockInit.DeepslatePillar.get());
				entries.accept(BlockInit.DeepslateHalfx2.get());
			}).build());
}
