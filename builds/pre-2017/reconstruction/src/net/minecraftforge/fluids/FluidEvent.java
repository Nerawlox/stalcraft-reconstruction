/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;

public class FluidEvent
extends Event {
    public final FluidStack fluid;
    public final int x;
    public final int y;
    public final int z;
    public final World world;
    private static ListenerList LISTENER_LIST;

    public FluidEvent(FluidStack fluidStack, World world, int n, int n2, int n3) {
        this.fluid = fluidStack;
        this.world = world;
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    public static final void fireEvent(FluidEvent fluidEvent) {
        MinecraftForge.EVENT_BUS.post(fluidEvent);
    }

    public FluidEvent() {
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

    public static class FluidSpilledEvent
    extends FluidEvent {
        private static ListenerList LISTENER_LIST;

        public FluidSpilledEvent(FluidStack fluidStack, World world, int n, int n2, int n3) {
            super(fluidStack, world, n, n2, n3);
        }

        public FluidSpilledEvent() {
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

    public static class FluidDrainingEvent
    extends FluidEvent {
        public final IFluidTank tank;
        private static ListenerList LISTENER_LIST;

        public FluidDrainingEvent(FluidStack fluidStack, World world, int n, int n2, int n3, IFluidTank iFluidTank) {
            super(fluidStack, world, n, n2, n3);
            this.tank = iFluidTank;
        }

        public FluidDrainingEvent() {
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

    public static class FluidFillingEvent
    extends FluidEvent {
        public final IFluidTank tank;
        private static ListenerList LISTENER_LIST;

        public FluidFillingEvent(FluidStack fluidStack, World world, int n, int n2, int n3, IFluidTank iFluidTank) {
            super(fluidStack, world, n, n2, n3);
            this.tank = iFluidTank;
        }

        public FluidFillingEvent() {
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

    public static class FluidMotionEvent
    extends FluidEvent {
        private static ListenerList LISTENER_LIST;

        public FluidMotionEvent(FluidStack fluidStack, World world, int n, int n2, int n3) {
            super(fluidStack, world, n, n2, n3);
        }

        public FluidMotionEvent() {
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

