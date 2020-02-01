package com.bteteam.bte.client.model;

import com.bteteam.bte.entity.PigeonEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;

/**
 * Infernal Blacksmith - Igrek02
 * Created using Tabula 6.0.0
 */
public class Pigeon extends BipedModel<PigeonEntity> {
	public RendererModel body;
	public RendererModel head;
	public RendererModel tail1;
	public RendererModel wing;
	public RendererModel wing_1;
	public RendererModel shape25;
	public RendererModel shape25_1;
	public RendererModel beak;
	public RendererModel crest;
	public RendererModel tailjoint;
	public RendererModel back_feather;
	public RendererModel wing_extension;
	public RendererModel wing_extension_1;

	public Pigeon() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.head = new RendererModel(this, 0, 0);
		this.head.setRotationPoint(0.1F, 1.6F, -4.0F);
		this.head.addBox(-2.0F, -10.0F, -3.0F, 4, 10, 4, 0.0F);
		this.shape25 = new RendererModel(this, 40, 24);
		this.shape25.setRotationPoint(1.5F, 0.0F, 0.0F);
		this.shape25.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 2, 0.0F);
		this.wing_1 = new RendererModel(this, 43, 0);
		this.wing_1.mirror = true;
		this.wing_1.setRotationPoint(-3.0F, -3.0F, -1.0F);
		this.wing_1.addBox(-1.0F, 0.0F, -3.0F, 1, 5, 6, 0.0F);
		this.shape25_1 = new RendererModel(this, 40, 24);
		this.shape25_1.mirror = true;
		this.shape25_1.setRotationPoint(-1.5F, 0.0F, 0.0F);
		this.shape25_1.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 2, 0.0F);
		this.beak = new RendererModel(this, 0, 16);
		this.beak.setRotationPoint(0.0F, -5.0F, -5.0F);
		this.beak.addBox(-1.0F, -3.0F, 0.0F, 2, 1, 2, 0.0F);
		this.back_feather = new RendererModel(this, 0, 22);
		this.back_feather.setRotationPoint(0.0F, -1.0F, 2.0F);
		this.back_feather.addBox(-4.0F, 0.0F, 0.0F, 8, 1, 9, 0.0F);
		this.setRotateAngle(back_feather, 0.5009094953223726F, 0.0F, 0.0F);
		this.crest = new RendererModel(this, 0, 20);
		this.crest.setRotationPoint(0.0F, -3.0F, 2.0F);
		this.crest.addBox(-0.5F, -1.0F, -1.0F, 1, 1, 2, 0.0F);
		this.wing_extension_1 = new RendererModel(this, 43, 11);
		this.wing_extension_1.mirror = true;
		this.wing_extension_1.setRotationPoint(0.1F, 5.0F, -3.0F);
		this.wing_extension_1.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 5, 0.0F);
		this.setRotateAngle(wing_extension_1, 1.5707963267948966F, 0.0F, 0.0F);
		this.tail1 = new RendererModel(this, 21, 14);
		this.tail1.setRotationPoint(0.0F, -1.9F, 0.8F);
		this.tail1.addBox(-2.5F, -2.0F, 0.0F, 5, 4, 3, 0.0F);
		this.setRotateAngle(tail1, -0.5918411493512771F, 0.0F, 0.0F);
		this.wing = new RendererModel(this, 43, 0);
		this.wing.setRotationPoint(3.0F, -3.0F, -1.0F);
		this.wing.addBox(0.0F, 0.0F, -3.0F, 1, 5, 6, 0.0F);
		this.tailjoint = new RendererModel(this, 0, 0);
		this.tailjoint.setRotationPoint(0.0F, 0.2F, 0.0F);
		this.tailjoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tailjoint, 0.36425021489121656F, 0.0F, 0.0F);
		this.body = new RendererModel(this, 17, 0);
		this.body.setRotationPoint(0.0F, 18.0F, 0.0F);
		this.body.addBox(-3.0F, -4.0F, -4.0F, 6, 6, 6, 0.0F);
		this.wing_extension = new RendererModel(this, 43, 11);
		this.wing_extension.setRotationPoint(0.9F, 5.0F, -3.0F);
		this.wing_extension.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 5, 0.0F);
		this.setRotateAngle(wing_extension, 1.5707963267948966F, 0.0F, 0.0F);
		this.body.addChild(this.head);
		this.body.addChild(this.shape25);
		this.body.addChild(this.wing_1);
		this.body.addChild(this.shape25_1);
		this.head.addChild(this.beak);
		this.tail1.addChild(this.back_feather);
		this.beak.addChild(this.crest);
		this.wing_1.addChild(this.wing_extension_1);
		this.body.addChild(this.tail1);
		this.body.addChild(this.wing);
		this.tail1.addChild(this.tailjoint);
		this.wing.addChild(this.wing_extension);
	}

	@Override
	public void render(PigeonEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
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
}
