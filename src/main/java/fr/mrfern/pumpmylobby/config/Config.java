package fr.mrfern.pumpmylobby.config;

import java.io.File;
import org.bukkit.configuration.Configuration;
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
		/*
		File file = new File(main.getDataFolder(),fileName);
		
		if(!file.exists()) {
			try (InputStream in = main.getResourceAsStream(fileName)){
				Files.copy(in, file.toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return file;*/
		return null;
	}
	
	public Configuration getConfiguration(String fileName) throws Exception {
		/*
		File file = new File(main.getDataFolder(),fileName);
		
		try {
			return ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
		} catch (Exception e) {
			throw new Exception( fileName + " impossible de récupérer la configuration" );
		}	
		*/
		return null;
	}
	
}