/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.amww;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class hdbs
extends tgdv {
    public hdbs(int n) {
        super(n);
        this.field_77777_bU = 1;
        this.func_77637_a(tgbl.field_78029_e);
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        Object object;
        int n;
        float f;
        float f2;
        float f3;
        double d;
        float f4;
        float f5 = 1.0f;
        float f6 = entityPlayer.field_70127_C + (entityPlayer.field_70125_A - entityPlayer.field_70127_C) * f5;
        float f7 = entityPlayer.field_70126_B + (entityPlayer.field_70177_z - entityPlayer.field_70126_B) * f5;
        double d2 = entityPlayer.field_70169_q + (entityPlayer.field_70165_t - entityPlayer.field_70169_q) * (double)f5;
        double d3 = entityPlayer.field_70167_r + (entityPlayer.field_70163_u - entityPlayer.field_70167_r) * (double)f5 + 1.62 - (double)entityPlayer.field_70129_M;
        double d4 = entityPlayer.field_70166_s + (entityPlayer.field_70161_v - entityPlayer.field_70166_s) * (double)f5;
        ofbx ofbx2 = ozlu2.func_82732_R()._a(d2, d3, d4);
        float f8 = sajh._b(-f7 * ((float)Math.PI / 180) - (float)Math.PI);
        float f9 = sajh._a(-f7 * ((float)Math.PI / 180) - (float)Math.PI);
        float f10 = f9 * (f4 = -sajh._b(-f6 * ((float)Math.PI / 180)));
        ofbx ofbx3 = ofbx2._c((double)f10 * (d = 5.0), (double)(f3 = (f2 = sajh._a(-f6 * ((float)Math.PI / 180)))) * d, (double)(f = f8 * f4) * d);
        hank hank2 = ozlu2.func_72901_a(ofbx2, ofbx3, true);
        if (hank2 == null) {
            return cvzo2;
        }
        ofbx ofbx4 = entityPlayer.func_70676_i(f5);
        boolean bl = false;
        float f11 = 1.0f;
        List list = ozlu2.func_72839_b(entityPlayer, entityPlayer.field_70121_D._a(ofbx4._c * d, ofbx4._d * d, ofbx4._e * d)._b(f11, f11, f11));
        for (n = 0; n < list.size(); ++n) {
            float f12;
            Entity entity = (Entity)list.get(n);
            if (!entity.func_70067_L() || !((eidj)(object = entity.field_70121_D._b(f12 = entity.func_70111_Y(), f12, f12)))._a(ofbx2)) continue;
            bl = true;
        }
        if (bl) {
            return cvzo2;
        }
        if (hank2._c == amww._a) {
            n = hank2._d;
            int n2 = hank2._e;
            int n3 = hank2._f;
            if (ozlu2.func_72798_a(n, n2, n3) == twgu.field_72037_aS.field_71990_ca) {
                --n2;
            }
            object = new EntityBoat(ozlu2, (float)n + 0.5f, (float)n2 + 1.0f, (float)n3 + 0.5f);
            ((EntityBoat)object).field_70177_z = ((sajh._c((double)(entityPlayer.field_70177_z * 4.0f / 360.0f) + 0.5) & 3) - 1) * 90;
            if (!ozlu2.func_72945_a((Entity)object, ((EntityBoat)object).field_70121_D._b(-0.1, -0.1, -0.1)).isEmpty()) {
                return cvzo2;
            }
            if (!ozlu2.field_72995_K) {
                ozlu2.func_72838_d((Entity)object);
            }
            if (!entityPlayer.field_71075_bZ._d) {
                --cvzo2._b;
            }
        }
        return cvzo2;
    }
}

