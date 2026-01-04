package me.tr.tritems.registries;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.tritems.properties.enchants.TrEnchantEntry;
import me.tr.tritems.properties.enchants.TrVanillaEnchant;
import me.tr.tritems.properties.identification.TrIdentifier;

import java.util.HashMap;
import java.util.Map;

/**
 * This registry contains all known {@link TrEnchantEntry} implementations.
 */
public class TrEnchantRegistry extends TrRegistry<TrEnchantEntry> {
    private static TrEnchantRegistry instance;
    private final Map<TrIdentifier, TrEnchantEntry> registry = new HashMap<>();

    private TrEnchantRegistry() {
    }

    public static TrEnchantRegistry getInstance() {
        if (instance == null) {
            instance = new TrEnchantRegistry();
            RegistryAccess.registryAccess().getRegistry(RegistryKey.ENCHANTMENT)
                    .stream()
                    .forEach(TrVanillaEnchant::new);
        }
        return instance;
    }

    @Override
    public Map<TrIdentifier, TrEnchantEntry> getRegistry() {
        return registry;
    }
}
