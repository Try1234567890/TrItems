package me.tr.tritems.properties.color;

import me.tr.serializer.annotations.AsString;
import org.bukkit.Color;
import org.bukkit.DyeColor;

@AsString
public class TrColor {
    private String hex;

    public TrColor(String hex) {
        this.hex = hex;
    }

    public String getHex() {
        return hex;
    }

    private void setHex(String hex) {
        this.hex = hex;
    }

    public String toMiniMessage() {
        return "<#" + hex + '>';
    }

    public int[] toRGB() {
        return TrColorConverter.toRGBFromHex(hex);
    }

    public double[] toDecimalRGB() {
        return TrColorConverter.toDecimalRGB(TrColorConverter.toColorFromHex(hex));
    }

    public Color toColor() {
        return TrColorConverter.toColorFromHex(hex);
    }

    public DyeColor toDyeColor() {
        return DyeColor.getByColor(toColor());
    }

    @Override
    public String toString() {
        return "TrColor{Hex=\"" + hex + "\"}";
    }
}
