package me.tr.trItems.item.items;

import me.tr.trItems.item.metas.TrSpawnEggMeta;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.SpawnEggMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class TrSpawnEggItem extends TrBaseItem {
    private @Nullable EntityType customSpawnedType;

    /**
     * Constructs a new SpawnEggItem with the specified base item properties and custom spawned type.
     *
     * @param item              The base item to extend.
     * @param customSpawnedType The custom entity type that this spawn egg will spawn.
     */
    public TrSpawnEggItem(TrBaseItem item, @Nullable EntityType customSpawnedType) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.customSpawnedType = customSpawnedType;
    }

    /**
     * Constructs a new SpawnEggItem with the specified id.
     *
     * @param id     The id of this item.
     * @param file   The file where this item is stored.
     * @param plugin The plugin that this item belongs to.
     */
    public TrSpawnEggItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the custom entity type that this spawn egg will spawn.
     *
     * @return The custom entity type.
     */
    public @Nullable EntityType getCustomSpawnedType() {
        return customSpawnedType;
    }

    /**
     * Sets the custom entity type that this spawn egg will spawn.
     *
     * @param customSpawnedType The new custom entity type.
     */
    public void setCustomSpawnedType(@Nullable EntityType customSpawnedType) {
        this.customSpawnedType = customSpawnedType;
    }

    /**
     * Gets the SpawnEggMeta instance from the item stack.
     *
     * @return The SpawnEggMeta instance.
     */
    @Override
    public SpawnEggMeta getItemMeta() {
        return (SpawnEggMeta) super.getItemMeta();
    }

    /**
     * Sets the SpawnEggMeta instance to the item stack.
     *
     * @param player The player who is setting the meta.
     */
    @Override
    public void setMeta(Player player) {
        TrSpawnEggMeta meta = new TrSpawnEggMeta(this);
        meta.setMeta(player);
    }

    public static class Builder extends TrBaseItem.Builder {
        private EntityType customSpawnedType;

        /**
         * Constructs a new Builder for SpawnEggItem with the specified id.
         *
         * @param id     The id of this item.
         * @param file   The file where this item is stored.
         * @param plugin The plugin that this item belongs to.
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        /**
         * Sets the custom entity type that this spawn egg will spawn.
         *
         * @param customSpawnedType The new custom entity type.
         * @return The builder instance for method chaining.
         */
        public Builder customSpawnedType(EntityType customSpawnedType) {
            this.customSpawnedType = customSpawnedType;
            return this;
        }

        /**
         * Builds the SpawnEggItem with the specified properties.
         *
         * @return The constructed SpawnEggItem.
         */
        public TrSpawnEggItem build() {
            return new TrSpawnEggItem(super.build(), customSpawnedType);
        }
    }
}
