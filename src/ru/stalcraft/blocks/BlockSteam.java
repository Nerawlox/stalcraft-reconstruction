/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.blocks;

import ru.stalcraft.AnomalyDrop;
import ru.stalcraft.Config;
import ru.stalcraft.StalkerDamage;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.blocks.BlockAnomaly;
import ru.stalcraft.tile.TileEntityAnomaly;
import ru.stalcraft.tile.TileEntitySteam;

public class BlockSteam
extends BlockAnomaly {
    public BlockSteam(int par1, AnomalyDrop drop) {
        super(par1, StalkerMain.fakeAir, drop, "stalker:steam", 0.03f);
    }

    @Override
    public void a(abw par1, int par2, int par3, int par4, nn par5Entity) {
        if (!par5Entity.ar() && par5Entity instanceof of && !par1.I) {
            TileEntitySteam par6 = (TileEntitySteam)par1.r(par2, par3, par4);
            if (par6.tickTile % 25 == 0) {
                TileEntityAnomaly.damageEntityForce((of)par5Entity, StalkerDamage.steam, Config.steamDamage, true);
            }
            ++par6.tickTile;
            if (par6.tickTile >= 37500) {
                par6.tickTile = 0;
            }
        }
    }

    public asp b(abw world) {
        return new TileEntitySteam();
    }
}

