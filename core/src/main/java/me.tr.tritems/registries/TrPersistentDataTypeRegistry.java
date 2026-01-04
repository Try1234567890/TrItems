package me.tr.tritems.registries;

import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.properties.nbts.datatypes.TrPersistentDataType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TrPersistentDataTypeRegistry extends TrRegistry<TrPersistentDataType<?, ?>> {
    private static TrPersistentDataTypeRegistry instance;
    private final Map<TrIdentifier, TrPersistentDataType<?, ?>> registry = new HashMap<>();

    private TrPersistentDataTypeRegistry() {
    }

    public static TrPersistentDataTypeRegistry getInstance() {
        if (instance == null) {
            instance = new TrPersistentDataTypeRegistry();
            Arrays.stream(new TrPersistentDataType[]{
                    TrPersistentDataType.UID,
                    TrPersistentDataType.BOOLEAN,
                    TrPersistentDataType.BYTE,
                    TrPersistentDataType.SHORT,
                    TrPersistentDataType.INTEGER,
                    TrPersistentDataType.LONG,
                    TrPersistentDataType.FLOAT,
                    TrPersistentDataType.DOUBLE,
                    TrPersistentDataType.STRING,
                    TrPersistentDataType.BYTE_ARRAY,
                    TrPersistentDataType.INTEGER_ARRAY,
                    TrPersistentDataType.LONG_ARRAY,
                    TrPersistentDataType.TAG_CONTAINER,
            }).forEach(t -> instance.register(t));
        }
        return instance;
    }

    @Override
    public Map<TrIdentifier, TrPersistentDataType<?, ?>> getRegistry() {
        return registry;
    }
}
