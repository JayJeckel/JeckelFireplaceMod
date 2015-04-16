package jeckelfireplacemod.content.blocks.kindling;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockKindling extends ItemBlock
{
	public ItemBlockKindling(Block block)
	{
		super(block);
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
    	infoList.add("Kindling to burn in a fireplace.");
    	infoList.add("Can also be efficiently burned as fuel.");
    }
}
