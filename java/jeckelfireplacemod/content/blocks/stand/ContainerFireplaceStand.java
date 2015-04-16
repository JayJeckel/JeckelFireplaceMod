package jeckelfireplacemod.content.blocks.stand;

import jeckelcorelibrary.base.guis.AContainerTileInventory;
import jeckelcorelibrary.core.slots.SlotDisplay;
import jeckelcorelibrary.core.slots.SlotItem;
import jeckelfireplacemod.content.ContentManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ContainerFireplaceStand extends AContainerTileInventory<TileFireplaceStand>
{
	public ContainerFireplaceStand(EntityPlayer player, TileFireplaceStand tile)
	{
		super(player, tile, tile, 176, 148);

		// Internal Inventory
		this.addSlotToContainer(new SlotDisplay(this._tile, 0, 80, 17));
		this.addSlotToContainer(new SlotItem(this._tile, 1, 62, 26, new ItemStack(ContentManager.ModItems.tool_tongs, 1, OreDictionary.WILDCARD_VALUE)));
		this.addSlotToContainer(new SlotItem(this._tile, 2, 98, 26, new ItemStack(ContentManager.ModItems.tool_shovel, 1, OreDictionary.WILDCARD_VALUE)));
		this.addSlotToContainer(new SlotItem(this._tile, 3, 80, 35, new ItemStack(ContentManager.ModItems.tool_poker, 1, OreDictionary.WILDCARD_VALUE)));

		// Player Inventory
		this.addPlayerInventorySlots(this._player.inventory, 8, this._height);
		this.addPlayerHotbarSlots(this._player.inventory, 8, this._height);
	}

	@Override protected int getMergeSlotCount(final int slotIndex)
	{
		switch (slotIndex) { default: { return 1; } }
	}

	@Override protected boolean isValidSlotItem(final EntityPlayer player, final int slotIndex, final ItemStack stack)
	{
		return this.getSlot(slotIndex).isItemValid(stack);
	}
}
