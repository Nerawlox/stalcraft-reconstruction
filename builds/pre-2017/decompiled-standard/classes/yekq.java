/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Sets;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;

public class yekq
extends aphd {
    public bbim _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        HashSet<zhkm> hashSet = Sets.newHashSet();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String string = entry.getKey();
            JsonElement jsonElement2 = entry.getValue();
            if (!jsonElement2.isJsonObject()) {
                throw new JsonParseException("Invalid language->'" + string + "': expected object, was " + jsonElement2);
            }
            JsonObject jsonObject2 = jsonElement2.getAsJsonObject();
            String string2 = this._a(jsonObject2.get("region"), "region", "", 0, Integer.MAX_VALUE);
            String string3 = this._a(jsonObject2.get("name"), "name", "", 0, Integer.MAX_VALUE);
            boolean bl = this._a(jsonObject2.get("bidirectional"), "bidirectional", false);
            if (string2.isEmpty()) {
                throw new JsonParseException("Invalid language->'" + string + "'->region: empty value");
            }
            if (string3.isEmpty()) {
                throw new JsonParseException("Invalid language->'" + string + "'->name: empty value");
            }
            if (hashSet.add(new zhkm(string, string2, string3, bl))) continue;
            throw new JsonParseException("Duplicate language->'" + string + "' defined");
        }
        return new bbim(hashSet);
    }

    @Override
    public String _a() {
        return "language";
    }

    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }
}

