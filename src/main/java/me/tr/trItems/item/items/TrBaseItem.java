package me.tr.trItems.item.items;

import me.tr.trItems.item.exeptions.ItemMetaNotFound;
import me.tr.trItems.item.helper.TrAttributes;
import me.tr.trItems.item.helper.TrEnchants;
import me.tr.trItems.item.helper.TrNBT;
import me.tr.trItems.item.metas.TrBaseMeta;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * This class represents a basic item.
 * <p>
 * It contains basic properties and methods for vanilla {@link ItemStack}
 * <p>
 * {@link TrBaseItem} is extended from all other different Items.
 */
public class TrBaseItem {
    private String id;
    private @Nullable String name;
    private List<String> lore = new ArrayList<>();
    private List<TrNBT<?>> nbts = new ArrayList<>();
    private List<TrEnchants> enchants = new ArrayList<>();
    private List<TrAttributes> attributes = new ArrayList<>();
    private ItemStack stack;
    private int maxAmount = 64;
    private int durability = -1;
    private int customModelData = 0;
    private boolean glint = false;
    private boolean fireResistance = false;
    private boolean unbreakable = false;
    private boolean hideTooltip = false;
    private ItemRarity itemRarity = ItemRarity.COMMON;
    private int version = 0;
    private boolean interactable = true;
    private File file;
    private Plugin plugin;

    /**
     * @param id              {@link String} to identify this BaseItem
     * @param name            {@link String} represent display name of this BaseItem
     * @param lore            {@link List} of {@link String} represent lore of this BaseItem
     * @param nbts            {@link List} of {@link TrNBT} represent NBTs of this BaseItem
     * @param enchants        {@link List} of {@link TrEnchants} represent enchantments of this BaseItem
     * @param attributes      {@link List} of {@link TrAttributes} represent attributes of this BaseItem
     * @param stack           {@link ItemStack} used for this instance of BaseItem
     * @param maxAmount       Amount of Max Items in a stack of this BaseItem
     * @param durability      Default durability if this BaseItem
     * @param customModelData CustomModelData to assign at this BaseItem
     * @param glint           Glint is the enchanted item animation applied to item stack without enchantments.
     * @param fireResistance  If FireResistance is true, item will be immune to fire or lava. Like netherite.
     * @param unbreakable     Make this BaseItem immune at durability loss.
     * @param hideTooltip     Hide Tooltips of this BaseItem
     * @param itemRarity      The {@link ItemRarity} of this BaseItem (No usage at the moment).
     * @param version         Version of this BaseItem
     * @param interactable    If interactable is false, when a player interacts with this BaseItem in hand, him cannot do it.
     * @param file            File where is specified configuration of this BaseItem.
     * @param plugin          Plugin that load this BaseItem
     */
    public TrBaseItem(@NotNull String id, @Nullable String name, List<String> lore, List<TrNBT<?>> nbts, List<TrEnchants> enchants, List<TrAttributes> attributes, ItemStack stack, int maxAmount, int durability, int customModelData, boolean glint, boolean fireResistance, boolean unbreakable, boolean hideTooltip, ItemRarity itemRarity, int version, boolean interactable, @NotNull File file, @NotNull Plugin plugin) {
        this.id = id;
        this.name = name;
        this.lore = lore;
        this.nbts = nbts;
        this.enchants = enchants;
        this.attributes = attributes;
        this.stack = stack;
        this.maxAmount = maxAmount;
        this.durability = durability;
        this.customModelData = customModelData;
        this.glint = glint;
        this.fireResistance = fireResistance;
        this.unbreakable = unbreakable;
        this.hideTooltip = hideTooltip;
        this.itemRarity = itemRarity;
        this.version = version;
        this.interactable = interactable;
        this.file = file;
        this.plugin = plugin;
    }

    /**
     * @param id     {@link String} to identify this BaseItem
     * @param file   File where is specified configuration of this BaseItem.
     * @param plugin Plugin that load this BaseItem
     */
    public TrBaseItem(@NotNull String id, File file, Plugin plugin) {
        this.id = id;
        this.file = file;
        this.plugin = plugin;
    }

    /**
     * Get the {@link String} of this BaseItem
     *
     * @return The {@link String} of this BaseItem
     */
    public String getId() {
        return id;
    }

    /**
     * Set the {@link String} of this BaseItem
     *
     * @param id the new {@link String} of this BaseItem
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the display name of this BaseItem
     *
     * @return The display name of this BaseItem
     */
    public @Nullable String getName() {
        return name;
    }

    /**
     * Set the display name of this BaseItem
     *
     * @param name A {@link String} represent display name for this BaseItem
     */
    public void setName(@Nullable String name) {
        this.name = name;
    }

    /**
     * Get the lore of this BaseItem
     *
     * @return The {@link List} of {@link String} represent lore for this BaseItem
     */
    public List<String> getLore() {
        return lore;
    }

    /**
     * Set the lore of this BaseItem
     *
     * @param lore A {@link List} of {@link String} represent lore for this BaseItem
     */
    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    /**
     * Get all NBTs of this BaseItem
     *
     * @return Get {@link List} of {@link TrNBT} represent all NBTs of this BaseItem
     */
    public List<TrNBT<?>> getNbts() {
        return nbts;
    }

    /**
     * Set NBTs for this BaseItem
     *
     * @param nbts A {@link List} of {@link TrNBT} represent NBTs for this BaseItem
     */
    public void setNbts(List<TrNBT<?>> nbts) {
        this.nbts = nbts;
    }

    /**
     * Get all enchantments of this BaseItem
     *
     * @return The {@link List} of {@link TrEnchants} represent all enchantments of this BaseItem
     */
    public List<TrEnchants> getEnchants() {
        return enchants;
    }

    /**
     * Set enchantments for this BaseItem
     *
     * @param enchants A {@link List} of {@link TrEnchants} represent enchantments for this BaseItem
     */
    public void setEnchants(List<TrEnchants> enchants) {
        this.enchants = enchants;
    }

    /**
     * Get all attributes of this BaseItem
     *
     * @return The {@link List} of {@link TrAttributes} represent all attributes of this BaseItem
     */
    public List<TrAttributes> getAttributes() {
        return attributes;
    }

    /**
     * Set attributes for this BaseItem
     *
     * @param attributes A {@link List} of {@link TrAttributes} represent attributes for this BaseItem
     */
    public void setAttributes(List<TrAttributes> attributes) {
        this.attributes = attributes;
    }

    /**
     * Get the ItemStack instance of this BaseItem
     *
     * @return The {@link ItemStack} instance of this BaseItem
     */
    public ItemStack getStack() {
        return stack;
    }

    /**
     * Set the ItemStack instance for this BaseItem
     *
     * @param stack The {@link ItemStack} to set for this BaseItem
     */
    public void setStack(ItemStack stack) {
        this.stack = stack;
    }

    /**
     * Get the current amount of this BaseItem's stack
     *
     * @return The current amount of this BaseItem's stack
     */
    public int getAmount() {
        return getStack().getAmount();
    }

    /**
     * Set the amount for this BaseItem's stack
     *
     * @param amount The new amount to set for this BaseItem's stack
     */
    public void setAmount(int amount) {
        this.stack = new ItemStack(stack.getType(), amount);
    }

    /**
     * Get the maximum stack size of this BaseItem
     *
     * @return The maximum stack size of this BaseItem
     */
    public int getMaxAmount() {
        return maxAmount;
    }

    /**
     * Set the maximum stack size for this BaseItem
     *
     * @param maxAmount The maximum stack size to set for this BaseItem
     */
    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    /**
     * Get the durability of this BaseItem
     *
     * @return The durability of this BaseItem
     */
    public int getDurability() {
        return durability;
    }

    /**
     * Set the durability for this BaseItem
     *
     * @param durability The durability to set for this BaseItem
     */
    public void setDurability(int durability) {
        this.durability = durability;
    }

    /**
     * Get the custom model data of this BaseItem
     *
     * @return The custom model data of this BaseItem
     */
    public int getCustomModelData() {
        return customModelData;
    }

    /**
     * Set the custom model data for this BaseItem
     *
     * @param customModelData The custom model data to set for this BaseItem
     */
    public void setCustomModelData(int customModelData) {
        this.customModelData = customModelData;
    }

    /**
     * Check if this BaseItem has enchantment glint effect
     *
     * @return True if this BaseItem has enchantment glint effect, false otherwise
     */
    public boolean isGlint() {
        return glint;
    }

    /**
     * Set whether this BaseItem should have enchantment glint effect
     *
     * @param glint True to apply enchantment glint effect, false otherwise
     */
    public void setGlint(boolean glint) {
        this.glint = glint;
    }

    /**
     * Check if this BaseItem is immune to fire and lava
     *
     * @return True if this BaseItem is immune to fire and lava, false otherwise
     */
    public boolean isFireResistance() {
        return fireResistance;
    }

    /**
     * Set whether this BaseItem should be immune to fire and lava
     *
     * @param fireResistance True to make this BaseItem immune to fire and lava, false otherwise
     */
    public void setFireResistance(boolean fireResistance) {
        this.fireResistance = fireResistance;
    }

    /**
     * Check if this BaseItem is unbreakable
     *
     * @return True if this BaseItem is unbreakable, false otherwise
     */
    public boolean isUnbreakable() {
        return unbreakable;
    }

    /**
     * Set whether this BaseItem should be unbreakable
     *
     * @param unbreakable True to make this BaseItem unbreakable, false otherwise
     */
    public void setUnbreakable(boolean unbreakable) {
        this.unbreakable = unbreakable;
    }

    /**
     * Check if tooltips are hidden for this BaseItem
     *
     * @return True if tooltips are hidden for this BaseItem, false otherwise
     */
    public boolean isHideTooltip() {
        return hideTooltip;
    }

    /**
     * Set whether tooltips should be hidden for this BaseItem
     *
     * @param hideTooltip True to hide tooltips for this BaseItem, false otherwise
     */
    public void setHideTooltip(boolean hideTooltip) {
        this.hideTooltip = hideTooltip;
    }

    /**
     * Get the rarity of this BaseItem
     *
     * @return The {@link ItemRarity} of this BaseItem
     */
    public ItemRarity getItemRarity() {
        return itemRarity;
    }

    /**
     * Set the rarity for this BaseItem
     *
     * @param itemRarity The {@link ItemRarity} to set for this BaseItem
     */
    public void setItemRarity(ItemRarity itemRarity) {
        this.itemRarity = itemRarity;
    }

    /**
     * Get the version of this BaseItem
     *
     * @return The version of this BaseItem
     */
    public int getVersion() {
        return version;
    }

    /**
     * Set the version for this BaseItem
     *
     * @param version The version to set for this BaseItem
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * Check if this BaseItem is interactable
     *
     * @return True if this BaseItem is interactable, false otherwise
     */
    public boolean isInteractable() {
        return interactable;
    }

    /**
     * Set whether this BaseItem should be interactable
     *
     * @param interactable True to make this BaseItem interactable, false otherwise
     */
    public void setInteractable(boolean interactable) {
        this.interactable = interactable;
    }

    /**
     * Get the File where this BaseItem is located.
     *
     * @return The File where this BaseItem is located.
     */
    public File getFile() {
        return file;
    }

    /**
     * Set the File where this BaseItem is located.
     *
     * @param file The File where this BaseItem is located
     */
    public void setFile(File file) {
        this.file = file;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public void setPlugin(Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Gets the ItemMeta of this BaseItem's stack
     *
     * @return The ItemMeta of this BaseItem's stack
     * @throws ItemMetaNotFound if the stack doesn't have ItemMeta
     */
    public @Nullable ItemMeta getItemMeta() {
        if (getStack().getItemMeta() == null) {
            throw new ItemMetaNotFound(getStack().getType() + " has no ItemMeta.");
        }
        return getStack().getItemMeta();
    }

    /**
     * Set meta to current {@link TrBaseItem}
     *
     * @see TrBaseMeta#setMeta(Player)
     */
    public void setMeta(Player player) {
        TrBaseMeta meta = new TrBaseMeta(this);
        meta.setMeta(player);
    }

    /**
     * Builder class for creating BaseItem instances using the builder pattern.
     * Provides a fluent interface for constructing BaseItem objects with all available properties.
     */
    public static class Builder {
        private String id;
        private File file;
        private Plugin plugin;
        private String name;
        private List<String> lore;
        private List<TrNBT<?>> nbts;
        private List<TrEnchants> enchants;
        private List<TrAttributes> attributes;
        private ItemStack stack;
        private int maxAmount;
        private int durability;
        private int customModelData;
        private boolean glint;
        private boolean fireResistance;
        private boolean unbreakable;
        private boolean hideTooltip;
        private ItemRarity itemRarity;
        private int version;
        private boolean interactable;


        public Builder(String id, File file, Plugin plugin) {
            this.id = id;
            this.file = file;
            this.plugin = plugin;
        }

        /**
         * Sets the unique ID for this BaseItem
         *
         * @param id The String to identify this BaseItem
         * @return This builder instance for method chaining
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the display name for this BaseItem
         *
         * @param name The String representing the display name
         * @return This builder instance for method chaining
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the lore for this BaseItem
         *
         * @param lore A list of Strings representing the lore
         * @return This builder instance for method chaining
         */
        public Builder lore(List<String> lore) {
            this.lore = lore;
            return this;
        }

        /**
         * Sets the NBT data for this BaseItem
         *
         * @param nbts A list of NBT data to apply to this BaseItem
         * @return This builder instance for method chaining
         */
        public Builder nbts(List<TrNBT<?>> nbts) {
            this.nbts = nbts;
            return this;
        }

        /**
         * Sets the enchantments for this BaseItem
         *
         * @param enchants A list of enchantments to apply to this BaseItem
         * @return This builder instance for method chaining
         */
        public Builder enchants(List<TrEnchants> enchants) {
            this.enchants = enchants;
            return this;
        }

        /**
         * Sets the attributes for this BaseItem
         *
         * @param attributes A list of attributes to apply to this BaseItem
         * @return This builder instance for method chaining
         */
        public Builder attributes(List<TrAttributes> attributes) {
            this.attributes = attributes;
            return this;
        }

        /**
         * Sets the ItemStack for this BaseItem
         *
         * @param stack The ItemStack to use for this BaseItem
         * @return This builder instance for method chaining
         */
        public Builder stack(ItemStack stack) {
            this.stack = stack;
            return this;
        }

        /**
         * Sets the amount for this BaseItem's stack
         *
         * @param amount The amount to set for this BaseItem's stack
         * @return This builder instance for method chaining
         */
        public Builder amount(int amount) {
            this.stack = new ItemStack(stack.getType(), amount);
            return this;
        }

        /**
         * Sets the maximum stack size for this BaseItem
         *
         * @param maxAmount The maximum stack size to set
         * @return This builder instance for method chaining
         */
        public Builder maxAmount(int maxAmount) {
            this.maxAmount = maxAmount;
            return this;
        }

        /**
         * Sets the durability for this BaseItem
         *
         * @param durability The durability to set
         * @return This builder instance for method chaining
         */
        public Builder durability(int durability) {
            this.durability = durability;
            return this;
        }

        /**
         * Sets the custom model data for this BaseItem
         *
         * @param customModelData The custom model data to set
         * @return This builder instance for method chaining
         */
        public Builder customModelData(int customModelData) {
            this.customModelData = customModelData;
            return this;
        }

        /**
         * Sets whether this BaseItem should have enchantment glint effect
         *
         * @param glint True to apply enchantment glint effect, false otherwise
         * @return This builder instance for method chaining
         */
        public Builder glint(boolean glint) {
            this.glint = glint;
            return this;
        }

        /**
         * Sets whether this BaseItem should be immune to fire and lava
         *
         * @param fireResistance True to make this BaseItem immune to fire and lava, false otherwise
         * @return This builder instance for method chaining
         */
        public Builder fireResistance(boolean fireResistance) {
            this.fireResistance = fireResistance;
            return this;
        }

        /**
         * Sets whether this BaseItem should be unbreakable
         *
         * @param unbreakable True to make this BaseItem unbreakable, false otherwise
         * @return This builder instance for method chaining
         */
        public Builder unbreakable(boolean unbreakable) {
            this.unbreakable = unbreakable;
            return this;
        }

        /**
         * Sets whether tooltips should be hidden for this BaseItem
         *
         * @param hideTooltip True to hide tooltips for this BaseItem, false otherwise
         * @return This builder instance for method chaining
         */
        public Builder hideTooltip(boolean hideTooltip) {
            this.hideTooltip = hideTooltip;
            return this;
        }

        /**
         * Sets the rarity for this BaseItem
         *
         * @param itemRarity The ItemRarity to set for this BaseItem
         * @return This builder instance for method chaining
         */
        public Builder itemRarity(ItemRarity itemRarity) {
            this.itemRarity = itemRarity;
            return this;
        }

        /**
         * Sets the version for this BaseItem
         *
         * @param version The version to set for this BaseItem
         * @return This builder instance for method chaining
         */
        public Builder version(int version) {
            this.version = version;
            return this;
        }

        /**
         * Sets whether this BaseItem should be interactable
         *
         * @param interactable True to make this BaseItem interactable, false otherwise
         * @return This builder instance for method chaining
         */
        public Builder interactable(boolean interactable) {
            this.interactable = interactable;
            return this;
        }

        /**
         * Sets the File for this BaseItem
         *
         * @param file The File for this BaseItem
         * @return This builder instance for method chaining
         */
        public Builder file(File file) {
            this.file = file;
            return this;
        }

        /**
         * Sets the Plugin for this BaseItem
         *
         * @param plugin The Plugin for this BaseItem
         * @return This builder instance for method chaining
         */
        public Builder plugin(Plugin plugin) {
            this.plugin = plugin;
            return this;
        }

        /**
         * Builds and returns a new BaseItem instance with the configured properties
         *
         * @return A new BaseItem instance with all the properties set in this builder
         */
        public TrBaseItem build() {
            return new TrBaseItem(id, name, lore, nbts, enchants, attributes, stack, maxAmount, durability, customModelData, glint, fireResistance, unbreakable, hideTooltip, itemRarity, version, interactable, file, plugin);
        }
    }
}
