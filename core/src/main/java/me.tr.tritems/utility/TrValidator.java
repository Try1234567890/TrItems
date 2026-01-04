package me.tr.tritems.utility;

import org.jetbrains.annotations.Contract;

import java.lang.reflect.Array;
import java.util.Collection;

public class TrValidator {

    /**
     * Check if the provided object is {@code null}.
     * <p>
     * If the object is {@code null} a new {@code NullPointerException}
     * will be thrown.
     * If msg is null no exception will be thrown and the method returns {@code true}.
     * <p>
     * If the object is an instance of {@link String} and the trimmed string is {@code empty},
     * the object is considered null.
     * <p>
     * If the object is an instance of {@link Number} and the double value is minus than {@code 0.0},
     * the object is considered null.
     * <p>
     * If the object is an instance of {@link Collection} or an {@link Array} and it is {@code empty},
     * the object is considered null.
     * <p>
     * If the object is {@code not null}, the method simply returns {@code false}.
     *
     * @param obj The object to check.
     * @param msg The msg to send with the {@code NullPointerException};
     *            If msg is {@code null}, no exception will be thrown.
     * @return {@code true} if the object is {@code null}, otherwise false if the msg is null;
     * If object is {@code null} and msg is {@code not null} a   new {@code NullPointerException} will be thrown.
     */
    @Contract("null, _ -> true")
    public static boolean isNull(Object obj, String msg) {
        boolean isNull = obj == null
                || ((obj instanceof String str) && str.trim().isEmpty())
                || ((obj instanceof Number num) && num.doubleValue() < 0.0)
                || ((obj instanceof Collection<?> coll) && coll.isEmpty())
                || ((obj.getClass().isArray()) && Array.getLength(obj) <= 0);
        return checkIf(isNull, msg);
    }

    @Contract("null -> true")
    public static boolean isNull(Object obj) {
        return isNull(obj, null);
    }

    public static boolean checkIf(boolean condition, String msg) {
        if (condition && msg != null)
            throw new IllegalArgumentException(msg);
        return condition;
    }
}
