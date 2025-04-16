package me.tr.trItems.item.items;

import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * Represents a Skull item, extending the functionality of BaseItem.
 * This class encapsulates properties specific to a player's skull, including
 * the owner's name, player profile, offline player data, and associated note block sound.
 */
public class SkullItem extends BaseItem {
    private OfflinePlayer player;
    private NamespacedKey noteBlockSound;

    /**
     * Constructs a new SkullItem with a specified offline player and note block sound.
     *
     * @param item           The base item to inherit properties from.
     * @param player         The offline player associated with the skull.
     * @param noteBlockSound The namespaced key for the associated note block sound.
     */
    public SkullItem(BaseItem item, OfflinePlayer player, NamespacedKey noteBlockSound) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.player = player;
    }

    /**
     * Gets the offline player associated with the skull.
     *
     * @return The offline player.
     */
    public OfflinePlayer getPlayer() {
        return player;
    }

    /**
     * Sets the offline player associated with the skull.
     *
     * @param player The new offline player to set.
     */
    public void setPlayer(OfflinePlayer player) {
        this.player = player;
    }

    /**
     * Gets the namespaced key for the note block sound associated with the skull.
     *
     * @return The namespaced key for the note block sound.
     */
    public NamespacedKey getNoteBlockSound() {
        return noteBlockSound;
    }

    /**
     * Sets the namespaced key for the note block sound associated with the skull.
     *
     * @param noteBlockSound The new namespaced key for the note block sound to set.
     */
    public void setNoteBlockSound(NamespacedKey noteBlockSound) {
        this.noteBlockSound = noteBlockSound;
    }


    public SkullMeta getItemMeta() {
        return (SkullMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.SkullMeta meta = new me.tr.trItems.item.metas.SkullMeta();
        meta.setMeta(this, player);
    }
}
