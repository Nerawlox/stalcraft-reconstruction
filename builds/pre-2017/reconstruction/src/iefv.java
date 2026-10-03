/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.vjta;
import gloomyfolken.mods.effects.client.mcsa.jxtc;
import gloomyfolken.mods.effects.client.mcsa.kjui;
import java.util.HashMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class iefv {
    private final kjui _a;
    public final jyth<jxtc> _d;
    protected HashMap<String, kjui> _e = new HashMap(2);
    protected final ResourceLocation _f;
    protected final ResourceLocation _g;
    protected final ResourceLocation _h;
    private String _b = "";

    public iefv(String string, String string2, String string3) {
        this(string + string2, string3 == null ? null : string + string3);
    }

    public iefv(String string, String string2, String string3, String string4) {
        this(string, string2, string3);
        this._b = string4;
    }

    public iefv(String string) {
        this(string, null);
    }

    public iefv(String string, String string2) {
        this(uyvo._a(string), string2 == null ? null : uyvo._a(string2));
    }

    public iefv(ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
        this._f = resourceLocation;
        if (resourceLocation2 == null) {
            resourceLocation2 = jhuw.getDefaultMaterialPath(resourceLocation);
        }
        this._g = resourceLocation2;
        this._d = jyth._a(resourceLocation);
        this._h = uyvo._b(resourceLocation2);
        this._a = new kjui(resourceLocation, resourceLocation2);
    }

    public kjui _b() {
        return this._a;
    }

    public kjui _a(String string) {
        if (string == null) {
            return this._a;
        }
        kjui kjui2 = this._e.get(string);
        if (kjui2 == null) {
            ResourceLocation resourceLocation = uyvo._a(this._h, string + this._b, "mcmtl");
            kjui2 = uyvo._d(resourceLocation) ? new kjui(this._a._a, jyth._a(resourceLocation)) : this._a;
            this._e.put(string, kjui2);
        }
        return kjui2;
    }

    public kjui _e(ItemStack itemStack) {
        if (itemStack != null && itemStack._a() instanceof vjta) {
            return this._a(((vjta)((Object)itemStack._a()))._i_(itemStack));
        }
        return this._a;
    }
}

