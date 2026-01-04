package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class MMOItem extends TrItem {

    @Initialize
    protected MMOItem() {
        super(TrItemType.MMO_ITEMS);
    }

    public MMOItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }
}
