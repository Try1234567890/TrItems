package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.TrSpawnEggItem;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.SpawnEggMeta;

public class TrSpawnEggMeta extends TrBaseMeta {


    private TrSpawnEggMeta() {
    }


    public TrSpawnEggMeta(TrSpawnEggItem item) {
        super(item);
    }

    @Override
    public TrSpawnEggItem getItem() {
        return (TrSpawnEggItem) super.getItem();
    }


    public void setMeta(Player player) {
        super.setMeta(player);
        setCustomSpawnedType();
    }

    public void setCustomSpawnedType() {
        SpawnEggMeta spawnEggMeta = getItem().getItemMeta();
        if (spawnEggMeta == null) return;
        spawnEggMeta.setCustomSpawnedType(getItem().getCustomSpawnedType());
        getItem().getStack().setItemMeta(spawnEggMeta);
    }

    public void editCustomSpawnedType(EntityType player) {
        getItem().setCustomSpawnedType(player);
        setCustomSpawnedType();
    }

}
