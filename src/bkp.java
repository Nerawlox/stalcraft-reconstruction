/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bkf
 *  bkn
 *  bko
 *  com.google.common.collect.Lists
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonDeserializationContext
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParseException
 *  com.google.gson.JsonPrimitive
 *  com.google.gson.JsonSerializationContext
 *  com.google.gson.JsonSerializer
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SideOnly(value=Side.CLIENT)
public class bkp
extends bkf
implements JsonSerializer {
    public bko a(JsonElement par1JsonElement, Type par2Type, JsonDeserializationContext par3JsonDeserializationContext) {
        int j2;
        ArrayList arraylist = Lists.newArrayList();
        JsonObject jsonobject = (JsonObject)par1JsonElement;
        int i2 = this.a(jsonobject.get("frametime"), "frametime", 1, 1, Integer.MAX_VALUE);
        if (jsonobject.has("frames")) {
            try {
                JsonArray jsonarray = jsonobject.getAsJsonArray("frames");
                for (j2 = 0; j2 < jsonarray.size(); ++j2) {
                    JsonElement jsonelement1 = jsonarray.get(j2);
                    bkn animationframe = this.a(j2, jsonelement1);
                    if (animationframe == null) continue;
                    arraylist.add(animationframe);
                }
            }
            catch (ClassCastException classcastexception) {
                throw new JsonParseException("Invalid animation->frames: expected array, was " + jsonobject.get("frames"), (Throwable)classcastexception);
            }
        }
        int k = this.a(jsonobject.get("width"), "width", -1, 1, Integer.MAX_VALUE);
        j2 = this.a(jsonobject.get("height"), "height", -1, 1, Integer.MAX_VALUE);
        return new bko((List)arraylist, k, j2, i2);
    }

    private bkn a(int par1, JsonElement par2JsonElement) {
        if (par2JsonElement.isJsonPrimitive()) {
            try {
                return new bkn(par2JsonElement.getAsInt());
            }
            catch (NumberFormatException numberformatexception) {
                throw new JsonParseException("Invalid animation->frames->" + par1 + ": expected number, was " + par2JsonElement, (Throwable)numberformatexception);
            }
        }
        if (par2JsonElement.isJsonObject()) {
            JsonObject jsonobject = par2JsonElement.getAsJsonObject();
            int j2 = this.a(jsonobject.get("time"), "frames->" + par1 + "->time", -1, 1, Integer.MAX_VALUE);
            int k = this.a(jsonobject.get("index"), "frames->" + par1 + "->index", null, 0, Integer.MAX_VALUE);
            return new bkn(k, j2);
        }
        return null;
    }

    public JsonElement a(bko par1AnimationMetadataSection, Type par2Type, JsonSerializationContext par3JsonSerializationContext) {
        JsonObject jsonobject = new JsonObject();
        jsonobject.addProperty("frametime", (Number)par1AnimationMetadataSection.d());
        if (par1AnimationMetadataSection.b() != -1) {
            jsonobject.addProperty("width", (Number)par1AnimationMetadataSection.b());
        }
        if (par1AnimationMetadataSection.a() != -1) {
            jsonobject.addProperty("height", (Number)par1AnimationMetadataSection.a());
        }
        if (par1AnimationMetadataSection.c() > 0) {
            JsonArray jsonarray = new JsonArray();
            for (int i2 = 0; i2 < par1AnimationMetadataSection.c(); ++i2) {
                if (par1AnimationMetadataSection.b(i2)) {
                    JsonObject jsonobject1 = new JsonObject();
                    jsonobject1.addProperty("index", (Number)par1AnimationMetadataSection.c(i2));
                    jsonobject1.addProperty("time", (Number)par1AnimationMetadataSection.a(i2));
                    jsonarray.add((JsonElement)jsonobject1);
                    continue;
                }
                jsonarray.add((JsonElement)new JsonPrimitive((Number)par1AnimationMetadataSection.c(i2)));
            }
            jsonobject.add("frames", (JsonElement)jsonarray);
        }
        return jsonobject;
    }

    public String a() {
        return "animation";
    }

    public Object deserialize(JsonElement par1JsonElement, Type par2Type, JsonDeserializationContext par3JsonDeserializationContext) {
        return this.a(par1JsonElement, par2Type, par3JsonDeserializationContext);
    }

    public JsonElement serialize(Object par1Obj, Type par2Type, JsonSerializationContext par3JsonSerializationContext) {
        return this.a((bko)par1Obj, par2Type, par3JsonSerializationContext);
    }
}

