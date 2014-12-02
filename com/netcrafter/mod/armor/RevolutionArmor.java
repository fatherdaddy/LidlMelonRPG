package com.netcrafter.mod.armor;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.netcrafter.mod.LidlMelonRPG;

public class RevolutionArmor extends ItemArmor {

	public RevolutionArmor(ArmorMaterial material, int id, int slot) {
		super(material, id, slot);
		this.setCreativeTab(LidlMelonRPG.rpgArmorsTab);
		
		if(slot == 0) {
			this.setTextureName("netcrafter:RevolutionHelm");
		}else if (slot == 1){
			this.setTextureName("netcrafter:RevolutionChest");
			
		}else if (slot == 2){
			this.setTextureName("netcrafter:RevolutionLegs");
			
		}else if (slot == 3){
			this.setTextureName("netcrafter:RevolutionBoots");
	    
	    }
	    
	}
	    
	    public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
	    	if(itemstack.getItem() == LidlMelonRPG.revolutionHelm || itemstack.getItem() == LidlMelonRPG.revolutionChest || itemstack.getItem() == LidlMelonRPG.revolutionBoots) {
	    			return "netcrafter:textures/model/armor/revolution_armor_layer1.png";	    
	    }else if(itemstack.getItem() == LidlMelonRPG.revolutionLegs) {
	    			return "netcrafter:textures/model/armor/revolution_armor_layer2.png";
	    }else{
	    	return null;
	    			
	    }
	    
	}
	    
	    public void onCreated(ItemStack itemstack, World world, EntityPlayer entityplayer) {
	    	itemstack.addEnchantment(Enchantment.fireProtection, 3);
	    }

}
