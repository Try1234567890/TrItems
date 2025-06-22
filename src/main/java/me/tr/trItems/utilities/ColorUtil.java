package me.tr.trItems.utilities;

import me.tr.trItems.TrItems;
import org.bukkit.Color;
import org.bukkit.DyeColor;

import java.util.ArrayList;
import java.util.List;

public class ColorUtil {
    private static final TrItems main = TrItems.getInstance();


    public static Color parseColor(String colorStr) {
        Color color = null;
        String[] colorStrSplit = colorStr.split(" ");
        if (colorStr.startsWith("#")) {
            colorStr = colorStr.substring(1);
            int r = Integer.parseInt(colorStr.substring(0, 2), 16);
            int g = Integer.parseInt(colorStr.substring(2, 4), 16);
            int b = Integer.parseInt(colorStr.substring(4, 6), 16);
            color = Color.fromRGB(r, g, b);
        } else if (colorStrSplit.length >= 3) {
            color = Color.fromRGB(Integer.parseInt(colorStrSplit[0]), Integer.parseInt(colorStrSplit[1]), Integer.parseInt(colorStrSplit[2]));
        } else {
            try {
                color = DyeColor.valueOf(colorStr).getColor();
            } catch (IllegalArgumentException e) {
                main.getLogger().error("Invalid color: " + colorStr);
            }
        }
        return color;
    }

    public static List<Color> parseColors(List<String> colorsStr) {
        List<Color> colors = new ArrayList<>();
        for (String colorStr : colorsStr) {
            Color color = parseColor(colorStr);
            colors.add(color);
        }
        return colors;
    }
}
