package me.tr.tritems.handlers;

import me.tr.serializer.exceptions.TypeMissMatched;
import me.tr.serializer.handlers.TypeHandler;
import me.tr.serializer.types.GenericType;
import me.tr.serializer.utility.Utility;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class TrItemHandler implements TypeHandler {
    public static final TrItemHandler INSTANCE = new TrItemHandler();


    @Override
    public Object deserialize(Object obj, GenericType<?> type) {
        if (obj instanceof Map<?, ?> map) {
            if (!String.class.equals(Utility.getKeyType(map))) {
                throw new TypeMissMatched("The keys type of the provided map is not String.");
            }
            //noinspection unchecked
            return TrItem.deserialize((Map<String, Object>) map);
        }

        if (obj instanceof ItemStack stack) {
            return TrItem.fromOrBuild(stack);
        }

        if (obj instanceof String str) {
            return TrItem.get(str);
        }

        if (obj instanceof TrIdentifier id) {
            return TrItem.get(id);
        }

        return null;
    }

    @Override
    public Object serialize(Object obj, GenericType<?> type) {
        return TrItem.getSerializer().serialize(new HashMap<>(), obj);
    }
}
