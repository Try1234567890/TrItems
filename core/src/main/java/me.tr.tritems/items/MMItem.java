package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class MMItem extends TrItem {

    @Initialize
    protected MMItem() {
        super(TrItemType.MYTHIC_MOBS);
    }

    public MMItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }
}
