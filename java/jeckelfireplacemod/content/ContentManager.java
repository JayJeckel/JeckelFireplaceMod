package jeckelfireplacemod.content;

import jeckelcorelibrary.GlobalRefs;
import jeckelcorelibrary.api.managers.IContentManager;
import jeckelcorelibrary.utils.GameRegUtil;
import jeckelfireplacemod.content.blocks.andiron.BlockAndiron;
import jeckelfireplacemod.content.blocks.andiron.ItemBlockAndiron;
import jeckelfireplacemod.content.blocks.andiron.TileAndiron;
import jeckelfireplacemod.content.blocks.fireplace.BlockFireplace;
import jeckelfireplacemod.content.blocks.fireplace.ItemBlockFireplace;
import jeckelfireplacemod.content.blocks.fireplace.TileFireplace;
import jeckelfireplacemod.content.blocks.kindling.BlockKindling;
import jeckelfireplacemod.content.blocks.kindling.ItemBlockKindling;
import jeckelfireplacemod.content.blocks.kindling.TileKindling;
import jeckelfireplacemod.content.blocks.stand.BlockFireplaceStand;
import jeckelfireplacemod.content.blocks.stand.ItemBlockFireplaceStand;
import jeckelfireplacemod.content.blocks.stand.TileFireplaceStand;
import jeckelfireplacemod.content.entities.ItemMinecartTest;
import jeckelfireplacemod.content.items.materials.ItemKindlingAsh;
import jeckelfireplacemod.content.items.materials.ItemKindlingEmber;
import jeckelfireplacemod.content.items.tools.ItemToolFireplacePoker;
import jeckelfireplacemod.content.items.tools.ItemToolFireplaceShovel;
import jeckelfireplacemod.content.items.tools.ItemToolFireplaceTongs;
import jeckelfireplacemod.core.Refs;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class ContentManager implements IContentManager
{
	public static class ModBlocks
	{
		public static Block andiron;

		public static Block fireplace;

		public static Block fireplace_active;

		public static Block kindling;

		public static Block stand;
	}

	public static class ModItems
	{
		public static Item tool_poker;

		public static Item tool_tongs;

		public static Item tool_shovel;

		public static Item kindling_ember;

		public static Item kindling_ash;
	}

	public static ItemMinecartTest test;

	public void pre()
	{
		ModItems.tool_poker = new ItemToolFireplacePoker();
		GameRegUtil.item(ModItems.tool_poker);

		ModItems.tool_tongs = new ItemToolFireplaceTongs();
		GameRegUtil.item(ModItems.tool_tongs);

		ModItems.tool_shovel = new ItemToolFireplaceShovel();
		GameRegUtil.item(ModItems.tool_shovel);

		ModItems.kindling_ember = new ItemKindlingEmber();
		GameRegUtil.item(ModItems.kindling_ember);

		ModItems.kindling_ash = new ItemKindlingAsh();
		GameRegUtil.item(ModItems.kindling_ash);

		ModBlocks.kindling = new BlockKindling();
		GameRegUtil.block(ModBlocks.kindling, ItemBlockKindling.class, TileKindling.class);

		ModBlocks.fireplace = new BlockFireplace(false);
		GameRegUtil.block(ModBlocks.fireplace, ItemBlockFireplace.class, TileFireplace.class);
		ModBlocks.fireplace_active = new BlockFireplace(true);
		GameRegUtil.block(ModBlocks.fireplace_active, ModBlocks.fireplace.getUnlocalizedName() + "_active");

		ModBlocks.andiron = new BlockAndiron();
		GameRegUtil.block(ModBlocks.andiron, ItemBlockAndiron.class, TileAndiron.class);

		ModBlocks.stand = new BlockFireplaceStand();
		GameRegUtil.block(ModBlocks.stand, ItemBlockFireplaceStand.class, TileFireplaceStand.class);

		//test = new ItemMinecartTest(0);
		//test.setCreativeTab(tab);
		//GameRegistry.registerItem(test, "cart.test");
		//EntityRegistry.registerModEntity(EntityMinecartTest.class, "cart.test", 0, modInfo.getMod(), 256, 3, true);

		GlobalRefs.getTabManager().addMachineBlock(Refs.ModId, ModBlocks.fireplace);
		GlobalRefs.getTabManager().addMachineBlock(Refs.ModId, ModBlocks.andiron);
		GlobalRefs.getTabManager().addMachineBlock(Refs.ModId, ModBlocks.stand);
		GlobalRefs.getTabManager().addMachineBlock(Refs.ModId, ModBlocks.kindling);
		GlobalRefs.getTabManager().addMachineItem(Refs.ModId, ModItems.kindling_ash);
		GlobalRefs.getTabManager().addMachineItem(Refs.ModId, ModItems.kindling_ember);
		GlobalRefs.getTabManager().addMachineItem(Refs.ModId, ModItems.tool_poker);
		GlobalRefs.getTabManager().addMachineItem(Refs.ModId, ModItems.tool_shovel);
		GlobalRefs.getTabManager().addMachineItem(Refs.ModId, ModItems.tool_tongs);

		GameRegistry.registerFuelHandler(new ContentManager.FuelHandler());
	}

	public static class FuelHandler implements IFuelHandler
	{
		@Override public int getBurnTime(ItemStack fuel)
		{
			if (Block.getBlockFromItem(fuel.getItem()) == ContentManager.ModBlocks.kindling) { return 20; }
			if (fuel.getItem() == ContentManager.ModItems.kindling_ash) { return 200; }
			if (fuel.getItem() == ContentManager.ModItems.kindling_ember) { return 600; }
			return 0;
		}
	}

	@Override public void initialize()
	{
		GameRegUtil.recipeShaped(new ItemStack(ModBlocks.kindling, 64, 0),
				"   ",
				"LLL",
				"   ",
				'L', "logWood");

		GameRegUtil.recipeShaped(new ItemStack(Items.coal, 1, 1),
				"###",
				"# #",
				"###",
				'#', new ItemStack(ModItems.kindling_ash));

		GameRegUtil.recipeShaped(new ItemStack(ModItems.tool_poker, 1, 0),
				"I  ",
				"#  ",
				"#  ",
				'I', new ItemStack(Items.iron_ingot),
				'#', new ItemStack(ModBlocks.kindling));

		GameRegUtil.recipeShaped(new ItemStack(ModItems.tool_tongs, 1, 0),
				"I I",
				"# #",
				"###",
				'I', new ItemStack(Items.iron_ingot),
				'#', new ItemStack(ModBlocks.kindling));

		GameRegUtil.recipeShaped(new ItemStack(ModItems.tool_shovel, 1, 0),
				" I ",
				" # ",
				" # ",
				'I', new ItemStack(Items.iron_ingot),
				'#', new ItemStack(ModBlocks.kindling));

		GameRegUtil.recipeShaped(new ItemStack(ModBlocks.fireplace, 1, 0),
				"   ",
				"III",
				"I I",
				'I', new ItemStack(Items.iron_ingot));

		GameRegUtil.recipeShaped(new ItemStack(ModBlocks.andiron, 1, 0),
				"   ",
				"I I",
				"III",
				'I', new ItemStack(Items.iron_ingot));

		GameRegUtil.recipeShaped(new ItemStack(ModBlocks.stand, 1, 0),
				" I ",
				" I ",
				"III",
				'I', new ItemStack(Items.iron_ingot));
	}

	@Override public void post()
	{
	}
}
