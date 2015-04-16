package jeckelfireplacemod.content.blocks.kindling;

import jeckelfireplacemod.core.Refs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class BlockRendererKindling extends TileEntitySpecialRenderer
{
	private final ModelKindling model;
	private final ModelKindlingPile modelPile;
	private final ResourceLocation texture;
	private final ResourceLocation texturePile;

	public BlockRendererKindling()
	{
		this.model = new ModelKindling();
		this.modelPile = new ModelKindlingPile();
		this.texture = new ResourceLocation(Refs.ModId, "textures/blocks/kindling_sheet.png");
		this.texturePile = new ResourceLocation(Refs.ModId, "textures/blocks/kindling_pile_sheet.png");
	}

	@Override public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
	{
		TileKindling tile = (TileKindling) te;
		GL11.glPushMatrix();
		if (tile.dummy)
		{
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.35F, (float) z + 0.5F);
		}
		else
		{
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
		}

		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

		int dir = tile.getFrontSide();
		float angle = 0;
		if (dir == 2) { angle = 0; }
		else if (dir == 3) { angle = 180; }
		else if (dir == 4) { angle = -90; }
		else if (dir == 5) { angle = 90; }
		else { angle = 0; }
		GL11.glRotatef(angle, 0.0F, 1.0F, 0.0F);

		int count = (tile.dummy ? 1 : tile.storage.getLogCount());//(tile._dummy ? 1 : Minecraft.getMinecraft().theWorld.getBlockMetadata(te.xCoord, te.yCoord, te.zCoord));
		if (count > 1)
		{
			Minecraft.getMinecraft().renderEngine.bindTexture(this.texturePile);
			this.modelPile.logCount = count;
			this.modelPile.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}
		else
		{
			Minecraft.getMinecraft().renderEngine.bindTexture(this.texture);
			this.model.logCount = count;
			this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}

		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
