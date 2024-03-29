package com.tntmodders.tutorial;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = "aluminiummod", version = "1.0", name = "AluminiumMod")
public class AluminiumMod {

	//インスタンス生成
    public static final Item ALUMINIUM = new ItemAluminium();
    public static final Block ALUMINIUM_BLOCK = new BlockAluminium();

    @Mod.EventHandler
    //この関数でMODファイル自体をイベントの発火先にする。
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    //アイテムを登録するイベント。 旧preinitのタイミングで発火する。
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(ALUMINIUM);
        event.getRegistry().register(new ItemBlock(ALUMINIUM_BLOCK).setRegistryName("aluminiummod", "aluminium_block"));
    }

    //ブロックを登録するイベント。 旧preinitのタイミングで発火する。
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(ALUMINIUM_BLOCK);
    }

    //モデルを登録するイベント。SideOnlyによってクライアント側のみ呼ばれる。旧preinitのタイミングで発火する。
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ALUMINIUM, 0, new ModelResourceLocation(new ResourceLocation("aluminiummod", "aluminium"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ALUMINIUM_BLOCK), 0, new ModelResourceLocation(new ResourceLocation("aluminiummod", "aluminium_block"), "inventory"));
    }
}