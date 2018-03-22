package fr.mrfern.pumpmylobby;

import org.bukkit.Server;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import fr.mrfern.pumpmylobby.bungee.MessagingInput;
import fr.mrfern.pumpmylobby.config.Config;
import fr.mrfern.pumpmylobby.inventory.InventoryListener;
import fr.mrfern.pumpmylobby.porg.MisterPorg;
import fr.mrfern.pumpmylobby.porg.PorgServerEvent;


public class Main extends JavaPlugin {

	private static Server server;
	private static Main main;
	
	//@SuppressWarnings("unused")
	//private HologramManager hologramManager;
	
	@Override
	public void onLoad() {
		server = this.getServer();
		main = this;
	}
	
	@Override
	public void onEnable() {
		// Init discord message start
		new PorgServerEvent().OnServerStartEvent(new MisterPorg(this, "#","387326167499276292"));
		
		//inti bungee com
		
		// init config
		Config conf = Config.getConfig(this);
		
		conf.initDataFolder();
	    conf.initAndGetFile("config.yml");	// init config default file
	    
	    Configuration bddConf;
		try {
			// get instance configuration config.yml
			bddConf = conf.getConfiguration("config.yml");
			
			//get url / user / mdp dans config.yml
			String url = bddConf.getString("ban.bdd_url");
	        String user = bddConf.getString("ban.bdd_user");
	        String mdp = bddConf.getString("ban.bdd_mdp");
	        String base = bddConf.getString("ban.bdd_base");
	        
	        //initialisation de la class MySQLConnector
	        conf.initMySQLConnect(url,user,mdp,base);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//event
		
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	    this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new MessagingInput());
	    
	    getServer().getPluginManager().registerEvents(new InventoryListener(), this);
	    
	    getServer().getPluginManager().registerEvents(new ChatFormater(), this);
	    
	   // Location loc = new Location(this.getServer().getWorld("spawn"), -537.5, 29, 1372.5);
	   // loc.setYaw(0);
	   // loc.setPitch(0);
	    
	   // DonateBoss.donateEnable(getPlugin(HologramPlugin.class).getHologramManager());	    
	    
		
	   /* ArmorStand armorStand = (ArmorStand) this.getServer().getWorld("spawn").spawnEntity(loc, EntityType.ARMOR_STAND);	
	    Creeper creeper = (Creeper) this.getServer().getWorld("spawn").spawnEntity(loc, EntityType.CREEPER);
	    NoIA.setAiEnabled(creeper, false);
	    //armorStand.setPassenger(creeper);
	    armorStand.setCustomNameVisible(true);
	    armorStand.setGravity(false);
	    armorStand.setHealth(20);
	    Annimation.initTask(this, armorStand);*/
	    
	}
	
	@Override
	public void onDisable() {
		//Annimation.getArmorS().remove();
		new PorgServerEvent().OnServerStopEvent(new MisterPorg(this, "MzgyNTc4Mzg4MDY3NTQ5MTg0.DQdApA.zxYqzecf2pn3HMt6rRZGbcibggs","387326167499276292"));
	}
	
	public static Server getServerInfo() {
		return server;
	}

	public static Main getMain() {
		return main;
	}
	
}
