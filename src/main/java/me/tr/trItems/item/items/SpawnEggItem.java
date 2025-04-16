package me.tr.trItems.item.items;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.SpawnEggMeta;

public class SpawnEggItem extends BaseItem {
    private EntityType customSpawnedType;
    // todo comments


    public SpawnEggItem(BaseItem item, EntityType customSpawnedType) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.customSpawnedType = customSpawnedType;
    }

    public EntityType getCustomSpawnedType() {
        return customSpawnedType;
    }

    public void setCustomSpawnedType(EntityType customSpawnedType) {
        this.customSpawnedType = customSpawnedType;
    }

    public SpawnEggMeta getItemMeta() {
        return (SpawnEggMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.SpawnEggMeta meta = new me.tr.trItems.item.metas.SpawnEggMeta();
        meta.setMeta(this, player);
    }
}
