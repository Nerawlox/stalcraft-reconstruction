/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bkc
 *  bkf
 *  bks
 *  com.google.common.collect.Sets
 *  com.google.gson.JsonDeserializationContext
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParseException
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import com.google.common.collect.Sets;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

@SideOnly(value=Side.CLIENT)
public class bkt
extends bkf {
    public bks a(JsonElement par1JsonElement, Type par2Type, JsonDeserializationContext par3JsonDeserializationContext) {
        boolean flag;
        String s2;
        String s1;
        String s3;
        JsonObject jsonobject = par1JsonElement.getAsJsonObject();
        HashSet hashset = Sets.newHashSet();
        Iterator iterator = jsonobject.entrySet().iterator();
        do {
            if (!iterator.hasNext()) {
                return new bks((Collection)hashset);
            }
            Map.Entry entry = (Map.Entry)iterator.next();
            s3 = (String)entry.getKey();
            JsonElement jsonelement1 = (JsonElement)entry.getValue();
            if (!jsonelement1.isJsonObject()) {
                throw new JsonParseException("Invalid language->'" + s3 + "': expected object, was " + jsonelement1);
            }
            JsonObject jsonobject1 = jsonelement1.getAsJsonObject();
            s1 = this.a(jsonobject1.get("region"), "region", "", 0, Integer.MAX_VALUE);
            s2 = this.a(jsonobject1.get("name"), "name", "", 0, Integer.MAX_VALUE);
            flag = this.a(jsonobject1.get("bidirectional"), "bidirectional", false);
            if (s1.isEmpty()) {
                throw new JsonParseException("Invalid language->'" + s3 + "'->region: empty value");
            }
            if (!s2.isEmpty()) continue;
            throw new JsonParseException("Invalid language->'" + s3 + "'->name: empty value");
        } while (hashset.add(new bkc(s3, s1, s2, flag)));
        throw new JsonParseException("Duplicate language->'" + s3 + "' defined");
    }

    public String a() {
        return "language";
    }

    public Object deserialize(JsonElement par1JsonElement, Type par2Type, JsonDeserializationContext par3JsonDeserializationContext) {
        return this.a(par1JsonElement, par2Type, par3JsonDeserializationContext);
    }
}

