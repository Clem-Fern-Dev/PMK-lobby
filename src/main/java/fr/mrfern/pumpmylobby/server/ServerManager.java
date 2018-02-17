package fr.mrfern.pumpmylobby.server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.bukkit.entity.Player;

import fr.mrfern.pumpmylobby.Main;
import fr.mrfern.pumpmylobby.bungee.Requete;
import fr.mrfern.pumpmylobby.config.MySQLConnector;

public class ServerManager {
	
	private Player p;
	private HashMap<String,MuteData> MuteDataList = new HashMap<>();

	public ServerManager(Player player) {
		setP(player);
		ResultSet listRS = new MySQLConnector().sendQuery("SELECT `mute_ID` FROM `mute_player` WHERE `player_UUID`='" + p.getUniqueId() +"'");	// commande pour récupérer les ids de mute correspondant à ce UUID
		List<Integer> muteIDList = new ArrayList<>();	// Instanciation de la liste de mute
		
		// récupération du contenu de la table
		try {
			while(listRS.next()) {
				try {
					// ajout à la liste de muteID
					muteIDList.add(listRS.getInt("mute_ID"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(!muteIDList.isEmpty()) {
				// si mute list vide alors pas mute
				for (int muteID : muteIDList) {
					ResultSet muteRS = new MySQLConnector().sendQuery("SELECT `author_UUID`, `author_name`, `mute_type`, `raison`, `mutetime_day`, `mutetime_hour`, `mutetime_minut`, `end_mutetime_year`, `end_mutetime_month`, `end_mutetime_day`, `end_mutetime_hour`, `end_mutetime_minut`, `player_UUID`, `end` FROM `mute_list` WHERE `id`=" + muteID);
					muteRS.next();
					
					boolean end = muteRS.getBoolean("end");
					
					if(!end) {
						MuteData MuteData = new MuteData();
						
						String muteType = muteRS.getString("mute_type");
						
						MuteData.setAuthor(muteRS.getString("author_name")); 	// set author name dans mute Data
						MuteData.setAuthor_UUID(muteRS.getString("author_UUID")); 	// set author UUID dans mute Data
						
						MuteData.setMuteType(muteType); 	// set mute type dans mute Data
						
						MuteData.setRaison(muteRS.getString("raison")); 	// set raison dans mute Data
						
						// set temps de mute dans mute Data
						MuteData.setDay(muteRS.getInt("mutetime_day"));
						MuteData.setHour(muteRS.getInt("mutetime_hour"));
						MuteData.setMinute(muteRS.getInt("mutetime_minut"));
						
						//set date de fin de mute dans mute Data
						MuteData.setYear_end(muteRS.getInt("end_mutetime_year"));
						MuteData.setMonth_end(muteRS.getInt("end_mutetime_month"));
						MuteData.setDay_end(muteRS.getInt("end_mutetime_day"));
						MuteData.setHour_end(muteRS.getInt("end_mutetime_hour"));
						MuteData.setMinute_end(muteRS.getInt("end_mutetime_minut"));
						
						MuteDataList.put(muteType, MuteData); // ajout à la map les infos sur le mute
					}							
				}
				
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static ServerManager getManager(Player p) {	
		return new ServerManager(p);
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}
	
	public boolean isMute(String serverName) {
		for (Entry<String, MuteData> entry : MuteDataList.entrySet()) {	//parcours de la liste de mute
			if(entry.getKey().equals(serverName) | entry.getKey().equals("global")) {	// test nom du serveur ou mute global
				return true;
			}
		}
		return false;
	}
	
	public boolean getMuteIsGlobal() {
		for (Entry<String, MuteData> entry : MuteDataList.entrySet()) {	//parcours de la liste de mute
			if(entry.getKey().equals("global")) {	// test mute global
				return true;
			}
		}
		return false;
	}
	
	public String getAuthor(String serverName) {
		for (Entry<String, MuteData> entry : MuteDataList.entrySet()) {	//parcours de la liste de mute
			if(entry.getKey().equals(serverName) | entry.getKey().equals("global")) {	// test nom du serveur ou mute global
				return entry.getValue().getAuthor();
			}
		}
		return "none";
	}
	
	public String getAuthorUUID(String serverName) {
		for (Entry<String, MuteData> entry : MuteDataList.entrySet()) {	//parcours de la liste de mute
			if(entry.getKey().equals(serverName) | entry.getKey().equals("global")) {	// test nom du serveur ou mute global
				return entry.getValue().getAuthor_UUID();
			}
		}
		return "none";
	}

	public String getRaison(String serverName) {
		for (Entry<String, MuteData> entry : MuteDataList.entrySet()) {	//parcours de la liste de mute
			if(entry.getKey().equals(serverName) | entry.getKey().equals("global")) {	// test nom du serveur ou mute global
				return entry.getValue().getRaison();
			}
		}
		return "no raison";
	}

	public int getDay(String serverName) {
		for (Entry<String, MuteData> entry : MuteDataList.entrySet()) {	//parcours de la liste de mute
			if(entry.getKey().equals(serverName) | entry.getKey().equals("global")) {	// test nom du serveur ou mute global
				return entry.getValue().getDay();
			}
		}
		return 0;
	}

	public int getHour(String serverName) {
		for (Entry<String, MuteData> entry : MuteDataList.entrySet()) {	//parcours de la liste de mute
			if(entry.getKey().equals(serverName) | entry.getKey().equals("global")) {	// test nom du serveur ou mute global
				return entry.getValue().getHour();
			}
		}
		return 0;
	}

	public int getMinute(String serverName) {
		for (Entry<String, MuteData> entry : MuteDataList.entrySet()) {	//parcours de la liste de mute
			if(entry.getKey().equals(serverName) | entry.getKey().equals("global")) {	// test nom du serveur ou mute global
				return entry.getValue().getMinute();
			}
		}
		return 0;
	}

	public int getYear_end(String serverName) {
		for (Entry<String, MuteData> entry : MuteDataList.entrySet()) {	//parcours de la liste de mute
			if(entry.getKey().equals(serverName) | entry.getKey().equals("global")) {	// test nom du serveur ou mute global
				return entry.getValue().getYear_end();
			}
		}
		return 0;
	}

	public int getMonth_end(String serverName) {
		for (Entry<String, MuteData> entry : MuteDataList.entrySet()) {	//parcours de la liste de mute
			if(entry.getKey().equals(serverName) | entry.getKey().equals("global")) {	// test nom du serveur ou mute global
				return entry.getValue().getMonth_end();
			}
		}
		return 0;
	}

	public int getDay_end(String serverName) {
		for (Entry<String, MuteData> entry : MuteDataList.entrySet()) {	//parcours de la liste de mute
			if(entry.getKey().equals(serverName) | entry.getKey().equals("global")) {	// test nom du serveur ou mute global
				return entry.getValue().getDay_end();
			}
		}
		return 0;
	}

	public int getHour_end(String serverName) {
		for (Entry<String, MuteData> entry : MuteDataList.entrySet()) {	//parcours de la liste de mute
			if(entry.getKey().equals(serverName) | entry.getKey().equals("global")) {	// test nom du serveur ou mute global
				return entry.getValue().getHour_end();
			}
		}
		return 0;
	}

	public int getMinute_end(String serverName) {
		for (Entry<String, MuteData> entry : MuteDataList.entrySet()) {	//parcours de la liste de mute
			if(entry.getKey().equals(serverName) | entry.getKey().equals("global")) {	// test nom du serveur ou mute global
				return entry.getValue().getMinute_end();
			}
		}
		return 0;
	}

	public HashMap<String,MuteData> getMuteDataList() {
		return MuteDataList;
	}

	public void setMuteDataList(HashMap<String,MuteData> MuteDataList) {
		this.MuteDataList = MuteDataList;
	}	

	public void sendRequete(Requete Req) {
		p.sendPluginMessage(Main.getMain(), Req.getChannel(), Req.getBuff());
	}

}
