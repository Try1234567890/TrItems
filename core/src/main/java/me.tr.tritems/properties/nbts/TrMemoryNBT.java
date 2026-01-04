package me.tr.tritems.properties.nbts;

import me.tr.serializer.annotations.Ignore;
import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.nbts.datatypes.TrPersistentDataType;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TrMemoryNBT<T> {
    private String compound;
    private T value;
    private @Ignore PersistentDataType<?, T> type;

    @Initialize
    private TrMemoryNBT() {
    }

    public TrMemoryNBT(String compound, T value) {
        this.compound = compound;
        this.value = value;
        this.type = TrPersistentDataType.from(value);
    }

    public static @Nullable <T> T get(ItemMeta meta, String compound, PersistentDataType<?, T> type) {
        if (meta == null) return null;

        PersistentDataContainer container = meta.getPersistentDataContainer();
        int j = -1, k;
        while ((j = compound.indexOf('.', k = j + 1)) != -1) {
            NamespacedKey key = NamespacedKey.fromString(compound.substring(k, j));
            if (key == null) return null;
            container = container.get(key, TrPersistentDataType.TAG_CONTAINER);
            if (container == null) return null;
        }

        NamespacedKey key = NamespacedKey.fromString(compound.substring(k));
        if (key != null)
            return container.get(key, type);
        return null;
    }

    public static boolean has(ItemMeta meta, String compound, PersistentDataType<?, ?> type) {
        if (meta == null) return false;

        PersistentDataContainer container = meta.getPersistentDataContainer();
        int j = -1, k;
        while ((j = compound.indexOf('.', k = j + 1)) != -1) {
            NamespacedKey key = NamespacedKey.fromString(compound.substring(k, j));
            if (key == null) return false;
            container = container.get(key, TrPersistentDataType.TAG_CONTAINER);
            if (container == null) return false;
        }

        NamespacedKey key = NamespacedKey.fromString(compound.substring(k));
        if (key != null)
            return container.has(key, type);
        return false;
    }

    public String getCompound() {
        return compound;
    }

    public void setCompound(String compound) {
        this.compound = compound;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public PersistentDataType<?, T> getType() {
        if (type == null) {
            type = TrPersistentDataType.from(value);
        }
        return type;
    }

    public void setType(PersistentDataType<?, T> type) {
        this.type = type;
    }

    public void remove(TrItem item) {
        remove(item.getItemMeta());
    }

    public void set(TrItem item) {
        set(item.getItemMeta());
    }

    public void modify(TrItem item, T newValue) {
        modify(item.getItemMeta(), newValue);
    }

    public void has(TrItem item) {
        has(item.getItemMeta());
    }

    public void get(TrItem item) {
        get(item.getItemMeta());
    }

    public void remove(ItemStack stack) {
        remove(stack.getItemMeta());
    }

    public void set(ItemStack stack) {
        set(stack.getItemMeta());
    }

    public void modify(ItemStack stack, T newValue) {
        modify(stack.getItemMeta(), newValue);
    }

    public @Nullable T get(ItemStack stack) {
        return get(stack.getItemMeta());
    }

    public boolean has(ItemStack stack) {
        return has(stack.getItemMeta());
    }

    public void remove(ItemMeta meta) {
        if (meta == null) return;

        String compound = getCompound();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        int j = -1, k;
        while ((j = compound.indexOf('.', k = j + 1)) != -1) {
            NamespacedKey key = NamespacedKey.fromString(compound.substring(k, j));
            if (key == null) return;
            container = container.get(key, TrPersistentDataType.TAG_CONTAINER);
            if (container == null) return;
        }

        NamespacedKey key = NamespacedKey.fromString(compound.substring(k));
        if (key != null)
            container.remove(key);
    }

    public void set(ItemMeta meta) {
        if (meta == null) return;

        String compound = getCompound();
        PersistentDataContainer root = meta.getPersistentDataContainer();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        PersistentDataAdapterContext context = container.getAdapterContext();
        List<PersistentDataContainer> containers = new ArrayList<>();
        List<NamespacedKey> keys = new ArrayList<>();
        containers.add(root);

        int j = -1, k;
        while ((j = compound.indexOf('.', k = j + 1)) != -1) {
            NamespacedKey key = NamespacedKey.fromString(compound.substring(k, j));
            if (key == null) return;

            PersistentDataContainer sub = container.get(key, TrPersistentDataType.TAG_CONTAINER);
            if (sub == null) {
                sub = context.newPersistentDataContainer();
                container.set(key, TrPersistentDataType.TAG_CONTAINER, sub);
            }
            container = sub;
            containers.add(container);
            keys.add(key);
        }

        NamespacedKey key = NamespacedKey.fromString(compound.substring(k));
        if (key != null)
            container.set(key, getType(), getValue());

        for (int i = containers.size() - 2; i >= 0; i--) {
            containers.get(i).set(keys.get(i), TrPersistentDataType.TAG_CONTAINER, containers.get(i + 1));
        }
    }

    public void modify(ItemMeta item, T newValue) {
        this.value = newValue;
        set(item);
    }

    public @Nullable T get(ItemMeta meta) {
        return get(meta, getCompound(), getType());
    }

    public boolean has(ItemMeta meta) {
        return has(meta, getCompound(), getType());
    }

    @Override
    public String toString() {
        return "TrMemoryNBT{Compound=" + compound + '\"' + ", Value=" + value + ", Type=" + type + '}';
    }

    private void finishDes() {
        this.type = TrPersistentDataType.from(value);
    }
}
























