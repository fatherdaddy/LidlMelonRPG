package com.netcrafter.mod.weapons;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import com.netcrafter.mod.LidlMelonRPG;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Generation extends ItemSword {

	public Generation(ToolMaterial material) {
		super(material);
		this.setCreativeTab(LidlMelonRPG.rpgWeaponsTab);
		
	}
	
	public void onCreated(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		itemstack.addEnchantment(Enchantment.fireAspect, 3);
		itemstack.addEnchantment(Enchantment.sharpness, 6);
		itemstack.addEnchantment(Enchantment.looting, 8);
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
    }
}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("netcrafter:" + this.getUnlocalizedName().substring(5));
	}

}
