package dev.merciful.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public final class RandomBlock extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("RandomBlock has started!");
        Plugin instance = new Plugin(this);
        saveDefaultConfig();
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, () -> {
            // Do something
        }, 0L, 20L);
    }

    }
        @Override
        public void onDisable() {
            Bukkit.getConsoleSender().sendMessage("RandomBlock has stopped!");
            // Plugin shutdown logic
        }
        }


