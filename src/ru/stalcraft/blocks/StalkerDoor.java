/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  anz
 */
package ru.stalcraft.blocks;

import ru.stalcraft.StalkerMain;
import ru.stalcraft.clans.IFlag;
import ru.stalcraft.player.PlayerUtils;

public class StalkerDoor
extends anz {
    public StalkerDoor(int par1) {
        super(par1, akc.d);
    }

    public boolean a(abw world, int x2, int y2, int z2, uf player, int side, float x1, float y1, float z1) {
        if (world.I) {
            return true;
        }
        IFlag flag = StalkerMain.flagManager.getFlagNearby(player.ar, x2, z2);
        return flag != null && flag.getClan() != PlayerUtils.getInfo(player).getClan() ? false : super.a(world, x2, y2, z2, player, side, x1, y1, z1);
    }
}

