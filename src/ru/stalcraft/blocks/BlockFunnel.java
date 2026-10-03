/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.blocks;

import ru.stalcraft.AnomalyDrop;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.blocks.BlockAnomaly;
import ru.stalcraft.tile.TileEntityFunnel;

public class BlockFunnel
extends BlockAnomaly {
    public BlockFunnel(int par1, AnomalyDrop drop) {
        super(par1, StalkerMain.fakeAir, drop, "stalker:blackhole", 0.01f);
    }

    @Override
    public void a(abw par1, int par2, int par3, int par4, nn par6) {
        if (!par1.I) {
            if (par6 instanceof uf && !((uf)par6).bG.d) {
                par6.am();
            } else if (par6 instanceof of && !(par6 instanceof uf)) {
                par6.am();
            }
        }
    }

    public asp b(abw world) {
        return new TileEntityFunnel();
    }
}

