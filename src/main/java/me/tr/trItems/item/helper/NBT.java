package me.tr.trItems.item.helper;

import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.Nullable;

/**
 * The NBT class represents a generic NBT (Named Binary Tag) data structure.
 * It holds a compound name, a key, and a value of generic type T.
 *
 * @param <T> The type of the value stored in this NBT
 */
public class NBT<T> {
    private @Nullable String compound; // TODO: DA CAMBIARE COME SE FOSSE UN PATH. Separatore: '.'
    private NamespacedKey key;
    private T value;

    /**
     * Constructs a new NBT instance with the specified compound, key, and value.
     *
     * @param compound The compound name, which can be null
     * @param key      The NamespacedKey associated with this NBT
     * @param value    The value of type T stored in this NBT
     */
    public NBT(@Nullable String compound, NamespacedKey key, T value) {
        this.compound = compound;
        this.key = key;
        this.value = value;
    }

    /**
     * Gets the compound name of this NBT.
     *
     * @return The compound name, which can be null
     */
    public @Nullable String getCompound() {
        return compound;
    }

    /**
     * Sets the compound name for this NBT.
     *
     * @param compound The compound name to set, which can be null
     */
    public void setCompound(@Nullable String compound) {
        this.compound = compound;
    }

    /**
     * Gets the NamespacedKey associated with this NBT.
     *
     * @return The NamespacedKey of this NBT
     */
    public NamespacedKey getKey() {
        return key;
    }

    /**
     * Sets the NamespacedKey for this NBT.
     *
     * @param key The NamespacedKey to set
     */
    public void setKey(NamespacedKey key) {
        this.key = key;
    }

    /**
     * Gets the value stored in this NBT.
     *
     * @return The value of type T stored in this NBT
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets the value for this NBT.
     *
     * @param value The value of type T to set
     */
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NBT{" +
                "compound='" + compound + '\'' +
                ", key=" + key +
                ", value=" + value +
                '}';
    }
}
