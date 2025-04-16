package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.BannerItem;
import org.bukkit.entity.Player;

public class BannerMeta extends BaseMeta {

    public void setMeta(BannerItem item, Player player) {
        super.setMeta(item, player);
        setPattern(item);
    }

    public void setPattern(BannerItem item) {
        org.bukkit.inventory.meta.BannerMeta bannerMeta = item.getItemMeta();
        if (bannerMeta == null) return;
        bannerMeta.setPatterns(item.getPatterns());
        item.getStack().setItemMeta(bannerMeta);
    }

}
