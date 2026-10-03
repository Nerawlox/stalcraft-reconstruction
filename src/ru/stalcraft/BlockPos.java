/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft;

public class BlockPos {
    public final int x;
    public final int y;
    public final int z;
    public final int dimension;

    public BlockPos(abw w2, int x2, int y2, int z2) {
        this.dimension = w2.t.i;
        this.x = x2;
        this.y = y2;
        this.z = z2;
    }

    public BlockPos(int dimension, int x2, int y2, int z2) {
        this.dimension = dimension;
        this.x = x2;
        this.y = y2;
        this.z = z2;
    }

    public boolean equals(BlockPos pos) {
        return pos != null && pos.x == this.x && pos.y == this.y && pos.z == this.z && pos.dimension == this.dimension;
    }
}

