/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.tile;

import ru.stalcraft.StalkerMain;

public class TileEntityFlag
extends asp {
    private boolean firstrun = true;

    @Override
    public void h() {
        if (this.k != null && this.firstrun) {
            this.firstrun = false;
            if (!this.k.I) {
                StalkerMain.flagManager.addFlagToCheck(this.k.t.i, this.l, this.m, this.n);
            }
        }
    }

    @Override
    public boolean canUpdate() {
        return true;
    }
}

