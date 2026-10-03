/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  asx
 *  mt
 */
package ru.stalcraft.blocks;

import java.util.Random;
import ru.stalcraft.blocks.BlockExtendedAnomaly;

public class BlockAnomalyNeighbor
extends aqz {
    public BlockAnomalyNeighbor(int par1) {
        super(par1, akc.a);
        this.r();
        this.a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, nn par5Entity) {
        for (int x2 = -1; x2 < 2; ++x2) {
            for (int y2 = -1; y2 < 2; ++y2) {
                for (int z2 = -1; z2 < 2; ++z2) {
                    int blockId = par1World.a(par2 + x2, par3 + y2, par4 + z2);
                    if (!BlockExtendedAnomaly.isExtendedAnomaly(blockId)) continue;
                    aqz.s[blockId].a(par1World, par2 + x2, par3 + y2, par4 + z2, par5Entity);
                }
            }
        }
    }

    @Override
    public int d() {
        return -1;
    }

    @Override
    public int a(Random par1Random) {
        return 0;
    }

    @Override
    public boolean c() {
        return false;
    }

    public void checkIsValid(abw w2, int blockX, int blockY, int blockZ) {
        for (int x2 = -1; x2 < 2; ++x2) {
            for (int y2 = -1; y2 < 2; ++y2) {
                for (int z2 = -1; z2 < 2; ++z2) {
                    int blockId = w2.a(blockX + x2, blockY + y2, blockZ + z2);
                    if (!BlockExtendedAnomaly.isExtendedAnomaly(blockId)) continue;
                    return;
                }
            }
        }
        w2.c(blockX, blockY, blockZ, 0);
    }

    @Override
    public asx b(abw par1World, int par2, int par3, int par4) {
        return null;
    }

    @Override
    public void a(mt par1IconRegister) {
        this.cW = par1IconRegister.a("stalker:transparent");
    }

    @Override
    public boolean isAirBlock(abw world, int x2, int y2, int z2) {
        return true;
    }
}

