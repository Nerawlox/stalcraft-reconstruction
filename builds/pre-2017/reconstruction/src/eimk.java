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
import java.util.ArrayList;

public class eimk
implements JsonDeserializer<flpm> {
    public flpm _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement.isJsonArray()) {
            ArrayList<pzne> arrayList = new ArrayList<pzne>();
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (JsonElement jsonElement2 : jsonArray) {
                pzne pzne2 = (pzne)jsonDeserializationContext.deserialize(jsonElement2, (Type)((Object)pzne.class));
                arrayList.add(pzne2);
            }
            return new flpm("Legacy group", arrayList, 1.0f);
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        ArrayList<pzne> arrayList = new ArrayList<pzne>();
        JsonArray jsonArray = jsonObject.get("entryList").getAsJsonArray();
        for (JsonElement jsonElement3 : jsonArray) {
            pzne pzne3 = (pzne)jsonDeserializationContext.deserialize(jsonElement3, (Type)((Object)pzne.class));
            arrayList.add(pzne3);
        }
        String string = jsonObject.has("name") ? jsonObject.get("name").getAsString() : "Unnamed group";
        float f = jsonObject.has("dropProbability") ? jsonObject.get("dropProbability").getAsFloat() : 1.0f;
        return new flpm(string, arrayList, f);
    }

    @Override
    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }
}

