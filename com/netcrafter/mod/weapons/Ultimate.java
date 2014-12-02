package com.netcrafter.mod.weapons;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.netcrafter.mod.LidlMelonRPG;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Ultimate extends ItemSword {
	
	public Ultimate(ToolMaterial material) {
		super(material);
		this.setCreativeTab(LidlMelonRPG.rpgWeaponsTab);
		
	}
	
	public void onCreated(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		itemstack.addEnchantment(Enchantment.fireAspect, 3);
		itemstack.addEnchantment(Enchantment.sharpness, 6);
		itemstack.addEnchantment(Enchantment.looting, 8);
		itemstack.addEnchantment(Enchantment.smite, 8);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
	  super.onUpdate(stack, world, entity, par4, par5);
	  EntityPlayer player = (EntityPlayer) entity;
	  ItemStack equipped = player.getCurrentEquippedItem();
	  if(equipped != null && equipped == stack) {
	      player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 500, 4));
	      player.addPotionEffect(new PotionEffect(Potion.jump.id, 500, 4));
	      player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 500, 4));
	      player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 500, 4));
	      player.addPotionEffect(new PotionEffect(Potion.resistance.id, 500, 4));
	      player.addPotionEffect(new PotionEffect(Potion.heal.id, 500, 4));
	  }
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackingEntity) {
	    hitEntity.addPotionEffect(new PotionEffect(Potion.poison.id, 500, 4));
	    hitEntity.addPotionEffect(new PotionEffect(Potion.weakness.id, 500, 4));
	    hitEntity.addPotionEffect(new PotionEffect(Potion.wither.id, 500, 4));
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("netcrafter:" + this.getUnlocalizedName().substring(5));
	}

}
