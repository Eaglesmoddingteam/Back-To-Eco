package bte.client.renders;

import bte.client.models.InfernalBlacksmith;
import bte.entity.utilitymobs.EntityBlacksmith;
import bte.util.helpers.StringHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderInfernalBlacksmith extends RenderLiving<EntityBlacksmith> {

    private ResourceLocation TEXTURE
            = new ResourceLocation(StringHelper.GRS("textures/blacksmith/infernal_blacksmith.png"));

    public RenderInfernalBlacksmith(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new InfernalBlacksmith(), 0.5F);
    }

    @Override
    public void doRender(EntityBlacksmith entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBlacksmith entity) {
        return TEXTURE;
    }

    public static class Factory implements IRenderFactory<EntityBlacksmith> {

        @Override
        public Render<? super EntityBlacksmith> createRenderFor(RenderManager manager) {
            return new RenderInfernalBlacksmith(manager);
        }
    }
}
