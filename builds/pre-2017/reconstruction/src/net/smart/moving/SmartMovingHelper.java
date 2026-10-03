/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.smart.moving.SmartMovingFactory;
import net.smart.moving.SmartMovingSelf;

public class SmartMovingHelper
extends rpdf {
    @Override
    public boolean isPlayerRunning(EntityPlayer entityPlayer) {
        return SmartMovingFactory.getInstance((EntityPlayer)entityPlayer).isFast;
    }

    @Override
    public boolean isPlayerCrawling(EntityPlayer entityPlayer) {
        return SmartMovingFactory.getInstance((EntityPlayer)entityPlayer).isCrawling;
    }

    @Override
    public int getClientCrawlChangeTicks() {
        return ((SmartMovingSelf)SmartMovingFactory.getInstance((EntityPlayer)Minecraft._E()._t)).anticheat.__aF;
    }
}

