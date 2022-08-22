package dev.merciful.main;

import dev.merciful.util.RandomItem;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class GiveItems extends BukkitRunnable {

    @Override
    public void run() {
        // What you want to schedule goes here
        if (counter > 0) {
            plugin.getServer().broadcastMessage("Commence greeting in " + counter--);
        } else {
            plugin.getServer().broadcastMessage("Welcome to Bukkit! Remember to read the documentation!");
            this.cancel();
        }
    }

}