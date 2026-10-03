/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.liquids;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.LiquidStack;

@Deprecated
public class LiquidEvent
extends Event {
    public final LiquidStack liquid;
    public final int x;
    public final int y;
    public final int z;
    public final ozlu world;
    private static ListenerList LISTENER_LIST;

    public LiquidEvent(LiquidStack liquidStack, ozlu ozlu2, int n, int n2, int n3) {
        this.liquid = liquidStack;
        this.world = ozlu2;
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    public static final void fireEvent(LiquidEvent liquidEvent) {
        MinecraftForge.EVENT_BUS.post(liquidEvent);
    }

    public LiquidEvent() {
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

    public static class LiquidSpilledEvent
    extends LiquidEvent {
        private static ListenerList LISTENER_LIST;

        public LiquidSpilledEvent(LiquidStack liquidStack, ozlu ozlu2, int n, int n2, int n3) {
            super(liquidStack, ozlu2, n, n2, n3);
        }

        public LiquidSpilledEvent() {
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

    public static class LiquidDrainingEvent
    extends LiquidEvent {
        public final ILiquidTank tank;
        private static ListenerList LISTENER_LIST;

        public LiquidDrainingEvent(LiquidStack liquidStack, ozlu ozlu2, int n, int n2, int n3, ILiquidTank iLiquidTank) {
            super(liquidStack, ozlu2, n, n2, n3);
            this.tank = iLiquidTank;
        }

        public LiquidDrainingEvent() {
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

    public static class LiquidFillingEvent
    extends LiquidEvent {
        public final ILiquidTank tank;
        private static ListenerList LISTENER_LIST;

        public LiquidFillingEvent(LiquidStack liquidStack, ozlu ozlu2, int n, int n2, int n3, ILiquidTank iLiquidTank) {
            super(liquidStack, ozlu2, n, n2, n3);
            this.tank = iLiquidTank;
        }

        public LiquidFillingEvent() {
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

    public static class LiquidMotionEvent
    extends LiquidEvent {
        private static ListenerList LISTENER_LIST;

        public LiquidMotionEvent(LiquidStack liquidStack, ozlu ozlu2, int n, int n2, int n3) {
            super(liquidStack, ozlu2, n, n2, n3);
        }

        public LiquidMotionEvent() {
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

