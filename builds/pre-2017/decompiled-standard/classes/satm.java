/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.lang.reflect.Type;
import net.minecraft.entity.Entity;

public class satm {
    public static final satm _a = new satm(0.0f, 0.0f);
    public final float _b;
    public final float _c;

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public satm(Entity entity) {
        this._b = entity.field_70177_z;
        this._c = entity.field_70125_A;
    }

    public satm(qoac qoac2) {
        this._b = qoac2._h("yaw");
        this._c = qoac2._h("pitch");
    }

    public satm(float f, float f2) {
        this._b = f;
        this._c = f2;
    }

    public qoac _a() {
        qoac qoac2 = new qoac();
        qoac2._a("yaw", this._b);
        qoac2._a("pitch", this._c);
        return qoac2;
    }

    public String toString() {
        return "Orientation{yaw=" + this._b + ", pitch=" + this._c + '}';
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        satm satm2 = (satm)object;
        if (Float.compare(satm2._b, this._b) != 0) {
            return false;
        }
        return Float.compare(satm2._c, this._c) == 0;
    }

    public int hashCode() {
        int n = this._b != 0.0f ? Float.floatToIntBits(this._b) : 0;
        n = 31 * n + (this._c != 0.0f ? Float.floatToIntBits(this._c) : 0);
        return n;
    }

    static class kjui
    implements JsonDeserializer<satm> {
        kjui() {
        }

        public satm _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                return new satm(jsonObject.has("yaw") ? jsonObject.get("yaw").getAsFloat() : 0.0f, jsonObject.has("pitch") ? jsonObject.get("pitch").getAsFloat() : 0.0f);
            }
            return new satm(0.0f, 0.0f);
        }

        @Override
        public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return this._a(jsonElement, type, jsonDeserializationContext);
        }
    }
}

