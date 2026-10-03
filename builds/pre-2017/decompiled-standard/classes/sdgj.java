/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class sdgj
extends zhui {
    public sdgj(int n, twgu twgu2) {
        super(n, twgu2);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (cvzo2._b == 0) {
            return false;
        }
        if (!entityPlayer.func_82247_a(n, n2, n3, n4, cvzo2)) {
            return false;
        }
        int n5 = ozlu2.func_72798_a(n, n2, n3);
        if (n5 == twgu.field_72037_aS.field_71990_ca) {
            twgu twgu2 = twgu.field_71973_m[this.func_77883_f()];
            int n6 = ozlu2.func_72805_g(n, n2, n3);
            int n7 = n6 & 7;
            if (n7 <= 6 && ozlu2.func_72855_b(twgu2.func_71872_e(ozlu2, n, n2, n3)) && ozlu2.func_72921_c(n, n2, n3, n7 + 1 | n6 & 0xFFFFFFF8, 2)) {
                ozlu2.func_72908_a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, twgu2.field_72020_cn._e(), (twgu2.field_72020_cn._a() + 1.0f) / 2.0f, twgu2.field_72020_cn._b() * 0.8f);
                --cvzo2._b;
                return true;
            }
        }
        return super.func_77648_a(cvzo2, entityPlayer, ozlu2, n, n2, n3, n4, f, f2, f3);
    }
}

