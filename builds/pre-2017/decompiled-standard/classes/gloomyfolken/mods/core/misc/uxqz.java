/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

public class uxqz {
    public static GsonBuilder _a = dwkx._a;
    private static Gson _b = _a.create();
    private static JsonParser _c = new JsonParser();

    public static <T> T _a(String string, Class<T> clazz) {
        return _b.fromJson(_c.parse(string), clazz);
    }

    public static String _a(Object object) {
        return _b.toJson(object);
    }
}

