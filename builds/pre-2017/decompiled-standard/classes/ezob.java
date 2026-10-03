/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

public class ezob {
    public static Gson _a = new GsonBuilder().registerTypeAdapter((Type)((Object)qoac.class), new tdxg()).registerTypeAdapter((Type)((Object)qoac.class), new anbv()).create();

    public static String _a(qoac qoac2) {
        if (qoac2 == null || qoac2._e()) {
            return "";
        }
        return _a.toJson(qoac2);
    }

    public static qoac _a(String string) {
        if (string == null || string.isEmpty()) {
            return new qoac();
        }
        return _a.fromJson(string, qoac.class);
    }
}

