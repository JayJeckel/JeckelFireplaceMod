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

public class ItemToolFireplaceTongs extends AItem implements IItemToolFireplace
{
	public ItemToolFireplaceTongs()
	{
		super(Refs.ModId, "tool_fireplace_tongs");
		this.setMaxDamage(320);
	}

	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	@Override public void addInformation(ItemStack stack, EntityPlayer player, @SuppressWarnings("rawtypes") List infoList, boolean par4)
	{
		infoList.add("Tool used to extract Kindling Embers.");
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
			final int count = 1;//CoreUtil.rand.nextInt(3) + 1;
			ItemStack reward = new ItemStack(ContentManager.ModItems.kindling_ember, count);
			boolean result = player.inventory.addItemStackToInventory(reward);
			if (!result)
			{
				player.entityDropItem(reward, 0.25F);
				ChatUtil.send(player, "Found and dropped " + count + " Ember.", EnumChatFormatting.YELLOW);
			}
			else
			{
				ChatUtil.send(player, "Found " + count + " Ember.", EnumChatFormatting.GREEN);
			}
		}
		else
		{
			ChatUtil.send(player, "No Ember found.", EnumChatFormatting.RED);
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
		if (te == null || !(te instanceof TileFireplace) || !((TileFireplace) te).fuelConsumer.isProcessing())
		{
			ChatUtil.Server.send(player, "Tongs are only usable on a burning Fireplace.");
			return true;
		}
		return false;
	}
}
