/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class apsb
extends tgdv {
    public apsb(int n) {
        super(n);
        this.func_77637_a(tgbl.field_78026_f);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return true;
        }
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
        if (!entityPlayer.func_82247_a(n, n2, n3, n4, cvzo2)) {
            return false;
        }
        int n5 = ozlu2.func_72798_a(n, n2, n3);
        if (n5 == 0) {
            ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "fire.ignite", 1.0f, field_77697_d.nextFloat() * 0.4f + 0.8f);
            ozlu2.func_94575_c(n, n2, n3, twgu.field_72067_ar.field_71990_ca);
        }
        if (!entityPlayer.field_71075_bZ._d) {
            --cvzo2._b;
        }
        return true;
    }
}

