/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anomaly;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.ResourceLocation;

public class kjui
extends ccsw {
    public float _a;
    public float _b;
    public float _c;
    public float _d;
    public float _e;
    public float _f;
    public String _g;
    public String _h;
    public String _i;
    public String _j;
    public String _k;
    public String _l;
    public String _m;
    public String _n;
    public String _o;
    public String _p;
    public static kjui _q;

    public kjui() {
        _q = this;
    }

    @Override
    protected void _a(anof anof2) {
        this._a = anof2._j("carousel_damage");
        this._b = anof2._j("electra_damage");
        this._c = anof2._j("kissel_damage");
        this._d = anof2._j("coach_damage");
        this._e = anof2._j("steam_damage");
        this._f = anof2._j("trampoline_damage");
        this._g = anof2._h("blackhole_drop");
        this._h = anof2._h("carousel_drop");
        this._i = anof2._h("coach_drop");
        this._j = anof2._h("electra_drop");
        this._k = anof2._h("kissel_drop");
        this._l = anof2._h("lighter_drop");
        this._m = anof2._h("steam_drop");
        this._n = anof2._h("trampoline_drop");
        this._o = anof2._h("circus_drop");
        this._p = anof2._h("teleport_drop");
    }

    @Override
    protected List<ResourceLocation> _a() {
        ArrayList<ResourceLocation> arrayList = new ArrayList<ResourceLocation>();
        ResourceLocation resourceLocation = new ResourceLocation("anomalies", "anomaly_config.txt");
        arrayList.add(resourceLocation);
        return arrayList;
    }
}

