/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class pznx {
    public static void _a(List list, Object object) {
        pznx._a(list);
        pznx._a(object);
        pznx._a(list.contains(object), "list '%' does not contain target object: '%s'", list, object);
    }

    public static void _a(String string, String string2) {
        pznx._c(string);
        pznx._c(string2);
        pznx._a(string.contains(string2), "src '%s' does not contain specified substring: '%s'", string, string2);
    }

    public static void _a(String string) {
        try {
            Float.parseFloat(string);
        }
        catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(String.format("incorrect numerical format: %s", string));
        }
    }

    public static void _b(String string) {
        try {
            Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(String.format("incorrect numerical format: %s", string));
        }
    }

    public static void _a(Collection collection) {
        pznx._a(collection != null && collection.size() > 0, "null or zero-length collection: %s", collection);
    }

    public static void _a(Map map) {
        pznx._a(map != null && map.size() > 0, "null or zero-length map: %s", map);
    }

    public static void _c(String string) {
        pznx._a(string != null && string.length() > 0, "null or zero-length string: %s", string);
    }

    public static void _a(List list) {
        pznx._a(list != null && list.size() > 0, "null or zero-length list: %s", list);
    }

    public static void _a(Object[] objectArray) {
        pznx._a(objectArray != null && objectArray.length > 0, "null or zero-length array: %s", objectArray);
    }

    public static void _a(Object object) {
        pznx._a(object != null, "null value: %s", object);
    }

    public static void _a(int n) {
        pznx._a(n < 0, "positive value: %s", n);
    }

    public static void _b(int n) {
        pznx._a(n >= 0, "negative value: %s", n);
    }

    public static void _a(long l) {
        pznx._a(l >= 0L, "negative value: %s", l);
    }

    public static void _a(boolean bl) {
        pznx._a(bl, "", new Object[0]);
    }

    public static void _a(boolean bl, String string, Object ... objectArray) {
        if (!bl) {
            throw new bqff(String.format(string, objectArray));
        }
    }

    public static void _a() {
        throw new bqff("Something went wrong!");
    }
}

