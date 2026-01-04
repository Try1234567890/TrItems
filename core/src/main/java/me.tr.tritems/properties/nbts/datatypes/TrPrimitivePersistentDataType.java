package me.tr.tritems.properties.nbts.datatypes;

import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.utility.TrValidator;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.jetbrains.annotations.NotNull;

public class TrPrimitivePersistentDataType<P> implements TrPersistentDataType<P, P> {
    private Class<P> clazz;
    private TrIdentifier identifier;

    public TrPrimitivePersistentDataType(Class<P> clazz) {
        if (TrValidator.isNull(clazz, "An error occurs while initializing new primitive persistent data type. Provided clazz is null."))
            return;
        this.clazz = clazz;
        this.identifier = new TrIdentifier(clazz.getName());
    }

    @Override
    public @NotNull Class<P> getPrimitiveType() {
        return clazz;
    }

    @Override
    public @NotNull Class<P> getComplexType() {
        return clazz;
    }

    @Override
    public @NotNull P toPrimitive(@NotNull P complex, @NotNull PersistentDataAdapterContext context) {
        return complex;
    }

    @Override
    public @NotNull P fromPrimitive(@NotNull P primitive, @NotNull PersistentDataAdapterContext context) {
        return primitive;
    }

    @Override
    public TrIdentifier identifier() {
        return identifier;
    }
}
