/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.terraingen;

import java.util.Random;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.world.WorldEvent;

public class InitNoiseGensEvent
extends WorldEvent {
    public final Random rand;
    public final mcfq[] originalNoiseGens;
    public mcfq[] newNoiseGens;
    private static ListenerList LISTENER_LIST;

    public InitNoiseGensEvent(ozlu ozlu2, Random random, mcfq[] mcfqArray) {
        super(ozlu2);
        this.rand = random;
        this.originalNoiseGens = mcfqArray;
        this.newNoiseGens = (mcfq[])mcfqArray.clone();
    }

    public InitNoiseGensEvent() {
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

