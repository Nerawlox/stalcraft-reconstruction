/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath.convexhull;

import com.bulletphysics.linearmath.convexhull.IntRef;

class Int3 {
    public int x;
    public int y;
    public int z;

    public Int3() {
    }

    public Int3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Int3(Int3 i) {
        this.x = i.x;
        this.y = i.y;
        this.z = i.z;
    }

    public void set(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void set(Int3 i) {
        this.x = i.x;
        this.y = i.y;
        this.z = i.z;
    }

    public int getCoord(int coord) {
        switch (coord) {
            case 0: {
                return this.x;
            }
            case 1: {
                return this.y;
            }
        }
        return this.z;
    }

    public void setCoord(int coord, int value) {
        switch (coord) {
            case 0: {
                this.x = value;
                break;
            }
            case 1: {
                this.y = value;
                break;
            }
            case 2: {
                this.z = value;
            }
        }
    }

    public boolean equals(Int3 i) {
        return this.x == i.x && this.y == i.y && this.z == i.z;
    }

    public IntRef getRef(final int coord) {
        return new IntRef(){

            @Override
            public int get() {
                return Int3.this.getCoord(coord);
            }

            @Override
            public void set(int value) {
                Int3.this.setCoord(coord, value);
            }
        };
    }
}

