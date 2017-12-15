package bte.util.helpers;

import bte.main.Vars;
import net.minecraft.util.ResourceLocation;

public class StringHelper {

	/**
	 * GetResourcelocation
	 * @param params
	 * @return
	 */
	public static ResourceLocation GR(String params) {
		return new ResourceLocation(Vars.MOD_ID + ":" + params);
	}
	
	/**
	 * GetResourcelocationString
	 * @param params
	 * @return
	 */
	public static String GRS(String params) {
		return Vars.MOD_ID + ":" + params;
	}
}
