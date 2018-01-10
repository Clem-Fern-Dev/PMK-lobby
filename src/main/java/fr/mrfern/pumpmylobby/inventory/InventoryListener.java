package fr.mrfern.pumpmylobby.inventory;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryListener implements Listener {

	@EventHandler
	public void OnJoinSetInv(PlayerJoinEvent e) {
		
		System.out.println("PlayerJoinEvent call");
		
		Player p = e.getPlayer();	
		Inventory inv = p.getInventory();
		NavBarManager m = new NavBarManager(p);
		
		inv.clear();
		
		if(p.hasPermission("server.ragna1")) {
			ItemStack navItemRagna1 = new ItemStack(Material.APPLE);
			ItemMeta navItemRagna1Meta = navItemRagna1.getItemMeta();
						
			navItemRagna1Meta.setDisplayName(ChatColor.LIGHT_PURPLE + "PumpMyRagna#1");
			navItemRagna1.setItemMeta(navItemRagna1Meta);
			
			inv.setItem(2, navItemRagna1);
		}else {
			
		}
		
		if(p.hasPermission("server.dev")) {
			ItemStack navItemDev = new ItemStack(Material.BEDROCK);
			ItemMeta navItemDevMeta = navItemDev.getItemMeta();
			
			navItemDevMeta.setDisplayName(ChatColor.YELLOW + "development_server");
			navItemDev.setItemMeta(navItemDevMeta);
			
			inv.setItem(4,navItemDev);
		}else {
			
		}
		
		if(p.hasPermission("server.ragna2")) {
			ItemStack navItemRagna2 = new ItemStack(Material.BREAD);
			ItemMeta navItemRagna2Meta = navItemRagna2.getItemMeta();
			
			navItemRagna2Meta.setDisplayName(ChatColor.AQUA + "PumpMyRagna#2");
			navItemRagna2.setItemMeta(navItemRagna2Meta);
			
			inv.setItem(6, navItemRagna2);
		}else {
			
		}
	}
	
	@EventHandler
	public void OnCancelDropInv(PlayerDropItemEvent e) {
		if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE) & !e.getPlayer().getGameMode().equals(GameMode.SPECTATOR)) {
			e.setCancelled(true);
		}
	}
	
}
