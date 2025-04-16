package me.tr.trItems.item.helper.logger;

import me.tr.trItems.TrItems;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;

public class TrLogger {
    private final TrItems main = TrItems.getInstance();

    public void log(String message, LoggerLevel level) {
        String newMessage = level.getColor() + level.getTag() + ' ' + message;
        Component mess = main.getFormatter().format(newMessage, null);
        Bukkit.getServer().getConsoleSender().sendMessage(mess);
    }

    public void info(String message) {
        log(message, LoggerLevel.INFO);
    }

    public void warn(String message) {
        log(message, LoggerLevel.WARN);
    }

    public void error(String message) {
        log(message, LoggerLevel.ERROR);
    }

}
