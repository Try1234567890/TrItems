package me.tr.trItems.item.helper.logger;

import org.jetbrains.annotations.Nullable;

public enum LoggerLevel {

    INFO("[INFO]", "<aqua>", 'b'),
    WARN("[WARN]", "<yellow>", 'e'),
    ERROR("[ERROR]", "<red>", 'c'),
    DEBUG("[DEBUG]", "<light_purple>", 'd');

    private final String tag;
    private final String color;
    private final @Nullable Character colorChar;

    LoggerLevel(String tag, String color, @Nullable Character colorChar) {
        this.tag = tag;
        this.color = color;
        this.colorChar = colorChar;
    }

    public String getTag() {
        return tag;
    }

    public String getColor() {
        return color;
    }

    public @Nullable Character getColorChar() {
        return colorChar;
    }
}
