/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.terraingen;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.world.WorldEvent;

public class InitNoiseGensEvent
extends WorldEvent {
    public final Random rand;
    public final mcfq[] originalNoiseGens;
    public mcfq[] newNoiseGens;
    private static ListenerList LISTENER_LIST;

    public InitNoiseGensEvent(World world, Random random, mcfq[] mcfqArray) {
        super(world);
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

