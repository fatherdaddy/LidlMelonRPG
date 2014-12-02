package com.netcrafter.mod.melonland.provider;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderFlat;
import net.minecraft.world.gen.ChunkProviderHell;

import com.netcrafter.mod.LidlMelonRPG;
import com.netcrafter.mod.melonland.chunk.ChunkProviderMelonLand;
import com.netcrafter.mod.world.biome.RPGBiomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderMelonLand extends WorldProvider
{
    /**
     * creates a new world chunk manager for WorldProvider
     */
    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new WorldChunkManagerHell(RPGBiomes.biomeVioletFields, 0.0F);
        this.dimensionId = LidlMelonRPG.dimid;
        this.hasNoSky = true;
    }

    /**
     * Returns a new chunk provider which generates chunks for this world
     */
    public IChunkProvider createChunkGenerator()
    {
        return new ChunkProviderMelonLand(this.worldObj, this.worldObj.getSeed());
    }
    
    @SideOnly(Side.CLIENT)
    public String getWelcomeMessage()
    {
      return "Welcome to the Melon Land, ArazhulHD. Nice to see you again Chaosflo44";
    }

    /**
     * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
     */
    public boolean isSurfaceWorld()
    {
        return false;
    }

    /**
     * Will check if the x, z position specified is alright to be set as the map spawn point
     */
    public boolean canCoordinateBeSpawn(int par1, int par2)
    {
        return false;
    }

    /**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
    public boolean canRespawnHere()
    {
        return false;
    }

    /**
     * Returns the dimension's name, e.g. "The End", "Nether", or "Overworld".
     */
    public String getDimensionName()
    {
        return "Melon Land";
    }
    
    public String getSaveFolder()
    {
        return "MelonLandDim";
    }
}
