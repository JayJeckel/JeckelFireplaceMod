package jeckelfireplacemod.content.blocks.stand;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFireplaceStand extends ModelBase
{
	ModelRenderer base;
	ModelRenderer shaft;
	ModelRenderer stemF;
	ModelRenderer stemB;
	ModelRenderer stemL;
	ModelRenderer stemR;
	ModelRenderer poker0;
	ModelRenderer poker1;
	ModelRenderer tongsL;
	ModelRenderer tongsM;
	ModelRenderer tongsR;
	ModelRenderer shovelHandle;
	ModelRenderer shovelBlade;

	public TileFireplaceStand tile;

	public ModelFireplaceStand()
	{
		textureWidth = 32;
		textureHeight = 32;

		base = new ModelRenderer(this, 0, 0);
		base.addBox(-4F, -1F, -4F, 8, 1, 8);
		base.setRotationPoint(0F, 0F, 0F);
		base.setTextureSize(32, 32);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
		shaft = new ModelRenderer(this, 28, 16);
		shaft.addBox(-0.5F, -16F, -0.5F, 1, 15, 1);
		shaft.setRotationPoint(0F, 0F, 0F);
		shaft.setTextureSize(32, 32);
		shaft.mirror = true;
		setRotation(shaft, 0F, 0F, 0F);
		stemF = new ModelRenderer(this, 0, 0);
		stemF.addBox(-0.5F, -13F, -3.5F, 1, 1, 3);
		stemF.setRotationPoint(0F, 0F, 0F);
		stemF.setTextureSize(32, 32);
		stemF.mirror = true;
		setRotation(stemF, 0F, 0F, 0F);
		stemB = new ModelRenderer(this, 0, 0);
		stemB.addBox(-0.5F, -13F, 0.5F, 1, 1, 3);
		stemB.setRotationPoint(0F, 0F, 0F);
		stemB.setTextureSize(32, 32);
		stemB.mirror = true;
		setRotation(stemB, 0F, 0F, 0F);
		stemL = new ModelRenderer(this, 0, 0);
		stemL.addBox(0.5F, -13F, -0.5F, 3, 1, 1);
		stemL.setRotationPoint(0F, 0F, 0F);
		stemL.setTextureSize(32, 32);
		stemL.mirror = true;
		setRotation(stemL, 0F, 0F, 0F);
		stemR = new ModelRenderer(this, 0, 0);
		stemR.addBox(-3.5F, -13F, -0.5F, 3, 1, 1);
		stemR.setRotationPoint(0F, 0F, 0F);
		stemR.setTextureSize(32, 32);
		stemR.mirror = true;
		setRotation(stemR, 0F, 0F, 0F);
		poker0 = new ModelRenderer(this, 0, 20);
		poker0.addBox(-0.5F, -14F, -2.5F, 1, 11, 1);
		poker0.setRotationPoint(0F, 0F, 0F);
		poker0.setTextureSize(32, 32);
		poker0.mirror = true;
		setRotation(poker0, 0F, 0F, 0F);
		poker1 = new ModelRenderer(this, 0, 18);
		poker1.addBox(-1F, -3F, -2.5F, 2, 1, 1);
		poker1.setRotationPoint(0F, 0F, 0F);
		poker1.setTextureSize(32, 32);
		poker1.mirror = true;
		setRotation(poker1, 0F, 0F, 0F);
		tongsL = new ModelRenderer(this, 6, 19);
		tongsL.addBox(-2.5F, -14F, -1.5F, 1, 12, 1);
		tongsL.setRotationPoint(0F, 0F, 0F);
		tongsL.setTextureSize(32, 32);
		tongsL.mirror = true;
		setRotation(tongsL, 0F, 0F, 0F);
		tongsM = new ModelRenderer(this, 6, 17);
		tongsM.addBox(-2.5F, -14F, -0.5F, 1, 1, 1);
		tongsM.setRotationPoint(0F, 0F, 0F);
		tongsM.setTextureSize(32, 32);
		tongsM.mirror = true;
		setRotation(tongsM, 0F, 0F, 0F);
		tongsR = new ModelRenderer(this, 6, 19);
		tongsR.addBox(-2.5F, -14F, 0.5F, 1, 12, 1);
		tongsR.setRotationPoint(0F, 0F, 0F);
		tongsR.setTextureSize(32, 32);
		tongsR.mirror = true;
		setRotation(tongsR, 0F, 0F, 0F);
		shovelHandle = new ModelRenderer(this, 10, 16);
		shovelHandle.addBox(1.5F, -14F, -0.5F, 1, 8, 1);
		shovelHandle.setRotationPoint(0F, 0F, 0F);
		shovelHandle.setTextureSize(32, 32);
		shovelHandle.mirror = true;
		setRotation(shovelHandle, 0F, 0F, 0F);
		shovelBlade = new ModelRenderer(this, 10, 25);
		shovelBlade.addBox(1.5F, -6F, -1.5F, 1, 4, 3);
		shovelBlade.setRotationPoint(0F, 0F, 0F);
		shovelBlade.setTextureSize(32, 32);
		shovelBlade.mirror = true;
		setRotation(shovelBlade, 0F, 0F, 0F);
	}

	@Override public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		base.render(f5);
		shaft.render(f5);
		stemF.render(f5);
		stemB.render(f5);
		stemL.render(f5);
		stemR.render(f5);
		if (this.tile.dummy || this.tile.getToolStackFront() != null)
		{
			poker0.render(f5);
			poker1.render(f5);
		}
		if (this.tile.dummy || this.tile.getToolStackLeft() != null)
		{
			tongsL.render(f5);
			tongsM.render(f5);
			tongsR.render(f5);
		}
		if (this.tile.dummy || this.tile.getToolStackRight() != null)
		{
			shovelHandle.render(f5);
			shovelBlade.render(f5);
		}
		if (this.tile.dummy || this.tile.getToolStackBack() != null)
		{
		}
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
