/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.util.tdpx;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public abstract class FluidRegistry {
    static int maxID = 0;
    static HashMap<String, Fluid> fluids = new HashMap();
    static BiMap<String, Integer> fluidIDs = HashBiMap.create();
    static BiMap<twgu, Fluid> fluidBlocks;
    public static final Fluid WATER;
    public static final Fluid LAVA;
    public static int renderIdFluid;

    private FluidRegistry() {
    }

    static void initFluidIDs(BiMap<String, Integer> biMap) {
        maxID = biMap.size();
        fluidIDs.clear();
        fluidIDs.putAll(biMap);
    }

    public static boolean registerFluid(Fluid fluid) {
        if (fluidIDs.containsKey(fluid.getName())) {
            return false;
        }
        fluids.put(fluid.getName(), fluid);
        fluidIDs.put(fluid.getName(), ++maxID);
        MinecraftForge.EVENT_BUS.post(new FluidRegisterEvent(fluid.getName(), maxID));
        return true;
    }

    public static boolean isFluidRegistered(Fluid fluid) {
        return fluidIDs.containsKey(fluid.getName());
    }

    public static boolean isFluidRegistered(String string) {
        return fluidIDs.containsKey(string);
    }

    public static Fluid getFluid(String string) {
        return fluids.get(string);
    }

    public static Fluid getFluid(int n) {
        return fluids.get(FluidRegistry.getFluidName(n));
    }

    public static String getFluidName(int n) {
        return (String)fluidIDs.inverse().get(n);
    }

    public static String getFluidName(FluidStack fluidStack) {
        return FluidRegistry.getFluidName(fluidStack.fluidID);
    }

    public static int getFluidID(String string) {
        return (Integer)fluidIDs.get(string);
    }

    public static FluidStack getFluidStack(String string, int n) {
        if (!fluidIDs.containsKey(string)) {
            return null;
        }
        return new FluidStack(FluidRegistry.getFluidID(string), n);
    }

    public static Map<String, Fluid> getRegisteredFluids() {
        return ImmutableMap.copyOf(fluids);
    }

    public static Map<String, Integer> getRegisteredFluidIDs() {
        return ImmutableMap.copyOf(fluidIDs);
    }

    public static Fluid lookupFluidForBlock(twgu twgu2) {
        if (fluidBlocks == null) {
            fluidBlocks = HashBiMap.create();
            for (Fluid fluid : fluids.values()) {
                if (!fluid.canBePlacedInWorld() || twgu.field_71973_m[fluid.getBlockID()] == null) continue;
                fluidBlocks.put(twgu.field_71973_m[fluid.getBlockID()], fluid);
            }
        }
        return (Fluid)fluidBlocks.get(twgu2);
    }

    static {
        WATER = new Fluid("water"){

            @Override
            public String getLocalizedName() {
                return tdpx._a("tile.water.name");
            }
        }.setBlockID(twgu.field_71943_B.field_71990_ca).setUnlocalizedName(twgu.field_71943_B.func_71917_a());
        LAVA = new Fluid("lava"){

            @Override
            public String getLocalizedName() {
                return tdpx._a("tile.lava.name");
            }
        }.setBlockID(twgu.field_71938_D.field_71990_ca).setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300).setUnlocalizedName(twgu.field_71938_D.func_71917_a());
        renderIdFluid = -1;
        FluidRegistry.registerFluid(WATER);
        FluidRegistry.registerFluid(LAVA);
    }

    public static class FluidRegisterEvent
    extends Event {
        public final String fluidName;
        public final int fluidID;
        private static ListenerList LISTENER_LIST;

        public FluidRegisterEvent(String string, int n) {
            this.fluidName = string;
            this.fluidID = n;
        }

        public FluidRegisterEvent() {
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

