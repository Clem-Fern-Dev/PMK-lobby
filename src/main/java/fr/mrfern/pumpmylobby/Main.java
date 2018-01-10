package fr.mrfern.pumpmylobby;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import fr.mrfern.pumpmylobby.inventory.InventoryListener;
import fr.mrfern.pumpmylobby.porg.MisterPorg;
import fr.mrfern.pumpmylobby.porg.PorgServerEvent;


public class Main extends JavaPlugin {

	private static Server server;
	private static Main main;
	
	@Override
	public void onLoad() {
		server = this.getServer();
		main = this;
	}
	
	@Override
	public void onEnable() {
		
		saveDefaultConfig();
		
		new PorgServerEvent().OnServerStartEvent(new MisterPorg(this, "MzgyNTc4Mzg4MDY3NTQ5MTg0.DQdApA.zxYqzecf2pn3HMt6rRZGbcibggs","387326167499276292"));	
		
		getServer().getPluginManager().registerEvents(new InventoryListener(), this);
		
	}
	
	@Override
	public void onDisable() {
		new PorgServerEvent().OnServerStopEvent(new MisterPorg(this, "MzgyNTc4Mzg4MDY3NTQ5MTg0.DQdApA.zxYqzecf2pn3HMt6rRZGbcibggs","387326167499276292"));
	}
	
	public static Server getServerInfo() {
		return server;
	}

	public static Main getMain() {
		return main;
	}
	
}
