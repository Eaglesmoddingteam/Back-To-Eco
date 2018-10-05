package centrifuge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * centrifuge - Igrek02
 * Created using Tabula 6.0.0
 */
public class centrifuge extends ModelBase {
    public ModelRenderer couldron;
    public ModelRenderer leg;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer bottom;
    public ModelRenderer top;
    public ModelRenderer port2;
    public ModelRenderer port3;
    public ModelRenderer port4;
    public ModelRenderer port;

    public centrifuge() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.port3 = new ModelRenderer(this, 0, 0);
        this.port3.setRotationPoint(7.5F, -9.2F, 0.0F);
        this.port3.addBox(-2.5F, -2.5F, -0.5F, 5, 5, 1, 0.0F);
        this.setRotateAngle(port3, 0.0F, 1.5707963267948966F, 0.0F);
        this.port4 = new ModelRenderer(this, 0, 0);
        this.port4.setRotationPoint(-7.5F, -9.2F, 0.0F);
        this.port4.addBox(-2.5F, -2.5F, -0.5F, 5, 5, 1, 0.0F);
        this.setRotateAngle(port4, 0.0F, 1.5707963267948966F, 0.0F);
        this.leg2 = new ModelRenderer(this, 0, 30);
        this.leg2.setRotationPoint(5.5F, -2.0F, -5.5F);
        this.leg2.addBox(-1.5F, 0.0F, -1.5F, 3, 1, 3, 0.0F);
        this.leg4 = new ModelRenderer(this, 0, 30);
        this.leg4.setRotationPoint(-5.5F, -2.0F, 5.5F);
        this.leg4.addBox(-1.5F, 0.0F, -1.5F, 3, 1, 3, 0.0F);
        this.bottom = new ModelRenderer(this, 0, 35);
        this.bottom.setRotationPoint(0.0F, -5.3F, 0.0F);
        this.bottom.addBox(-8.0F, 0.0F, -8.0F, 16, 3, 16, 0.0F);
        this.port = new ModelRenderer(this, 0, 0);
        this.port.setRotationPoint(0.0F, -9.2F, 7.5F);
        this.port.addBox(-2.5F, -2.5F, -0.5F, 5, 5, 1, 0.0F);
        this.leg = new ModelRenderer(this, 0, 30);
        this.leg.setRotationPoint(5.5F, -2.0F, 5.5F);
        this.leg.addBox(-1.5F, 0.0F, -1.5F, 3, 1, 3, 0.0F);
        this.port2 = new ModelRenderer(this, 0, 0);
        this.port2.setRotationPoint(0.0F, -9.2F, -7.5F);
        this.port2.addBox(-2.5F, -2.5F, -0.5F, 5, 5, 1, 0.0F);
        this.leg3 = new ModelRenderer(this, 0, 30);
        this.leg3.setRotationPoint(-5.5F, -2.0F, -5.5F);
        this.leg3.addBox(-1.5F, 0.0F, -1.5F, 3, 1, 3, 0.0F);
        this.top = new ModelRenderer(this, 0, 35);
        this.top.setRotationPoint(0.0F, -15.5F, 0.0F);
        this.top.addBox(-8.0F, 0.0F, -8.0F, 16, 3, 16, 0.0F);
        this.couldron = new ModelRenderer(this, 0, 0);
        this.couldron.setRotationPoint(0.0F, 25.0F, 0.0F);
        this.couldron.addBox(-7.0F, -14.0F, -7.0F, 14, 12, 14, 0.0F);
        this.couldron.addChild(this.port3);
        this.couldron.addChild(this.port4);
        this.couldron.addChild(this.leg2);
        this.couldron.addChild(this.leg4);
        this.couldron.addChild(this.bottom);
        this.couldron.addChild(this.port);
        this.couldron.addChild(this.leg);
        this.couldron.addChild(this.port2);
        this.couldron.addChild(this.leg3);
        this.couldron.addChild(this.top);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.couldron.render(f5);
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
