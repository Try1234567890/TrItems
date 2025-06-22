package me.tr.trItems.hooks;

import org.bukkit.Bukkit;

public class ExecutableItemsHook {

    public static boolean isEnabled() {
        return Bukkit.getPluginManager().isPluginEnabled("ExecutableItems");
    }
}
