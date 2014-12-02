package com.netcrafter.mod.armor;

import com.netcrafter.mod.LidlMelonRPG;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class GayArmor extends ItemArmor {

	public GayArmor(ArmorMaterial material, int id, int slot) {
		super(material, id, slot);
		this.setCreativeTab(LidlMelonRPG.rpgArmorsTab);
		
		if(slot == 0) {
			this.setTextureName("netcrafter:GayHelm");
		}else if (slot == 1){
			this.setTextureName("netcrafter:GayChest");
			
		}else if (slot == 2){
			this.setTextureName("netcrafter:GayLegs");
			
		}else if (slot == 3){
			this.setTextureName("netcrafter:GayBoots");
	    
	    }
	    
	}
	    
	    public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
	    	if(itemstack.getItem() == LidlMelonRPG.gayHelm || itemstack.getItem() == LidlMelonRPG.gayChest || itemstack.getItem() == LidlMelonRPG.gayBoots) {
	    			return "netcrafter:textures/model/armor/gayarazhul_armor_layer1.png";	    
	    }else if(itemstack.getItem() == LidlMelonRPG.gayLegs) {
	    			return "netcrafter:textures/model/armor/gayarazhul_armor_layer2.png";
	    }else{
	    	return null;
	    			
	    }
	    
	}
}
