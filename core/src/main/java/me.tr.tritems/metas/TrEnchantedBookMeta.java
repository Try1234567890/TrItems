package me.tr.tritems.metas;

import me.tr.tritems.items.TrEnchantedBookItem;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.enchants.TrEnchant;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.List;

public class TrEnchantedBookMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrEnchantedBookMeta.class.getSimpleName());
        }

        @Override
        public TrEnchantedBookMeta newInstance(TrItem item) {
            return new TrEnchantedBookMeta((TrEnchantedBookItem) item);
        }
    };

    public TrEnchantedBookMeta(TrEnchantedBookItem item) {
        super(item);
    }

    @Override
    public TrEnchantedBookItem getItem() {
        return (TrEnchantedBookItem) super.getItem();
    }

    public TrEnchantedBookMeta setEnchants(List<TrEnchant> enchants) {
        getItem().setStoredEnchants(enchants);
        return this;
    }

    public TrEnchantedBookMeta addEnchants(List<TrEnchant> enchants) {
        getItem().addEnchants(enchants);
        return this;
    }

    public TrEnchantedBookMeta addEnchants(TrEnchant... enchants) {
        getItem().addEnchants(List.of(enchants));
        return this;
    }

    @Override
    public TrEnchantedBookItem apply() {
        EnchantmentStorageMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setEnchants(meta);

        }

        super.apply(meta);
        return getItem();
    }


    private void setEnchants(EnchantmentStorageMeta meta) {
        meta.removeEnchantments();
        List<TrEnchant> newEnchants = getItem().getStoredEnchants();


        if (newEnchants == null || newEnchants.isEmpty()) {
            // Enchants already removed.
            return;
        }

        for (TrEnchant enchant : newEnchants) {
            if (enchant == null)
                continue;
            enchant.set(meta);
        }
    }
}
