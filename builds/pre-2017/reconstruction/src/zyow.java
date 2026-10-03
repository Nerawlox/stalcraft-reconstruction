/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import net.minecraft.client.resources.data.BaseMetadataSectionSerializer;

public class zyow
extends BaseMetadataSectionSerializer {
    public dyqm _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        boolean bl = this._a(jsonObject.get("blur"), "blur", false);
        boolean bl2 = this._a(jsonObject.get("clamp"), "clamp", false);
        return new dyqm(bl, bl2);
    }

    @Override
    public String _a() {
        return "texture";
    }

    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }
}

