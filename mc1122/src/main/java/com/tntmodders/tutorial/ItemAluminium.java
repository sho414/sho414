package com.tntmodders.tutorial;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemAluminium extends Item {

    public ItemAluminium() {
        super();

        this.setRegistryName("aluminiummod", "aluminium");

        this.setCreativeTab(CreativeTabs.MATERIALS);

        this.setUnlocalizedName("aluminium");
    }
}