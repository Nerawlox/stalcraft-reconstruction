/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.util.Collection;
import java.util.Random;
import net.minecraft.util.piet;

public class iurq {
    public static int _a(Collection collection) {
        int n = 0;
        for (piet piet2 : collection) {
            n += piet2.field_76292_a;
        }
        return n;
    }

    public static piet _a(Random random, Collection collection, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        int n2 = random.nextInt(n);
        for (piet piet2 : collection) {
            if ((n2 -= piet2.field_76292_a) >= 0) continue;
            return piet2;
        }
        return null;
    }

    public static piet _a(Random random, Collection collection) {
        return iurq._a(random, collection, iurq._a(collection));
    }

    public static int _a(piet[] pietArray) {
        int n = 0;
        for (piet piet2 : pietArray) {
            n += piet2.field_76292_a;
        }
        return n;
    }

    public static piet _a(Random random, piet[] pietArray, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        int n2 = random.nextInt(n);
        for (piet piet2 : pietArray) {
            if ((n2 -= piet2.field_76292_a) >= 0) continue;
            return piet2;
        }
        return null;
    }

    public static piet _a(Random random, piet[] pietArray) {
        return iurq._a(random, pietArray, iurq._a(pietArray));
    }
}

