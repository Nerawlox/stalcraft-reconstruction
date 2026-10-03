/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;

public class uysl
extends hsjl {
    public uysl() {
        super("textureCoordsIn", 4);
    }

    @Override
    public void _a(ncyh ncyh2, int n, float f) {
        ejaq ejaq2 = eidj._a._b;
        ejcz ejcz2 = ncyh2.getIcon(n);
        this._e.put(ejcz2.getMinU() + ejaq2._b());
        this._e.put(ejcz2.getMinV() + ejaq2._c());
        this._e.put(ejcz2.getMaxU() - ejaq2._b());
        this._e.put(ejcz2.getMaxV() - ejaq2._c());
    }
}

