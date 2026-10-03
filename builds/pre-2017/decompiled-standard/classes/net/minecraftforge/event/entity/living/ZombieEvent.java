/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.living;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.EntityEvent;

public class ZombieEvent
extends EntityEvent {
    private static ListenerList LISTENER_LIST;

    public ZombieEvent(EntityZombie entityZombie) {
        super(entityZombie);
    }

    public EntityZombie getSummoner() {
        return (EntityZombie)this.entity;
    }

    public ZombieEvent() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (LISTENER_LIST != null) {
            return;
        }
        LISTENER_LIST = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return LISTENER_LIST;
    }

    @Event.HasResult
    public static class SummonAidEvent
    extends ZombieEvent {
        public EntityZombie customSummonedAid;
        public final ozlu world;
        public final int x;
        public final int y;
        public final int z;
        public final EntityLivingBase attacker;
        public final double summonChance;
        private static ListenerList LISTENER_LIST;

        public SummonAidEvent(EntityZombie entityZombie, ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, double d) {
            super(entityZombie);
            this.world = ozlu2;
            this.x = n;
            this.y = n2;
            this.z = n3;
            this.attacker = entityLivingBase;
            this.summonChance = d;
        }

        public SummonAidEvent() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (LISTENER_LIST != null) {
                return;
            }
            LISTENER_LIST = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return LISTENER_LIST;
        }
    }
}

