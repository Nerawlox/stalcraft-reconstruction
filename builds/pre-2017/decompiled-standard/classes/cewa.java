/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class cewa
extends tgdv {
    public cewa(int n) {
        super(n);
        this.func_77625_d(1);
        this.func_77637_a(tgbl.field_78026_f);
    }

    @Override
    public cvzo func_77654_b(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (!entityPlayer.field_71075_bZ._d) {
            --cvzo2._b;
        }
        if (!ozlu2.field_72995_K) {
            entityPlayer.curePotionEffects(cvzo2);
        }
        return cvzo2._b <= 0 ? new cvzo(tgdv.field_77788_aw) : cvzo2;
    }

    @Override
    public int func_77626_a(cvzo cvzo2) {
        return 32;
    }

    @Override
    public bsre func_77661_b(cvzo cvzo2) {
        return bsre._c;
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        entityPlayer.func_71008_a(cvzo2, this.func_77626_a(cvzo2));
        return cvzo2;
    }
}

