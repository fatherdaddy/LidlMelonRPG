package com.netcrafter.mod.melonland.biome;

import com.netcrafter.mod.LidlMelonRPG;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenMelonLand extends BiomeGenBase {
	
	  public BiomeGenMelonLand(int par1)
	  {
	    super(par1);
	    this.temperature = 0.1F;
	    this.fillerBlock = LidlMelonRPG.blockMelonShard;
	    this.topBlock = LidlMelonRPG.blockMelonShard;
	    this.rainfall = 0;
	  }
	  
	@Override
	public int getWaterColorMultiplier() {
		return 0;
	}
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return 0;
	}
}
