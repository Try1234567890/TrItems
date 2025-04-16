package me.tr.trItems.item.loaders;

import me.tr.configuration.Section;
import me.tr.trItems.TrItems;
import me.tr.trItems.item.helper.ItemType;
import me.tr.trItems.item.items.*;
import me.tr.trItems.item.loaders.loader.*;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ItemLoaderManager {
    private final TrItems main = TrItems.getInstance();

    public List<BaseItem> loadAll(Plugin plugin, Section itemsSection) {
        final List<BaseItem> items = new ArrayList<>();
        for (String id : itemsSection.getKeys(false)) {
            Section itemSection = itemsSection.getSection(id);
            items.add(loadItem(plugin, itemSection));
        }
        return items;
    }

    public BaseItem loadItem(Plugin plugin, Section itemSection) {
        ItemType itemType = main.getItemManager().getItemType(itemSection);
        switch (itemType) {
            case ARMOR:
                ArmorItem armorItem = new ArmorLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(armorItem);
                break;
            case ARMOR_STAND:
                ArmorStandItem armorStandItem = new ArmorStandLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(armorStandItem);
                break;
            case AXOLOTL_BUCKET:
                AxolotlBucketItem axolotlBucketItem = new AxolotlBucketLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(axolotlBucketItem);
                break;
            case BANNER:
                BannerItem bannerItem = new BannerLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(bannerItem);
                break;
            case BOOK:
                BookItem bookItem = new BookLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(bookItem);
                break;
            case BUNDLE:
                BundleItem bundleItem = new BundleLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(bundleItem);
                break;
            case COMPASS:
                CompassItem compassItem = new CompassLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(compassItem);
                break;
            case CROSSBOW:
                CrossBowItem crossBowItem = new CrossBowLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(crossBowItem);
                break;
            case EXECUTABLE_ITEMS:
                BaseItem executableItems = new BaseLoader().load(plugin, itemSection);
                // todo
                main.getItemManager().getCachedItems().add(executableItems);
                break;
            case FIREWORK:
                FireworkItem fireworkItem = new FireworkLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(fireworkItem);
                break;
            case KNOWLEDGE_BOOK:
                KnowledgeBookItem knowledgeBookItem = new KnowledgeBookLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(knowledgeBookItem);
                break;
            case LEATHER_ARMOR:
                LeatherArmorItem leatherArmorItem = new LeatherArmorLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(leatherArmorItem);
                break;
            case MAP:
                MapItem mapItem = new MapLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(mapItem);
                break;
            case MMOITEM:
                BaseItem mmoItems = new BaseLoader().load(plugin, itemSection);
                // todo
                main.getItemManager().getCachedItems().add(mmoItems);
                break;
            case MUSIC_INSTRUMENT:
                MusicInstrumentItem musicInstrumentItem = new MusicInstrumentLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(musicInstrumentItem);
                break;
            case MYTHIC_MOBS:
                BaseItem mythicMobs = new BaseLoader().load(plugin, itemSection);
                // todo
                main.getItemManager().getCachedItems().add(mythicMobs);
                break;
            case OMINOUS_BOTTLE:
                OminousBottleItem ominousBottleItem = new OminousBottleLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(ominousBottleItem);
                break;
            case POTION:
                PotionItem potionItem = new PotionLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(potionItem);
                break;
            case SHIELD:
                ShieldItem shieldItem = new ShieldLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(shieldItem);
                break;
            case SKULL:
                SkullItem skullItem = new SkullLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(skullItem);
                break;
            case SPAWN_EGG:
                SpawnEggItem spawnEggItem = new SpawnEggLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(spawnEggItem);
                break;
            case SUSPICIOUS_STEW:
                SuspiciousStewItem suspiciousStewItem = new SuspiciousStewLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(suspiciousStewItem);
                break;
            case TROPICAL_FISH_BUCKET:
                TropicalFishBucketItem tropicalFishBucketItem = new TropicalFishBucketLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(tropicalFishBucketItem);
                break;
            case INVENTORY_ITEM:
                InventoryItem inventoryItem = new InventoryLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(inventoryItem);
                break;
            default:
                BaseItem baseItem = new BaseLoader().load(plugin, itemSection);
                main.getItemManager().getCachedItems().add(baseItem);
                break;
        }
        return null;
    }

    public List<BaseItem> getItems(Plugin plugin, Section itemsSection) {
        List<BaseItem> items = new ArrayList<>();
        for (String itemID : itemsSection.getKeys(false)) {
            Section itemSection = itemsSection.getSection(itemID);
            BaseItem item = loadItem(plugin, itemSection);
            items.add(item);
        }
        return items;
    }

    public @Nullable Color convertColor(String colorStr) {
        Color color = null;
        String[] colorStrSplit = colorStr.split(" ");
        if (colorStr.startsWith("#")) {
            colorStr = colorStr.substring(1);
            int r = Integer.parseInt(colorStr.substring(0, 2), 16);
            int g = Integer.parseInt(colorStr.substring(2, 4), 16);
            int b = Integer.parseInt(colorStr.substring(4, 6), 16);
            color = Color.fromRGB(r, g, b);
        } else if (colorStrSplit.length >= 3) {
            color = Color.fromRGB(Integer.parseInt(colorStrSplit[0]), Integer.parseInt(colorStrSplit[1]), Integer.parseInt(colorStrSplit[2]));
        } else {
            try {
                color = DyeColor.valueOf(colorStr).getColor();
            } catch (IllegalArgumentException e) {
                main.getTrLogger().error("Invalid color: " + colorStr);
            }
        }
        return color;
    }

    public List<Color> convertColors(List<String> colorsStr) {
        List<Color> colors = new ArrayList<>();
        for (String colorStr : colorsStr) {
            Color color = convertColor(colorStr);
            colors.add(color);
        }
        return colors;
    }
}
