package jeckelfireplacemod.content.items.materials;

import java.util.List;

import jeckelcorelibrary.base.items.AItem;
import jeckelfireplacemod.core.Refs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemKindlingEmber extends AItem
{
	public ItemKindlingEmber()
	{
		super(Refs.ModId, "kindling_ember");
		this.setMaxDamage(16);
	}

	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	@Override public void addInformation(ItemStack stack, EntityPlayer player, @SuppressWarnings("rawtypes") List infoList, boolean par4)
	{
		infoList.add("Burning piece of kindling.");
		infoList.add("Careful! It could start a fire.");
		infoList.add("Can be burned as fuel.");
	}

	@Override public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z, int side, float f0, float f1, float f2)
	{
		if (side == 0) { --y; }
		else if (side == 1) { ++y; }
		else if (side == 2) { --z; }
		else if (side == 3) { ++z; }
		else if (side == 4) { --x; }
		else if (side == 5) { ++x; }

		if (!player.canPlayerEdit(x, y, z, side, stack)) { return false; }

		if (world.isAirBlock(x, y, z))
		{
			world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D,
					"fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
			world.setBlock(x, y, z, Blocks.fire);
		}

		stack.damageItem(1, player);
		return true;
	}
}
