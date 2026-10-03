/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import java.util.ArrayList;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IShearable {
    public boolean isShearable(ItemStack var1, World var2, int var3, int var4, int var5);

    public ArrayList<ItemStack> onSheared(ItemStack var1, World var2, int var3, int var4, int var5, int var6);
}

