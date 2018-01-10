package fr.mrfern.pumpmylobby.porg;

import org.bukkit.configuration.file.FileConfiguration;

import fr.mrfern.pumpmylobby.Main;
import net.dv8tion.jda.core.MessageBuilder;

public class PorgServerEvent {
	
	public void OnServerStartEvent(MisterPorg misterP) {
		
		FileConfiguration config = Main.getMain().getConfig();
		PorgTextChannel porgChan = misterP.getPorgTextChannel();
		
		if(config.getBoolean("discord.debug_mod")) {
			porgChan.sendPorgMessage(new MessageBuilder().append(misterP.getJda().getTextChannelById("375790951081181187")).append(" __debug_mod__ **" + Main.getServerInfo().getServerName() + " est en ligne et opérationnel ! ** \nRejoingnez nous en vous connectant via pumpmykins.eu").build())
			.complete();
		}else {					
			porgChan.sendPorgMessage("@everyone **" + Main.getServerInfo().getServerName() + " est en ligne et opérationnel ! **\nRejoingnez nous en vous connectant via pumpmykins.eu").complete();
		}
		misterP.close();
	}
	
	public void OnServerStopEvent(MisterPorg misterP) {
		
		FileConfiguration config = Main.getMain().getConfig();
		PorgTextChannel porgChan = misterP.getPorgTextChannel();
		
		if(config.getBoolean("discord.debug_mod")) {
			porgChan.sendPorgMessage(new MessageBuilder().append(misterP.getJda().getTextChannelById("375790951081181187")).append(" __debug_mod__ **" + Main.getServerInfo().getServerName() + " est hors-ligne !** \nIl sera à nouveau disponible dans les plus brefs délais. Restez informé des nouveautés et mises à jours sur le forum/discord/site !").build())
			.complete();
		}else {					
			porgChan.sendPorgMessage("@everyone **" + Main.getServerInfo().getServerName() + " est hors-ligne !** \nIl sera à nouveau disponible dans les plus brefs délais. Restez informé des nouveautés et mises à jours sur le forum/discord/site !").complete();
		}
		misterP.close();
	}
	
	
	
}
