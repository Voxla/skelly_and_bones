package net.mcreator.skellyandbones.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.skellyandbones.network.SkellyAndBonesModVariables;
import net.mcreator.skellyandbones.init.SkellyAndBonesModEntities;
import net.mcreator.skellyandbones.entity.SkellyEntity;

import javax.annotation.Nullable;

import java.util.Random;

@Mod.EventBusSubscriber
public class SkellySpawnProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		double spawnx = 0;
		double spawnz = 0;
		double spawny = 0;
		if (world.getLevelData().isRaining() && !(world instanceof Level _lvl && _lvl.isDay()) && SkellyAndBonesModVariables.WorldVariables.get(world).SkellySpawnNumber == 1) {
			if (!(!world.getEntitiesOfClass(SkellyEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())) {
				spawnx = x + Mth.nextInt(new Random(), -30, 30);
				spawny = y + Mth.nextInt(new Random(), -30, 30);
				spawnz = z + Mth.nextInt(new Random(), -30, 30);
			}
			if (world.isEmptyBlock(new BlockPos(spawnx, spawny + 0, spawnz)) && world.isEmptyBlock(new BlockPos(spawnx, spawny + 2, spawnz)) && !world.isEmptyBlock(new BlockPos(spawnx, spawny - 1, spawnz))) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new SkellyEntity(SkellyAndBonesModEntities.SKELLY.get(), _level);
					entityToSpawn.moveTo(spawnx, spawny, spawnz, 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
