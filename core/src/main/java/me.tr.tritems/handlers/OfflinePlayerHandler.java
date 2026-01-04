package me.tr.tritems.handlers;

import me.tr.serializer.handlers.TypeHandler;
import me.tr.serializer.types.GenericType;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.UUID;

public class OfflinePlayerHandler implements TypeHandler {
    public static final OfflinePlayerHandler INSTANCE = new OfflinePlayerHandler();

    @Override
    public Object deserialize(Object o, GenericType<?> type) {
        if (o instanceof String str) {
            try {
                return Bukkit.getOfflinePlayer(UUID.fromString(str));
            } catch (IllegalArgumentException e) {
                return Bukkit.getOfflinePlayer(str);
            }
        }

        if (o instanceof UUID uuid) {
            return Bukkit.getOfflinePlayer(uuid);
        }

        return null;
    }

    @Override
    public Object serialize(Object o, GenericType<?> type) {
        if (o instanceof OfflinePlayer offPlayer)
            return offPlayer.getName();
        return null;
    }
}
