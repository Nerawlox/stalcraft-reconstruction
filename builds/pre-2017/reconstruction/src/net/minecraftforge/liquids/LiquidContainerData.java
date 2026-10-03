/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.liquids;

import net.minecraft.item.ItemStack;
import net.minecraftforge.liquids.LiquidStack;

@Deprecated
public class LiquidContainerData {
    public final LiquidStack stillLiquid;
    public final ItemStack filled;
    public final ItemStack container;

    public LiquidContainerData(LiquidStack liquidStack, ItemStack itemStack, ItemStack itemStack2) {
        this.stillLiquid = liquidStack;
        this.filled = itemStack;
        this.container = itemStack2;
        if (liquidStack == null || itemStack == null || itemStack2 == null) {
            throw new RuntimeException("stillLiquid, filled, or container is null, this is an error");
        }
    }
}

