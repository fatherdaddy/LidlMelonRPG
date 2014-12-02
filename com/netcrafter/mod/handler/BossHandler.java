package com.netcrafter.mod.handler;

import java.util.Random;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.netcrafter.mod.LidlMelonRPG;

import cpw.mods.fml.common.registry.EntityRegistry;

public class BossHandler {
	
	public static void registerBosses(Class bossClass, String name) {
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = name.hashCode();
		Random random = new Random(x);
		int mainColor = random.nextInt() * 16777216;
		int subColor = random.nextInt() * 16777216;
		
		EntityRegistry.registerGlobalEntityID(bossClass, name, entityId);
		EntityRegistry.addSpawn(bossClass, 50, 2, 4, EnumCreatureType.monster);
//		EntityRegistry.registerModEntity(bossClass, name, entityId, LidlMelonRPG.instance, 64, 1, true);
//		EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, mainColor, subColor));
	} 
}
