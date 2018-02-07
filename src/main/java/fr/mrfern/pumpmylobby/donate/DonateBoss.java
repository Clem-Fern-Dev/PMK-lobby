package fr.mrfern.pumpmylobby.donate;

import com.sainttx.holograms.api.HologramManager;

public class DonateBoss {
	
	private static HologramManager holoManager;

	public static void initDonateHolo() {
		// TODO Auto-generated method stub
		
	}

	public static void donateEnable(HologramManager hologramManager) {
		holoManager = hologramManager;		
	}

	public static HologramManager getHoloManager() {
		return holoManager;
	}

	public static void setHoloManager(HologramManager holoManager) {
		DonateBoss.holoManager = holoManager;
	}
}
