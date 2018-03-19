package bte.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * HorseshoeCrab - Igrek02
 * Created using Tabula 6.0.0
 */
public class HorseshoeCrab extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer headadd1;
    public ModelRenderer headadd2;
    public ModelRenderer bodymain;
    public ModelRenderer body2;
    public ModelRenderer bodyup;
    public ModelRenderer tail;

    public HorseshoeCrab() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.bodyup = new ModelRenderer(this, 0, 23);
        this.bodyup.setRotationPoint(0.0F, -0.2F, 0.0F);
        this.bodyup.addBox(-2.0F, -1.0F, 0.0F, 4, 2, 7, 0.0F);
        this.tail = new ModelRenderer(this, 42, 21);
        this.tail.setRotationPoint(0.0F, 0.0F, 6.3F);
        this.tail.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 8, 0.0F);
        this.body2 = new ModelRenderer(this, 23, 19);
        this.body2.setRotationPoint(0.0F, 0.0F, 2.9F);
        this.body2.addBox(-4.0F, -0.4F, 0.0F, 8, 1, 3, 0.0F);
        this.headadd1 = new ModelRenderer(this, 33, 0);
        this.headadd1.mirror = true;
        this.headadd1.setRotationPoint(2.8F, 0.0F, -5.6F);
        this.headadd1.addBox(0.0F, -1.0F, -2.0F, 3, 2, 8, 0.0F);
        this.setRotateAngle(headadd1, 0.0F, 0.18203784098300857F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 22.7F, 0.0F);
        this.head.addBox(-4.0F, -2.0F, -9.0F, 8, 3, 7, 0.0F);
        this.setRotateAngle(head, 0.045553093477052F, 0.0F, 0.0F);
        this.headadd2 = new ModelRenderer(this, 33, 0);
        this.headadd2.setRotationPoint(-2.8F, 0.0F, -5.6F);
        this.headadd2.addBox(-3.0F, -1.0F, -2.0F, 3, 2, 8, 0.0F);
        this.setRotateAngle(headadd2, 0.0F, -0.18203784098300857F, 0.0F);
        this.bodymain = new ModelRenderer(this, 0, 14);
        this.bodymain.setRotationPoint(0.0F, -0.1F, -2.9F);
        this.bodymain.addBox(-4.5F, -0.8F, 0.0F, 9, 2, 3, 0.0F);
        this.setRotateAngle(bodymain, -0.091106186954104F, 0.0F, 0.0F);
        this.bodymain.addChild(this.bodyup);
        this.bodyup.addChild(this.tail);
        this.bodymain.addChild(this.body2);
        this.head.addChild(this.headadd1);
        this.head.addChild(this.headadd2);
        this.head.addChild(this.bodymain);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.head.render(f5);
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
