package bte.util.helpers;

import bte.main.Vars;

public class StringHelper {

	/**
	 * gets string for resourcelocation
	 * @param params
	 * @return
	 */
	public static String GRS(String params) {
		return Vars.MOD_ID + ":" + params;
	}
}
