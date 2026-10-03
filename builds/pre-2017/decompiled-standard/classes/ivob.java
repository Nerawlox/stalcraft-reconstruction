/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;

public class ivob
extends aphd {
    public tvoe _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        boolean bl = this._a(jsonObject.get("blur"), "blur", Boolean.FALSE);
        boolean bl2 = this._a(jsonObject.get("clamp"), "clamp", Boolean.FALSE);
        boolean bl3 = this._a(jsonObject.get("mipmap"), "mipmap", Boolean.FALSE);
        boolean bl4 = this._a(jsonObject.get("mipmap_blur"), "mipmap_blur", Boolean.FALSE);
        boolean bl5 = this._a(jsonObject.get("premultiplied_alpha"), "premultiplied_alpha", Boolean.FALSE);
        int n = this._a(jsonObject.get("anisotropy"), "anisotropy", 1, 1, 16);
        return new tvoe(bl, bl2, bl3, bl4, bl5, n);
    }

    @Override
    public String _a() {
        return "texture";
    }

    public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }
}

