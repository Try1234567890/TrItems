package me.tr.tritems.properties;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.properties.color.TrColor;
import org.bukkit.FireworkEffect;

import java.util.List;

public class TrFireworkEffect {
    private List<TrColor> colors;
    private List<TrColor> fadeColors;
    private FireworkEffect.Type type;
    private boolean flicker;
    private boolean trail;

    @Initialize
    private TrFireworkEffect() {
    }


    public TrFireworkEffect(List<TrColor> colors, List<TrColor> fadeColors,
                            FireworkEffect.Type type, boolean flicker, boolean trail) {
        this.colors = colors;
        this.fadeColors = fadeColors;
        this.type = type;
        this.flicker = flicker;
        this.trail = trail;
    }

    public List<TrColor> getColors() {
        return colors;
    }

    public void setColors(List<TrColor> colors) {
        this.colors = colors;
    }

    public void addColors(List<TrColor> colors) {
        this.colors.addAll(colors);
    }

    public void addColors(TrColor... colors) {
        this.colors.addAll(List.of(colors));
    }

    public List<TrColor> getFadeColors() {
        return fadeColors;
    }

    public void setFadeColors(List<TrColor> fadeColors) {
        this.fadeColors = fadeColors;
    }

    public void addFadeColors(List<TrColor> colors) {
        this.fadeColors.addAll(colors);
    }

    public void addFadeColors(TrColor... colors) {
        this.fadeColors.addAll(List.of(colors));
    }

    public FireworkEffect.Type getType() {
        return type;
    }

    public void setType(FireworkEffect.Type type) {
        this.type = type;
    }

    public boolean isFlicker() {
        return flicker;
    }

    public void setFlicker(boolean flicker) {
        this.flicker = flicker;
    }

    public boolean isTrail() {
        return trail;
    }

    public void setTrail(boolean trail) {
        this.trail = trail;
    }

    public FireworkEffect toBukkit() {
        return FireworkEffect.builder()
                .flicker(this.flicker)
                .trail(this.trail)
                .withColor(colors.stream().map(TrColor::toColor).toList())
                .withFade(fadeColors.stream().map(TrColor::toColor).toList())
                .build();
    }
}
