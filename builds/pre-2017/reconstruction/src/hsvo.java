/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class hsvo {
    private float _a = 0.0f;
    private float _b = 0.0f;
    private Map<String, pidb> _c = new HashMap<String, pidb>();

    public hsvo(String string) {
        Gson gson2 = new Gson();
        JsonObject jsonObject = new JsonParser().parse(string).getAsJsonObject();
        this._a = jsonObject.get("hear_distance").getAsFloat();
        this._b = jsonObject.get("hear_distance_enemy").getAsFloat();
        JsonObject jsonObject2 = jsonObject.get("voicepacks").getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject2.entrySet()) {
            pidb pidb2 = new pidb(entry.getKey());
            JsonObject jsonObject3 = entry.getValue().getAsJsonObject().get("spot").getAsJsonObject();
            for (Map.Entry<String, JsonElement> entry2 : jsonObject3.entrySet()) {
                Object object = gson2.fromJson(entry2.getValue(), String[].class);
                pidb2._c.putAll(entry2.getKey(), Arrays.asList(object));
            }
            JsonObject jsonObject4 = entry.getValue().getAsJsonObject().get("commands").getAsJsonObject();
            for (Object object : jsonObject4.entrySet()) {
                kjui[] kjuiArray = gson2.fromJson((JsonElement)object.getValue(), kjui[].class);
                pidb2._d.putAll(object.getKey(), Arrays.asList(kjuiArray));
            }
            this._c.put(pidb2._a, pidb2);
        }
    }

    public float _a() {
        return this._b;
    }

    public float _b() {
        return this._a;
    }

    public boolean _a(String string) {
        return this._c.containsKey(string);
    }

    public pidb _b(String string) {
        return this._c.get(string);
    }

    public Map<String, pidb> _c() {
        return this._c;
    }

    public static class pidb {
        private String _a;
        private Random _b = new Random();
        private ListMultimap<String, String> _c = ArrayListMultimap.create();
        private ListMultimap<String, kjui> _d = ArrayListMultimap.create();

        public pidb(String string) {
            this._a = string;
        }

        public kjui _a(String string) {
            return this._a(this._d, string);
        }

        public String _b(String string) {
            return this._a(this._c, string);
        }

        private <V> V _a(ListMultimap<String, V> listMultimap, String string) {
            List<V> list = listMultimap.get(string);
            if (list == null || list.isEmpty()) {
                return null;
            }
            return list.get(this._b.nextInt(list.size()));
        }
    }

    public static class kjui {
        @SerializedName(value="text")
        private String _a;
        @SerializedName(value="sound")
        private String _b;

        public String _a() {
            return this._a;
        }

        public String _b() {
            return this._b;
        }
    }
}

