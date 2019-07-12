package assets.bte.textures.grpgen;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * GrowthGenerator - Igrek02
 * Created using Tabula 6.0.0
 */
public class GrowthGenerator extends ModelBase {
    public ModelRenderer base;
    public ModelRenderer leg1;
    public ModelRenderer leg3;
    public ModelRenderer leg2;
    public ModelRenderer leg2_1;
    public ModelRenderer core;
    public ModelRenderer top;
    public ModelRenderer piston;
    public ModelRenderer pillar1;
    public ModelRenderer pillar2;
    public ModelRenderer pillar3;
    public ModelRenderer pillar4;

    public GrowthGenerator() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.leg1 = new ModelRenderer(this, 0, 0);
        this.leg1.setRotationPoint(5.6F, 3.0F, -5.6F);
        this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
        this.core = new ModelRenderer(this, 0, 34);
        this.core.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.core.addBox(-4.0F, -9.0F, -4.0F, 8, 9, 8, 0.0F);
        this.leg2 = new ModelRenderer(this, 0, 0);
        this.leg2.setRotationPoint(-5.6F, 3.0F, -5.6F);
        this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
        this.pillar1 = new ModelRenderer(this, 55, 0);
        this.pillar1.setRotationPoint(7.3F, 9.9F, 7.3F);
        this.pillar1.addBox(-0.5F, -10.1F, -1.2F, 1, 12, 1, 0.0F);
        this.setRotateAngle(pillar1, 0.3141592653589793F, 0.7853981633974483F, 0.0F);
        this.leg2_1 = new ModelRenderer(this, 0, 0);
        this.leg2_1.setRotationPoint(-5.6F, 3.0F, 5.6F);
        this.leg2_1.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
        this.pillar2 = new ModelRenderer(this, 55, 0);
        this.pillar2.setRotationPoint(-7.3F, 9.9F, 7.3F);
        this.pillar2.addBox(-0.5F, -10.1F, -1.2F, 1, 12, 1, 0.0F);
        this.setRotateAngle(pillar2, 0.3141592653589793F, -0.7853981633974483F, 0.0F);
        this.pillar3 = new ModelRenderer(this, 55, 0);
        this.pillar3.setRotationPoint(7.3F, 9.9F, -7.3F);
        this.pillar3.addBox(-0.5F, -10.1F, -1.2F, 1, 12, 1, 0.0F);
        this.setRotateAngle(pillar3, 0.3141592653589793F, 2.356194490192345F, 0.0F);
        this.piston = new ModelRenderer(this, 3, 52);
        this.piston.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.piston.addBox(-5.0F, -1.0F, -5.0F, 10, 2, 10, 0.0F);
        this.top = new ModelRenderer(this, 12, 19);
        this.top.setRotationPoint(0.0F, -10.0F, 0.0F);
        this.top.addBox(-6.0F, 0.0F, -6.0F, 12, 1, 12, 0.0F);
        this.pillar4 = new ModelRenderer(this, 55, 0);
        this.pillar4.setRotationPoint(-7.3F, 9.9F, -7.3F);
        this.pillar4.addBox(-0.5F, -10.1F, -1.2F, 1, 12, 1, 0.0F);
        this.setRotateAngle(pillar4, 0.3141592653589793F, -2.356194490192345F, 0.0F);
        this.base = new ModelRenderer(this, 0, 0);
        this.base.setRotationPoint(0.0F, 17.0F, 0.0F);
        this.base.addBox(-8.0F, 0.0F, -8.1F, 16, 3, 16, 0.0F);
        this.leg3 = new ModelRenderer(this, 0, 0);
        this.leg3.setRotationPoint(5.6F, 3.0F, 5.6F);
        this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
        this.base.addChild(this.leg1);
        this.base.addChild(this.core);
        this.base.addChild(this.leg2);
        this.top.addChild(this.pillar1);
        this.base.addChild(this.leg2_1);
        this.top.addChild(this.pillar2);
        this.top.addChild(this.pillar3);
        this.core.addChild(this.piston);
        this.core.addChild(this.top);
        this.top.addChild(this.pillar4);
        this.base.addChild(this.leg3);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.base.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
