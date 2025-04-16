package me.tr.trItems.item.loaders.loader;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.configuration.Section;
import me.tr.trItems.item.items.BaseItem;
import me.tr.trItems.item.items.SpawnEggItem;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;

public class SpawnEggLoader extends BaseLoader {

    public SpawnEggItem load(Plugin plugin, Section itemSection) {
        BaseItem baseItem = super.load(plugin, itemSection);
        EntityType entityType = getCustomSpawnedType(itemSection);
        return new SpawnEggItem(baseItem, entityType);
    }

    public EntityType getCustomSpawnedType(Section itemSection) {
        String entityTypeName = itemSection.getString("EntityType");
        NamespacedKey entityTypeKey = main.getItemManager().getNamespacedKey(entityTypeName);
        EntityType entityType = RegistryAccess.registryAccess().getRegistry(RegistryKey.ENTITY_TYPE).get(entityTypeKey);
        if (entityType == null)
            throw new NullPointerException("EntityType " + entityTypeName + " not found");
        return entityType;

    }

}
