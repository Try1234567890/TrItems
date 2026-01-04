package me.tr.tritems.registries;

import me.tr.tritems.properties.flags.TrFlag;
import me.tr.tritems.properties.flags.TrGlint;
import me.tr.tritems.properties.flags.TrUnbreakable;
import me.tr.tritems.properties.identification.TrIdentifier;

import java.util.HashMap;
import java.util.Map;

public class TrFlagRegistry extends TrRegistry<TrFlag> {
    private static TrFlagRegistry instance;
    private final Map<TrIdentifier, TrFlag> registry = new HashMap<>();

    private TrFlagRegistry() {
    }

    public static TrFlagRegistry getInstance() {
        if (instance == null) {
            instance = new TrFlagRegistry();
            new TrGlint();
            new TrUnbreakable();
        }
        return instance;
    }

    @Override
    public Map<TrIdentifier, TrFlag> getRegistry() {
        return registry;
    }
}
