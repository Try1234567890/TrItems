package me.tr.tritems.deserializers.properties;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.properties.color.TrColor;
import me.tr.tritems.properties.custommodeldata.TrComponentCustomModelData;

import java.util.List;
import java.util.Map;

public class TrComponentCustomModelDataDeserializer {

    private TrComponentCustomModelDataDeserializer() {}

    public static TrComponentCustomModelData deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrComponentCustomModelData, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        List<Float> floats = castList(map.get("floats"), "floats", o -> ((Number) o).floatValue());
        List<Boolean> flags = castList(map.get("flags"), "flags", o -> (Boolean) o);
        List<String> strings = castList(map.get("strings"), "strings", o -> (String) o);
        List<String> colorHexes = castList(map.get("colors"), "colors", o -> (String) o);
        List<TrColor> colors = colorHexes.stream().map(TrColor::new).toList();

        return new TrComponentCustomModelData(floats, flags, strings, colors);
    }

    @SuppressWarnings("unchecked")
    private static <T> List<T> castList(Object raw, String field, java.util.function.Function<Object, T> mapper) throws DeserializationException {
        if (raw == null) return List.of();
        if (!(raw instanceof List<?> list))
            throw new DeserializationException("expected List for " + field + ", got: " + raw.getClass().getSimpleName());
        try {
            return list.stream().map(mapper).toList();
        } catch (ClassCastException e) {
            throw new DeserializationException("invalid element type in " + field);
        }
    }
}
