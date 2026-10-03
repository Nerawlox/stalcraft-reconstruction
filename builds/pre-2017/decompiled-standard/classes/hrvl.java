/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.lang.reflect.Type;
import net.minecraft.entity.Entity;

public class hrvl {
    public final einh _b;
    public final satm _c;

    public hrvl(einh einh2, satm satm2) {
        this._b = einh2;
        this._c = satm2;
    }

    public hrvl(int n, double d, double d2, double d3, float f, float f2) {
        this(new einh(n, d, d2, d3), new satm(f, f2));
    }

    public hrvl(einh einh2) {
        this(einh2, satm._a);
    }

    public hrvl(qoac qoac2) {
        this(new einh(qoac2._m("loc")), new satm(qoac2._m("rot")));
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public hrvl(Entity entity) {
        this(new einh(entity), new satm(entity));
    }

    public qoac _a() {
        qoac qoac2 = new qoac();
        qoac2._a("loc", (huhy)this._b._a());
        qoac2._a("rot", (huhy)this._c._a());
        return qoac2;
    }

    public String toString() {
        return "LocalPosition{loc=" + this._b + ", rot=" + this._c + '}';
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        hrvl hrvl2 = (hrvl)object;
        if (this._b != null ? !this._b.equals(hrvl2._b) : hrvl2._b != null) {
            return false;
        }
        return this._c != null ? this._c.equals(hrvl2._c) : hrvl2._c == null;
    }

    public int hashCode() {
        int n = this._b != null ? this._b.hashCode() : 0;
        n = 31 * n + (this._c != null ? this._c.hashCode() : 0);
        return n;
    }

    static class kjui
    implements JsonDeserializer<hrvl> {
        kjui() {
        }

        public hrvl _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            einh einh2 = (einh)jsonDeserializationContext.deserialize(jsonElement, (Type)((Object)einh.class));
            satm satm2 = (satm)jsonDeserializationContext.deserialize(jsonElement, (Type)((Object)satm.class));
            return new hrvl(einh2, satm2);
        }

        @Override
        public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return this._a(jsonElement, type, jsonDeserializationContext);
        }
    }
}

