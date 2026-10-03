/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 */
package ru.stalcraft.blocks;

import ru.stalcraft.AnomalyDrop;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.blocks.BlockExtendedAnomaly;
import ru.stalcraft.tile.TileEntityElectra;

public class BlockElectra
extends BlockExtendedAnomaly {
    public BlockElectra(int par1, AnomalyDrop drop) {
        super(par1, StalkerMain.fakeAir, drop, "stalker:electra", 0.07f);
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, nn par5Entity) {
        if (!par1World.I && par5Entity instanceof of && BlockElectra.getDistanceSq(par2, par3, par4, par5Entity) <= 2.25 && !par5Entity.ar()) {
            TileEntityElectra tileEntityElectra = (TileEntityElectra)par1World.r(par2, par3, par4);
        }
    }

    public asp b(abw world) {
        return new TileEntityElectra();
    }

    @Override
    public int getLightValue(acf world, int x2, int y2, int z2) {
        return 10;
    }
}

