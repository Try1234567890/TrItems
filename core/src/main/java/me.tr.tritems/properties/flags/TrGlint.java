package me.tr.tritems.properties.flags;

import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.inventory.meta.ItemMeta;

public class TrGlint extends TrFlag {

    public TrGlint() {
        super(new TrIdentifier("minecraft", "glint"));
    }

    @Override
    public void set(ItemMeta meta) {
        meta.setEnchantmentGlintOverride(true);
    }

    @Override
    public void remove(ItemMeta meta) {
        meta.setEnchantmentGlintOverride(false);
    }

    @Override
    public void modify(ItemMeta meta, TrFlag flag) {
        meta.setEnchantmentGlintOverride(!meta.hasEnchantmentGlintOverride());
    }

    @Override
    public boolean has(ItemMeta meta) {
        return meta.hasEnchantmentGlintOverride();
    }
}
