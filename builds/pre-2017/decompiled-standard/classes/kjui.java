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
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class kjui {
    private static Gson _a = new GsonBuilder().registerTypeAdapter((Type)((Object)eidj.class), new pidb()).registerTypeAdapter((Type)((Object)eidj.class), new kjui()).create();

    public static String _a(eidj eidj2) {
        if (eidj2 == null) {
            return "";
        }
        return _a.toJson(eidj2);
    }

    public static eidj _a(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        return _a.fromJson(string, eidj.class);
    }

    static class kjui
    implements JsonDeserializer<eidj> {
        kjui() {
        }

        public eidj _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            eidj eidj2 = new eidj();
            String[] stringArray = new String[jsonObject.get("itemCount").getAsInt()];
            for (int i = 0; i < stringArray.length; ++i) {
                stringArray[i] = jsonObject.get("item_" + i).getAsJsonObject().toString();
            }
            eidj2._a(stringArray);
            eidj2._a(jsonObject.get("money").getAsLong());
            return eidj2;
        }

        @Override
        public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return this._a(jsonElement, type, jsonDeserializationContext);
        }
    }

    static class pidb
    implements JsonSerializer<eidj> {
        pidb() {
        }

        public JsonElement _a(eidj eidj2, Type type, JsonSerializationContext jsonSerializationContext) {
            if (eidj2 == null) {
                return JsonNull.INSTANCE;
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("money", new JsonPrimitive(eidj2._c()));
            jsonObject.add("itemCount", new JsonPrimitive(eidj2._b().length));
            Gson gson2 = new GsonBuilder().create();
            for (int i = 0; i < eidj2._b().length; ++i) {
                String string = eidj2._b()[i];
                jsonObject.add("item_" + i, new JsonParser().parse(string).getAsJsonObject());
            }
            return jsonObject;
        }

        @Override
        public /* synthetic */ JsonElement serialize(Object object, Type type, JsonSerializationContext jsonSerializationContext) {
            return this._a((eidj)object, type, jsonSerializationContext);
        }
    }
}

