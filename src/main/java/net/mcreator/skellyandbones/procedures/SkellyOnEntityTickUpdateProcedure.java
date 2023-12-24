package net.mcreator.skellyandbones.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.skellyandbones.network.SkellyAndBonesModVariables;
import net.mcreator.skellyandbones.init.SkellyAndBonesModEntities;
import net.mcreator.skellyandbones.entity.BonesEntity;

import java.util.Random;
import java.util.Comparator;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class SkellyOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double spawnx = 0;
		double spawnz = 0;
		double spawny = 0;
		File skellyandbones = new File("");
		com.google.gson.JsonObject skellyandbonejson = new com.google.gson.JsonObject();
		if (!world.getEntitiesOfClass(BonesEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty()) {
			if ((((Entity) world.getEntitiesOfClass(BonesEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 20) {
				if (entity instanceof Mob _entity && (((Entity) world.getEntitiesOfClass(BonesEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _ent)
					_entity.setTarget(_ent);
			}
		}
		skellyandbones = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "skellyandbonesconfig.json");
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(skellyandbones));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				skellyandbonejson = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (skellyandbonejson.get("spawn_bones_around_skelly_only_when_raining_and_night").getAsBoolean() == false) {
					if (entity.getPersistentData().getDouble("BonesSpawn") == 1 || entity.getPersistentData().getDouble("BonesSpawn") == 2 || entity.getPersistentData().getDouble("BonesSpawn") == 3
							|| entity.getPersistentData().getDouble("BonesSpawn") == 4 || entity.getPersistentData().getDouble("BonesSpawn") == 5 || entity.getPersistentData().getDouble("BonesSpawn") == 6
							|| entity.getPersistentData().getDouble("BonesSpawn") == 7 || entity.getPersistentData().getDouble("BonesSpawn") == 8 || entity.getPersistentData().getDouble("BonesSpawn") == 9
							|| entity.getPersistentData().getDouble("BonesSpawn") == 10) {
						if (!(!world.getEntitiesOfClass(BonesEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())) {
							if (!(!world.getEntitiesOfClass(BonesEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())) {
								spawnx = x + Mth.nextInt(new Random(), -2, 2);
								spawny = y + Mth.nextInt(new Random(), -2, 2);
								spawnz = z + Mth.nextInt(new Random(), -2, 2);
							}
							if (world.isEmptyBlock(new BlockPos(spawnx, spawny + 0, spawnz)) && world.isEmptyBlock(new BlockPos(spawnx, spawny + 2, spawnz)) && !world.isEmptyBlock(new BlockPos(spawnx, spawny - 1, spawnz))) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = new BonesEntity(SkellyAndBonesModEntities.BONES.get(), _level);
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
					if (!(!world.getEntitiesOfClass(BonesEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())) {
						if (entity.getPersistentData().getDouble("BonesSpawn") == 0) {
							entity.getPersistentData().putDouble("BonesSpawn", 100);
						} else if (entity.getPersistentData().getDouble("BonesSpawn") > 0) {
							entity.getPersistentData().putDouble("BonesSpawn", (entity.getPersistentData().getDouble("BonesSpawn") - 1));
						}
					}
					if (!world.getEntitiesOfClass(BonesEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) {
						if (entity.getPersistentData().getDouble("BonesSpawn") > 0) {
							entity.getPersistentData().putDouble("BonesSpawn", 0);
						}
					}
				} else if (skellyandbonejson.get("spawn_bones_around_skelly_only_when_raining_and_night").getAsBoolean() == true) {
					if (world.getLevelData().isRaining() && !(world instanceof Level _lvl && _lvl.isDay())) {
						if (entity.getPersistentData().getDouble("BonesSpawn") == 1 || entity.getPersistentData().getDouble("BonesSpawn") == 2 || entity.getPersistentData().getDouble("BonesSpawn") == 3
								|| entity.getPersistentData().getDouble("BonesSpawn") == 4 || entity.getPersistentData().getDouble("BonesSpawn") == 5 || entity.getPersistentData().getDouble("BonesSpawn") == 6
								|| entity.getPersistentData().getDouble("BonesSpawn") == 7 || entity.getPersistentData().getDouble("BonesSpawn") == 8 || entity.getPersistentData().getDouble("BonesSpawn") == 9
								|| entity.getPersistentData().getDouble("BonesSpawn") == 10) {
							if (!(!world.getEntitiesOfClass(BonesEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())) {
								if (!(!world.getEntitiesOfClass(BonesEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())) {
									spawnx = x + Mth.nextInt(new Random(), -2, 2);
									spawny = y + Mth.nextInt(new Random(), -2, 2);
									spawnz = z + Mth.nextInt(new Random(), -2, 2);
								}
								if (world.isEmptyBlock(new BlockPos(spawnx, spawny + 0, spawnz)) && world.isEmptyBlock(new BlockPos(spawnx, spawny + 2, spawnz)) && !world.isEmptyBlock(new BlockPos(spawnx, spawny - 1, spawnz))) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = new BonesEntity(SkellyAndBonesModEntities.BONES.get(), _level);
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
						if (!(!world.getEntitiesOfClass(BonesEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())) {
							if (entity.getPersistentData().getDouble("BonesSpawn") == 0) {
								entity.getPersistentData().putDouble("BonesSpawn", 100);
							} else if (entity.getPersistentData().getDouble("BonesSpawn") > 0) {
								entity.getPersistentData().putDouble("BonesSpawn", (entity.getPersistentData().getDouble("BonesSpawn") - 1));
							}
						}
						if (!world.getEntitiesOfClass(BonesEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) {
							if (entity.getPersistentData().getDouble("BonesSpawn") > 0) {
								entity.getPersistentData().putDouble("BonesSpawn", 0);
							}
						}
					}
				}
				if (skellyandbonejson.get("dialogue_when_close").getAsBoolean() == true) {
					if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty()) {
						if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 0) {
							SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer = 2000;
							SkellyAndBonesModVariables.WorldVariables.get(world).syncData(world);
						}
						if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer > 1) {
							SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer = SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer - 1;
							SkellyAndBonesModVariables.WorldVariables.get(world).syncData(world);
						}
					}
					if (!(!world.getEntitiesOfClass(BonesEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty())) {
						SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive = 0;
						SkellyAndBonesModVariables.WorldVariables.get(world).syncData(world);
					} else if (!world.getEntitiesOfClass(BonesEntity.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) {
						SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive = 1;
						SkellyAndBonesModVariables.WorldVariables.get(world).syncData(world);
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 0) {
						SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer = 0;
						SkellyAndBonesModVariables.WorldVariables.get(world).syncData(world);
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1900) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Skelly> See? I think he's happy.\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1800) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Skelly> Well, not to tell you to do your job, but a better question might be, Where's the castle?\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1770) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Bones> Oooh, good idea. We know that one.\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1600) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Skelly> It's missing.\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1570) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Bones> Vanished.\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1540) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Skelly> Disappeared without a trace.\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1510) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Bones> Gone with the wind.\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1440) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Skelly> See, we went looking for the prince at the castle, but the castle was missing.\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1410) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Bones> Of course, you already know that.\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1370) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Skelly> And then we were attacked by a bunch of knights.\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1330) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Bones> A knight, actually uhhh, there was only one.\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1300) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Skelly> But he was very effective.\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1270) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Bones> Unpleasant.\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1240) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Skelly> Mean I'd have to say.\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1210) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Bones> Mean? Would you go that far?\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1170) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Skelly> Yeah! When he did the thing with the thing...\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1140) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Bones> Right, right, mean.\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1110) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Bones> I'm good with mean.\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1070) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Skelly> This knight had a voice like thunder.\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1040) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Bones> A sword as fast as lightning.\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 1000) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Skelly> He came at us like a whirlwind!\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 960) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Bones> All in all, we'd have to say...\"");
					}
					if (SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingactive == 1 && SkellyAndBonesModVariables.WorldVariables.get(world).skellyandbonestalkingtimer == 890) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Skelly> It was a dark and stormy night.\"");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a \"<Bones> It was a dark and stormy night.\"");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
