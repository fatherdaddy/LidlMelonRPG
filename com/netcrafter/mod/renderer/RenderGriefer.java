package com.netcrafter.mod.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.netcrafter.mod.entity.monster.EntityGriefer;
import com.netcrafter.mod.entity.monster.EntityPumpkinMonster;
import com.netcrafter.mod.model.ModelGriefer;

public class RenderGriefer extends RenderLiving {
	
	private static final ResourceLocation texture = new ResourceLocation("netcrafter:textures/model/Griefer");

	protected ModelGriefer modelEntity;
	
	public RenderGriefer(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		
		modelEntity = ((ModelGriefer) mainModel);
		
	}
	
	public void renderGriefer(EntityGriefer entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderGriefer((EntityGriefer)entityLiving, x, y, z, u, v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderGriefer((EntityGriefer)entity, x, y, z, u, v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}

}
