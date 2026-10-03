/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class mssm
extends tgdv {
    public mssm(int n) {
        super(n);
        this.func_77637_a(tgbl.field_78028_d);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (ozlu2.func_72798_a(n, n2, n3) != twgu.field_72037_aS.field_71990_ca) {
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
            if (!ozlu2.func_72799_c(n, n2, n3)) {
                return false;
            }
        }
        if (!entityPlayer.func_82247_a(n, n2, n3, n4, cvzo2)) {
            return false;
        }
        if (twgu.field_72075_av.func_71930_b(ozlu2, n, n2, n3)) {
            --cvzo2._b;
            ozlu2.func_94575_c(n, n2, n3, twgu.field_72075_av.field_71990_ca);
        }
        return true;
    }
}

