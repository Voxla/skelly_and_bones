package net.mcreator.skellyandbones.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

import net.mcreator.skellyandbones.network.SkellyAndBonesModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SkellySpawnTimerProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.WorldTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.world);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (world.getLevelData().isRaining() && !(world instanceof Level _lvl && _lvl.isDay())) {
			if (SkellyAndBonesModVariables.WorldVariables.get(world).SkellySpawnTimer == 0) {
				SkellyAndBonesModVariables.WorldVariables.get(world).SkellySpawnTimer = 3000;
				SkellyAndBonesModVariables.WorldVariables.get(world).syncData(world);
			} else if (SkellyAndBonesModVariables.WorldVariables.get(world).SkellySpawnTimer > 0) {
				SkellyAndBonesModVariables.WorldVariables.get(world).SkellySpawnTimer = SkellyAndBonesModVariables.WorldVariables.get(world).SkellySpawnTimer - 1;
				SkellyAndBonesModVariables.WorldVariables.get(world).syncData(world);
			}
			if (SkellyAndBonesModVariables.WorldVariables.get(world).SkellySpawnTimer == 20) {
				SkellyAndBonesModVariables.WorldVariables.get(world).SkellySpawnNumber = 1;
				SkellyAndBonesModVariables.WorldVariables.get(world).syncData(world);
			} else if (SkellyAndBonesModVariables.WorldVariables.get(world).SkellySpawnTimer == 0 || SkellyAndBonesModVariables.WorldVariables.get(world).SkellySpawnTimer > 20) {
				SkellyAndBonesModVariables.WorldVariables.get(world).SkellySpawnNumber = 0;
				SkellyAndBonesModVariables.WorldVariables.get(world).syncData(world);
			}
		}
	}
}
