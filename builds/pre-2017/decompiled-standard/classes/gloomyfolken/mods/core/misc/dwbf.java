/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class dwbf
implements JsonSerializer<cvzo> {
    private static hrwc _a = new hrwc();

    public JsonElement _a(cvzo cvzo2, Type type, JsonSerializationContext jsonSerializationContext) {
        return _a._a(new wnce(cvzo2), type, jsonSerializationContext);
    }

    @Override
    public /* synthetic */ JsonElement serialize(Object object, Type type, JsonSerializationContext jsonSerializationContext) {
        return this._a((cvzo)object, type, jsonSerializationContext);
    }
}

