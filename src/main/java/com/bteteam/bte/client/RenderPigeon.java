package com.bteteam.bte.client;

import com.bteteam.bte.client.model.Pigeon;
import com.bteteam.bte.entity.PigeonEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

import static com.bteteam.bte.Main.MODID;

public class RenderPigeon implements IRenderFactory<PigeonEntity> {


	@Override
	public EntityRenderer<PigeonEntity> createRenderFor(EntityRendererManager manager) {
		return new Render(manager);
	}


	private static class Render extends BipedRenderer<PigeonEntity, Pigeon> {

		private ResourceLocation TEXTURE = new ResourceLocation(MODID, "textures/blacksmith/infernal_blacksmith.png");

		protected Render(EntityRendererManager renderManager) {
			super(renderManager, new Pigeon(), 0.25F);
		}

		@Nullable
		@Override
		protected ResourceLocation getEntityTexture(PigeonEntity entity) {
			return TEXTURE;
		}


	}
}
