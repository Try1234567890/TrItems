package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrSkullMeta;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TrSkullItem extends TrItem {
    private NamespacedKey sound;
    private OfflinePlayer skullOwner;

    @Initialize
    protected TrSkullItem() {
        super(TrItemType.SKULL);
    }

    public TrSkullItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    @Override
    public TrSkullMeta getMeta() {
        return (TrSkullMeta) super.getMeta();
    }

    @Override
    public @Nullable SkullMeta getItemMeta() {
        return (SkullMeta) super.getItemMeta();
    }

    public NamespacedKey getSound() {
        return sound;
    }

    public void setSound(NamespacedKey sound) {
        this.sound = sound;
    }

    public OfflinePlayer getSkullOwner() {
        return skullOwner;
    }

    public void setSkullOwner(OfflinePlayer skullOwner) {
        this.skullOwner = skullOwner;
    }
}
