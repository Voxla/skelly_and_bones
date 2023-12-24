package net.mcreator.skellyandbones.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.skellyandbones.network.SkellyAndBonesModVariables;

public class SkellyspawntimestProcedure {
	public static void execute(LevelAccessor world) {
		SkellyAndBonesModVariables.WorldVariables.get(world).SkellySpawnTimer = 100;
		SkellyAndBonesModVariables.WorldVariables.get(world).syncData(world);
	}
}
