/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.playerapi;

import net.minecraft.entity.player.EntityPlayer;
import net.smart.moving.IEntityPlayerSP;
import net.smart.moving.SmartMoving;

public class SmartMovingFactory
extends net.smart.moving.SmartMovingFactory {
    public static void initialize() {
        if (!SmartMovingFactory.isInitialized()) {
            new SmartMovingFactory();
        }
    }

    @Override
    protected SmartMoving doGetInstance(EntityPlayer entityPlayer) {
        SmartMoving smartMoving = super.doGetInstance(entityPlayer);
        if (smartMoving != null) {
            return smartMoving;
        }
        IEntityPlayerSP iEntityPlayerSP = net.smart.moving.playerapi.SmartMoving.getPlayerBase(entityPlayer);
        return iEntityPlayerSP != null ? iEntityPlayerSP.getMoving() : null;
    }
}

