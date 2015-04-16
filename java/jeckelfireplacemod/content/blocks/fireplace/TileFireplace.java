package jeckelfireplacemod.content.blocks.fireplace;

import java.util.ArrayList;
import java.util.List;

import jeckelcorelibrary.api.guis.ITileGuiActivator;
import jeckelcorelibrary.api.processes.ITickProcess;
import jeckelcorelibrary.api.tiles.ITileInteractable;
import jeckelcorelibrary.api.tiles.ITileProcessor;
import jeckelcorelibrary.base.tiles.ATileInventory;
import jeckelcorelibrary.core.processes.solids.DynamicSolidConsumerProcess;
import jeckelfireplacemod.JeckelFireplaceMod;
import jeckelfireplacemod.api.ModManager;
import jeckelfireplacemod.content.ContentManager;
import jeckelfireplacemod.content.KindlingContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class TileFireplace
extends ATileInventory
implements ITileInteractable, ITileGuiActivator, ITileProcessor
{
	private TileFireplace(int inventoryCount, boolean dummy)
	{
		super(inventoryCount, dummy);
		this.setTileName(ContentManager.ModBlocks.fireplace.getUnlocalizedName() + ".name");

		this._processes = new ArrayList<ITickProcess>();

		this.storage = new KindlingContainer(this, this,
				ModManager.INSTANCE.FireplaceFuel,
				0, 0, 6);
		this.fuelConsumer = new DynamicSolidConsumerProcess("fuel_consumer", true, this, 0, ModManager.INSTANCE.FireplaceFuel);
		this._processes.add(this.fuelConsumer);
	}

	private final List<ITickProcess> _processes;

	public TileFireplace() { this(1, false); }

	public TileFireplace(boolean dummy) { this(1, dummy); }

	public final KindlingContainer storage;

	public final ITickProcess fuelConsumer;

	@Override public int getInventoryStackLimit()
	{
		return this.storage.countMax - (this.fuelConsumer.isProcessing() ? 1 : 0);
	}

	@Override public void updateEntity()
	{
		boolean dirty = false;

		if (!this.worldObj.isRemote)
		{
			BlockFireplace block = (BlockFireplace) this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord);
			if (block.active)
			{
				if (this.fuelConsumer.updateProcess(this.worldObj)) { dirty = true; }
				if (!this.fuelConsumer.isProcessable())
				{
					BlockFireplace.setFireplaceBlock(this.worldObj, this.xCoord, this.yCoord, this.zCoord, false);
					dirty = true;
				}
			}

			if (!block.active)
			{
				if (this.fuelConsumer.isProcessing()) { this.fuelConsumer.cancelCycle(this.worldObj); dirty = true; }
			}
		}

		if (dirty) { this.markDirty(); }
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
	// ITileGuiActivator
	//
	// ##################################################

	@Override public Object createContainer(EntityPlayer player) { return new ContainerFireplace(player, this); }

	@Override public Object createScreen(EntityPlayer player) { return new ScreenFireplace(player, this); }


	// ##################################################
	//
	// ITileProcessor
	//
	// ##################################################

	@Override public List<ITickProcess> getProcesses() { return this._processes; }
}
