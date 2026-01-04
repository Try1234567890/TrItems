package me.tr.tritems.metas;

import me.tr.tritems.items.TrBundleItem;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BundleMeta;

import java.util.List;
import java.util.Objects;

public class TrBundleMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrBundleMeta.class.getSimpleName());
        }

        @Override
        public TrBundleMeta newInstance(TrItem item) {
            return new TrBundleMeta((TrBundleItem) item);
        }
    };

    public TrBundleMeta(TrBundleItem item) {
        super(item);
    }

    @Override
    public TrBundleItem getItem() {
        return (TrBundleItem) super.getItem();
    }

    public TrBundleMeta setItems(List<TrItem> items) {
        getItem().setItems(items);
        return this;
    }

    public TrBundleMeta addItems(List<TrItem> items) {
        getItem().addItems(items);
        return this;
    }

    public TrBundleMeta addItems(TrItem... items) {
        getItem().addItems(List.of(items));
        return this;
    }

    @Override
    public TrBundleItem apply() {
        BundleMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setItems(meta);

        }


        super.apply(meta);
        return getItem();
    }

    private void setItems(BundleMeta meta) {
        List<ItemStack> items = meta.getItems();
        List<TrItem> newItems = getItem().getItems();


        if (newItems == null || newItems.isEmpty()) {
            meta.setItems(null);
            return;
        }

        List<ItemStack> newStacks = newItems.stream()
                .map(TrItem::toStack)
                .filter(Objects::nonNull)
                .toList();

        if (newStacks.equals(items))
            return;

        meta.setItems(newStacks);
    }
}
