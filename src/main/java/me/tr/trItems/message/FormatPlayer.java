package me.tr.trItems.message;

import org.bukkit.entity.Player;

public class FormatPlayer {
    private Player player;
    private String prefix;

    public FormatPlayer(Player player, String prefix) {
        this.player = player;
        this.prefix = prefix;
    }

    public FormatPlayer(Player player) {
        this.player = player;
        this.prefix = "Player";
    }

    public static FormatPlayer of(Player player) {
        return new FormatPlayer(player);
    }

    public static FormatPlayer of(Player player, String prefix) {
        return new FormatPlayer(player, prefix);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
