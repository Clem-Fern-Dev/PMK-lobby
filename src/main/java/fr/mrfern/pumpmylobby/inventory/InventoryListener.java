package fr.mrfern.pumpmylobby.inventory;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.mrfern.pumpmylobby.server.ServerManager;

public class InventoryListener implements Listener {

	@EventHandler
	public void OnJoinSetInv(PlayerJoinEvent e) {		
		Player p = e.getPlayer();
		
		NavBarManager navM = new NavBarManager(p);
		MessageManager messM = new MessageManager(p);
		
		messM.OnJoin(ServerManager.getManager(p));
		
		navM.giveNavInv(ServerManager.getManager(p));		
	}
	
	@EventHandler
	public void OnPlayerUseNavItem(PlayerInteractEvent e) {
		if(e.getPlayer().getGameMode().equals(GameMode.CREATIVE) | e.getPlayer().getGameMode().equals(GameMode.SPECTATOR))
			return;
		
		if(e.getItem() == null)
			return;
		
		e.setCancelled(true);
		
		ItemStack item = e.getItem();
		ItemMeta itemMeta = item.getItemMeta();
		String itemName = itemMeta.getDisplayName();
		
		Player p = e.getPlayer();
		
		System.out.println(itemName);
		
		if(itemName.equals("§cPumpMyRagna#1") | itemName.equals("az")) {
			if(!p.hasPermission("server.ragna1")) {
				p.sendMessage(ChatColor.GOLD + "[ PumpMyLobby ] " + ChatColor.RESET + "" + ChatColor.ITALIC + "" + ChatColor.AQUA + "ragna1 " + ChatColor.RESET + "" + ChatColor.RED + "Envoie de la demande connection impossible. Vous n'avez pas la permissions de rejoindre !");
			}else if(ServerManager.getManager(p).getServerState("ragna1")) {
				p.sendMessage(ChatColor.GOLD + "[ PumpMyLobby ] " + ChatColor.RESET + "" + ChatColor.ITALIC + "" + ChatColor.AQUA + "ragna1 " + ChatColor.RESET + "" + ChatColor.RED + "Envoie de la demande connection impossible, serveur non disponible !");
			}else {
				p.sendMessage(ChatColor.GOLD + "[ PumpMyLobby ] " + ChatColor.RESET + "" + ChatColor.ITALIC + "" + ChatColor.AQUA + "ragna1 " + ChatColor.RESET + "" + ChatColor.YELLOW + "Envoie de la demande connection, attente d'une réponse ....");
			}
		}else if(itemName.equals("§cPumpMyRagna#2") | itemName.equals("er")){
			if(!p.hasPermission("server.ragna2")) {
				p.sendMessage(ChatColor.GOLD + "[ PumpMyLobby ] " + ChatColor.RESET + "" + ChatColor.ITALIC + "" + ChatColor.AQUA + "ragna2 " + ChatColor.RESET + "" + ChatColor.RED + "Envoie de la demande connection impossible. Vous n'avez pas la permissions de rejoindre !");
			}else if(ServerManager.getManager(p).getServerState("ragna2")) {
				p.sendMessage(ChatColor.GOLD + "[ PumpMyLobby ] " + ChatColor.RESET + "" + ChatColor.ITALIC + "" + ChatColor.AQUA + "ragna2 " + ChatColor.RESET + "" + ChatColor.RED + "Envoie de la demande connection impossible, serveur non disponible !");
			}else {
				p.sendMessage(ChatColor.GOLD + "[ PumpMyLobby ] " + ChatColor.RESET + "" + ChatColor.ITALIC + "" + ChatColor.AQUA + "ragna2 " + ChatColor.RESET + "" + ChatColor.YELLOW + "Envoie de la demande connection, attente d'une réponse ....");
			}
			
		}else if(itemName.equals("§6§kabcd§r§c SECRET §r§6§kabcd") | itemName.equals("§cServeur developpement")){
			if(!p.hasPermission("server.dev")) {
				p.sendMessage(ChatColor.GOLD + "[ PumpMyLobby ] " + "" + ChatColor.RESET + "" + ChatColor.MAGIC + "abcd " + ChatColor.RESET + "" + ChatColor.RED + "" + ChatColor.UNDERLINE + "Tentative d'accès à une contenue classé secret " + ChatColor.RESET + "" + ChatColor.MAGIC + "abcd");
			}else if(ServerManager.getManager(p).getServerState("dev")) {
				p.sendMessage(ChatColor.RED + "Serveur offline ou indisponible");
			}else {
				p.sendMessage(ChatColor.GOLD + "[ PumpMyLobby ] " + ChatColor.RESET + "" + ChatColor.ITALIC + "" + ChatColor.AQUA + "ragna1 " + ChatColor.RESET + "" + ChatColor.YELLOW + "Envoie de la demande connection, attente d'une réponse ....");
			}
		}else {
			e.getPlayer().getInventory().remove(item);
		}
	}
	
	@EventHandler
	public void OnDragItem(InventoryDragEvent e) {
		if(!e.getWhoClicked().getGameMode().equals(GameMode.CREATIVE) & !e.getWhoClicked().getGameMode().equals(GameMode.SPECTATOR)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void OnInteractInv(InventoryClickEvent e) {
		if(!e.getWhoClicked().getGameMode().equals(GameMode.CREATIVE) & !e.getWhoClicked().getGameMode().equals(GameMode.SPECTATOR)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void OnCancelDropInv(PlayerDropItemEvent e) {
		if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE) & !e.getPlayer().getGameMode().equals(GameMode.SPECTATOR)) {
			e.setCancelled(true);
		}
	}
	
}
