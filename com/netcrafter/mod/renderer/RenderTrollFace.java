package com.netcrafter.mod.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.netcrafter.mod.entity.boss.EntityTrollFace;
import com.netcrafter.mod.model.ModelTrollFace;

public class RenderTrollFace extends RenderLiving {
	
	public static final ResourceLocation texture = new ResourceLocation("netcrafter:textures/model/TrollFace.png");

	protected ModelTrollFace modelEntity;
	
	public RenderTrollFace(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		
		modelEntity = ((ModelTrollFace) mainModel);
		
	}
	
	public void renderTrollFace(EntityTrollFace entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderTrollFace((EntityTrollFace)entityLiving, x, y, z, u, v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderTrollFace((EntityTrollFace)entity, x, y, z, u, v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}

}
