
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.skellyandbones.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.skellyandbones.entity.SkellyEntity;
import net.mcreator.skellyandbones.entity.BonesEntity;
import net.mcreator.skellyandbones.SkellyAndBonesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SkellyAndBonesModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, SkellyAndBonesMod.MODID);
	public static final RegistryObject<EntityType<SkellyEntity>> SKELLY = register("skelly",
			EntityType.Builder.<SkellyEntity>of(SkellyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SkellyEntity::new)

					.sized(0.6f, 1.99f));
	public static final RegistryObject<EntityType<BonesEntity>> BONES = register("bones",
			EntityType.Builder.<BonesEntity>of(BonesEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BonesEntity::new)

					.sized(0.6f, 1.99f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			SkellyEntity.init();
			BonesEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(SKELLY.get(), SkellyEntity.createAttributes().build());
		event.put(BONES.get(), BonesEntity.createAttributes().build());
	}
}
