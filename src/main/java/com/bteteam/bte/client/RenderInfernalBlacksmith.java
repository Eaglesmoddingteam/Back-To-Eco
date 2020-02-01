package com.bteteam.bte.client;

import com.bteteam.bte.client.model.InfernalBlacksmith;
import com.bteteam.bte.entity.InfernalBlackSmithEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

import static com.bteteam.bte.Main.MODID;

public class RenderInfernalBlacksmith implements IRenderFactory<InfernalBlackSmithEntity> {


	@Override
	public EntityRenderer<InfernalBlackSmithEntity> createRenderFor(EntityRendererManager manager) {
		return new Render(manager);
	}


	private static class Render extends BipedRenderer<InfernalBlackSmithEntity, InfernalBlacksmith> {


		private ResourceLocation TEXTURE = new ResourceLocation(MODID, "textures/blacksmith/infernal_blacksmith.png");

		protected Render(EntityRendererManager renderManager) {
			super(renderManager, new InfernalBlacksmith(), 0.5F);
		}

		@Nullable
		@Override
		protected ResourceLocation getEntityTexture(InfernalBlackSmithEntity entity) {
			return TEXTURE;
		}


	}
}
