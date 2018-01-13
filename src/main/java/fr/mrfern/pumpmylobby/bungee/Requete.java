package fr.mrfern.pumpmylobby.bungee;

import org.bukkit.entity.Player;

public class Requete {

	private byte[] buf;
	private Player sender;
	
	public static Requete PrejoinReq(Player sen) {
		
		
		
		return new Requete();		
	}
	
	public static void OnPreJoinReqOK(Player sen) {
		
	}
	
	public static Requete joinReq(Player sen) {
		
		
		
		return new Requete();		
	}
	
	public static void OnJoinReqOK() {
		
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
