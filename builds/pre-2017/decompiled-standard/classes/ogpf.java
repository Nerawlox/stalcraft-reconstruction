/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class ogpf
implements JsonDeserializer<mrkk> {
    public mrkk _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray jsonArray = jsonElement.getAsJsonObject().get("frames").getAsJsonArray();
        pjrz[] pjrzArray = new pjrz[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); ++i) {
            pjrz pjrz2;
            JsonElement jsonElement2 = jsonArray.get(i);
            pjrzArray[i] = pjrz2 = (pjrz)jsonDeserializationContext.deserialize(jsonElement2, (Type)((Object)pjrz.class));
        }
        return new mrkk(pjrzArray);
    }

    @Override
    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }
}

