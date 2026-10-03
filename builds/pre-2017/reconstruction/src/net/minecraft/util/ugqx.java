/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.util.sajh;

public class ugqx {
    public static final int[] _a = new int[]{0, -1, 0, 1};
    public static final int[] _b = new int[]{1, 0, -1, 0};
    public static final String[] _c = new String[]{"SOUTH", "WEST", "NORTH", "EAST"};
    public static final int[] _d = new int[]{3, 4, 2, 5};
    public static final int[] _e = new int[]{-1, -1, 2, 0, 1, 3};
    public static final int[] _f = new int[]{2, 3, 0, 1};
    public static final int[] _g = new int[]{1, 2, 3, 0};
    public static final int[] _h = new int[]{3, 0, 1, 2};
    public static final int[][] _i = new int[][]{{1, 0, 3, 2, 5, 4}, {1, 0, 5, 4, 2, 3}, {1, 0, 2, 3, 4, 5}, {1, 0, 4, 5, 3, 2}};

    public static int _a(double d, double d2) {
        if (sajh._e((float)d) > sajh._e((float)d2)) {
            if (d > 0.0) {
                return 1;
            }
            return 3;
        }
        if (d2 > 0.0) {
            return 2;
        }
        return 0;
    }
}

