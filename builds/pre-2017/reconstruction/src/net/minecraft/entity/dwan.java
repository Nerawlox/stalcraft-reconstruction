/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import java.util.Random;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.potion.Potion;

public class dwan
implements EntityLivingData {
    public int _a;

    public void _a(Random random) {
        int n = random.nextInt(5);
        if (n <= 1) {
            this._a = Potion._c._H;
        } else if (n <= 2) {
            this._a = Potion._g._H;
        } else if (n <= 3) {
            this._a = Potion._l._H;
        } else if (n <= 4) {
            this._a = Potion._p._H;
        }
    }
}

