/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import net.minecraft.nbt.NBTTagCompound;

public class iuyn
extends hrvl {
    public final gotk _a;

    public iuyn(String string, hrvl hrvl2) {
        this(new gotk(string, hrvl2._b), hrvl2._c);
    }

    public iuyn(gotk gotk2, satm satm2) {
        super(gotk2, satm2);
        this._a = gotk2;
    }

    public iuyn(gotk gotk2) {
        this(gotk2, satm._a);
    }

    public iuyn(String string, int n, double d, double d2, double d3, float f, float f2) {
        this(new gotk(string, n, d, d2, d3), new satm(f, f2));
    }

    public iuyn(NBTTagCompound nBTTagCompound) {
        this(new gotk(nBTTagCompound._m("loc")), new satm(nBTTagCompound._m("rot")));
    }

    @Override
    public String toString() {
        return "GlobalPosition{loc=" + this._a + ", rot=" + this._c + '}';
    }

    static class kjui
    implements JsonDeserializer<iuyn> {
        kjui() {
        }

        public iuyn _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            gotk gotk2 = (gotk)jsonDeserializationContext.deserialize(jsonElement, (Type)((Object)gotk.class));
            satm satm2 = (satm)jsonDeserializationContext.deserialize(jsonElement, (Type)((Object)satm.class));
            return new iuyn(gotk2, satm2);
        }

        @Override
        public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return this._a(jsonElement, type, jsonDeserializationContext);
        }
    }
}

