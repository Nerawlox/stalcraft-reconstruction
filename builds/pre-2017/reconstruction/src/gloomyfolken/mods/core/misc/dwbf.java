/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import net.minecraft.item.ItemStack;

public class dwbf
implements JsonSerializer<ItemStack> {
    private static hrwc _a = new hrwc();

    public JsonElement _a(ItemStack itemStack, Type type, JsonSerializationContext jsonSerializationContext) {
        return _a._a(new wnce(itemStack), type, jsonSerializationContext);
    }

    @Override
    public /* synthetic */ JsonElement serialize(Object object, Type type, JsonSerializationContext jsonSerializationContext) {
        return this._a((ItemStack)object, type, jsonSerializationContext);
    }
}

