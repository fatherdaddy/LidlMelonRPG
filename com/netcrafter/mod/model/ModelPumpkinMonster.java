package com.netcrafter.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPumpkinMonster extends ModelBase {

    ModelRenderer Body;
    ModelRenderer Neck;
    ModelRenderer Head;
  
  public ModelPumpkinMonster()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Body = new ModelRenderer(this, 0, 12);
      Body.addBox(0F, 0F, 0F, 12, 8, 12);
      Body.setRotationPoint(-6F, 16F, -6F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Neck = new ModelRenderer(this, 0, 0);
      Neck.addBox(0F, 0F, 0F, 8, 4, 8);
      Neck.setRotationPoint(-4F, 12F, -4F);
      Neck.setTextureSize(64, 32);
      Neck.mirror = true;
      setRotation(Neck, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 48, 24);
      Head.addBox(0F, 0F, 0F, 4, 4, 4);
      Head.setRotationPoint(-2F, 8F, -2F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body.render(f5);
    Neck.render(f5);
    Head.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.Body.render(f5);
    
  }

}
