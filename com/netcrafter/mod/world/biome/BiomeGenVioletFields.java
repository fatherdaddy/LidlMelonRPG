package com.netcrafter.mod.world.biome;

import com.netcrafter.mod.LidlMelonRPG;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenVioletFields extends BiomeGenBase {

	private static final Height biomeHeight = new Height(0.1F, 0.2F);
	
	public BiomeGenVioletFields(int id) {
		super(id);
		
		this.setHeight(biomeHeight);
		this.setColor(11081945);
		this.topBlock = Blocks.grass;
		this.fillerBlock = LidlMelonRPG.melonActivator;
		this.setTemperatureRainfall(0.5F, 1.0F);
		this.waterColorMultiplier = 1099232;
	}
	
	@Override
	public int getBiomeGrassColor(int x, int y, int z) {
		return 15433694;
	}
	
	@Override
	public int getWaterColorMultiplier() {
		return 15433694;
	}
	
	@Override
	public int getBiomeFoliageColor(int x, int y, int z) {
		return 15433694;
	}
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return 0;
	}

}
