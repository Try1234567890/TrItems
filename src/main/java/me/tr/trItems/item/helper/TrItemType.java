package me.tr.trItems.item.helper;

import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.loaders.loader.*;
import me.tr.trItems.item.metas.*;
import me.tr.trItems.utilities.EnumUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public enum TrItemType {

    // VANILLA
    ARMOR(new TrArmorLoader(), TrArmorMeta.class, true, "HELMET", "CHESTPLATE", "LEGGINGS", "BOOTS"),
    LEATHER_ARMOR(new TrLeatherArmorLoader(), TrLeatherArmorMeta.class, true, "LEATHER_HELMET", "LEATHER_CHESTPLATE", "LEATHER_LEGGINGS", "LEATHER_BOOTS"),
    ARMOR_STAND(new TrArmorStandLoader(), TrArmorStandMeta.class, true, "ARMOR_STAND"),
    AXOLOTL_BUCKET(new TrAxolotlBucketLoader(), TrAxolotlBucketMeta.class, true, "AXOLOTL_BUCKET"),
    BANNER(new TrBannerLoader(), TrBannerMeta.class, true, "BANNER"),
    BOOK(new TrBookLoader(), TrBookMeta.class, true, "BOOK"),
    BUNDLE(new TrBundleLoader(), TrBundleMeta.class, true, "BUNDLE"),
    COMPASS(new TrCompassLoader(), TrCompassMeta.class, true, "COMPASS"),
    CROSSBOW(new TrCrossBowLoader(), TrCrossBowMeta.class, true, "CROSSBOW"),
    FIREWORK(new TrFireworkLoader(), TrFireworkMeta.class, true, "FIREWORK"),
    KNOWLEDGE_BOOK(new TrKnowledgeBookLoader(), TrKnowledgeBookMeta.class, true, "KNOWLEDGE_BOOK"),
    FILLED_MAP(new TrMapLoader(), TrMapMeta.class, true, "FILLED_MAP"),
    MUSIC_INSTRUMENT(new TrMusicInstrumentLoader(), TrMusicInstrumentMeta.class, true, "GOAT_CORN"),
    OMINOUS_BOTTLE(new TrOminousBottleLoader(), TrOminousBottleMeta.class, true, "OMINOUS_BOTTLE"),
    POTION(new TrPotionLoader(), TrPotionMeta.class, true, "POTION"),
    SHIELD(new TrShieldLoader(), TrShieldMeta.class, true, "SHIELD"),
    SKULL(new TrSkullLoader(), TrSkullMeta.class, true, "HEAD", "SKULL"),
    SPAWN_EGG(new TrSpawnEggLoader(), TrSpawnEggMeta.class, true, "SPAWN_EGG"),
    SUSPICIOUS_STEW(new TrSuspiciousStewLoader(), TrSuspiciousStewMeta.class, true, "SUSPICIOUS_STEW"),
    TROPICAL_FISH_BUCKET(new TrTropicalFishBucketLoader(), TrTropicalFishBucketMeta.class, true, "TROPICAL_FISH_BUCKET"),
    BASE(new TrBaseLoader(), TrBaseMeta.class, true),

    // NON VANILLA
    EXECUTABLE_ITEMS(new TrExecutableItemsLoader(), TrExecutableItemsMeta.class, false, "ExecutableItems"),
    MMOITEM(new TrMMOItemLoader(), TrMMOItemMeta.class, false, "MMOItem"),
    MYTHIC_MOBS(new TrMythicMobsLoader(), TrMythicMobsMeta.class, false, "MythicMobs"),
    INVENTORY_ITEM(new TrInventoryItemLoader(), TrInventoryItemMeta.class, false, "Slot"),

    ;

    private final TrBaseLoader loader;
    private final Class<? extends TrBaseMeta> meta;
    private final boolean vanilla;
    private final String[] ids;

    TrItemType(TrBaseLoader loader, Class<? extends TrBaseMeta> meta, boolean vanilla, String... ids) {
        this.loader = loader;
        this.meta = meta;
        this.vanilla = vanilla;
        this.ids = EnumUtil.expandIDs(ids);
    }

    /**
     * Get {@link TrItemType} instance from the item section if found.
     *
     * @param section Root Item Section.
     * @return The corresponding instance of {@link TrItemType} if found, otherwise {@link TrItemType#BASE}.
     */
    public static TrItemType parse(Section section) {
        if (section == null || !section.contains("Material")) {
            return TrItemType.BASE;
        }
        for (TrItemType type : TrItemType.values()) {
            if (type.isVanilla()) {
                String material = section.getString("Material");
                if (Arrays.stream(type.getIds()).anyMatch(material::contains)) {
                    return type;
                }
            } else {
                if (Arrays.stream(type.getIds()).anyMatch(section::contains)) {
                    return type;
                }
            }
        }
        return TrItemType.BASE;
    }

    public TrBaseLoader getLoader() {
        return loader;
    }

    public TrBaseMeta getMeta() {
        try {
            Constructor<? extends TrBaseMeta> constructor = meta.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException _) {
        }
        return new TrBaseMeta(null);
    }

    public String[] getIds() {
        return ids;
    }

    public boolean isVanilla() {
        return vanilla;
    }
}
