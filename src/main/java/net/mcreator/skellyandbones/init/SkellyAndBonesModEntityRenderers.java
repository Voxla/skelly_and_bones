
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.skellyandbones.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.skellyandbones.client.renderer.SkellyRenderer;
import net.mcreator.skellyandbones.client.renderer.BonesRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SkellyAndBonesModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(SkellyAndBonesModEntities.SKELLY.get(), SkellyRenderer::new);
		event.registerEntityRenderer(SkellyAndBonesModEntities.BONES.get(), BonesRenderer::new);
	}
}
