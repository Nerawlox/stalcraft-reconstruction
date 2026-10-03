/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Map;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

public class anbv
implements JsonSerializer<NBTTagCompound> {
    public JsonElement _a(NBTTagCompound nBTTagCompound, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonNull jsonNull = nBTTagCompound == null ? JsonNull.INSTANCE : this._a(nBTTagCompound);
        return jsonNull;
    }

    private JsonElement _a(String string, NBTBase nBTBase) {
        if ("compound".equals(string)) {
            return this._a((NBTTagCompound)nBTBase);
        }
        if ("list".equals(string)) {
            return this._a((NBTTagList)nBTBase);
        }
        if ("string".equals(string)) {
            return this._a((NBTTagString)nBTBase);
        }
        if ("integer".equals(string)) {
            return this._a(((hdfw)nBTBase)._c);
        }
        if ("long".equals(string)) {
            return this._a(((grhp)nBTBase)._c);
        }
        if ("short".equals(string)) {
            return this._a(((ixnt)nBTBase)._c);
        }
        if ("byte".equals(string)) {
            return this._a(((xsub)nBTBase)._c);
        }
        if ("double".equals(string)) {
            return this._a(((qoae)nBTBase)._c);
        }
        if ("float".equals(string)) {
            return this._a(Float.valueOf(((jjly)nBTBase)._c));
        }
        if ("integer[]".equals(string)) {
            return this._a((qoak)nBTBase);
        }
        if ("byte[]".equals(string)) {
            return this._a((yvxd)nBTBase);
        }
        return null;
    }

    private JsonElement _a(NBTTagCompound nBTTagCompound) {
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry entry : nBTTagCompound._c.entrySet()) {
            String string = this._a((NBTBase)entry.getValue());
            JsonElement jsonElement = this._a(string, (NBTBase)entry.getValue());
            jsonObject.add((String)entry.getKey(), this._a(string, jsonElement));
        }
        return jsonObject;
    }

    private JsonElement _a(NBTTagList nBTTagList) {
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTBase nBTBase = nBTTagList._b(i);
            String string = this._a(nBTBase);
            JsonElement jsonElement = this._a(string, nBTBase);
            jsonArray.add(this._a(string, jsonElement));
        }
        return jsonArray;
    }

    private JsonElement _a(String string, JsonElement jsonElement) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("type", new JsonPrimitive(string));
        jsonObject.add("value", jsonElement);
        return jsonObject;
    }

    private JsonElement _a(NBTTagString nBTTagString) {
        return new JsonPrimitive(nBTTagString._c);
    }

    private JsonElement _a(Number number) {
        return new JsonPrimitive(number);
    }

    private JsonElement _a(qoak qoak2) {
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < qoak2._c.length; ++i) {
            jsonArray.add(this._a(qoak2._c[i]));
        }
        return jsonArray;
    }

    private JsonElement _a(yvxd yvxd2) {
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < yvxd2._c.length; ++i) {
            jsonArray.add(this._a(yvxd2._c[i]));
        }
        return jsonArray;
    }

    private String _a(NBTBase nBTBase) {
        if (nBTBase instanceof NBTTagCompound) {
            return "compound";
        }
        if (nBTBase instanceof NBTTagList) {
            return "list";
        }
        if (nBTBase instanceof NBTTagString) {
            return "string";
        }
        if (nBTBase instanceof hdfw) {
            return "integer";
        }
        if (nBTBase instanceof grhp) {
            return "long";
        }
        if (nBTBase instanceof ixnt) {
            return "short";
        }
        if (nBTBase instanceof xsub) {
            return "byte";
        }
        if (nBTBase instanceof qoae) {
            return "double";
        }
        if (nBTBase instanceof jjly) {
            return "float";
        }
        if (nBTBase instanceof qoak) {
            return "integer[]";
        }
        if (nBTBase instanceof yvxd) {
            return "byte[]";
        }
        return null;
    }

    @Override
    public /* synthetic */ JsonElement serialize(Object object, Type type, JsonSerializationContext jsonSerializationContext) {
        return this._a((NBTTagCompound)object, type, jsonSerializationContext);
    }
}

