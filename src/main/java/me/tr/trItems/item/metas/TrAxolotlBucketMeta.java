package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.TrAxolotlBucketItem;
import org.bukkit.entity.Axolotl;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.AxolotlBucketMeta;

public class TrAxolotlBucketMeta extends TrBaseMeta {

    private TrAxolotlBucketMeta() {
    }

    public TrAxolotlBucketMeta(TrAxolotlBucketItem item) {
        super(item);
    }

    @Override
    public TrAxolotlBucketItem getItem() {
        return (TrAxolotlBucketItem) super.getItem();
    }

    public void setMeta(Player player) {
        super.setMeta(player);
        setAxolotlVariant();
    }

    public void setAxolotlVariant() {
        AxolotlBucketMeta axolotlBucketMeta = getItem().getItemMeta();
        if (axolotlBucketMeta == null) return;
        Axolotl.Variant variant = getItem().getVariant();
        if (variant != null) {
            axolotlBucketMeta.setVariant(variant);
            getItem().getStack().setItemMeta(axolotlBucketMeta);
        }
    }

    public void editAxolotlVariant(Axolotl.Variant variant) {
        getItem().setVariant(variant);
        setAxolotlVariant();
    }

}
