/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aoe
 */
package ru.stalcraft.blocks;

import ru.stalcraft.AnomalyDrop;
import ru.stalcraft.Config;
import ru.stalcraft.StalkerDamage;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.blocks.BlockAnomaly;
import ru.stalcraft.entity.EntityGrenade;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.tile.TileEntityTrampoline;

public class BlockTrampoline
extends BlockAnomaly
implements aoe {
    public BlockTrampoline(int id, AnomalyDrop drop) {
        super(id, StalkerMain.fakeAir, drop, "stalker:trampoline", 0.05f);
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, nn par5Entity) {
        if (!par5Entity.ar() && par5Entity instanceof of || par5Entity instanceof EntityGrenade && (par5Entity.F || par5Entity.y < 0.0)) {
            par5Entity.g(0.0, 1.1, 0.0);
            if (par1World.I) {
                ((TileEntityTrampoline)par1World.r(par2, par3, par4)).onActivate();
            } else {
                float par6 = Config.trampolineDamage;
                if (par5Entity instanceof uf) {
                    PlayerInfo playerInfo = PlayerUtils.getInfo((uf)par5Entity);
                }
                par5Entity.a(StalkerDamage.trampoline, (float)Config.trampolineDamage);
                par5Entity.q.a(par5Entity, "stalker:trampoline_hit", 1.0f, 1.0f);
            }
        }
    }

    public asp b(abw world) {
        return new TileEntityTrampoline();
    }
}

