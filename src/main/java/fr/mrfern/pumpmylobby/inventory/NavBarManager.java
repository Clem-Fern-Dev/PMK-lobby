package fr.mrfern.pumpmylobby.inventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NavBarManager {

	private Inventory inv;
	private Player player;
	
	public NavBarManager(Player p) {
		setInv(p.getInventory());
		setPlayer(p);
	}
	
	public static void initConfig() {
		
	}
	
	public void giveItem(String serverName,int pos) {
		if(player.hasPermission("server." + serverName)) {
			ItemStack navItem = new ItemStack(Material.APPLE);
			ItemMeta navItemMeta = navItem.getItemMeta();
						
			navItemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + serverName);
			navItem.setItemMeta(navItemMeta);
			
			inv.setItem(pos, navItem);
		}else {
			
		}		
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
