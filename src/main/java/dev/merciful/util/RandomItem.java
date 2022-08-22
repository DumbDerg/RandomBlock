package dev.merciful.util;

import dev.merciful.main.GiveItems;
import dev.merciful.main.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Random;

public class RandomItem {
    private static Material getRandomItem() {
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
        if(!players.isEmpty()){
        for (int j = 0; j < players.size(); j++) {
            if (players.get(j).hasPermission(Bukkit.getPluginManager().getPlugin("RandomBlock").getConfig().getString("Permission Name"))) {
                players.get(1).getInventory().addItem(new ItemStack(getRandomItem(), 1));

            }}
        }
    }
    public static void runTask(){
        GiveItems run = new GiveItems();
        if(Plugin.plugin.getConfig().getBoolean("Enabled")) {
            run.runTask(Plugin.plugin);
        }else{
            run.runTask(Plugin.plugin).cancel();
        }
    }
}