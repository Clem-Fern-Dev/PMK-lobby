package fr.mrfern.pumpmylobby.bungee;

import org.bukkit.entity.Player;

public class Requete {

	private byte[] buf;
	private Player sender;
	
	public Requete(Player sen, String serverName, byte[] bytes) {
		// TODO Auto-generated constructor stub
	}

	public static Requete PrejoinReq(Player sen,String serverName) {
		
		
		
		return new Requete(sen,serverName, "".getBytes());		
	}
	
	public static void OnPreJoinReqOK(Player sen) {
		
	}
	
	public static Requete joinReq(Player sen, String serverName) {
		
		
		
		return new Requete(sen,serverName, "".getBytes());			
	}
	
	public static void OnJoinReqOK() {
		
	}
	
	public static Requete ConnectReq(Player sen, String serverName) {
		
		
		
		return new Requete(sen,serverName, "".getBytes());		
	}
	
	public static void OnConnectReqOk(Player sen, String serverName) {
		
	}


	public byte[] getBuf() {
		return buf;
	}


	public void setBuf(byte[] buf) {
		this.buf = buf;
	}


	public Player getSender() {
		return sender;
	}


	public void setSender(Player sender) {
		this.sender = sender;
	}
	
}
