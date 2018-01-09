package fr.mrfern.pumpmylobby;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import fr.mrfern.pumpmylobby.porg.MisterPorg;

public class Main extends JavaPlugin {

	private static MisterPorg misterP;
	private static Server server;
	
	@Override
	public void onLoad() {
		setMisterP(new MisterPorg(this, "MzgyNTc4Mzg4MDY3NTQ5MTg0.DQdApA.zxYqzecf2pn3HMt6rRZGbcibggs","387326167499276292"));
		server = this.getServer();
	}
	
	@Override
		public void onEnable() {
			// TODO Auto-generated method stub
		}
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
	}

	public static MisterPorg getMisterP() {
		return misterP;
	}

	public void setMisterP(MisterPorg misterP) {
		Main.misterP = misterP;
	}
	
	public static Server getServerInfo() {
		return server;
	}
	
}
