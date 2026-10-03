/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.util.dwan;
import org.lwjgl.opengl.GL11;

public class ytzy {
    public static int _a = -1;
    private xpzm _b = xpzm._E();
    private htvf _c = htvf.field_78398_a;
    private cekh _d = cekh._b;
    private ArrayList<kjui> _e = new ArrayList();
    private HashSet<Integer> _f = new HashSet();
    private int _g;
    private static final int _h = (int)Math.pow(2.0, 18.0) - 1;

    public void _a(List<xqwz> list, float f) {
        xpzm._E().__ah._a("customlights");
        GL11.glPushMatrix();
        htvf htvf2 = htvf.field_78398_a;
        this._b._D.func_78483_a(f);
        double d = this._b._u.field_70142_S + (this._b._u.field_70165_t - this._b._u.field_70142_S) * (double)f;
        double d2 = this._b._u.field_70137_T + (this._b._u.field_70163_u - this._b._u.field_70137_T) * (double)f;
        double d3 = this._b._u.field_70136_U + (this._b._u.field_70161_v - this._b._u.field_70136_U) * (double)f;
        htvf2.func_78373_b(-d, -d2, -d3);
        for (xqwz xqwz2 : list) {
            if (this._b._u.func_70092_e(xqwz2._b, xqwz2._c, xqwz2._d) > (double)eidj._a._j || !eidj._a._r._a(xqwz2._n)) continue;
            this._b._h._a(sctd._c);
            GL11.glEnable(3042);
            xqwz2._c();
            GL11.glDisable(3008);
            GL11.glPolygonOffset(-3.0f, -3.0f);
            GL11.glEnable(32823);
            GL11.glEnable(3008);
            for (int i = 0; i < xqwz2._j; ++i) {
                this._g = xqwz2._i[i];
                byte by = (byte)(this._g >> 18 & 0x3F);
                int n = xqwz2._e + (this._g >> 12 & 0x3F);
                int n2 = xqwz2._f + (this._g >> 6 & 0x3F);
                int n3 = xqwz2._g + (this._g & 0x3F);
                xqwz2._a((int)by);
                for (int j = 0; j < 7; ++j) {
                    if ((this._g >> 24 + j & 1) != 1) continue;
                    this._a(xqwz2._a, n, n2, n3, j);
                }
            }
            GL11.glDisable(3008);
            GL11.glPolygonOffset(0.0f, 0.0f);
            GL11.glDisable(32823);
            GL11.glEnable(3008);
            this._f.clear();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
        htvf2.func_78373_b(0.0, 0.0, 0.0);
        GL11.glPopMatrix();
        xpzm._E().__ah._b();
    }

    private void _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        this._c.func_78382_b();
        this._c.func_78383_c();
        boolean bl = false;
        if (n4 == 0) {
            int n5 = this._g & _h;
            if (this._f.contains(n5)) {
                ivms._a._a();
                bl = true;
            } else {
                this._f.add(n5);
            }
            twgu twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(n, n2, n3)];
            if (twgu2 != null) {
                this._b._s._s._a(twgu2, n, n2, n3, (dwan)null);
            }
            if (bl) {
                ivms._a._b();
            }
        } else {
            switch (n4) {
                case 1: {
                    --n2;
                    break;
                }
                case 2: {
                    ++n2;
                    break;
                }
                case 3: {
                    ++n3;
                    break;
                }
                case 4: {
                    --n3;
                    break;
                }
                case 5: {
                    ++n;
                    break;
                }
                case 6: {
                    --n;
                }
            }
            twgu twgu3 = twgu.field_71973_m[ozlu2.func_72798_a(n, n2, n3)];
            if (twgu3 == null) {
                twgu3 = twgu.field_71981_t;
            }
            if (--n4 == 0) {
                n4 = 1;
            } else if (n4 == 1) {
                n4 = 0;
            }
            _a = n4;
            int n6 = this._g & _h;
            if (this._f.contains(n6)) {
                ivms._a._a();
                bl = true;
            } else {
                this._f.add(n6);
            }
            this._b._s._s._a(twgu3, n, n2, n3, (dwan)null);
            if (bl) {
                ivms._a._b();
            }
            _a = -1;
        }
        this._c.field_78414_p = false;
        this._c.func_78381_a();
    }

    private class kjui {
        public final hurg _a;
        public final xqwz _b;
        public final byte _c;

        public kjui(hurg hurg2, xqwz xqwz2, byte by) {
            this._a = hurg2;
            this._b = xqwz2;
            this._c = by;
        }
    }
}

