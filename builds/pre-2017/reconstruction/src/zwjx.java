/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

public class zwjx {
    public static final Gson _a = zwjx._a(new GsonBuilder()).create();

    public static GsonBuilder _a(GsonBuilder gsonBuilder) {
        return gsonBuilder.registerTypeAdapter((Type)((Object)gotk.class), new gotk.kjui()).registerTypeAdapter((Type)((Object)iuyn.class), new iuyn.kjui()).registerTypeAdapter((Type)((Object)einh.class), new einh.kjui()).registerTypeAdapter((Type)((Object)hrvl.class), new hrvl.kjui()).registerTypeAdapter((Type)((Object)satm.class), new satm.kjui());
    }
}

