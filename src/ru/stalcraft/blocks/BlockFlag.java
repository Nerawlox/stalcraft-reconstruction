/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ake
 *  aoe
 *  asx
 *  cpw.mods.fml.common.registry.LanguageRegistry
 */
package ru.stalcraft.blocks;

import cpw.mods.fml.common.registry.LanguageRegistry;
import java.util.Random;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.blocks.MaterialFlag;
import ru.stalcraft.tile.TileEntityFlag;

public class BlockFlag
extends aqz
implements aoe {
    public BlockFlag(int par1) {
        super(par1, new MaterialFlag(ake.e));
        this.c("block_flag");
        this.a(StalkerMain.tab);
        this.b(100000.0f);
        this.c(5.0f);
        LanguageRegistry.addName((Object)this, (String)"\u0424\u043b\u0430\u0433");
        this.d("stalker:transparent");
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
    public void a(abw world, int x2, int y2, int z2, of entity, ye par6ItemStack) {
        if (!world.I) {
            StalkerMain.flagManager.onFlagPlace(world, x2, y2, z2, (jv)entity);
        } else {
            world.c(x2, y2, z2, 0);
        }
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, int par5, int par6) {
        super.a(par1World, par2, par3, par4, par5, par6);
        if (!par1World.I) {
            StalkerMain.flagManager.onBlockFlagRemoved(par1World.t.i, par2, par3, par4);
        }
    }

    @Override
    public boolean a(abw par1World, int x2, int y2, int z2, uf player, int par6, float par7, float par8, float par9) {
        if (!par1World.I) {
            StalkerMain.flagManager.tryJoinClanLand(player, x2, y2, z2);
        }
        return true;
    }

    public asp b(abw world) {
        return new TileEntityFlag();
    }
}

