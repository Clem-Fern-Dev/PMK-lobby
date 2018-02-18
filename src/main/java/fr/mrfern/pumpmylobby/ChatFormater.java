package fr.mrfern.pumpmylobby;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.RegisteredServiceProvider;

import me.lucko.luckperms.api.LuckPermsApi;

public class ChatFormater implements Listener{

	private static RegisteredServiceProvider<LuckPermsApi> provider;
	
	public static void initChatFormateur() {
		
		
		
	}
	
	@EventHandler
	public void OnChatMessage(AsyncPlayerChatEvent e) {
	
		Player p = e.getPlayer();
		
		if(isMute(e.getPlayer())) {
			// cancel message
			
		}else {
			// set format
			String format;
			
			
			
		}
		
	}

	private boolean isMute(Player player) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
