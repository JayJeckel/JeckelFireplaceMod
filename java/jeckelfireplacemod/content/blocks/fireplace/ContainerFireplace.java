package jeckelfireplacemod.content.blocks.fireplace;

import jeckelcorelibrary.base.guis.AContainerTileInventory;
import jeckelfireplacemod.slots.SlotFuelFireplace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ContainerFireplace extends AContainerTileInventory<TileFireplace>
{
	public ContainerFireplace(EntityPlayer player, TileFireplace tile)
	{
		super(player, tile, tile, 176, 148);

		// Internal Inventory
		this.addSlotToContainer(new SlotFuelFireplace(this._tile, 0, 80, 35));

		// Player Inventory
		this.addPlayerInventorySlots(this._player.inventory, 8, this._height);
		this.addPlayerHotbarSlots(this._player.inventory, 8, this._height);
	}

	@Override protected int getMergeSlotCount(final int slotIndex)
	{
		switch (slotIndex) { default: { return 0; } }
	}

	@Override protected boolean isValidSlotItem(final EntityPlayer player, final int slotIndex, final ItemStack stack)
	{
		return this.getSlot(slotIndex).isItemValid(stack);
	}
}
