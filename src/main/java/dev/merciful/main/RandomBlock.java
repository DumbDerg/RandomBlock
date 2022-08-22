package dev.merciful.main;

import dev.merciful.commands.RandomBlockCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class RandomBlock extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("RandomBlock has started!");
        Plugin instance = new Plugin(this);
        Plugin.startTask();
        saveDefaultConfig();
        getCommand("randomblock").setExecutor(new RandomBlockCommand());
        if(!getConfig().getBoolean("Enabled")){
            Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED+"RandomBlock is disabled!");
        }

    }

        @Override
        public void onDisable() {
            Bukkit.getConsoleSender().sendMessage("RandomBlock has stopped!");
            // Plugin shutdown logic
        }
        }


