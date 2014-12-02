package com.netcrafter.mod.items;

import com.netcrafter.mod.LidlMelonRPG;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class RPGItems extends Item {
	
	public RPGItems() {
		this.setCreativeTab(LidlMelonRPG.rpgMaterialTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("netcrafter:" + this.getUnlocalizedName().substring(5));
	}
}
