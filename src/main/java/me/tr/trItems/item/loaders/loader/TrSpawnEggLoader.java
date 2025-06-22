package me.tr.trItems.item.loaders.loader;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.ItemManager;
import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.item.items.TrSpawnEggItem;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;

public class TrSpawnEggLoader extends TrBaseLoader {

    public TrSpawnEggItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        EntityType entityType = getCustomSpawnedType(itemSection);
        return new TrSpawnEggItem(baseItem, entityType);
    }

    public EntityType getCustomSpawnedType(Section itemSection) {
        String entityTypeName = itemSection.getString("EntityType");
        NamespacedKey entityTypeKey = ItemManager.getInstance().parseNamespacedKey(entityTypeName);
        EntityType entityType = RegistryAccess.registryAccess().getRegistry(RegistryKey.ENTITY_TYPE).get(entityTypeKey);
        if (entityType == null)
            throw new NullPointerException("EntityType " + entityTypeName + " not found");
        return entityType;

    }

}
