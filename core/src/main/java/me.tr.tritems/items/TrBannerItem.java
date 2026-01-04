package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrBannerMeta;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.utility.TrValidator;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.inventory.meta.BannerMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TrBannerItem extends TrItem {
    private List<Pattern> patterns = new ArrayList<>();

    @Initialize
    protected TrBannerItem() {
        super(TrItemType.BANNER);
    }

    public TrBannerItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    public List<Pattern> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<Pattern> patterns) {
        this.patterns = patterns;
    }

    public void addPatterns(List<Pattern> patterns) {
        this.patterns.addAll(patterns);
    }

    public void addPatterns(Pattern... patterns) {
        this.patterns.addAll(List.of(patterns));
    }

    @Override
    public @Nullable BannerMeta getItemMeta() {
        return (BannerMeta) super.getItemMeta();
    }

    @Override
    public TrBannerMeta getMeta() {
        return (TrBannerMeta) super.getMeta();
    }

    @Override
    public String toString() {
        return super.toString() + " extends TrBannerTrim{" +
                (!TrValidator.isNull(getPatterns()) ? "Patterns=" + getPatterns().stream().map(Pattern::toString) : "")
                + '}';
    }
}
