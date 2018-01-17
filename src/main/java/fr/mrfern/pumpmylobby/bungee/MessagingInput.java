package fr.mrfern.pumpmylobby.bungee;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

public class MessagingInput implements PluginMessageListener {

	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		System.out.println(channel);
		if (channel.equals("BungeeCord")) {
			System.out.println("Bungee cord channel");
			ByteArrayDataInput in = ByteStreams.newDataInput(message);
			
		    String subchannel = in.readUTF();
		    
		    if (subchannel.equals("prejoinresponse")) {
		    	System.out.println("response");
		    	String serverName = in.readUTF();
		    	boolean serverState = in.readBoolean();
		    	
		    	if(!serverState) {
		    		System.out.println("serverstate false");
		    		Requete.OnPreJoinResp(player, serverName, serverState, null);
		    	}else {
		    		boolean isBan = in.readBoolean();
		    		if(isBan) {
		    			
		    			BanData banData = new BanData();
		    			banData.setAuthor(in.readUTF());
		    			banData.setAuthor_UUID(in.readUTF());
		    			
		    			banData.setGlobal(in.readBoolean());
		    			
		    			banData.setRaison(in.readUTF());
		    			
		    			banData.setDay(in.readInt());
		    			banData.setHour(in.readInt());
		    			banData.setMinute(in.readInt());
		    			
		    			banData.setYear_end(in.readInt());
		    			banData.setMonth_end(in.readInt());
		    			banData.setDay_end(in.readInt());
		    			banData.setHour_end(in.readInt());
		    			banData.setMinute_end(in.readInt());
		    			
		    			
		    			Requete.OnPreJoinResp(player, serverName, serverState, banData);
		    		}else {
		    			Requete.OnPreJoinResp(player, serverName, true, null);
		    		}
		    	}
		    	
		    }
			
		}		
		
	}
}
