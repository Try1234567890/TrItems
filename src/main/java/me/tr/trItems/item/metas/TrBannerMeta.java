package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.TrBannerItem;
import org.bukkit.block.banner.Pattern;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.BannerMeta;

import java.util.List;

public class TrBannerMeta extends TrBaseMeta {

    private TrBannerMeta() {
    }

    public TrBannerMeta(TrBannerItem item) {
        super(item);
    }

    @Override
    public TrBannerItem getItem() {
        return (TrBannerItem) super.getItem();
    }

    public void setMeta(Player player) {
        super.setMeta(player);
        setPatterns();
    }

    public void setPatterns() {
        BannerMeta bannerMeta = getItem().getItemMeta();
        if (bannerMeta == null) return;
        bannerMeta.setPatterns(getItem().getPatterns());
        getItem().getStack().setItemMeta(bannerMeta);
    }

    public void editPatterns(List<Pattern> patterns) {
        getItem().setPatterns(patterns);
        setPatterns();
    }

}
