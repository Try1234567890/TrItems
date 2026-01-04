package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrEnchantedBookMeta;
import me.tr.tritems.properties.enchants.TrEnchant;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.utility.TrValidator;
import org.bukkit.Material;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TrEnchantedBookItem extends TrItem {
    private List<TrEnchant> storedEnchants = new ArrayList<>();

    @Initialize
    protected TrEnchantedBookItem() {
        super(TrItemType.ENCHANTED_BOOK);
    }

    public TrEnchantedBookItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }


    public List<TrEnchant> getStoredEnchants() {
        return storedEnchants;
    }

    public void setStoredEnchants(List<TrEnchant> enchants) {
        this.storedEnchants = enchants;
    }

    public void addEnchants(List<TrEnchant> enchants) {
        this.storedEnchants.addAll(enchants);
    }

    public void addEnchants(TrEnchant... enchants) {
        this.storedEnchants.addAll(List.of(enchants));
    }

    @Override
    public @Nullable EnchantmentStorageMeta getItemMeta() {
        return (EnchantmentStorageMeta) super.getItemMeta();
    }

    @Override
    public TrEnchantedBookMeta getMeta() {
        return (TrEnchantedBookMeta) super.getMeta();
    }

    @Override
    public String toString() {
        return super.toString() + " extends TrEnchantedBookItem{" +
                (!TrValidator.isNull(getEnchants()) ? "Enchants=" + getStoredEnchants() : "")
                + '}';
    }
}
