package jeckelfireplacemod.content.blocks.fireplace;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFireplace extends ModelBase
{
    ModelRenderer log0;
    ModelRenderer log1;
    ModelRenderer log2;
    ModelRenderer log3;
    ModelRenderer log4;
    ModelRenderer log5;
    ModelRenderer base0;
    ModelRenderer base1;
    ModelRenderer base2;
    ModelRenderer base3;
    ModelRenderer base4;
    ModelRenderer base5;
    ModelRenderer base6;
    ModelRenderer base7;
    ModelRenderer base8;
    ModelRenderer base9;
    ModelRenderer base10;
    ModelRenderer base11;
    ModelRenderer stem0;
    ModelRenderer stem1;
    ModelRenderer stem2;
    ModelRenderer stem3;
  
  public ModelFireplace()
  {
    textureWidth = 48;
    textureHeight = 48;

    log0 = new ModelRenderer(this, 0, 2);
    log0.addBox(-4F, -6F, 2F, 8, 4, 4);
    log0.setRotationPoint(0F, 0F, 0F);
    log0.setTextureSize(48, 48);
    log0.mirror = true;
    setRotation(log0, 0F, 0F, 0F);
    log1 = new ModelRenderer(this, 0, 2);
    log1.addBox(-4F, -6F, -6F, 8, 4, 4);
    log1.setRotationPoint(0F, 0F, 0F);
    log1.setTextureSize(48, 48);
    log1.mirror = true;
    setRotation(log1, 0F, 0F, 0F);
    log2 = new ModelRenderer(this, 0, 2);
    log2.addBox(-4F, -10F, 0F, 8, 4, 4);
    log2.setRotationPoint(0F, 0F, 0F);
    log2.setTextureSize(48, 48);
    log2.mirror = true;
    setRotation(log2, 0F, -1.570796F, 0F);
    log3 = new ModelRenderer(this, 0, 2);
    log3.addBox(-4F, -10F, -4F, 8, 4, 4);
    log3.setRotationPoint(0F, 0F, 0F);
    log3.setTextureSize(48, 48);
    log3.mirror = true;
    setRotation(log3, 0F, -1.570796F, 0F);
    log4 = new ModelRenderer(this, 0, 2);
    log4.addBox(-4F, -14F, 0F, 8, 4, 4);
    log4.setRotationPoint(0F, 0F, 0F);
    log4.setTextureSize(48, 48);
    log4.mirror = true;
    setRotation(log4, 0F, 0F, 0F);
    log5 = new ModelRenderer(this, 0, 2);
    log5.addBox(-4F, -14F, -4F, 8, 4, 4);
    log5.setRotationPoint(0F, 0F, 0F);
    log5.setTextureSize(48, 48);
    log5.mirror = true;
    setRotation(log5, 0F, 0F, 0F);
    base0 = new ModelRenderer(this, 0, 0);
    base0.addBox(-8F, -2F, -8F, 16, 1, 1);
    base0.setRotationPoint(0F, 0F, 0F);
    base0.setTextureSize(48, 48);
    base0.mirror = true;
    setRotation(base0, 0F, 0F, 0F);
    base1 = new ModelRenderer(this, 0, 0);
    base1.addBox(-8F, -2F, -5F, 16, 1, 1);
    base1.setRotationPoint(0F, 0F, 0F);
    base1.setTextureSize(48, 48);
    base1.mirror = true;
    setRotation(base1, 0F, 0F, 0F);
    base2 = new ModelRenderer(this, 0, 0);
    base2.addBox(-8F, -2F, -2F, 16, 1, 1);
    base2.setRotationPoint(0F, 0F, 0F);
    base2.setTextureSize(48, 48);
    base2.mirror = true;
    setRotation(base2, 0F, 0F, 0F);
    base3 = new ModelRenderer(this, 0, 0);
    base3.addBox(-8F, -2F, 1F, 16, 1, 1);
    base3.setRotationPoint(0F, 0F, 0F);
    base3.setTextureSize(48, 48);
    base3.mirror = true;
    setRotation(base3, 0F, 0F, 0F);
    base4 = new ModelRenderer(this, 0, 0);
    base4.addBox(-8F, -2F, 7F, 16, 1, 1);
    base4.setRotationPoint(0F, 0F, 0F);
    base4.setTextureSize(48, 48);
    base4.mirror = true;
    setRotation(base4, 0F, 0F, 0F);
    base5 = new ModelRenderer(this, 0, 0);
    base5.addBox(-8F, -2F, 4F, 16, 1, 1);
    base5.setRotationPoint(0F, 0F, 0F);
    base5.setTextureSize(48, 48);
    base5.mirror = true;
    setRotation(base5, 0F, 0F, 0F);
    base6 = new ModelRenderer(this, 0, 0);
    base6.addBox(-8F, -2F, -8F, 16, 1, 1);
    base6.setRotationPoint(0F, 0F, 0F);
    base6.setTextureSize(48, 48);
    base6.mirror = true;
    setRotation(base6, 0F, -1.570796F, 0F);
    base7 = new ModelRenderer(this, 0, 0);
    base7.addBox(-8F, -2F, -5F, 16, 1, 1);
    base7.setRotationPoint(0F, 0F, 0F);
    base7.setTextureSize(48, 48);
    base7.mirror = true;
    setRotation(base7, 0F, -1.570796F, 0F);
    base8 = new ModelRenderer(this, 0, 0);
    base8.addBox(-8F, -2F, -2F, 16, 1, 1);
    base8.setRotationPoint(0F, 0F, 0F);
    base8.setTextureSize(48, 48);
    base8.mirror = true;
    setRotation(base8, 0F, -1.570796F, 0F);
    base9 = new ModelRenderer(this, 0, 0);
    base9.addBox(-8F, -2F, 1F, 16, 1, 1);
    base9.setRotationPoint(0F, 0F, 0F);
    base9.setTextureSize(48, 48);
    base9.mirror = true;
    setRotation(base9, 0F, -1.570796F, 0F);
    base10 = new ModelRenderer(this, 0, 0);
    base10.addBox(-8F, -2F, 4F, 16, 1, 1);
    base10.setRotationPoint(0F, 0F, 0F);
    base10.setTextureSize(48, 48);
    base10.mirror = true;
    setRotation(base10, 0F, -1.570796F, 0F);
    base11 = new ModelRenderer(this, 0, 0);
    base11.addBox(-8F, -2F, 7F, 16, 1, 1);
    base11.setRotationPoint(0F, 0F, 0F);
    base11.setTextureSize(48, 48);
    base11.mirror = true;
    setRotation(base11, 0F, -1.570796F, 0F);
    stem0 = new ModelRenderer(this, 0, 0);
    stem0.addBox(-8F, -1F, -8F, 1, 1, 1);
    stem0.setRotationPoint(0F, 0F, 0F);
    stem0.setTextureSize(48, 48);
    stem0.mirror = true;
    setRotation(stem0, 0F, 0F, 0F);
    stem1 = new ModelRenderer(this, 0, 0);
    stem1.addBox(7F, -1F, -8F, 1, 1, 1);
    stem1.setRotationPoint(0F, 0F, 0F);
    stem1.setTextureSize(48, 48);
    stem1.mirror = true;
    setRotation(stem1, 0F, 0F, 0F);
    stem2 = new ModelRenderer(this, 0, 0);
    stem2.addBox(-8F, -1F, 7F, 1, 1, 1);
    stem2.setRotationPoint(0F, 0F, 0F);
    stem2.setTextureSize(48, 48);
    stem2.mirror = true;
    setRotation(stem2, 0F, 0F, 0F);
    stem3 = new ModelRenderer(this, 0, 0);
    stem3.addBox(7F, -1F, 7F, 1, 1, 1);
    stem3.setRotationPoint(0F, 0F, 0F);
    stem3.setTextureSize(48, 48);
    stem3.mirror = true;
    setRotation(stem3, 0F, 0F, 0F);
  }
  
  public int logCount = 0;
  
  @Override public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

    stem0.render(f5);
    stem1.render(f5);
    stem2.render(f5);
    stem3.render(f5);
    
    base0.render(f5);
    base1.render(f5);
    base2.render(f5);
    base3.render(f5);
    base4.render(f5);
    base5.render(f5);
    base6.render(f5);
    base7.render(f5);
    base8.render(f5);
    base9.render(f5);
    base10.render(f5);
    base11.render(f5);
    
    if (logCount > 0) { log0.render(f5); }
    if (logCount > 1) { log1.render(f5); }
    if (logCount > 2) { log2.render(f5); }
    if (logCount > 3) { log3.render(f5); }
    if (logCount > 4) { log4.render(f5); }
    if (logCount > 5) { log5.render(f5); }
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
}
