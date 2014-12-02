package com.netcrafter.mod.renderer;

import com.netcrafter.mod.entity.boss.EntityPumpkinMutant;
import com.netcrafter.mod.model.ModelPumpkinMutant;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderPumpkinMutant extends RenderLiving {
	
	public static final ResourceLocation texture = new ResourceLocation("netcrafter:textures/model/PumpkinMutant.png");

	protected ModelPumpkinMutant modelEntity;
	
	public RenderPumpkinMutant(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		
		modelEntity = ((ModelPumpkinMutant) mainModel);
		
	}
	
	public void renderPumpkinMutant(EntityPumpkinMutant entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderPumpkinMutant((EntityPumpkinMutant)entityLiving, x, y, z, u, v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderPumpkinMutant((EntityPumpkinMutant)entity, x, y, z, u, v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}
	
}
