package com.tntmodders.tutorial;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

//登録したレジスター名はblockstateの描画の方で使用する。基本的にモデル名と一緒にしておくと良い。
public class BlockAluminium extends Block {
    public BlockAluminium() {
        super(Material.IRON);
        this.setRegistryName("aluminiummod","aluminium_block");
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setUnlocalizedName("aluminium_block");
    }
}