package jeckelfireplacemod.content.blocks.kindling;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKindling extends ModelBase
{
    ModelRenderer layer1;

    public ModelKindling()
    {
        textureWidth = 32;
        textureHeight = 32;

        layer1 = new ModelRenderer(this, 0, 0);
        layer1.addBox(-4F, -4F, -2F, 8, 4, 4);
        layer1.setRotationPoint(0F, 0F, 0F);
        layer1.setTextureSize(32, 32);
        layer1.mirror = true;
        setRotation(layer1, 0F, 0F, 0F);
    }

	public int logCount = 0;

	@Override public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		layer1.render(f5);
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
