// Date: 09.04.2017 09:57:49
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.minecraft.src;

public class ModelHiena extends ModelBase
{
  //fields
    ModelRenderer WolfHead;
    ModelRenderer Body;
    ModelRenderer Mane;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Tail;
    ModelRenderer Ear1;
    ModelRenderer Ear2;
    ModelRenderer Nose;
  
  public ModelHiena()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      WolfHead = new ModelRenderer(this, 0, 0);
      WolfHead.addBox(-3F, -3F, -2F, 6, 6, 5);
      WolfHead.setRotationPoint(-1F, 12.5F, -8F);
      WolfHead.setTextureSize(128, 128);
      WolfHead.mirror = true;
      setRotation(WolfHead, 0F, 0F, 0F);
      Body = new ModelRenderer(this, 18, 15);
      Body.addBox(-4F, -2F, -3F, 6, 9, 6);
      Body.setRotationPoint(0F, 14F, 2F);
      Body.setTextureSize(128, 128);
      Body.mirror = true;
      setRotation(Body, 1.570796F, 0F, 0F);
      Mane = new ModelRenderer(this, 24, 0);
      Mane.addBox(-4F, -3F, -3F, 8, 7, 7);
      Mane.setRotationPoint(-1F, 14F, -3F);
      Mane.setTextureSize(128, 128);
      Mane.mirror = true;
      setRotation(Mane, 1.37881F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 13, 40);
      Leg1.addBox(-2F, 0F, -1F, 3, 8, 3);
      Leg1.setRotationPoint(-2.2F, 16F, 7F);
      Leg1.setTextureSize(128, 128);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 0, 40);
      Leg2.addBox(-1F, 0F, -1F, 3, 8, 3);
      Leg2.setRotationPoint(0.2F, 16F, 7F);
      Leg2.setTextureSize(128, 128);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg3 = new ModelRenderer(this, 13, 90);
      Leg3.addBox(-2F, 0F, -1F, 3, 8, 3);
      Leg3.setRotationPoint(-2.5F, 16F, -4F);
      Leg3.setTextureSize(128, 128);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      Leg4 = new ModelRenderer(this, 0, 90);
      Leg4.addBox(-1F, 0F, -1F, 3, 8, 3);
      Leg4.setRotationPoint(0.5F, 16F, -4F);
      Leg4.setTextureSize(128, 128);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);
      Tail = new ModelRenderer(this, 9, 18);
      Tail.addBox(-1F, 0F, -1F, 2, 5, 2);
      Tail.setRotationPoint(-1F, 12F, 8F);
      Tail.setTextureSize(128, 128);
      Tail.mirror = true;
      setRotation(Tail, 1.130069F, 0F, 0F);
      Ear1 = new ModelRenderer(this, 87, 14);
      Ear1.addBox(-4F, -5F, 0F, 3, 3, 1);
      Ear1.setRotationPoint(-1F, 12.5F, -7F);
      Ear1.setTextureSize(128, 128);
      Ear1.mirror = true;
      setRotation(Ear1, 0F, 0F, 0F);
      Ear2 = new ModelRenderer(this, 96, 14);
      Ear2.addBox(1F, -5F, 0F, 3, 3, 1);
      Ear2.setRotationPoint(-1F, 12.5F, -7F);
      Ear2.setTextureSize(128, 128);
      Ear2.mirror = true;
      setRotation(Ear2, 0F, 0F, 0F);
      Nose = new ModelRenderer(this, 0, 11);
      Nose.addBox(-2F, 0F, -5F, 3, 3, 4);
      Nose.setRotationPoint(-0.5F, 12.4F, -7F);
      Nose.setTextureSize(128, 128);
      Nose.mirror = true;
      setRotation(Nose, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    WolfHead.render(f5);
    Body.render(f5);
    Mane.render(f5);
    Leg1.render(f5);
    Leg2.render(f5);
    Leg3.render(f5);
    Leg4.render(f5);
    Tail.render(f5);
    Ear1.render(f5);
    Ear2.render(f5);
    Nose.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}
