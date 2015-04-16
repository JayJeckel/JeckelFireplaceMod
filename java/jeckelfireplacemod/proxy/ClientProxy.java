package jeckelfireplacemod.proxy;

import jeckelcorelibrary.utils.GameRegUtil;
import jeckelfireplacemod.content.ContentManager;
import jeckelfireplacemod.content.blocks.andiron.BlockRendererAndiron;
import jeckelfireplacemod.content.blocks.andiron.TileAndiron;
import jeckelfireplacemod.content.blocks.fireplace.BlockRendererFireplace;
import jeckelfireplacemod.content.blocks.fireplace.TileFireplace;
import jeckelfireplacemod.content.blocks.kindling.BlockRendererKindling;
import jeckelfireplacemod.content.blocks.kindling.TileKindling;
import jeckelfireplacemod.content.blocks.stand.BlockRendererFireplaceStand;
import jeckelfireplacemod.content.blocks.stand.TileFireplaceStand;

public class ClientProxy extends CommonProxy
{
	@Override public boolean isClient() { return true; }

	@Override public void initialize(final String modId)
	{
		super.initialize(modId);

		GameRegUtil.Client.registerTileRenderer(ContentManager.ModBlocks.fireplace, new TileFireplace(true), new BlockRendererFireplace());
		GameRegUtil.Client.registerTileRenderer(ContentManager.ModBlocks.andiron, new TileAndiron(true), new BlockRendererAndiron());
		GameRegUtil.Client.registerTileRenderer(ContentManager.ModBlocks.kindling, new TileKindling(true), new BlockRendererKindling());
		GameRegUtil.Client.registerTileRenderer(ContentManager.ModBlocks.stand, new TileFireplaceStand(true), new BlockRendererFireplaceStand());

		//RenderingRegistry.registerEntityRenderingHandler(EntityMinecartTest.class,
		//		new EntityRendererMinecartTest());
	}
}
