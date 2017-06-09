package net.minewave;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class TabHandler extends BukkitRunnable {
	
	private final JavaPlugin plugin;
	
	public TabHandler(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	
	public void run() {
		for(Player p : Bukkit.getOnlinePlayers()) {   
		
		if(!p.hasPermission("mwc.vip.tab")) {
			p.setPlayerListName(ChatColor.GRAY + p.getName());
		} else {
			p.setPlayerListName(ChatColor.GREEN + "[V] " + p.getName());
		}
		if(p.hasPermission("mwc.admin.tab")) {
			p.setPlayerListName(ChatColor.RED + "[A] " + p.getName());
		}
	}
	}





	

}
	