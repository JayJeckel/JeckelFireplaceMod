package jeckelfireplacemod.content.items.materials;

import java.util.List;

import jeckelcorelibrary.base.items.AItem;
import jeckelfireplacemod.core.Refs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemKindlingAsh extends AItem
{
	public ItemKindlingAsh()
	{
		super(Refs.ModId, "kindling_ash");
	}

	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	@Override public void addInformation(ItemStack stack, EntityPlayer player, @SuppressWarnings("rawtypes") List infoList, boolean par4)
	{
		infoList.add("Small amount of charcoal ash.");
		infoList.add("Can be burned as fuel.");
	}
}
