package jeckelfireplacemod.content.items.tools;

import java.util.List;

import jeckelcorelibrary.base.items.AItem;
import jeckelfireplacemod.core.Refs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemToolFireplacePoker extends AItem
{
	public ItemToolFireplacePoker()
	{
		super(Refs.ModId, "tool_fireplace_poker");
		this.setMaxDamage(64);
	}

	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	@Override public void addInformation(ItemStack stack, EntityPlayer player, @SuppressWarnings("rawtypes") List infoList, boolean par4)
	{
		infoList.add("Tool used to stir a fireplace.");
	}
}
