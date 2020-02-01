package com.bteteam.bte.client;

import com.bteteam.bte.blocks.tileentities.TileEntityInfernalForge;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class RenderInfernalForge extends TileEntityRenderer<TileEntityInfernalForge> {

	@Override
	public void render(TileEntityInfernalForge te, double x, double y, double z, float partialTicks, int destroyStage) {
		if (!te.getStackHandler().getStackInSlot(0).isEmpty()) {
			ItemStack item = te.getStackHandler().getStackInSlot(0);
			Minecraft mc = Minecraft.getInstance();
			GlStateManager.enableRescaleNormal();
			GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1f);
			GlStateManager.enableBlend();
			RenderHelper.enableStandardItemLighting();
			GlStateManager.pushMatrix();
			GlStateManager.translated(x + 0.5, y + 0.6, z + 0.5);
			IBakedModel ibakedmodel = mc.getItemRenderer().getItemModelWithOverrides(item, te.getWorld(), null);
			IBakedModel transformedModel = net.minecraftforge.client.ForgeHooksClient.handleCameraTransforms(ibakedmodel, ItemCameraTransforms.TransformType.GROUND, false);
			mc.getItemRenderer().renderItem(item, transformedModel);
			GlStateManager.popMatrix();
			GlStateManager.disableBlend();
		}
	}
}
