/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.misc;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import cpw.mods.fml.common.FMLLog;
import gloomyfolken.bundle.common.core.tupg;
import gloomyfolken.mods.stalker.misc.ezey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.vecmath.Vector3f;
import org.apache.commons.lang3.tuple.Pair;

public class pidb {
    private Map<String, kjui> _a = new HashMap<String, kjui>();
    private ezey _b = new ezey();
    private List<pzop<String, String, Double>> _c = new ArrayList<pzop<String, String, Double>>();
    private List<Pair<Integer, Float>> _d = new ArrayList<Pair<Integer, Float>>();

    public pidb(String string) {
        this._a(string);
    }

    private void _a(String string) {
        JsonObject jsonObject = new JsonParser().parse(string).getAsJsonObject();
        this._b(jsonObject);
        this._c(jsonObject);
        this._a(jsonObject);
    }

    private void _a(JsonObject jsonObject) {
        JsonArray jsonArray = jsonObject.getAsJsonArray("discounts");
        for (JsonElement jsonElement : jsonArray) {
            JsonArray jsonArray2 = jsonElement.getAsJsonArray();
            this._d.add(Pair.of(jsonArray2.get(0).getAsInt(), Float.valueOf(jsonArray2.get(1).getAsFloat())));
        }
    }

    public Map<String, kjui> _a() {
        return this._a;
    }

    public ezey _b() {
        return this._b;
    }

    public List<pzop<String, String, Double>> _c() {
        return this._c;
    }

    public float _a(int n) {
        float f = 0.0f;
        for (Pair<Integer, Float> pair : this._d) {
            if (n < pair.getLeft() || !(f < pair.getRight().floatValue())) continue;
            f = pair.getRight().floatValue();
        }
        return Math.min(f, 1.0f);
    }

    private void _b(JsonObject jsonObject) {
        JsonArray jsonArray = jsonObject.getAsJsonArray("routes");
        for (JsonElement jsonElement : jsonArray) {
            JsonArray jsonArray2 = jsonElement.getAsJsonArray();
            String string = jsonArray2.get(0).getAsString();
            String string2 = jsonArray2.get(1).getAsString();
            double d = jsonArray2.get(2).getAsDouble();
            this._c.add(pzop._a(string, string2, d));
            this._b._a(string, string2, d);
        }
        this._b._b();
        if (!this._b._a()) {
            FMLLog.warning("Guides routes graph is disconnected! Fix guides.json!", new Object[0]);
        }
    }

    private void _c(JsonObject jsonObject) {
        JsonObject jsonObject2 = jsonObject.getAsJsonObject("savezones");
        for (Map.Entry<String, JsonElement> entry : jsonObject2.entrySet()) {
            String string = entry.getKey();
            JsonArray jsonArray = entry.getValue().getAsJsonArray();
            float f = jsonArray.get(0).getAsFloat();
            float f2 = jsonArray.get(1).getAsFloat();
            float f3 = jsonArray.get(2).getAsFloat();
            tupg tupg2 = null;
            String string2 = jsonArray.get(3).toString().toUpperCase().replace("\"", "");
            if (!"ALL".equals(string2)) {
                tupg2 = tupg.valueOf(string2);
            }
            String string3 = jsonArray.get(4).getAsString().replace("\"", "");
            this._a.put(string, new kjui(string, tupg2, new Vector3f(f, f2, f3), string3));
        }
    }

    public class kjui {
        public final String _a;
        public final tupg _b;
        public final Vector3f _c;
        public final String _d;

        public kjui(String string, tupg tupg2, Vector3f vector3f, String string2) {
            this._a = string;
            this._b = tupg2;
            this._c = vector3f;
            this._d = string2;
        }
    }
}

