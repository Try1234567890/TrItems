package me.tr.trItems.item.loaders.loader;

import me.tr.configuration.Section;
import me.tr.trItems.item.items.BaseItem;
import me.tr.trItems.item.items.PotionItem;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;

public class PotionLoader extends BaseLoader {

    public PotionItem load(Plugin plugin, Section itemSection) {
        BaseItem baseItem = super.load(plugin, itemSection);
        String customName = getCustomName(itemSection);
        Color color = getColor(itemSection);
        List<PotionEffect> customEffects = getCustomEffects(itemSection);
        PotionType potionType = getPotionType(itemSection);
        return new PotionItem(baseItem, potionType, customEffects, color, customName);
    }

    public String getCustomName(Section itemSection) {
        return itemSection.getString("CustomName");
    }

    public Color getColor(Section itemSection) {
        String color = itemSection.getString("Color");
        return main.getItemLoaderManager().convertColor(color);
    }

    public List<PotionEffect> getCustomEffects(Section itemSection) {
        List<PotionEffect> effects = new ArrayList<>();
        List<String> effectsStr = itemSection.getStringList("CustomEffects");
        for (String effect : effectsStr) {
            String[] effectSplit = effect.split(" ");
            if (effectSplit.length < 3) {
                main.getTrLogger().error("Effect " + effect + " not contains enough information.");
                continue;
            }
            NamespacedKey potionEffectTypeKey = main.getItemManager().getNamespacedKey(effectSplit[0]);
            PotionEffectType potionEffectType = Registry.POTION_EFFECT_TYPE.get(potionEffectTypeKey);
            if (potionEffectType == null) {
                main.getTrLogger().error("Unknown potion effect type " + potionEffectTypeKey);
                continue;
            }
            try {
                int duration = Integer.parseInt(effectSplit[1]);
                int amplifier = Integer.parseInt(effectSplit[2]);
                boolean ambient = Boolean.parseBoolean(effectSplit[3]);
                boolean particles = Boolean.parseBoolean(effectSplit[4]);
                boolean icon = Boolean.parseBoolean(effectSplit[5]);
                effects.add(new PotionEffect(potionEffectType, duration, amplifier, ambient, particles, icon));
            } catch (NumberFormatException e) {
                main.getTrLogger().error("Duration & Amplifier must be numbers " + effectSplit[1] + " & " + effectSplit[2]);
            }
        }
        return effects;
    }

    public PotionType getPotionType(Section itemSection) {
        String potionType = itemSection.getString("PotionType");
        try {
            return PotionType.valueOf(potionType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid PotionType: " + potionType);
        }
    }
}
