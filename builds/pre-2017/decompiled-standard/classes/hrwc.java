/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class hrwc
implements JsonSerializer<wnce> {
    public JsonElement _a(wnce wnce2, Type type, JsonSerializationContext jsonSerializationContext) {
        if (wnce2 == null) {
            return JsonNull.INSTANCE;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("id", new JsonPrimitive(wnce2._c()));
        jsonObject.add("stackSize", new JsonPrimitive(wnce2._d()));
        jsonObject.add("itemDamage", new JsonPrimitive(wnce2._e()));
        if (wnce2._f() != null) {
            jsonObject.add("tag", jsonSerializationContext.serialize(wnce2._f()));
        }
        return jsonObject;
    }

    @Override
    public /* synthetic */ JsonElement serialize(Object object, Type type, JsonSerializationContext jsonSerializationContext) {
        return this._a((wnce)object, type, jsonSerializationContext);
    }
}

