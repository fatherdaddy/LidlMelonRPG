package com.netcrafter.mod.melonland.portal;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.World;

import com.netcrafter.mod.LidlMelonRPG;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MelonLandPortalActivator extends Block {

	public MelonLandPortalActivator() {
		super(Material.rock);

	}
	
	public void onBlockAdded(World world, int x, int y, int z) {
		if(world.getBlock(x, y - 1, z) != LidlMelonRPG.blockMelonShard || !MelonLandPortal.func_150000_e(world, x, y, z));
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon("netcrafter:" + this.getUnlocalizedName().substring(5));
	}

}
