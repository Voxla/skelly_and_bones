
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.skellyandbones.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.skellyandbones.item.IronPikeItem;
import net.mcreator.skellyandbones.item.IronKnightItem;
import net.mcreator.skellyandbones.SkellyAndBonesMod;

public class SkellyAndBonesModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SkellyAndBonesMod.MODID);
	public static final RegistryObject<Item> IRON_KNIGHT_HELMET = REGISTRY.register("iron_knight_helmet", () -> new IronKnightItem.Helmet());
	public static final RegistryObject<Item> IRON_PIKE = REGISTRY.register("iron_pike", () -> new IronPikeItem());
	public static final RegistryObject<Item> SKELLY_SPAWN_EGG = REGISTRY.register("skelly_spawn_egg", () -> new ForgeSpawnEggItem(SkellyAndBonesModEntities.SKELLY, -3355444, -7909039, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> BONES_SPAWN_EGG = REGISTRY.register("bones_spawn_egg", () -> new ForgeSpawnEggItem(SkellyAndBonesModEntities.BONES, -3355444, -11446137, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
