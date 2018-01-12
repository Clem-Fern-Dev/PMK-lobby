package fr.mrfern.pumpmylobby.server;

import org.bukkit.entity.Player;

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
		
		
		return false;
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

}
