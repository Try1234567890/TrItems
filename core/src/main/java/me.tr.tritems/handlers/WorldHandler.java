package me.tr.tritems.handlers;

import me.tr.serializer.handlers.TypeHandler;
import me.tr.serializer.types.GenericType;
import net.kyori.adventure.key.Key;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.World;

import java.util.UUID;

public class WorldHandler implements TypeHandler {
    public static final WorldHandler INSTANCE = new WorldHandler();

    @Override
    public Object deserialize(Object o, GenericType<?> type) {

        if (o instanceof String str) {
            return Bukkit.getWorld(str);
        }
        if (o instanceof UUID uid)
            return Bukkit.getWorld(uid);

        if (o instanceof NamespacedKey namespacedKey)
            return Bukkit.getWorld(namespacedKey);

        if (o instanceof Key key) {
            return Bukkit.getWorld(key);
        }

        return null;
    }

    @Override
    public Object serialize(Object o, GenericType<?> type) {
        if (o instanceof World w)
            return w.getName();
        return null;
    }
}
