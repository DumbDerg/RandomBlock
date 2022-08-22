package dev.merciful.main;

import org.bukkit.scheduler.BukkitTask;

public class Plugin {
    public static RandomBlock plugin;
    private static BukkitTask task;

    public Plugin(RandomBlock plugin) {
        Plugin.plugin = plugin;
    }
    public static void startTask(){
        Plugin.task = new GiveItems().runTaskTimer(plugin, 1L, 20L * Plugin.plugin.getConfig().getInt("Interval"));
    }
    public static void stopTask(){
        task.cancel();
    }
}
