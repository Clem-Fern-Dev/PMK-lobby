package fr.mrfern.pumpmylobby.donate;

import org.bukkit.Location;

import com.sainttx.holograms.api.Hologram;
import com.sainttx.holograms.api.HologramManager;
import com.sainttx.holograms.api.line.HologramLine;
import com.sainttx.holograms.api.line.TextLine;

public class DonateBoss {
	
	private static HologramManager holoManager;

	public static void donateEnable(HologramManager hologramManager) {
		holoManager = hologramManager;		
	}
	
	public void createHologram(String id, Location location) {
	    Hologram hologram = new Hologram(id, location);
	    holoManager.addActiveHologram(hologram); // Tells the plugin a new Hologram was added
	}
	
	public void addTextLine(Hologram hologram, String text) {
	    HologramLine line = new TextLine(hologram, text);
	    hologram.addLine(line);
	}
	
	public void deleteHologram(Hologram hologram) {
	    holoManager.deleteHologram(hologram);
	}

	public static HologramManager getHoloManager() {
		return holoManager;
	}

	public static void setHoloManager(HologramManager holoManager) {
		DonateBoss.holoManager = holoManager;
	}
}
