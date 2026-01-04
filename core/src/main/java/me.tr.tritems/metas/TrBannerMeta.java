package me.tr.tritems.metas;

import me.tr.tritems.items.TrBannerItem;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.block.banner.Pattern;
import org.bukkit.inventory.meta.BannerMeta;

import java.util.ArrayList;
import java.util.List;

public class TrBannerMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrBannerMeta.class.getSimpleName());
        }

        @Override
        public TrBannerMeta newInstance(TrItem item) {
            return new TrBannerMeta((TrBannerItem) item);
        }
    };

    public TrBannerMeta(TrBannerItem item) {
        super(item);
    }

    @Override
    public TrBannerItem getItem() {
        return (TrBannerItem) super.getItem();
    }


    public TrBannerMeta setPatterns(List<Pattern> patterns) {
        getItem().setPatterns(patterns);
        return this;
    }

    public TrBannerMeta addPatterns(List<Pattern> patterns) {
        getItem().addPatterns(patterns);
        return this;
    }

    public TrBannerMeta addPatterns(Pattern... patterns) {
        getItem().addPatterns(List.of(patterns));
        return this;
    }

    @Override
    public TrBannerItem apply() {
        BannerMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setPatterns(meta);

        }

        super.apply(meta);
        return getItem();
    }


    private void setPatterns(BannerMeta meta) {
        List<Pattern> patterns = meta.getPatterns();
        List<Pattern> newPatterns = getItem().getPatterns();

        if (newPatterns == null || newPatterns.isEmpty()) {
            meta.setPatterns(new ArrayList<>());
            return;
        }

        if (newPatterns.equals(patterns)) {
            return;
        }

        meta.setPatterns(newPatterns);
    }
}
