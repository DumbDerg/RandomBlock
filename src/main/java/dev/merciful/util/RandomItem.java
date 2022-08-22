package dev.merciful.util;

import dev.merciful.main.Plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Random;

public class RandomItem {
    public static Material getRandomItem() {
        Random random = new Random();
        List<String> blacklisted = Bukkit.getPluginManager().getPlugin("RandomBlock").getConfig().getStringList("Blacklisted Items");
        Material randomItem = Material.values()[random.nextInt(Material.values().length)];
        for (int i = 0; i < blacklisted.size(); i++) {
            if (randomItem.toString().equals(blacklisted.get(i))) {
                randomItem = Material.values()[random.nextInt(Material.values().length)];
                i = 0;
            }
        }
        return randomItem;
    }

    public static void givePlayersItem() {
        List<Player> players = (List<Player>) Bukkit.getServer().getOnlinePlayers();
        if (!players.isEmpty()) {
            if(!Plugin.plugin.getConfig().getBoolean("Same Item Per Player")){
            for (int j = 0; j < players.size(); j++) {
                if (players.get(j).hasPermission(Bukkit.getPluginManager().getPlugin("RandomBlock").getConfig().getString("Permission Name"))) {
                    if (!players.get(j).isDead() && !(players.get(j).getInventory().firstEmpty() == -1)) {
                        players.get(j).getInventory().addItem(new ItemStack(getRandomItem(), 1));
                    }else if(Plugin.plugin.getConfig().getBoolean("Drop Item If Full Inventory")){
                        players.get(j).getWorld().dropItemNaturally(players.get(j).getLocation(), new ItemStack(getRandomItem(), 1));
                    }
                }
                }
            }else {
                ItemStack item = new ItemStack(getRandomItem(), 1);
                for(int k = 0; k < players.size(); k++){
                    if (players.get(k).hasPermission(Bukkit.getPluginManager().getPlugin("RandomBlock").getConfig().getString("Permission Name"))) {
                        if (!players.get(k).isDead() && !(players.get(k).getInventory().firstEmpty() == -1)) {
                            players.get(k).getInventory().addItem(item);
                            }else if(Plugin.plugin.getConfig().getBoolean("Drop Item If Full Inventory")){
                                players.get(k).getWorld().dropItemNaturally(players.get(k).getLocation(), item);

                        }
                }
            }
        }
    }
}
}
