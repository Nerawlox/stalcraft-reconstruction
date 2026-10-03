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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
    public static final ItemStack EMPTY_BUCKET = new ItemStack(Item.bucketEmpty);
    public static final ItemStack EMPTY_BOTTLE = new ItemStack(Item.glassBottle);
    private static final ItemStack NULL_EMPTYCONTAINER = new ItemStack(Item.bucketEmpty);

    private FluidContainerRegistry() {
    }

    public static boolean registerFluidContainer(FluidStack fluidStack, ItemStack itemStack, ItemStack itemStack2) {
        return FluidContainerRegistry.registerFluidContainer(new FluidContainerData(fluidStack, itemStack, itemStack2));
    }

    public static boolean registerFluidContainer(Fluid fluid, ItemStack itemStack, ItemStack itemStack2) {
        if (!FluidRegistry.isFluidRegistered(fluid)) {
            FluidRegistry.registerFluid(fluid);
        }
        return FluidContainerRegistry.registerFluidContainer(new FluidStack(fluid, 1000), itemStack, itemStack2);
    }

    public static boolean registerFluidContainer(FluidStack fluidStack, ItemStack itemStack) {
        return FluidContainerRegistry.registerFluidContainer(new FluidContainerData(fluidStack, itemStack, null, true));
    }

    public static boolean registerFluidContainer(Fluid fluid, ItemStack itemStack) {
        if (!FluidRegistry.isFluidRegistered(fluid)) {
            FluidRegistry.registerFluid(fluid);
        }
        return FluidContainerRegistry.registerFluidContainer(new FluidStack(fluid, 1000), itemStack);
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

    public static FluidStack getFluidForFilledItem(ItemStack itemStack) {
        if (itemStack == null) {
            return null;
        }
        FluidContainerData fluidContainerData = containerFluidMap.get(Arrays.asList(itemStack._d, itemStack._j()));
        return fluidContainerData == null ? null : fluidContainerData.fluid.copy();
    }

    public static ItemStack fillFluidContainer(FluidStack fluidStack, ItemStack itemStack) {
        if (itemStack == null || fluidStack == null) {
            return null;
        }
        FluidContainerData fluidContainerData = filledContainerMap.get(Arrays.asList(itemStack._d, itemStack._j(), fluidStack.fluidID));
        if (fluidContainerData != null && fluidStack.amount >= fluidContainerData.fluid.amount) {
            return fluidContainerData.filledContainer._l();
        }
        return null;
    }

    public static boolean containsFluid(ItemStack itemStack, FluidStack fluidStack) {
        if (itemStack == null || fluidStack == null) {
            return false;
        }
        FluidContainerData fluidContainerData = filledContainerMap.get(Arrays.asList(itemStack._d, itemStack._j(), fluidStack.fluidID));
        return fluidContainerData == null ? false : fluidContainerData.fluid.isFluidEqual(fluidStack);
    }

    public static boolean isBucket(ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if (itemStack._b(EMPTY_BUCKET)) {
            return true;
        }
        FluidContainerData fluidContainerData = containerFluidMap.get(Arrays.asList(itemStack._d, itemStack._j()));
        return fluidContainerData != null && fluidContainerData.emptyContainer._b(EMPTY_BUCKET);
    }

    public static boolean isContainer(ItemStack itemStack) {
        return FluidContainerRegistry.isEmptyContainer(itemStack) || FluidContainerRegistry.isFilledContainer(itemStack);
    }

    public static boolean isEmptyContainer(ItemStack itemStack) {
        return itemStack != null && emptyContainers.contains(Arrays.asList(itemStack._d, itemStack._j()));
    }

    public static boolean isFilledContainer(ItemStack itemStack) {
        return itemStack != null && FluidContainerRegistry.getFluidForFilledItem(itemStack) != null;
    }

    public static FluidContainerData[] getRegisteredFluidContainerData() {
        return containerFluidMap.values().toArray(new FluidContainerData[containerFluidMap.size()]);
    }

    static {
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.WATER, new ItemStack(Item.bucketWater), EMPTY_BUCKET);
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.LAVA, new ItemStack(Item.bucketLava), EMPTY_BUCKET);
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.WATER, new ItemStack(Item.potion), EMPTY_BOTTLE);
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
        public final ItemStack filledContainer;
        public final ItemStack emptyContainer;

        public FluidContainerData(FluidStack fluidStack, ItemStack itemStack, ItemStack itemStack2) {
            this(fluidStack, itemStack, itemStack2, false);
        }

        public FluidContainerData(FluidStack fluidStack, ItemStack itemStack, ItemStack itemStack2, boolean bl) {
            this.fluid = fluidStack;
            this.filledContainer = itemStack;
            ItemStack itemStack3 = this.emptyContainer = itemStack2 == null ? NULL_EMPTYCONTAINER : itemStack2;
            if (fluidStack == null || itemStack == null || itemStack2 == null && !bl) {
                throw new RuntimeException("Invalid FluidContainerData - a parameter was null.");
            }
        }

        public FluidContainerData copy() {
            return new FluidContainerData(this.fluid, this.filledContainer, this.emptyContainer, true);
        }
    }
}

