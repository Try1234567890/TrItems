package me.tr.tritems.registries;

import me.tr.tritems.properties.identification.NotUniqueIdentifierException;
import me.tr.tritems.properties.identification.TrIdentifiable;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.utility.TrValidator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;


/**
 * This abstract class is the base for all TrRegistries.
 * <p>
 * Subclasses must implement {@link #getRegistry()} to provide the underlying
 * {@code Map<TrIdentifier, T>} that stores all registry values.
 * <p>
 * Example usage:
 * <pre>
 * public class TrRarityRegistry extends TrRegistry&lt;TrRarity&gt; {
 *     private static TrRarityRegistry instance;
 *     private final Map&lt;TrIdentifier, TrRarity&gt; registry = new HashMap&lt;&gt;();
 *
 *     private TrRarityRegistry() {}
 *
 *     // Singleton pattern to avoid multiple instances
 *     public static TrRarityRegistry getInstance() {
 *         if (instance == null) instance = new TrRarityRegistry();
 *         return instance;
 *     }
 *
 *     {@literal @}Override
 *     public Map&lt;TrIdentifier, TrRarity&gt; getRegistry() {
 *         return registry;
 *     }
 * }
 *
 * // Using the registry
 * TrRarityRegistry registry = TrRarityRegistry.getInstance();
 * TrRarity rare = new TrRarity("Rare");
 * registry.register(rare);
 * TrRarity retrieved = registry.get(rare.getIdentifier());
 * </pre>
 *
 */
public abstract class TrRegistry<V extends TrIdentifiable> implements Iterable<V> {

    /**
     * Get the {@code Map<I, V>} that contains all the values of the registry.
     *
     * @return the {@code Map<I, V>} that contains all the values of the registry.
     */
    public abstract Map<TrIdentifier, V> getRegistry();

    /**
     * Get the value from the {@code Map<TrIdentifier, T>} with the provided identifier.
     *
     * @param name The value identifier name to get; This is case-sensitive.
     * @return If the identifier is found, return its value, otherwise null.
     * @throws NullPointerException if the provided identifier is null.
     */
    public @Nullable V get(String name) {
        TrValidator.isNull(name, "Identifier cannot be null");
        for (Map.Entry<? extends TrIdentifier, V> entry : getRegistry().entrySet()) {
            if (entry.getKey().getIdentifier().equals(name)) {
                return entry.getValue();
            }
        }
        return null;
    }

    /**
     * Get the value from the {@code Map<TrIdentifier, T>} with the provided identifier.
     *
     * @param identifier The value identifier to get.
     * @return If the identifier is found, return its value, otherwise null.
     * @throws NullPointerException if the provided identifier is null.
     */
    public @Nullable V get(TrIdentifier identifier) {
        TrValidator.isNull(identifier, "Identifier cannot be null");
        if (TrValidator.isNull(identifier.getNamespace()))
            return get(identifier.getIdentifier());
        return getRegistry().get(identifier);
    }

    /**
     * Register the provided value to the registry.
     * <p>
     * If the registry already contains the value identifier,
     * a new {@link NotUniqueIdentifierException} will be thrown.
     *
     * @param value The value to register to the registry.
     * @throws NullPointerException         if the provided value is null.
     * @throws NotUniqueIdentifierException if value registry already contains its identifier.
     */
    public void register(V value) {
        TrValidator.isNull(value, "Value cannot be null");
        if (getRegistry().containsKey(value.identifier())) {
            throw new NotUniqueIdentifierException("Identifier " + value.identifier() + " is already used in registry " + value.getClass().getSimpleName());
        }
        getRegistry().put(value.identifier(), value);
    }

    /**
     * Unregister the value with the provided identifier from the registry.
     * <p>
     * If the provided identifier is null, a new {@link NullPointerException} will be thrown.
     *
     * @param identifier The value identifier to remove.
     * @throws NullPointerException if the provided identifier is null.
     */
    public void unregister(TrIdentifier identifier) {
        TrValidator.isNull(identifier, "Identifier cannot be null");
        getRegistry().remove(identifier);
    }

    /**
     * Modify the first value provided with the new one.
     * <p>
     * If one of the provided values is null, a new {@link NullPointerException} will be thrown.
     *
     * @param from The value to remove from the registry.
     * @param to   The value to add to the registry.
     * @throws NullPointerException if one of the values is null.
     * @see #unregister(TrIdentifier)
     * @see #register(V)
     */
    public void modify(V from, V to) {
        unregister(from.identifier());
        register(to);
    }

    @Override
    public @NotNull Iterator<V> iterator() {
        return getRegistry().values().iterator();
    }

    public Stream<V> values() {
        return getRegistry().values().stream();
    }

    public Stream<? extends TrIdentifier> keys() {
        return getRegistry().keySet().stream();
    }

    @Override
    public String toString() {
        return getRegistry().toString();
    }
}