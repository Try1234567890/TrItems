package me.tr.trItems.item.loaders.loader;

import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.item.items.TrFireworkItem;
import me.tr.trItems.utilities.ColorUtil;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class TrFireworkLoader extends TrBaseLoader {

    public TrFireworkItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        int power = getPower(itemSection);
        List<FireworkEffect> effects = getFireworkEffect(itemSection);
        return new TrFireworkItem(baseItem, power, effects);
    }

    public int getPower(Section itemSection) {
        return itemSection.getInt("Power");
    }

    public List<FireworkEffect> getFireworkEffect(Section itemSection) {
        Section fireworkEffectsSection = itemSection.getSection("FireworkEffects");
        List<FireworkEffect> effects = new ArrayList<>();
        for (String fireworkEffect : fireworkEffectsSection.getKeys(false)) {
            Section section = fireworkEffectsSection.getSection(fireworkEffect);
            boolean flicker = section.getBoolean("Flicker");
            boolean trail = section.getBoolean("Trail");
            List<Color> colors = getColors(section);
            List<Color> fadeColors = getFadeColors(section);
            FireworkEffect.Type type = getFireworkType(section);
            effects.add(FireworkEffect.builder().flicker(flicker).trail(trail).withColor(colors).withFade(fadeColors).with(type).build());
        }
        return effects;
    }

    public List<Color> getColors(Section itemSection) {
        List<String> colorsStr = itemSection.getStringList("Colors");
        return ColorUtil.parseColors(colorsStr);
    }

    public List<Color> getFadeColors(Section itemSection) {
        List<String> colorsStr = itemSection.getStringList("FadeColors");
        return ColorUtil.parseColors(colorsStr);
    }

    public FireworkEffect.Type getFireworkType(Section itemSection) {
        String type = itemSection.getString("FireworkType");
        try {
            return FireworkEffect.Type.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The FireworkType " + type + " is not valid.");
        }
    }
}
