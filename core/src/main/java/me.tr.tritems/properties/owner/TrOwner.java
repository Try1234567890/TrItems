package me.tr.tritems.properties.owner;

import me.tr.serializer.annotations.AsString;
import me.tr.serializer.annotations.Ignore;
import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.utility.TrValidator;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

@AsString
public class TrOwner {
    private UUID uuid;
    private @Ignore Player player;
    private @Ignore OfflinePlayer offlinePlayer;

    @Initialize
    private TrOwner() {
    }

    public TrOwner(UUID uuid) {
        TrValidator.isNull(uuid, "The UUID cannot be null.");
        this.uuid = uuid;
        this.player = Bukkit.getPlayer(uuid);
        this.offlinePlayer = Bukkit.getOfflinePlayer(uuid);
        TrValidator.isNull(offlinePlayer, "OfflinePlayer with UUID: " + uuid + " not exists.");
    }

    public TrOwner(Player player) {
        this(player.getUniqueId());
    }

    public TrOwner(OfflinePlayer offlinePlayer) {
        this(offlinePlayer.getUniqueId());
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
        this.player = Bukkit.getPlayer(uuid);
        this.offlinePlayer = Bukkit.getOfflinePlayer(uuid);
    }

    public @Nullable Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        this.offlinePlayer = Bukkit.getOfflinePlayer(player.getUniqueId());
        this.uuid = player.getUniqueId();
    }

    public @Nullable OfflinePlayer getOfflinePlayer() {
        return offlinePlayer;
    }

    public void setOfflinePlayer(OfflinePlayer offlinePlayer) {
        this.offlinePlayer = offlinePlayer;
        this.player = offlinePlayer.getPlayer();
        this.uuid = offlinePlayer.getUniqueId();
    }

    @Override
    public String toString() {
        return "TrOwner{UUID=" + uuid + '}';
    }

    private void finishDes() {
        this.player = Bukkit.getPlayer(uuid);
        this.offlinePlayer = Bukkit.getOfflinePlayer(uuid);
    }
}
