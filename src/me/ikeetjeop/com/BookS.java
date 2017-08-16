package me.ikeetjeop.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import BetterNick.API.NickAPI;
import me.ikeetjeop.com.Book.ClickAction;
import me.ikeetjeop.com.Book.HoverAction;
import me.ikeetjeop.com.Book.PageBuilder;

public class BookS implements CommandExecutor{
	private Main plugin;
	public BookS(Main plugin) {
		this.plugin = plugin;
	}
	static boolean enabledChat = false;

	public static void setChat(boolean chat) {
		BookS.enabledChat = chat;
	}
	public static boolean getChat() {
		return BookS.enabledChat;
	}
	static HashMap<UUID, String> player = new HashMap<UUID, String>();
	static HashMap<Player, String> Rank = new HashMap<Player, String>();
	static HashMap<Player, String> Active = new HashMap<Player, String>();
	ArrayList<String> Alex = new ArrayList<>();
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		ArrayList<String> Skin = (ArrayList<String>) plugin.getConfig().getStringList("Hypixel.Random.Skin");
		Player p = (Player) sender;
		if(p.hasPermission("Hypixel.nick")){
			if(cmd.getName().equalsIgnoreCase("nick") || cmd.getName().equalsIgnoreCase("hnick")){
				if(args.length == 0){
					Book book = new Book("Nick", "Ranks");
					PageBuilder page1 = book.addPage();
					page1.add("Let's get you set up\nWith your nickname!\nFirst, you'll need to choose wich " + ChatColor.BOLD + "RANK" + ChatColor.BLACK + "\nyou would like to be\nshown as when nicked.\n").build();
					page1.add("\n").build();
					String arrow = "\u27A4";
					page1.add(arrow + " " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Default.Book")) + "\n").clickEvent(ClickAction.Run_Command, "/hnick DEFAULT").hoverEvent(HoverAction.Show_Text,ChatColor.WHITE + "Click here to be show as " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Default.Book"))).build();
					page1.add(arrow + " " +ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Vip.Book")) + "\n").clickEvent(ClickAction.Run_Command, "/hnick VIP").hoverEvent(HoverAction.Show_Text,ChatColor.WHITE + "Click here to be show as " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Vip.Book"))).build();
					page1.add(arrow + " " +ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Vip+.Book")) + "\n").clickEvent(ClickAction.Run_Command, "/hnick VIPPLUS").hoverEvent(HoverAction.Show_Text,ChatColor.WHITE + "Click here to be show as " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Vip+.Book"))).build();
					page1.add(arrow + " " +ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Mvp.Book")) + "\n").clickEvent(ClickAction.Run_Command, "/hnick MVP").hoverEvent(HoverAction.Show_Text,ChatColor.WHITE + "Click here to be show as " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Mvp.Book"))).build();
					page1.add(arrow + " " +ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Mvp+.Book")) + "\n").clickEvent(ClickAction.Run_Command, "/hnick MVPPLUS").hoverEvent(HoverAction.Show_Text,ChatColor.WHITE + "Click here to be show as " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Mvp+.Book"))).build();
					page1.build();
					Book.open(p, book.build(), false);
				}
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("reload")){
						if(p.hasPermission("Hypixel.reload")){
							plugin.reloadConfig();
							p.sendMessage(ChatColor.GOLD + "Reloaded!");
						} else {
							p.sendMessage(ChatColor.RED + "You are not allowed to do this!");
						}
					}
					if(args[0].equalsIgnoreCase("Default") || args[0].equalsIgnoreCase("vip")|| args[0].equalsIgnoreCase("vipplus")|| args[0].equalsIgnoreCase("mvp")|| args[0].equalsIgnoreCase("mvpplus")){
						Book booka = new Book("Nick", "Default");
						PageBuilder page2 = booka.addPage();
						page2.add("Awesome! Now, wich").build();
						page2.add("\n" + ChatColor.BOLD + "SKIN " + ChatColor.BLACK + "would you like\nto have while nicked?\n").build();
						page2.add("\n").build();
						String arrow = "\u27A4";
						page2.add(arrow + ChatColor.BLACK + " My normal skin\n").clickEvent(ClickAction.Run_Command, "/hnick " + args[0] + " MYSKIN").hoverEvent(HoverAction.Show_Text,ChatColor.WHITE + "Click here to use your normal skin").build();
						page2.add(arrow + ChatColor.BLACK + " Steven/Alex skin\n").clickEvent(ClickAction.Run_Command, "/hnick " + args[0] + " STEVEN").hoverEvent(HoverAction.Show_Text,ChatColor.WHITE + "Click here to use a Steven/Alex skin").build();
						page2.add(arrow + ChatColor.BLACK + " Random skin\n").clickEvent(ClickAction.Run_Command, "/hnick " + args[0] + " RANDOMSKIN").hoverEvent(HoverAction.Show_Text,ChatColor.WHITE + "Click here to use a random present skin").build();
						page2.build();
						Book.open(p, booka.build(), false);
						if(args[0].equalsIgnoreCase("default")){
							p.sendMessage(ChatColor.GREEN + "Set your nick rank to " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Default.Book")) + ChatColor.GREEN + "!");
						} else if(args[0].equalsIgnoreCase("vip")){
							p.sendMessage(ChatColor.GREEN + "Set your nick rank to " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Vip.Book")) + ChatColor.GREEN + "!");
						} else if(args[0].equalsIgnoreCase("vipplus")){
							p.sendMessage(ChatColor.GREEN + "Set your nick rank to " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Vip+.Book")) + ChatColor.GREEN + "!");
						}else if(args[0].equalsIgnoreCase("mvp")){
							p.sendMessage(ChatColor.GREEN + "Set your nick rank to " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Mvp.Book")) + ChatColor.GREEN + "!");
						}else if(args[0].equalsIgnoreCase("mvpplus")){
							p.sendMessage(ChatColor.GREEN + "Set your nick rank to " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Mvp+.Book")) + ChatColor.GREEN + "!");
						}
					}
				}
				if(args.length == 2){
					if(args[1].equalsIgnoreCase("myskin") || args[1].equalsIgnoreCase("steven") || args[1].equalsIgnoreCase("randomskin")){
						Book booka = new Book("Nick", "mynick");
						PageBuilder page2 = booka.addPage();
						page2.add("Alright, Now you'll need\nto choose the " + ChatColor.BOLD + "NAME" + ChatColor.BLACK + " to use!\n").build();
						page2.add("\n").build();
						String arrow = "\u27A4";
						page2.add(arrow + ChatColor.BLACK + " Enter a name\n").clickEvent(ClickAction.Run_Command, "/hnick " + args[0] + " " + args[1] + " ENTERNICK").hoverEvent(HoverAction.Show_Text,ChatColor.WHITE + "Click here to use your normal skin").build();
						page2.add(arrow + ChatColor.BLACK + " Use a random name\n").clickEvent(ClickAction.Run_Command, "/hnick " + args[0] + " " + args[1] + " RANDOMNICK").hoverEvent(HoverAction.Show_Text,ChatColor.WHITE + "Click here to use a Steven/Alex skin").build();
						page2.add("\n").build();
						page2.add("To go back te being\nyour usual self, type:\n" + ChatColor.BOLD + "/unnick").build();
						page2.build();
						Book.open(p, booka.build(), false);
					}
				}
				if(args.length == 3){
					if(args[2].equalsIgnoreCase("ENTERNICK")){
						if(getChat() == false){
							player.put(p.getUniqueId(), p.getName());
							p.sendMessage("Enter your username in chat!");
							GetMessgae.Rank.put(p, args[0]);
							GetMessgae.PlayerSkin.put(p, args[1]);
							GetMessgae.Nick.put(p, p.getName());
							setChat(true);
						} else {
							p.sendMessage(ChatColor.GREEN + "Another player is now in the ChatHandler! soon you can use /hnick <nick>");
						}
					}
					ArrayList<String> Nicks = (ArrayList<String>) plugin.getConfig().getStringList("Hypixel.Random.Nicks");
					if(args[2].equalsIgnoreCase("randomnick")){
						Book booka = new Book("Nick", "randomnick");
						PageBuilder page2 = booka.addPage();
						Random randomNick = new Random();
						int indexNick = randomNick.nextInt(Nicks.size());
						page2.add("We've generated a\nrandom username for\nyou:\n" + ChatColor.BOLD + Nicks.get(indexNick) + "\n").build();
						page2.add("\n").build();
						page2.add(ChatColor.GREEN + "     " + ChatColor.UNDERLINE + ChatColor.BOLD + "USE NAME\n").clickEvent(ClickAction.Run_Command, "/hnick " + args[0] + " " + args[1] + " " + " ENTERNICK " + Nicks.get(indexNick)).hoverEvent(HoverAction.Show_Text,ChatColor.WHITE + "Click here to use this name.").build();
						page2.add(ChatColor.RED + "    " + ChatColor.UNDERLINE + ChatColor.BOLD + "TRY AGAIN\n").clickEvent(ClickAction.Run_Command, "/hnick " + args[0] + " " + args[1] + " " + args[2]).hoverEvent(HoverAction.Show_Text,ChatColor.WHITE + "Click here to generate another name.").build();
						page2.add("\n").build();
						page2.add(ChatColor.BLACK + "" + ChatColor.UNDERLINE + "Or enter a name to " + ChatColor.BLACK + "" + ChatColor.UNDERLINE  +"use.").clickEvent(ClickAction.Run_Command, "/hnick " + args[0] + " " + args[1] + " ENTERNICK").hoverEvent(HoverAction.Show_Text,ChatColor.WHITE + "Click here to use this name.").build();
						page2.build();
						Book.open(p, booka.build(), false);
					}
				}
			}
			if(args.length == 4){	
				if(args[0].equalsIgnoreCase("default")){
					Main.getChat().setPlayerPrefix(p.getWorld(), p.getName(), ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Default.Chat")));
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), plugin.getConfig().getString("Hypixel.RankPluginReloadCommand").replace("/", ""));
				}
				if(args[0].equalsIgnoreCase("vip")){
					Main.getChat().setPlayerPrefix(p.getWorld(),p.getName(), ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Vip.Chat")));
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), plugin.getConfig().getString("Hypixel.RankPluginReloadCommand").replace("/", ""));
				}
				if(args[0].equalsIgnoreCase("vipplus")){
					Main.getChat().setPlayerPrefix(p.getWorld(), p.getName(), ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Vip+.Chat")));
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), plugin.getConfig().getString("Hypixel.RankPluginReloadCommand").replace("/", ""));
				}
				if(args[0].equalsIgnoreCase("mvp")){
					Main.getChat().setPlayerPrefix(p.getWorld(), p.getName(), ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Mvp.Chat")));
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), plugin.getConfig().getString("Hypixel.RankPluginReloadCommand").replace("/", ""));
				}
				if(args[0].equalsIgnoreCase("mvpplus")){
					Main.getChat().setPlayerPrefix(p.getWorld(), p.getName(), ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Mvp+.Chat")));
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), plugin.getConfig().getString("Hypixel.RankPluginReloadCommand").replace("/", ""));
				}
				if(args[2].equalsIgnoreCase("enternick")){
					try{
						/////
						if(args[0].equalsIgnoreCase("default")){
							if(plugin.getConfig().getBoolean("Hypixel.Hooking.PermissionsEx") == true){
								Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getUniqueId() + " prefix " + plugin.getConfig().getString("Hypixel.Ranks.Default.Chat") + " " + p.getWorld().getName() );
							} else  {
								NickAPI.setNickName(p.getUniqueId(), args[3], Main.getChat().getPlayerPrefix(p), "", ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Default.Chat")));
							}
						}
						/////
						if(args[0].equalsIgnoreCase("vip")){
							if(plugin.getConfig().getBoolean("Hypixel.Hooking.PermissionsEx") == true){
								Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getUniqueId() + " prefix " + plugin.getConfig().getString("Hypixel.Ranks.Vip.Chat") + " " + p.getWorld().getName());
							} else  {
								NickAPI.setNickName(p.getUniqueId(), args[3], Main.getChat().getPlayerPrefix(p), "", ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Vip.Chat")));
							}
						}
						/////
						if(args[0].equalsIgnoreCase("vipplus")){
							if(plugin.getConfig().getBoolean("Hypixel.Hooking.PermissionsEx") == true){
								Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getUniqueId() + " prefix " + plugin.getConfig().getString("Hypixel.Ranks.Vip+.Chat")+ " " + p.getWorld().getName());
							} else  {
								NickAPI.setNickName(p.getUniqueId(), args[3], Main.getChat().getPlayerPrefix(p), "", ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Vip+.Chat")));
							}
						}
						/////
						if(args[0].equalsIgnoreCase("mvp")){
							if(plugin.getConfig().getBoolean("Hypixel.Hooking.PermissionsEx") == true){
								Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getUniqueId() + " prefix " + plugin.getConfig().getString("Hypixel.Ranks.Mvp.Chat") + " " + p.getWorld().getName());
							} else  {
								NickAPI.setNickName(p.getUniqueId(), args[3], Main.getChat().getPlayerPrefix(p), "", ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Mvp.Chat")));
							}
						}
						////
						if(args[0].equalsIgnoreCase("mvpplus")){
							if(plugin.getConfig().getBoolean("Hypixel.Hooking.PermissionsEx") == true){
								Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getUniqueId() + " prefix " + plugin.getConfig().getString("Hypixel.Ranks.Mvp+.Chat")+ " " +p.getWorld().getName());
							} else  {
								NickAPI.setNickName(p.getUniqueId(), args[3], Main.getChat().getPlayerPrefix(p), "", ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Hypixel.Ranks.Mvp+.Chat")));
							}
						}
					}catch (NullPointerException e) {
					}
					if(plugin.getConfig().getBoolean("Hypixel.KillPlayerWhenNicked") == true){
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule showDeathMessages false");
						p.setHealth(0);
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule showDeathMessages true");
					}
					p.sendMessage(ChatColor.GREEN + "Your are now nicked as " + args[3]);
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), plugin.getConfig().getString("Hypixel.RankPluginReloadCommand").replace("/", ""));
				}
				if(args[1].equalsIgnoreCase("myskin")){
					try{
						NickAPI.resetSkin(p.getUniqueId());
					}catch (NullPointerException e) {
					}
				}
				if(args[1].equalsIgnoreCase("steven")){
					Alex.add("Alex");
					Alex.add("Steve");
					Random randomSteven = new Random();
					int indexSteven = randomSteven.nextInt(Alex.size());
					NickAPI.setSkin(p.getUniqueId(), Alex.get(indexSteven));
				}
				if(args[1].equalsIgnoreCase("randomskin")){
					try{
						Random randomS = new Random();
						int index = randomS.nextInt(Skin.size());
						NickAPI.setSkin(p.getUniqueId(), Skin.get(index));
					}catch (NullPointerException e) {
					}
				}
			}
		}else {
			p.sendMessage(ChatColor.RED + "You are not allowed to do this!");
		}
		return false;
	}



}
