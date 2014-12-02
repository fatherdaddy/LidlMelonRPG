package com.netcrafter.mod.weapons;

import com.netcrafter.mod.LidlMelonRPG;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;

public class Weapons extends ItemSword {

	public Weapons(ToolMaterial material) {
		super(material);
		this.setCreativeTab(LidlMelonRPG.rpgWeaponsTab);
		
		}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("netcrafter:" + this.getUnlocalizedName().substring(5));
	}
}
