package fr.mrfern.pumpmylobby.bungee;

import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

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
		
		out.writeUTF("Connect");
		out.writeUTF(serverName);
		
		return new Requete(sen, "BungeeCord" , out.toByteArray());		
	}
	
	public static void OnPreJoinReqOK(Player sen) {
		// si offline alors erreur et return + update inv
		
		//sinon si ban alors return + send message ban + infos
		
		// sinon check nombre de joueurs avec JoinReq
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
