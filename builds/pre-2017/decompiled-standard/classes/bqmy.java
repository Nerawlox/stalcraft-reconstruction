/*
 * Decompiled with CFR 0.152.
 */
import org.lwjgl.opengl.GL11;

public class bqmy
extends xqwz {
    private wnhj _o;
    private static final byte _p = 12;

    public bqmy(wnhj wnhj2) {
        super(wnhj2.field_70331_k, wnhj2.field_70329_l, wnhj2.field_70330_m, wnhj2.field_70327_n, (byte)12);
        this._o = wnhj2;
    }

    @Override
    public void _a(int n) {
        float f = 0.0f;
        int n2 = this._o._c - this._o._e;
        f = n2 < 3 ? 0.33f * (float)n2 : (n2 < 9 ? 1.0f : (n2 > 8 && n2 < 20 ? (float)(20 - n2) / 12.0f : 0.0f));
        GL11.glColor4f(0.4f, 0.4f, 1.0f, (float)n / 12.0f * f);
    }

    @Override
    public boolean _a() {
        return this._o._e + 20 > this._o._c && !this._o.func_70320_p();
    }
}

