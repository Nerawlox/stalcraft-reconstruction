/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;

public class yvwy
extends tgdv {
    public tflj _a;

    public yvwy(int n, tflj tflj2) {
        super(n);
        this._a = tflj2;
        this.field_77777_bU = 1;
        this.func_77637_a(tgbl.field_78028_d);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (n4 != 1) {
            return false;
        }
        twgu twgu2 = this._a == tflj._d ? twgu.field_72054_aE : twgu.field_72045_aL;
        if (!entityPlayer.func_82247_a(n, ++n2, n3, n4, cvzo2) || !entityPlayer.func_82247_a(n, n2 + 1, n3, n4, cvzo2)) {
            return false;
        }
        if (!twgu2.func_71930_b(ozlu2, n, n2, n3)) {
            return false;
        }
        int n5 = sajh._c((double)((entityPlayer.field_70177_z + 180.0f) * 4.0f / 360.0f) - 0.5) & 3;
        yvwy._a(ozlu2, n, n2, n3, n5, twgu2);
        --cvzo2._b;
        return true;
    }

    public static void _a(ozlu ozlu2, int n, int n2, int n3, int n4, twgu twgu2) {
        int n5 = 0;
        int n6 = 0;
        if (n4 == 0) {
            n6 = 1;
        }
        if (n4 == 1) {
            n5 = -1;
        }
        if (n4 == 2) {
            n6 = -1;
        }
        if (n4 == 3) {
            n5 = 1;
        }
        int n7 = (ozlu2.func_72809_s(n - n5, n2, n3 - n6) ? 1 : 0) + (ozlu2.func_72809_s(n - n5, n2 + 1, n3 - n6) ? 1 : 0);
        int n8 = (ozlu2.func_72809_s(n + n5, n2, n3 + n6) ? 1 : 0) + (ozlu2.func_72809_s(n + n5, n2 + 1, n3 + n6) ? 1 : 0);
        boolean bl = ozlu2.func_72798_a(n - n5, n2, n3 - n6) == twgu2.field_71990_ca || ozlu2.func_72798_a(n - n5, n2 + 1, n3 - n6) == twgu2.field_71990_ca;
        boolean bl2 = ozlu2.func_72798_a(n + n5, n2, n3 + n6) == twgu2.field_71990_ca || ozlu2.func_72798_a(n + n5, n2 + 1, n3 + n6) == twgu2.field_71990_ca;
        boolean bl3 = false;
        if (bl && !bl2) {
            bl3 = true;
        } else if (n8 > n7) {
            bl3 = true;
        }
        ozlu2.func_72832_d(n, n2, n3, twgu2.field_71990_ca, n4, 2);
        ozlu2.func_72832_d(n, n2 + 1, n3, twgu2.field_71990_ca, 8 | (bl3 ? 1 : 0), 2);
        ozlu2.func_72898_h(n, n2, n3, twgu2.field_71990_ca);
        ozlu2.func_72898_h(n, n2 + 1, n3, twgu2.field_71990_ca);
    }
}

