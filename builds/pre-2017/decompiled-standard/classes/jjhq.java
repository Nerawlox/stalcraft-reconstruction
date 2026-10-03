/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;

public class jjhq
extends tgdv {
    public jjhq(int n) {
        super(n);
        this.func_77637_a(tgbl.field_78031_c);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return true;
        }
        if (n4 != 1) {
            return false;
        }
        ++n2;
        gqbt gqbt2 = (gqbt)twgu.field_71959_S;
        int n5 = sajh._c((double)(entityPlayer.field_70177_z * 4.0f / 360.0f) + 0.5) & 3;
        int n6 = 0;
        int n7 = 0;
        if (n5 == 0) {
            n7 = 1;
        }
        if (n5 == 1) {
            n6 = -1;
        }
        if (n5 == 2) {
            n7 = -1;
        }
        if (n5 == 3) {
            n6 = 1;
        }
        if (!entityPlayer.func_82247_a(n, n2, n3, n4, cvzo2) || !entityPlayer.func_82247_a(n + n6, n2, n3 + n7, n4, cvzo2)) {
            return false;
        }
        if (ozlu2.func_72799_c(n, n2, n3) && ozlu2.func_72799_c(n + n6, n2, n3 + n7) && ozlu2.func_72797_t(n, n2 - 1, n3) && ozlu2.func_72797_t(n + n6, n2 - 1, n3 + n7)) {
            ozlu2.func_72832_d(n, n2, n3, gqbt2.field_71990_ca, n5, 3);
            if (ozlu2.func_72798_a(n, n2, n3) == gqbt2.field_71990_ca) {
                ozlu2.func_72832_d(n + n6, n2, n3 + n7, gqbt2.field_71990_ca, n5 + 8, 3);
            }
            --cvzo2._b;
            return true;
        }
        return false;
    }
}

