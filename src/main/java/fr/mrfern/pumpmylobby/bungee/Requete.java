package fr.mrfern.pumpmylobby.bungee;

import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import fr.mrfern.pumpmylobby.inventory.InventoryListener;
import fr.mrfern.pumpmylobby.server.ServerManager;

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
	
	public static void OnPreJoinResp(Player sen, String serverName , boolean serverState, BanData banData) {
		// si offline alors erreur et return + update inv		
		
		if(serverState) {	
			if(banData == null) {
				sen.sendMessage("non ban requete joinReq");
				// donc pas ban, envoie de la requete suivante
				//ServerManager.getManager(sen).sendRequete(Requete.joinReq(sen, serverName));
				if(InventoryListener.getPlayerList().contains(sen))
					InventoryListener.getPlayerList().remove(sen);
				
			}else {
				// alors ban
				String banOwner = banData.getAuthor();
				String banOwnerUUID = banData.getAuthor_UUID();
				
				/*boolean global = banData.isGlobal();
				
				String raison = banData.getRaison();
				
				int day = banData.getDay(), hour = banData.getHour(), minute = banData.getMinute();
				
				int year_end = banData.getYear_end(), month_end = banData.getMonth_end(), day_end = banData.getDay_end(), hour_end = banData.getHour_end(), minute_end = banData.getMinute_end();
				*/
				// refus de la connection + envoie du message
				sen.sendMessage("ban  " + banOwner + "  " + banOwnerUUID);		// Message à mettre , il faut dire que la requète de connexion n'a pas aboutti pour le serveur demandé, car le joueur est ban par author (UUID de l'author ), pendant J/H/M , date de déban
				if(InventoryListener.getPlayerList().contains(sen))
					InventoryListener.getPlayerList().remove(sen);
			}			
		}else {
			sen.sendMessage("offline");		// Message à mettre, il faut dire que la requère de connexion n'a pas aboutti car le serveur demandé n'est pas disponible
			if(InventoryListener.getPlayerList().contains(sen))
				InventoryListener.getPlayerList().remove(sen);	
			
			// update inventaire
			
		}
	}
	
	/*public static Requete joinReq(Player sen, String serverName) {
		// génération du buffer de demande si en ligne ou non et get nombre de joueur		
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		
		out.writeUTF("joinreq");
		out.writeUTF(serverName);
		
		return new Requete(sen,"BungeeCord", out.toByteArray());			
	}*/
	
	/*public static void OnJoinResp(Player sen, String serverName, boolean serverState, int plyNb) {
		/*if(serverState) {	
			if(plyNb > 20) {
				// besoin d'etre staff pour rejoindre
				if(sen.hasPermission("server.staffslot")) {
					// connection
					ServerManager.getManager(sen).sendRequete(Requete.ConnectReq(sen, serverName));
				}else {
					//refus
					sen.sendMessage("refus besoin de la permissions staffslot");
					if(InventoryListener.getPlayerList().contains(sen))
						InventoryListener.getPlayerList().remove(sen);
				}
			}else if(plyNb > 14) {
				// besoin d'un grade pour rejoindre
				if(sen.hasPermission("server.premiumslot") | sen.hasPermission("server.staffslot")) {
					// connection
					ServerManager.getManager(sen).sendRequete(Requete.ConnectReq(sen, serverName));
				}else {
					// refus
					sen.sendMessage("refus besoin de la permissions premiumslot ou staffslot");
					if(InventoryListener.getPlayerList().contains(sen))
						InventoryListener.getPlayerList().remove(sen);
				}
			}else {
				// connection
				ServerManager.getManager(sen).sendRequete(Requete.ConnectReq(sen, serverName));				
			}
		}else {
			sen.sendMessage("offline");		// Message à mettre, il faut dire que la requère de connexion n'a pas aboutti car le serveur demandé n'est pas disponible
			if(InventoryListener.getPlayerList().contains(sen))
				InventoryListener.getPlayerList().remove(sen);	
			
			// update inventaire	
		}	
		
		ServerManager.getManager(sen).sendRequete(Requete.ConnectReq(sen, serverName));
	}*/
	
	/*public static Requete ConnectReq(Player sen, String serverName) {
		
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		
		out.writeUTF("Connect");
		out.writeUTF(serverName);
		
		if(InventoryListener.getPlayerList().contains(sen))
			InventoryListener.getPlayerList().remove(sen);
		
		return new Requete(sen,"BungeeCord", out.toByteArray());		
	}*/
	
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
