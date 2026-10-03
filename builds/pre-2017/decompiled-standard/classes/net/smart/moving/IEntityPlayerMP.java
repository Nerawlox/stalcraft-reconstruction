/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import java.util.List;
import java.util.logging.Logger;
import net.minecraft.entity.Entity;
import net.minecraft.util.eidj;
import net.smart.moving.IPacketSender;
import net.smart.moving.SmartMovingServer;

public interface IEntityPlayerMP
extends IPacketSender {
    public void sendPacketToTrackedPlayers(jjqf var1);

    public String getUsername();

    public void resetFallDistance();

    public void resetTicksForFloatKick();

    public Logger getLogger();

    public void setHeight(float var1);

    public double getMinY();

    public float getHeight();

    public void setMaxY(double var1);

    public boolean localIsEntityInsideOpaqueBlock();

    public SmartMovingServer getMoving();

    public IEntityPlayerMP[] getAllPlayers();

    public float doGetHealth();

    public eidj getBox();

    public eidj expandBox(eidj var1, double var2, double var4, double var6);

    public List getEntitiesExcludingPlayer(eidj var1);

    public boolean isDeadEntity(Entity var1);

    public void onCollideWithPlayer(Entity var1);

    public void localAddExhaustion(float var1);

    public void localAddMovementStat(double var1, double var3, double var5);

    public void localPlaySound(String var1, float var2, float var3);
}

