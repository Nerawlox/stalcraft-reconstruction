/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class bbsp
extends tgdv {
    public int _a;

    public bbsp(int n, twgu twgu2) {
        super(n);
        this._a = twgu2.field_71990_ca;
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        twgu twgu2;
        int n5;
        int n6 = ozlu2.func_72798_a(n, n2, n3);
        if (n6 == twgu.field_72037_aS.field_71990_ca && (ozlu2.func_72805_g(n, n2, n3) & 7) < 1) {
            n4 = 1;
        } else if (n6 != twgu.field_71998_bu.field_71990_ca && n6 != twgu.field_71962_X.field_71990_ca && n6 != twgu.field_71961_Y.field_71990_ca) {
            if (n4 == 0) {
                --n2;
            }
            if (n4 == 1) {
                ++n2;
            }
            if (n4 == 2) {
                --n3;
            }
            if (n4 == 3) {
                ++n3;
            }
            if (n4 == 4) {
                --n;
            }
            if (n4 == 5) {
                ++n;
            }
        }
        if (!entityPlayer.func_82247_a(n, n2, n3, n4, cvzo2)) {
            return false;
        }
        if (cvzo2._b == 0) {
            return false;
        }
        if (ozlu2.func_72931_a(this._a, n, n2, n3, false, n4, null, cvzo2) && ozlu2.func_72832_d(n, n2, n3, this._a, n5 = (twgu2 = twgu.field_71973_m[this._a]).func_85104_a(ozlu2, n, n2, n3, n4, f, f2, f3, 0), 3)) {
            if (ozlu2.func_72798_a(n, n2, n3) == this._a) {
                twgu.field_71973_m[this._a].func_71860_a(ozlu2, n, n2, n3, entityPlayer, cvzo2);
                twgu.field_71973_m[this._a].func_85105_g(ozlu2, n, n2, n3, n5);
            }
            ozlu2.func_72908_a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, twgu2.field_72020_cn._e(), (twgu2.field_72020_cn._a() + 1.0f) / 2.0f, twgu2.field_72020_cn._b() * 0.8f);
            --cvzo2._b;
        }
        return true;
    }
}

