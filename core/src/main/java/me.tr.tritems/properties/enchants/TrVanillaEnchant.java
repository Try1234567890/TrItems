package me.tr.tritems.properties.enchants;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.serializer.annotations.Ignore;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashSet;
import java.util.stream.Collectors;

public class TrVanillaEnchant extends TrEnchantEntry {
    private final @Ignore Enchantment enchantment;

    @SuppressWarnings("UnstableApiUsage")
    public TrVanillaEnchant(Enchantment enchantment) {
        super(new TrIdentifier(enchantment.getKey()), -1, enchantment.getAnvilCost(), enchantment.getSupportedItems().values().stream().map(
                item -> RegistryAccess.registryAccess().getRegistry(RegistryKey.ITEM).get(item.registryKey().key())
        ).collect(Collectors.toSet()), new HashSet<>(), enchantment.getMaxLevel());
        //setConflicts(
        //        RegistryAccess.registryAccess().getRegistry(RegistryKey.ENCHANTMENT).stream()
        //                .filter(ench -> ench.conflictsWith(enchantment))
        //                .map(TrVanillaEnchant::new)
        //                .collect(Collectors.toSet()));
        // todo LATER TASKS
        this.enchantment = enchantment;
    }

    public Enchantment getEnchantment() {
        return enchantment;
    }

    @Override
    public void use(Player player, TrItem item) {
        // VANILLA HANDLED
    }

    @Override
    public void set(ItemMeta meta, int level) {
        if (meta == null) return;

        meta.addEnchant(getEnchantment(), level, true);
    }

    @Override
    public void set(ItemStack stack, int level) {
        ItemMeta meta = stack.getItemMeta();
        if (meta == null) return;

        meta.addEnchant(getEnchantment(), level, true);
    }

    @Override
    public boolean has(ItemMeta meta) {
        if (meta == null) return false;

        return meta.hasEnchant(getEnchantment());
    }

    @Override
    public boolean has(ItemStack stack) {
        ItemMeta meta = stack.getItemMeta();
        if (meta == null) return false;

        return meta.hasEnchant(getEnchantment());
    }

    @Override
    public void remove(ItemMeta meta) {
        if (meta == null) return;

        meta.removeEnchant(getEnchantment());
    }

    @Override
    public void remove(ItemStack stack) {
        ItemMeta meta = stack.getItemMeta();
        if (meta == null) return;

        meta.removeEnchant(getEnchantment());
    }
}
