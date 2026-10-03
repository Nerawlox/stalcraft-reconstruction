/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 */
package ru.stalcraft.items;

import ru.stalcraft.StalkerMain;
import ru.stalcraft.clans.IClan;
import ru.stalcraft.clans.IFlag;
import ru.stalcraft.entity.EntityTurrel;
import ru.stalcraft.player.PlayerUtils;

public abstract class ItemTurrel
extends yc {
    public ItemTurrel(int par1) {
        super(par1);
        this.cw = 1;
        this.a(StalkerMain.tab);
    }

    @Override
    public boolean a(ye stack, uf player, abw world, int x2, int y2, int z2, int side, float par8, float par9, float par10) {
        if (side == 1 && !world.I) {
            for (int clan = 0; clan < 9; ++clan) {
                if (world.a(x2 - 1 + clan / 3, y2 + 1, z2 - 1 + clan % 3) == 0) continue;
                return false;
            }
            IClan var14 = PlayerUtils.getInfo(player).getClan();
            if (var14 == null) {
                player.a("\u0412\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442\u0435 \u0432 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0435!");
                return false;
            }
            IFlag flag = StalkerMain.flagManager.getFlagNearby(world.t.i, x2, z2);
            if (flag != null && flag.getClan() == var14) {
                EntityTurrel entity = this.getTurrel(world, var14.getName(), asx.a((double)(flag.getPosZ() - 16), (double)0.0, (double)(flag.getPosY() - 16), (double)(flag.getPosX() + 17), (double)256.0, (double)(flag.getPosZ() + 17)));
                entity.b((double)x2 + 0.5, y2 + 1, (double)z2 + 0.5);
                world.d(entity);
                if (!player.bG.d) {
                    --stack.b;
                }
                return true;
            }
            player.a("\u042d\u0442\u043e \u043d\u0435 \u0442\u0435\u0440\u0440\u0438\u0442\u043e\u0440\u0438\u044f \u0432\u0430\u0448\u0435\u0439 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438!");
            return false;
        }
        return false;
    }

    protected abstract EntityTurrel getTurrel(abw var1, String var2, asx var3);
}

