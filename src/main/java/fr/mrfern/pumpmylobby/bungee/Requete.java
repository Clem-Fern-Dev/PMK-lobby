package fr.mrfern.pumpmylobby.bungee;

import org.bukkit.ChatColor;
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
	
	public static void OnPreJoinResp(Player sen, String serverName , BanData banData) {
		if(banData == null) {
			//sen.sendMessage("non ban requete joinReq");
			// donc pas ban, envoie de la requete suivante
			ServerManager.getManager(sen).sendRequete(Requete.joinReq(sen, serverName));
			if(InventoryListener.getPlayerList().contains(sen))
				InventoryListener.getPlayerList().remove(sen);
				
		}else {
			// alors ban
			String banOwner = banData.getAuthor();
			String banOwnerUUID = banData.getAuthor_UUID();
				
			String raison = banData.getRaison();
				
			int day = banData.getDay(), hour = banData.getHour(), minute = banData.getMinute();
				
			int year_end = banData.getYear_end(), month_end = banData.getMonth_end(), day_end = banData.getDay_end(), hour_end = banData.getHour_end(), minute_end = banData.getMinute_end();
				
			// refus de la connection + envoie du message
			// Message à mettre , il faut dire que la requète de connexion n'a pas aboutti pour le serveur demandé, car le joueur est ban par author (UUID de l'author ), pendant J/H/M , date de déban
			sen.sendMessage(ChatColor.RED + "Demande de connexion annulée ! Vous etes banni de ce serveur :");
			sen.sendMessage(ChatColor.RED + "Bannisseur : " + ChatColor.GOLD + "" + ChatColor.BOLD + banOwner + " " + ChatColor.RESET + "" + ChatColor.RED + "( " + ChatColor.GOLD + banOwnerUUID + " " + ChatColor.RED + ")" );
			sen.sendMessage(ChatColor.RED + "Raison : " + ChatColor.DARK_RED + raison);
			sen.sendMessage(ChatColor.RED + "Temps de bannissement : " + ChatColor.AQUA + day + ChatColor.DARK_AQUA + "D:" + ChatColor.AQUA + hour + ChatColor.DARK_AQUA + "H:"+ ChatColor.AQUA + minute + ChatColor.DARK_AQUA + "M " + ChatColor.DARK_AQUA + "( " + year_end + "\\" + month_end + "\\" + day_end + "\\" + hour_end + "\\" + minute_end + " )" );
			sen.sendMessage(ChatColor.RED + "Demande de débannissment : "+ ChatColor.UNDERLINE + "" + ChatColor.BLUE +"http://pumpmykins.eu/forum/forumdisplay.php?fid=8");
			if(InventoryListener.getPlayerList().contains(sen))
				InventoryListener.getPlayerList().remove(sen);
		}			
	}
	
	public static Requete joinReq(Player sen, String serverName) {
		// génération du buffer de demande si en ligne ou non et get nombre de joueur		
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		
		out.writeUTF("joinreq");
		out.writeUTF(serverName);
		
		return new Requete(sen,"BungeeCord", out.toByteArray());			
	}
	
	public static void OnJoinResp(Player sen, String serverName, int plyNb) {
		if(plyNb > 20) {
			// besoin d'etre staff pour rejoindre
			if(sen.hasPermission("server.staffslot." + serverName)) {
				// connection
				ServerManager.getManager(sen).sendRequete(Requete.ConnectReq(sen, serverName));
			}else {
				//refus
				sen.sendMessage(ChatColor.RED + "Demande de connexion annulée ! Le serveur est plein.");
				if(InventoryListener.getPlayerList().contains(sen))
					InventoryListener.getPlayerList().remove(sen);
			}
		}else if(plyNb > 14) {
			// besoin d'un grade pour rejoindre
			if(sen.hasPermission("server.premiumslot." + serverName) | sen.hasPermission("server.staffslot." + serverName)) {
				// connection
				ServerManager.getManager(sen).sendRequete(Requete.ConnectReq(sen, serverName));
			}else {
				// refus
				sen.sendMessage(ChatColor.RED + "Demande de connexion annulée ! Le serveur est plein.");
				if(InventoryListener.getPlayerList().contains(sen))
					InventoryListener.getPlayerList().remove(sen);
			}
		}else {
			// connection
			ServerManager.getManager(sen).sendRequete(Requete.ConnectReq(sen, serverName));				
		}
	}
	
	public static Requete ConnectReq(Player sen, String serverName) {
		
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		
		out.writeUTF("Connect");
		out.writeUTF(serverName);
		
		if(InventoryListener.getPlayerList().contains(sen))
			InventoryListener.getPlayerList().remove(sen);
		
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
