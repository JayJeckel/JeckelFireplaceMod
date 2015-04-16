package jeckelfireplacemod.content.blocks.kindling;

import jeckelcorelibrary.api.guis.ITileGuiActivator;
import jeckelcorelibrary.api.tiles.ITileInteractable;
import jeckelcorelibrary.base.tiles.ATileInventory;
import jeckelfireplacemod.JeckelFireplaceMod;
import jeckelfireplacemod.api.ModManager;
import jeckelfireplacemod.content.KindlingContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class TileKindling
extends ATileInventory
implements ITileInteractable, ITileGuiActivator
{
	protected TileKindling(int inventoryCount, boolean dummy)
	{
		super(inventoryCount, dummy);
		this.storage = new KindlingContainer(this, this,
				ModManager.INSTANCE.FireplaceFuel,
				0, 1, 32);
	}

	public TileKindling() { this(1, false); }

	public TileKindling(boolean dummy) { this(1, dummy); }

	public final KindlingContainer storage;

	@Override public int getInventoryStackLimit() { return this.storage.countMax; }


	// ##################################################
	//
	// Read and Write NBT
	//
	// ##################################################

	@Override public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
	}

	@Override public void writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);
	}


	// ##################################################
	//
	// ITileInteractable
	//
	// ##################################################

	@Override public void interact(EntityPlayer player, World world, int x, int y, int z, int side)
	{
		if (!player.isSneaking()) {  player.openGui(JeckelFireplaceMod.INSTANCE, 0, world, x, y, z); }
	}


	// ##################################################
	//
	// ITileGui
	//
	// ##################################################

	@Override public Object createContainer(EntityPlayer player) { return null; }//new ContainerKindling(player, this); }

	@Override public Object createScreen(EntityPlayer player) { return null; }//new ScreenKindling(player, this); }
}
