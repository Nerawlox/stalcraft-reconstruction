/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  mt
 */
package ru.stalcraft.blocks;

import java.util.Random;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.player.PlayerUtils;

public class BlockDebuff
extends aqz {
    public int effectID;
    public int level;
    public int tickTimeInc;

    public BlockDebuff(int blockID, int effectID, int effectLevel, int tickTimeIncrease) {
        super(blockID, StalkerMain.fakeAir);
        this.effectID = effectID;
        this.level = effectLevel;
        this.tickTimeInc = tickTimeIncrease;
        this.a(StalkerMain.tab);
        this.b(false);
        this.c(10000.0f);
        this.b(20000.0f);
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, nn par5Entity) {
        if (par5Entity instanceof uf) {
            uf player = (uf)par5Entity;
            if (!player.q.I) {
                PlayerUtils.getInfo((uf)player).cont.addEffect(this.effectID, this.tickTimeInc, this.level);
            }
        }
    }

    @Override
    public int a(Random par1Random) {
        return 0;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public asx c_(abw par1World, int par2, int par3, int par4) {
        return atv.w().c.h() ? asx.a().a((double)par2 + this.cM, (double)par3 + this.cN, (double)par4 + this.cO, (double)par2 + this.cP, (double)par3 + this.cQ, (double)par4 + this.cR) : null;
    }

    @Override
    public asx b(abw par1World, int par2, int par3, int par4) {
        return null;
    }

    @Override
    public boolean isAirBlock(abw world, int x2, int y2, int z2) {
        return true;
    }

    @Override
    public void a(mt par1IconRegister) {
        this.cW = par1IconRegister.a("stalker:transparent");
    }
}

