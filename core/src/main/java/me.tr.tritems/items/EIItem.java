package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class EIItem extends TrItem {

    @Initialize
    protected EIItem() {
        super(TrItemType.EXECUTABLE_ITEMS);
    }

    public EIItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }
}
