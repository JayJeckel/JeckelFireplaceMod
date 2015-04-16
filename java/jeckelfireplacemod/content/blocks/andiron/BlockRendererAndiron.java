package jeckelfireplacemod.content.blocks.andiron;

import jeckelfireplacemod.core.Refs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class BlockRendererAndiron extends TileEntitySpecialRenderer
{
	private final ModelAndiron model;
	private final ResourceLocation texture;

	public BlockRendererAndiron()
	{
		this.model = new ModelAndiron();
		this.texture = new ResourceLocation(Refs.ModId, "textures/blocks/andiron_sheet.png");
	}

	@Override public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);

		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

		TileAndiron tile = (TileAndiron) te;
		int dir = tile.getFrontSide();
		float angle = 0;
		if (dir == 2) { angle = 0; }
		else if (dir == 3) { angle = 180; }
		else if (dir == 4) { angle = -90; }
		else if (dir == 5) { angle = 90; }
		else { angle = 0; }
		GL11.glRotatef(angle, 0.0F, 1.0F, 0.0F);

		int count = (tile.dummy ? 10 : tile.storage.getLogCount());//(tile._dummy ? 9 : Minecraft.getMinecraft().theWorld.getBlockMetadata(te.xCoord, te.yCoord, te.zCoord))
		Minecraft.getMinecraft().renderEngine.bindTexture(this.texture);
		this.model.logCount = count;
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
