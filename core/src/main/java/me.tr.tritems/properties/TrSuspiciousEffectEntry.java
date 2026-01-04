package me.tr.tritems.properties;

import io.papermc.paper.potion.SuspiciousEffectEntry;
import me.tr.serializer.annotations.Initialize;
import org.bukkit.potion.PotionEffectType;

public class TrSuspiciousEffectEntry {
    private PotionEffectType effect;
    private int duration;
    private boolean overwrite;

    @Initialize()
    private TrSuspiciousEffectEntry() {
    }

    public TrSuspiciousEffectEntry(PotionEffectType effect, int duration, boolean overwrite) {
        this.effect = effect;
        this.duration = duration;
        this.overwrite = overwrite;
    }

    public PotionEffectType getEffect() {
        return effect;
    }

    public void setEffect(PotionEffectType effect) {
        this.effect = effect;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isOverwrite() {
        return overwrite;
    }

    public void setOverwrite(boolean overwrite) {
        this.overwrite = overwrite;
    }

    public SuspiciousEffectEntry toBukkit() {
        return SuspiciousEffectEntry.create(getEffect(), getDuration());
    }
}
