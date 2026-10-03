/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.liquids;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;
import net.minecraftforge.liquids.LiquidStack;

@Deprecated
public abstract class LiquidDictionary {
    private static BiMap<String, LiquidStack> liquids = HashBiMap.create();

    public static LiquidStack getOrCreateLiquid(String string, LiquidStack liquidStack) {
        if (liquidStack == null) {
            throw new NullPointerException("You cannot register a null LiquidStack");
        }
        LiquidStack liquidStack2 = (LiquidStack)liquids.get(string);
        if (liquidStack2 != null) {
            return liquidStack2.copy();
        }
        liquids.put(string, liquidStack.copy());
        MinecraftForge.EVENT_BUS.post(new LiquidRegisterEvent(string, liquidStack));
        return liquidStack;
    }

    public static LiquidStack getLiquid(String string, int n) {
        LiquidStack liquidStack = (LiquidStack)liquids.get(string);
        if (liquidStack == null) {
            return null;
        }
        liquidStack = liquidStack.copy();
        liquidStack.amount = n;
        return liquidStack;
    }

    public static LiquidStack getCanonicalLiquid(String string) {
        return (LiquidStack)liquids.get(string);
    }

    public static Map<String, LiquidStack> getLiquids() {
        return ImmutableMap.copyOf(liquids);
    }

    public static String findLiquidName(LiquidStack liquidStack) {
        if (liquidStack != null) {
            return (String)liquids.inverse().get(liquidStack);
        }
        return null;
    }

    public static LiquidStack getCanonicalLiquid(LiquidStack liquidStack) {
        return (LiquidStack)liquids.get(liquids.inverse().get(liquidStack));
    }

    static {
        LiquidDictionary.getOrCreateLiquid("Water", new LiquidStack(Block.waterStill, 1000));
        LiquidDictionary.getOrCreateLiquid("Lava", new LiquidStack(Block.lavaStill, 1000));
    }

    public static class LiquidRegisterEvent
    extends Event {
        public final String Name;
        public final LiquidStack Liquid;
        private static ListenerList LISTENER_LIST;

        public LiquidRegisterEvent(String string, LiquidStack liquidStack) {
            this.Name = string;
            this.Liquid = liquidStack.copy();
        }

        public LiquidRegisterEvent() {
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

