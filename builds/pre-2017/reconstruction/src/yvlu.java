/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import net.minecraft.client.resources.data.BaseMetadataSectionSerializer;

public class yvlu
extends BaseMetadataSectionSerializer
implements JsonSerializer {
    public yekc _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String string = this._a(jsonObject.get("description"), "description", (String)null, 1, Integer.MAX_VALUE);
        int n = this._a(jsonObject.get("pack_format"), "pack_format", (Integer)null, 1, Integer.MAX_VALUE);
        return new yekc(string, n);
    }

    public JsonElement _a(yekc yekc2, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("pack_format", yekc2._b());
        jsonObject.addProperty("description", yekc2._a());
        return jsonObject;
    }

    @Override
    public String _a() {
        return "pack";
    }

    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }

    public /* synthetic */ JsonElement serialize(Object object, Type type, JsonSerializationContext jsonSerializationContext) {
        return this._a((yekc)object, type, jsonSerializationContext);
    }
}

