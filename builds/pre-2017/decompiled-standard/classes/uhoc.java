/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import net.minecraft.util.ofbx;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class uhoc {
    public static final uhoc _a = new uhoc();
    public boolean _b = false;

    @ForgeSubscribe
    public void _a(MouseEvent mouseEvent) {
        if (!this._b || mouseEvent.button != 1 || !mouseEvent.buttonstate) {
            return;
        }
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._t == null || xpzm2._r == null) {
            return;
        }
        float f = 200.0f;
        float f2 = 0.2f;
        ofbx ofbx2 = xpzm2._t.func_70040_Z();
        for (float f3 = 0.0f; f3 < f; f3 += f2) {
            int n = (int)(ofbx2._c * (double)f3 + xpzm2._t.field_70165_t + 0.5);
            int n2 = (int)(ofbx2._d * (double)f3 + xpzm2._t.field_70163_u + 0.5);
            int n3 = (int)(ofbx2._e * (double)f3 + xpzm2._t.field_70161_v + 0.5);
            for (int i = n - 1; i < n + 1; ++i) {
                for (int j = n2 - 1; j < n2 + 1; ++j) {
                    for (int k = n3 - 1; k < n3 + 1; ++k) {
                        if (!this._a(i, j, k)) continue;
                        return;
                    }
                }
            }
        }
    }

    private boolean _a(int n, int n2, int n3) {
        pkix pkix2 = xpzm._E()._r;
        int n4 = pkix2.func_72798_a(n, n2, n3);
        if (twgu.field_71973_m[n4] instanceof uyqj) {
            new dxaa(pkix2.field_73011_w._i, n, n2, n3).sendToServer();
            return true;
        }
        return false;
    }
}

