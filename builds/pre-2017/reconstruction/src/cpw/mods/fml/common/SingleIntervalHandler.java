/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;

public class SingleIntervalHandler
implements IScheduledTickHandler {
    private ITickHandler wrapped;

    public SingleIntervalHandler(ITickHandler iTickHandler) {
        this.wrapped = iTickHandler;
    }

    @Override
    public void tickStart(EnumSet<TickType> enumSet, Object ... objectArray) {
        this.wrapped.tickStart(enumSet, objectArray);
    }

    @Override
    public void tickEnd(EnumSet<TickType> enumSet, Object ... objectArray) {
        this.wrapped.tickEnd(enumSet, objectArray);
    }

    @Override
    public EnumSet<TickType> ticks() {
        return this.wrapped.ticks();
    }

    @Override
    public String getLabel() {
        return this.wrapped.getLabel();
    }

    @Override
    public int nextTickSpacing() {
        return 1;
    }
}

