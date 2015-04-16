package jeckelfireplacemod.content.blocks.fireplace;

import java.awt.Point;
import java.awt.Rectangle;

import jeckelcorelibrary.base.guis.AScreenTileInventory;
import jeckelfireplacemod.core.Refs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ScreenFireplace extends AScreenTileInventory<TileFireplace>
{
	public ScreenFireplace(EntityPlayer player, TileFireplace tile)
	{
		super(player, tile, new ContainerFireplace(player, tile), tile, 176, 148);
		this._resource = new ResourceLocation(Refs.ModId, "textures/guis/fireplace.png");
	}

	@Override public ResourceLocation getResourceLocation() { return this._resource; }
	private ResourceLocation _resource;

	private final OverlayInfo infoFuelConsumer = new OverlayInfo(new Rectangle(81, 18, 14, 14),
			new Point(176, 0), new Point(176, 14), false, true, true);

	@Override protected void onDrawTexts()
	{
		this.drawTextLeft(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2);
	}

	@Override protected void onDrawOverlays()
	{
		if (this._tile.fuelConsumer.isProcessing())
		{ this.drawProcessOverlay(this._tile.fuelConsumer, this.infoFuelConsumer); }
	}

	@Override protected void onDrawTooltips(int x, int y)
	{
		if (this.infoFuelConsumer.contains(x, y)) { this.drawProcessTooltip(x, y, "Fire Burning", this._tile.fuelConsumer); }
	}
}
