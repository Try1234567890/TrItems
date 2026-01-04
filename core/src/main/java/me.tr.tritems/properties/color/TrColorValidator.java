package me.tr.tritems.properties.color;

public final class TrColorValidator {

    private TrColorValidator() {
    }

    public static int[] isRGB(int[] rgb) {
        if (rgb == null || rgb.length < 3) return new int[]{0, 0, 0};

        int[] result = new int[3];
        int start = (rgb.length == 4) ? 1 : 0;

        for (int i = 0; i < 3; i++) {
            int val = rgb[start + i];
            result[i] = Math.max(0, Math.min(255, val));
        }
        return result;
    }

    public static double[] isRGB(double[] rgb) {
        if (rgb == null || rgb.length < 3) return new double[]{0.0, 0.0, 0.0};

        double[] result = new double[3];
        int start = (rgb.length == 4) ? 1 : 0;

        for (int i = 0; i < 3; i++) {
            double val = rgb[start + i];
            result[i] = Math.max(0.0, Math.min(1.0, val));
        }
        return result;
    }

    public static String isHex(String hex) {
        if (hex == null || hex.isEmpty()) return "000000";

        String prefix = hex.startsWith("#") ? "#" : "";
        String clean = hex.replaceAll("[^a-fA-F0-9]", "");

        if (clean.length() == 8) {
            clean = clean.substring(2);
        }

        if (clean.length() != 6) {
            return "000000";
        }

        return prefix + clean;
    }
}