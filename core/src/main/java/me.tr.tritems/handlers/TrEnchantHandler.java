package me.tr.tritems.handlers;

import me.tr.serializer.handlers.TypeHandler;
import me.tr.serializer.types.GenericType;
import me.tr.tritems.properties.enchants.TrEnchantEntry;
import me.tr.tritems.properties.identification.TrIdentifier;

public class TrEnchantHandler implements TypeHandler {
    public static final TrEnchantHandler INSTANCE = new TrEnchantHandler();

    @Override
    public Object deserialize(Object o, GenericType<?> type) {
        if (o instanceof String str) {
            TrIdentifier ID = TrIdentifier.from(str);
            TrEnchantEntry enchant = TrEnchantEntry.getEnchantment(ID);
            return enchant == null ? TrEnchantEntry.getEnchantment(str) : enchant;
        }

        if (o instanceof TrIdentifier id) {
            return TrEnchantEntry.getEnchantment(id);
        }

        return null;
    }

    @Override
    public Object serialize(Object o, GenericType<?> type) {
        if (o instanceof TrEnchantEntry enchant)
            return enchant.identifier().toString();
        return null;
    }
}
