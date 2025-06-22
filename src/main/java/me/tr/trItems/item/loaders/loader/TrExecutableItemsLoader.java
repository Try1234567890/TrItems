package me.tr.trItems.item.loaders.loader;

import com.ssomar.score.api.executableitems.ExecutableItemsAPI;
import com.ssomar.score.api.executableitems.config.ExecutableItemInterface;
import me.tr.trFiles.configuration.Section;
import me.tr.trItems.TrItems;
import me.tr.trItems.hooks.ExecutableItemsHook;
import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.item.items.TrExecutableItemsItem;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class TrExecutableItemsLoader extends TrBaseLoader {
    private final TrItems main = TrItems.getInstance();

    public @Nullable TrExecutableItemsItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        ExecutableItemInterface executableItem = getExecutableItem(itemSection);
        if (executableItem == null) {
            return new TrExecutableItemsItem(baseItem.getId(), baseItem.getFile(), baseItem.getPlugin());
        }
        return new TrExecutableItemsItem(baseItem, executableItem);
    }

    public @Nullable ExecutableItemInterface getExecutableItem(Section itemSection) {
        if (!ExecutableItemsHook.isEnabled()) {
            main.getLogger().error("Cannot load item: \"" + itemSection.getName() + "\", ExecutableItems is not enabled. Please put ExecutableItems jar in the plugins folder and restart the server.");
            return null;
        }
        String id = itemSection.getString("ExecutableItems");
        if (id == null) return null;
        return ExecutableItemsAPI.getExecutableItemsManager().getExecutableItem(id).orElseGet(() -> {
            main.getLogger().warn("Could not find executable item with ID: " + id);
            return null;
        });
    }

}
