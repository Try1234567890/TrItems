package me.tr.tritems.properties.flags;

import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.inventory.meta.ItemMeta;

public class TrUnbreakable extends TrFlag {

    public TrUnbreakable() {
        super(new TrIdentifier("minecraft", "unbreakable"));
    }

    @Override
    public void set(ItemMeta meta) {
        meta.setUnbreakable(true);
    }

    @Override
    public void remove(ItemMeta meta) {
        meta.setUnbreakable(false);
    }

    @Override
    public void modify(ItemMeta meta, TrFlag flag) {
        meta.setUnbreakable(!meta.getEnchantmentGlintOverride());
    }

    @Override
    public boolean has(ItemMeta meta) {
        return meta.isUnbreakable();
    }
}
