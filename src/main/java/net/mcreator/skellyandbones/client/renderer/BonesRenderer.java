
package net.mcreator.skellyandbones.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.skellyandbones.entity.model.BonesModel;
import net.mcreator.skellyandbones.entity.BonesEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BonesRenderer extends GeoEntityRenderer<BonesEntity> {
	public BonesRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new BonesModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(BonesEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(0.995f, 0.995f, 0.995f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
