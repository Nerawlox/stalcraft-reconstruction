/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import java.util.Random;
import net.minecraft.entity.tupg;

public class dwan
implements tupg {
    public int _a;

    public void _a(Random random) {
        int n = random.nextInt(5);
        if (n <= 1) {
            this._a = hdpq._c._H;
        } else if (n <= 2) {
            this._a = hdpq._g._H;
        } else if (n <= 3) {
            this._a = hdpq._l._H;
        } else if (n <= 4) {
            this._a = hdpq._p._H;
        }
    }
}

