package jeckelfireplacemod.content.items.tools;

import java.util.List;

import jeckelcorelibrary.base.items.AItem;
import jeckelcorelibrary.utils.ChatUtil;
import jeckelcorelibrary.utils.MathUtil;
import jeckelfireplacemod.api.IItemToolFireplace;
import jeckelfireplacemod.content.ContentManager;
import jeckelfireplacemod.content.blocks.fireplace.TileFireplace;
import jeckelfireplacemod.core.Refs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemToolFireplaceShovel extends AItem implements IItemToolFireplace
{
	public ItemToolFireplaceShovel()
	{
		super(Refs.ModId, "tool_fireplace_shovel");
		this.setMaxDamage(320);
	}

	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	@Override public void addInformation(ItemStack stack, EntityPlayer player, @SuppressWarnings("rawtypes") List infoList, boolean par4)
	{
		infoList.add("Tool used to extract Kindling Charcoal Ash.");
	}

	//@SideOnly(Side.CLIENT)
	//@Override public boolean shouldRotateAroundWhenRendering() { return true; }

	@Override public EnumAction getItemUseAction(ItemStack stack) { return EnumAction.bow; }

	@Override public int getMaxItemUseDuration(ItemStack stack) { return 64; }

	@Override public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		//ChatUtil.Server.send(player, "onItemUseFirst");
		return false;
	}

	@Override public void onUsingTick(ItemStack stack, EntityPlayer player, int tick)
	{
		if (player.worldObj.isRemote) { return; }
		if (tick > 1) { return; }
		//ChatUtil.send(player, "Tick: " + tick);
		final int rand = MathUtil.rand.nextInt(1000) + 1;
		if (rand <= 500)
		{
			final int count = MathUtil.rand.nextInt(3) + 1;
			ItemStack reward = new ItemStack(ContentManager.ModItems.kindling_ash, count);
			boolean result = player.inventory.addItemStackToInventory(reward);
			if (!result)
			{
				player.entityDropItem(reward, 0.25F);
				ChatUtil.send(player, "Found and dropped " + count + " Charcoal Ash.", EnumChatFormatting.YELLOW);
			}
			else
			{
				ChatUtil.send(player, "Found " + count + " Charcoal Ash.", EnumChatFormatting.GREEN);
			}
		}
		else
		{
			ChatUtil.send(player, "No Charcoal Ash found.", EnumChatFormatting.RED);
		}
		stack.damageItem(1, player);
	}

	@Override public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		//ChatUtil.Server.send(player, "onItemRightClick");
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}

	@Override public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		//ChatUtil.Server.send(player, "onItemUse");
		TileEntity te = world.getTileEntity(x, y, z);
		if (te == null || !(te instanceof TileFireplace))
		{
			ChatUtil.Server.send(player, "Poker is only usable on a Fireplace.");
			return true;
		}
		return false;
	}
}
