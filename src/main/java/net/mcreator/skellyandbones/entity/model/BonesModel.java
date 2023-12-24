package net.mcreator.skellyandbones.entity.model;

import software.bernie.geckolib3.model.provider.data.EntityModelData;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.skellyandbones.entity.BonesEntity;

public class BonesModel extends AnimatedGeoModel<BonesEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(BonesEntity entity) {
		return new ResourceLocation("skelly_and_bones", "animations/bones.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(BonesEntity entity) {
		return new ResourceLocation("skelly_and_bones", "geo/bones.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(BonesEntity entity) {
		return new ResourceLocation("skelly_and_bones", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(BonesEntity animatable, int instanceId, AnimationEvent animationEvent) {
		super.setCustomAnimations(animatable, instanceId, animationEvent);
		IBone head = this.getAnimationProcessor().getBone("head");
		EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
		AnimationData manager = animatable.getFactory().getOrCreateAnimationData(instanceId);
		int unpausedMultiplier = !Minecraft.getInstance().isPaused() || manager.shouldPlayWhilePaused ? 1 : 0;
		head.setRotationX(head.getRotationX() + extraData.headPitch * ((float) Math.PI / 180F) * unpausedMultiplier);
		head.setRotationY(head.getRotationY() + extraData.netHeadYaw * ((float) Math.PI / 180F) * unpausedMultiplier);
	}
}
