package com.netcrafter.mod.renderer;

import com.netcrafter.mod.entity.monster.EntityPumpkinMonster;
import com.netcrafter.mod.model.ModelPumpkinMonster;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderPumpkinMonster extends RenderLiving {
	
	public static final ResourceLocation texture = new ResourceLocation("netcrafter:textures/model/PumpkinMonster.png");

	protected ModelPumpkinMonster modelEntity;
	
	public RenderPumpkinMonster(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		
		modelEntity = ((ModelPumpkinMonster) mainModel);
		
	}
	
	public void renderPumpkinMonster(EntityPumpkinMonster entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderPumpkinMonster((EntityPumpkinMonster)entityLiving, x, y, z, u, v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderPumpkinMonster((EntityPumpkinMonster)entity, x, y, z, u, v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}

}
