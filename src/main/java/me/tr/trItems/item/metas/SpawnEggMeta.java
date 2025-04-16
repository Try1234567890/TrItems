package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.SpawnEggItem;
import org.bukkit.entity.Player;

public class SpawnEggMeta extends BaseMeta {


    public void setMeta(SpawnEggItem item, Player player) {
        super.setMeta(item, player);
        setCustomSpawnedType(item);
    }

    public void setCustomSpawnedType(SpawnEggItem item) {
        org.bukkit.inventory.meta.SpawnEggMeta spawnEggMeta = item.getItemMeta();
        if (spawnEggMeta == null) return;
        spawnEggMeta.setCustomSpawnedType(item.getCustomSpawnedType());
        item.getStack().setItemMeta(spawnEggMeta);
    }

}
