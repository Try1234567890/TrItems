package me.tr.trItems.item.helper;

import me.tr.trItems.item.ItemManager;
import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.utilities.Util;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The NBT class represents a generic NBT (Named Binary Tag) data structure.
 * It holds a compound name, a key, and a value of generic type T.
 *
 * @param <T> The type of the value stored in this NBT
 */
public class TrNBT<T> {
    private @Nullable String compound;
    private NamespacedKey key;
    private T value;

    /**
     * Constructs a new NBT instance with the specified compound, key, and value.
     *
     * @param compound The compound name, which can be null
     * @param key      The NamespacedKey associated with this NBT
     * @param value    The value of type T stored in this NBT
     */
    public TrNBT(@Nullable String compound, NamespacedKey key, T value) {
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

    public Class<?> getValueClass() {
        return value.getClass();
    }

    /**
     * Set value and create all containers specified at compound
     *
     * @param item Item to set value into.
     */
    public void set(TrBaseItem item) {
        set(item.getStack());
    }

    /**
     * Set value and create all containers specified at compound
     *
     * @param item Item to set value into.
     */
    public void set(ItemStack item) {
        KeyedPersistentDataContainer container = createContainers(item);
        if (container == null) return;
        if (getValueClass().isInstance(int.class)) {
            setInt(item, (int) value);
        } else if (getValueClass().isInstance(double.class)) {
            setDouble(item, getAsDouble());
        } else if (getValueClass().isInstance(byte.class)) {
            setByte(item, getAsByte());
        } else if (getValueClass().isInstance(short.class)) {
            setShort(item, getAsShort());
        } else if (getValueClass().isInstance(long.class)) {
            setLong(item, getAsLong());
        } else if (getValueClass().isInstance(float.class)) {
            setFloat(item, getAsFloat());
        } else if (getValueClass().isInstance(boolean.class)) {
            setBoolean(item, getAsBoolean());
        } else if (getValueClass().isInstance(byte[].class)) {
            setByteArray(item, getAsByteArray());
        } else if (getValueClass().isInstance(int[].class)) {
            setIntArray(item, getAsIntArray());
        } else if (getValueClass().isInstance(long[].class)) {
            setLongArray(item, getAsLongArray());
        } else {
            setString(item, getAsString());
        }
    }

    /**
     * Get the last sub-container contained in the compound path.
     *
     * @param item Item to search sub-container into.
     * @return A new instance of {@link KeyedPersistentDataContainer} that contains the last
     * sub-container found and the {@link NamespacedKey} to search.
     */
    private KeyedPersistentDataContainer getLastContainerInCompound(ItemStack item) {
        if (item == null || !item.hasItemMeta() || Util.isNull(compound)) return null;
        int currentSeparatorIndex = -1, nextChar;
        PersistentDataContainer container = item.getItemMeta().getPersistentDataContainer();
        while ((currentSeparatorIndex = compound.indexOf('.', nextChar = currentSeparatorIndex + 1)) != -1) {
            String subContainerKey = compound.substring(nextChar, currentSeparatorIndex);
            PersistentDataContainer subContainer = container.get(ItemManager.getInstance().parseNamespacedKey(subContainerKey), PersistentDataType.TAG_CONTAINER);
            if (subContainer != null) {
                container = subContainer;
            }
        }
        return new KeyedPersistentDataContainer(container, compound.substring(nextChar));
    }

    /**
     * Create container and sub-containers specified in compound.
     *
     * @param item Item to create container and sub-containers into.
     * @return A new instance of {@link KeyedPersistentDataContainer} that contains the last
     * sub-container found and the {@link NamespacedKey} to create.
     */
    public KeyedPersistentDataContainer createContainers(ItemStack item) {
        if (item == null || !item.hasItemMeta() || Util.isNull(compound)) return null;
        PersistentDataContainer container = item.getItemMeta().getPersistentDataContainer();
        if (compound != null) {
            int currentSeparatorIndex = -1, nextChar;
            while ((currentSeparatorIndex = compound.indexOf('.', nextChar = currentSeparatorIndex + 1)) != -1) {
                String subContainerKey = compound.substring(nextChar, currentSeparatorIndex);
                PersistentDataContainer subContainer = container.get(ItemManager.getInstance().parseNamespacedKey(subContainerKey), PersistentDataType.TAG_CONTAINER);
                if (subContainer == null) {
                    container = container.getAdapterContext().newPersistentDataContainer();
                    container.set(ItemManager.getInstance().parseNamespacedKey(subContainerKey), PersistentDataType.TAG_CONTAINER, container);
                }
            }
            return new KeyedPersistentDataContainer(container, compound.substring(nextChar));
        }
        return null;
    }

    /**
     * @return The current Object#toString().
     */
    public String getAsString() {
        return value.toString();
    }

    /**
     * Get the compound target value as string.
     *
     * @param item Item to search value into.
     * @return The string if found, otherwise null.
     */
    public String getString(ItemStack item) {
        KeyedPersistentDataContainer container = getLastContainerInCompound(item);
        if (container == null) return null;
        return container.getContainer().get(container.getKey(), PersistentDataType.STRING);
    }

    /**
     * Set the value and create all containers specified into compound.
     *
     * @param item  Item to search value into
     * @param value The String value to set.
     */
    public void setString(ItemStack item, String value) {
        KeyedPersistentDataContainer container = createContainers(item);
        if (container == null) return;
        container.getContainer().set(container.getKey(), PersistentDataType.STRING, value);
    }


    /**
     * @return If the object is a number get integer value, otherwise try to parse the integer, otherwise 0.
     */
    public Integer getAsInt() {
        if (value instanceof Number number) {
            return number.intValue();
        }
        try {
            return Integer.parseInt(value.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * Get the compound target value as integer
     *
     * @param item Item to search value into
     * @return The integer if found, otherwise -1
     */
    public Integer getInt(ItemStack item) {
        KeyedPersistentDataContainer container = getLastContainerInCompound(item);
        if (container == null) return -1;
        return container.getContainer().get(container.getKey(), PersistentDataType.INTEGER);
    }

    /**
     * Set the value and create all containers specified into compound.
     *
     * @param item  Item to search value into
     * @param value The integer value to set.
     */
    public void setInt(ItemStack item, int value) {
        KeyedPersistentDataContainer container = createContainers(item);
        if (container == null) return;
        container.getContainer().set(container.getKey(), PersistentDataType.INTEGER, value);
    }

    /**
     * @return If the object is a number get double value, otherwise try to parse the double, otherwise 0.0.
     */
    public double getAsDouble() {
        if (value instanceof Number number) {
            return number.doubleValue();
        }
        try {
            return Double.parseDouble(value.toString());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    /**
     * Get the compound target value as double
     *
     * @param item Item to search value into
     * @return The double if found, otherwise -1.0
     */
    public Double getDouble(ItemStack item) {
        KeyedPersistentDataContainer container = getLastContainerInCompound(item);
        if (container == null) return -1.0;
        return container.getContainer().get(container.getKey(), PersistentDataType.DOUBLE);
    }

    /**
     * Set the value and create all containers specified into compound.
     *
     * @param item  Item to search value into
     * @param value The double value to set.
     */
    public void setDouble(ItemStack item, double value) {
        KeyedPersistentDataContainer container = createContainers(item);
        if (container == null) return;
        container.getContainer().set(container.getKey(), PersistentDataType.DOUBLE, value);
    }

    /**
     * @return If the object is a number get byte value, otherwise try to parse the byte, otherwise 0.
     */
    public byte getAsByte() {
        if (value instanceof Number number) {
            return number.byteValue();
        }
        try {
            return Byte.parseByte(value.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * Get the compound target value as byte
     *
     * @param item Item to search value into
     * @return The byte if found, otherwise -1
     */
    public Byte getByte(ItemStack item) {
        KeyedPersistentDataContainer container = getLastContainerInCompound(item);
        if (container == null) return -1;
        return container.getContainer().get(container.getKey(), PersistentDataType.BYTE);
    }

    /**
     * Set the value and create all containers specified into compound.
     *
     * @param item  Item to search value into
     * @param value The byte value to set.
     */
    public void setByte(ItemStack item, byte value) {
        KeyedPersistentDataContainer container = createContainers(item);
        if (container == null) return;
        container.getContainer().set(container.getKey(), PersistentDataType.BYTE, value);
    }

    /**
     * @return If the object is a number get short value, otherwise try to parse the short, otherwise 0.
     */
    public short getAsShort() {
        if (value instanceof Number number) {
            return number.shortValue();
        }
        try {
            return Short.parseShort(value.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * Get the compound target value as short
     *
     * @param item Item to search value into
     * @return The short if found, otherwise -1
     */
    public Short getShort(ItemStack item) {
        KeyedPersistentDataContainer container = getLastContainerInCompound(item);
        if (container == null) return -1;
        return container.getContainer().get(container.getKey(), PersistentDataType.SHORT);
    }

    /**
     * Set the value and create all containers specified into compound.
     *
     * @param item  Item to search value into
     * @param value The short value to set.
     */
    public void setShort(ItemStack item, short value) {
        KeyedPersistentDataContainer container = createContainers(item);
        if (container == null) return;
        container.getContainer().set(container.getKey(), PersistentDataType.SHORT, value);
    }

    /**
     * @return If the object is a number get long value, otherwise try to parse the long, otherwise 0.
     */
    public long getAsLong() {
        if (value instanceof Number number) {
            return number.longValue();
        }
        try {
            return Long.parseLong(value.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * Get the compound target value as long
     *
     * @param item Item to search value into
     * @return The long if found, otherwise -1
     */
    public Long getLong(ItemStack item) {
        KeyedPersistentDataContainer container = getLastContainerInCompound(item);
        if (container == null) return -1L;
        return container.getContainer().get(container.getKey(), PersistentDataType.LONG);
    }

    /**
     * Set the value and create all containers specified into compound.
     *
     * @param item  Item to search value into
     * @param value The long value to set.
     */
    public void setLong(ItemStack item, long value) {
        KeyedPersistentDataContainer container = createContainers(item);
        if (container == null) return;
        container.getContainer().set(container.getKey(), PersistentDataType.LONG, value);
    }

    /**
     * @return If the object is a number get float value, otherwise try to parse the float, otherwise 0.
     */
    public float getAsFloat() {
        if (value instanceof Number number) {
            return number.floatValue();
        }
        try {
            return Float.parseFloat(value.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * Get the compound target value as float
     *
     * @param item Item to search value into
     * @return The float if found, otherwise -1
     */
    public Float getFloat(ItemStack item) {
        KeyedPersistentDataContainer container = getLastContainerInCompound(item);
        if (container == null) return -1f;
        return container.getContainer().get(container.getKey(), PersistentDataType.FLOAT);
    }

    /**
     * Set the value and create all containers specified into compound.
     *
     * @param item  Item to search value into
     * @param value The float value to set.
     */
    public void setFloat(ItemStack item, float value) {
        KeyedPersistentDataContainer container = createContainers(item);
        if (container == null) return;
        container.getContainer().set(container.getKey(), PersistentDataType.FLOAT, value);
    }

    /**
     * @return If the object is a boolean return it, otherwise try to parse the boolean, otherwise false.
     */
    public boolean getAsBoolean() {
        if (value instanceof Boolean bool) {
            return bool;
        }
        return Boolean.parseBoolean(value.toString());
    }

    /**
     * Get the compound target value as boolean
     *
     * @param item Item to search value into
     * @return The boolean if found, otherwise false
     */
    public Boolean getBoolean(ItemStack item) {
        KeyedPersistentDataContainer container = getLastContainerInCompound(item);
        if (container == null) return false;
        return container.getContainer().get(container.getKey(), PersistentDataType.BOOLEAN);
    }

    /**
     * Set the value and create all containers specified into compound.
     *
     * @param item  Item to search value into
     * @param value The boolean value to set.
     */
    public void setBoolean(ItemStack item, boolean value) {
        KeyedPersistentDataContainer container = createContainers(item);
        if (container == null) return;
        container.getContainer().set(container.getKey(), PersistentDataType.BOOLEAN, value);
    }

    /**
     * @return If the object is a number array return it, otherwise an empty array.
     */
    public byte[] getAsByteArray() {
        final List<Byte> bytes = new ArrayList<>();
        if (value instanceof Collection<?> coll) {
            for (Object o : coll) {
                if (o instanceof Number number) {
                    bytes.add(number.byteValue());
                } else if (o instanceof String) {
                    try {
                        bytes.add(Byte.parseByte(o.toString()));
                    } catch (NumberFormatException _) {
                    }
                }
            }
        }
        byte[] result = new byte[bytes.size()];
        for (int i = 0; i < bytes.size(); i++) {
            result[i] = bytes.get(i);
        }
        return result;
    }

    /**
     * Get the compound target value as a byte array
     *
     * @param item Item to search value into
     * @return The byte array if found, otherwise null
     */
    public byte[] getByteArray(ItemStack item) {
        KeyedPersistentDataContainer container = getLastContainerInCompound(item);
        if (container == null) return null;
        return container.getContainer().get(container.getKey(), PersistentDataType.BYTE_ARRAY);
    }

    /**
     * Set the value and create all containers specified into compound.
     *
     * @param item  Item to search value into
     * @param value The byte array value to set.
     */
    public void setByteArray(ItemStack item, byte[] value) {
        KeyedPersistentDataContainer container = createContainers(item);
        if (container == null) return;
        container.getContainer().set(container.getKey(), PersistentDataType.BYTE_ARRAY, value);
    }

    /**
     * @return If the object is a number array return it, otherwise an empty array.
     */
    public int[] getAsIntArray() {
        final List<Integer> integers = new ArrayList<>();
        if (value instanceof Collection<?> coll) {
            for (Object o : coll) {
                if (o instanceof Number number) {
                    integers.add(number.intValue());
                } else if (o instanceof String) {
                    try {
                        integers.add(Integer.parseInt(o.toString()));
                    } catch (NumberFormatException _) {
                    }
                }
            }
        }
        int[] result = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            result[i] = integers.get(i);
        }
        return result;
    }

    /**
     * Get the compound target value as an integer array
     *
     * @param item Item to search value into
     * @return The integer array if found, otherwise null
     */
    public int[] getIntArray(ItemStack item) {
        KeyedPersistentDataContainer container = getLastContainerInCompound(item);
        if (container == null) return null;
        return container.getContainer().get(container.getKey(), PersistentDataType.INTEGER_ARRAY);
    }

    /**
     * Set the value and create all containers specified into compound.
     *
     * @param item  Item to search value into
     * @param value The int array value to set.
     */
    public void setIntArray(ItemStack item, int[] value) {
        KeyedPersistentDataContainer container = createContainers(item);
        if (container == null) return;
        container.getContainer().set(container.getKey(), PersistentDataType.INTEGER_ARRAY, value);
    }

    /**
     * @return If the object is a number array return it, otherwise an empty array.
     */
    public long[] getAsLongArray() {
        final List<Long> longs = new ArrayList<>();
        if (value instanceof Collection<?> coll) {
            for (Object o : coll) {
                if (o instanceof Number number) {
                    longs.add(number.longValue());
                } else if (o instanceof String) {
                    try {
                        longs.add(Long.parseLong(o.toString()));
                    } catch (NumberFormatException _) {
                    }
                }
            }
        }
        long[] result = new long[longs.size()];
        for (int i = 0; i < longs.size(); i++) {
            result[i] = longs.get(i);
        }
        return result;
    }

    /**
     * Get the compound target value as a long array
     *
     * @param item Item to search value into
     * @return The long array if found, otherwise null
     */
    public long[] getLongArray(ItemStack item) {
        KeyedPersistentDataContainer container = getLastContainerInCompound(item);
        if (container == null) return null;
        return container.getContainer().get(container.getKey(), PersistentDataType.LONG_ARRAY);
    }

    /**
     * Set the value and create all containers specified into compound.
     *
     * @param item  Item to search value into
     * @param value The long array value to set.
     */
    public void setLongArray(ItemStack item, long[] value) {
        KeyedPersistentDataContainer container = createContainers(item);
        if (container == null) return;
        container.getContainer().set(container.getKey(), PersistentDataType.LONG_ARRAY, value);
    }


    @Override
    public String toString() {
        return "NBT{" +
                "compound='" + compound + '\'' +
                ", key=" + key +
                ", value=" + value +
                '}';
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    public class KeyedPersistentDataContainer {
        private final PersistentDataContainer container;
        private final NamespacedKey key;

        public KeyedPersistentDataContainer(PersistentDataContainer container, NamespacedKey key) {
            this.container = container;
            this.key = key;
        }

        public KeyedPersistentDataContainer(PersistentDataContainer container, String key) {
            this.container = container;
            this.key = ItemManager.getInstance().parseNamespacedKey(key);
        }

        public PersistentDataContainer getContainer() {
            return container;
        }

        public NamespacedKey getKey() {
            return key;
        }
    }
}
