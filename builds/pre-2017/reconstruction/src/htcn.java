/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import gloomyfolken.mods.core.misc.tdpx;
import java.util.HashMap;
import net.minecraft.util.ResourceLocation;

public class htcn {
    private static final ResourceLocation _f = new ResourceLocation("weapons", "suppression.json");
    private static htcn _g;
    public final float _a;
    public final long _b;
    public final float _c;
    public final float _d;
    public final xafi _e;

    public htcn(float f, long l, float f2, float f3, xafi xafi2) {
        this._a = f;
        this._b = l;
        this._c = f2;
        this._d = f3;
        this._e = xafi2;
    }

    public static htcn _a() {
        if (_g == null) {
            htcn._b();
        }
        return _g;
    }

    private static void _b() {
        String string = tdpx._b(_f);
        Gson gson2 = new Gson();
        JsonObject jsonObject = new JsonParser().parse(string).getAsJsonObject();
        HashMap hashMap = (HashMap)gson2.fromJson(jsonObject.get("properties"), new TypeToken<HashMap<String, String>>(){}.getType());
        xafi xafi2 = cdjc._a(new rpaa(null, "", hashMap));
        float f = jsonObject.get("decay_factor").getAsFloat();
        long l = jsonObject.get("reset_delta_millis").getAsLong();
        float f2 = jsonObject.get("suppression_radius").getAsFloat();
        float f3 = jsonObject.get("wiggle").getAsFloat();
        _g = new htcn(f, l, f2, f3, xafi2);
    }
}

