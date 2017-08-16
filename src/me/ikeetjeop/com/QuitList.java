package me.ikeetjeop.com;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitList implements Listener{
	
	@EventHandler
	public void PlayerQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		BookS.Active.remove(p.getUniqueId());
	}

}
