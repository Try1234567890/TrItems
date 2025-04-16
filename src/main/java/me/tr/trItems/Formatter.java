package me.tr.trItems;

import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class Formatter {


    public Component format(String msg, @Nullable Player player) {
        if (msg == null)
            return Component.empty();
        if (player != null)
            PlaceholderAPI.setPlaceholders(player, msg);
        return MiniMessage.miniMessage().deserialize(msg);
    }

}
