package fr.mrfern.pumpmylobby.inventory;

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
		
		System.out.println(itemName);
		
		if(itemName.equals("")) {
			
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
