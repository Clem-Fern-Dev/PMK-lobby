package fr.mrfern.pumpmylobby;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.RegisteredServiceProvider;

import me.lucko.luckperms.api.Contexts;
import me.lucko.luckperms.api.LuckPermsApi;
import me.lucko.luckperms.api.User;
import me.lucko.luckperms.api.caching.MetaData;
import me.lucko.luckperms.api.caching.UserData;

public class ChatFormater implements Listener{

	private static RegisteredServiceProvider<LuckPermsApi> provider;
	private static LuckPermsApi api;
	
	private static boolean apiState;
	
	public static void initChatFormateur() {
		
		provider = Bukkit.getServicesManager().getRegistration(LuckPermsApi.class);	// récupération du provider
		
		if (provider != null) {	// test du provider
		    api = provider.getProvider();	// récupération de l'api
		    setApiState(true);	// state ok
		}else {
			setApiState(false);		// state non ok
			try {
				throw new IOException("LuckPerms API error accès !");	// throw Exception
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@EventHandler
	public void OnChatMessage(AsyncPlayerChatEvent e) {
		if(!apiState)	// si API non dispo
			return;		// alors return
		
		
		Player p = e.getPlayer(); // récupération de l'instance player
		
		if(isMute(e.getPlayer())) {	// test du mute du player 
			// cancel message
			
		}else {
			// instanciation format format
			String format;
			
			UUID playerUuid = p.getUniqueId();	//récupération de l'uuid
					User user = api.getUser(playerUuid);	// récupération de l'User luckPerm API
					if (user == null) {		//cheack du load de l'user
					    // user load error
					} else {
					    
						UserData uData = user.getCachedData();
						Optional<Contexts> contexts = api.getContextForUser(user);
						MetaData metaData = uData.getMetaData(contexts.get());
						
						format = ">";
						
						for (Entry<Integer, String> entry : metaData.getPrefixes().entrySet()) {
							format += " [" + entry.getValue() + "]";
						}
						
						e.setFormat(format);
						
					}
			
		}
		
	}

	private boolean isMute(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	public static RegisteredServiceProvider<LuckPermsApi> getProvider() {
		return provider;
	}

	public static void setProvider(RegisteredServiceProvider<LuckPermsApi> provider) {
		ChatFormater.provider = provider;
	}

	public static LuckPermsApi getApi() {
		return api;
	}

	public static void setApi(LuckPermsApi api) {
		ChatFormater.api = api;
	}

	public static boolean isApiState() {
		return apiState;
	}

	public static void setApiState(boolean apiState) {
		ChatFormater.apiState = apiState;
	}
	
}
