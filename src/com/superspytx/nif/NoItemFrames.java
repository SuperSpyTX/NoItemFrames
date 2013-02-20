package com.superspytx.nif;

import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoItemFrames extends JavaPlugin implements Listener {
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getLogger().info("NoItemFrames enabled!");
	}
	
	public void onDisable() {
		getLogger().info("NoItemFrames disabled!");
	}
	
	@EventHandler
	public void hang(HangingPlaceEvent e) {
		if (e.getPlayer().hasPermission("noitemframes.bypass")) return;
		if (e.getEntity() instanceof ItemFrame) {
			e.setCancelled(true);
		}
	}
}
