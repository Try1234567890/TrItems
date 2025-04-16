package me.tr.trItems.item.metas;

import me.tr.trItems.TrItems;
import me.tr.trItems.item.helper.Attributes;
import me.tr.trItems.item.helper.Enchants;
import me.tr.trItems.item.helper.NBT;
import me.tr.trItems.item.items.BaseItem;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.tag.DamageTypeTags;

/**
 * The BaseMeta class is responsible for applying metadata properties to BaseItem objects.
 * It provides methods to set various properties like name, lore, NBTs, enchantments, attributes, etc.
 * on the ItemMeta of a BaseItem.
 */
public class BaseMeta {
    protected TrItems main = TrItems.getInstance();

    /**
     * Sets all properties of the BaseItem
     *
     * @param item   {@link BaseItem} instance to set properties to.
     * @param player {@link Player} to get info from.
     */
    public void setMeta(BaseItem item, Player player) {
        setName(item, player);
        setLore(item, player);
        setNBTs(item);
        setEnchants(item);
        setAttributes(item);
        setDurability(item);
        setCustomModelData(item);
        setGlint(item);
        setFireResistance(item);
        setUnbreakable(item);
        setHideTooltip(item);
        setItemRarity(item);
        setVersion(item);
        setInteractable(item);
    }


    /**
     * Sets the display name of the BaseItem.
     *
     * @param item The BaseItem to set the name for
     */
    public void setName(BaseItem item, Player player) {
        ItemMeta meta = item.getItemMeta();
        meta.displayName(main.getFormatter().format(item.getName(), player));
        item.getStack().setItemMeta(meta);
    }

    /**
     * Sets the lore of the BaseItem.
     *
     * @param item The BaseItem to set the lore for
     */
    public void setLore(BaseItem item, Player player) {
        ItemMeta meta = item.getItemMeta();
        meta.lore(item.getLore().stream().map(lore -> main.getFormatter().format(lore, player)).toList());
        item.getStack().setItemMeta(meta);
    }

    /**
     * Sets all NBT values on the BaseItem.
     * This method handles different data types and applies them to the item's PersistentDataContainer.
     *
     * @param item The BaseItem to set NBTs for
     */
    public void setNBTs(BaseItem item) {
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer root = meta.getPersistentDataContainer();
        for (NBT<?> nbt : item.getNbts()) {
            String compoundName = nbt.getCompound();
            NamespacedKey key = nbt.getKey();
            Object value = nbt.getValue();
            PersistentDataContainer compound = root;
            if (compoundName != null) {
                String[] compoundPath = compoundName.split("\\.");
                for (String part : compoundPath) {
                    NamespacedKey partKey = new NamespacedKey(item.getPlugin(), part);
                    PersistentDataContainer nextContainer = compound.get(partKey, PersistentDataType.TAG_CONTAINER);
                    if (nextContainer == null) {
                        nextContainer = compound.getAdapterContext().newPersistentDataContainer();
                        compound.set(partKey, PersistentDataType.TAG_CONTAINER, nextContainer);
                    }
                    compound = nextContainer;
                }
            }
            String[] classNameSplit = value.getClass().getName().toLowerCase().split("\\.");
            switch (classNameSplit[classNameSplit.length - 1].toLowerCase()) {
                case "byte":
                    compound.set(key, PersistentDataType.BYTE, (byte) value);
                    continue;
                case "short":
                    compound.set(key, PersistentDataType.SHORT, (short) value);
                    continue;
                case "boolean":
                    compound.set(key, PersistentDataType.BOOLEAN, (boolean) value);
                    continue;
                case "double":
                    compound.set(key, PersistentDataType.DOUBLE, (double) value);
                    continue;
                case "float":
                    compound.set(key, PersistentDataType.FLOAT, (float) value);
                    continue;
                case "integer":
                    compound.set(key, PersistentDataType.INTEGER, (int) value);
                    continue;
                case "long":
                    compound.set(key, PersistentDataType.LONG, (long) value);
                    continue;
                default:
                    compound.set(key, PersistentDataType.STRING, String.valueOf(value));
            }
        }
        item.getStack().setItemMeta(meta);
    }

    /**
     * Sets all enchantments on the BaseItem.
     * Adds enabled enchantments and removes disabled ones.
     *
     * @param item The BaseItem to set enchantments for
     */
    public void setEnchants(BaseItem item) {
        ItemMeta meta = item.getItemMeta();
        for (Enchants enchants : item.getEnchants()) {
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
     * Sets all attributes on the BaseItem.
     *
     * @param item The BaseItem to set attributes for
     */
    public void setAttributes(BaseItem item) {
        ItemMeta meta = item.getItemMeta();
        for (Attributes attributes : item.getAttributes()) {
            Attribute attribute = attributes.getAttribute();
            AttributeModifier modifier = attributes.getAttributeModifier();
            meta.addAttributeModifier(attribute, modifier);
        }
        item.getStack().setItemMeta(meta);
    }

    /**
     * Sets the maximum stack size for the BaseItem.
     *
     * @param item The BaseItem to set max stack size for
     */
    public void setMaxAmount(BaseItem item) {
        ItemMeta meta = item.getItemMeta();
        meta.setMaxStackSize(item.getMaxAmount());
        item.getStack().setItemMeta(meta);
    }

    /**
     * Sets the durability for the BaseItem if it's damageable.
     *
     * @param item The BaseItem to set durability for
     */
    public void setDurability(BaseItem item) {
        ItemMeta meta = item.getItemMeta();
        if (meta instanceof Damageable dam) {
            dam.setDamage(item.getDurability());
        }
        item.getStack().setItemMeta(meta);
    }

    /**
     * Sets the custom model data for the BaseItem.
     *
     * @param item The BaseItem to set custom model data for
     */
    public void setCustomModelData(BaseItem item) {
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(item.getCustomModelData());
        item.getStack().setItemMeta(meta);
    }

    /**
     * Sets whether the BaseItem should have an enchantment glint effect.
     *
     * @param item The BaseItem to set glint effect for
     */
    public void setGlint(BaseItem item) {
        ItemMeta meta = item.getItemMeta();
        meta.setEnchantmentGlintOverride(item.isGlint());
        item.getStack().setItemMeta(meta);
    }

    /**
     * Sets whether the BaseItem should be resistant to fire damage.
     *
     * @param item The BaseItem to set fire resistance for
     */
    @SuppressWarnings("UnstableApiUsage")
    public void setFireResistance(BaseItem item) {
        ItemMeta meta = item.getItemMeta();
        meta.setDamageResistant(DamageTypeTags.IS_FIRE);
        item.getStack().setItemMeta(meta);
    }

    /**
     * Sets whether the BaseItem should be unbreakable.
     *
     * @param item The BaseItem to set unbreakable status for
     */
    public void setUnbreakable(BaseItem item) {
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(item.isUnbreakable());
        item.getStack().setItemMeta(meta);
    }

    /**
     * Sets whether tooltips should be hidden for the BaseItem.
     *
     * @param item The BaseItem to set tooltip visibility for
     */
    public void setHideTooltip(BaseItem item) {
        ItemMeta meta = item.getItemMeta();
        meta.setHideTooltip(item.isHideTooltip());
        item.getStack().setItemMeta(meta);
    }

    /**
     * Sets the rarity of the BaseItem.
     *
     * @param item The BaseItem to set rarity for
     */
    public void setItemRarity(BaseItem item) {
        ItemMeta meta = item.getItemMeta();
        meta.setRarity(item.getItemRarity());
        item.getStack().setItemMeta(meta);
    }

    /**
     * Sets the version of the BaseItem in its persistent data container.
     *
     * @param item The BaseItem to set version for
     */
    public void setVersion(BaseItem item) {
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(new NamespacedKey(item.getPlugin(), "version"), PersistentDataType.INTEGER, item.getVersion());
        item.getStack().setItemMeta(meta);
    }

    /**
     * Sets whether the BaseItem should be interactable in its persistent data container.
     *
     * @param item The BaseItem to set interactable status for
     */
    public void setInteractable(BaseItem item) {
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(new NamespacedKey(item.getPlugin(), "interactable"), PersistentDataType.BOOLEAN, item.isInteractable());
        item.getStack().setItemMeta(meta);
    }
}
