package dev.merciful.commands;

import dev.merciful.main.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RandomBlockCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("RB.Admin")) {
            if (args.length == 0) {
                boolean enabled = Bukkit.getPluginManager().getPlugin("RandomBlock").getConfig().getBoolean("Enabled");
                if (!enabled) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aEnabled RandomBlock!\nThis will give a random item every " + Bukkit.getPluginManager().getPlugin("RandomBlock").getConfig().getInt("Interval") + " seconds!"));
                    Bukkit.getPluginManager().getPlugin("RandomBlock").getConfig().set("Enabled", true);
                    Plugin.plugin.saveConfig();
                    Plugin.plugin.reloadConfig();
                    Plugin.startTask();
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4RandomBlock has been disabled!"));
                    Bukkit.getPluginManager().getPlugin("RandomBlock").getConfig().set("Enabled", false);
                    Plugin.plugin.saveConfig();
                    Plugin.plugin.reloadConfig();
                    Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED+"RandomBlock has been disabled!");
                    Plugin.stopTask();
                }
            } else if(args[0].equals("reload")){
                sender.sendMessage("RandomBlock: Config.yml has reloaded!");
                Plugin.stopTask();
                Plugin.plugin.reloadConfig();
                Plugin.startTask();
            }else {
                sender.sendMessage("RandomBlock: Unknown sub command!");
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4RandomBlock: You do not have permission to preform this command!"));
        }
        return true;
    }}
