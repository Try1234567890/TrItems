package me.tr.trItems.item.loaders.loader;

import io.papermc.paper.potion.SuspiciousEffectEntry;
import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.ItemManager;
import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.item.items.TrSuspiciousStewItem;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class TrSuspiciousStewLoader extends TrBaseLoader {

    public TrSuspiciousStewItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        List<SuspiciousEffectEntry> suspiciousEffects = getSuspiciousEffects(itemSection);
        return new TrSuspiciousStewItem(baseItem, suspiciousEffects);
    }

    public List<SuspiciousEffectEntry> getSuspiciousEffects(Section itemSection) {
        final List<SuspiciousEffectEntry> suspiciousEffects = new ArrayList<>();
        List<String> suspiciousEffectsStr = itemSection.getStringList(" ");
        for (String suspiciousEffect : suspiciousEffectsStr) {
            String[] suspiciousEffectSplit = suspiciousEffect.split(" ");
            if (suspiciousEffectSplit.length < 1) {
                main.getLogger().error("SuspiciousEffect " + suspiciousEffect + " not contains enough information.");
                continue;
            }
            NamespacedKey suspiciousEffectTypeKey = ItemManager.getInstance().parseNamespacedKey(suspiciousEffectSplit[0]);
            PotionEffectType suspiciousEffectType = Registry.POTION_EFFECT_TYPE.get(suspiciousEffectTypeKey);
            if (suspiciousEffectType == null) {
                main.getLogger().error("Unknown potion effect type " + suspiciousEffectTypeKey);
                continue;
            }
            try {
                int duration = Integer.parseInt(suspiciousEffectSplit[1]);
                suspiciousEffects.add(SuspiciousEffectEntry.create(suspiciousEffectType, duration));
            } catch (NumberFormatException e) {
                main.getLogger().error("Duration & Amplifier must be numbers " + suspiciousEffectSplit[1] + " & " + suspiciousEffectSplit[2]);
            }
        }
        return suspiciousEffects;
    }
}
