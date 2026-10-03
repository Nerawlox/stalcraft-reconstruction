/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.misc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import cpw.mods.fml.common.FMLLog;
import gloomyfolken.mods.stalker.misc.ezey;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class xpzm {
    private ezey _a = new ezey();
    @SerializedName(value="localizedNames")
    private Map<String, String> _b = new HashMap<String, String>();
    @SerializedName(value="onLost")
    private double _c;
    @SerializedName(value="saturationStart")
    private double _d;
    @SerializedName(value="saturationEnd")
    private double _e;
    @SerializedName(value="finalDecrease")
    private double _f;
    @SerializedName(value="reset")
    private int _g;

    public xpzm(String string) {
        this._a(string);
    }

    private void _a(String string) {
        JsonObject jsonObject = new JsonParser().parse(string).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("locations");
        for (JsonElement jsonElement : jsonArray) {
            JsonArray jsonArray2 = jsonElement.getAsJsonArray();
            String string2 = jsonArray2.get(0).getAsString();
            String string3 = jsonArray2.get(1).getAsString();
            double d = jsonArray2.get(2).getAsDouble();
            this._a._a(string2, string3, d / 100.0);
        }
        this._a._b();
        Gson gson2 = new GsonBuilder().registerTypeAdapter((Type)((Object)xpzm.class), type -> this).create();
        gson2.fromJson((JsonElement)jsonObject, xpzm.class);
        if (!this._a._a()) {
            FMLLog.warning("Trade routes graph is disconnected! Prices calculation may act unpredictably! Fix tradepacks.json immediately!", new Object[0]);
        }
    }

    public boolean _a() {
        return this._a._a();
    }

    public Map<String, String> _b() {
        return this._b;
    }

    public Set<String> _c() {
        return this._a._d();
    }

    public double _a(String string, String string2) {
        return this._a._a(string, string2);
    }

    public double _d() {
        return this._c;
    }

    public double _e() {
        return this._d;
    }

    public double _f() {
        return this._e;
    }

    public double _g() {
        return this._f;
    }

    public int _h() {
        return this._g;
    }
}

