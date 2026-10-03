/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bkf
 *  bku
 *  com.google.gson.JsonDeserializationContext
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonSerializationContext
 *  com.google.gson.JsonSerializer
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.lang.reflect.Type;

@SideOnly(value=Side.CLIENT)
public class bkv
extends bkf
implements JsonSerializer {
    public bku a(JsonElement par1JsonElement, Type par2Type, JsonDeserializationContext par3JsonDeserializationContext) {
        JsonObject jsonobject = par1JsonElement.getAsJsonObject();
        String s2 = this.a(jsonobject.get("description"), "description", null, 1, Integer.MAX_VALUE);
        int i2 = this.a(jsonobject.get("pack_format"), "pack_format", null, 1, Integer.MAX_VALUE);
        return new bku(s2, i2);
    }

    public JsonElement a(bku par1PackMetadataSection, Type par2Type, JsonSerializationContext par3JsonSerializationContext) {
        JsonObject jsonobject = new JsonObject();
        jsonobject.addProperty("pack_format", (Number)par1PackMetadataSection.b());
        jsonobject.addProperty("description", par1PackMetadataSection.a());
        return jsonobject;
    }

    public String a() {
        return "pack";
    }

    public Object deserialize(JsonElement par1JsonElement, Type par2Type, JsonDeserializationContext par3JsonDeserializationContext) {
        return this.a(par1JsonElement, par2Type, par3JsonDeserializationContext);
    }

    public JsonElement serialize(Object par1Obj, Type par2Type, JsonSerializationContext par3JsonSerializationContext) {
        return this.a((bku)par1Obj, par2Type, par3JsonSerializationContext);
    }
}

