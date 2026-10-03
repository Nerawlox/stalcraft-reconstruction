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
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

public class MessageComponentSerializer
implements JsonDeserializer,
JsonSerializer {
    public ChatMessageComponent _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        Object object;
        ChatMessageComponent chatMessageComponent = new ChatMessageComponent();
        JsonObject jsonObject = (JsonObject)jsonElement;
        JsonElement jsonElement2 = jsonObject.get("text");
        JsonElement jsonElement3 = jsonObject.get("translate");
        JsonElement jsonElement4 = jsonObject.get("color");
        JsonElement jsonElement5 = jsonObject.get("bold");
        JsonElement jsonElement6 = jsonObject.get("italic");
        JsonElement jsonElement7 = jsonObject.get("underlined");
        JsonElement jsonElement8 = jsonObject.get("obfuscated");
        if (jsonElement4 != null && jsonElement4.isJsonPrimitive()) {
            object = EnumChatFormatting._b(jsonElement4.getAsString());
            if (object == null || !object._c()) {
                throw new JsonParseException("Given color (" + jsonElement4.getAsString() + ") is not a valid selection");
            }
            chatMessageComponent._a((EnumChatFormatting)((Object)object));
        }
        if (jsonElement5 != null && jsonElement5.isJsonPrimitive()) {
            chatMessageComponent._a((Boolean)jsonElement5.getAsBoolean());
        }
        if (jsonElement6 != null && jsonElement6.isJsonPrimitive()) {
            chatMessageComponent._b(jsonElement6.getAsBoolean());
        }
        if (jsonElement7 != null && jsonElement7.isJsonPrimitive()) {
            chatMessageComponent._c(jsonElement7.getAsBoolean());
        }
        if (jsonElement8 != null && jsonElement8.isJsonPrimitive()) {
            chatMessageComponent._d(jsonElement8.getAsBoolean());
        }
        if (jsonElement2 != null) {
            if (jsonElement2.isJsonArray()) {
                object = jsonElement2.getAsJsonArray();
                Iterator<JsonElement> iterator2 = ((JsonArray)object).iterator();
                while (iterator2.hasNext()) {
                    JsonElement jsonElement9 = iterator2.next();
                    if (jsonElement9.isJsonPrimitive()) {
                        chatMessageComponent._a(jsonElement9.getAsString());
                        continue;
                    }
                    if (!jsonElement9.isJsonObject()) continue;
                    chatMessageComponent._a(this._a(jsonElement9, type, jsonDeserializationContext));
                }
            } else if (jsonElement2.isJsonPrimitive()) {
                chatMessageComponent._a(jsonElement2.getAsString());
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
                    chatMessageComponent._a(jsonElement3.getAsString(), arrayList.toArray());
                } else if (((JsonElement)object).isJsonPrimitive()) {
                    chatMessageComponent._a(jsonElement3.getAsString(), ((JsonElement)object).getAsString());
                }
            } else {
                chatMessageComponent._b(jsonElement3.getAsString());
            }
        }
        return chatMessageComponent;
    }

    public JsonElement _a(ChatMessageComponent chatMessageComponent, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        if (chatMessageComponent._a() != null) {
            jsonObject.addProperty("color", chatMessageComponent._a()._d());
        }
        if (chatMessageComponent._b() != null) {
            jsonObject.addProperty("bold", chatMessageComponent._b());
        }
        if (chatMessageComponent._c() != null) {
            jsonObject.addProperty("italic", chatMessageComponent._c());
        }
        if (chatMessageComponent._d() != null) {
            jsonObject.addProperty("underlined", chatMessageComponent._d());
        }
        if (chatMessageComponent._e() != null) {
            jsonObject.addProperty("obfuscated", chatMessageComponent._e());
        }
        if (chatMessageComponent._f() != null) {
            jsonObject.addProperty("text", chatMessageComponent._f());
        } else if (chatMessageComponent._g() != null) {
            jsonObject.addProperty("translate", chatMessageComponent._g());
            if (chatMessageComponent._h() != null && !chatMessageComponent._h().isEmpty()) {
                jsonObject.add("using", this._b(chatMessageComponent, type, jsonSerializationContext));
            }
        } else if (chatMessageComponent._h() != null && !chatMessageComponent._h().isEmpty()) {
            jsonObject.add("text", this._b(chatMessageComponent, type, jsonSerializationContext));
        }
        return jsonObject;
    }

    public JsonArray _b(ChatMessageComponent chatMessageComponent, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonArray jsonArray = new JsonArray();
        for (ChatMessageComponent chatMessageComponent2 : chatMessageComponent._h()) {
            if (chatMessageComponent2._f() != null) {
                jsonArray.add(new JsonPrimitive(chatMessageComponent2._f()));
                continue;
            }
            jsonArray.add(this._a(chatMessageComponent2, type, jsonSerializationContext));
        }
        return jsonArray;
    }

    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }

    public /* synthetic */ JsonElement serialize(Object object, Type type, JsonSerializationContext jsonSerializationContext) {
        return this._a((ChatMessageComponent)object, type, jsonSerializationContext);
    }
}

