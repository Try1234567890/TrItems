package me.tr.tritems.registries;

import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.identification.TrIdentifier;

import java.util.HashMap;
import java.util.Map;

public class TrItemRegistry extends TrRegistry<TrItem> {
    private static TrItemRegistry instance;
    private final Map<TrIdentifier, TrItem> registry = new HashMap<>();

    private TrItemRegistry() {
    }

    public static TrItemRegistry getInstance() {
        if (instance == null) {
            instance = new TrItemRegistry();
        }
        return instance;
    }

    @Override
    public Map<TrIdentifier, TrItem> getRegistry() {
        return registry;
    }
}
