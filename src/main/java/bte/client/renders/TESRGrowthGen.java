package bte.client.renders;

import bte.client.models.GrowthGenerator;
import bte.objects.blocks.tile.TileGrowthGen;
import bte.util.helpers.StringHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class TESRGrowthGen extends TileEntitySpecialRenderer<TileGrowthGen> {

	@Override
	public void render(TileGrowthGen te, double x, double y, double z, float partialTicks, int destroyStage,
			float alpha) {
		GrowthGenerator model = new GrowthGenerator();
		model.render(null, (float) x, (float)y,(float) z,(float) partialTicks, (float)destroyStage, (float) alpha);
		bindTexture(StringHelper.GR("grpgen/growthgenerator-texturemap"));
		super.render(te, x, y, z, partialTicks, destroyStage, alpha);
	}
	
}
