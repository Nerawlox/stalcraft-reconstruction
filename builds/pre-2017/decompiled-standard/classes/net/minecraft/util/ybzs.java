/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.util.ezfc;
import net.minecraft.util.zwat;

public class ybzs
implements JsonDeserializer,
JsonSerializer {
    public zwat _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        Object object;
        zwat zwat2 = new zwat();
        JsonObject jsonObject = (JsonObject)jsonElement;
        JsonElement jsonElement2 = jsonObject.get("text");
        JsonElement jsonElement3 = jsonObject.get("translate");
        JsonElement jsonElement4 = jsonObject.get("color");
        JsonElement jsonElement5 = jsonObject.get("bold");
        JsonElement jsonElement6 = jsonObject.get("italic");
        JsonElement jsonElement7 = jsonObject.get("underlined");
        JsonElement jsonElement8 = jsonObject.get("obfuscated");
        if (jsonElement4 != null && jsonElement4.isJsonPrimitive()) {
            object = ezfc._b(jsonElement4.getAsString());
            if (object == null || !object._c()) {
                throw new JsonParseException("Given color (" + jsonElement4.getAsString() + ") is not a valid selection");
            }
            zwat2._a((ezfc)((Object)object));
        }
        if (jsonElement5 != null && jsonElement5.isJsonPrimitive()) {
            zwat2._a((Boolean)jsonElement5.getAsBoolean());
        }
        if (jsonElement6 != null && jsonElement6.isJsonPrimitive()) {
            zwat2._b(jsonElement6.getAsBoolean());
        }
        if (jsonElement7 != null && jsonElement7.isJsonPrimitive()) {
            zwat2._c(jsonElement7.getAsBoolean());
        }
        if (jsonElement8 != null && jsonElement8.isJsonPrimitive()) {
            zwat2._d(jsonElement8.getAsBoolean());
        }
        if (jsonElement2 != null) {
            if (jsonElement2.isJsonArray()) {
                object = jsonElement2.getAsJsonArray();
                Iterator<JsonElement> iterator2 = ((JsonArray)object).iterator();
                while (iterator2.hasNext()) {
                    JsonElement jsonElement9 = iterator2.next();
                    if (jsonElement9.isJsonPrimitive()) {
                        zwat2._a(jsonElement9.getAsString());
                        continue;
                    }
                    if (!jsonElement9.isJsonObject()) continue;
                    zwat2._a(this._a(jsonElement9, type, jsonDeserializationContext));
                }
            } else if (jsonElement2.isJsonPrimitive()) {
                zwat2._a(jsonElement2.getAsString());
            }
        } else if (jsonElement3 != null && jsonElement3.isJsonPrimitive()) {
            object = jsonObject.get("using");
            if (object != null) {
                if (((JsonElement)object).isJsonArray()) {
                    ArrayList<Object> arrayList = Lists.newArrayList();
                    for (JsonElement jsonElement10 : ((JsonElement)object).getAsJsonArray()) {
                        if (jsonElement10.isJsonPrimitive()) {
                            arrayList.add(jsonElement10.getAsString());
                            continue;
                        }
                        if (!jsonElement10.isJsonObject()) continue;
                        arrayList.add(this._a(jsonElement10, type, jsonDeserializationContext));
                    }
                    zwat2._a(jsonElement3.getAsString(), arrayList.toArray());
                } else if (((JsonElement)object).isJsonPrimitive()) {
                    zwat2._a(jsonElement3.getAsString(), ((JsonElement)object).getAsString());
                }
            } else {
                zwat2._b(jsonElement3.getAsString());
            }
        }
        return zwat2;
    }

    public JsonElement _a(zwat zwat2, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        if (zwat2._a() != null) {
            jsonObject.addProperty("color", zwat2._a()._d());
        }
        if (zwat2._b() != null) {
            jsonObject.addProperty("bold", zwat2._b());
        }
        if (zwat2._c() != null) {
            jsonObject.addProperty("italic", zwat2._c());
        }
        if (zwat2._d() != null) {
            jsonObject.addProperty("underlined", zwat2._d());
        }
        if (zwat2._e() != null) {
            jsonObject.addProperty("obfuscated", zwat2._e());
        }
        if (zwat2._f() != null) {
            jsonObject.addProperty("text", zwat2._f());
        } else if (zwat2._g() != null) {
            jsonObject.addProperty("translate", zwat2._g());
            if (zwat2._h() != null && !zwat2._h().isEmpty()) {
                jsonObject.add("using", this._b(zwat2, type, jsonSerializationContext));
            }
        } else if (zwat2._h() != null && !zwat2._h().isEmpty()) {
            jsonObject.add("text", this._b(zwat2, type, jsonSerializationContext));
        }
        return jsonObject;
    }

    public JsonArray _b(zwat zwat2, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonArray jsonArray = new JsonArray();
        for (zwat zwat3 : zwat2._h()) {
            if (zwat3._f() != null) {
                jsonArray.add(new JsonPrimitive(zwat3._f()));
                continue;
            }
            jsonArray.add(this._a(zwat3, type, jsonSerializationContext));
        }
        return jsonArray;
    }

    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }

    public /* synthetic */ JsonElement serialize(Object object, Type type, JsonSerializationContext jsonSerializationContext) {
        return this._a((zwat)object, type, jsonSerializationContext);
    }
}

