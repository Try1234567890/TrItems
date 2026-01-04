package me.tr.tritems.properties.nbts.datatypes;

import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.properties.identification.TrReusableIdentifier;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.jetbrains.annotations.NotNull;

public class TrPersistentUID implements TrPersistentDataType<String, TrIdentifier> {
    private static final TrIdentifier identifier = new TrIdentifier(TrPersistentUID.class.getName());

    @Override

    public @NotNull Class<String> getPrimitiveType() {
        return String.class;
    }

    @Override
    public @NotNull Class<TrIdentifier> getComplexType() {
        return TrIdentifier.class;
    }

    @Override
    public @NotNull String toPrimitive(@NotNull TrIdentifier complex, @NotNull PersistentDataAdapterContext context) {
        return complex.toString();
    }

    @Override
    public @NotNull TrIdentifier fromPrimitive(@NotNull String primitive, @NotNull PersistentDataAdapterContext context) {
        TrIdentifier id = TrIdentifier.from(primitive);
        if (id == null)
            return TrReusableIdentifier.of("-");
        return id;
    }

    @Override
    public TrIdentifier identifier() {
        return identifier;
    }
}
