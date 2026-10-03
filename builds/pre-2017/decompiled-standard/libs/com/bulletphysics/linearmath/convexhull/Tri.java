/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath.convexhull;

import com.bulletphysics.linearmath.convexhull.Int3;
import com.bulletphysics.linearmath.convexhull.IntRef;

class Tri
extends Int3 {
    public Int3 n = new Int3();
    public int id;
    public int vmax;
    public float rise;
    private static int er = -1;
    private static IntRef erRef = new IntRef(){

        @Override
        public int get() {
            return er;
        }

        @Override
        public void set(int value) {
            er = value;
        }
    };

    public Tri(int a, int b, int c) {
        super(a, b, c);
        this.n.set(-1, -1, -1);
        this.vmax = -1;
        this.rise = 0.0f;
    }

    public IntRef neib(int a, int b) {
        for (int i = 0; i < 3; ++i) {
            int i1 = (i + 1) % 3;
            int i2 = (i + 2) % 3;
            if (this.getCoord(i) == a && this.getCoord(i1) == b) {
                return this.n.getRef(i2);
            }
            if (this.getCoord(i) != b || this.getCoord(i1) != a) continue;
            return this.n.getRef(i2);
        }
        assert (false);
        return erRef;
    }
}

