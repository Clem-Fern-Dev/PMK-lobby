package fr.mrfern.pumpmylobby.inventory;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryListener implements Listener {

	@EventHandler
	public void OnJoinSetInv(PlayerJoinEvent e) {
		Player p = e.getPlayer();	
		Inventory inv = p.getInventory();
		
		inv.clear();
		
		if(p.hasPermission("server.ragna1")) {
			ItemStack navItemRagna1 = new ItemStack(Material.APPLE);
			ItemMeta navItemRagna1Meta = navItemRagna1.getItemMeta();
						
			navItemRagna1Meta.setDisplayName(Color.PURPLE + "PumpMyRagna#1");
			navItemRagna1.setItemMeta(navItemRagna1Meta);
			
			inv.setItem(2, navItemRagna1);
		}
		
		if(p.hasPermission("server.dev")) {
			ItemStack navItemDev = new ItemStack(Material.BEDROCK);
			ItemMeta navItemDevMeta = navItemDev.getItemMeta();
			
			navItemDevMeta.setDisplayName(Color.YELLOW + "development_server");
			navItemDev.setItemMeta(navItemDevMeta);
			
			inv.setItem(4,navItemDev);
		}
		
		if(p.hasPermission("server.ragna2")) {
			ItemStack navItemRagna2 = new ItemStack(Material.CARROT);
			ItemMeta navItemRagna2Meta = navItemRagna2.getItemMeta();
			
			navItemRagna2Meta.setDisplayName(Color.FUCHSIA + "PumpMyRagna#2");
			navItemRagna2.setItemMeta(navItemRagna2Meta);
			
			inv.setItem(6, navItemRagna2);
		}
	}
	
	public void OnCancelModifInv() {
		
	}
	
}
