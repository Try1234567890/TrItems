package me.tr.tritems.properties.identification;

import me.tr.tritems.utility.TrValidator;
import org.jetbrains.annotations.Nullable;

/**
 * This class avoids creating multiple one-time-use instances of {@link TrIdentifier}.
 * <p>
 * It provides a single reusable instance of {@link TrIdentifier} per thread,
 * which will be modified through the {@link #of(String, String)} method.
 * <p>
 * Using a {@link ThreadLocal}, each thread gets its own independent instance,
 * ensuring thread safety without synchronization overhead.
 */
public class TrReusableIdentifier {
    private static final ThreadLocal<TrIdentifier> INSTANCE = ThreadLocal.withInitial(() -> new TrIdentifier("", ""));

    /**
     * Returns a thread-local reusable instance of {@link TrIdentifier},
     * updated with the given parameters.
     *
     * @param namespace  the namespace to set; if {@code null} or empty, it will be removed (set to empty string)
     * @param identifier the identifier to set; must not be {@code null}
     * @return the updated reusable instance of {@link TrIdentifier}
     */
    public static TrIdentifier of(@Nullable String namespace, String identifier) {
        TrValidator.isNull(identifier, "Identifier cannot be null");
        TrIdentifier instance = INSTANCE.get();

        instance.setIdentifier(identifier);
        instance.setNamespace(TrValidator.isNull(namespace, null) ? "" : namespace);

        return instance;
    }

    /**
     * Returns a thread-local reusable instance of {@link TrIdentifier},
     * updated with the given parameters.
     *
     * @param identifier the identifier to set; must not be {@code null}
     * @return the updated reusable instance of {@link TrIdentifier}
     */
    public static TrIdentifier of(String identifier) {
        return of(null, identifier);
    }
}
