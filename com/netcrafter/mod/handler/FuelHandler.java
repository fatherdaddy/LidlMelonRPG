package com.netcrafter.mod.handler;

import com.netcrafter.mod.LidlMelonRPG;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		
		if(fuel.getItem() == LidlMelonRPG.itemChaosNugget) return 8000;
		
		return 0;
	}

}
