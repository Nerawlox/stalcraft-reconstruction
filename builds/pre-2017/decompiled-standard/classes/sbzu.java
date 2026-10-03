/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class sbzu
implements JsonDeserializer<pjrz> {
    public pjrz _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        float f = jsonObject.get("progress").getAsFloat();
        pjrz.kjui kjui2 = jsonObject.has("left_hand") ? (pjrz.kjui)jsonDeserializationContext.deserialize(jsonObject.get("left_hand"), (Type)((Object)pjrz.kjui.class)) : new pjrz.kjui();
        pjrz.kjui kjui3 = jsonObject.has("right_hand") ? (pjrz.kjui)jsonDeserializationContext.deserialize(jsonObject.get("right_hand"), (Type)((Object)pjrz.kjui.class)) : new pjrz.kjui();
        pjrz.pidb pidb2 = jsonObject.has("weapon") ? (pjrz.pidb)jsonDeserializationContext.deserialize(jsonObject.get("weapon"), (Type)((Object)pjrz.pidb.class)) : new pjrz.pidb();
        boolean bl = true;
        if (jsonObject.has("sine_interpolation")) {
            bl = jsonObject.get("sine_interpolation").getAsBoolean();
        }
        return new pjrz(kjui2, kjui3, pidb2, f, bl);
    }

    @Override
    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }
}

