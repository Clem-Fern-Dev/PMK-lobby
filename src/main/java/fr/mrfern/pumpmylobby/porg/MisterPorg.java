package fr.mrfern.pumpmylobby.porg;

import javax.security.auth.login.LoginException;

import fr.mrfern.pumpmylobby.Main;

//this.getJda().getTextChannelById("387326167499276292")

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

public class MisterPorg {

	private JDA jda;
	private boolean isOK;
	private Main main;
	private PorgTextChannel porgTextChannel;
	
	

	public MisterPorg(Main m,String token,String channelID) {
		isOK = false;
		main = m;
		
		try {
			jda = new JDABuilder(AccountType.BOT).setToken(token).buildBlocking();
			isOK = true;
			
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RateLimitedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(jda == null) {
			System.out.println("erreur jda null");
		}else {
			if(isOK) {
				main.getLogger().info(" JDA communication ... succes !");	
				
				porgTextChannel = new PorgTextChannel(this, channelID);
				
				/*porgTextChannel.sendMessage("Bungee restarted").complete();
				porgTextChannel.sendMessage(new Exception("error null").toString()).complete();*/
				
				
				/*if(!porgTextChannel.isOK()) {
					main.getLogger().severe(" JDA PorgTextChannel initialisation ... echec !");
					forceClose();
				}else {
					main.getLogger().info(" JDA PorgTextChannel initialisation ... succes !");
					//initDefaultChannel(porgTextChannel);
				}*/
			}else {
				main.getLogger().severe(" JDA communication ... echec !");
				forceClose();
			}
		}		
	}
	
	
	public void close() {
		main.getLogger().warning(" JDA shutdown !");
		jda.shutdown();		
	}
	
	private void forceClose() {
		main.getLogger().severe(" JDA force shutodown !");
		jda.shutdownNow();		
	}


	public MisterPorg addListener(Object... listeners) {
		jda.addEventListener(listeners);
		return this;
	}

	public JDA getJda() {
		return jda;
	}

	public void setJda(JDA jda) {
		this.jda = jda;
	}

	public boolean isOK() {
		return isOK;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public PorgTextChannel getPorgTextChannel() {
		return porgTextChannel;
	}

	public void setPorgTextChannel(PorgTextChannel porgTextChannel) {
		this.porgTextChannel = porgTextChannel;
	}
	
}
