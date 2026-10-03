/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import net.minecraft.nbt.NBTTagCompound;

public class ncgb
implements JsonDeserializer<wnce> {
    public wnce _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        int n = jsonObject.get("id").getAsInt();
        if (n <= 0) {
            return null;
        }
        int n2 = jsonObject.has("stackSize") ? jsonObject.get("stackSize").getAsInt() : 1;
        int n3 = jsonObject.has("itemDamage") ? jsonObject.get("itemDamage").getAsInt() : 0;
        NBTTagCompound nBTTagCompound = null;
        if (jsonObject.has("tag")) {
            nBTTagCompound = (NBTTagCompound)jsonDeserializationContext.deserialize(jsonObject.get("tag"), (Type)((Object)NBTTagCompound.class));
            nBTTagCompound._a("tag");
        }
        return new wnce(n, n2, n3, nBTTagCompound);
    }

    @Override
    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }
}

