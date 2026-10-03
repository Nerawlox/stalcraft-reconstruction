/*
 * Decompiled with CFR 0.152.
 */
public class igjt {
    public String[][] _a = new String[][]{{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
    public Object[][] _b = new Object[][]{{tgdv.field_77770_aF, twgu.field_72067_ar, tgdv.field_77703_o, tgdv.field_77702_n, tgdv.field_77717_p}, {tgdv.field_77687_V, tgdv.field_77694_Z, tgdv.field_77812_ad, tgdv.field_77820_ah, tgdv.field_77796_al}, {tgdv.field_77686_W, tgdv.field_77814_aa, tgdv.field_77822_ae, tgdv.field_77798_ai, tgdv.field_77806_am}, {tgdv.field_77693_X, tgdv.field_77816_ab, tgdv.field_77824_af, tgdv.field_77800_aj, tgdv.field_77808_an}, {tgdv.field_77692_Y, tgdv.field_77810_ac, tgdv.field_77818_ag, tgdv.field_77794_ak, tgdv.field_77802_ao}};

    public void _a(igjl igjl2) {
        for (int i = 0; i < this._b[0].length; ++i) {
            Object object = this._b[0][i];
            for (int j = 0; j < this._b.length - 1; ++j) {
                tgdv tgdv2 = (tgdv)this._b[j + 1][i];
                igjl2._a(new cvzo(tgdv2), this._a[j], Character.valueOf('X'), object);
            }
        }
    }
}

