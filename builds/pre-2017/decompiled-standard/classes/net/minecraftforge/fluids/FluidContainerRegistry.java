/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public abstract class FluidContainerRegistry {
    private static Map<List, FluidContainerData> containerFluidMap = new HashMap<List, FluidContainerData>();
    private static Map<List, FluidContainerData> filledContainerMap = new HashMap<List, FluidContainerData>();
    private static Set<List> emptyContainers = new HashSet<List>();
    public static final int BUCKET_VOLUME = 1000;
    public static final cvzo EMPTY_BUCKET = new cvzo(tgdv.field_77788_aw);
    public static final cvzo EMPTY_BOTTLE = new cvzo(tgdv.field_77729_bt);
    private static final cvzo NULL_EMPTYCONTAINER = new cvzo(tgdv.field_77788_aw);

    private FluidContainerRegistry() {
    }

    public static boolean registerFluidContainer(FluidStack fluidStack, cvzo cvzo2, cvzo cvzo3) {
        return FluidContainerRegistry.registerFluidContainer(new FluidContainerData(fluidStack, cvzo2, cvzo3));
    }

    public static boolean registerFluidContainer(Fluid fluid, cvzo cvzo2, cvzo cvzo3) {
        if (!FluidRegistry.isFluidRegistered(fluid)) {
            FluidRegistry.registerFluid(fluid);
        }
        return FluidContainerRegistry.registerFluidContainer(new FluidStack(fluid, 1000), cvzo2, cvzo3);
    }

    public static boolean registerFluidContainer(FluidStack fluidStack, cvzo cvzo2) {
        return FluidContainerRegistry.registerFluidContainer(new FluidContainerData(fluidStack, cvzo2, null, true));
    }

    public static boolean registerFluidContainer(Fluid fluid, cvzo cvzo2) {
        if (!FluidRegistry.isFluidRegistered(fluid)) {
            FluidRegistry.registerFluid(fluid);
        }
        return FluidContainerRegistry.registerFluidContainer(new FluidStack(fluid, 1000), cvzo2);
    }

    public static boolean registerFluidContainer(FluidContainerData fluidContainerData) {
        if (FluidContainerRegistry.isFilledContainer(fluidContainerData.filledContainer)) {
            return false;
        }
        containerFluidMap.put(Arrays.asList(fluidContainerData.filledContainer._d, fluidContainerData.filledContainer._j()), fluidContainerData);
        if (fluidContainerData.emptyContainer != null && fluidContainerData.emptyContainer != NULL_EMPTYCONTAINER) {
            filledContainerMap.put(Arrays.asList(fluidContainerData.emptyContainer._d, fluidContainerData.emptyContainer._j(), fluidContainerData.fluid.fluidID), fluidContainerData);
            emptyContainers.add(Arrays.asList(fluidContainerData.emptyContainer._d, fluidContainerData.emptyContainer._j()));
        }
        MinecraftForge.EVENT_BUS.post(new FluidContainerRegisterEvent(fluidContainerData));
        return true;
    }

    public static FluidStack getFluidForFilledItem(cvzo cvzo2) {
        if (cvzo2 == null) {
            return null;
        }
        FluidContainerData fluidContainerData = containerFluidMap.get(Arrays.asList(cvzo2._d, cvzo2._j()));
        return fluidContainerData == null ? null : fluidContainerData.fluid.copy();
    }

    public static cvzo fillFluidContainer(FluidStack fluidStack, cvzo cvzo2) {
        if (cvzo2 == null || fluidStack == null) {
            return null;
        }
        FluidContainerData fluidContainerData = filledContainerMap.get(Arrays.asList(cvzo2._d, cvzo2._j(), fluidStack.fluidID));
        if (fluidContainerData != null && fluidStack.amount >= fluidContainerData.fluid.amount) {
            return fluidContainerData.filledContainer._l();
        }
        return null;
    }

    public static boolean containsFluid(cvzo cvzo2, FluidStack fluidStack) {
        if (cvzo2 == null || fluidStack == null) {
            return false;
        }
        FluidContainerData fluidContainerData = filledContainerMap.get(Arrays.asList(cvzo2._d, cvzo2._j(), fluidStack.fluidID));
        return fluidContainerData == null ? false : fluidContainerData.fluid.isFluidEqual(fluidStack);
    }

    public static boolean isBucket(cvzo cvzo2) {
        if (cvzo2 == null) {
            return false;
        }
        if (cvzo2._b(EMPTY_BUCKET)) {
            return true;
        }
        FluidContainerData fluidContainerData = containerFluidMap.get(Arrays.asList(cvzo2._d, cvzo2._j()));
        return fluidContainerData != null && fluidContainerData.emptyContainer._b(EMPTY_BUCKET);
    }

    public static boolean isContainer(cvzo cvzo2) {
        return FluidContainerRegistry.isEmptyContainer(cvzo2) || FluidContainerRegistry.isFilledContainer(cvzo2);
    }

    public static boolean isEmptyContainer(cvzo cvzo2) {
        return cvzo2 != null && emptyContainers.contains(Arrays.asList(cvzo2._d, cvzo2._j()));
    }

    public static boolean isFilledContainer(cvzo cvzo2) {
        return cvzo2 != null && FluidContainerRegistry.getFluidForFilledItem(cvzo2) != null;
    }

    public static FluidContainerData[] getRegisteredFluidContainerData() {
        return containerFluidMap.values().toArray(new FluidContainerData[containerFluidMap.size()]);
    }

    static {
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.WATER, new cvzo(tgdv.field_77786_ax), EMPTY_BUCKET);
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.LAVA, new cvzo(tgdv.field_77775_ay), EMPTY_BUCKET);
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.WATER, new cvzo(tgdv.field_77726_bs), EMPTY_BOTTLE);
    }

    public static class FluidContainerRegisterEvent
    extends Event {
        public final FluidContainerData data;
        private static ListenerList LISTENER_LIST;

        public FluidContainerRegisterEvent(FluidContainerData fluidContainerData) {
            this.data = fluidContainerData.copy();
        }

        public FluidContainerRegisterEvent() {
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

    public static class FluidContainerData {
        public final FluidStack fluid;
        public final cvzo filledContainer;
        public final cvzo emptyContainer;

        public FluidContainerData(FluidStack fluidStack, cvzo cvzo2, cvzo cvzo3) {
            this(fluidStack, cvzo2, cvzo3, false);
        }

        public FluidContainerData(FluidStack fluidStack, cvzo cvzo2, cvzo cvzo3, boolean bl) {
            this.fluid = fluidStack;
            this.filledContainer = cvzo2;
            cvzo cvzo4 = this.emptyContainer = cvzo3 == null ? NULL_EMPTYCONTAINER : cvzo3;
            if (fluidStack == null || cvzo2 == null || cvzo3 == null && !bl) {
                throw new RuntimeException("Invalid FluidContainerData - a parameter was null.");
            }
        }

        public FluidContainerData copy() {
            return new FluidContainerData(this.fluid, this.filledContainer, this.emptyContainer, true);
        }
    }
}

