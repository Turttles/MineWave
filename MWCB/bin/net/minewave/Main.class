package net.minewave;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;



public class Main extends JavaPlugin  {
	
	public static FileConfiguration pdata;
	public static File pdatafile;
	public static FileConfiguration rdata;
	public static File rdatafile;
	
	public void onEnable() {
		registerE();


		@SuppressWarnings("unused")
		BukkitTask TabChange = new TabHandler(this).runTaskTimer(this, 40, 200);
		new TabHandler(this);
		setup();
		save();
    }
	
	private void registerE() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new EventListener(), this);

	}
	
	private void setup() {
		pdata = getConfig();
		pdata.options().copyDefaults(false);
		pdatafile = new File(getDataFolder(), "player-data.yml");
		pdata = YamlConfiguration.loadConfiguration(pdatafile);
		
		rdata = getConfig();
		rdata.options().copyDefaults(false);
		rdatafile = new File(getDataFolder(), "rank-data.yml");
		rdata = YamlConfiguration.loadConfiguration(rdatafile);
	
		save();
	}

	public static void save() {
		try {
			pdata.save(pdatafile);
			rdata.save(rdatafile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
}
