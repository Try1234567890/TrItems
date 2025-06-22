package me.tr.trItems.hooks;

import org.bukkit.Bukkit;

public class MMOItemsHook {


    public static boolean isEnabled() {
        return Bukkit.getPluginManager().isPluginEnabled("MMOItems");
    }

}
