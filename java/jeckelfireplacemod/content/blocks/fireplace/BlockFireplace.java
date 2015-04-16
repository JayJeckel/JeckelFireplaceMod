package jeckelfireplacemod.content.blocks.fireplace;

import java.util.Random;

import jeckelcorelibrary.base.blocks.ABlockTile;
import jeckelfireplacemod.api.IItemToolFireplace;
import jeckelfireplacemod.api.ModManager;
import jeckelfireplacemod.content.ContentManager;
import jeckelfireplacemod.core.Refs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFireplace extends ABlockTile
{
	public BlockFireplace(final boolean active)
	{
		super(Refs.ModId, "fireplace", Material.rock, Block.soundTypeStone);
		this.active = active;
		this.setTickRandomly(true);
		//this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);

		if (this.active) { this.setLightLevel(1.0F); }
	}

	public final boolean active;

	@Override public boolean canHarvestBlock(EntityPlayer player, int meta)
	{
		return true;
	}

	/*@Override public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity entity)
	{
		AxisAlignedBB axisalignedbb1 = this.getCollisionBoundingBoxFromPool(world, x, y, z);

		if (axisalignedbb1 != null && mask.intersectsWith(axisalignedbb1))
		{
			list.add(axisalignedbb1);
		}
	}*/

	@Override public TileEntity createNewTileEntity(World world, int blockMeta) { return new TileFireplace(); }

	@Override public int getRenderType() { return -1; }

	@Override public boolean isOpaqueCube() { return false; }

	@Override public boolean renderAsNormalBlock() { return false; }

	/*@Override public int getLightValue(IBlockAccess world, int x, int y, int z)
	{
		int blockMeta = world.getBlockMetadata(x, y, z);
		if (blockMeta > 0) { return 15; }
		return 0;
	}*/


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
	// Particle Methods
	//
	// ##################################################

	@SideOnly(Side.CLIENT)
	@Override public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		//int meta = world.getBlockMetadata(x, y, z);

		if (this.active)
		{
			for (int l = 0; l < 2; ++l)
			{
				float f = (float)x + random.nextFloat();
				float f1 = (float)y + random.nextFloat() * 0.5F + 0.25F;
				float f2 = (float)z + random.nextFloat();
				world.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
			}
			for (int l = 0; l < 3 * 2; ++l)
			{
				float f = (float)x + this.getFloat(0.2F, 0.8F, random);
				float f1 = (float)y + this.getFloat(0.1F, 0.8F, random);
				float f2 = (float)z + this.getFloat(0.2F, 0.8F, random);
				world.spawnParticle("flame", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
			}
		}
	}


	// ##################################################
	//
	// Block Access
	//
	// ##################################################

	public static void setFireplaceBlock(World world, int x, int y, int z, boolean active)
	{
		if (active) { setFireplaceBlock(world, x, y, z, ContentManager.ModBlocks.fireplace_active); }
		else { setFireplaceBlock(world, x, y, z, ContentManager.ModBlocks.fireplace); }
	}

	private static boolean _changing = false;
	private static void setFireplaceBlock(World world, int x, int y, int z, Block block)
	{
		if (!world.isRemote)
		{
			int meta = world.getBlockMetadata(x, y, z);
			TileEntity tile = world.getTileEntity(x, y, z);

			_changing = true;
			world.setBlock(x, y, z, block);
			world.setBlockMetadataWithNotify(x, y, z, meta, 2);
			tile.validate();
			world.setTileEntity(x, y, z, tile);
			_changing = false;
		}
	}

	@Override public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float par7, float par8, float par9)
	{
		ItemStack stack = player.getCurrentEquippedItem();
		//int meta = world.getBlockMetadata(x, y, z);
		TileFireplace tile = (TileFireplace) world.getTileEntity(x, y, z);

		//ChatUtil.send(player, "active: " + this.active);
		//ChatUtil.send(player, "meta: " + meta);
		//ChatUtil.send(player, "tile: " + (tile != null));
		if (!this.active)
		{
			if (stack != null && ModManager.INSTANCE.FireplaceIgniters.hasItem(stack))
			{
				//ChatUtil.send(player, "Igniter");
				if (!world.isRemote) { setFireplaceBlock(world, x, y, z, true); }
				player.getCurrentEquippedItem().damageItem(1, player);
				return true;
			}
		}
		else if (this.active)
		{
			//ChatUtil.send(player, "Douser");
			if (stack != null && ModManager.INSTANCE.FireplaceDousers.hasItem(stack))
			{
				if (!world.isRemote) { setFireplaceBlock(world, x, y, z, false); }
				return true;
			}
		}

		if (stack != null && tile.storage.canAddLog(stack))
		{
			if (!world.isRemote) { tile.storage.addLog(player, stack); }
			return true;
		}

		if (stack != null && stack.getItem() instanceof IItemToolFireplace) { return false; }

		return super.onBlockActivated(world, x, y, z, player, side, par7, par8, par9);
	}

	@Override public void breakBlock(World world, int x, int y, int z, Block block, int blockMetaMaybe)
	{
		if (!_changing)
		{
			super.breakBlock(world, x, y, z, block, blockMetaMaybe);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
	{
		return Item.getItemFromBlock(ContentManager.ModBlocks.fireplace);
	}

	@SideOnly(Side.CLIENT)
	@Override public Item getItem(World world, int x, int y, int z)
	{
		return Item.getItemFromBlock(ContentManager.ModBlocks.fireplace);
	}

	@Override protected ItemStack createStackedBlock(int meta)
	{
		return new ItemStack(ContentManager.ModBlocks.fireplace);
	}

	private float getFloat(final float min, final float max, final Random random)
	{
		return min + ((max - min) * random.nextFloat());
	}
}
