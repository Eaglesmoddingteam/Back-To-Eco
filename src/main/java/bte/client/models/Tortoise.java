package bte.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * tortoise - Igrek02
 * Created using Tabula 6.0.0
 */
public class Tortoise extends ModelBase {
    public ModelRenderer shell;
    public ModelRenderer shellbase;
    public ModelRenderer neckjoint;
    public ModelRenderer tail;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer neck;
    public ModelRenderer head;

    public Tortoise() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shellbase = new ModelRenderer(this, 14, 0);
        this.shellbase.setRotationPoint(0.0F, -0.4F, 0.0F);
        this.shellbase.addBox(-6.0F, -1.0F, -6.0F, 12, 1, 12, 0.0F);
        this.tail = new ModelRenderer(this, 52, 0);
        this.tail.setRotationPoint(0.0F, -0.1F, 5.0F);
        this.tail.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(tail, -0.36425021489121656F, 0.0F, 0.0F);
        this.neckjoint = new ModelRenderer(this, 0, 18);
        this.neckjoint.setRotationPoint(0.0F, -0.2F, -3.8F);
        this.neckjoint.addBox(-1.0F, -1.0F, -3.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(neckjoint, 0.22759093446006054F, 0.0F, 0.0F);
        this.leg2 = new ModelRenderer(this, 40, 16);
        this.leg2.setRotationPoint(-4.4F, 0.4F, -3.4F);
        this.leg2.addBox(-2.0F, 0.0F, -0.8F, 2, 4, 2, 0.0F);
        this.setRotateAngle(leg2, 0.0F, 0.0F, 0.27314402793711257F);
        this.shell = new ModelRenderer(this, 3, 15);
        this.shell.setRotationPoint(0.0F, 20.3F, 0.0F);
        this.shell.addBox(-5.0F, -6.0F, -5.0F, 10, 7, 10, 0.0F);
        this.leg3 = new ModelRenderer(this, 40, 16);
        this.leg3.mirror = true;
        this.leg3.setRotationPoint(4.4F, 0.4F, 3.4F);
        this.leg3.addBox(0.0F, 0.0F, -0.8F, 2, 4, 2, 0.0F);
        this.setRotateAngle(leg3, 0.0F, 0.0F, -0.27314402793711257F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -5.0F, -0.5F);
        this.head.addBox(-2.3F, -3.0F, -2.3F, 4, 3, 4, 0.0F);
        this.setRotateAngle(head, 0.0F, -0.7853981633974483F, 0.0F);
        this.leg4 = new ModelRenderer(this, 40, 16);
        this.leg4.setRotationPoint(-4.4F, 0.4F, 3.4F);
        this.leg4.addBox(-2.0F, 0.0F, -0.8F, 2, 4, 2, 0.0F);
        this.setRotateAngle(leg4, 0.0F, 0.0F, 0.27314402793711257F);
        this.neck = new ModelRenderer(this, 0, 7);
        this.neck.setRotationPoint(0.0F, -0.07F, -3.5F);
        this.neck.addBox(-1.5F, -5.0F, -1.5F, 3, 6, 3, 0.0F);
        this.setRotateAngle(neck, -0.136659280431156F, 0.0F, 0.0F);
        this.leg1 = new ModelRenderer(this, 40, 16);
        this.leg1.mirror = true;
        this.leg1.setRotationPoint(4.4F, 0.4F, -3.4F);
        this.leg1.addBox(0.0F, 0.0F, -0.8F, 2, 4, 2, 0.0F);
        this.setRotateAngle(leg1, 0.0F, 0.0F, -0.27314402793711257F);
        this.shell.addChild(this.shellbase);
        this.shell.addChild(this.tail);
        this.shell.addChild(this.neckjoint);
        this.shellbase.addChild(this.leg2);
        this.shellbase.addChild(this.leg3);
        this.neck.addChild(this.head);
        this.shellbase.addChild(this.leg4);
        this.neckjoint.addChild(this.neck);
        this.shellbase.addChild(this.leg1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shell.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
    		float headPitch, float scaleFactor, Entity entityIn) {
    	super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 3.4F * limbSwingAmount;
        this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 3.4F * limbSwingAmount;
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 3.4F * limbSwingAmount;
        this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 3.4F * limbSwingAmount;
    }
}
