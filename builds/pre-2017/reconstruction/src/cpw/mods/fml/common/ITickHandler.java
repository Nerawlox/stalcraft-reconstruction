/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import cpw.mods.fml.common.TickType;
import java.util.EnumSet;

public interface ITickHandler {
    public void tickStart(EnumSet<TickType> var1, Object ... var2);

    public void tickEnd(EnumSet<TickType> var1, Object ... var2);

    public EnumSet<TickType> ticks();

    public String getLabel();
}

