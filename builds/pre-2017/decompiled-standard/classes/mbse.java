/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.tdpx;

public class mbse
extends tgdv {
    public dwan _a;

    public mbse(int n) {
        super(n);
    }

    @Override
    public dwan func_77618_c(int n, int n2) {
        if (n2 > 0) {
            return this._a;
        }
        return super.func_77618_c(n, n2);
    }

    @Override
    public int func_82790_a(cvzo cvzo2, int n) {
        if (n == 1) {
            huhy huhy2 = mbse._a(cvzo2, "Colors");
            if (huhy2 != null) {
                qoak qoak2 = (qoak)huhy2;
                if (qoak2._c.length == 1) {
                    return qoak2._c[0];
                }
                int n2 = 0;
                int n3 = 0;
                int n4 = 0;
                for (int n5 : qoak2._c) {
                    n2 += (n5 & 0xFF0000) >> 16;
                    n3 += (n5 & 0xFF00) >> 8;
                    n4 += (n5 & 0xFF) >> 0;
                }
                return (n2 /= qoak2._c.length) << 16 | (n3 /= qoak2._c.length) << 8 | (n4 /= qoak2._c.length);
            }
            return 0x8A8A8A;
        }
        return super.func_82790_a(cvzo2, n);
    }

    @Override
    public boolean func_77623_v() {
        return true;
    }

    public static huhy _a(cvzo cvzo2, String string) {
        qoac qoac2;
        if (cvzo2._p() && (qoac2 = cvzo2._q()._m("Explosion")) != null) {
            return qoac2._b(string);
        }
        return null;
    }

    @Override
    public void func_77624_a(cvzo cvzo2, EntityPlayer entityPlayer, List list2, boolean bl) {
        qoac qoac2;
        if (cvzo2._p() && (qoac2 = cvzo2._q()._m("Explosion")) != null) {
            mbse._a(qoac2, list2);
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void _a(qoac qoac2, List list2) {
        boolean bl;
        boolean bl2;
        int[] nArray;
        int n;
        byte by = qoac2._d("Type");
        if (by >= 0 && by <= 4) {
            list2.add(tdpx._a("item.fireworksCharge.type." + by).trim());
        } else {
            list2.add(tdpx._a("item.fireworksCharge.type").trim());
        }
        int[] nArray2 = qoac2._l("Colors");
        if (nArray2.length > 0) {
            boolean bl3 = true;
            String string = "";
            for (int n2 : nArray2) {
                if (!bl3) {
                    string = string + ", ";
                }
                bl3 = false;
                int n3 = 0;
                for (n = 0; n < 16; ++n) {
                    if (n2 != hugs._c[n]) continue;
                    n3 = 1;
                    string = string + tdpx._a("item.fireworksCharge." + hugs._a[n]);
                    break;
                }
                if (n3 != 0) continue;
                string = string + tdpx._a("item.fireworksCharge.customColor");
            }
            list2.add(string);
        }
        if ((nArray = qoac2._l("FadeColors")).length > 0) {
            void var6_11;
            boolean bl4 = true;
            String bl3 = tdpx._a("item.fireworksCharge.fadeTo") + " ";
            for (int n3 : nArray) {
                if (!bl4) {
                    String string = (String)var6_11 + ", ";
                }
                bl4 = false;
                n = 0;
                for (int i = 0; i < 16; ++i) {
                    if (n3 != hugs._c[i]) continue;
                    n = 1;
                    String string = (String)var6_11 + tdpx._a("item.fireworksCharge." + hugs._a[i]);
                    break;
                }
                if (n != 0) continue;
                String string = (String)var6_11 + tdpx._a("item.fireworksCharge.customColor");
            }
            list2.add(var6_11);
        }
        if (bl2 = qoac2._o("Trail")) {
            list2.add(tdpx._a("item.fireworksCharge.trail"));
        }
        if (bl = qoac2._o("Flicker")) {
            list2.add(tdpx._a("item.fireworksCharge.flicker"));
        }
    }

    @Override
    public void func_94581_a(nege nege2) {
        super.func_94581_a(nege2);
        this._a = nege2._b(this.func_111208_A() + "_overlay");
    }
}

