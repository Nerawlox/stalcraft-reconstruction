/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;

public class bsut
extends tgdv {
    public bsut(int n) {
        super(n);
        this.func_77637_a(tgbl.field_78040_i);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        int n5 = ozlu2.func_72798_a(n, n2, n3);
        if (twgu.field_71973_m[n5] != null && twgu.field_71973_m[n5].func_71857_b() == 11) {
            if (ozlu2.field_72995_K) {
                return true;
            }
            bsut._a(entityPlayer, ozlu2, n, n2, n3);
            return true;
        }
        return false;
    }

    public static boolean _a(EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3) {
        EntityLeashKnot entityLeashKnot = EntityLeashKnot.func_110130_b(ozlu2, n, n2, n3);
        boolean bl = false;
        double d = 7.0;
        List list2 = ozlu2.func_72872_a(EntityLiving.class, eidj._a()._a((double)n - d, (double)n2 - d, (double)n3 - d, (double)n + d, (double)n2 + d, (double)n3 + d));
        if (list2 != null) {
            for (EntityLiving entityLiving : list2) {
                if (!entityLiving.func_110167_bD() || entityLiving.func_110166_bE() != entityPlayer) continue;
                if (entityLeashKnot == null) {
                    entityLeashKnot = EntityLeashKnot.func_110129_a(ozlu2, n, n2, n3);
                }
                entityLiving.func_110162_b(entityLeashKnot, true);
                bl = true;
            }
        }
        return bl;
    }
}

