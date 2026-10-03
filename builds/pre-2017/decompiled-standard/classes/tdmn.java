/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class tdmn {
    public static final Map<String, satl> _a = new HashMap<String, satl>();
    public static final Set<wnce> _b = new HashSet<wnce>();

    public static satl _a(String string) {
        return _a.get(string);
    }

    static {
        try {
            Gson gson2 = new GsonBuilder().registerTypeAdapter((Type)((Object)satl.class), new zfiq()).registerTypeAdapter((Type)((Object)flpm.class), new eimk()).registerTypeAdapter((Type)((Object)pzne.class), new pidb()).registerTypeAdapter((Type)((Object)qoac.class), new tdxg()).registerTypeAdapter((Type)((Object)qoac.class), new anbv()).create();
            String string = srxe._b("/assets/bundle/clans/loot.json");
            Type type = new TypeToken<Map<String, satl>>(){}.getType();
            _a.putAll((Map)gson2.fromJson(string, type));
            for (satl satl2 : _a.values()) {
                for (wnce wnce2 : satl2._a()) {
                    wnce wnce3 = wnce2._a(1);
                    _b.add(wnce3);
                }
            }
            gloomyfolken.bundle.common.core.pidb._d("Clan random loot loaded", new String[0]);
        }
        catch (Exception exception) {
            gloomyfolken.bundle.common.core.pidb._b("Can not load clans random loot", exception, new String[0]);
        }
    }

    public static class pidb
    extends flqi {
        @Override
        public pzne _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            pzne pzne2 = super._a(jsonElement, type, jsonDeserializationContext);
            JsonArray jsonArray = jsonElement.getAsJsonObject().getAsJsonArray("chanceMultiplier");
            if (jsonArray == null) {
                jsonArray = new JsonArray();
            }
            float[] fArray = new float[jsonArray.size()];
            for (int i = 0; i < jsonArray.size(); ++i) {
                fArray[i] = jsonArray.get(i).getAsFloat();
            }
            return new kjui(pzne2, fArray);
        }

        @Override
        public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return this._a(jsonElement, type, jsonDeserializationContext);
        }
    }

    public static class kjui
    extends pzne {
        @SerializedName(value="chanceMultiplier")
        public float[] _a;

        public kjui(pzne pzne2, float[] fArray) {
            super(pzne2._c(), pzne2._d(), pzne2._e(), pzne2._f(), pzne2._g(), pzne2._h());
            this._a = fArray;
        }

        public float _a(int n) {
            if (n <= 1 || this._a == null || this._a.length == 0) {
                return 1.0f;
            }
            return this._a[Math.min(this._a.length, n - 2)];
        }

        public float _b(int n) {
            return this._b * this._a(n);
        }
    }
}

