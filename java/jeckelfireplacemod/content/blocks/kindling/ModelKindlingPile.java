package jeckelfireplacemod.content.blocks.kindling;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKindlingPile extends ModelBase
{
    private final ModelRenderer log000;
    private final ModelRenderer log100;
    private final ModelRenderer log200;
    private final ModelRenderer log300;

    private final ModelRenderer log010;
    private final ModelRenderer log110;
    private final ModelRenderer log210;
    private final ModelRenderer log310;

    private final ModelRenderer log020;
    private final ModelRenderer log120;
    private final ModelRenderer log220;
    private final ModelRenderer log320;

    private final ModelRenderer log030;
    private final ModelRenderer log130;
    private final ModelRenderer log230;
    private final ModelRenderer log330;

    private final ModelRenderer log001;
    private final ModelRenderer log101;
    private final ModelRenderer log201;
    private final ModelRenderer log301;

    private final ModelRenderer log011;
    private final ModelRenderer log111;
    private final ModelRenderer log211;
    private final ModelRenderer log311;

    private final ModelRenderer log021;
    private final ModelRenderer log121;
    private final ModelRenderer log221;
    private final ModelRenderer log321;

    private final ModelRenderer log031;
    private final ModelRenderer log131;
    private final ModelRenderer log231;
    private final ModelRenderer log331;

    public ModelKindlingPile()
    {
        textureWidth = 32;
        textureHeight = 32;

        log000 = new ModelRenderer(this, 0, 0);
        log000.addBox(-8F, -4F, 0F, 4, 4, 8);
        log000.setRotationPoint(0F, 0F, 0F);
        log000.setTextureSize(32, 32);
        log000.mirror = true;
        setRotation(log000, 0F, 0F, 0F);
        log100 = new ModelRenderer(this, 0, 0);
        log100.addBox(-4F, -4F, 0F, 4, 4, 8);
        log100.setRotationPoint(0F, 0F, 0F);
        log100.setTextureSize(32, 32);
        log100.mirror = true;
        setRotation(log100, 0F, 0F, 0F);
        log200 = new ModelRenderer(this, 0, 0);
        log200.addBox(0F, -4F, 0F, 4, 4, 8);
        log200.setRotationPoint(0F, 0F, 0F);
        log200.setTextureSize(32, 32);
        log200.mirror = true;
        setRotation(log200, 0F, 0F, 0F);
        log300 = new ModelRenderer(this, 0, 0);
        log300.addBox(4F, -4F, 0F, 4, 4, 8);
        log300.setRotationPoint(0F, 0F, 0F);
        log300.setTextureSize(32, 32);
        log300.mirror = true;
        setRotation(log300, 0F, 0F, 0F);

        log010 = new ModelRenderer(this, 0, 0);
        log010.addBox(-8F, -8F, 0F, 4, 4, 8);
        log010.setRotationPoint(0F, 0F, 0F);
        log010.setTextureSize(32, 32);
        log010.mirror = true;
        setRotation(log010, 0F, 0F, 0F);
        log110 = new ModelRenderer(this, 0, 0);
        log110.addBox(-4F, -8F, 0F, 4, 4, 8);
        log110.setRotationPoint(0F, 0F, 0F);
        log110.setTextureSize(32, 32);
        log110.mirror = true;
        setRotation(log110, 0F, 0F, 0F);
        log210 = new ModelRenderer(this, 0, 0);
        log210.addBox(0F, -8F, 0F, 4, 4, 8);
        log210.setRotationPoint(0F, 0F, 0F);
        log210.setTextureSize(32, 32);
        log210.mirror = true;
        setRotation(log210, 0F, 0F, 0F);
        log310 = new ModelRenderer(this, 0, 0);
        log310.addBox(4F, -8F, 0F, 4, 4, 8);
        log310.setRotationPoint(0F, 0F, 0F);
        log310.setTextureSize(32, 32);
        log310.mirror = true;
        setRotation(log310, 0F, 0F, 0F);

        log020 = new ModelRenderer(this, 0, 0);
        log020.addBox(-8F, -12F, 0F, 4, 4, 8);
        log020.setRotationPoint(0F, 0F, 0F);
        log020.setTextureSize(32, 32);
        log020.mirror = true;
        setRotation(log020, 0F, 0F, 0F);
        log120 = new ModelRenderer(this, 0, 0);
        log120.addBox(-4F, -12F, 0F, 4, 4, 8);
        log120.setRotationPoint(0F, 0F, 0F);
        log120.setTextureSize(32, 32);
        log120.mirror = true;
        setRotation(log120, 0F, 0F, 0F);
        log220 = new ModelRenderer(this, 0, 0);
        log220.addBox(0F, -12F, 0F, 4, 4, 8);
        log220.setRotationPoint(0F, 0F, 0F);
        log220.setTextureSize(32, 32);
        log220.mirror = true;
        setRotation(log220, 0F, 0F, 0F);
        log320 = new ModelRenderer(this, 0, 0);
        log320.addBox(4F, -12F, 0F, 4, 4, 8);
        log320.setRotationPoint(0F, 0F, 0F);
        log320.setTextureSize(32, 32);
        log320.mirror = true;
        setRotation(log320, 0F, 0F, 0F);

        log030 = new ModelRenderer(this, 0, 0);
        log030.addBox(-8F, -16F, 0F, 4, 4, 8);
        log030.setRotationPoint(0F, 0F, 0F);
        log030.setTextureSize(32, 32);
        log030.mirror = true;
        setRotation(log030, 0F, 0F, 0F);
        log130 = new ModelRenderer(this, 0, 0);
        log130.addBox(-4F, -16F, 0F, 4, 4, 8);
        log130.setRotationPoint(0F, 0F, 0F);
        log130.setTextureSize(32, 32);
        log130.mirror = true;
        setRotation(log130, 0F, 0F, 0F);
        log230 = new ModelRenderer(this, 0, 0);
        log230.addBox(0F, -16F, 0F, 4, 4, 8);
        log230.setRotationPoint(0F, 0F, 0F);
        log230.setTextureSize(32, 32);
        log230.mirror = true;
        setRotation(log230, 0F, 0F, 0F);
        log330 = new ModelRenderer(this, 0, 0);
        log330.addBox(4F, -16F, 0F, 4, 4, 8);
        log330.setRotationPoint(0F, 0F, 0F);
        log330.setTextureSize(32, 32);
        log330.mirror = true;
        setRotation(log330, 0F, 0F, 0F);

        log001 = new ModelRenderer(this, 0, 0);
        log001.addBox(-8F, -4F, -8F, 4, 4, 8);
        log001.setRotationPoint(0F, 0F, 0F);
        log001.setTextureSize(32, 32);
        log001.mirror = true;
        setRotation(log001, 0F, 0F, 0F);
        log101 = new ModelRenderer(this, 0, 0);
        log101.addBox(-4F, -4F, -8F, 4, 4, 8);
        log101.setRotationPoint(0F, 0F, 0F);
        log101.setTextureSize(32, 32);
        log101.mirror = true;
        setRotation(log101, 0F, 0F, 0F);
        log201 = new ModelRenderer(this, 0, 0);
        log201.addBox(0F, -4F, -8F, 4, 4, 8);
        log201.setRotationPoint(0F, 0F, 0F);
        log201.setTextureSize(32, 32);
        log201.mirror = true;
        setRotation(log201, 0F, 0F, 0F);
        log301 = new ModelRenderer(this, 0, 0);
        log301.addBox(4F, -4F, -8F, 4, 4, 8);
        log301.setRotationPoint(0F, 0F, 0F);
        log301.setTextureSize(32, 32);
        log301.mirror = true;
        setRotation(log301, 0F, 0F, 0F);

        log011 = new ModelRenderer(this, 0, 0);
        log011.addBox(-8F, -8F, -8F, 4, 4, 8);
        log011.setRotationPoint(0F, 0F, 0F);
        log011.setTextureSize(32, 32);
        log011.mirror = true;
        setRotation(log011, 0F, 0F, 0F);
        log111 = new ModelRenderer(this, 0, 0);
        log111.addBox(-4F, -8F, -8F, 4, 4, 8);
        log111.setRotationPoint(0F, 0F, 0F);
        log111.setTextureSize(32, 32);
        log111.mirror = true;
        setRotation(log111, 0F, 0F, 0F);
        log211 = new ModelRenderer(this, 0, 0);
        log211.addBox(0F, -8F, -8F, 4, 4, 8);
        log211.setRotationPoint(0F, 0F, 0F);
        log211.setTextureSize(32, 32);
        log211.mirror = true;
        setRotation(log211, 0F, 0F, 0F);
        log311 = new ModelRenderer(this, 0, 0);
        log311.addBox(4F, -8F, -8F, 4, 4, 8);
        log311.setRotationPoint(0F, 0F, 0F);
        log311.setTextureSize(32, 32);
        log311.mirror = true;
        setRotation(log311, 0F, 0F, 0F);

        log021 = new ModelRenderer(this, 0, 0);
        log021.addBox(-8F, -12F, -8F, 4, 4, 8);
        log021.setRotationPoint(0F, 0F, 0F);
        log021.setTextureSize(32, 32);
        log021.mirror = true;
        setRotation(log021, 0F, 0F, 0F);
        log121 = new ModelRenderer(this, 0, 0);
        log121.addBox(-4F, -12F, -8F, 4, 4, 8);
        log121.setRotationPoint(0F, 0F, 0F);
        log121.setTextureSize(32, 32);
        log121.mirror = true;
        setRotation(log121, 0F, 0F, 0F);
        log221 = new ModelRenderer(this, 0, 0);
        log221.addBox(0F, -12F, -8F, 4, 4, 8);
        log221.setRotationPoint(0F, 0F, 0F);
        log221.setTextureSize(32, 32);
        log221.mirror = true;
        setRotation(log221, 0F, 0F, 0F);
        log321 = new ModelRenderer(this, 0, 0);
        log321.addBox(4F, -12F, -8F, 4, 4, 8);
        log321.setRotationPoint(0F, 0F, 0F);
        log321.setTextureSize(32, 32);
        log321.mirror = true;
        setRotation(log321, 0F, 0F, 0F);

        log031 = new ModelRenderer(this, 0, 0);
        log031.addBox(-8F, -16F, -8F, 4, 4, 8);
        log031.setRotationPoint(0F, 0F, 0F);
        log031.setTextureSize(32, 32);
        log031.mirror = true;
        setRotation(log031, 0F, 0F, 0F);
        log131 = new ModelRenderer(this, 0, 0);
        log131.addBox(-4F, -16F, -8F, 4, 4, 8);
        log131.setRotationPoint(0F, 0F, 0F);
        log131.setTextureSize(32, 32);
        log131.mirror = true;
        setRotation(log131, 0F, 0F, 0F);
        log231 = new ModelRenderer(this, 0, 0);
        log231.addBox(0F, -16F, -8F, 4, 4, 8);
        log231.setRotationPoint(0F, 0F, 0F);
        log231.setTextureSize(32, 32);
        log231.mirror = true;
        setRotation(log231, 0F, 0F, 0F);
        log331 = new ModelRenderer(this, 0, 0);
        log331.addBox(4F, -16F, -8F, 4, 4, 8);
        log331.setRotationPoint(0F, 0F, 0F);
        log331.setTextureSize(32, 32);
        log331.mirror = true;
        setRotation(log331, 0F, 0F, 0F);
    }
	  
	public int logCount = 0;
	  
	@Override public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		if (this.logCount >= 1) { log000.render(f5); }
		if (this.logCount >= 2) { log100.render(f5); }
		if (this.logCount >= 3) { log200.render(f5); }
		if (this.logCount >= 4) { log300.render(f5); }

		if (this.logCount >= 5) { log010.render(f5); }
		if (this.logCount >= 6) { log110.render(f5); }
		if (this.logCount >= 7) { log210.render(f5); }
		if (this.logCount >= 8) { log310.render(f5); }

		if (this.logCount >= 9) { log020.render(f5); }
		if (this.logCount >= 10) { log120.render(f5); }
		if (this.logCount >= 11) { log220.render(f5); }
		if (this.logCount >= 12) { log320.render(f5); }

		if (this.logCount >= 13) { log030.render(f5); }
		if (this.logCount >= 14) { log130.render(f5); }
		if (this.logCount >= 15) { log230.render(f5); }
		if (this.logCount >= 16) { log330.render(f5); }

		if (this.logCount >= 17) { log001.render(f5); }
		if (this.logCount >= 18) { log101.render(f5); }
		if (this.logCount >= 19) { log201.render(f5); }
		if (this.logCount >= 20) { log301.render(f5); }

		if (this.logCount >= 21) { log011.render(f5); }
		if (this.logCount >= 22) { log111.render(f5); }
		if (this.logCount >= 23) { log211.render(f5); }
		if (this.logCount >= 24) { log311.render(f5); }

		if (this.logCount >= 25) { log021.render(f5); }
		if (this.logCount >= 26) { log121.render(f5); }
		if (this.logCount >= 27) { log221.render(f5); }
		if (this.logCount >= 28) { log321.render(f5); }

		if (this.logCount >= 29) { log031.render(f5); }
		if (this.logCount >= 30) { log131.render(f5); }
		if (this.logCount >= 31) { log231.render(f5); }
		if (this.logCount >= 32) { log331.render(f5); }
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
