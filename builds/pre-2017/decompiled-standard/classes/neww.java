/*
 * Decompiled with CFR 0.152.
 */
public class neww {
    public String[][] _a = new String[][]{{"X", "X", "#"}};
    public Object[][] _b = new Object[][]{{twgu.field_71988_x, twgu.field_71978_w, tgdv.field_77703_o, tgdv.field_77702_n, tgdv.field_77717_p}, {tgdv.field_77715_r, tgdv.field_77711_v, tgdv.field_77716_q, tgdv.field_77718_z, tgdv.field_77672_G}};

    public void _a(igjl igjl2) {
        for (int i = 0; i < this._b[0].length; ++i) {
            Object object = this._b[0][i];
            for (int j = 0; j < this._b.length - 1; ++j) {
                tgdv tgdv2 = (tgdv)this._b[j + 1][i];
                igjl2._a(new cvzo(tgdv2), this._a[j], Character.valueOf('#'), tgdv.field_77669_D, Character.valueOf('X'), object);
            }
        }
        igjl2._a(new cvzo(tgdv.field_77707_k, 1), " #X", "# X", " #X", Character.valueOf('X'), tgdv.field_77683_K, Character.valueOf('#'), tgdv.field_77669_D);
        igjl2._a(new cvzo(tgdv.field_77704_l, 4), "X", "#", "Y", Character.valueOf('Y'), tgdv.field_77676_L, Character.valueOf('X'), tgdv.field_77804_ap, Character.valueOf('#'), tgdv.field_77669_D);
    }
}

