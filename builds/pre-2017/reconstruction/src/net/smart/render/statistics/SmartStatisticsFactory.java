/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render.statistics;

import java.util.Hashtable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.smart.render.statistics.IEntityPlayerSP;
import net.smart.render.statistics.SmartStatistics;
import net.smart.render.statistics.SmartStatisticsOther;

public class SmartStatisticsFactory {
    private static SmartStatisticsFactory factory;
    private Hashtable otherStatistics;

    public SmartStatisticsFactory() {
        if (factory != null) {
            throw new RuntimeException("FATAL: Can only create one instance of type 'StatisticsFactory'");
        }
        factory = this;
    }

    protected static boolean isInitialized() {
        return factory != null;
    }

    public static void initialize() {
        if (!SmartStatisticsFactory.isInitialized()) {
            new SmartStatisticsFactory();
        }
    }

    public static void handleMultiPlayerTick(Minecraft minecraft) {
        factory.doHandleMultiPlayerTick(minecraft);
    }

    public static SmartStatistics getInstance(EntityPlayer entityPlayer) {
        return factory.doGetInstance(entityPlayer);
    }

    public static SmartStatisticsOther getOtherStatistics(int n) {
        return factory.doGetOtherStatistics(n);
    }

    public static SmartStatisticsOther getOtherStatistics(EntityOtherPlayerMP entityOtherPlayerMP) {
        return factory.doGetOtherStatistics(entityOtherPlayerMP);
    }

    protected void doHandleMultiPlayerTick(Minecraft minecraft) {
        SmartStatisticsOther smartStatisticsOther;
        Object object;
        for (Object object2 : minecraft._r.playerEntities) {
            if (!(object2 instanceof EntityOtherPlayerMP)) continue;
            object = (EntityOtherPlayerMP)object2;
            smartStatisticsOther = this.doGetOtherStatistics((EntityOtherPlayerMP)object);
            smartStatisticsOther.calculateAllStats();
            smartStatisticsOther.foundAlive = true;
        }
        if (this.otherStatistics != null && !this.otherStatistics.isEmpty()) {
            Object object2;
            object2 = this.otherStatistics.keySet().iterator();
            while (object2.hasNext()) {
                object = (Integer)object2.next();
                smartStatisticsOther = (SmartStatisticsOther)this.otherStatistics.get(object);
                if (smartStatisticsOther.foundAlive) {
                    smartStatisticsOther.foundAlive = false;
                    continue;
                }
                object2.remove();
            }
        }
    }

    protected SmartStatistics doGetInstance(EntityPlayer entityPlayer) {
        return entityPlayer instanceof EntityOtherPlayerMP ? this.doGetOtherStatistics(entityPlayer.entityId) : (entityPlayer instanceof IEntityPlayerSP ? ((IEntityPlayerSP)((Object)entityPlayer)).getStatistics() : null);
    }

    protected SmartStatisticsOther doGetOtherStatistics(int n) {
        Entity entity;
        SmartStatisticsOther smartStatisticsOther = this.tryGetOtherStatistics(n);
        if (smartStatisticsOther == null && (entity = Minecraft._E()._r.getEntityByID(n)) != null && entity instanceof EntityOtherPlayerMP) {
            smartStatisticsOther = this.addOtherStatistics((EntityOtherPlayerMP)entity);
        }
        return smartStatisticsOther;
    }

    protected SmartStatisticsOther doGetOtherStatistics(EntityOtherPlayerMP entityOtherPlayerMP) {
        SmartStatisticsOther smartStatisticsOther = this.tryGetOtherStatistics(entityOtherPlayerMP.entityId);
        if (smartStatisticsOther == null) {
            smartStatisticsOther = this.addOtherStatistics(entityOtherPlayerMP);
        }
        return smartStatisticsOther;
    }

    protected final SmartStatisticsOther tryGetOtherStatistics(int n) {
        if (this.otherStatistics == null) {
            this.otherStatistics = new Hashtable();
        }
        return (SmartStatisticsOther)this.otherStatistics.get(n);
    }

    protected final SmartStatisticsOther addOtherStatistics(EntityOtherPlayerMP entityOtherPlayerMP) {
        SmartStatisticsOther smartStatisticsOther = new SmartStatisticsOther(entityOtherPlayerMP);
        this.otherStatistics.put(entityOtherPlayerMP.entityId, smartStatisticsOther);
        return smartStatisticsOther;
    }
}

