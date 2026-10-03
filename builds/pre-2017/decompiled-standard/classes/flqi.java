/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class flqi
implements JsonDeserializer<pzne> {
    public pzne _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        float f = jsonObject.has("weight") ? jsonObject.get("weight").getAsFloat() : 0.0f;
        JsonObject jsonObject2 = jsonObject.has("stack") ? jsonObject.get("stack").getAsJsonObject() : jsonObject;
        int n = jsonObject2.has("id") ? jsonObject2.get("id").getAsInt() : 0;
        int n2 = jsonObject2.has("stackSize") ? jsonObject2.get("stackSize").getAsInt() : 0;
        int n3 = jsonObject2.has("itemDamage") ? jsonObject2.get("itemDamage").getAsInt() : 0;
        qoac qoac2 = jsonObject2.has("tag") ? (qoac)jsonDeserializationContext.deserialize(jsonObject2.get("tag"), (Type)((Object)qoac.class)) : null;
        int n4 = jsonObject2.has("stackSizeVariance") ? jsonObject2.get("stackSizeVariance").getAsInt() : 0;
        return new pzne(n, n2, n3, qoac2, n4, f);
    }

    @Override
    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }
}

