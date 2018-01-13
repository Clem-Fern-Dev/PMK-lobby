package fr.mrfern.pumpmylobby.server;

import org.bukkit.entity.Player;

import fr.mrfern.pumpmylobby.Main;
import fr.mrfern.pumpmylobby.bungee.Requete;

public class ServerManager {
	
	private static ServerManager serverManager = new ServerManager();
	private Player p;

	public static void initConfig() {
		
	}

	public static ServerManager getManager(Player p) {
		serverManager.setP(p);
		return serverManager;
	}

	public boolean getServerState(String serverName) {
		
		
		return true;
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public void sendRequete(Requete Req) {
		p.sendPluginMessage(Main.getMain(), Req.getChannel(), Req.getBuff());
	}

}
