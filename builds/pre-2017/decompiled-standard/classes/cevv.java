/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class cevv
extends nvwc {
    public cevv(int n) {
        super(n);
        this.func_77637_a(tgbl.field_78026_f);
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        cvzo cvzo3 = new cvzo(tgdv.field_77744_bd, 1, ozlu2.func_72841_b("map"));
        String string = "map_" + cvzo3._j();
        thdd thdd2 = new thdd(string);
        ozlu2.func_72823_a(string, thdd2);
        thdd2._d = 0;
        int n = 128 * (1 << thdd2._d);
        thdd2._a = (int)(Math.round(entityPlayer.field_70165_t / (double)n) * (long)n);
        thdd2._b = (int)(Math.round(entityPlayer.field_70161_v / (double)n) * (long)n);
        thdd2._c = (byte)ozlu2.field_73011_w._i;
        thdd2.func_76185_a();
        --cvzo2._b;
        if (cvzo2._b <= 0) {
            return cvzo3;
        }
        if (!entityPlayer.field_71071_by._c(cvzo3._l())) {
            entityPlayer.func_71021_b(cvzo3);
        }
        return cvzo2;
    }
}

