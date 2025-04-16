package me.tr.trItems.item.loaders.loader;

import io.papermc.paper.potion.SuspiciousEffectEntry;
import me.tr.configuration.Section;
import me.tr.trItems.item.items.BaseItem;
import me.tr.trItems.item.items.SuspiciousStewItem;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class SuspiciousStewLoader extends BaseLoader {

    public SuspiciousStewItem load(Plugin plugin, Section itemSection) {
        BaseItem baseItem = super.load(plugin, itemSection);
        List<SuspiciousEffectEntry> suspiciousEffects = getSuspiciousEffects(itemSection);
        return new SuspiciousStewItem(baseItem, suspiciousEffects);
    }

    public List<SuspiciousEffectEntry> getSuspiciousEffects(Section itemSection) {
        final List<SuspiciousEffectEntry> suspiciousEffects = new ArrayList<>();
        List<String> suspiciousEffectsStr = itemSection.getStringList(" ");
        for (String suspiciousEffect : suspiciousEffectsStr) {
            String[] suspiciousEffectSplit = suspiciousEffect.split(" ");
            if (suspiciousEffectSplit.length < 1) {
                main.getTrLogger().error("SuspiciousEffect " + suspiciousEffect + " not contains enough information.");
                continue;
            }
            NamespacedKey suspiciousEffectTypeKey = main.getItemManager().getNamespacedKey(suspiciousEffectSplit[0]);
            PotionEffectType suspiciousEffectType = Registry.POTION_EFFECT_TYPE.get(suspiciousEffectTypeKey);
            if (suspiciousEffectType == null) {
                main.getTrLogger().error("Unknown potion effect type " + suspiciousEffectTypeKey);
                continue;
            }
            try {
                int duration = Integer.parseInt(suspiciousEffectSplit[1]);
                suspiciousEffects.add(SuspiciousEffectEntry.create(suspiciousEffectType, duration));
            } catch (NumberFormatException e) {
                main.getTrLogger().error("Duration & Amplifier must be numbers " + suspiciousEffectSplit[1] + " & " + suspiciousEffectSplit[2]);
            }
        }
        return suspiciousEffects;
    }
}
