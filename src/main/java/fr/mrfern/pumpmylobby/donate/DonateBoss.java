package fr.mrfern.pumpmylobby.donate;

import java.util.UUID;

import org.bukkit.Location;

import com.sainttx.holograms.api.Hologram;
import com.sainttx.holograms.api.HologramManager;
import com.sainttx.holograms.api.line.HologramLine;
import com.sainttx.holograms.api.line.TextLine;

import fr.mrfern.pumpmylobby.Main;

public class DonateBoss {
	
	private static HologramManager holoManager;
	
	private static Location holoLoc;
	private static Hologram holo;

	public static void donateEnable(HologramManager hologramManager) {
		holoManager = hologramManager;	
		holoLoc = new Location(Main.getServerInfo().getWorld("spawn"), -537.5, 0,1372.4);
	}
	
	public static void donateDisable(Hologram hologram) {
		hideHologram(hologram);
		deleteHologram(hologram);
	}
	
	public static void InitHologram(Hologram holo) {
		holo = createHologram(UUID.randomUUID().toString(), holoLoc);
	}
	
	public static Hologram createHologram(String id, Location location) {
	    Hologram hologram = new Hologram(id, location);
	    holoManager.addActiveHologram(hologram); // Tells the plugin a new Hologram was added
	    return hologram;
	}
	
	public static void addTextLine(Hologram hologram, String text) {
	    HologramLine line = new TextLine(hologram, text);
	    hologram.addLine(line);
	}
	
	public static void deleteHologram(Hologram hologram) {
	    holoManager.deleteHologram(hologram);
	}
	
	public static void hideHologram(Hologram hologram) {
	    hologram.despawn();
	    holoManager.removeActiveHologram(hologram);
	}

	public static HologramManager getHoloManager() {
		return holoManager;
	}

	public static void setHoloManager(HologramManager holoManager) {
		DonateBoss.holoManager = holoManager;
	}

	public static Hologram getHolo() {
		return holo;
	}

	public static void setHolo(Hologram holo) {
		DonateBoss.holo = holo;
	}
}
