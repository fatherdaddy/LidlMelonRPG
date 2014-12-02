package com.netcrafter.mod.items;

import com.netcrafter.mod.LidlMelonRPG;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class RPGFood extends ItemFood {

	public RPGFood(int heal, float saturation, boolean wolfmeat) {
		super(heal, saturation, wolfmeat);
		
		this.setCreativeTab(LidlMelonRPG.rpgMaterialTab);
		
		this.setPotionEffect(10, 60, 1, 1F);
		this.setPotionEffect(3, 60, 1, 1F);
		this.setPotionEffect(8, 60, 1, 1F);
		this.setPotionEffect(21, 60, 1, 1F);
		this.setPotionEffect(Potion.digSpeed.id, 60, 1, 1F);
		this.setPotionEffect(Potion.nightVision.id, 60, 1, 1F);

	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("netcrafter:" + this.getUnlocalizedName().substring(5));
	}

}
