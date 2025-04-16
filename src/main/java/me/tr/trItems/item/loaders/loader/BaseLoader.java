package me.tr.trItems.item.loaders.loader;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.configuration.Section;
import me.tr.trItems.TrItems;
import me.tr.trItems.item.helper.Attributes;
import me.tr.trItems.item.helper.Enchants;
import me.tr.trItems.item.helper.NBT;
import me.tr.trItems.item.items.BaseItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BaseLoader {
    protected TrItems main = TrItems.getInstance();


    public BaseItem load(Plugin plugin, Section itemSection) {
        String[] IDSplit = itemSection.getName().split("\\.");
        String ID = IDSplit[IDSplit.length - 1];
        ItemStack stack = getItemStack(itemSection);
        if (stack == null)
            throw new NullPointerException("Itemstack cannot be null. Check if \"Material\" variable is set inside item " + ID + " section.");
        String name = getName(itemSection);
        if (name == null)
            name = stack.getType().name();
        List<String> lore = getLore(itemSection);
        List<NBT<?>> nbts = getNBT(plugin, itemSection);
        List<Enchants> enchants = getEnchants(itemSection);
        List<Attributes> attributes = getAttributes(plugin, itemSection);
        int maxAmount = getMaxAmount(itemSection);
        int durability = getDurability(itemSection);
        int customModelData = getCustomModelData(itemSection);
        boolean glint = getGlint(itemSection);
        boolean fireResistance = getFireResistance(itemSection);
        boolean unbreakable = getUnbreakable(itemSection);
        boolean hideTooltip = getHideTooltip(itemSection);
        boolean interactable = getInteractable(itemSection);
        ItemRarity rarity = getItemRarity(itemSection);
        int version = getVersion(itemSection);
        File file = itemSection.getRoot().getFile();
        return new BaseItem(ID, name, lore, nbts, enchants, attributes, stack, maxAmount, durability, customModelData, glint, fireResistance, unbreakable, hideTooltip, rarity, version, interactable, file, plugin);
    }


    public String getName(Section item) {
        return item.getString("Name");
    }

    public List<String> getLore(Section item) {
        return item.getStringList("Lore");
    }

    public List<NBT<?>> getNBT(Plugin plugin, Section item) {
        final List<NBT<?>> result = new ArrayList<>();
        List<String> specifiedNBTs = item.getStringList("NBTs");
        for (String specifiedNBT : specifiedNBTs) {
            String[] splitNBT = specifiedNBT.split(" ");
            if (splitNBT.length < 2) {
                main.getTrLogger().error("NBT " + specifiedNBT + " not contains enough information.");
                continue;
            }
            String compound = null;
            if (splitNBT.length >= 3) {
                compound = splitNBT[2].toLowerCase();
            }
            NamespacedKey key = new NamespacedKey(plugin, splitNBT[0]);
            Object value = splitNBT[1];
            result.add(new NBT<>(compound, key, value));
        }
        return result;
    }


    public List<Enchants> getEnchants(Section item) {
        final List<Enchants> result = new ArrayList<>();
        List<String> specifiedEnchants = item.getStringList("Enchants");
        for (String specifiedEnchant : specifiedEnchants) {
            String[] splitEnchant = specifiedEnchant.split(" ");
            if (splitEnchant.length < 2)
                throw new ArrayIndexOutOfBoundsException("Enchantment " + specifiedEnchant + " not contains enough information.");
            NamespacedKey key = main.getItemManager().getNamespacedKey(splitEnchant[0]);
            Enchantment enchantment = RegistryAccess.registryAccess().getRegistry(RegistryKey.ENCHANTMENT).get(key);
            if (enchantment == null)
                throw new NullPointerException("Could not find enchantment " + key);
            try {
                int level = Integer.parseInt(splitEnchant[1]);
                result.add(new Enchants(enchantment, level));
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Level of enchantment " + key + " is not a number.");
            }
        }
        return result;
    }


    public List<Attributes> getAttributes(Plugin plugin, Section item) {
        final List<Attributes> result = new ArrayList<>();
        List<String> specifiedAttributes = item.getStringList("Attributes");
        for (String specifiedAttribute : specifiedAttributes) {
            String[] splitAttribute = specifiedAttribute.split(" ");
            if (splitAttribute.length < 2)
                throw new ArrayIndexOutOfBoundsException("Attribute " + specifiedAttribute + " not contains enough information.");
            NamespacedKey attributeKey = new NamespacedKey(plugin, splitAttribute[0]);
            Attribute attribute = RegistryAccess.registryAccess().getRegistry(RegistryKey.ATTRIBUTE).get(attributeKey);
            if (attribute == null)
                throw new NullPointerException("Could not find attribute " + attributeKey);
            NamespacedKey attributeModifierKey = new NamespacedKey(plugin, splitAttribute[1]);
            try {
                double amount = Double.parseDouble(splitAttribute[2]);
                AttributeModifier.Operation operation = AttributeModifier.Operation.valueOf(splitAttribute[3]);
                AttributeModifier attributeModifier = new AttributeModifier(attributeModifierKey, amount, operation);

                result.add(new Attributes(attribute, attributeModifier));
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Amount of attribute " + attributeKey + " is not a number.");
            }
        }
        return result;
    }

    public ItemStack getItemStack(Section item) {
        String materialStr = item.getString("Material");
        Material material = Material.getMaterial(materialStr);
        if (material == null)
            throw new NullPointerException("Material " + materialStr + " is not a valid material.");
        int amount = item.getInt("Amount", 1);
        return new ItemStack(material, amount);
    }

    public int getMaxAmount(Section item) {
        return item.getInt("MaxAmount", 64);
    }

    public int getDurability(Section item) {
        return item.getInt("Durability", 0);
    }

    public int getCustomModelData(Section item) {
        return item.getInt("CustomModelData");
    }

    public boolean getGlint(Section item) {
        return item.getBoolean("Glint");
    }

    public boolean getFireResistance(Section item) {
        return item.getBoolean("FireResistance");
    }

    public boolean getUnbreakable(Section item) {
        return item.getBoolean("Unbreakable");
    }

    public boolean getHideTooltip(Section item) {
        return item.getBoolean("HideTooltip");
    }

    public boolean getInteractable(Section item) {
        return item.getBoolean("Interactable");
    }

    public ItemRarity getItemRarity(Section item) {
        String rarityStr = item.getString("Rarity", "COMMON");
        try {
            return ItemRarity.valueOf(rarityStr);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Rarity " + rarityStr + " is not a valid rarity.");
        }
    }

    public int getVersion(Section item) {
        return item.getInt("Version");
    }
}
