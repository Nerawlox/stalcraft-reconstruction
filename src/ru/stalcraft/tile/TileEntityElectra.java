/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.tile;

import ru.stalcraft.tile.TileEntityExtendedAnomaly;

public class TileEntityElectra
extends TileEntityExtendedAnomaly {
    public int ticks;
    public boolean isEjection = false;
    public int timerActive = 0;
    public int timeParticleSpawn = 0;

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public void h() {
        super.h();
    }

    @Override
    protected Class getEmitterClass() {
        return null;
    }

    @Override
    public boolean b(int par1, int par2) {
        if (par1 == 3) {
            return true;
        }
        return super.b(par1, par2);
    }
}

