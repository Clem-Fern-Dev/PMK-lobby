package fr.mrfern.pumpmylobby.inventory;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import fr.mrfern.pumpmylobby.server.ServerManager;

public class MessageManager {

	private Player player;
	
	public MessageManager(Player p) {
		player = p;
	}

	public void OnJoin(ServerManager serverManager) {
		player.sendMessage(ChatColor.GOLD + "[ PumpMyLobby ] Bonjour " + ChatColor.BOLD + ChatColor.YELLOW +player.getName());
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
