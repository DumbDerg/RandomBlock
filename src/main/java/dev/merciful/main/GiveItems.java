package dev.merciful.main;

import dev.merciful.util.RandomItem;
import org.bukkit.scheduler.BukkitRunnable;

public class GiveItems extends BukkitRunnable {

    @Override
    public void run() {
        // What you want to schedule goes here
     if(Plugin.plugin.getConfig().getBoolean("Enabled")){
         RandomItem.givePlayersItem();
     }else {
         cancel();
     }
    }

}