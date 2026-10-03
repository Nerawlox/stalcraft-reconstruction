/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class uzcj
implements JsonDeserializer<pjrz.kjui> {
    public pjrz.kjui _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        if (jsonObject.has("rotation")) {
            JsonArray jsonArray = jsonObject.get("rotation").getAsJsonArray();
            f = jsonArray.get(0).getAsFloat();
            f2 = jsonArray.get(1).getAsFloat();
            f3 = jsonArray.get(2).getAsFloat();
        }
        float f4 = 1.0f;
        if (jsonObject.has("scale")) {
            f4 = jsonObject.get("scale").getAsFloat();
        }
        return new pjrz.kjui(f, f2, f3, f4);
    }

    @Override
    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }
}

