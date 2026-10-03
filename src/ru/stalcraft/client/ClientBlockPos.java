/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client;

public class ClientBlockPos {
    public final int x;
    public final int y;
    public final int z;
    public final int w;

    public ClientBlockPos(int w2, int x2, int y2, int z2) {
        this.w = w2;
        this.x = x2;
        this.y = y2;
        this.z = z2;
    }

    public boolean posEquals(ClientBlockPos pos) {
        return pos != null && pos.w == this.w && pos.x == this.x && pos.y == this.y && pos.z == this.z;
    }

    public abw getWorld() {
        return this.w == atv.w().f.t.i ? atv.w().f : null;
    }
}

