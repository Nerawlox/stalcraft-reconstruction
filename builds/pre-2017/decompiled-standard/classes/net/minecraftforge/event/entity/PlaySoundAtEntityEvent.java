/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.entity;

import net.minecraft.entity.Entity;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.EntityEvent;

@Cancelable
public class PlaySoundAtEntityEvent
extends EntityEvent {
    public String name;
    public final float volume;
    public final float pitch;
    private static ListenerList LISTENER_LIST;

    public PlaySoundAtEntityEvent(Entity entity, String string, float f, float f2) {
        super(entity);
        this.name = string;
        this.volume = f;
        this.pitch = f2;
    }

    public PlaySoundAtEntityEvent() {
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

