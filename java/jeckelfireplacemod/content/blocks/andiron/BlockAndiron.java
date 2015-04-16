package jeckelfireplacemod.content.blocks.andiron;

import jeckelcorelibrary.base.blocks.ABlockTile;
import jeckelfireplacemod.core.Refs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAndiron extends ABlockTile
{
	public BlockAndiron()
	{
		super(Refs.ModId, "andiron", Material.rock, Block.soundTypeStone);
	}

	@Override public boolean canHarvestBlock(EntityPlayer player, int meta)
	{
		return true;
	}

	@Override public TileEntity createNewTileEntity(World world, int blockMeta) { return new TileAndiron(); }

	@Override public int getRenderType() { return -1; }

	@Override public boolean isOpaqueCube() { return false; }

	@Override public boolean renderAsNormalBlock() { return false; }


	// ##################################################
	//
	// Icon Methods
	//
	// ##################################################

	public String getBlockTextureName() { return this.getTextureName(); }

	@SideOnly(Side.CLIENT)
	@Override public void registerBlockIcons(IIconRegister reg)
	{
		this.blockIcon = reg.registerIcon(this.textureName);
	}


	// ##################################################
	//
	// Block Access
	//
	// ##################################################

	@Override public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		ItemStack stack = player.getCurrentEquippedItem();
		//int meta = world.getBlockMetadata(x, y, z);
		TileAndiron tile = (TileAndiron) world.getTileEntity(x, y, z);

		if (stack != null && tile.storage.canAddLog(stack))
		{
			if (!world.isRemote) { tile.storage.addLog(player, stack); }
			return true;
		}
		else if (stack == null && tile.storage.canTakeLog())
		{
			if (!world.isRemote) { tile.storage.takeLog(player); }
			return true;
		}

		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}
}
