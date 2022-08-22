package dev.merciful.main;

import org.bukkit.scheduler.BukkitTask;

public class Plugin {
    public static RandomBlock plugin;
    public static BukkitTask task;

    public Plugin(RandomBlock plugin) {
        Plugin.plugin = plugin;
    }
    public static void startTask(){
        BukkitTask task = new GiveItems().runTaskTimer(plugin, 1, 20L * Plugin.plugin.getConfig().getInt("Interval"));
        task = Plugin.task;
    }
    public static void stopTask(){
        task.cancel();
    }
}
