package fr.mrfern.pumpmylobby;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;
import fr.mrfern.pumpmylobby.bungee.MessagingInput;
import fr.mrfern.pumpmylobby.donate.DonateBoss;
import fr.mrfern.pumpmylobby.inventory.InventoryListener;
import fr.mrfern.pumpmylobby.porg.MisterPorg;
import fr.mrfern.pumpmylobby.porg.PorgServerEvent;
import fr.mrfern.pumpmylobby.server.NoIA;


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
		// Init discord message start
		new PorgServerEvent().OnServerStartEvent(new MisterPorg(this, "MzgyNTc4Mzg4MDY3NTQ5MTg0.DQdApA.zxYqzecf2pn3HMt6rRZGbcibggs","387326167499276292"));
		
		//inti bungee com
		
		// init config
		saveDefaultConfig();
		
		//event
		
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	    this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new MessagingInput());
	    
	    getServer().getPluginManager().registerEvents(new InventoryListener(), this);
	    
	    Location loc = new Location(this.getServer().getWorld("spawn"), -537.5, 29, 1372.5);
	    loc.setYaw(0);
	    loc.setPitch(0);
	    
	    if (!Bukkit.getPluginManager().isPluginEnabled("HolographicDisplays")) {
			getLogger().severe("*** HolographicDisplays is not installed or not enabled. ***");
			getLogger().severe("*** This plugin will be disabled. ***");
		}else {
			DonateBoss.initDonateHolo();
		}
		
	    ArmorStand armorStand = (ArmorStand) this.getServer().getWorld("spawn").spawnEntity(loc, EntityType.ARMOR_STAND);	
	    Creeper creeper = (Creeper) this.getServer().getWorld("spawn").spawnEntity(loc, EntityType.CREEPER);
	    NoIA.setAiEnabled(creeper, false);
	    //armorStand.setPassenger(creeper);
	    armorStand.setCustomNameVisible(true);
	    armorStand.setGravity(false);
	    armorStand.setHealth(20);
	    Annimation.initTask(this, armorStand);
	    
	}
	
	@Override
	public void onDisable() {
		Annimation.getArmorS().remove();
		new PorgServerEvent().OnServerStopEvent(new MisterPorg(this, "MzgyNTc4Mzg4MDY3NTQ5MTg0.DQdApA.zxYqzecf2pn3HMt6rRZGbcibggs","387326167499276292"));
	}
	
	public static Server getServerInfo() {
		return server;
	}

	public static Main getMain() {
		return main;
	}
	
}
