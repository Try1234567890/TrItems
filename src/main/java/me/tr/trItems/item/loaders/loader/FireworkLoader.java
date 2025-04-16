package me.tr.trItems.item.loaders.loader;

import me.tr.configuration.Section;
import me.tr.trItems.item.items.BaseItem;
import me.tr.trItems.item.items.FireworkItem;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class FireworkLoader extends BaseLoader {

    public FireworkItem load(Plugin plugin, Section itemSection) {
        BaseItem baseItem = super.load(plugin, itemSection);
        int power = getPower(itemSection);
        List<FireworkEffect> effects = getFireworkEffect(itemSection);
        return new FireworkItem(baseItem, power, effects);
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
        return main.getItemLoaderManager().convertColors(colorsStr);
    }

    public List<Color> getFadeColors(Section itemSection) {
        List<String> colorsStr = itemSection.getStringList("FadeColors");
        return main.getItemLoaderManager().convertColors(colorsStr);
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
