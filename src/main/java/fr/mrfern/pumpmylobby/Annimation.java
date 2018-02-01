package fr.mrfern.pumpmylobby;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Annimation {
	
	private static ArmorStand armorS;
	private static boolean updownState;
	
	public static void initTask(Plugin p,ArmorStand armor) {
		armorS = armor;
		BukkitScheduler sch = p.getServer().getScheduler();
		
		sch.scheduleSyncRepeatingTask(p, new Annimation().getRotate(), 0, 1);
		sch.scheduleSyncRepeatingTask(p, new Annimation().getUpdate(), 0, 200);
	}

	private Runnable getUpdate() {
		return new Runnable() {
			
			@Override
			public void run() {
				ArmorStand armorS = getArmorS();
				
				armorS.setCustomName(ChatColor.RED + "test " + System.lineSeparator() +"test");
			}
		};
	}

	public Runnable getRotate() {
		return new Runnable() {
			
			@Override
			public void run() {
				//System.out.println("run 2");
				ArmorStand armor = Annimation.getArmorS();
				
				float yaw = armor.getLocation().getYaw();
				
				yaw += 1;
				
				Location loc = new Location(armor.getWorld(),armor.getLocation().getX(),armor.getLocation().getY(),armor.getLocation().getZ());
				loc.setYaw(yaw);
				armor.teleport(loc);			
				
			}
		};
	}
	
	public static ArmorStand getArmorS() {
		return armorS;
	}

	public static void setArmorS(ArmorStand armorS) {
		Annimation.armorS = armorS;
	}

	public static boolean isUpdownState() {
		return updownState;
	}

	public static void setUpdownState(boolean updownState) {
		Annimation.updownState = updownState;
	}

}
