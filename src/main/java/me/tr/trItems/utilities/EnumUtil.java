package me.tr.trItems.utilities;

import java.util.HashSet;
import java.util.Set;

public class EnumUtil {


    public static String[] expandIDs(String... ids) {
        final Set<String> expandedIds = new HashSet<>();
        for (String id : ids) {
            expandedIds.add(id);
            expandedIds.add(Util.toCamelCase(id));
            expandedIds.add(Util.toSnakeCase(id));
            expandedIds.add(Util.toSnakeCase(id).toLowerCase());
            expandedIds.add(Util.toSnakeCase(id).toUpperCase());
            expandedIds.add(id.replace("_", ""));
            expandedIds.add(id.replace("$", ""));
            expandedIds.add(id.toLowerCase());
            expandedIds.add(id.toUpperCase());
        }
        return expandedIds.toArray(new String[0]);
    }


    public static boolean equalsAtPercentage(String str1, String str2, int percentage) {
        if (str1 == null || str2 == null || percentage < 0 || percentage > 100) {
            return false;
        }
        int matches = 0;
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                matches++;
            }
        }
        return ((matches * 100.0) / Math.max(str1.length(), str2.length())) >= percentage;
    }
}
