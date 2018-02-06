package fr.mrfern.pumpmylobby.bungee;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

public class MessagingInput implements PluginMessageListener {

	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		if (channel.equals("BungeeCord")) {
			ByteArrayDataInput in = ByteStreams.newDataInput(message);
			
		    String subchannel = in.readUTF();
		    
		    if (subchannel.equals("prejoinresponse")) {
		    	String serverName = in.readUTF();
		    	// serveur dispo
		    	boolean isBan = in.readBoolean(); 	// check ban
		    	if(isBan) {
		    		// si ban, alors new BanData & envoie r�ponse
		    		BanData banData = new BanData();
		    		banData.setAuthor(in.readUTF());
		    		banData.setAuthor_UUID(in.readUTF());
		    			
		    		//banData.setGlobal(in.readBoolean());
		    			
		    		banData.setRaison(in.readUTF());
		    			
		    		banData.setDay(in.readInt());
		    		banData.setHour(in.readInt());
		    		banData.setMinute(in.readInt());
		    			
		    		banData.setYear_end(in.readInt());
		    		banData.setMonth_end(in.readInt());
		    		banData.setDay_end(in.readInt());
		    		banData.setHour_end(in.readInt());
		    		banData.setMinute_end(in.readInt());
		    			
		    			
		    		Requete.OnPreJoinResp(player, serverName, banData);
		    	}else {
		    		// envoie confirmation r�ponse joueur non ban
		    		Requete.OnPreJoinResp(player, serverName, null);
		    	}
		    	
		    	
		    }else if(subchannel.equals("joinresponse")) {
		    	String serverName = in.readUTF();
		    	
		    	int plyCount = in.readInt();	// r�cup�ration du nombre de joueur
		    	
		    	Requete.OnJoinResp(player, serverName, plyCount);
		    	
		    	
		    }
		}		
	}
}
