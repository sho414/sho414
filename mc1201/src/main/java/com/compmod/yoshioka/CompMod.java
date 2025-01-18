package com.compmod.yoshioka;

import com.compmod.yoshioka.init.BlockInit;
import com.compmod.yoshioka.init.ItemInit;
import com.compmod.yoshioka.init.TabInit;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("compmod")
@Mod.EventBusSubscriber(modid = CompMod.MOD_ID, bus = Bus.MOD)
public class CompMod
{
	public static final String MOD_ID = "compmod";
	public static CompMod instance; //複数インスタンスの防止

	public CompMod()
	{
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::doClientStuff);

		//リソースの登録
		BlockInit.BLOCKS.register(modEventBus);
		ItemInit.ITEMS.register(modEventBus);
		TabInit.CREATIVE_TABS.register(modEventBus);

		instance = this;
		MinecraftForge.EVENT_BUS.register(this);

	}

	private void setup(final FMLCommonSetupEvent event)
	{
	}

	private void doClientStuff(final FMLClientSetupEvent event)
	{
	}

	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event)
	{
	}

}
