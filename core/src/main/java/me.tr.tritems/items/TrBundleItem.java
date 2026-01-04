package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrBundleMeta;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.utility.TrValidator;
import org.bukkit.Material;
import org.bukkit.inventory.meta.BundleMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TrBundleItem extends TrItem {
    private List<TrItem> items = new ArrayList<>();

    @Initialize
    protected TrBundleItem() {
        super(TrItemType.BUNDLE);
    }

    public TrBundleItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    public List<TrItem> getItems() {
        return items;
    }

    public void setItems(List<TrItem> items) {
        this.items = items;
    }

    public void addItems(List<TrItem> items) {
        this.items.addAll(items);
    }

    public void addItems(TrItem... items) {
        this.items.addAll(List.of(items));
    }

    @Override
    public @Nullable BundleMeta getItemMeta() {
        return (BundleMeta) super.getItemMeta();
    }

    @Override
    public TrBundleMeta getMeta() {
        return (TrBundleMeta) super.getMeta();
    }

    @Override
    public String toString() {
        return super.toString() + " extends TrBannerTrim{" +
                (!TrValidator.isNull(getItems()) ? "Items=" + getItems() : "")
                + '}';
    }
}
