package jeckelfireplacemod.slots;

import jeckelfireplacemod.api.ModManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotFuelFireplace extends Slot
{
    public SlotFuelFireplace(IInventory inventory, int id, int x, int y)
    {
        super(inventory, id, x, y);
    }
    
    @Override public boolean isItemValid(ItemStack stack)
    {
    	return ModManager.INSTANCE.FireplaceFuel.getConsumableTime(stack) > 0;
    }
    
    @Override public int getSlotStackLimit()
    {
    	return 6;
    }
}
