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

public class dxrn
implements JsonDeserializer<pjrz.pidb> {
    public pjrz.pidb _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
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
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        if (jsonObject.has("offset")) {
            JsonArray jsonArray = jsonObject.get("offset").getAsJsonArray();
            f4 = jsonArray.get(0).getAsFloat();
            f5 = jsonArray.get(1).getAsFloat();
            f6 = jsonArray.get(2).getAsFloat();
        }
        return new pjrz.pidb(f, f2, f3, f4, f5, f6);
    }

    @Override
    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }
}

