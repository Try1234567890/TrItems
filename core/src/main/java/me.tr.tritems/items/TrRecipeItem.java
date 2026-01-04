package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class TrRecipeItem extends TrItem {
    private final char letter;

    @Initialize
    private TrRecipeItem() {
        super(TrItemType.NORMAL);
        this.letter = 'A';
    }

    public TrRecipeItem(TrIdentifier identifier, @NotNull Material material, char letter) {
        super(identifier, material);
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }
}
