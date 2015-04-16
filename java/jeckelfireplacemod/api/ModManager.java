package jeckelfireplacemod.api;

import jeckelcorelibrary.api.managers.IConsumableManager;
import jeckelcorelibrary.api.managers.IItemManager;

public final class ModManager
{
	public static final ModManager INSTANCE = new ModManager();

	private ModManager() { }

	public IConsumableManager FireplaceFuel;

	public IItemManager FireplaceIgniters;

	public IItemManager FireplaceDousers;
}
