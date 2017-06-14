package me.Turttles;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Example implements Listener {
	
	
	
	@EventHandler
	public void playerJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		e.setJoinMessage(p.getName() + " did a join.");
		
		p.sendMessage("you did a join");
		
		
	}
	
}