package me.tr.tritems.serializers.properties;

import me.tr.tritems.properties.permissions.TrPermission;
import me.tr.tritems.serializers.SerializationException;

import java.util.HashMap;
import java.util.Map;

public class TrPermissionSerializer {

    private TrPermissionSerializer() {}

    public static Map<String, Object> serialize(TrPermission object) throws SerializationException {
        Map<String, Object> map = new HashMap<>();
        map.put("permission", permission(object));
        if (object.getOther() != null && !object.getOther().isEmpty())
            map.put("other", object.getOther());
        if (object.getAliases() != null && !object.getAliases().isEmpty())
            map.put("aliases", object.getAliases());
        return map;
    }

    private static String permission(TrPermission object) throws SerializationException {
        String permission = object.getPermission();
        if (permission == null) throw new SerializationException("permission is null");
        return permission;
    }
}
