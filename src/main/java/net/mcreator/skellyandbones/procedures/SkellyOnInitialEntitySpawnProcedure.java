package net.mcreator.skellyandbones.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class SkellyOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double spawnx = 0;
		double spawnz = 0;
		double spawny = 0;
		double tradeNumber = 0;
		double randomNumber = 0;
		double randomAmount = 0;
		File skellyandbones = new File("");
		com.google.gson.JsonObject skellyandbonejson = new com.google.gson.JsonObject();
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
				if (skellyandbonejson.get("spawning_sound").getAsBoolean() == true) {
					if (world.getLevelData().isRaining() && !(world instanceof Level _lvl && _lvl.isDay())) {
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private LevelAccessor world;

							public void start(LevelAccessor world, int waitTicks) {
								this.waitTicks = waitTicks;
								MinecraftForge.EVENT_BUS.register(this);
								this.world = world;
							}

							@SubscribeEvent
							public void tick(TickEvent.ServerTickEvent event) {
								if (event.phase == TickEvent.Phase.END) {
									this.ticks += 1;
									if (this.ticks >= this.waitTicks)
										run();
								}
							}

							private void run() {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("skelly_and_bones:skellyandbones")), SoundSource.RECORDS, 30, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("skelly_and_bones:skellyandbones")), SoundSource.RECORDS, 30, 1, false);
									}
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, 1);
					}
				}
				if (skellyandbonejson.get("spawning_message").getAsBoolean() == true) {
					if (world.getLevelData().isRaining() && !(world instanceof Level _lvl && _lvl.isDay())) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @a {\"text\":\"It was a dark and stormy night.\",\"color\":\"#693F3F\"}");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
