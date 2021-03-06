package jeckelfireplacemod.content.blocks.andiron;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockAndiron extends ItemBlock
{
	public ItemBlockAndiron(Block block)
	{
		super(block);
		//this.setMaxStackSize(1);
	}

	public Block getBlock() { return this.field_150939_a; }

	@Override public String getUnlocalizedName(ItemStack stack)
	{
		return this.getBlock().getUnlocalizedName();
	}

	@Override public int getMetadata(int meta) { return meta; }

	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	@Override public void addInformation(ItemStack stack, EntityPlayer player, @SuppressWarnings("rawtypes") List infoList, boolean par4)
	{
		infoList.add("Decorative block to store Kindling.");
		infoList.add(EnumChatFormatting.WHITE + "-Use Kindling to add to andiron.");
		infoList.add(EnumChatFormatting.WHITE + "-Use empty hand to remove Kindling from andiron.");
	}
}
