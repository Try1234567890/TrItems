package me.tr.trItems.item.helper;

import org.bukkit.enchantments.Enchantment;

/**
 * The Enchants class represents an enchantment with its properties.
 * It includes the enchantment type, level, and whether it is enabled or should override existing enchantments.
 */

public class Enchants {
    private final boolean enabled;
    private final Enchantment enchantment;
    private final int level;
    private final boolean override;

    /**
     * Constructs an Enchants instance with the specified enchantment and level.
     * The enchantment is enabled and set to override by default.
     *
     * @param enchantment The Enchantment type
     * @param level       The level of the enchantment
     */
    public Enchants(Enchantment enchantment, int level) {
        this.enabled = true;
        this.enchantment = enchantment;
        this.level = level;
        this.override = true;
    }

    /**
     * Constructs an Enchants instance with the specified enabled state, enchantment, and level.
     * The enchantment is set to override by default.
     *
     * @param enabled     Whether the enchantment is enabled
     * @param enchantment The Enchantment type
     * @param level       The level of the enchantment
     */
    public Enchants(boolean enabled, Enchantment enchantment, int level) {
        this.enabled = enabled;
        this.enchantment = enchantment;
        this.level = level;
        this.override = true;
    }

    /**
     * Constructs an Enchants instance with the specified enchantment, level, and override state.
     * The enchantment is enabled by default.
     *
     * @param enchantment The Enchantment type
     * @param level       The level of the enchantment
     * @param override    Whether the enchantment should override existing enchantments
     */
    public Enchants(Enchantment enchantment, int level, boolean override) {
        this.enabled = true;
        this.enchantment = enchantment;
        this.level = level;
        this.override = override;
    }

    /**
     * Constructs an Enchants instance with the specified enabled state, enchantment, level, and override state.
     *
     * @param enabled     Whether the enchantment is enabled
     * @param enchantment The Enchantment type
     * @param level       The level of the enchantment
     * @param override    Whether the enchantment should override existing enchantments
     */
    public Enchants(boolean enabled, Enchantment enchantment, int level, boolean override) {
        this.enabled = enabled;
        this.enchantment = enchantment;
        this.level = level;
        this.override = override;
    }

    /**
     * Checks if the enchantment is enabled.
     *
     * @return True if the enchantment is enabled, false otherwise
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Gets the Enchantment type.
     *
     * @return The Enchantment type
     */
    public Enchantment getEnchantment() {
        return enchantment;
    }

    /**
     * Gets the level of the enchantment.
     *
     * @return The level of the enchantment
     */
    public int getLevel() {
        return level;
    }

    /**
     * Checks if the enchantment should override existing enchantments.
     *
     * @return True if the enchantment should override, false otherwise
     */
    public boolean isOverride() {
        return override;
    }

    @Override
    public String toString() {
        return "Enchants{" +
                "enabled=" + enabled +
                ", enchantment=" + enchantment +
                ", level=" + level +
                ", override=" + override +
                '}';
    }
}
