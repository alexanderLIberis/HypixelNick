package me.ikeetjeop.com;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

@SuppressWarnings("deprecation")
public class GetMessgae implements Listener {
	private Main plugin;
	public GetMessgae(Main plugin) {
		this.plugin = plugin;
	}
	private ArrayList<String> blacklist = new ArrayList<String>(); 
	static HashMap<Player, String> Rank = new HashMap<Player, String>();
	static HashMap<Player, String> PlayerSkin = new HashMap<Player, String>();
	static HashMap<Player, String> Nick = new HashMap<Player, String>();

	@EventHandler
	public void Command(PlayerChatEvent e) throws NullPointerException{
		Player p = e.getPlayer();
		if(p.getName() == BookS.player.get(p.getUniqueId())){
			if(BookS.getChat() == true){
				if(e.getMessage().length() <= 2){
					p.sendMessage(ChatColor.GREEN + "You name must be longer then 3 words!");
					e.setCancelled(true);
					BookS.setChat(false);
				} else {
					try{
						blacklist.addAll(plugin.getConfig().getStringList("Hypixel.Random.BlackListed"));
						if(blacklist.contains(e.getMessage())){
							p.sendMessage(ChatColor.RED + "BlackListed name");
							p.sendMessage(ChatColor.RED + "If you try to using blacklisted name's or abusive name's you can be banned!");
						}else{
							p.chat("/hnick " + Rank.get(p) + " " + PlayerSkin.get(p) + " " + "ENTERNICK " + e.getMessage().replace("&", "").replace("#", ""));
							e.setCancelled(true);
							BookS.setChat(false);
							BookS.Active.put(p, p.getName());
						}
					}catch (Exception pv) {
						p.sendMessage(ChatColor.RED + "Try another name!");
					}
				}
			}
		}
	}
}


