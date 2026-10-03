/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.liquids;

import net.minecraftforge.liquids.LiquidStack;

@Deprecated
public class LiquidContainerData {
    public final LiquidStack stillLiquid;
    public final cvzo filled;
    public final cvzo container;

    public LiquidContainerData(LiquidStack liquidStack, cvzo cvzo2, cvzo cvzo3) {
        this.stillLiquid = liquidStack;
        this.filled = cvzo2;
        this.container = cvzo3;
        if (liquidStack == null || cvzo2 == null || cvzo3 == null) {
            throw new RuntimeException("stillLiquid, filled, or container is null, this is an error");
        }
    }
}

