/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

public class dwkx {
    public static final GsonBuilder _a = new GsonBuilder().registerTypeAdapter((Type)((Object)satl.class), new zfiq()).registerTypeAdapter((Type)((Object)flpm.class), new eimk()).registerTypeAdapter((Type)((Object)pzne.class), new flqi()).registerTypeAdapter((Type)((Object)qoac.class), new tdxg()).registerTypeAdapter((Type)((Object)qoac.class), new anbv()).setPrettyPrinting();
    public static final Gson _b = _a.create();
}

