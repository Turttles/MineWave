package net.minewave;

import org.bukkit.plugin.java.JavaPlugin;

import me.Turttles.TRegister;

public class Main extends JavaPlugin {
	
	
	
	@Override
	public void onEnable() {
		
		new TRegister(this);
	}
}
