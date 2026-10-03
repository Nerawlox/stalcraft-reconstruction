/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import java.util.Hashtable;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.smart.moving.IEntityPlayerSP;
import net.smart.moving.SmartMoving;
import net.smart.moving.SmartMovingContext;
import net.smart.moving.SmartMovingOther;

public class SmartMovingFactory
extends SmartMovingContext {
    private static SmartMovingFactory factory;
    private Hashtable otherSmartMovings;

    public SmartMovingFactory() {
        if (factory != null) {
            throw new RuntimeException("FATAL: Can only create one instance of type 'SmartMovingFactory'");
        }
        factory = this;
    }

    public static boolean isInitialized() {
        return factory != null;
    }

    public static void initialize() {
        if (!SmartMovingFactory.isInitialized()) {
            new SmartMovingFactory();
        }
    }

    public static void handleMultiPlayerTick(xpzm xpzm2) {
        factory.doHandleMultiPlayerTick(xpzm2);
    }

    public static SmartMoving getInstance(EntityPlayer entityPlayer) {
        return factory.doGetInstance(entityPlayer);
    }

    public static SmartMoving getOtherSmartMoving(int n) {
        return factory.doGetOtherSmartMoving(n);
    }

    public static SmartMovingOther getOtherSmartMoving(EntityOtherPlayerMP entityOtherPlayerMP) {
        return factory.doGetOtherSmartMoving(entityOtherPlayerMP);
    }

    protected void doHandleMultiPlayerTick(xpzm xpzm2) {
        SmartMovingOther smartMovingOther;
        Object object;
        for (Object object2 : xpzm2._r.field_73010_i) {
            if (!(object2 instanceof EntityOtherPlayerMP)) continue;
            object = (EntityOtherPlayerMP)object2;
            smartMovingOther = this.doGetOtherSmartMoving((EntityOtherPlayerMP)object);
            smartMovingOther.spawnParticles(xpzm2, ((Entity)object).field_70165_t - ((Entity)object).field_70169_q, ((Entity)object).field_70161_v - ((Entity)object).field_70166_s);
            smartMovingOther.foundAlive = true;
        }
        if (this.otherSmartMovings != null && !this.otherSmartMovings.isEmpty()) {
            Object object2;
            object2 = this.otherSmartMovings.keySet().iterator();
            while (object2.hasNext()) {
                object = (Integer)object2.next();
                smartMovingOther = (SmartMovingOther)this.otherSmartMovings.get(object);
                if (smartMovingOther.foundAlive) {
                    smartMovingOther.foundAlive = false;
                    continue;
                }
                object2.remove();
            }
        }
    }

    protected SmartMoving doGetInstance(EntityPlayer entityPlayer) {
        return entityPlayer instanceof EntityOtherPlayerMP ? this.doGetOtherSmartMoving(entityPlayer.field_70157_k) : (entityPlayer instanceof IEntityPlayerSP ? ((IEntityPlayerSP)((Object)entityPlayer)).getMoving() : null);
    }

    protected SmartMoving doGetOtherSmartMoving(int n) {
        Entity entity;
        SmartMovingOther smartMovingOther = this.tryGetOtherSmartMoving(n);
        if (smartMovingOther == null && (entity = xpzm._E()._r.func_73045_a(n)) != null && entity instanceof EntityOtherPlayerMP) {
            smartMovingOther = this.addOtherSmartMoving((EntityOtherPlayerMP)entity);
        }
        return smartMovingOther;
    }

    protected SmartMovingOther doGetOtherSmartMoving(EntityOtherPlayerMP entityOtherPlayerMP) {
        SmartMovingOther smartMovingOther = this.tryGetOtherSmartMoving(entityOtherPlayerMP.field_70157_k);
        if (smartMovingOther == null) {
            smartMovingOther = this.addOtherSmartMoving(entityOtherPlayerMP);
        }
        return smartMovingOther;
    }

    protected final SmartMovingOther tryGetOtherSmartMoving(int n) {
        if (this.otherSmartMovings == null) {
            this.otherSmartMovings = new Hashtable();
        }
        return (SmartMovingOther)this.otherSmartMovings.get(n);
    }

    protected final SmartMovingOther addOtherSmartMoving(EntityOtherPlayerMP entityOtherPlayerMP) {
        SmartMovingOther smartMovingOther = new SmartMovingOther(entityOtherPlayerMP);
        this.otherSmartMovings.put(entityOtherPlayerMP.field_70157_k, smartMovingOther);
        return smartMovingOther;
    }
}

