package bte.client.renders;

import bte.client.models.HorseshoeCrab;
import bte.client.models.Tortoise;
import bte.entity.animal.AnimalHorseshoeCrab;
import bte.entity.animal.AnimalTortoise;
import bte.entity.utilitymobs.EntityBlacksmith;
import bte.util.helpers.StringHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHorseshoeCrab extends RenderLiving<AnimalHorseshoeCrab> {

	private ResourceLocation TEXTURE
    = new ResourceLocation(StringHelper.GRS("textures/horseshoecrab/horseshoecrab-texturemap.png"));
	
	public RenderHorseshoeCrab(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new HorseshoeCrab(), 0.5f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(AnimalHorseshoeCrab entity) {
		return TEXTURE;
	}
	
	public static class Factory implements IRenderFactory<AnimalHorseshoeCrab> {

        @Override
        public Render<? super AnimalHorseshoeCrab> createRenderFor(RenderManager manager) {
            return new RenderHorseshoeCrab(manager);
        }
    }
}
