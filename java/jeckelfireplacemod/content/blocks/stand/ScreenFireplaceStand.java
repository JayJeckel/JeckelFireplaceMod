package jeckelfireplacemod.content.blocks.stand;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jeckelcorelibrary.base.guis.AScreenTileInventory;
import jeckelfireplacemod.core.Refs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class ScreenFireplaceStand extends AScreenTileInventory<TileFireplaceStand>
{
	public ScreenFireplaceStand(EntityPlayer player, TileFireplaceStand tile)
	{
		super(player, tile, new ContainerFireplaceStand(player, tile), tile, 176, 148);
		this._resource = new ResourceLocation(Refs.ModId, "textures/guis/fireplace_stand.png");
	}

	@Override public ResourceLocation getResourceLocation() { return this._resource; }
	private ResourceLocation _resource;

	@Override protected void onDrawTexts()
	{
		this.drawTextLeft(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2);
	}
}
