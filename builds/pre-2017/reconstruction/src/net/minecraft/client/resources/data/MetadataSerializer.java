/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import net.minecraft.client.resources.data.MetadataSection;

public class MetadataSerializer {
    public final zhqu _a = new xsly();
    public final GsonBuilder _b = new GsonBuilder();
    public Gson _c;

    public void _a(ujad ujad2, Class clazz) {
        this._a._a(ujad2._a(), new jjal(this, ujad2, clazz, null));
        this._b.registerTypeAdapter(clazz, ujad2);
        this._c = null;
    }

    public MetadataSection _a(String string, JsonObject jsonObject) {
        if (string == null) {
            throw new IllegalArgumentException("Metadata section name cannot be null");
        }
        if (!jsonObject.has(string)) {
            return null;
        }
        if (!jsonObject.get(string).isJsonObject()) {
            throw new IllegalArgumentException("Invalid metadata for '" + string + "' - expected object, found " + jsonObject.get(string));
        }
        jjal jjal2 = (jjal)this._a._a(string);
        if (jjal2 == null) {
            throw new IllegalArgumentException("Don't know how to handle metadata section '" + string + "'");
        }
        return (MetadataSection)this._a().fromJson((JsonElement)jsonObject.getAsJsonObject(string), (Type)jjal2._b);
    }

    public Gson _a() {
        if (this._c == null) {
            this._c = this._b.create();
        }
        return this._c;
    }
}

