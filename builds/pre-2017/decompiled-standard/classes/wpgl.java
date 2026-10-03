/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class wpgl
extends aphd {
    public oyqc _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        float[] fArray = new float[256];
        float[] fArray2 = new float[256];
        float[] fArray3 = new float[256];
        float f = 1.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        if (jsonObject.has("characters")) {
            if (!jsonObject.get("characters").isJsonObject()) {
                throw new JsonParseException("Invalid font->characters: expected object, was " + jsonObject.get("characters"));
            }
            JsonObject jsonObject2 = jsonObject.getAsJsonObject("characters");
            if (jsonObject2.has("default")) {
                if (!jsonObject2.get("default").isJsonObject()) {
                    throw new JsonParseException("Invalid font->characters->default: expected object, was " + jsonObject2.get("default"));
                }
                JsonObject jsonObject3 = jsonObject2.getAsJsonObject("default");
                f = this._a(jsonObject3.get("width"), "characters->default->width", Float.valueOf(f), 0.0f, 2.14748365E9f);
                f2 = this._a(jsonObject3.get("spacing"), "characters->default->spacing", Float.valueOf(f2), 0.0f, 2.14748365E9f);
                f3 = this._a(jsonObject3.get("left"), "characters->default->left", Float.valueOf(f3), 0.0f, 2.14748365E9f);
            }
            for (int i = 0; i < 256; ++i) {
                JsonElement jsonElement2 = jsonObject2.get(Integer.toString(i));
                float f4 = f;
                float f5 = f2;
                float f6 = f3;
                if (jsonElement2 != null) {
                    if (jsonElement2.isJsonObject()) {
                        JsonObject jsonObject4 = jsonElement2.getAsJsonObject();
                        f4 = this._a(jsonObject4.get("width"), "characters->" + i + "->width", Float.valueOf(f4), 0.0f, 2.14748365E9f);
                        f5 = this._a(jsonObject4.get("spacing"), "characters->" + i + "->spacing", Float.valueOf(f5), 0.0f, 2.14748365E9f);
                        f6 = this._a(jsonObject4.get("left"), "characters->" + i + "->left", Float.valueOf(f6), 0.0f, 2.14748365E9f);
                    } else {
                        throw new JsonParseException("Invalid font->characters->" + i + ": expected object, was " + jsonElement2);
                    }
                }
                fArray[i] = f4;
                fArray2[i] = f5;
                fArray3[i] = f6;
            }
        }
        return new oyqc(fArray, fArray3, fArray2);
    }

    @Override
    public String _a() {
        return "font";
    }

    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }
}

