/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import net.minecraft.item.ItemStack;

public class pzdf
implements JsonDeserializer<ItemStack> {
    private static ncgb _a = new ncgb();

    public ItemStack _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return _a._a(jsonElement, type, jsonDeserializationContext)._a();
    }

    @Override
    public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return this._a(jsonElement, type, jsonDeserializationContext);
    }
}

