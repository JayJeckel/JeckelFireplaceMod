package jeckelfireplacemod.content;

import jeckelcorelibrary.api.managers.IConsumableManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class KindlingContainer
{
	public KindlingContainer(TileEntity tile, IInventory inventory, IConsumableManager fuelManager,
			int slotIndex, int countMin, int countMax)
	{
		this.tile = tile;
		this.inventory = inventory;
		this.fuelManager = fuelManager;
		this.slotIndex = slotIndex;
		this.countMin = countMin;
		this.countMax = countMax;
	}

	public final TileEntity tile;
	public final IInventory inventory;
	public final IConsumableManager fuelManager;
	public final int slotIndex;
	public final int countMin;
	public final int countMax;

	public int getLogCount()
	{
		ItemStack stack = this.inventory.getStackInSlot(this.slotIndex);
		int count = (stack == null ? this.countMin : stack.stackSize);
		if (count > this.inventory.getInventoryStackLimit()) { count = this.inventory.getInventoryStackLimit(); }
		return count;
	}

	public boolean canTakeLog()
	{
		return this.getLogCount() > this.countMin;
	}

	public void takeLog(EntityPlayer player)
	{
		ItemStack log = this.inventory.getStackInSlot(this.slotIndex).copy();
		log.stackSize = 1;
		this.inventory.decrStackSize(this.slotIndex, 1);
		player.setCurrentItemOrArmor(0, log);

		if (!this.tile.getWorldObj().isRemote)
		{
			this.tile.getWorldObj().markBlockForUpdate(this.tile.xCoord, this.tile.yCoord, this.tile.zCoord);
			this.tile.markDirty();
		}
	}

	public boolean canAddLog(ItemStack log)
	{
		ItemStack stack = this.inventory.getStackInSlot(this.slotIndex);
		if (this.fuelManager.getConsumableTime(log) < 1) { return false; }
		if (stack != null)
		{
			if (!stack.isItemEqual(log)) { return false; }
			if (this.getLogCount() >= this.inventory.getInventoryStackLimit()) { return false; }
		}
		return true;
	}

	public void addLog(EntityPlayer player, ItemStack log)
	{
		ItemStack stack = this.inventory.getStackInSlot(this.slotIndex);
		ItemStack result = log.copy();
		if (stack == null)
		{
			result.stackSize = 1;
			this.inventory.setInventorySlotContents(this.slotIndex, result);
		}
		else
		{
			result.stackSize = stack.stackSize + 1;
			this.inventory.setInventorySlotContents(this.slotIndex, result);
		}

		if (player != null && !player.capabilities.isCreativeMode)
		{
			ItemStack equip = player.getCurrentEquippedItem();
			equip.stackSize -= 1;
			if (equip.stackSize <= 0) { equip = null; }
			player.setCurrentItemOrArmor(0, equip);
		}

		if (!this.tile.getWorldObj().isRemote)
		{
			this.tile.getWorldObj().markBlockForUpdate(this.tile.xCoord, this.tile.yCoord, this.tile.zCoord);
			this.tile.markDirty();
		}
	}
}
