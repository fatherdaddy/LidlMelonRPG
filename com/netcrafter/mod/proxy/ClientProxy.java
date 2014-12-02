package com.netcrafter.mod.proxy;

import com.netcrafter.mod.entity.boss.EntityGayArazhul;
import com.netcrafter.mod.entity.boss.EntityPumpkinMutant;
import com.netcrafter.mod.entity.boss.EntityTrollFace;
import com.netcrafter.mod.entity.monster.EntityGriefer;
import com.netcrafter.mod.entity.monster.EntityPumpkinMonster;
import com.netcrafter.mod.model.ModelGayArazhul;
import com.netcrafter.mod.model.ModelGriefer;
import com.netcrafter.mod.model.ModelPumpkinMonster;
import com.netcrafter.mod.model.ModelPumpkinMutant;
import com.netcrafter.mod.model.ModelTrollFace;
import com.netcrafter.mod.renderer.RenderGayArazhul;
import com.netcrafter.mod.renderer.RenderGriefer;
import com.netcrafter.mod.renderer.RenderPumpkinMonster;
import com.netcrafter.mod.renderer.RenderPumpkinMutant;
import com.netcrafter.mod.renderer.RenderTrollFace;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerRenderThings() {
		
		//TileEntities
	    //nothing
	
		//Monsters
		RenderingRegistry.registerEntityRenderingHandler(EntityPumpkinMonster.class, new RenderPumpkinMonster(new ModelPumpkinMonster(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGriefer.class, new RenderGriefer(new ModelGriefer(), 0.3F));
		
		//Bosses
		RenderingRegistry.registerEntityRenderingHandler(EntityPumpkinMutant.class, new RenderPumpkinMutant(new ModelPumpkinMutant(), 0.4F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGayArazhul.class, new RenderGayArazhul(new ModelGayArazhul(), 0.4F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTrollFace.class, new RenderTrollFace(new ModelTrollFace(), 0.4F));
		
	}

}
