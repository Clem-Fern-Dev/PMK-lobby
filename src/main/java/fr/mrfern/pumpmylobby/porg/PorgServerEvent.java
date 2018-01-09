package fr.mrfern.pumpmylobby.porg;

import fr.mrfern.pumpmylobby.Main;

public class PorgServerEvent {
	
	public void OnServerStartEvent(MisterPorg misterP) {
		
		PorgTextChannel porgChan = misterP.getPorgTextChannel();		
		porgChan.sendPorgMessage("@everyone **" + Main.getServerInfo().getName() + " est en ligne et op�rationnel ! **\nRejoingnez nous en vous connectant via pumpmykins.eu").complete();

		misterP.close();
	}
	
	public void OnServerStopEvent(MisterPorg misterP) {
		
		PorgTextChannel porgChan = misterP.getPorgTextChannel();		
		porgChan.sendPorgMessage("@everyone **" + Main.getServerInfo().getName() + " est hors-ligne !** \nIl sera � nouveau disponible dans les plus brefs d�lais. Restez inform� des nouveaut�s et mises � jours sur le forum/discord/site !").complete();
	
		misterP.close();
	}
	
	
	
}
