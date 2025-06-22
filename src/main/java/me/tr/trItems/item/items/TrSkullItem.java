package me.tr.trItems.item.items;

import me.tr.trItems.item.metas.TrSkullMeta;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.io.File;

/**
 * Represents a Skull item, extending the functionality of BaseItem.
 * This class encapsulates properties specific to a player's skull, including
 * the owner's name, player profile, offline player data, and associated note block sound.
 */
public class TrSkullItem extends TrBaseItem {
    private @Nullable OfflinePlayer owner;
    private @Nullable NamespacedKey noteBlockSound;

    /**
     * Constructs a new SkullItem with a specified offline player and note block sound.
     *
     * @param item           The base item to inherit properties from.
     * @param owner          The offline player associated with the skull.
     * @param noteBlockSound The namespaced key for the associated note block sound.
     */
    public TrSkullItem(TrBaseItem item, @Nullable OfflinePlayer owner, @Nullable NamespacedKey noteBlockSound) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.owner = owner;
        this.noteBlockSound = noteBlockSound;
    }

    /**
     * Constructs a new SkullItem with a specified id.
     *
     * @param id     The id of this item.
     * @param file   The file where this item is stored.
     * @param plugin The plugin that this item belongs to.
     */
    public TrSkullItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the offline player associated with the skull.
     *
     * @return The offline player.
     */
    public @Nullable OfflinePlayer getOwner() {
        return owner;
    }

    /**
     * Sets the offline player associated with the skull.
     *
     * @param owner The new offline player to set.
     */
    public void setOwner(@Nullable OfflinePlayer owner) {
        this.owner = owner;
    }

    /**
     * Gets the namespaced key for the note block sound associated with the skull.
     *
     * @return The namespaced key for the note block sound.
     */
    public @Nullable NamespacedKey getNoteBlockSound() {
        return noteBlockSound;
    }

    /**
     * Sets the namespaced key for the note block sound associated with the skull.
     *
     * @param noteBlockSound The new namespaced key for the note block sound to set.
     */
    public void setNoteBlockSound(@Nullable NamespacedKey noteBlockSound) {
        this.noteBlockSound = noteBlockSound;
    }

    /**
     * Gets the SkullMeta instance from the item stack.
     *
     * @return The SkullMeta instance.
     */
    @Override
    public SkullMeta getItemMeta() {
        return (SkullMeta) super.getItemMeta();
    }

    /**
     * Sets the SkullMeta for this item.
     *
     * @param player The player to set the meta for.
     */
    @Override
    public void setMeta(Player player) {
        TrSkullMeta meta = new TrSkullMeta(this);
        meta.setMeta(player);
    }

    /**
     * Builder class for creating SkullItem instances.
     */
    public static class Builder extends TrBaseItem.Builder {
        private OfflinePlayer player;
        private NamespacedKey noteBlockSound;

        /**
         * Constructs a new Builder instance for creating a SkullItem.
         *
         * @param id     The id of the item.
         * @param file   The file where this item is stored.
         * @param plugin The plugin that this item belongs to.
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        /**
         * Sets the offline player for the skull item.
         *
         * @param player The offline player to set.
         * @return The builder instance for method chaining.
         */
        public Builder player(OfflinePlayer player) {
            this.player = player;
            return this;
        }

        /**
         * Sets the namespaced key for the note block sound associated with the skull item.
         *
         * @param noteBlockSound The namespaced key to set.
         * @return The builder instance for method chaining.
         */
        public Builder noteBlockSound(NamespacedKey noteBlockSound) {
            this.noteBlockSound = noteBlockSound;
            return this;
        }

        /**
         * Builds and returns a new SkullItem instance with the specified properties.
         *
         * @return A new SkullItem instance.
         */
        public TrSkullItem build() {
            return new TrSkullItem(super.build(), player, noteBlockSound);
        }
    }
}
