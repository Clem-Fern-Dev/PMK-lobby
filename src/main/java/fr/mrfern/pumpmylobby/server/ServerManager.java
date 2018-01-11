package fr.mrfern.pumpmylobby.server;

import java.util.HashMap;

import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import fr.mrfern.pumpmylobby.Main;

public class ServerManager {
	
	private static ServerManager serverManager = new ServerManager();
	private static HashMap<String, ServerData> serverHash;
	private Player p;

	public static void initConfig() {
		
	}

	public static HashMap<String, ServerData> getServerHash() {
		return serverHash;
	}

	public static void setServerHash(HashMap<String, ServerData> serverHash) {
		ServerManager.serverHash = serverHash;
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
