/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.monster.EntitySlime;

public class huwa
extends foqh {
    public huwa(int n) {
        super(n);
        this._I.field_76832_z = 2;
        this._I.field_76802_A = -999;
        this._I.field_76804_C = 1;
        this._I.field_76798_D = 8;
        this._I.field_76799_E = 10;
        this._I.field_76806_I = 1;
        this._I.field_76833_y = 4;
        this._H = 14745518;
        this._J.add(new yffo(EntitySlime.class, 1, 1, 1));
    }

    @Override
    public zzpm _a(Random random) {
        return this._T;
    }

    @Override
    public int _l() {
        double d = this._k();
        double d2 = this._j();
        return ((gapq._a(d, d2) & 0xFEFEFE) + 0x4E0E4E) / 2;
    }

    @Override
    public int _m() {
        double d = this._k();
        double d2 = this._j();
        return ((igvq._a(d, d2) & 0xFEFEFE) + 0x4E0E4E) / 2;
    }
}

