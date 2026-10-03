/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  beg
 */
package ru.stalcraft.entity;

import ru.stalcraft.tile.TileEntityTrampoline;

public class TrampolineParticle
extends beg {
    private final double startY;
    private TileEntityTrampoline tileEntity;
    private final int xTile;
    private final int yTile;
    private final int zTile;

    public TrampolineParticle(abw par1World, int x2, int y2, int z2) {
        super(par1World, (double)x2 + Math.random(), (double)y2, (double)z2 + Math.random());
        this.z = 0.0;
        this.y = 0.0;
        this.x = 0.0;
        this.startY = this.v;
        this.xTile = x2;
        this.yTile = y2;
        this.zTile = z2;
        this.tileEntity = (TileEntityTrampoline)par1World.r(x2, y2, z2);
        this.aw = 0.7f;
        this.i = 0.0f;
        this.j = 0.87058824f;
        this.au = 0.72156864f;
        this.av = 0.5294118f;
        this.Z = true;
        this.i((int)(Math.random() * 8.0));
        this.h = 0.5f;
    }

    public void l_() {
        this.r = this.u;
        this.s = this.v;
        this.t = this.w;
        if (this.tileEntity == this.q.r(this.xTile, this.yTile, this.zTile) && this.tileEntity != null) {
            if (this.y == 0.0 && Math.random() > 0.99) {
                this.y = Math.random() / 4.0;
            }
            this.y -= 0.05;
            this.v = Math.max(this.startY, this.v + this.y);
            if (this.v <= this.startY) {
                this.y = 0.0;
                this.v = this.startY;
            }
        } else {
            this.x();
        }
    }
}

