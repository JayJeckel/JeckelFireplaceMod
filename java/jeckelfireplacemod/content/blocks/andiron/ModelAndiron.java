package jeckelfireplacemod.content.blocks.andiron;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAndiron extends ModelBase
{
    ModelRenderer log0;
    ModelRenderer log1;
    ModelRenderer log2;
    ModelRenderer log3;
    ModelRenderer log4;
    ModelRenderer log5;
    ModelRenderer log6;
    ModelRenderer log7;
    ModelRenderer log8;
    ModelRenderer log9;
    ModelRenderer log10;
    ModelRenderer log11;
    ModelRenderer base;
    ModelRenderer wall0;
    ModelRenderer wall1;
    ModelRenderer stem0;
    ModelRenderer stem1;
    ModelRenderer stem2;
    ModelRenderer stem3;

    public ModelAndiron()
    {
      textureWidth = 64;
      textureHeight = 64;

      log0 = new ModelRenderer(this, 0, 52);
      log0.addBox(-6F, -8F, 0F, 4, 4, 8);
      log0.setRotationPoint(0F, 0F, 0F);
      log0.setTextureSize(64, 64);
      log0.mirror = true;
      setRotation(log0, 0F, 0F, 0F);
      log1 = new ModelRenderer(this, 0, 52);
      log1.addBox(-2F, -8F, 0F, 4, 4, 8);
      log1.setRotationPoint(0F, 0F, 0F);
      log1.setTextureSize(64, 64);
      log1.mirror = true;
      setRotation(log1, 0F, 0F, 0F);
      log2 = new ModelRenderer(this, 0, 52);
      log2.addBox(2F, -8F, 0F, 4, 4, 8);
      log2.setRotationPoint(0F, 0F, 0F);
      log2.setTextureSize(64, 64);
      log2.mirror = true;
      setRotation(log2, 0F, 0F, 0F);
      log3 = new ModelRenderer(this, 0, 52);
      log3.addBox(-6F, -8F, -8F, 4, 4, 8);
      log3.setRotationPoint(0F, 0F, 0F);
      log3.setTextureSize(64, 64);
      log3.mirror = true;
      setRotation(log3, 0F, 0F, 0F);
      log4 = new ModelRenderer(this, 0, 52);
      log4.addBox(-2F, -8F, -8F, 4, 4, 8);
      log4.setRotationPoint(0F, 0F, 0F);
      log4.setTextureSize(64, 64);
      log4.mirror = true;
      setRotation(log4, 0F, 0F, 0F);
      log5 = new ModelRenderer(this, 0, 52);
      log5.addBox(2F, -8F, -8F, 4, 4, 8);
      log5.setRotationPoint(0F, 0F, 0F);
      log5.setTextureSize(64, 64);
      log5.mirror = true;
      setRotation(log5, 0F, 0F, 0F);
      log6 = new ModelRenderer(this, 0, 52);
      log6.addBox(-6F, -12F, 0F, 4, 4, 8);
      log6.setRotationPoint(0F, 0F, 0F);
      log6.setTextureSize(64, 64);
      log6.mirror = true;
      setRotation(log6, 0F, 0F, 0F);
      log7 = new ModelRenderer(this, 0, 52);
      log7.addBox(-2F, -12F, 0F, 4, 4, 8);
      log7.setRotationPoint(0F, 0F, 0F);
      log7.setTextureSize(64, 64);
      log7.mirror = true;
      setRotation(log7, 0F, 0F, 0F);
      log8 = new ModelRenderer(this, 0, 52);
      log8.addBox(2F, -12F, 0F, 4, 4, 8);
      log8.setRotationPoint(0F, 0F, 0F);
      log8.setTextureSize(64, 64);
      log8.mirror = true;
      setRotation(log8, 0F, 0F, 0F);
      log9 = new ModelRenderer(this, 0, 52);
      log9.addBox(-6F, -12F, -8F, 4, 4, 8);
      log9.setRotationPoint(0F, 0F, 0F);
      log9.setTextureSize(64, 64);
      log9.mirror = true;
      setRotation(log9, 0F, 0F, 0F);
      log10 = new ModelRenderer(this, 0, 52);
      log10.addBox(-2F, -12F, -8F, 4, 4, 8);
      log10.setRotationPoint(0F, 0F, 0F);
      log10.setTextureSize(64, 64);
      log10.mirror = true;
      setRotation(log10, 0F, 0F, 0F);
      log11 = new ModelRenderer(this, 0, 52);
      log11.addBox(2F, -12F, -8F, 4, 4, 8);
      log11.setRotationPoint(0F, 0F, 0F);
      log11.setTextureSize(64, 64);
      log11.mirror = true;
      setRotation(log11, 0F, 0F, 0F);
      base = new ModelRenderer(this, 0, 8);
      base.addBox(-6F, -4F, -8F, 12, 1, 16);
      base.setRotationPoint(0F, 0F, 0F);
      base.setTextureSize(64, 64);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
      wall0 = new ModelRenderer(this, 0, 25);
      wall0.addBox(-7F, -10F, -8F, 1, 7, 16);
      wall0.setRotationPoint(0F, 0F, 0F);
      wall0.setTextureSize(64, 64);
      wall0.mirror = true;
      setRotation(wall0, 0F, 0F, 0F);
      wall1 = new ModelRenderer(this, 0, 25);
      wall1.addBox(6F, -10F, -8F, 1, 7, 16);
      wall1.setRotationPoint(0F, 0F, 0F);
      wall1.setTextureSize(64, 64);
      wall1.mirror = true;
      setRotation(wall1, 0F, 0F, 0F);
      stem0 = new ModelRenderer(this, 34, 25);
      stem0.addBox(-7F, -3F, -8F, 3, 3, 3);
      stem0.setRotationPoint(0F, 0F, 0F);
      stem0.setTextureSize(64, 64);
      stem0.mirror = true;
      setRotation(stem0, 0F, 0F, 0F);
      stem1 = new ModelRenderer(this, 34, 25);
      stem1.addBox(4F, -3F, -8F, 3, 3, 3);
      stem1.setRotationPoint(0F, 0F, 0F);
      stem1.setTextureSize(64, 64);
      stem1.mirror = true;
      setRotation(stem1, 0F, 0F, 0F);
      stem2 = new ModelRenderer(this, 34, 25);
      stem2.addBox(-7F, -3F, 5F, 3, 3, 3);
      stem2.setRotationPoint(0F, 0F, 0F);
      stem2.setTextureSize(64, 64);
      stem2.mirror = true;
      setRotation(stem2, 0F, 0F, 0F);
      stem3 = new ModelRenderer(this, 34, 25);
      stem3.addBox(4F, -3F, 5F, 3, 3, 3);
      stem3.setRotationPoint(0F, 0F, 0F);
      stem3.setTextureSize(64, 64);
      stem3.mirror = true;
      setRotation(stem3, 0F, 0F, 0F);
    }
	  
	  public int logCount = 0;
	  
	  @Override public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

	    this.stem0.render(f5);
	    this.stem1.render(f5);
	    this.stem2.render(f5);
	    this.stem3.render(f5);
	    
	    this.base.render(f5);
	    this.wall0.render(f5);
	    this.wall1.render(f5);
	    
	    if (this.logCount > 0) { this.log0.render(f5); }
	    if (this.logCount > 1) { this.log1.render(f5); }
	    if (this.logCount > 2) { this.log2.render(f5); }
	    if (this.logCount > 3) { this.log3.render(f5); }
	    if (this.logCount > 4) { this.log4.render(f5); }
	    if (this.logCount > 5) { this.log5.render(f5); }
	    if (this.logCount > 6) { this.log6.render(f5); }
	    if (this.logCount > 7) { this.log7.render(f5); }
	    if (this.logCount > 8) { this.log8.render(f5); }
	    if (this.logCount > 9) { this.log9.render(f5); }
	    if (this.logCount > 10) { this.log10.render(f5); }
	    if (this.logCount > 11) { this.log11.render(f5); }
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
