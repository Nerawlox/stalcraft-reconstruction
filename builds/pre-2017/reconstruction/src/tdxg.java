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
import java.util.Map;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

public class tdxg
implements JsonDeserializer<NBTTagCompound> {
    public NBTTagCompound _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return jsonElement.isJsonNull() ? null : this._b("", jsonElement);
    }

    private NBTBase _a(String string, JsonElement jsonElement) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String string2 = jsonObject.get("type").getAsString();
        JsonElement jsonElement2 = jsonObject.get("value");
        if (string2.equals("compound")) {
            return this._b(string, jsonElement2);
        }
        if (string2.equals("list")) {
            return this._c(string, jsonElement2);
        }
        if (string2.equals("string")) {
            return this._f(string, jsonElement2);
        }
        if (string2.equals("integer")) {
            return this._g(string, jsonElement2);
        }
        if (string2.equals("long")) {
            return this._i(string, jsonElement2);
        }
        if (string2.equals("short")) {
            return this._h(string, jsonElement2);
        }
        if (string2.equals("byte")) {
            return this._j(string, jsonElement2);
        }
        if (string2.equals("boolean")) {
            return this._m(string, jsonElement2);
        }
        if (string2.equals("double")) {
            return this._k(string, jsonElement2);
        }
        if (string2.equals("float")) {
            return this._l(string, jsonElement2);
        }
        if (string2.equals("integer[]")) {
            return this._e(string, jsonElement2);
        }
        if (string2.equals("byte[]")) {
            return this._d(string, jsonElement2);
        }
        throw new JsonParseException("Unknown NBT type: " + string2);
    }

    private NBTTagCompound _b(String string, JsonElement jsonElement) {
        NBTTagCompound nBTTagCompound = new NBTTagCompound(string);
        if (jsonElement != null && !jsonElement.isJsonNull()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                String string2 = entry.getKey();
                nBTTagCompound._a(string2, this._a(string2, entry.getValue()));
            }
        }
        return nBTTagCompound;
    }

    private NBTTagList _c(String string, JsonElement jsonElement) {
        NBTTagList nBTTagList = new NBTTagList(string);
        if (jsonElement != null && jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (JsonElement jsonElement2 : jsonArray) {
                nBTTagList._a(this._a("", jsonElement2));
            }
        }
        return nBTTagList;
    }

    private yvxd _d(String string, JsonElement jsonElement) {
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        byte[] byArray = new byte[jsonArray.size()];
        int n = 0;
        for (JsonElement jsonElement2 : jsonArray) {
            byArray[n++] = jsonElement2.getAsByte();
        }
        return new yvxd(string, byArray);
    }

    private qoak _e(String string, JsonElement jsonElement) {
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        int[] nArray = new int[jsonArray.size()];
        int n = 0;
        for (JsonElement jsonElement2 : jsonArray) {
            nArray[n++] = jsonElement2.getAsInt();
        }
        return new qoak(string, nArray);
    }

    private NBTTagString _f(String string, JsonElement jsonElement) {
        return new NBTTagString(string, jsonElement.getAsString());
    }

    private hdfw _g(String string, JsonElement jsonElement) {
        return new hdfw(string, jsonElement.getAsInt());
    }

    private ixnt _h(String string, JsonElement jsonElement) {
        return new ixnt(string, jsonElement.getAsShort());
    }

    private grhp _i(String string, JsonElement jsonElement) {
        return new grhp(string, jsonElement.getAsLong());
    }

    private xsub _j(String string, JsonElement jsonElement) {
        return new xsub(string, jsonElement.getAsByte());
    }

    private qoae _k(String string, JsonElement jsonElement) {
        return new qoae(string, jsonElement.getAsDouble());
    }

    private jjly _l(String string, JsonElement jsonElement) {
        return new jjly(string, jsonElement.getAsFloat());
    }

    private xsub _m(String string, JsonElement jsonElement) {
        return new xsub(string, (byte)(jsonElement.getAsBoolean() ? 1 : 0));
    }

    @Override
    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }
}

