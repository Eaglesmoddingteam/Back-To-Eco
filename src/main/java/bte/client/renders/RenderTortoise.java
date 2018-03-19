package bte.client.renders;

import bte.client.models.Tortoise;
import bte.entity.animal.AnimalTortoise;
import bte.entity.utilitymobs.EntityBlacksmith;
import bte.util.helpers.StringHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTortoise extends RenderLiving<AnimalTortoise> {

	private ResourceLocation TEXTURE
    = new ResourceLocation(StringHelper.GRS("textures/tortoise/tortoise-texturemap.png"));
	
	public RenderTortoise(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new Tortoise(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(AnimalTortoise entity) {
		return TEXTURE;
	}
	
	public static class Factory implements IRenderFactory<AnimalTortoise> {

        @Override
        public Render<? super AnimalTortoise> createRenderFor(RenderManager manager) {
            return new RenderTortoise(manager);
        }
    }

}
