package me.tr.tritems.properties.identification;

import me.tr.trfiles.file.configuration.Section;
import me.tr.trfiles.file.configuration.memory.implementations.MemoryJsonConfiguration;
import me.tr.tritems.utility.TrValidator;
import org.bukkit.NamespacedKey;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;


public class TrIdentifier {
    private static final char SEPARATOR = ':';
    private String namespace;
    private String identifier;

    public TrIdentifier(String namespace, String identifier) {
        this.namespace = namespace.toLowerCase();
        this.identifier = identifier.toLowerCase();
    }

    public TrIdentifier(String identifier) {
        this.identifier = identifier.toLowerCase();
    }

    public TrIdentifier(NamespacedKey key) {
        this.namespace = key.getNamespace().toLowerCase();
        this.identifier = key.getKey().toLowerCase();
    }

    public static TrIdentifier getID(Map<String, Object> map) {
        return getID(MemoryJsonConfiguration.fromMap(map));
    }

    public static TrIdentifier getID(Section section) {
        return from(section.getString(getKey(), section.getName()));
    }

    public static TrIdentifier from(String identifier) {
        if (TrValidator.isNull(identifier, "Identifier cannot be null"))
            return null;
        int index = identifier.trim().indexOf(SEPARATOR);
        if (index == -1) {
            return new TrIdentifier(identifier.trim());
        } else if (index == 0) {
            return new TrIdentifier(identifier.trim().substring(1));
        } else if (index == identifier.trim().length() - 1) {
            return new TrIdentifier(identifier.trim().substring(0, index));
        } else {
            return new TrIdentifier(identifier.trim().substring(0, index), identifier.trim().substring(index + 1));
        }
    }

    public static TrIdentifier random() {
        String namespace = "tr_items";
        UUID id = UUID.randomUUID();

        return new TrIdentifier(namespace, id.toString());
    }

    public static String getKey() {
        return "ID";
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace.toLowerCase();
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier.toLowerCase();
    }

    public NamespacedKey toNamespacedKey() {
        return new NamespacedKey(TrValidator.isNull(namespace, null) ? "" : namespace.toLowerCase(), identifier.toLowerCase());
    }

    @Override
    public String toString() {
        return TrValidator.isNull(namespace, null) ? identifier : namespace + SEPARATOR + identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TrIdentifier that = (TrIdentifier) o;
        return Objects.equals(getNamespace(), that.getNamespace()) && Objects.equals(getIdentifier(), that.getIdentifier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNamespace(), getIdentifier());
    }
}