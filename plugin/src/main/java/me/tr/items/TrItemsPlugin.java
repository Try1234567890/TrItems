package me.tr.items;

import me.tr.tritems.TrItems;
import org.bukkit.plugin.java.JavaPlugin;

public final class TrItemsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        TrItems.init(this);

        System.out.println("[TrItems] Plugin has been enabled!");
    }

    @Override
    public void onDisable() {

    }
}
