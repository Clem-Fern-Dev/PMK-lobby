package fr.mrfern.pumpmylobby.donate;

import org.bukkit.Location;

import com.sainttx.holograms.api.Hologram;
import com.sainttx.holograms.api.HologramManager;

public class DonateBoss {
	
	private static HologramManager holoManager;

	public static void donateEnable(HologramManager hologramManager) {
		holoManager = hologramManager;		
	}
	
	public void createHologram(String id, Location location) {
	    Hologram hologram = new Hologram(id, location);
	    holoManager.addActiveHologram(hologram); // Tells the plugin a new Hologram was added
	}

	public static HologramManager getHoloManager() {
		return holoManager;
	}

	public static void setHoloManager(HologramManager holoManager) {
		DonateBoss.holoManager = holoManager;
	}
}
