package jeckelfireplacemod.content.blocks.kindling;

import java.util.Random;

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

public class BlockKindling extends ABlockTile
{
	public BlockKindling()
	{
		super(Refs.ModId, "kindling", Material.rock, Block.soundTypeStone);
	}

	@Override public boolean canHarvestBlock(EntityPlayer player, int meta)
	{
		return true;
	}

	@Override public TileEntity createNewTileEntity(World world, int blockMeta) { return new TileKindling(); }

	@Override public int getRenderType() { return -1; }

	@Override public boolean isOpaqueCube() { return false; }

	@Override public boolean renderAsNormalBlock() { return false; }

	@Override public int quantityDropped(Random rand) { return 0; }


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

	@Override public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileKindling)
		{
			TileKindling tile = (TileKindling) te;
			tile.storage.addLog(null, new ItemStack(this));
		}
	}

	@Override public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float par7, float par8, float par9)
	{
		ItemStack stack = player.getCurrentEquippedItem();
		//int meta = world.getBlockMetadata(x, y, z);
		TileKindling tile = (TileKindling) world.getTileEntity(x, y, z);

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

		return super.onBlockActivated(world, x, y, z, player, side, par7, par8, par9);
	}
}
