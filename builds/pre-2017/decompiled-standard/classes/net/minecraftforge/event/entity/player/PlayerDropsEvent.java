/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity.player;

import java.util.ArrayList;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.jxtc;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

@Cancelable
public class PlayerDropsEvent
extends LivingDropsEvent {
    public final EntityPlayer entityPlayer;
    private static ListenerList LISTENER_LIST;

    public PlayerDropsEvent(EntityPlayer entityPlayer, jxtc jxtc2, ArrayList<EntityItem> arrayList, boolean bl) {
        super(entityPlayer, jxtc2, arrayList, jxtc2.func_76346_g() instanceof EntityPlayer ? zhty._f((EntityPlayer)jxtc2.func_76346_g()) : 0, bl, 0);
        this.entityPlayer = entityPlayer;
    }

    public PlayerDropsEvent() {
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

