package fr.mrfern.pumpmylobby.bungee;

import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import fr.mrfern.pumpmylobby.inventory.InventoryListener;

public class Requete {

	private byte[] buff;
	private Player sender;
	private String channel;
	
	public Requete(Player sen, String chan, byte[] bytes) {
		buff = bytes;
		sender = sen;
		channel = chan;		
	}

	public static Requete PrejoinReq(Player sen,String serverName) {
		// génération du buffer	de demande si en ligne ou non, et si ban
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		
		out.writeUTF("prejoinrequest");
		out.writeUTF(serverName);
		
		return new Requete(sen, "BungeeCord" , out.toByteArray());		
	}
	
	@SuppressWarnings("unused")
	public static void OnPreJoinResp(Player sen, String serverName , boolean serverState, BanData banData) {
		// si offline alors erreur et return + update inv		
		
		if(serverState) {			
			if(banData == null) {
				
				// donc pas ban
				sen.sendMessage("Connection ok");
				//ServerManager.getManager(sen).sendRequete(Requete.joinReq(sen, serverName));
				
			}else {
				// alors ban
				String banOwner = banData.getAuthor();
				String banOwnerUUID = banData.getAuthor_UUID();
				
				boolean global = banData.isGlobal();
				
				String raison = banData.getRaison();
				
				int day = banData.getDay(), hour = banData.getHour(), minute = banData.getMinute();
				
				int year_end = banData.getYear_end(), month_end = banData.getMonth_end(), day_end = banData.getDay_end(), hour_end = banData.getHour_end(), minute_end = banData.getMinute_end();
				
				// refus de la connection + envoie du message
				sen.sendMessage("ban");	
				if(InventoryListener.getPlayerList().contains(sen))
					InventoryListener.getPlayerList().remove(sen);
			}			
		}else {
			sen.sendMessage("offline");
			if(InventoryListener.getPlayerList().contains(sen))
				InventoryListener.getPlayerList().remove(sen);	
		}
	}
	
	public static Requete joinReq(Player sen, String serverName) {
		// génération du buffer de demande si en ligne ou non et get nombre de joueur		
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		
		out.writeUTF("Connect");
		out.writeUTF(serverName);
		
		return new Requete(sen,"BungeeCord", out.toByteArray());			
	}
	
	public static void OnJoinReqOK() {
		// si offline alors erreur et return + update inv
		
		// sinon check si autorisé à rejoindre avec le nombre de joueur
		
		// si autorisé alors connect avec ConnectReq
		
	}
	
	public static Requete ConnectReq(Player sen, String serverName) {
		
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		
		out.writeUTF("Connect");
		out.writeUTF(serverName);

		
		return new Requete(sen,"BungeeCord", out.toByteArray());		
	}
	
	@Deprecated
	public static void OnConnectReqOk(Player sen, String serverName) {
	
	}


	public byte[] getBuff() {
		return buff;
	}


	public void setBuff(byte[] buf) {
		this.buff = buf;
	}


	public Player getSender() {
		return sender;
	}


	public void setSender(Player sender) {
		this.sender = sender;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	
}
