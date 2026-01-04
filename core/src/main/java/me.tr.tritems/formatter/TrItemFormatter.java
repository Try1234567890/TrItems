package me.tr.tritems.formatter;

import me.tr.trformatter.TrFormatter;
import me.tr.tritems.TrItems;
import net.kyori.adventure.text.Component;

import java.util.ArrayList;
import java.util.List;

public class TrItemFormatter {

    private TrItemFormatter() {
    }

    public static List<Component> format(List<String> strs) {
        List<Component> result = new ArrayList<>();

        for (String str : strs) {
            result.add(format(str));
        }

        return result;
    }

    public static String formatAsString(String str) {
        return TrItems.getMiniMessage().serialize(format(str));
    }

    public static Component format(String str) {
        str = TrFormatter.resolve(str);
        return TrItems.getMiniMessage().deserialize(str);
    }

}
