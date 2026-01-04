package me.tr.tritems.metas;

import me.tr.tritems.items.TrCrossbowItem;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;

import java.util.List;
import java.util.Objects;

public class TrCrossbowMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrCrossbowMeta.class.getSimpleName());
        }

        @Override
        public TrCrossbowMeta newInstance(TrItem item) {
            return new TrCrossbowMeta((TrCrossbowItem) item);
        }
    };

    public TrCrossbowMeta(TrCrossbowItem item) {
        super(item);
    }

    @Override
    public TrCrossbowItem getItem() {
        return (TrCrossbowItem) super.getItem();
    }

    public TrCrossbowMeta setProjectiles(List<TrItem> projectiles) {
        getItem().setChargedProjectiles(projectiles);
        return this;
    }

    @Override
    public TrCrossbowItem apply() {
        CrossbowMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setProjectiles(meta);

        }

        super.apply(meta);
        return getItem();
    }

    private void setProjectiles(CrossbowMeta meta) {
        List<ItemStack> items = meta.getChargedProjectiles();
        List<TrItem> newItems = getItem().getChargedProjectiles();


        if (newItems == null || newItems.isEmpty()) {
            meta.setChargedProjectiles(null);
            return;
        }

        List<ItemStack> newStacks = newItems.stream()
                .map(TrItem::toStack)
                .filter(Objects::nonNull)
                .toList();

        if (newStacks.equals(items))
            return;

        meta.setChargedProjectiles(newStacks);
    }
}
