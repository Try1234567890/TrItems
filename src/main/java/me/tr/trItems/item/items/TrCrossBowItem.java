package me.tr.trItems.item.items;

import me.tr.trItems.item.metas.TrCrossBowMeta;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.CrossbowMeta;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a crossbow item in the game.
 * This class extends BaseItem and adds functionality to store multiple items (presumably arrows or projectiles).
 */
public class TrCrossBowItem extends TrBaseItem {
    private List<TrBaseItem> projectiles = new ArrayList<>();

    /**
     * Constructs a new CrossBowItem with the specified properties.
     *
     * @param item        The base item to inherit properties from
     * @param projectiles The list of items (presumably arrows or projectiles) associated with this crossbow
     */
    public TrCrossBowItem(TrBaseItem item, List<TrBaseItem> projectiles) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.projectiles = projectiles;
    }

    /**
     * Constructs a new CrossBowItem with the specified id.
     *
     * @param id     The id of this item
     * @param file   The file where this item is stored
     * @param plugin The plugin that this item belongs to
     */
    public TrCrossBowItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the list of items associated with this crossbow.
     *
     * @return A List of BaseItem objects representing the items (presumably arrows or projectiles) associated with the crossbow
     */
    public List<TrBaseItem> getProjectiles() {
        return projectiles;
    }

    /**
     * Sets the list of items associated with this crossbow.
     *
     * @param projectiles A List of BaseItem objects to be associated with the crossbow
     */
    public void setProjectiles(List<TrBaseItem> projectiles) {
        this.projectiles = projectiles;
    }

    /**
     * Gets the CrossbowMeta instance from the item stack.
     *
     * @return The CrossbowMeta instance from the item stack, or null if the stack does not have a CrossbowMeta
     */
    @Override
    public CrossbowMeta getItemMeta() {
        return (CrossbowMeta) super.getItemMeta();
    }

    /**
     * Sets the CrossbowMeta for this item.
     *
     * @param player The player to set the meta for
     */
    @Override
    public void setMeta(Player player) {
        TrCrossBowMeta meta = new TrCrossBowMeta(this);
        meta.setMeta(player);
    }

    public static class Builder extends TrBaseItem.Builder {
        private List<TrBaseItem> items;

        /**
         * Constructs a new CrossBowItem with the specified id.
         *
         * @param id     The id of this item
         * @param file   The file where this item is stored
         * @param plugin The plugin that this item belongs to
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        public Builder items(List<TrBaseItem> items) {
            this.items = items;
            return this;
        }

        public TrCrossBowItem build() {
            return new TrCrossBowItem(super.build(), items);
        }
    }
}
