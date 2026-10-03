/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  junit.framework.Assert
 */
package net.sf.kdgcommons.test;

import junit.framework.Assert;

public class NumericAsserts {
    public static void assertApproximate(int n, int n2, int n3) {
        int n4 = (int)((long)n * (long)n3 / 100L);
        int n5 = n - n4;
        Assert.assertTrue((String)("expected >= " + n5 + ", was " + n2), (n2 >= n5 ? 1 : 0) != 0);
        int n6 = n + n4;
        Assert.assertTrue((String)("expected <= " + n6 + ", was " + n2), (n2 <= n6 ? 1 : 0) != 0);
    }
}

