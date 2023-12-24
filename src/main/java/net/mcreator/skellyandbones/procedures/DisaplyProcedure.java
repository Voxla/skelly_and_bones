package net.mcreator.skellyandbones.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.skellyandbones.network.SkellyAndBonesModVariables;

public class DisaplyProcedure {
	public static String execute(LevelAccessor world) {
		return new java.text.DecimalFormat("####").format(SkellyAndBonesModVariables.WorldVariables.get(world).SkellySpawnTimer) + "";
	}
}
