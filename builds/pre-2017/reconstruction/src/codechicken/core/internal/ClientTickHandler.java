/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.internal;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;

public class ClientTickHandler
implements ITickHandler {
    public static int renderTime;
    public static float renderFrame;

    @Override
    public void tickStart(EnumSet<TickType> enumSet, Object ... objectArray) {
        if (enumSet.contains((Object)TickType.RENDER)) {
            renderFrame = ((Float)objectArray[0]).floatValue();
        }
    }

    @Override
    public void tickEnd(EnumSet<TickType> enumSet, Object ... objectArray) {
        if (enumSet.contains((Object)TickType.CLIENT)) {
            ++renderTime;
        }
    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.CLIENT, TickType.RENDER);
    }

    @Override
    public String getLabel() {
        return "CodeChicken Core internals";
    }
}

