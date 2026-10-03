/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import cpw.mods.fml.common.ITickHandler;

public interface IScheduledTickHandler
extends ITickHandler {
    public int nextTickSpacing();
}

