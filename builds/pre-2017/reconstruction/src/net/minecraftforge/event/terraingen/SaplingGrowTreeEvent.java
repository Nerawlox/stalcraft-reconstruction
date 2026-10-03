/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event.terraingen;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.event.world.WorldEvent;

@Event.HasResult
public class SaplingGrowTreeEvent
extends WorldEvent {
    public final int x;
    public final int y;
    public final int z;
    public final Random rand;
    private static ListenerList LISTENER_LIST;

    public SaplingGrowTreeEvent(World world, Random random, int n, int n2, int n3) {
        super(world);
        this.rand = random;
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    public SaplingGrowTreeEvent() {
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

