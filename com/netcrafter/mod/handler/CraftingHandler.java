package com.netcrafter.mod.handler;

import com.netcrafter.mod.LidlMelonRPG;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftingHandler {
	
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event) {
		
		final IInventory craftMatrix = null;
		for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
			
		    if(event.craftMatrix.getStackInSlot(i) != null) {
		    	
		    	ItemStack item0 = event.craftMatrix.getStackInSlot(i);
		    	    if(item0 != null && item0.getItem() == LidlMelonRPG.itemNGPKnife) {
		    	    ItemStack k = new ItemStack(LidlMelonRPG.itemNGPKnife, 2, (item0.getItemDamage() + 1));
		    	    
		    	    if(k.getItemDamage() >= k.getMaxDamage()) {
		    	       k.stackSize--;
		    	    
		    	    }
		    	    
		    	    event.craftMatrix.setInventorySlotContents(i, k);
		    	    
    }}}}}
