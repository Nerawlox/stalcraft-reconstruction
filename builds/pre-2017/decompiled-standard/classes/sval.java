/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gloomyfolken.mods.core.misc.dwbf;
import gloomyfolken.mods.core.misc.pzdf;
import java.lang.reflect.Type;

public class sval {
    private static Gson _a = new GsonBuilder().registerTypeAdapter((Type)((Object)cvzo.class), new pzdf()).registerTypeAdapter((Type)((Object)cvzo.class), new dwbf()).registerTypeAdapter((Type)((Object)qoac.class), new tdxg()).registerTypeAdapter((Type)((Object)qoac.class), new anbv()).create();

    public static String _a(cvzo cvzo2) {
        if (cvzo2 == null || cvzo2._a() == null) {
            return "";
        }
        return _a.toJson(cvzo2);
    }

    public static cvzo _a(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        return _a.fromJson(string, cvzo.class);
    }
}

