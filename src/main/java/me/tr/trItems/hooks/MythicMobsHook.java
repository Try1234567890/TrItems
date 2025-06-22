package me.tr.trItems.hooks;

import org.bukkit.Bukkit;

public class MythicMobsHook {

    public static boolean isEnabled() {
        return Bukkit.getPluginManager().isPluginEnabled("MythicMobs");
    }
}
