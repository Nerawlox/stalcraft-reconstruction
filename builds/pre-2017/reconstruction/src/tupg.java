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

public class tupg {
    private static Gson _a = new GsonBuilder().registerTypeAdapter((Type)((Object)ezey.class), new pidb()).registerTypeAdapter((Type)((Object)ezey.class), new kjui()).create();

    public static String _a(ezey ezey2) {
        if (ezey2 == null) {
            return "";
        }
        return _a.toJson(ezey2);
    }

    public static ezey _a(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        return _a.fromJson(string, ezey.class);
    }

    static class kjui
    implements JsonDeserializer<ezey> {
        kjui() {
        }

        public ezey _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            ezey ezey2 = new ezey();
            ezey2._a(jsonObject.get("category").getAsString());
            ezey2._b(new Date(jsonObject.get("dateStart").getAsLong()));
            ezey2._c(new Date(jsonObject.get("dateEnd").getAsLong()));
            ezey2._a(new Date(jsonObject.get("dateLeft").getAsLong()));
            ezey2._c(jsonObject.get("currentBidder").getAsString());
            ezey2._b(jsonObject.get("itemData").getAsString());
            ezey2._d(jsonObject.get("currentBid").getAsLong());
            ezey2._b(jsonObject.get("priceStep").getAsLong());
            ezey2._c(jsonObject.get("priceMax").getAsLong());
            ezey2._a(jsonObject.get("priceStart").getAsLong());
            ezey2._a(jsonObject.get("lotId").getAsInt());
            return ezey2;
        }

        @Override
        public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return this._a(jsonElement, type, jsonDeserializationContext);
        }
    }

    static class pidb
    implements JsonSerializer<ezey> {
        pidb() {
        }

        public JsonElement _a(ezey ezey2, Type type, JsonSerializationContext jsonSerializationContext) {
            if (ezey2 == null) {
                return JsonNull.INSTANCE;
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("lotId", new JsonPrimitive(ezey2._b));
            jsonObject.add("dateStart", new JsonPrimitive(ezey2._f.getTime()));
            jsonObject.add("dateEnd", new JsonPrimitive(ezey2._g.getTime()));
            jsonObject.add("dateLeft", new JsonPrimitive(ezey2._h.getTime()));
            jsonObject.add("priceStep", new JsonPrimitive(ezey2._d));
            jsonObject.add("priceMax", new JsonPrimitive(ezey2._e));
            jsonObject.add("priceStart", new JsonPrimitive(ezey2._c));
            jsonObject.add("itemData", new JsonPrimitive(ezey2._j));
            jsonObject.add("category", new JsonPrimitive(ezey2._i.toString()));
            jsonObject.add("currentBidder", new JsonPrimitive(ezey2._k));
            jsonObject.add("currentBid", new JsonPrimitive(ezey2._l));
            return jsonObject;
        }

        @Override
        public /* synthetic */ JsonElement serialize(Object object, Type type, JsonSerializationContext jsonSerializationContext) {
            return this._a((ezey)object, type, jsonSerializationContext);
        }
    }
}

