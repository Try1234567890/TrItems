package me.tr.tritems.properties.permissions;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.utility.TrValidator;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class TrPermission {
    private String permission;
    private String other;
    private List<String> aliases;

    public TrPermission(String permission, String other, List<String> aliases) {
        this.permission = permission;
        this.other = other;
        this.aliases = aliases;
    }

    public TrPermission(String permission, String other, String... aliases) {
        this(permission, other, Arrays.asList(aliases));
    }

    public TrPermission(String permission, String other) {
        this(permission, other, new String[0]);
    }

    @Initialize
    public TrPermission(String permission) {
        this(permission, "");
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(String... aliases) {
        this.aliases = List.of(aliases);
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public void addAliases(String... aliases) {
        this.aliases.addAll(List.of(aliases));
    }

    public void addAliases(List<String> aliases) {
        this.aliases.addAll(aliases);
    }

    public boolean has(Player player) {
        if (player.hasPermission(permission)) return true;
        else {
            for (String alias : aliases) {
                if (player.hasPermission(alias)) return true;
            }
        }
        return false;
    }

    public boolean hasOther(Player player) {
        return TrValidator.isNull(other, null) || player.hasPermission(other);
    }

    @Override
    public String toString() {
        return "TrPermission{Permission=\"" + permission + '\"' + ", Other=\"" + other + '\"' + ", Aliases=" + aliases + '}';
    }
}
