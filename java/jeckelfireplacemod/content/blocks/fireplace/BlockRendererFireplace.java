package jeckelfireplacemod.content.blocks.fireplace;

import jeckelfireplacemod.core.Refs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class BlockRendererFireplace extends TileEntitySpecialRenderer
{
	private final ModelFireplace model;
	private final ResourceLocation texture;

	public BlockRendererFireplace()
	{
		this.model = new ModelFireplace();
		this.texture = new ResourceLocation(Refs.ModId, "textures/blocks/fireplace_sheet.png");
	}

	@Override public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
	{
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);

			GL11.glPushMatrix();
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

			int dir = ((TileFireplace) te).getFrontSide();
			float angle = 0;
			if (dir == 2) { angle = 0; }
			else if (dir == 3) { angle = 180; }
			else if (dir == 4) { angle = -90; }
			else if (dir == 5) { angle = 90; }
			else { angle = 0; }
			GL11.glRotatef(angle, 0.0F, 1.0F, 0.0F);

			TileFireplace tile = (TileFireplace) te;
			int count = (tile.dummy ? 4 : tile.storage.getLogCount());
			Minecraft.getMinecraft().renderEngine.bindTexture(this.texture);
			this.model.logCount = count;//(tile._dummy ? 4 : Minecraft.getMinecraft().theWorld.getBlockMetadata(te.xCoord, te.yCoord, te.zCoord));
			this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

			//ResourceLocation textures = new ResourceLocation("minecraft:textures/blocks/stone.png");
			//Minecraft.getMinecraft().renderEngine.bindTexture(textures);
			//this.renderBlockFire(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord);

			GL11.glPopMatrix();
			GL11.glPopMatrix();
	}

	/*public boolean renderBlockFire(World world, int x, int y, int z)
	{
		Tessellator tessellator = Tessellator.instance;
		IIcon iicon = Blocks.fire.getFireIcon(0);
		IIcon iicon1 = Blocks.fire.getFireIcon(1);
		IIcon iicon2 = iicon;

		Block block = world.getBlock(x, y, z);

		if (RenderBlocks.getInstance().hasOverrideBlockTexture())
		{
			iicon2 = RenderBlocks.getInstance().overrideBlockTexture;
		}

		tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
		tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
		double d0 = (double)iicon2.getMinU();
		double d1 = (double)iicon2.getMinV();
		double d2 = (double)iicon2.getMaxU();
		double d3 = (double)iicon2.getMaxV();
		float f = 1.4F;
		double d5;
		double d6;
		double d7;
		double d8;
		double d9;
		double d10;
		double d11;

		double d4 = (double)x + 0.5D + 0.2D;
		d5 = (double)x + 0.5D - 0.2D;
		d6 = (double)z + 0.5D + 0.2D;
		d7 = (double)z + 0.5D - 0.2D;
		d8 = (double)x + 0.5D - 0.3D;
		d9 = (double)x + 0.5D + 0.3D;
		d10 = (double)z + 0.5D - 0.3D;
		d11 = (double)z + 0.5D + 0.3D;
		tessellator.addVertexWithUV(d8, (double)((float)y + f), (double)(z + 1), d2, d1);
		tessellator.addVertexWithUV(d4, (double)(y + 0), (double)(z + 1), d2, d3);
		tessellator.addVertexWithUV(d4, (double)(y + 0), (double)(z + 0), d0, d3);
		tessellator.addVertexWithUV(d8, (double)((float)y + f), (double)(z + 0), d0, d1);
		tessellator.addVertexWithUV(d9, (double)((float)y + f), (double)(z + 0), d2, d1);
		tessellator.addVertexWithUV(d5, (double)(y + 0), (double)(z + 0), d2, d3);
		tessellator.addVertexWithUV(d5, (double)(y + 0), (double)(z + 1), d0, d3);
		tessellator.addVertexWithUV(d9, (double)((float)y + f), (double)(z + 1), d0, d1);
		d0 = (double)iicon1.getMinU();
		d1 = (double)iicon1.getMinV();
		d2 = (double)iicon1.getMaxU();
		d3 = (double)iicon1.getMaxV();
		tessellator.addVertexWithUV((double)(x + 1), (double)((float)y + f), d11, d2, d1);
		tessellator.addVertexWithUV((double)(x + 1), (double)(y + 0), d7, d2, d3);
		tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), d7, d0, d3);
		tessellator.addVertexWithUV((double)(x + 0), (double)((float)y + f), d11, d0, d1);
		tessellator.addVertexWithUV((double)(x + 0), (double)((float)y + f), d10, d2, d1);
		tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), d6, d2, d3);
		tessellator.addVertexWithUV((double)(x + 1), (double)(y + 0), d6, d0, d3);
		tessellator.addVertexWithUV((double)(x + 1), (double)((float)y + f), d10, d0, d1);
		d4 = (double)x + 0.5D - 0.5D;
		d5 = (double)x + 0.5D + 0.5D;
		d6 = (double)z + 0.5D - 0.5D;
		d7 = (double)z + 0.5D + 0.5D;
		d8 = (double)x + 0.5D - 0.4D;
		d9 = (double)x + 0.5D + 0.4D;
		d10 = (double)z + 0.5D - 0.4D;
		d11 = (double)z + 0.5D + 0.4D;
		tessellator.addVertexWithUV(d8, (double)((float)y + f), (double)(z + 0), d0, d1);
		tessellator.addVertexWithUV(d4, (double)(y + 0), (double)(z + 0), d0, d3);
		tessellator.addVertexWithUV(d4, (double)(y + 0), (double)(z + 1), d2, d3);
		tessellator.addVertexWithUV(d8, (double)((float)y + f), (double)(z + 1), d2, d1);
		tessellator.addVertexWithUV(d9, (double)((float)y + f), (double)(z + 1), d0, d1);
		tessellator.addVertexWithUV(d5, (double)(y + 0), (double)(z + 1), d0, d3);
		tessellator.addVertexWithUV(d5, (double)(y + 0), (double)(z + 0), d2, d3);
		tessellator.addVertexWithUV(d9, (double)((float)y + f), (double)(z + 0), d2, d1);
		d0 = (double)iicon.getMinU();
		d1 = (double)iicon.getMinV();
		d2 = (double)iicon.getMaxU();
		d3 = (double)iicon.getMaxV();
		tessellator.addVertexWithUV((double)(x + 0), (double)((float)y + f), d11, d0, d1);
		tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), d7, d0, d3);
		tessellator.addVertexWithUV((double)(x + 1), (double)(y + 0), d7, d2, d3);
		tessellator.addVertexWithUV((double)(x + 1), (double)((float)y + f), d11, d2, d1);
		tessellator.addVertexWithUV((double)(x + 1), (double)((float)y + f), d10, d0, d1);
		tessellator.addVertexWithUV((double)(x + 1), (double)(y + 0), d6, d0, d3);
		tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), d6, d2, d3);
		tessellator.addVertexWithUV((double)(x + 0), (double)((float)y + f), d10, d2, d1);

		return true;
	}*/

	/*private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
	{
			int meta = world.getBlockMetadata(x, y, z);
			GL11.glPushMatrix();
			GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
			GL11.glPopMatrix();
	}*/

	//Set the lighting stuff, so it changes it's brightness properly.
	/*private void adjustLightFixture(World world, int i, int j, int k, Block block)
	{
			Tessellator tess = Tessellator.instance;
			//float brightness = block.getBlockBrightness(world, i, j, k);
			//As of MC 1.7+ block.getBlockBrightness() has become block.getLightValue():
			float brightness = block.getLightValue(world, i, j, k);
			int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
			int modulousModifier = skyLight % 65536;
			int divModifier = skyLight / 65536;
			tess.setColorOpaque_F(brightness, brightness, brightness);
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) modulousModifier,  divModifier);
	}*/
}
