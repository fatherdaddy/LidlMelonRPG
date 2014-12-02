package com.netcrafter.mod.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.netcrafter.mod.*;
import com.netcrafter.mod.melonland.biome.BiomeGenMelonLand;
import com.netcrafter.mod.melonland.feature.StructureMelonDungeon;
import com.netcrafter.mod.melonland.feature.StructurePumpkinDungeon;
import com.netcrafter.mod.world.biome.BiomeGenVioletFields;
import com.netcrafter.mod.world.biome.RPGBiomes;

import cpw.mods.fml.common.IWorldGenerator;

public class RPGWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		
		case 0 :
			//Generates our surface world
			generateSurface(world, random, chunkX*16, chunkZ*16);
			
		case -1 :
			//Generates our surface world
			generateNether(world, random, chunkX*16, chunkZ*16);
			
		case 1 :
			//Generates our surface world
			generateEnd(world, random, chunkX*16, chunkZ*16);
			
		case 2 :
			//Generates the melon land
			generateMelonLand(world, random, chunkX*16, chunkZ*16);
		}
		
	}

	private void generateMelonLand(World world, Random random, int x, int z) {
		//this.addOreSpawn(Nealecraft.oreWhatever, world, random, i=blockXPos, j= blockZPos, maxX, maxZ, maxVeinSize, chancetospawn, minY, maxY); 
		
		this.addOreSpawn(LidlMelonRPG.blockLucky, world, random, x, z, 16, 16, 4 + random.nextInt(6), 25, 38, 100);
		
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);
		
		if((biome instanceof BiomeGenMelonLand)) 
		{
			for(int a = 0; a < 8; a++)
			{
				int i = x + random.nextInt(16);
				int k = z + random.nextInt(16);
				int j = world.getHeightValue(i, k);
			}
		
		if((biome instanceof BiomeGenVioletFields)) 
		{
			for(int a = 0; a < 8; a++)
			{
				int i = x + random.nextInt(16);
				int k = z + random.nextInt(16);
				int j = world.getHeightValue(i, k);
				}
			
		if((biome == RPGBiomes.biomeVioletFields)) {
			for(int a = 0; a < 1; a++) {
				int i = x + random.nextInt(1024);
				int k = z + random.nextInt(1024);
				int j = world.getHeightValue(i, k);
				new StructurePumpkinDungeon().generate(world, random, i, j, k);
			}
				
}}}}

	private void generateSurface(World world, Random random, int x, int z) {
		//this.addOreSpawn(Nealecraft.oreWhatever, world, random, i=blockXPos, j= blockZPos, maxX, maxZ, maxVeinSize, chancetospawn, minY, maxY); 
		
		this.addOreSpawn(LidlMelonRPG.blockLucky, world, random, x, z, 16, 16, 4 + random.nextInt(6), 25, 38, 100);
		
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);
		
		if((biome == RPGBiomes.biomeVioletFields)) {
			for (int a = 0; a < 1; a++) {
				 int i = x + random.nextInt(256);
				 int k = z + random.nextInt(256);
				 int j = world.getHeightValue(i, k);
				 new StructureMelonDungeon().generate(world, random, i, j, k);
				
			}
		}
	}

	private void generateNether(World world, Random random, int x, int z) {
		// TODO Auto-generated method stub
		
	}
	
	private void generateEnd(World world, Random random, int x, int z) {
		// TODO Auto-generated method stub
		
	}

	private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
		for(int i = 0; i < chanceToSpawn; i++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block, maxVeinSize, Blocks.stone)).generate(world, random, posX, posY, posZ);
		}
	}	
}
