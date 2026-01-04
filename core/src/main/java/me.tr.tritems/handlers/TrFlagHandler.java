package me.tr.tritems.handlers;

import me.tr.serializer.handlers.TypeHandler;
import me.tr.serializer.types.GenericType;
import me.tr.tritems.properties.flags.TrFlag;
import me.tr.tritems.properties.identification.TrIdentifier;

public class TrFlagHandler implements TypeHandler {
    public static final TrFlagHandler INSTANCE = new TrFlagHandler();

    @Override
    public Object deserialize(Object o, GenericType<?> type) {
        if (o instanceof String str) {
            TrIdentifier ID = TrIdentifier.from(str);
            TrFlag enchant = TrFlag.getFlag(ID);
            return enchant == null ? TrFlag.getFlag(str) : enchant;
        }

        if (o instanceof TrIdentifier id) {
            return TrFlag.getFlag(id);
        }

        return null;
    }

    @Override
    public Object serialize(Object o, GenericType<?> type) {
        if (o instanceof TrFlag enchant)
            return enchant.identifier().toString();
        return null;
    }
}
