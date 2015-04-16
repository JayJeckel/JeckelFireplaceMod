package jeckelfireplacemod.content.blocks.stand;

import jeckelcorelibrary.api.guis.ITileGuiActivator;
import jeckelcorelibrary.api.tiles.ITileInteractable;
import jeckelcorelibrary.base.tiles.ATileInventory;
import jeckelfireplacemod.JeckelFireplaceMod;
import jeckelfireplacemod.content.ContentManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class TileFireplaceStand
extends ATileInventory
implements ITileInteractable, ITileGuiActivator
{
	private TileFireplaceStand(int inventorySize, boolean dummy)
	{
		super(inventorySize, dummy);
		this.setTileName(ContentManager.ModBlocks.stand.getUnlocalizedName() + ".name");
	}

	public TileFireplaceStand() { this(4, false); }

	public TileFireplaceStand(boolean dummy) { this(4, dummy); }

	public int getInventoryStackLimit() { return 1; }

	public ItemStack getToolStackBack() { return this.getStackInSlot(0); }
	public ItemStack getToolStackLeft() { return this.getStackInSlot(1); }
	public ItemStack getToolStackRight() { return this.getStackInSlot(2); }
	public ItemStack getToolStackFront() { return this.getStackInSlot(3); }


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

	@Override public Object createContainer(EntityPlayer player) { return new ContainerFireplaceStand(player, this); }

	@Override public Object createScreen(EntityPlayer player) { return new ScreenFireplaceStand(player, this); }
}
