/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.entity.player.PlayerEvent;
import noppes.npcs.controllers.Quest;

public class QuestStartedEvent
extends PlayerEvent {
    public final Quest quest;
    private static ListenerList LISTENER_LIST;

    public QuestStartedEvent(EntityPlayer entityPlayer, Quest quest) {
        super(entityPlayer);
        this.quest = quest;
    }

    public QuestStartedEvent() {
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

