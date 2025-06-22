package me.tr.trItems.utilities;

public class Util {

    public static boolean isNull(String str) {
        return str == null || str.isEmpty();
    }

    public static String toCamelCase(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c) && i == 0) {
                builder.append(Character.toLowerCase(c));
                continue;
            }
            if (c == '_') {
                i++;
                builder.append(Character.toUpperCase(str.charAt(i)));
                continue;
            }
            builder.append(Character.toLowerCase(c));
        }
        return builder.toString();
    }

    public static String toSnakeCase(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                if (i != 0)
                    builder.append("_");
                builder.append(Character.toLowerCase(c));
                continue;
            }
            builder.append(c);
        }
        return builder.toString();
    }

}
