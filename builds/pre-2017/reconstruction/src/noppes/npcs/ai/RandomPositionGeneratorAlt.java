/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import java.util.Random;
import net.minecraft.entity.EntityCreature;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;

public class RandomPositionGeneratorAlt {
    private static Vec3 staticVector = Vec3._a(0.0, 0.0, 0.0);

    public static Vec3 findRandomTarget(EntityCreature entityCreature, int n, int n2) {
        return RandomPositionGeneratorAlt.findRandomTargetBlock(entityCreature, n, n2, null);
    }

    public static Vec3 findRandomTargetBlockTowards(EntityCreature entityCreature, int n, int n2, Vec3 vec3) {
        RandomPositionGeneratorAlt.staticVector._c = vec3._c - entityCreature.posX;
        RandomPositionGeneratorAlt.staticVector._d = vec3._d - entityCreature.posY;
        RandomPositionGeneratorAlt.staticVector._e = vec3._e - entityCreature.posZ;
        return RandomPositionGeneratorAlt.findRandomTargetBlock(entityCreature, n, n2, staticVector);
    }

    public static Vec3 findRandomTargetBlockAwayFrom(EntityCreature entityCreature, int n, int n2, Vec3 vec3) {
        RandomPositionGeneratorAlt.staticVector._c = entityCreature.posX - vec3._c;
        RandomPositionGeneratorAlt.staticVector._d = entityCreature.posY - vec3._d;
        RandomPositionGeneratorAlt.staticVector._e = entityCreature.posZ - vec3._e;
        return RandomPositionGeneratorAlt.findRandomTargetBlock(entityCreature, n, n2, staticVector);
    }

    private static Vec3 findRandomTargetBlock(EntityCreature entityCreature, int n, int n2, Vec3 vec3) {
        double d;
        double d2;
        if (n <= 0) {
            n = 1;
        }
        Random random = entityCreature.getRNG();
        boolean bl = false;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        float f = -99999.0f;
        boolean bl2 = entityCreature.hasHome() ? (d2 = (double)(entityCreature.getHomePosition()._b(sajh._c(entityCreature.posX), sajh._c(entityCreature.posY), sajh._c(entityCreature.posZ)) + 4.0f)) < (d = (double)(entityCreature.func_110174_bM() + (float)n)) * d : false;
        for (int i = 0; i < 10; ++i) {
            float f2;
            int n6 = random.nextInt(2 * n) - n;
            int n7 = random.nextInt(2 * n2) - n2;
            int n8 = random.nextInt(2 * n) - n;
            if (vec3 != null && !((double)n6 * vec3._c + (double)n8 * vec3._e >= 0.0)) continue;
            if (random.nextBoolean()) {
                n6 += sajh._c(entityCreature.posX);
                n7 += sajh._c(entityCreature.posY);
                n8 += sajh._c(entityCreature.posZ);
            } else {
                n6 += sajh._e(entityCreature.posX);
                n7 += sajh._e(entityCreature.posY);
                n8 += sajh._e(entityCreature.posZ);
            }
            if (bl2 && !entityCreature.func_110176_b(n6, n7, n8) || !((f2 = entityCreature.getBlockPathWeight(n6, n7, n8)) > f)) continue;
            f = f2;
            n3 = n6;
            n4 = n7;
            n5 = n8;
            bl = true;
        }
        if (bl) {
            return entityCreature.worldObj.getWorldVec3Pool()._a(n3, n4, n5);
        }
        return null;
    }
}

