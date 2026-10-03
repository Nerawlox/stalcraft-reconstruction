/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.util.Random;
import net.minecraft.util.iurq;
import net.minecraft.util.piet;
import net.minecraftforge.common.ChestGenHooks;

public class vjvn
extends piet {
    public cvzo _a;
    public int _b;
    public int _c;

    public vjvn(int n, int n2, int n3, int n4, int n5) {
        super(n5);
        this._a = new cvzo(n, 1, n2);
        this._b = n3;
        this._c = n4;
    }

    public vjvn(cvzo cvzo2, int n, int n2, int n3) {
        super(n3);
        this._a = cvzo2;
        this._b = n;
        this._c = n2;
    }

    public static void _a(Random random, vjvn[] vjvnArray, mssh mssh2, int n) {
        for (int i = 0; i < n; ++i) {
            cvzo[] cvzoArray;
            vjvn vjvn2 = (vjvn)iurq._a(random, vjvnArray);
            for (cvzo cvzo2 : cvzoArray = vjvn2._a(random, mssh2)) {
                mssh2.func_70299_a(random.nextInt(mssh2.func_70302_i_()), cvzo2);
            }
        }
    }

    public static void _a(Random random, vjvn[] vjvnArray, jjzo jjzo2, int n) {
        for (int i = 0; i < n; ++i) {
            cvzo[] cvzoArray;
            vjvn vjvn2 = (vjvn)iurq._a(random, vjvnArray);
            for (cvzo cvzo2 : cvzoArray = vjvn2._a(random, jjzo2)) {
                jjzo2.func_70299_a(random.nextInt(jjzo2.func_70302_i_()), cvzo2);
            }
        }
    }

    public static vjvn[] _a(vjvn[] vjvnArray, vjvn ... vjvnArray2) {
        vjvn[] vjvnArray3 = new vjvn[vjvnArray.length + vjvnArray2.length];
        int n = 0;
        for (int i = 0; i < vjvnArray.length; ++i) {
            vjvnArray3[n++] = vjvnArray[i];
        }
        vjvn[] vjvnArray4 = vjvnArray2;
        int n2 = vjvnArray2.length;
        for (int i = 0; i < n2; ++i) {
            vjvn vjvn2 = vjvnArray4[i];
            vjvnArray3[n++] = vjvn2;
        }
        return vjvnArray3;
    }

    public cvzo[] _a(Random random, mssh mssh2) {
        return ChestGenHooks.generateStacks(random, this._a, this._b, this._c);
    }
}

