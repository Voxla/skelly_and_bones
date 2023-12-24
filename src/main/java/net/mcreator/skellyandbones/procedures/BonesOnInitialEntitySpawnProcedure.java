package net.mcreator.skellyandbones.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class BonesOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double tradeNumber = 0;
		double randomNumber = 0;
		double randomAmount = 0;
		tradeNumber = 1;
		for (int index0 = 0; index0 < 3; index0++) {
			if (!world.isClientSide()) {
				randomNumber = Math.random();
			}
			if (randomNumber >= 0.83) {
				entity.getPersistentData().putDouble(("tradeItem" + new java.text.DecimalFormat("##").format(tradeNumber)), 1);
			} else if (randomNumber >= 0.664) {
				entity.getPersistentData().putDouble(("tradeItem" + new java.text.DecimalFormat("##").format(tradeNumber)), 2);
			} else if (randomNumber >= 0.498) {
				entity.getPersistentData().putDouble(("tradeItem" + new java.text.DecimalFormat("##").format(tradeNumber)), 3);
			} else if (randomNumber >= 0.332) {
				entity.getPersistentData().putDouble(("tradeItem" + new java.text.DecimalFormat("##").format(tradeNumber)), 4);
			} else if (randomNumber >= 0.166) {
				entity.getPersistentData().putDouble(("tradeItem" + new java.text.DecimalFormat("##").format(tradeNumber)), 5);
			} else if (randomNumber >= 0) {
				entity.getPersistentData().putDouble(("tradeItem" + new java.text.DecimalFormat("##").format(tradeNumber)), 6);
			}
			if (!world.isClientSide()) {
				randomNumber = Math.random();
			}
			tradeNumber = tradeNumber + 1;
		}
	}
}
