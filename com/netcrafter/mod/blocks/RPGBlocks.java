package com.netcrafter.mod.blocks;

import java.util.Random;

import com.netcrafter.mod.LidlMelonRPG;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class RPGBlocks extends Block {
	
	public RPGBlocks(Material material) {
		super(material);
		
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeSnow);
		this.setCreativeTab(LidlMelonRPG.rpgMaterialTab);
	}
	
	public Item getItemDropped(int i, Random random, int j) {
		return this == LidlMelonRPG.blockMelonShard ? LidlMelonRPG.itemMelonShard : Item.getItemFromBlock(this);
	}
	
	public int quantityDropped(Random random) {
		return this == LidlMelonRPG.blockMelonShard ? 4 + random.nextInt(5) : 1;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon("netcrafter:" + this.getUnlocalizedName().substring(5));
	}

}
