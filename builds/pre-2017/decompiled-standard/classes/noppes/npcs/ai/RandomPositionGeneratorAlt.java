/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import java.util.Random;
import net.minecraft.entity.EntityCreature;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class RandomPositionGeneratorAlt {
    private static ofbx staticVector = ofbx._a(0.0, 0.0, 0.0);

    public static ofbx findRandomTarget(EntityCreature entityCreature, int n, int n2) {
        return RandomPositionGeneratorAlt.findRandomTargetBlock(entityCreature, n, n2, null);
    }

    public static ofbx findRandomTargetBlockTowards(EntityCreature entityCreature, int n, int n2, ofbx ofbx2) {
        RandomPositionGeneratorAlt.staticVector._c = ofbx2._c - entityCreature.field_70165_t;
        RandomPositionGeneratorAlt.staticVector._d = ofbx2._d - entityCreature.field_70163_u;
        RandomPositionGeneratorAlt.staticVector._e = ofbx2._e - entityCreature.field_70161_v;
        return RandomPositionGeneratorAlt.findRandomTargetBlock(entityCreature, n, n2, staticVector);
    }

    public static ofbx findRandomTargetBlockAwayFrom(EntityCreature entityCreature, int n, int n2, ofbx ofbx2) {
        RandomPositionGeneratorAlt.staticVector._c = entityCreature.field_70165_t - ofbx2._c;
        RandomPositionGeneratorAlt.staticVector._d = entityCreature.field_70163_u - ofbx2._d;
        RandomPositionGeneratorAlt.staticVector._e = entityCreature.field_70161_v - ofbx2._e;
        return RandomPositionGeneratorAlt.findRandomTargetBlock(entityCreature, n, n2, staticVector);
    }

    private static ofbx findRandomTargetBlock(EntityCreature entityCreature, int n, int n2, ofbx ofbx2) {
        double d;
        double d2;
        if (n <= 0) {
            n = 1;
        }
        Random random = entityCreature.func_70681_au();
        boolean bl = false;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        float f = -99999.0f;
        boolean bl2 = entityCreature.func_110175_bO() ? (d2 = (double)(entityCreature.func_110172_bL()._b(sajh._c(entityCreature.field_70165_t), sajh._c(entityCreature.field_70163_u), sajh._c(entityCreature.field_70161_v)) + 4.0f)) < (d = (double)(entityCreature.func_110174_bM() + (float)n)) * d : false;
        for (int i = 0; i < 10; ++i) {
            float f2;
            int n6 = random.nextInt(2 * n) - n;
            int n7 = random.nextInt(2 * n2) - n2;
            int n8 = random.nextInt(2 * n) - n;
            if (ofbx2 != null && !((double)n6 * ofbx2._c + (double)n8 * ofbx2._e >= 0.0)) continue;
            if (random.nextBoolean()) {
                n6 += sajh._c(entityCreature.field_70165_t);
                n7 += sajh._c(entityCreature.field_70163_u);
                n8 += sajh._c(entityCreature.field_70161_v);
            } else {
                n6 += sajh._e(entityCreature.field_70165_t);
                n7 += sajh._e(entityCreature.field_70163_u);
                n8 += sajh._e(entityCreature.field_70161_v);
            }
            if (bl2 && !entityCreature.func_110176_b(n6, n7, n8) || !((f2 = entityCreature.func_70783_a(n6, n7, n8)) > f)) continue;
            f = f2;
            n3 = n6;
            n4 = n7;
            n5 = n8;
            bl = true;
        }
        if (bl) {
            return entityCreature.field_70170_p.func_82732_R()._a(n3, n4, n5);
        }
        return null;
    }
}

