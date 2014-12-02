package com.netcrafter.mod.weapons;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.netcrafter.mod.LidlMelonRPG;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Revolution extends ItemSword {

	public Revolution(ToolMaterial material) {
		super(material);
		this.setCreativeTab(LidlMelonRPG.rpgWeaponsTab);

	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackingEntity) {
	    hitEntity.addPotionEffect(new PotionEffect(Potion.poison.id, 500, 4));
	    hitEntity.addPotionEffect(new PotionEffect(Potion.weakness.id, 500, 4));
	    hitEntity.addPotionEffect(new PotionEffect(Potion.wither.id, 500, 4));
		return true;
	}
	
	public void onCreated(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if(itemstack.getItem() == LidlMelonRPG.itemRevolution) {
			itemstack.addEnchantment(Enchantment.fireAspect, 5);
		}else if (itemstack.getItem() == LidlMelonRPG.itemPreGeneration) {
			itemstack.addEnchantment(Enchantment.sharpness, 5);
			itemstack.addEnchantment(Enchantment.fireAspect, 5);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("netcrafter:" + this.getUnlocalizedName().substring(5));
	}
	

}
