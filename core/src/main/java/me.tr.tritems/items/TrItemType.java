package me.tr.tritems.items;

import me.tr.serializer.instancers.AllInOneInstancer;
import me.tr.trfiles.file.configuration.Section;
import me.tr.trfiles.file.configuration.memory.implementations.MemoryJsonConfiguration;
import me.tr.tritems.metas.*;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.properties.identification.TrReusableIdentifier;
import me.tr.tritems.registries.TrItemMetaRegistry;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public enum TrItemType {

    MYTHIC_MOBS(MMItem.class, TrItemMeta.class) {
        @Override
        public boolean is(Section section) {
            return section.contains("MM");
        }

        @Override
        public boolean is(Material mat) {
            return false; // Only with config.
        }
    },

    MMO_ITEMS(MMOItem.class, TrItemMeta.class) {
        @Override
        public boolean is(Section section) {
            return section.contains("MMOItems");
        }

        @Override
        public boolean is(Material mat) {
            return false; // Only with config.
        }
    },

    EXECUTABLE_ITEMS(EIItem.class, TrItemMeta.class) {
        @Override
        public boolean is(Section section) {
            return section.contains("EItems");
        }

        @Override
        public boolean is(Material mat) {
            return false; // Only with config.
        }
    },

    SPAWN_EGG(TrSpawnEggItem.class, TrSpawnEggMeta.class) {
        @Override
        public boolean is(Section section) {
            return getMaterial(section).contains("SPAWN_EGG");
        }

        @Override
        public boolean is(Material mat) {
            return mat.name().endsWith("SPAWN_EGG");
        }
    },

    CROSSBOW(TrCrossbowItem.class, TrCrossbowMeta.class) {
        @Override
        public boolean is(Section section) {
            return getMaterial(section).equals("CROSSBOW");
        }

        @Override
        public boolean is(Material mat) {
            return mat == Material.CROSSBOW;
        }
    },

    COMPASS(TrCompassItem.class, TrCompassMeta.class) {
        @Override
        public boolean is(Section section) {
            return getMaterial(section).equals("COMPASS");
        }

        @Override
        public boolean is(Material mat) {
            return mat == Material.COMPASS;
        }
    },

    FIREWORK_ROCKET(TrFireworkRocketItem.class, TrFireworkRocketMeta.class) {
        @Override
        public boolean is(Section section) {
            return getMaterial(section).equals("FIREWORK_ROCKET");
        }

        @Override
        public boolean is(Material mat) {
            return mat == Material.FIREWORK_ROCKET;
        }
    },

    FIREWORK_STAR(TrFireworkStarItem.class, TrFireworkStarMeta.class) {
        @Override
        public boolean is(Section section) {
            return getMaterial(section).equals("FIREWORK_STAR");
        }

        @Override
        public boolean is(Material mat) {
            return mat == Material.FIREWORK_STAR;
        }
    },

    POTION(TrPotionItem.class, TrPotionMeta.class) {
        @Override
        public boolean is(Section section) {
            String mat = getMaterial(section);
            return mat.contains("POTION") || mat.equals("TIPPED_ARROW");
        }

        @Override
        public boolean is(Material mat) {
            String name = mat.name();
            return name.contains("POTION") || name.equals("TIPPED_ARROW");
        }
    },

    OMINOUS_BOTTLE(TrOminousBottleItem.class, TrOminousBottleMeta.class) {
        @Override
        public boolean is(Section section) {
            return getMaterial(section).equals("OMINOUS_BOTTLE");
        }

        @Override
        public boolean is(Material mat) {
            return mat == Material.OMINOUS_BOTTLE;
        }
    },

    MAP(TrMapItem.class, TrMapMeta.class) {
        @Override
        public boolean is(Section section) {
            return getMaterial(section).equals("FILLED_MAP");
        }

        @Override
        public boolean is(Material mat) {
            return mat == Material.FILLED_MAP;
        }
    },

    SHIELD(TrShieldItem.class, TrShieldMeta.class) {
        @Override
        public boolean is(Section section) {
            return getMaterial(section).equals("SHIELD");
        }

        @Override
        public boolean is(Material mat) {
            return mat == Material.SHIELD;
        }
    },

    BANNER(TrBannerItem.class, TrBannerMeta.class) {
        @Override
        public boolean is(Section section) {
            return getMaterial(section).endsWith("BANNER");
        }

        @Override
        public boolean is(Material mat) {
            String name = mat.name();
            return !name.contains("WALL") && name.endsWith("BANNER");
        }
    },

    ARMOR(TrArmorItem.class, TrArmorMeta.class) {
        @Override
        public boolean is(Section section) {
            String mat = getMaterial(section);
            return (mat.endsWith("_HELMET") ||
                    mat.endsWith("_CHESTPLATE") ||
                    mat.endsWith("_LEGGINGS") ||
                    mat.endsWith("_BOOTS") ||
                    mat.endsWith("_ARMOR")) &&
                    !mat.contains("LEATHER") &&
                    !mat.contains("HORSE") &&
                    !mat.contains("WOLF");
        }

        @Override
        public boolean is(Material mat) {
            String name = mat.name();
            return (name.endsWith("_HELMET") ||
                    name.endsWith("_CHESTPLATE") ||
                    name.endsWith("_LEGGINGS") ||
                    name.endsWith("_BOOTS") ||
                    name.endsWith("_ARMOR")) &&
                    !name.contains("LEATHER") &&
                    !name.contains("HORSE") &&
                    !name.contains("WOLF");
        }
    },

    ANIMAL_ARMOR(TrAnimalArmorItem.class, TrAnimalArmorMeta.class) {
        @Override
        public boolean is(Section section) {
            String mat = getMaterial(section);
            return (mat.startsWith("LEATHER_") && mat.endsWith("_HORSE_ARMOR")) || mat.equals("WOLF_ARMOR");
        }

        @Override
        public boolean is(Material mat) {
            String name = mat.name();
            return (name.startsWith("LEATHER_") && name.endsWith("_HORSE_ARMOR")) || mat == Material.WOLF_ARMOR;
        }
    },


    LEATHER_ARMOR(TrLeatherArmorItem.class, TrLeatherArmorMeta.class) {
        @Override
        public boolean is(Section section) {
            String mat = getMaterial(section);
            return mat.contains("LEATHER_") && !mat.endsWith("_HORSE_ARMOR");
        }

        @Override
        public boolean is(Material mat) {
            String name = mat.name();
            return name.contains("LEATHER_") && !name.endsWith("_HORSE_ARMOR");
        }
    },

    SKULL(TrSkullItem.class, TrSkullMeta.class) {
        @Override
        public boolean is(Section section) {
            String mat = getMaterial(section);
            return mat.endsWith("SKULL") || mat.endsWith("HEAD");
        }

        @Override
        public boolean is(Material mat) {
            String name = mat.name();
            return !name.contains("WALL") && (name.endsWith("SKULL") || name.endsWith("HEAD"));
        }
    },

    ENCHANTED_BOOK(TrEnchantedBookItem.class, TrEnchantedBookMeta.class) {
        @Override
        public boolean is(Section section) {
            return getMaterial(section).equals("ENCHANTED_BOOK");
        }

        @Override
        public boolean is(Material mat) {
            return mat == Material.ENCHANTED_BOOK;
        }
    },

    WRITTEN_BOOK(TrWrittenBookItem.class, TrWrittenBookMeta.class) {
        @Override
        public boolean is(Section section) {
            return getMaterial(section).equals("WRITTEN_BOOK");
        }

        @Override
        public boolean is(Material mat) {
            return mat == Material.WRITTEN_BOOK;
        }
    },

    WRITABLE_BOOK(TrWritableBookItem.class, TrWritableBookMeta.class) {
        @Override
        public boolean is(Section section) {
            return getMaterial(section).equals("WRITABLE_BOOK");
        }

        @Override
        public boolean is(Material mat) {
            return mat == Material.WRITABLE_BOOK;
        }
    },

    KNOWLEDGE_BOOK(TrKnowledgeBookItem.class, TrKnowledgeBookMeta.class) {
        @Override
        public boolean is(Section section) {
            return getMaterial(section).equals("KNOWLEDGE_BOOK");
        }

        @Override
        public boolean is(Material mat) {
            return mat == Material.KNOWLEDGE_BOOK;
        }
    },

    BUNDLE(TrBundleItem.class, TrBundleMeta.class) {
        @Override
        public boolean is(Section section) {
            return getMaterial(section).contains("BUNDLE");
        }

        @Override
        public boolean is(Material mat) {
            return mat.name().contains("BUNDLE");
        }
    },

    SUSPICIOUS_STEW(TrSuspiciousStewItem.class, TrSuspiciousStewMeta.class) {
        @Override
        public boolean is(Section section) {
            return getMaterial(section).equals("SUSPICIOUS_STEW");
        }

        @Override
        public boolean is(Material mat) {
            return mat == Material.SUSPICIOUS_STEW;
        }
    },

    MUSIC_INSTRUMENT(TrMusicInstrumentItem.class, TrMusicInstrumentMeta.class) {
        @Override
        public boolean is(Section section) {
            return getMaterial(section).equals("GOAT_HORN");
        }

        @Override
        public boolean is(Material mat) {
            return mat == Material.GOAT_HORN;
        }
    },

    TROPICAL_FISH_BUCKET(TrTropicalFishBucketItem.class, TrTropicalFishBucketMeta.class) {
        @Override
        public boolean is(Section section) {
            return getMaterial(section).equals("TROPICAL_FISH_BUCKET");
        }

        @Override
        public boolean is(Material mat) {
            return mat == Material.TROPICAL_FISH_BUCKET;
        }
    },

    NORMAL(TrItem.class, TrItemMeta.class) {
        @Override
        public boolean is(Section section) {
            return true;
        }

        @Override
        public boolean is(Material mat) {
            return true;
        }
    };

    private static final AllInOneInstancer instancer = new AllInOneInstancer();
    private final Class<? extends TrItem> clazzItem;
    private final Class<? extends TrItemMeta> clazzMeta;
    private Set<Material> validMaterials = null;

    TrItemType(Class<? extends TrItem> item, Class<? extends TrItemMeta> meta) {
        this.clazzItem = item;
        this.clazzMeta = meta;
    }

    private static String getMaterial(Section section) {
        String res = section.getString("Material", section.getString("material"));
        return res != null ? res.toUpperCase() : "";
    }

    public static TrItemType from(Material mat) {
        if (mat == null) return null;

        for (TrItemType type : values()) {
            if (type == NORMAL || type == MYTHIC_MOBS || type == MMO_ITEMS || type == EXECUTABLE_ITEMS) continue;
            if (type.is(mat)) return type;
        }

        return NORMAL;
    }

    public static TrItemType from(Section section) {
        for (TrItemType type : values()) {
            if (type == NORMAL) continue;
            if (type.is(section)) return type;
        }
        return NORMAL;
    }

    public Set<Material> getValidMaterials() {
        if (validMaterials == null) {
            validMaterials = Arrays.stream(Material.values())
                    .filter(mat -> !mat.name().contains("LEGACY"))
                    .filter(this::is)
                    .collect(Collectors.toSet());
        }
        return validMaterials;
    }

    public Material getExampleItem() {
        Set<Material> materials = getValidMaterials();
        return materials.isEmpty() ? Material.AIR : materials.iterator().next();
    }

    public static @Nullable TrItemType from(ItemStack stack) {
        return stack == null ? null : from(stack.getType());
    }

    public static TrItemType from(Map<String, Object> map) {
        return from(MemoryJsonConfiguration.fromMap(map));
    }

    public TrItem getNewItem() {
        return (TrItem) instancer.instance(clazzItem);
    }

    public Class<? extends TrItemMeta> getMeta() {
        return clazzMeta;
    }

    public Class<? extends TrItem> getItem() {
        return clazzItem;
    }

    public abstract boolean is(Section section);

    public abstract boolean is(Material mat);

    public TrItemMeta getMeta(TrItem item) {
        TrIdentifier ID = TrReusableIdentifier.of(clazzMeta.getSimpleName());
        TrItemMetaEntry meta = TrItemMetaRegistry.getInstance().get(ID);
        return meta != null ? meta.newInstance(item) : null;
    }
}