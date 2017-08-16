package me.ikeetjeop.com;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import BetterNick.API.NickAPI;

public class Unnick implements Listener{
	private Main plugin;
	public Unnick(Main plugin) {
		this.plugin = plugin;
	}
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommandPreProcess(PlayerCommandPreprocessEvent e){
		String value = " \"ROM\" ";
		Player p = e.getPlayer();
		if(e.getMessage().toLowerCase().startsWith("/unnick")){
			if(p.hasPermission("Hypixel.unnick")){
				try{
					if(plugin.getConfig().getBoolean("Hypixel.KillPlayerWhenNicked") == true){
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule showDeathMessages false");
						p.setHealth(0);
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule showDeathMessages true");
					}
					if(plugin.getConfig().getBoolean("Hypixel.Hooking.PermissionsEx") == true){
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getUniqueId() + " prefix " + value + value + " " + p.getWorld().getName());
					} else {
						Main.getChat().setPlayerPrefix(p.getWorld(), p.getName(), "");
						BookS.Active.remove(p);
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manload");
						NickAPI.resetSkin(p.getUniqueId());
						NickAPI.UnNick(p.getUniqueId());
					}
				}catch (NullPointerException ev) {
				}
			} else {
				p.sendMessage(ChatColor.RED + "You are not allowed to do this!");
			}
		}
	}
}
