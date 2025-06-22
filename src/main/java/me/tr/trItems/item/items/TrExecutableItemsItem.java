package me.tr.trItems.item.items;

import com.ssomar.score.api.executableitems.config.ExecutableItemInterface;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.Optional;

/**
 * Represents an item that can execute specific actions or behaviors in the game.
 * This class extends BaseItem and adds functionality for executable items.
 */
public class TrExecutableItemsItem extends TrBaseItem {
    private ExecutableItemInterface executableItem;

    /**
     * Constructs a new ExecutableItemsItem with the specified properties.
     *
     * @param item           The base item to inherit properties from
     * @param executableItem The executable item interface providing specific actions or behaviors
     */
    public TrExecutableItemsItem(TrBaseItem item, ExecutableItemInterface executableItem) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.executableItem = executableItem;
        setStack(executableItem.buildItem(getAmount(), Optional.empty()));
    }

    /**
     * Constructs a new ExecutableItemsItem with the specified id.
     *
     * @param id     The id of this item
     * @param file   The file where this item is stored
     * @param plugin The plugin that this item belongs to
     */
    public TrExecutableItemsItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the executable item interface associated with this item.
     *
     * @return The executable item interface
     */
    public ExecutableItemInterface getExecutableItem() {
        return executableItem;
    }

    /**
     * Sets the executable item interface for this item.
     *
     * @param executableItem The new executable item interface
     */
    public void setExecutableItem(ExecutableItemInterface executableItem) {
        this.executableItem = executableItem;
    }

    public static class Builder extends TrBaseItem.Builder {
        private ExecutableItemInterface executableItem;

        /**
         * Constructs a new Builder for creating ExecutableItemsItem instances.
         *
         * @param id     The id of this item
         * @param file   The file where this item is stored
         * @param plugin The plugin that this item belongs to
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        public Builder executableItem(ExecutableItemInterface executableItem) {
            this.executableItem = executableItem;
            return this;
        }

        public TrExecutableItemsItem build() {
            return new TrExecutableItemsItem(super.build(), executableItem);
        }

    }
}
