package net.mcreator.skellyandbones.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SkellyAndBonesConfigProcedure {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		com.google.gson.JsonObject skellyandbonejson = new com.google.gson.JsonObject();
		File skellyandbones = new File("");
		skellyandbones = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "skellyandbonesconfig.json");
		if (!skellyandbones.exists()) {
			try {
				skellyandbones.getParentFile().mkdirs();
				skellyandbones.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			skellyandbonejson.addProperty("dialogue_when_close", true);
			skellyandbonejson.addProperty("spawning_sound", true);
			skellyandbonejson.addProperty("spawning_message", true);
			skellyandbonejson.addProperty("spawn_bones_around_skelly_only_when_raining_and_night", false);
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(skellyandbones);
					fileWriter.write(mainGSONBuilderVariable.toJson(skellyandbonejson));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}
