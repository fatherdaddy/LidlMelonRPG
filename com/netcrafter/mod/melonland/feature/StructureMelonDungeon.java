package com.netcrafter.mod.melonland.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class StructureMelonDungeon extends WorldGenerator
{
	protected Block[] GetValidSpawnBlocks()
	{
		return new Block[]
		{
			Blocks.grass,
			Blocks.dirt,
			Blocks.stone,
		};
	}

	public boolean LocationIsValidSpawn(World world, int x, int y, int z)
	{
		int distanceToAir = 0;
		Block checkBlock = world.getBlock(x, y, z);

		while (checkBlock != Blocks.air)
		{
			distanceToAir++;
			checkBlock = world.getBlock(x, y + distanceToAir, z);
		}

		if (distanceToAir > 1)
		{
			return false;
		}

		y += distanceToAir - 1;

		Block block = world.getBlock(x, y, z);
		Block blockAbove = world.getBlock(x, y + 1, z);
		Block blockBelow = world.getBlock(x, y - 1, z);

		for (Block i : GetValidSpawnBlocks())
		{
			if (blockAbove != Blocks.air)
			{
				return false;
			}
			if (block == i)
			{
				return true;
			}
			else if (block == Blocks.snow_layer && blockBelow == i) {
				return true;
			}
			else if (block.getMaterial() == Material.plants && blockBelow == i)
			{
				return true;
			}
		}
		return false;
	}

	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		if(!LocationIsValidSpawn(world, x, y, z) || !LocationIsValidSpawn(world, x + 6, y, z) || !LocationIsValidSpawn(world, x + 6, y, z + 6) || !LocationIsValidSpawn(world, x, y, z + 6))
		{
			return false;
		}

		world.setBlock(x + 0, y + 0, z + 0, Blocks.pumpkin, 3, 3);
		world.setBlock(x + 1, y + 0, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 0, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 0, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 0, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 0, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 0, z + 0, Blocks.pumpkin, 2, 3);
		world.setBlock(x + 0, y + 0, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 0, z + 1, Blocks.melon_block, 0, 3);
		world.setBlock(x + 2, y + 0, z + 1, Blocks.melon_block, 0, 3);
		world.setBlock(x + 3, y + 0, z + 1, Blocks.pumpkin, 2, 3);
		world.setBlock(x + 4, y + 0, z + 1, Blocks.melon_block, 0, 3);
		world.setBlock(x + 5, y + 0, z + 1, Blocks.melon_block, 0, 3);
		world.setBlock(x + 6, y + 0, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 0, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 0, z + 2, Blocks.melon_block, 0, 3);
		world.setBlock(x + 2, y + 0, z + 2, Blocks.diamond_ore, 0, 3);
		world.setBlock(x + 3, y + 0, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 0, z + 2, Blocks.diamond_ore, 0, 3);
		world.setBlock(x + 5, y + 0, z + 2, Blocks.melon_block, 0, 3);
		world.setBlock(x + 6, y + 0, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 0, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 0, z + 3, Blocks.melon_block, 0, 3);
		world.setBlock(x + 2, y + 0, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 0, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 0, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 0, z + 3, Blocks.melon_block, 0, 3);
		world.setBlock(x + 6, y + 0, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 0, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 0, z + 4, Blocks.melon_block, 0, 3);
		world.setBlock(x + 2, y + 0, z + 4, Blocks.diamond_ore, 0, 3);
		world.setBlock(x + 3, y + 0, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 0, z + 4, Blocks.diamond_ore, 0, 3);
		world.setBlock(x + 5, y + 0, z + 4, Blocks.melon_block, 0, 3);
		world.setBlock(x + 6, y + 0, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 0, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 0, z + 5, Blocks.melon_block, 0, 3);
		world.setBlock(x + 2, y + 0, z + 5, Blocks.melon_block, 0, 3);
		world.setBlock(x + 3, y + 0, z + 5, Blocks.melon_block, 0, 3);
		world.setBlock(x + 4, y + 0, z + 5, Blocks.melon_block, 0, 3);
		world.setBlock(x + 5, y + 0, z + 5, Blocks.melon_block, 0, 3);
		world.setBlock(x + 6, y + 0, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 0, z + 6, Blocks.pumpkin, 2, 3);
		world.setBlock(x + 1, y + 0, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 0, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 0, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 0, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 0, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 0, z + 6, Blocks.pumpkin, 3, 3);
		world.setBlock(x + 0, y + 1, z + 0, Blocks.pumpkin, 3, 3);
		world.setBlock(x + 1, y + 1, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 1, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 1, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 1, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 1, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 1, z + 0, Blocks.pumpkin, 2, 3);
		world.setBlock(x + 0, y + 1, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 1, z + 1, Blocks.melon_block, 0, 3);
		world.setBlock(x + 2, y + 1, z + 1, Blocks.melon_block, 0, 3);
		world.setBlock(x + 3, y + 1, z + 1, Blocks.pumpkin, 2, 3);
		world.setBlock(x + 4, y + 1, z + 1, Blocks.melon_block, 0, 3);
		world.setBlock(x + 5, y + 1, z + 1, Blocks.melon_block, 0, 3);
		world.setBlock(x + 6, y + 1, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 1, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 1, z + 2, Blocks.melon_block, 0, 3);
		world.setBlock(x + 2, y + 1, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 1, z + 2, Blocks.diamond_ore, 0, 3);
		world.setBlock(x + 4, y + 1, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 1, z + 2, Blocks.melon_block, 0, 3);
		world.setBlock(x + 6, y + 1, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 1, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 1, z + 3, Blocks.melon_block, 0, 3);
		world.setBlock(x + 2, y + 1, z + 3, Blocks.diamond_ore, 0, 3);
		world.setBlock(x + 3, y + 1, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 1, z + 3, Blocks.diamond_ore, 0, 3);
		world.setBlock(x + 5, y + 1, z + 3, Blocks.melon_block, 0, 3);
		world.setBlock(x + 6, y + 1, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 1, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 1, z + 4, Blocks.melon_block, 0, 3);
		world.setBlock(x + 2, y + 1, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 1, z + 4, Blocks.diamond_ore, 0, 3);
		world.setBlock(x + 4, y + 1, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 1, z + 4, Blocks.melon_block, 0, 3);
		world.setBlock(x + 6, y + 1, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 1, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 1, z + 5, Blocks.melon_block, 0, 3);
		world.setBlock(x + 2, y + 1, z + 5, Blocks.melon_block, 0, 3);
		world.setBlock(x + 3, y + 1, z + 5, Blocks.melon_block, 0, 3);
		world.setBlock(x + 4, y + 1, z + 5, Blocks.melon_block, 0, 3);
		world.setBlock(x + 5, y + 1, z + 5, Blocks.melon_block, 0, 3);
		world.setBlock(x + 6, y + 1, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 1, z + 6, Blocks.pumpkin, 2, 3);
		world.setBlock(x + 1, y + 1, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 1, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 1, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 1, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 1, z + 6, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 1, z + 6, Blocks.pumpkin, 3, 3);
		world.setBlock(x + 0, y + 2, z + 0, Blocks.pumpkin, 3, 3);
		world.setBlock(x + 1, y + 2, z + 0, Blocks.log2, 4, 3);
		world.setBlock(x + 2, y + 2, z + 0, Blocks.log2, 4, 3);
		world.setBlock(x + 3, y + 2, z + 0, Blocks.log2, 4, 3);
		world.setBlock(x + 4, y + 2, z + 0, Blocks.log2, 4, 3);
		world.setBlock(x + 5, y + 2, z + 0, Blocks.log2, 4, 3);
		world.setBlock(x + 6, y + 2, z + 0, Blocks.pumpkin, 2, 3);
		world.setBlock(x + 0, y + 2, z + 1, Blocks.log2, 8, 3);
		world.setBlock(x + 1, y + 2, z + 1, Blocks.diamond_ore, 0, 3);
		world.setBlock(x + 2, y + 2, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 2, z + 1, Blocks.diamond_ore, 0, 3);
		world.setBlock(x + 4, y + 2, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 2, z + 1, Blocks.diamond_ore, 0, 3);
		world.setBlock(x + 6, y + 2, z + 1, Blocks.log2, 8, 3);
		world.setBlock(x + 0, y + 2, z + 2, Blocks.log2, 8, 3);
		world.setBlock(x + 1, y + 2, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 2, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 2, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 2, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 2, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 2, z + 2, Blocks.log2, 8, 3);
		world.setBlock(x + 0, y + 2, z + 3, Blocks.log2, 8, 3);
		world.setBlock(x + 1, y + 2, z + 3, Blocks.diamond_ore, 0, 3);
		world.setBlock(x + 2, y + 2, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 2, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 2, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 2, z + 3, Blocks.diamond_ore, 0, 3);
		world.setBlock(x + 6, y + 2, z + 3, Blocks.log2, 8, 3);
		world.setBlock(x + 0, y + 2, z + 4, Blocks.log2, 8, 3);
		world.setBlock(x + 1, y + 2, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 2, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 2, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 2, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 2, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 2, z + 4, Blocks.log2, 8, 3);
		world.setBlock(x + 0, y + 2, z + 5, Blocks.log2, 8, 3);
		world.setBlock(x + 1, y + 2, z + 5, Blocks.diamond_ore, 0, 3);
		world.setBlock(x + 2, y + 2, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 2, z + 5, Blocks.diamond_ore, 0, 3);
		world.setBlock(x + 4, y + 2, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 2, z + 5, Blocks.diamond_ore, 0, 3);
		world.setBlock(x + 6, y + 2, z + 5, Blocks.log2, 8, 3);
		world.setBlock(x + 0, y + 2, z + 6, Blocks.pumpkin, 2, 3);
		world.setBlock(x + 1, y + 2, z + 6, Blocks.log2, 4, 3);
		world.setBlock(x + 2, y + 2, z + 6, Blocks.log2, 4, 3);
		world.setBlock(x + 3, y + 2, z + 6, Blocks.log2, 4, 3);
		world.setBlock(x + 4, y + 2, z + 6, Blocks.log2, 4, 3);
		world.setBlock(x + 5, y + 2, z + 6, Blocks.log2, 4, 3);
		world.setBlock(x + 6, y + 2, z + 6, Blocks.pumpkin, 3, 3);
		world.setBlock(x + 0, y + 3, z + 0, Blocks.log2, 0, 3);
		world.setBlock(x + 1, y + 3, z + 0, Blocks.pumpkin, 3, 3);
		world.setBlock(x + 2, y + 3, z + 0, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 3, y + 3, z + 0, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 4, y + 3, z + 0, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 5, y + 3, z + 0, Blocks.pumpkin, 0, 3);
		world.setBlock(x + 6, y + 3, z + 0, Blocks.log2, 0, 3);
		world.setBlock(x + 0, y + 3, z + 1, Blocks.pumpkin, 3, 3);
		world.setBlock(x + 1, y + 3, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 3, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 3, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 3, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 3, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 3, z + 1, Blocks.pumpkin, 0, 3);
		world.setBlock(x + 0, y + 3, z + 2, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 1, y + 3, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 3, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 3, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 3, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 3, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 3, z + 2, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 0, y + 3, z + 3, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 1, y + 3, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 3, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 3, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 3, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 3, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 3, z + 3, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 0, y + 3, z + 4, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 1, y + 3, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 3, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 3, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 3, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 3, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 3, z + 4, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 0, y + 3, z + 5, Blocks.pumpkin, 3, 3);
		world.setBlock(x + 1, y + 3, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 3, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 3, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 3, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 3, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 3, z + 5, Blocks.pumpkin, 1, 3);
		world.setBlock(x + 0, y + 3, z + 6, Blocks.log2, 0, 3);
		world.setBlock(x + 1, y + 3, z + 6, Blocks.pumpkin, 2, 3);
		world.setBlock(x + 2, y + 3, z + 6, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 3, y + 3, z + 6, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 4, y + 3, z + 6, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 5, y + 3, z + 6, Blocks.pumpkin, 2, 3);
		world.setBlock(x + 6, y + 3, z + 6, Blocks.log2, 0, 3);
		world.setBlock(x + 0, y + 4, z + 0, Blocks.log2, 0, 3);
		world.setBlock(x + 1, y + 4, z + 0, Blocks.pumpkin, 3, 3);
		world.setBlock(x + 2, y + 4, z + 0, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 3, y + 4, z + 0, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 4, y + 4, z + 0, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 5, y + 4, z + 0, Blocks.pumpkin, 0, 3);
		world.setBlock(x + 6, y + 4, z + 0, Blocks.log2, 0, 3);
		world.setBlock(x + 0, y + 4, z + 1, Blocks.pumpkin, 3, 3);
		world.setBlock(x + 1, y + 4, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 4, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 4, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 4, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 4, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 4, z + 1, Blocks.pumpkin, 1, 3);
		world.setBlock(x + 0, y + 4, z + 2, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 1, y + 4, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 4, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 4, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 4, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 4, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 4, z + 2, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 0, y + 4, z + 3, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 1, y + 4, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 4, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 4, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 4, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 4, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 4, z + 3, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 0, y + 4, z + 4, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 1, y + 4, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 4, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 4, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 4, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 4, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 4, z + 4, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 0, y + 4, z + 5, Blocks.pumpkin, 3, 3);
		world.setBlock(x + 1, y + 4, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 4, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 4, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 4, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 4, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 4, z + 5, Blocks.pumpkin, 1, 3);
		world.setBlock(x + 0, y + 4, z + 6, Blocks.log2, 0, 3);
		world.setBlock(x + 1, y + 4, z + 6, Blocks.pumpkin, 2, 3);
		world.setBlock(x + 2, y + 4, z + 6, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 3, y + 4, z + 6, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 4, y + 4, z + 6, Blocks.stained_glass, 1, 3);
		world.setBlock(x + 5, y + 4, z + 6, Blocks.pumpkin, 1, 3);
		world.setBlock(x + 6, y + 4, z + 6, Blocks.log2, 0, 3);
		world.setBlock(x + 0, y + 5, z + 0, Blocks.log2, 0, 3);
		world.setBlock(x + 1, y + 5, z + 0, Blocks.pumpkin, 3, 3);
		world.setBlock(x + 2, y + 5, z + 0, Blocks.melon_block, 0, 3);
		world.setBlock(x + 3, y + 5, z + 0, Blocks.melon_block, 0, 3);
		world.setBlock(x + 4, y + 5, z + 0, Blocks.melon_block, 0, 3);
		world.setBlock(x + 5, y + 5, z + 0, Blocks.pumpkin, 0, 3);
		world.setBlock(x + 6, y + 5, z + 0, Blocks.log2, 0, 3);
		world.setBlock(x + 0, y + 5, z + 1, Blocks.pumpkin, 3, 3);
		world.setBlock(x + 1, y + 5, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 5, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 5, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 5, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 5, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 5, z + 1, Blocks.pumpkin, 0, 3);
		world.setBlock(x + 0, y + 5, z + 2, Blocks.melon_block, 0, 3);
		world.setBlock(x + 1, y + 5, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 5, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 5, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 5, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 5, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 5, z + 2, Blocks.melon_block, 0, 3);
		world.setBlock(x + 0, y + 5, z + 3, Blocks.melon_block, 0, 3);
		world.setBlock(x + 1, y + 5, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 5, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 5, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 5, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 5, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 5, z + 3, Blocks.melon_block, 0, 3);
		world.setBlock(x + 0, y + 5, z + 4, Blocks.melon_block, 0, 3);
		world.setBlock(x + 1, y + 5, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 5, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 5, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 5, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 5, z + 4, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 5, z + 4, Blocks.melon_block, 0, 3);
		world.setBlock(x + 0, y + 5, z + 5, Blocks.pumpkin, 3, 3);
		world.setBlock(x + 1, y + 5, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 5, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 5, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 5, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 5, y + 5, z + 5, Blocks.air, 0, 3);
		world.setBlock(x + 6, y + 5, z + 5, Blocks.pumpkin, 1, 3);
		world.setBlock(x + 0, y + 5, z + 6, Blocks.log2, 0, 3);
		world.setBlock(x + 1, y + 5, z + 6, Blocks.pumpkin, 2, 3);
		world.setBlock(x + 2, y + 5, z + 6, Blocks.melon_block, 0, 3);
		world.setBlock(x + 3, y + 5, z + 6, Blocks.melon_block, 0, 3);
		world.setBlock(x + 4, y + 5, z + 6, Blocks.melon_block, 0, 3);
		world.setBlock(x + 5, y + 5, z + 6, Blocks.melon_block, 0, 3);
		world.setBlock(x + 6, y + 5, z + 6, Blocks.log2, 0, 3);
		world.setBlock(x + 0, y + 6, z + 0, Blocks.log2, 0, 3);
		world.setBlock(x + 1, y + 6, z + 0, Blocks.log2, 4, 3);
		world.setBlock(x + 2, y + 6, z + 0, Blocks.log2, 4, 3);
		world.setBlock(x + 3, y + 6, z + 0, Blocks.log2, 4, 3);
		world.setBlock(x + 4, y + 6, z + 0, Blocks.log2, 4, 3);
		world.setBlock(x + 5, y + 6, z + 0, Blocks.log2, 4, 3);
		world.setBlock(x + 6, y + 6, z + 0, Blocks.log2, 0, 3);
		world.setBlock(x + 0, y + 6, z + 1, Blocks.log2, 8, 3);
		world.setBlock(x + 1, y + 6, z + 1, Blocks.lapis_block, 0, 3);
		world.setBlock(x + 2, y + 6, z + 1, Blocks.lapis_block, 0, 3);
		world.setBlock(x + 3, y + 6, z + 1, Blocks.lapis_block, 0, 3);
		world.setBlock(x + 4, y + 6, z + 1, Blocks.lapis_block, 0, 3);
		world.setBlock(x + 5, y + 6, z + 1, Blocks.lapis_block, 0, 3);
		world.setBlock(x + 6, y + 6, z + 1, Blocks.log2, 8, 3);
		world.setBlock(x + 0, y + 6, z + 2, Blocks.log2, 8, 3);
		world.setBlock(x + 1, y + 6, z + 2, Blocks.lapis_block, 0, 3);
		world.setBlock(x + 2, y + 6, z + 2, Blocks.iron_ore, 0, 3);
		world.setBlock(x + 3, y + 6, z + 2, Blocks.iron_ore, 0, 3);
		world.setBlock(x + 4, y + 6, z + 2, Blocks.iron_ore, 0, 3);
		world.setBlock(x + 5, y + 6, z + 2, Blocks.lapis_block, 0, 3);
		world.setBlock(x + 6, y + 6, z + 2, Blocks.log2, 8, 3);
		world.setBlock(x + 0, y + 6, z + 3, Blocks.log2, 8, 3);
		world.setBlock(x + 1, y + 6, z + 3, Blocks.lapis_block, 0, 3);
		world.setBlock(x + 2, y + 6, z + 3, Blocks.iron_ore, 0, 3);
		world.setBlock(x + 3, y + 6, z + 3, Blocks.diamond_ore, 0, 3);
		world.setBlock(x + 4, y + 6, z + 3, Blocks.iron_ore, 0, 3);
		world.setBlock(x + 5, y + 6, z + 3, Blocks.lapis_block, 0, 3);
		world.setBlock(x + 6, y + 6, z + 3, Blocks.log2, 8, 3);
		world.setBlock(x + 0, y + 6, z + 4, Blocks.log2, 8, 3);
		world.setBlock(x + 1, y + 6, z + 4, Blocks.lapis_block, 0, 3);
		world.setBlock(x + 2, y + 6, z + 4, Blocks.iron_ore, 0, 3);
		world.setBlock(x + 3, y + 6, z + 4, Blocks.iron_ore, 0, 3);
		world.setBlock(x + 4, y + 6, z + 4, Blocks.iron_ore, 0, 3);
		world.setBlock(x + 5, y + 6, z + 4, Blocks.lapis_block, 0, 3);
		world.setBlock(x + 6, y + 6, z + 4, Blocks.log2, 8, 3);
		world.setBlock(x + 0, y + 6, z + 5, Blocks.log2, 8, 3);
		world.setBlock(x + 1, y + 6, z + 5, Blocks.lapis_block, 0, 3);
		world.setBlock(x + 2, y + 6, z + 5, Blocks.lapis_block, 0, 3);
		world.setBlock(x + 3, y + 6, z + 5, Blocks.lapis_block, 0, 3);
		world.setBlock(x + 4, y + 6, z + 5, Blocks.lapis_block, 0, 3);
		world.setBlock(x + 5, y + 6, z + 5, Blocks.lapis_block, 0, 3);
		world.setBlock(x + 6, y + 6, z + 5, Blocks.log2, 8, 3);
		world.setBlock(x + 0, y + 6, z + 6, Blocks.log2, 0, 3);
		world.setBlock(x + 1, y + 6, z + 6, Blocks.log2, 4, 3);
		world.setBlock(x + 2, y + 6, z + 6, Blocks.log2, 4, 3);
		world.setBlock(x + 3, y + 6, z + 6, Blocks.log2, 4, 3);
		world.setBlock(x + 4, y + 6, z + 6, Blocks.log2, 4, 3);
		world.setBlock(x + 5, y + 6, z + 6, Blocks.log2, 4, 3);
		world.setBlock(x + 6, y + 6, z + 6, Blocks.log2, 0, 3);
		return true;

	}
}
