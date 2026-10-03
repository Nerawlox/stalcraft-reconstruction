/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.tile;

import ru.stalcraft.StalkerMain;
import ru.stalcraft.server.ServerTicker;
import ru.stalcraft.tile.TileEntityAnomaly;

public abstract class TileEntityExtendedAnomaly
extends TileEntityAnomaly {
    @Override
    public void w_() {
        super.w_();
        if (!this.k.I) {
            for (int x2 = -1; x2 < 2; ++x2) {
                for (int y2 = -1; y2 < 2; ++y2) {
                    for (int z2 = -1; z2 < 2; ++z2) {
                        this.k.a(this.l + x2, this.m + y2, this.n + z2);
                        if (this.k.a(this.l + x2, this.m + y2, this.n + z2) != StalkerMain.anomalyNeighbor.cF) continue;
                        StalkerMain.anomalyNeighbor.checkIsValid(this.k, this.l + x2, this.m + y2, this.n + z2);
                    }
                }
            }
        }
    }

    @Override
    public void s() {
        super.s();
        if (!this.k.I) {
            ServerTicker.anomaliesToCheck.add(this);
        }
    }

    public void addNeighborBlocks() {
        for (int x2 = -1; x2 < 2; ++x2) {
            for (int y2 = -1; y2 < 2; ++y2) {
                for (int z2 = -1; z2 < 2; ++z2) {
                    if (x2 == 0 && y2 == 0 && z2 == 0) continue;
                    this.k.a(this.l + x2, this.m + y2, this.n + z2);
                    if (this.k.a(this.l + x2, this.m + y2, this.n + z2) != 0) continue;
                    this.k.c(this.l + x2, this.m + y2, this.n + z2, StalkerMain.anomalyNeighbor.cF);
                }
            }
        }
    }
}

