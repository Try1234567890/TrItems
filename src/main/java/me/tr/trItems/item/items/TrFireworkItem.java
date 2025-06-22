package me.tr.trItems.item.items;

import me.tr.trItems.item.metas.TrFireworkMeta;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a custom firework item that extends the functionality of a base item.
 * This class allows setting and retrieving the power and effect of the firework.
 */
public class TrFireworkItem extends TrBaseItem {
    private int power = 1;
    private List<FireworkEffect> effects = new ArrayList<>();

    /**
     * Constructs a new FireworkItem with the specified base item properties, power, and effect.
     *
     * @param item    The base item to extend.
     * @param power   The power level of the firework.
     * @param effects The visual effect of the firework.
     */
    public TrFireworkItem(TrBaseItem item, int power, List<FireworkEffect> effects) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.power = power;
        this.effects = effects;
    }

    /**
     * Constructs a new FireworkItem with the specified id.
     *
     * @param id     The id of this item.
     * @param file   The file where this item is stored.
     * @param plugin The plugin that this item belongs to.
     */
    public TrFireworkItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the power level of the firework.
     *
     * @return The power level.
     */
    public int getPower() {
        return power;
    }

    /**
     * Sets the power level of the firework.
     *
     * @param power The new power level.
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Gets the visual effect of the firework.
     *
     * @return The firework effect.
     */
    public List<FireworkEffect> getEffects() {
        return effects;
    }

    /**
     * Sets the visual effect of the firework.
     *
     * @param effects The new firework effect.
     */
    public void setEffects(List<FireworkEffect> effects) {
        this.effects = effects;
    }

    /**
     * Gets the FireworkMeta instance from the item stack.
     *
     * @return The FireworkMeta instance from the item stack, or null if the stack does not have a FireworkMeta.
     */
    @Override
    public FireworkMeta getItemMeta() {
        return (FireworkMeta) super.getItemMeta();
    }

    /**
     * Sets the FireworkMeta for this item.
     *
     * @param player The player to set the meta for.
     */
    @Override
    public void setMeta(Player player) {
        TrFireworkMeta meta = new TrFireworkMeta(this);
        meta.setMeta(player);
    }

    public static class Builder extends TrBaseItem.Builder {
        private int power;
        private List<FireworkEffect> effect;

        /**
         * Constructs a new Builder instance for creating a FireworkItem.
         *
         * @param id     The id of the item.
         * @param file   The file where this item is stored.
         * @param plugin The plugin that this item belongs to.
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        public Builder power(int power) {
            this.power = power;
            return this;
        }

        public Builder effect(List<FireworkEffect> effect) {
            this.effect = effect;
            return this;
        }

        public TrFireworkItem build() {
            return new TrFireworkItem(super.build(), power, effect);
        }
    }
}