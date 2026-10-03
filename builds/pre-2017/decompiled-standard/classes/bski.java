/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class bski
extends aphd
implements JsonSerializer {
    public htxz _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        int n;
        ArrayList<msgn> arrayList = Lists.newArrayList();
        JsonObject jsonObject = (JsonObject)jsonElement;
        int n2 = this._a(jsonObject.get("frametime"), "frametime", 1, 1, Integer.MAX_VALUE);
        if (jsonObject.has("frames")) {
            try {
                JsonArray jsonArray = jsonObject.getAsJsonArray("frames");
                for (n = 0; n < jsonArray.size(); ++n) {
                    JsonElement jsonElement2 = jsonArray.get(n);
                    msgn msgn2 = this._a(n, jsonElement2);
                    if (msgn2 == null) continue;
                    arrayList.add(msgn2);
                }
            }
            catch (ClassCastException classCastException) {
                throw new JsonParseException("Invalid animation->frames: expected array, was " + jsonObject.get("frames"), classCastException);
            }
        }
        int n3 = this._a(jsonObject.get("width"), "width", -1, 1, Integer.MAX_VALUE);
        n = this._a(jsonObject.get("height"), "height", -1, 1, Integer.MAX_VALUE);
        return new htxz(arrayList, n3, n, n2);
    }

    public msgn _a(int n, JsonElement jsonElement) {
        if (jsonElement.isJsonPrimitive()) {
            try {
                return new msgn(jsonElement.getAsInt());
            }
            catch (NumberFormatException numberFormatException) {
                throw new JsonParseException("Invalid animation->frames->" + n + ": expected number, was " + jsonElement, numberFormatException);
            }
        }
        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            int n2 = this._a(jsonObject.get("time"), "frames->" + n + "->time", -1, 1, Integer.MAX_VALUE);
            int n3 = this._a(jsonObject.get("index"), "frames->" + n + "->index", (Integer)null, 0, Integer.MAX_VALUE);
            return new msgn(n3, n2);
        }
        return null;
    }

    public JsonElement _a(htxz htxz2, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("frametime", htxz2._d());
        if (htxz2._b() != -1) {
            jsonObject.addProperty("width", htxz2._b());
        }
        if (htxz2._a() != -1) {
            jsonObject.addProperty("height", htxz2._a());
        }
        if (htxz2._c() > 0) {
            JsonArray jsonArray = new JsonArray();
            for (int i = 0; i < htxz2._c(); ++i) {
                if (htxz2._c(i)) {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("index", htxz2._d(i));
                    jsonObject2.addProperty("time", htxz2._b(i));
                    jsonArray.add(jsonObject2);
                    continue;
                }
                jsonArray.add(new JsonPrimitive(htxz2._d(i)));
            }
            jsonObject.add("frames", jsonArray);
        }
        return jsonObject;
    }

    @Override
    public String _a() {
        return "animation";
    }

    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }

    public /* synthetic */ JsonElement serialize(Object object, Type type, JsonSerializationContext jsonSerializationContext) {
        return this._a((htxz)object, type, jsonSerializationContext);
    }
}

