/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  cpw.mods.fml.common.registry.LanguageRegistry
 *  mt
 */
package ru.stalcraft.blocks;

import cpw.mods.fml.common.registry.LanguageRegistry;
import java.util.Random;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;

public class BlockRespawn
extends aqz {
    public BlockRespawn(int par1) {
        super(par1, StalkerMain.fakeAir);
        this.c("block_respawn");
        this.a(StalkerMain.tab);
        this.r();
        this.a(1.0f);
        LanguageRegistry.addName((Object)this, (String)"\u0422\u043e\u0447\u043a\u0430 \u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u044f");
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.001f, 1.0f);
        this.k(0);
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
    public asx b(abw par1World, int par2, int par3, int par4) {
        return null;
    }

    @Override
    public void a(mt par1IconRegister) {
        this.cW = par1IconRegister.a("stalker:respawn");
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, nn par5Entity) {
        if (!par1World.I && par5Entity instanceof uf) {
            PlayerInfo info = PlayerUtils.getInfo((uf)par5Entity);
            info.setRespawnPoint(par1World.t.i, par2, par3, par4);
        }
    }
}

