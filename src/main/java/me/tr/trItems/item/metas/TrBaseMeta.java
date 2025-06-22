package me.tr.trItems.item.metas;

import me.tr.trItems.TrItems;
import me.tr.trItems.item.helper.TrAttributes;
import me.tr.trItems.item.helper.TrEnchants;
import me.tr.trItems.item.helper.TrNBT;
import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.message.MessageFormatter;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.tag.DamageTypeTags;

import java.util.List;

/**
 * The BaseMeta class is responsible for applying metadata properties to BaseItem objects.
 * It provides methods to set various properties like name, lore, NBTs, enchantments, attributes, etc.
 * on the ItemMeta of a BaseItem.
 */
public class TrBaseMeta {
    protected TrItems main = TrItems.getInstance();
    private TrBaseItem item;

    protected TrBaseMeta() {
    }

    /**
     * Create a new instance of TrBaseMeta
     *
     * @param item Item to assign to this instance.
     */
    public TrBaseMeta(TrBaseItem item) {
        this.item = item;
    }

    public TrBaseItem getItem() {
        return item;
    }

    /**
     * Sets all properties of the BaseItem
     *
     * @param player {@link Player} to get info from.
     */
    public void setMeta(Player player) {
        setName(player);
        setLore(player);
        setNBTs();
        setEnchants();
        setAttributes();
        setDurability();
        setCustomModelData();
        setGlint();
        setFireResistance();
        setUnbreakable();
        setHideTooltip();
        setItemRarity();
        setVersion();
        setInteractable();
    }

    /**
     * Sets the display name of the BaseItem.
     *
     * @param player Player used to format item name
     */
    public void setName(Player player) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
        Component name = MessageFormatter.getInstance().format(item.getName(), player);
        if (name != null) {
            meta.displayName(name);
            item.getStack().setItemMeta(meta);
        }
    }

    /**
     * Edit the current item name with the new one.
     *
     * @param name   The new name to set to current instance item.
     * @param player Player used to format item name
     */
    public void editName(String name, Player player) {
        item.setName(name);
        setName(player);
    }

    /**
     * Sets the lore of the BaseItem.
     *
     * @param player Player used to format item name
     */
    public void setLore(Player player) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
        meta.lore(item.getLore().stream().map(lore -> MessageFormatter.getInstance().format(lore, player)).toList());
        item.getStack().setItemMeta(meta);
    }


    /**
     * Edit the current item lore with the new one.
     *
     * @param lore   The new lore to set ot current instance item.
     * @param player Player used to format item name
     */
    public void editLore(List<String> lore, Player player) {
        item.setLore(lore);
        setLore(player);
    }


    /**
     * Sets all NBT values on the BaseItem.
     * This method handles different data types and applies them to the item's PersistentDataContainer.
     */
    public void setNBTs() {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
        for (TrNBT<?> nbt : item.getNbts()) {
            nbt.set(item);
        }
        item.getStack().setItemMeta(meta);
    }

    /**
     * Edit the current item nbts with the new one.
     *
     * @param nbts The new nbts to set ot current instance item.
     */
    public void editNBTs(List<TrNBT<?>> nbts) {
        item.setNbts(nbts);
        setNBTs();
    }

    /**
     * Sets all enchantments on the BaseItem.
     * Adds enabled enchantments and removes disabled ones.
     */
    public void setEnchants() {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
        for (TrEnchants enchants : item.getEnchants()) {
            boolean enabled = enchants.isEnabled();
            Enchantment enchantment = enchants.getEnchantment();
            int level = enchants.getLevel();
            boolean override = enchants.isOverride();
            if (enabled) meta.addEnchant(enchantment, level, override);
            else meta.removeEnchant(enchantment);
        }
        item.getStack().setItemMeta(meta);
    }

    /**
     * Edit the current item enchants with the new one.
     *
     * @param enchants The new enchants to set ot current instance item.
     */
    public void editEnchants(List<TrEnchants> enchants) {
        item.setEnchants(enchants);
        setEnchants();
    }

    /**
     * Sets all attributes on the BaseItem.
     */
    public void setAttributes() {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
        for (TrAttributes attributes : item.getAttributes()) {
            Attribute attribute = attributes.getAttribute();
            AttributeModifier modifier = attributes.getAttributeModifier();
            meta.addAttributeModifier(attribute, modifier);
        }
        item.getStack().setItemMeta(meta);
    }

    /**
     * Edit the current item attributes with the new one.
     *
     * @param attributes The new attributes to set ot current instance item.
     */
    public void editAttributes(List<TrAttributes> attributes) {
        item.setAttributes(attributes);
        setAttributes();
    }

    /**
     * Sets the maximum stack size for the BaseItem.
     */
    public void setMaxAmount() {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
        meta.setMaxStackSize(item.getMaxAmount());
        item.getStack().setItemMeta(meta);
    }

    /**
     * Edit the current item max amount with the new one.
     *
     * @param maxAmount The new max amount to set ot current instance item.
     */
    private void editMaxAmount(int maxAmount) {
        item.setMaxAmount(maxAmount);
        setMaxAmount();
    }

    /**
     * Sets the durability for the BaseItem if it's damageable.
     */
    public void setDurability() {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
        if (meta instanceof Damageable dam) {
            dam.setDamage(item.getDurability());
        }
        item.getStack().setItemMeta(meta);
    }

    /**
     * Edit the current item durability with the new one.
     *
     * @param durability The new durability to set ot current instance item.
     */
    public void editDurability(int durability) {
        item.setDurability(durability);
        setDurability();
    }

    /**
     * Sets the custom model data for the BaseItem.
     */
    public void setCustomModelData() {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
        meta.setCustomModelData(item.getCustomModelData());
        item.getStack().setItemMeta(meta);
    }

    /**
     * Edit the current item customModelData with the new one.
     *
     * @param customModelData The new customModelData to set ot current instance item.
     */
    public void editCustomModelData(int customModelData) {
        item.setCustomModelData(customModelData);
        setCustomModelData();
    }

    /**
     * Sets whether the BaseItem should have an enchantment glint effect.
     */
    public void setGlint() {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
        meta.setEnchantmentGlintOverride(item.isGlint());
        item.getStack().setItemMeta(meta);
    }

    /**
     * Edit the current item glint with the new one.
     *
     * @param glint The new glint to set ot current instance item.
     */
    public void editGlint(boolean glint) {
        item.setGlint(glint);
        setGlint();
    }

    /**
     * Sets whether the BaseItem should be resistant to fire damage.
     */
    @SuppressWarnings("UnstableApiUsage")
    public void setFireResistance() {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
        meta.setDamageResistant(DamageTypeTags.IS_FIRE);
        item.getStack().setItemMeta(meta);
    }

    /**
     * Edit the current item fire resistance with the new one.
     *
     * @param fireResistance The new fire resistance to set ot current instance item.
     */
    public void editFireResistance(boolean fireResistance) {
        item.setFireResistance(fireResistance);
        setFireResistance();
    }

    /**
     * Sets whether the BaseItem should be unbreakable.
     */
    public void setUnbreakable() {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
        meta.setUnbreakable(item.isUnbreakable());
        item.getStack().setItemMeta(meta);
    }

    /**
     * Edit the current item unbreakable with the new one.
     *
     * @param unbreakable The new unbreakable to set ot current instance item.
     */
    public void editUnbreakable(boolean unbreakable) {
        item.setUnbreakable(unbreakable);
        setUnbreakable();
    }

    /**
     * Sets whether tooltips should be hidden for the BaseItem.
     */
    public void setHideTooltip() {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
        meta.setHideTooltip(item.isHideTooltip());
        item.getStack().setItemMeta(meta);
    }

    /**
     * Edit the current item hide tooltip with the new one.
     *
     * @param hideTooltip The new hide tooltip to set ot current instance item.
     */
    public void editHideTooltip(boolean hideTooltip) {
        item.setHideTooltip(hideTooltip);
        setHideTooltip();
    }

    /**
     * Sets the rarity of the BaseItem.
     */
    public void setItemRarity() {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
        meta.setRarity(item.getItemRarity());
        item.getStack().setItemMeta(meta);
    }

    /**
     * Edit the current item rarity with the new one.
     *
     * @param rarity The new rarity to set ot current instance item.
     */
    public void editItemRarity(ItemRarity rarity) {
        item.setItemRarity(rarity);
        setItemRarity();
    }

    /**
     * Sets the version of the BaseItem in its persistent data container.
     */
    public void setVersion() {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
        meta.getPersistentDataContainer().set(new NamespacedKey(item.getPlugin(), "version"), PersistentDataType.INTEGER, item.getVersion());
        item.getStack().setItemMeta(meta);
    }

    /**
     * Edit the current item version with the new one.
     *
     * @param version The new version to set ot current instance item.
     */
    public void editVersion(int version) {
        item.setVersion(version);
        setVersion();
    }

    /**
     * Sets whether the BaseItem should be interactable in its persistent data container.
     */
    public void setInteractable() {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
        meta.getPersistentDataContainer().set(new NamespacedKey(item.getPlugin(), "interactable"), PersistentDataType.BOOLEAN, item.isInteractable());
        item.getStack().setItemMeta(meta);
    }

    /**
     * Edit the current item interactable with the new one.
     *
     * @param interactable The new interactable to set ot current instance item.
     */
    public void editInteractable(boolean interactable) {
        item.setInteractable(interactable);
        setInteractable();
    }
}
