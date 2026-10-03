/*
 * Decompiled with CFR 0.152.
 */
public class wprm {
    public String[][] _a = new String[][]{{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
    public Object[][] _b = new Object[][]{{twgu.field_71988_x, twgu.field_71978_w, tgdv.field_77703_o, tgdv.field_77702_n, tgdv.field_77717_p}, {tgdv.field_77713_t, tgdv.field_77720_x, tgdv.field_77696_g, tgdv.field_77674_B, tgdv.field_77681_I}, {tgdv.field_77714_s, tgdv.field_77710_w, tgdv.field_77695_f, tgdv.field_77673_A, tgdv.field_77680_H}, {tgdv.field_77712_u, tgdv.field_77719_y, tgdv.field_77708_h, tgdv.field_77675_C, tgdv.field_77682_J}, {tgdv.field_77678_N, tgdv.field_77679_O, tgdv.field_77689_P, tgdv.field_77688_Q, tgdv.field_77691_R}};

    public void _a(igjl igjl2) {
        for (int i = 0; i < this._b[0].length; ++i) {
            Object object = this._b[0][i];
            for (int j = 0; j < this._b.length - 1; ++j) {
                tgdv tgdv2 = (tgdv)this._b[j + 1][i];
                igjl2._a(new cvzo(tgdv2), this._a[j], Character.valueOf('#'), tgdv.field_77669_D, Character.valueOf('X'), object);
            }
        }
        igjl2._a(new cvzo(tgdv.field_77745_be), " #", "# ", Character.valueOf('#'), tgdv.field_77703_o);
    }
}

