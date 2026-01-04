package me.tr.tritems.properties.nbts.datatypes;

import me.tr.tritems.properties.identification.TrIdentifiable;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.properties.identification.TrReusableIdentifier;
import me.tr.tritems.registries.TrPersistentDataTypeRegistry;
import me.tr.tritems.utility.TrValidator;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

public interface TrPersistentDataType<P, C> extends PersistentDataType<P, C>, TrIdentifiable {

    TrPersistentDataType<String, TrIdentifier> UID = new TrPersistentUID();
    TrPersistentDataType<Byte, Boolean> BOOLEAN = new TrBooleanPersistentDataType();
    TrPersistentDataType<Byte, Byte> BYTE = new TrPrimitivePersistentDataType<>(Byte.class);
    TrPersistentDataType<Short, Short> SHORT = new TrPrimitivePersistentDataType<>(Short.class);
    TrPersistentDataType<Integer, Integer> INTEGER = new TrPrimitivePersistentDataType<>(Integer.class);
    TrPersistentDataType<Long, Long> LONG = new TrPrimitivePersistentDataType<>(Long.class);
    TrPersistentDataType<Float, Float> FLOAT = new TrPrimitivePersistentDataType<>(Float.class);
    TrPersistentDataType<Double, Double> DOUBLE = new TrPrimitivePersistentDataType<>(Double.class);
    TrPersistentDataType<String, String> STRING = new TrPrimitivePersistentDataType<>(String.class);
    TrPersistentDataType<byte[], byte[]> BYTE_ARRAY = new TrPrimitivePersistentDataType<>(byte[].class);
    TrPersistentDataType<int[], int[]> INTEGER_ARRAY = new TrPrimitivePersistentDataType<>(int[].class);
    TrPersistentDataType<long[], long[]> LONG_ARRAY = new TrPrimitivePersistentDataType<>(long[].class);
    TrPersistentDataType<PersistentDataContainer, PersistentDataContainer> TAG_CONTAINER = new TrPrimitivePersistentDataType<>(PersistentDataContainer.class);


    @SuppressWarnings("unchecked")
    static <T> @Nullable TrPersistentDataType<?, T> from(Class<T> type) {
        for (TrPersistentDataType<?, ?> dataType
                : getRegistry().getRegistry().values()) {
            if (dataType.getComplexType() == type
                    || dataType.identifier().equals(TrReusableIdentifier.of(type.getName()))) {
                return (TrPersistentDataType<?, T>) dataType;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    static <T> @Nullable TrPersistentDataType<?, T> from(T type) {
        if (TrValidator.isNull(type, "The provided type to get TrPersistentDataType from is null.")) return null;
        return (TrPersistentDataType<?, T>) from(type.getClass());
    }


    static TrPersistentDataTypeRegistry getRegistry() {
        return TrPersistentDataTypeRegistry.getInstance();
    }
}
