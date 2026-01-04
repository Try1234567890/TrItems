package me.tr.tritems.handlers;

import me.tr.serializer.handlers.TypeHandler;
import me.tr.serializer.types.GenericType;
import me.tr.tritems.properties.identification.TrIdentifier;

import java.util.Map;

public class TrIdentifierHandler implements TypeHandler {
    public static final TrIdentifierHandler INSTANCE = new TrIdentifierHandler();

    @Override
    public Object deserialize(Object o, GenericType<?> type) {
        if (o instanceof String str) {
            return TrIdentifier.from(str);
        }

        if (o instanceof Map<?, ?> map) {
            String ID = (String) map.get(TrIdentifier.getKey());
            String namespace = (String) map.get("Namespace");

            if (ID == null)
                return null;

            return new TrIdentifier(namespace == null ? "tr_items" : namespace, ID);
        }

        return null;
    }

    @Override
    public Object serialize(Object o, GenericType<?> type) {
        if (o instanceof TrIdentifier id)
            return id.toString();
        return null;
    }
}
