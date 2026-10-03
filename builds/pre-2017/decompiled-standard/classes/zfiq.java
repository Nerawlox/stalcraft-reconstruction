/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class zfiq
implements JsonDeserializer<satl> {
    public satl _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        satl satl2 = new satl();
        JsonArray jsonArray = (jsonElement.isJsonArray() ? jsonElement : jsonElement.getAsJsonObject().get("groups")).getAsJsonArray();
        for (JsonElement jsonElement2 : jsonArray) {
            flpm flpm2 = (flpm)jsonDeserializationContext.deserialize(jsonElement2, (Type)((Object)flpm.class));
            satl2._a.add(flpm2);
        }
        return satl2;
    }

    @Override
    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }
}

