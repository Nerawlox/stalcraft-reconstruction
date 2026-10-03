/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class oxtf
extends mrnb {
    protected xrox _b(rpaa rpaa2, int n, String string, String string2, List<String> list2) {
        String string3 = this._a(rpaa2, "shoot_sound", "weapons");
        String string4 = this._a(rpaa2, "reload_sound", "weapons");
        String string5 = this._a(rpaa2, "enable_sound", "weapons");
        String string6 = this._a(rpaa2, "disable_sound", "weapons");
        int[] nArray = rpaa2._f("grenades_id");
        int n2 = rpaa2._g("cooldown");
        int n3 = rpaa2._g("reload");
        return new xrox(n, string, string2, list2, string3, string4, string5, string6, nArray, n2, n3);
    }

    @Override
    public String _a() {
        return "launcher";
    }

    protected /* synthetic */ dxwc _a(rpaa rpaa2, int n, String string, String string2, List list2) {
        return this._b(rpaa2, n, string, string2, list2);
    }
}

