package me.tr.tritems.properties.color;

import org.bukkit.Color;

public final class TrColorConverter {

    private TrColorConverter() {
    }

    public static int[] toRGB(Color color) {
        if (color == null) return new int[]{0, 0, 0};
        return new int[]{color.getRed(), color.getGreen(), color.getBlue()};
    }

    public static int[] toRGBFromHex(String hex) {
        if (hex == null || hex.isEmpty()) return new int[]{0, 0, 0};

        if (hex.startsWith("#")) {
            hex = hex.substring(1);
        }

        try {
            if (hex.length() == 8) {
                hex = hex.substring(2);
            }

            if (hex.length() == 6) {
                int r = Integer.parseInt(hex.substring(0, 2), 16);
                int g = Integer.parseInt(hex.substring(2, 4), 16);
                int b = Integer.parseInt(hex.substring(4, 6), 16);
                return new int[]{r, g, b};
            }
        } catch (NumberFormatException e) {
            return new int[]{0, 0, 0};
        }

        return new int[]{0, 0, 0};
    }

    public static double[] toDecimalRGB(Color color) {
        int[] rgb = toRGB(color);
        return new double[]{rgb[0] / 255.0, rgb[1] / 255.0, rgb[2] / 255.0};
    }

    public static String toHex(int[] rgb) {
        int[] validated = TrColorValidator.isRGB(rgb);
        int len = validated.length;
        return String.format("%02X%02X%02X", validated[len - 3], validated[len - 2], validated[len - 1]);
    }

    public static String toHex(double[] rgb) {
        double[] v = TrColorValidator.isRGB(rgb);
        int len = v.length;
        return String.format("%02X%02X%02X",
                (int) (v[len - 3] * 255),
                (int) (v[len - 2] * 255),
                (int) (v[len - 1] * 255));
    }

    public static String toHex(Color color) {
        return toHex(toRGB(color));
    }

    public static Color toColorFromHex(String hex) {
        int[] rgb = toRGBFromHex(TrColorValidator.isHex(hex));
        return Color.fromRGB(rgb[0], rgb[1], rgb[2]);
    }
}