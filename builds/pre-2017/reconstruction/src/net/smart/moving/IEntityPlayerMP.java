/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import java.util.List;
import java.util.logging.Logger;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.AxisAlignedBB;
import net.smart.moving.IPacketSender;
import net.smart.moving.SmartMovingServer;

public interface IEntityPlayerMP
extends IPacketSender {
    public void sendPacketToTrackedPlayers(Packet250CustomPayload var1);

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

    public AxisAlignedBB getBox();

    public AxisAlignedBB expandBox(AxisAlignedBB var1, double var2, double var4, double var6);

    public List getEntitiesExcludingPlayer(AxisAlignedBB var1);

    public boolean isDeadEntity(Entity var1);

    public void onCollideWithPlayer(Entity var1);

    public void localAddExhaustion(float var1);

    public void localAddMovementStat(double var1, double var3, double var5);

    public void localPlaySound(String var1, float var2, float var3);
}

