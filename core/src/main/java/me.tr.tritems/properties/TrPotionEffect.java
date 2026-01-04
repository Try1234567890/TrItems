package me.tr.tritems.properties;

import me.tr.serializer.annotations.Initialize;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class TrPotionEffect {
    private int amplifier;
    private int duration;
    private PotionEffectType type;
    private boolean ambient;
    private boolean particles;
    private boolean icon;
    private boolean overwrite;

    @Initialize()
    private TrPotionEffect() {
    }
    
    public TrPotionEffect(@NotNull PotionEffectType type, int duration, int amplifier, boolean ambient, boolean particles, boolean icon, boolean overwrite) {
        this.amplifier = amplifier;
        this.duration = duration;
        this.type = type;
        this.ambient = ambient;
        this.particles = particles;
        this.icon = icon;
        this.overwrite = overwrite;
    }

    public int getAmplifier() {
        return amplifier;
    }

    public void setAmplifier(int amplifier) {
        this.amplifier = amplifier;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public PotionEffectType getType() {
        return type;
    }

    public void setType(PotionEffectType type) {
        this.type = type;
    }

    public boolean isAmbient() {
        return ambient;
    }

    public void setAmbient(boolean ambient) {
        this.ambient = ambient;
    }

    public boolean isParticles() {
        return particles;
    }

    public void setParticles(boolean particles) {
        this.particles = particles;
    }

    public boolean isIcon() {
        return icon;
    }

    public void setIcon(boolean icon) {
        this.icon = icon;
    }

    public PotionEffect toBukkit() {
        return new PotionEffect(getType(), getDuration(), getAmplifier(), isAmbient(), isParticles(), isIcon());
    }

    public boolean isOverwrite() {
        return overwrite;
    }

    public void setOverwrite(boolean overwrite) {
        this.overwrite = overwrite;
    }
}
