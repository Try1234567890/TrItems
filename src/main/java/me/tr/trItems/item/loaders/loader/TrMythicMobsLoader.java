package me.tr.trItems.item.loaders.loader;

import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.core.items.MythicItem;
import me.tr.trFiles.configuration.Section;
import me.tr.trItems.TrItems;
import me.tr.trItems.hooks.MythicMobsHook;
import org.jetbrains.annotations.Nullable;

public class TrMythicMobsLoader extends TrBaseLoader {
    private final TrItems main = TrItems.getInstance();

    public @Nullable MythicItem getMythicItem(Section itemSection) {
        if (!MythicMobsHook.isEnabled()) {
            main.getLogger().error("Cannot load item: \"" + itemSection.getName() + "\", MythicMobs is not enabled. Please put MythicMobs jar in the plugins folder and restart the server.");
            return null;
        }
        String mythicMobsItemName = itemSection.getString("MythicMobs");
        try (MythicBukkit mythicBukkit = MythicBukkit.inst()) {
            mythicBukkit.getItemManager().getItem(mythicMobsItemName).orElseGet(() -> {
                main.getLogger().warn("MythicMobs item " + mythicMobsItemName + " not found.");
                return null;
            });
        } catch (Exception ignored) {
        }
        return null;
    }

}
