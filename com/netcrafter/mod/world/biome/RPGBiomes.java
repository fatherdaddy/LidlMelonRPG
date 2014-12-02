package com.netcrafter.mod.world.biome;

import com.netcrafter.mod.melonland.biome.BiomeGenMelonLand;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

public class RPGBiomes {
	
	//Biomes in custom dimensions
	public static BiomeGenBase biomeMelonLand = new BiomeGenMelonLand(61).setBiomeName("Melon Land");
	
	//Biomes in the world
	public static BiomeGenBase biomeVioletFields;
	
	public static void init() {
		registerBiomes();
	}
	
	private static void registerBiomes() {
		
		biomeVioletFields = new BiomeGenVioletFields(60).setBiomeName("Violet Fields");
		BiomeDictionary.registerBiomeType(biomeVioletFields, Type.FOREST);
		BiomeManager.warmBiomes.add(new BiomeEntry(biomeVioletFields, 10));
		BiomeManager.addSpawnBiome(biomeVioletFields);
		
	}

}
