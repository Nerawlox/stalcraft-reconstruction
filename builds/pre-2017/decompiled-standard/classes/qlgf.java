/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Date;

public class qlgf {
    private static Gson _a = new GsonBuilder().registerTypeAdapter((Type)((Object)zwat.class), new pidb()).registerTypeAdapter((Type)((Object)zwat.class), new kjui()).create();

    public static String _a(zwat zwat2) {
        if (zwat2 == null) {
            return "";
        }
        return _a.toJson(zwat2);
    }

    public static zwat _a(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        return _a.fromJson(string, zwat.class);
    }

    static class kjui
    implements JsonDeserializer<zwat> {
        kjui() {
        }

        public zwat _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            zwat zwat2 = new zwat();
            zwat2._e(jsonObject.get("attachment").getAsString());
            zwat2._f(jsonObject.get("folder").getAsString());
            zwat2._b(jsonObject.get("message").getAsString());
            zwat2._a(jsonObject.get("topic").getAsString());
            zwat2._d(jsonObject.get("receiver").getAsString());
            zwat2._c(jsonObject.get("sender").getAsString());
            zwat2._g(jsonObject.get("category").getAsString());
            zwat2._a(jsonObject.get("id").getAsInt());
            zwat2._a(new Date(jsonObject.get("dateSent").getAsLong()));
            return zwat2;
        }

        @Override
        public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return this._a(jsonElement, type, jsonDeserializationContext);
        }
    }

    static class pidb
    implements JsonSerializer<zwat> {
        pidb() {
        }

        public JsonElement _a(zwat zwat2, Type type, JsonSerializationContext jsonSerializationContext) {
            if (zwat2 == null) {
                return JsonNull.INSTANCE;
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("attachment", new JsonPrimitive(zwat2._f()));
            jsonObject.add("folder", new JsonPrimitive(zwat2._g()));
            jsonObject.add("message", new JsonPrimitive(zwat2._c()));
            jsonObject.add("topic", new JsonPrimitive(zwat2._b()));
            jsonObject.add("receiver", new JsonPrimitive(zwat2._e()));
            jsonObject.add("sender", new JsonPrimitive(zwat2._d()));
            jsonObject.add("id", new JsonPrimitive(zwat2._j()));
            jsonObject.add("category", new JsonPrimitive(zwat2._h()));
            jsonObject.add("dateSent", new JsonPrimitive(zwat2._i().getTime()));
            return jsonObject;
        }

        @Override
        public /* synthetic */ JsonElement serialize(Object object, Type type, JsonSerializationContext jsonSerializationContext) {
            return this._a((zwat)object, type, jsonSerializationContext);
        }
    }
}

