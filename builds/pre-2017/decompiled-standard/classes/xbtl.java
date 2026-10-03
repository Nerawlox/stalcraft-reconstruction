/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import net.minecraft.entity.passive.EntitySheep;

public class xbtl
implements lpso {
    @Override
    public boolean func_77569_a(bsse bsse2, ozlu ozlu2) {
        cvzo cvzo2 = null;
        ArrayList<cvzo> arrayList = new ArrayList<cvzo>();
        for (int i = 0; i < bsse2.func_70302_i_(); ++i) {
            cvzo cvzo3 = bsse2.func_70301_a(i);
            if (cvzo3 == null) continue;
            if (cvzo3._a() instanceof lpno) {
                lpno lpno2 = (lpno)cvzo3._a();
                if (lpno2.func_82812_d() == yery._a && cvzo2 == null) {
                    cvzo2 = cvzo3;
                    continue;
                }
                return false;
            }
            if (cvzo3._d == tgdv.field_77756_aW.field_77779_bT) {
                arrayList.add(cvzo3);
                continue;
            }
            return false;
        }
        return cvzo2 != null && !arrayList.isEmpty();
    }

    @Override
    public cvzo func_77572_b(bsse bsse2) {
        float f;
        float f2;
        int n;
        int n2;
        cvzo cvzo2 = null;
        int[] nArray = new int[3];
        int n3 = 0;
        int n4 = 0;
        lpno lpno2 = null;
        for (n2 = 0; n2 < bsse2.func_70302_i_(); ++n2) {
            cvzo cvzo3 = bsse2.func_70301_a(n2);
            if (cvzo3 == null) continue;
            if (cvzo3._a() instanceof lpno) {
                lpno2 = (lpno)cvzo3._a();
                if (lpno2.func_82812_d() == yery._a && cvzo2 == null) {
                    cvzo2 = cvzo3._l();
                    cvzo2._b = 1;
                    if (!lpno2.func_82816_b_(cvzo3)) continue;
                    n = lpno2.func_82814_b(cvzo2);
                    f2 = (float)(n >> 16 & 0xFF) / 255.0f;
                    f = (float)(n >> 8 & 0xFF) / 255.0f;
                    float f3 = (float)(n & 0xFF) / 255.0f;
                    n3 = (int)((float)n3 + Math.max(f2, Math.max(f, f3)) * 255.0f);
                    nArray[0] = (int)((float)nArray[0] + f2 * 255.0f);
                    nArray[1] = (int)((float)nArray[1] + f * 255.0f);
                    nArray[2] = (int)((float)nArray[2] + f3 * 255.0f);
                    ++n4;
                    continue;
                }
                return null;
            }
            if (cvzo3._d == tgdv.field_77756_aW.field_77779_bT) {
                float[] fArray = EntitySheep.field_70898_d[uziv._a(cvzo3._j())];
                int n5 = (int)(fArray[0] * 255.0f);
                int n6 = (int)(fArray[1] * 255.0f);
                int n7 = (int)(fArray[2] * 255.0f);
                n3 += Math.max(n5, Math.max(n6, n7));
                nArray[0] = nArray[0] + n5;
                nArray[1] = nArray[1] + n6;
                nArray[2] = nArray[2] + n7;
                ++n4;
                continue;
            }
            return null;
        }
        if (lpno2 == null) {
            return null;
        }
        n2 = nArray[0] / n4;
        int n8 = nArray[1] / n4;
        n = nArray[2] / n4;
        f2 = (float)n3 / (float)n4;
        f = Math.max(n2, Math.max(n8, n));
        n2 = (int)((float)n2 * f2 / f);
        n8 = (int)((float)n8 * f2 / f);
        n = (int)((float)n * f2 / f);
        int n9 = n2;
        n9 = (n9 << 8) + n8;
        n9 = (n9 << 8) + n;
        lpno2.func_82813_b(cvzo2, n9);
        return cvzo2;
    }

    @Override
    public int func_77570_a() {
        return 10;
    }

    @Override
    public cvzo func_77571_b() {
        return null;
    }
}

