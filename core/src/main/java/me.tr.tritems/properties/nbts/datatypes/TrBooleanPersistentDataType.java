package me.tr.tritems.properties.nbts.datatypes;

import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.jetbrains.annotations.NotNull;

public class TrBooleanPersistentDataType implements TrPersistentDataType<Byte, Boolean> {
    private static final TrIdentifier identifier = new TrIdentifier(TrBooleanPersistentDataType.class.getName());

    @Override
    public @NotNull Class<Byte> getPrimitiveType() {
        return Byte.class;
    }

    @Override
    public @NotNull Class<Boolean> getComplexType() {
        return Boolean.class;
    }

    @Override
    public @NotNull Byte toPrimitive(@NotNull Boolean complex, @NotNull PersistentDataAdapterContext context) {
        return (byte) (complex ? 1 : 0);
    }

    @NotNull
    @Override
    public Boolean fromPrimitive(@NotNull Byte primitive, @NotNull PersistentDataAdapterContext context) {
        return primitive != 0;
    }

    @Override
    public TrIdentifier identifier() {
        return identifier;
    }
}