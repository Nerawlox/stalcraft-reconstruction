/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class ncgb
implements JsonDeserializer<wnce> {
    public wnce _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        int n = jsonObject.get("id").getAsInt();
        if (n <= 0) {
            return null;
        }
        int n2 = jsonObject.has("stackSize") ? jsonObject.get("stackSize").getAsInt() : 1;
        int n3 = jsonObject.has("itemDamage") ? jsonObject.get("itemDamage").getAsInt() : 0;
        qoac qoac2 = null;
        if (jsonObject.has("tag")) {
            qoac2 = (qoac)jsonDeserializationContext.deserialize(jsonObject.get("tag"), (Type)((Object)qoac.class));
            qoac2._a("tag");
        }
        return new wnce(n, n2, n3, qoac2);
    }

    @Override
    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }
}

