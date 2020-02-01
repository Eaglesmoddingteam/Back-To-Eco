package com.bteteam.bte.client.model;

import com.bteteam.bte.entity.InfernalBlackSmithEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

/**
 * Infernal Blacksmith - Igrek02
 * Created using Tabula 6.0.0
 */
public class InfernalBlacksmith extends BipedModel<InfernalBlackSmithEntity> {
	public RendererModel body;
	public RendererModel leg1;
	public RendererModel leg2;
	public RendererModel neck;
	public RendererModel arm1;
	public RendererModel arm2;
	public RendererModel head;
	public RendererModel jaw;
	public RendererModel eyebrow1;
	public RendererModel eyebrow2;
	public RendererModel shape12;
	public RendererModel horn1;
	public RendererModel horn2;
	public RendererModel beard;
	public RendererModel horntop1;
	public RendererModel horntoptop1;
	public RendererModel horntop2;
	public RendererModel horntoptop2;

	public InfernalBlacksmith() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.body = new RendererModel(this, 0, 36);
		this.body.setRotationPoint(0.0F, 11.5F, 0.0F);
		this.body.addBox(-4.5F, -4.0F, -2.5F, 9, 12, 5, 0.0F);
		this.setRotateAngle(body, -0.136659280431156F, 0.0F, 0.0F);
		this.beard = new RendererModel(this, 24, 0);
		this.beard.setRotationPoint(0.0F, 2.1F, -3.0F);
		this.beard.addBox(-2.0F, 0.0F, -2.0F, 4, 3, 3, 0.0F);
		this.setRotateAngle(beard, -0.18203784098300857F, 0.0F, 0.0F);
		this.eyebrow2 = new RendererModel(this, 31, 10);
		this.eyebrow2.mirror = true;
		this.eyebrow2.setRotationPoint(-1.4F, -1.3F, -2.6F);
		this.eyebrow2.addBox(-2.2F, -1.0F, -1.0F, 3, 2, 2, 0.0F);
		this.setRotateAngle(eyebrow2, 0.0F, 0.0F, 0.136659280431156F);
		this.horn2 = new RendererModel(this, 45, 13);
		this.horn2.mirror = true;
		this.horn2.setRotationPoint(-1.2F, -1.5F, -0.7F);
		this.horn2.addBox(-1.0F, -4.7F, -1.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(horn2, -0.4553564018453205F, 0.0F, -0.40980330836826856F);
		this.horn1 = new RendererModel(this, 45, 13);
		this.horn1.setRotationPoint(1.2F, -1.5F, -0.7F);
		this.horn1.addBox(-1.0F, -4.7F, -1.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(horn1, -0.4553564018453205F, 0.0F, 0.40980330836826856F);
		this.jaw = new RendererModel(this, 0, 12);
		this.jaw.setRotationPoint(0.0F, 1.6F, 1.05F);
		this.jaw.addBox(-3.5F, -1.0F, -5.0F, 7, 4, 6, 0.0F);
		this.setRotateAngle(jaw, 0.045553093477052F, 0.0F, 0.0F);
		this.leg1 = new RendererModel(this, 5, 54);
		this.leg1.setRotationPoint(2.1F, 6.7F, -0.3F);
		this.leg1.addBox(-1.0F, 0.0F, -1.0F, 3, 6, 2, 0.0F);
		this.setRotateAngle(leg1, 0.24260076602721178F, 0.0F, 0.091106186954104F);
		this.horntop2 = new RendererModel(this, 45, 22);
		this.horntop2.mirror = true;
		this.horntop2.setRotationPoint(0.0F, -4.0F, -0.3F);
		this.horntop2.addBox(-1.0F, -4.0F, -1.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(horntop2, -0.8196066167365371F, 0.0F, -0.2617993877991494F);
		this.leg2 = new RendererModel(this, 5, 54);
		this.leg2.mirror = true;
		this.leg2.setRotationPoint(-2.1F, 6.7F, -0.3F);
		this.leg2.addBox(-2.0F, 0.0F, -1.0F, 3, 6, 2, 0.0F);
		this.setRotateAngle(leg2, 0.24260076602721178F, 0.0F, -0.08726646259971647F);
		this.head = new RendererModel(this, 0, 0);
		this.head.setRotationPoint(0.0F, -1.7F, -3.4F);
		this.head.addBox(-3.0F, -2.8F, -3.0F, 6, 4, 5, 0.0F);
		this.setRotateAngle(head, 0.5462880558742251F, 0.0F, 0.0F);
		this.horntoptop2 = new RendererModel(this, 45, 31);
		this.horntoptop2.mirror = true;
		this.horntoptop2.setRotationPoint(0.1F, -3.4F, -0.3F);
		this.horntoptop2.addBox(-0.5F, -3.0F, 0.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(horntoptop2, 0.8196066167365371F, 0.0F, 0.0F);
		this.eyebrow1 = new RendererModel(this, 31, 10);
		this.eyebrow1.setRotationPoint(1.4F, -1.3F, -2.6F);
		this.eyebrow1.addBox(-0.8F, -1.0F, -1.0F, 3, 2, 2, 0.0F);
		this.setRotateAngle(eyebrow1, 0.0F, 0.0F, -0.136659280431156F);
		this.shape12 = new RendererModel(this, 43, 0);
		this.shape12.setRotationPoint(0.0F, 1.0F, -2.5F);
		this.shape12.addBox(-1.5F, -1.0F, -1.0F, 3, 1, 1, 0.0F);
		this.setRotateAngle(shape12, 0.091106186954104F, 0.0F, 0.0F);
		this.neck = new RendererModel(this, 0, 26);
		this.neck.setRotationPoint(0.0F, -1.3F, -0.2F);
		this.neck.addBox(-3.0F, -3.5F, -2.4F, 6, 4, 3, 0.0F);
		this.setRotateAngle(neck, -0.5009094953223726F, 0.0F, 0.0F);
		this.arm1 = new RendererModel(this, 29, 40);
		this.arm1.setRotationPoint(3.8F, -2.2F, 0.0F);
		this.arm1.addBox(0.0F, -1.2F, -1.5F, 3, 10, 3, 0.0F);
		this.setRotateAngle(arm1, 0.136659280431156F, 0.0F, -0.136659280431156F);
		this.arm2 = new RendererModel(this, 29, 40);
		this.arm2.mirror = true;
		this.arm2.setRotationPoint(-3.8F, -2.2F, 0.0F);
		this.arm2.addBox(-3.0F, -1.2F, -1.5F, 3, 10, 3, 0.0F);
		this.setRotateAngle(arm2, 0.136659280431156F, 0.0F, 0.136659280431156F);
		this.horntoptop1 = new RendererModel(this, 45, 31);
		this.horntoptop1.setRotationPoint(0.1F, -3.4F, -0.3F);
		this.horntoptop1.addBox(-0.5F, -3.0F, 0.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(horntoptop1, 0.8196066167365371F, 0.0F, 0.0F);
		this.horntop1 = new RendererModel(this, 45, 22);
		this.horntop1.setRotationPoint(0.0F, -4.0F, -0.3F);
		this.horntop1.addBox(-1.0F, -4.0F, -1.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(horntop1, -0.8196066167365371F, 0.0F, 0.2617993877991494F);
		this.jaw.addChild(this.beard);
		this.head.addChild(this.eyebrow2);
		this.head.addChild(this.horn2);
		this.head.addChild(this.horn1);
		this.head.addChild(this.jaw);
		this.body.addChild(this.leg1);
		this.horn2.addChild(this.horntop2);
		this.body.addChild(this.leg2);
		this.neck.addChild(this.head);
		this.horntop2.addChild(this.horntoptop2);
		this.head.addChild(this.eyebrow1);
		this.head.addChild(this.shape12);
		this.body.addChild(this.neck);
		this.body.addChild(this.arm1);
		this.body.addChild(this.arm2);
		this.horntop1.addChild(this.horntoptop1);
		this.horn1.addChild(this.horntop1);
	}

	@Override
	public void render(InfernalBlackSmithEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.body.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(InfernalBlackSmithEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
		this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.neck.rotateAngleY = netHeadYaw * (float) (Math.PI / 180F);
		this.neck.rotateAngleX = (headPitch - 20) * (float) (Math.PI / 180F);
	}
}
