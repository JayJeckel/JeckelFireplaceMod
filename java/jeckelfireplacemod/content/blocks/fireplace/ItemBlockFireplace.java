package jeckelfireplacemod.content.blocks.fireplace;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockFireplace extends ItemBlock
{
	public ItemBlockFireplace(Block block)
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
		infoList.add("Fireplace to provide light and atmosphere.");
		infoList.add(EnumChatFormatting.WHITE + "-Use Flint and Steel to light.");
		infoList.add(EnumChatFormatting.WHITE + "-Use Water Bucket or Sand to extinguish.");
		infoList.add(EnumChatFormatting.WHITE + "-Use Kindling to add fuel to the fire.");
	}
}
