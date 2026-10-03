/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.living;

import java.util.ArrayList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.living.LivingEvent;

@Cancelable
public class LivingDropsEvent
extends LivingEvent {
    public final DamageSource source;
    public final ArrayList<EntityItem> drops;
    public final int lootingLevel;
    public final boolean recentlyHit;
    public final int specialDropValue;
    private static ListenerList LISTENER_LIST;

    public LivingDropsEvent(EntityLivingBase entityLivingBase, DamageSource damageSource, ArrayList<EntityItem> arrayList, int n, boolean bl, int n2) {
        super(entityLivingBase);
        this.source = damageSource;
        this.drops = arrayList;
        this.lootingLevel = n;
        this.recentlyHit = bl;
        this.specialDropValue = n2;
    }

    public LivingDropsEvent() {
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

