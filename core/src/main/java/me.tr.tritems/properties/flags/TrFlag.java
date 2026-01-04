package me.tr.tritems.properties.flags;

import me.tr.serializer.annotations.Ignore;
import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.properties.identification.TrIdentifiable;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.properties.nbts.TrMemoryNBT;
import me.tr.tritems.registries.TrFlagRegistry;
import org.bukkit.inventory.meta.ItemMeta;

public class TrFlag implements TrIdentifiable {
    public static final TrFlag GLINT = getFlag("glint");
    public static final TrFlag UNBREAKABLE = getFlag("unbreakable");
    public @Ignore TrMemoryNBT<TrIdentifier> NBT;
    private final TrIdentifier identifier;

    @Initialize
    public TrFlag(TrIdentifier identifier) {
        this.identifier = identifier;
        this.NBT = new TrMemoryNBT<>("tr_items.flags." + identifier.toString(), identifier);
        getRegistry().register(this);
    }

    public static TrFlag getFlag(String name) {
        return getRegistry().get(name);
    }

    public static TrFlag getFlag(TrIdentifier id) {
        return getRegistry().get(id);
    }

    public static TrFlagRegistry getRegistry() {
        return TrFlagRegistry.getInstance();
    }

    @Override
    public TrIdentifier identifier() {
        return identifier;
    }

    public void set(ItemMeta meta) {
        NBT.set(meta);
    }

    public void remove(ItemMeta meta) {
        NBT.remove(meta);
    }

    public void modify(ItemMeta meta, TrFlag flag) {
        NBT.modify(meta, flag.identifier());
    }

    public boolean has(ItemMeta meta) {
        return NBT.has(meta);
    }

    public TrFlag get(ItemMeta meta) {
        return getFlag(NBT.get(meta));
    }

    @Override
    public String toString() {
        return "TrFlag{ID=\"" + identifier + "\"}";
    }

    private void finishDes() {
        this.NBT = new TrMemoryNBT<>("tr_items.flags." + identifier.toString(), identifier);
    }
}
