/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.blocks;

import ru.stalcraft.AnomalyDrop;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.blocks.BlockAnomaly;
import ru.stalcraft.tile.TileEntityLighter;

public class BlockLighter
extends BlockAnomaly {
    public BlockLighter(int par1, AnomalyDrop drop) {
        super(par1, StalkerMain.fakeAir, drop, "stalker:lighter", 0.0f);
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, nn par5Entity) {
        if (!par5Entity.ar() && par5Entity instanceof of) {
            TileEntityLighter tile = (TileEntityLighter)par1World.r(par2, par3, par4);
            if (par1World.I) {
                tile.onClientCollide();
            } else {
                tile.onServerCollide((of)par5Entity);
            }
        }
    }

    public asp b(abw world) {
        return new TileEntityLighter();
    }
}

