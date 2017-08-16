package me.ikeetjeop.com;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.chat.Chat;

public class Main extends JavaPlugin{

	public static Chat chat = null;
	@Override
	public void onEnable(){
		registerCommands();
		setupChat();
		config();
	}
	
	
	private boolean setupChat()
	{
		RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
		if (chatProvider != null) {
			chat = chatProvider.getProvider();
		}

		return (chat != null);
	}
	public static Chat getChat() {
		return chat;
	}
	public void config(){
		String[] Nicks = {"Ikeetjeop", "Skeppy", "Jif", "Dawrk", "Airay", "SemNick", "Spesko", "ForceClient_" , "_ROBIN_", "FRUS", "Bye", "RIPBye"};
		String[] Skin = {"Ikeetjeop", "Skeppy", "Jif", "Dawrk", "Airay", "SemNick", "Spesko", "ForceClient_" , "_ROBIN_", "FRUS", "Bye", "RIPBye"};
		String[] BlackList = {"Notch", "Jeb_"};
		getConfig().addDefault("Hypixel.Ranks.Default.Book", "&7Default");
		getConfig().addDefault("Hypixel.Ranks.Default.Chat", "&7");
		//
		getConfig().addDefault("Hypixel.Ranks.Vip.Book", "&aVIP");
		getConfig().addDefault("Hypixel.Ranks.Vip.Chat", "&a[VIP] &a");
		//
		getConfig().addDefault("Hypixel.Ranks.Vip+.Book", "&aVIP&6+");
		getConfig().addDefault("Hypixel.Ranks.Vip+.Chat", "&a[VIP&6+&a] &a");
		//
		getConfig().addDefault("Hypixel.Ranks.Mvp.Book", "&bMVP");
		getConfig().addDefault("Hypixel.Ranks.Mvp.Chat", "&b[MVP] &b");
		//
		getConfig().addDefault("Hypixel.Ranks.Mvp+.Book", "&bMVP&c+");
		getConfig().addDefault("Hypixel.Ranks.Mvp+.Chat", "&b[MVP&c+&b] &b");
		getConfig().addDefault("Hypixel.RankPluginReloadCommand", "/manload");
		getConfig().addDefault("Hypixel.Random.Nicks", Nicks);
		getConfig().addDefault("Hypixel.Random.Skin", Skin);
		getConfig().addDefault("Hypixel.KillPlayerWhenNicked", false);
		getConfig().addDefault("Hypixel.Random.BlackListed", BlackList);
		getConfig().addDefault("Hypixel.Hooking.PermissionsEx", false);
		
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public void registerConfig(){
		if(!getDataFolder().exists()){
			getDataFolder().mkdirs();
		}
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	public void registerCommands(){
		getCommand("nick").setExecutor(new BookS(this));
		getCommand("hnick").setExecutor(new BookS(this));
		Bukkit.getPluginManager().registerEvents(new GetMessgae(this), this);
		Bukkit.getPluginManager().registerEvents(new Unnick(this), this);
	}
}
