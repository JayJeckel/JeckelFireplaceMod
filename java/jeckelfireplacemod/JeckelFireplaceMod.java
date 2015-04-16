package jeckelfireplacemod;

import jeckelcorelibrary.base.managers.ConsumableManager;
import jeckelcorelibrary.base.managers.ItemManager;
import jeckelcorelibrary.core.commands.InfoModCommand;
import jeckelfireplacemod.api.ModManager;
import jeckelfireplacemod.content.ContentManager;
import jeckelfireplacemod.core.Refs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod
(
modid = Refs.ModId,
useMetadata = true,
canBeDeactivated = false,
guiFactory = Refs.ConfigFactoryTypeName
)
public class JeckelFireplaceMod
{
	@Mod.Instance (value = Refs.ModId)
	public static JeckelFireplaceMod INSTANCE;

	public JeckelFireplaceMod() { }

	@Mod.EventHandler
	public void preInitialize(FMLPreInitializationEvent event)
	{
		Refs.pre(INSTANCE, event);

		ModManager.INSTANCE.FireplaceFuel = new ConsumableManager();
		ModManager.INSTANCE.FireplaceIgniters = new ItemManager();
		ModManager.INSTANCE.FireplaceDousers = new ItemManager();
	}

	@Mod.EventHandler
	public void initialize(FMLInitializationEvent event)
	{
		Refs.initialize(event);

		ModManager.INSTANCE.FireplaceFuel.setConsumable(new ItemStack(ContentManager.ModBlocks.kindling, 1, OreDictionary.WILDCARD_VALUE), 12000);

		ModManager.INSTANCE.FireplaceIgniters.addItem(new ItemStack(Items.flint_and_steel));

		ModManager.INSTANCE.FireplaceDousers.addItem(new ItemStack(Items.water_bucket));
		ModManager.INSTANCE.FireplaceDousers.addItem(new ItemStack(Items.milk_bucket));
		ModManager.INSTANCE.FireplaceDousers.addItem(new ItemStack(Blocks.sand));
	}

	@Mod.EventHandler
	public void postInitialization(FMLPostInitializationEvent event)
	{
		Refs.post(event);
	}

	@EventHandler
	public void onServerStarting(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new InfoModCommand(Refs.getMetadata(), Refs.getUpdateChecker(), "Display info about the mod."));
	}
}
