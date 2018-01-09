package fr.mrfern.pumpmylobby.porg;

import fr.mrfern.pumpmylobby.Main;

public class PorgServerEvent {
	
	public void OnServerStartEvent(MisterPorg misterP) {
		
		PorgTextChannel porgChan = misterP.getPorgTextChannel();		
		porgChan.sendPorgMessage("@everyone **" + Main.getServerInfo().getName() + " est en ligne et opérationnel ! **\nRejoingnez nous en vous connectant via pumpmykins.eu").complete();

		misterP.close();
	}
	
	public void OnServerStopEvent(MisterPorg misterP) {
		
		PorgTextChannel porgChan = misterP.getPorgTextChannel();		
		porgChan.sendPorgMessage("@everyone **" + Main.getServerInfo().getName() + " est hors-ligne !** \nIl sera à nouveau disponible dans les plus brefs délais. Restez informé des nouveautés et mises à jours sur le forum/discord/site !").complete();
	
		misterP.close();
	}
	
	
	
}
