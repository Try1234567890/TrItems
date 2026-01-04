package me.tr.tritems.properties.rarity;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.properties.color.TrColor;
import me.tr.tritems.properties.color.TrColors;
import me.tr.tritems.properties.identification.TrIdentifiable;
import me.tr.tritems.properties.identification.TrIdentifier;

/**
 * This class represent a TrItem rarity.
 * Is useful in some scenarios like:
 * <pre>
 *  - Custom Color.
 *  - In some logic.
 *  - Spawn Rate.
 *  - ...
 * </pre>
 */
public class TrItemRarity implements TrIdentifiable {
    private final TrIdentifier identifier;
    private TrColor color;

    @Initialize
    public TrItemRarity(TrIdentifier identifier) {
        this.identifier = identifier;
        this.color = TrColors.WHITE.asTrColor();
    }

    public TrItemRarity(TrIdentifier identifier, TrColor color) {
        this.identifier = identifier;
        this.color = color;
    }

    @Override
    public TrIdentifier identifier() {
        return identifier;
    }

    public TrColor getColor() {
        return color;
    }

    public void setColor(TrColor color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "TrItemRarity{ID=" + identifier + ", Color=" + color + '}';
    }
}
