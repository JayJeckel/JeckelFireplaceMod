package jeckelfireplacemod.content.blocks.stand;

import jeckelcorelibrary.utils.DirUtil;
import jeckelfireplacemod.core.Refs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class BlockRendererFireplaceStand extends TileEntitySpecialRenderer
{
	private final ModelFireplaceStand model;
	private final ResourceLocation texture;
	EntityItem entItem = new EntityItem(Minecraft.getMinecraft().theWorld, 0D, 0D, 0D, new ItemStack(Items.water_bucket, 1, 0));

	public BlockRendererFireplaceStand()
	{
		this.model = new ModelFireplaceStand();
		this.texture = new ResourceLocation(Refs.ModId, "textures/blocks/fireplace_stand_sheet.png");
	}

	@Override public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
	{
		TileFireplaceStand tile = (TileFireplaceStand) te;
		float angle = DirUtil.getAngle(tile.getFrontSide());

		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);

		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(angle, 0.0F, 1.0F, 0.0F);

		Minecraft.getMinecraft().renderEngine.bindTexture(this.texture);
		this.model.tile = tile;
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

		GL11.glPopMatrix();
		GL11.glPopMatrix();

		/*GL11.glPushMatrix();
		//Without the below line, the item will spazz out
		this.entItem.hoverStart = 0.0F;
		RenderItem.renderInFrame = true;
		GL11.glTranslatef((float)x + 0.5F, (float)y + 0.5F, (float)z + 1.0F);
		GL11.glRotatef(angle, 0.0F, 1.0F, 0.0F);
		//GL11.glRotatef(180, 0, 1, 1);
		RenderManager.instance.renderEntityWithPosYaw(this.entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
		RenderItem.renderInFrame = false;
		GL11.glPopMatrix();*/
	}
}
