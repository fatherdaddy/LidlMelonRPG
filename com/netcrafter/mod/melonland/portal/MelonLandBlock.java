package com.netcrafter.mod.melonland.portal;

import com.netcrafter.mod.LidlMelonRPG;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class MelonLandBlock extends Block {

	public MelonLandBlock() {
		super(Material.rock);
		this.setCreativeTab(LidlMelonRPG.rpgMaterialTab);

    }
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon("netcrafter:" + this.getUnlocalizedName().substring(5));
	}
}
