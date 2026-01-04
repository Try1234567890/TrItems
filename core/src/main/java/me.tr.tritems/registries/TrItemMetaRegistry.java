package me.tr.tritems.registries;

import me.tr.tritems.metas.*;
import me.tr.tritems.properties.identification.TrIdentifier;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TrItemMetaRegistry extends TrRegistry<TrItemMetaEntry> {
    private static TrItemMetaRegistry instance;
    private final Map<TrIdentifier, TrItemMetaEntry> registry = new HashMap<>();

    private TrItemMetaRegistry() {
    }

    public static TrItemMetaRegistry getInstance() {
        if (instance == null) {
            instance = new TrItemMetaRegistry();
            Arrays.stream(new TrItemMetaEntry[]{
                    TrAnimalArmorMeta.ENTRY,
                    TrArmorMeta.ENTRY,
                    TrBannerMeta.ENTRY,
                    TrBundleMeta.ENTRY,
                    TrCompassMeta.ENTRY,
                    TrCrossbowMeta.ENTRY,
                    TrEnchantedBookMeta.ENTRY,
                    TrFireworkRocketMeta.ENTRY,
                    TrFireworkStarMeta.ENTRY,
                    TrItemMeta.ENTRY,
                    TrKnowledgeBookMeta.ENTRY,
                    TrLeatherArmorMeta.ENTRY,
                    TrMapMeta.ENTRY,
                    TrMusicInstrumentMeta.ENTRY,
                    TrOminousBottleMeta.ENTRY,
                    TrPotionMeta.ENTRY,
                    TrShieldMeta.ENTRY,
                    TrSkullMeta.ENTRY,
                    TrSpawnEggMeta.ENTRY,
                    TrSuspiciousStewMeta.ENTRY,
                    TrTropicalFishBucketMeta.ENTRY,
                    TrWritableBookMeta.ENTRY,
                    TrWrittenBookMeta.ENTRY
            }).forEach(entry -> instance.register(entry));
        }
        return instance;
    }

    @Override
    public Map<TrIdentifier, TrItemMetaEntry> getRegistry() {
        return registry;
    }
}
