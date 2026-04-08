package me.tr.tritems.deserializers.properties;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.properties.permissions.TrPermission;

import java.util.List;
import java.util.Map;

public class TrPermissionDeserializer {

    private TrPermissionDeserializer() {}

    public static TrPermission deserialize(Object raw) throws DeserializationException {
        if (raw instanceof String str) return new TrPermission(str);

        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected String or Map for TrPermission, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        Object permRaw = map.get("permission");
        if (!(permRaw instanceof String permission))
            throw new DeserializationException("missing or invalid 'permission' field");

        String other = map.get("other") instanceof String s ? s : "";

        Object aliasesRaw = map.get("aliases");
        List<String> aliases = aliasesRaw instanceof List<?> list
                ? list.stream().filter(o -> o instanceof String).map(o -> (String) o).toList()
                : List.of();

        return new TrPermission(permission, other, aliases);
    }
}
