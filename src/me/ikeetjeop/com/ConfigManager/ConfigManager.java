package me.ikeetjeop.com.ConfigManager;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.ikeetjeop.com.Main;


public class ConfigManager {

	protected Main main;
	protected File file;
	protected FileConfiguration config;

	public ConfigManager(Main main, String FileName) {
		this.main = main;
		this.file = new File(main.getDataFolder() + "/" + FileName);
		if(!file.exists()){
			try{
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.config = YamlConfiguration.loadConfiguration(file);
	}

	public void save(){
		try{
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void reload(){
		try{
			try {
				config.load(file);
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
