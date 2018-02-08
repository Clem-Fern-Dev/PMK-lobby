package fr.mrfern.pumpmylobby.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.YamlConfigurationOptions;

import fr.mrfern.pumpmylobby.Main;

public class Config {

	private static Config config = new Config();
	private static Main main;
	
	public static Config getConfig(Main m) {
		main = m;
		return config;
	}

public void initDataFolder() {
		
		if(!main.getDataFolder().exists()) {
			main.getDataFolder().mkdir();
		}
		
	}
	
	public File initAndGetFile(String fileName) {
		
		File file = new File(main.getDataFolder(),fileName);
		
		if(!file.exists()) {
			file.getParentFile().mkdirs();
            main.saveResource(fileName, false);    
		}
		return file;
	}
	
	public YamlConfiguration getConfiguration(String fileName){
		
		File file = new File(main.getDataFolder(),fileName);
		
		if(file.exists()) {
			YamlConfiguration conf = new YamlConfiguration();
			
			try {
				conf.load(file);
				return conf;
			} catch (IOException | InvalidConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		
		return null;		
	}

	public void initMySQLConnect(String url, String user, String mdp, String base) {
		MySQLConnector.setUrl(url);
		MySQLConnector.setUser(user);
		MySQLConnector.setMdp(mdp);
		MySQLConnector.setPort(3306);
		MySQLConnector.setBase(base);
	}
}