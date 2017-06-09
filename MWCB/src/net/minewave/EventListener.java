package net.minewave;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class EventListener implements Listener{
	
	private ArrayList<UUID> cannotChat = new ArrayList<UUID>();
	String admin = "§c[Admin]";
	String vip = "§a[VIP]";
	String mod = "Moderator";
	FileConfiguration pd = Main.pdata;
	FileConfiguration rd = Main.rdata;

	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		UUID pu = p.getUniqueId();
		pd.set(pu.toString() + ".name" , p.getName());
		pd.set(pu.toString() + ".rank", "default");
		Object rank = pd.get(p.getUniqueId().toString() + ".Rank");
		Object prefix = rd.get(rank + ".prefix");
		prefix = prefix.toString().replaceAll("&", "§");
		e.setJoinMessage(prefix + p.getName());
		}
		
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		if(!p.hasPermission("mwc.vip.chat")) {
			
			e.setFormat(ChatColor.GRAY + p.getName() + ": " + ChatColor.WHITE + msg);
		} else {
			e.setFormat(ChatColor.GREEN + "[VIP] " + p.getName() + ": " + ChatColor.WHITE + msg);
		}
		if(p.hasPermission("mwc.admin")) {
			e.setFormat(ChatColor.RED + "[Admin] " + p.getName() + ": " + ChatColor.WHITE + msg);
		}
		
	}
	@EventHandler
	public void onCChat(AsyncPlayerChatEvent e) {
		String msg = e.getMessage();
		msg = msg.replaceAll("&", "§");
		e.setMessage(msg);
		final Player p = e.getPlayer();
		if(msg.contains("Turttles") | msg.contains("turt") | msg.contains("turts") | msg.contains("turtles") | msg.contains("turtt")) {
			
			p.sendMessage(ChatColor.GRAY + "Turttles is currently AFK. He will be back at around 6:30pm EST.");
		} else {
			return;
		}

    }




		
		
}


