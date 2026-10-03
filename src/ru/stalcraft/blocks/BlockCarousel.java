/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.blocks;

import ru.stalcraft.AnomalyDrop;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.blocks.BlockExtendedAnomaly;
import ru.stalcraft.entity.EntityGrenade;
import ru.stalcraft.tile.TileEntityCarousel;

public class BlockCarousel
extends BlockExtendedAnomaly {
    public BlockCarousel(int par1, AnomalyDrop drop) {
        super(par1, StalkerMain.fakeAir, drop, "stalker:carousel", 0.05f);
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, nn par5Entity) {
        if (!par1World.I && par5Entity instanceof of && !par5Entity.ar()) {
            if (par5Entity instanceof uf && ((uf)par5Entity).bG.d) {
                return;
            }
            ((TileEntityCarousel)par1World.r(par2, par3, par4)).addTarget((of)par5Entity);
        }
        if (par5Entity instanceof EntityGrenade) {
            par5Entity.g(0.0, 1.0, 0.0);
        }
    }

    public asp b(abw world) {
        return new TileEntityCarousel();
    }
}

