package com.netcrafter.mod.renderer;

import com.netcrafter.mod.entity.boss.EntityGayArazhul;
import com.netcrafter.mod.entity.monster.EntityPumpkinMonster;
import com.netcrafter.mod.model.ModelGayArazhul;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderGayArazhul extends RenderLiving {
	
	public static final ResourceLocation texture = new ResourceLocation("netcrafter:textures/model/GayArazhul.png"); 
	
	protected ModelGayArazhul modelEntity;

	public RenderGayArazhul(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		
		modelEntity = ((ModelGayArazhul) mainModel);
		
	}
	
	public void renderGayArazhul(EntityGayArazhul entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderGayArazhul((EntityGayArazhul)entityLiving, x, y, z, u, v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderGayArazhul((EntityGayArazhul)entity, x, y, z, u, v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}

}
