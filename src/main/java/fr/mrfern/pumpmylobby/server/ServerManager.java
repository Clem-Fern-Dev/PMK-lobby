package fr.mrfern.pumpmylobby.server;

import java.util.HashMap;

public class ServerManager {
	
	private static HashMap<String, ServerData> serverHash;

	public static void initConfig() {
		// TODO Auto-generated method stub
		
	}

	public static HashMap<String, ServerData> getServerHash() {
		return serverHash;
	}

	public static void setServerHash(HashMap<String, ServerData> serverHash) {
		ServerManager.serverHash = serverHash;
	}

}
