/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import java.util.List;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public interface ICrafting {
    public void func_71110_a(Container var1, List var2);

    public void sendSlotContents(Container var1, int var2, ItemStack var3);

    public void sendProgressBarUpdate(Container var1, int var2, int var3);
}

