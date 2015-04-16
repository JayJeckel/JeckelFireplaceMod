package jeckelfireplacemod.content.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class EntityMinecartTest extends EntityMinecart
{
	public EntityMinecartTest(World world)
	{
		super(world);
	}

	public EntityMinecartTest(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}

	@Override public Block func_145817_o()
	{
		//return ContentInitializer.fireplace;
		return Blocks.hay_block;
	}

	@Override public boolean interactFirst(EntityPlayer player)
	{
		if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.entity.minecart.MinecartInteractEvent(this, player))) { return true; }
		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != player)
		{
			return true;
		}
		else if (this.riddenByEntity != null && this.riddenByEntity != player)
		{
			return false;
		}

		if (!this.worldObj.isRemote) { player.mountEntity(this); }
		return true;
	}

	@Override public int getMinecartType()
	{
		return 0;
	}
}
