package me.tr.tritems.properties.enchants;

import me.tr.serializer.annotations.Initialize;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public record TrEnchant(TrEnchantEntry enchant, int level) {

    @Initialize(paramNames = {"enchant", "level"})
    public TrEnchant {
    }

    public boolean has(ItemStack stack) {
        return enchant.has(stack);
    }

    public void set(ItemStack stack) {
        enchant.set(stack, level);
    }

    public void remove(ItemStack stack) {
        enchant.remove(stack);
    }

    public boolean has(ItemMeta meta) {
        return enchant.has(meta);
    }

    public void set(ItemMeta meta) {
        enchant.set(meta, level);
    }

    public void remove(ItemMeta meta) {
        enchant.remove(meta);
    }

    @Override
    public String toString() {
        return "TrEnchant{Enchant=" + enchant.identifier() + ", Level=" + level + '}';
    }
}
