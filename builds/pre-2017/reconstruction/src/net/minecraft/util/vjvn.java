/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.util.Random;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.iurq;
import net.minecraft.util.piet;
import net.minecraftforge.common.ChestGenHooks;

public class vjvn
extends piet {
    public ItemStack _a;
    public int _b;
    public int _c;

    public vjvn(int n, int n2, int n3, int n4, int n5) {
        super(n5);
        this._a = new ItemStack(n, 1, n2);
        this._b = n3;
        this._c = n4;
    }

    public vjvn(ItemStack itemStack, int n, int n2, int n3) {
        super(n3);
        this._a = itemStack;
        this._b = n;
        this._c = n2;
    }

    public static void _a(Random random, vjvn[] vjvnArray, IInventory iInventory, int n) {
        for (int i = 0; i < n; ++i) {
            ItemStack[] itemStackArray;
            vjvn vjvn2 = (vjvn)iurq._a(random, vjvnArray);
            for (ItemStack itemStack : itemStackArray = vjvn2._a(random, iInventory)) {
                iInventory.setInventorySlotContents(random.nextInt(iInventory.getSizeInventory()), itemStack);
            }
        }
    }

    public static void _a(Random random, vjvn[] vjvnArray, TileEntityDispenser tileEntityDispenser, int n) {
        for (int i = 0; i < n; ++i) {
            ItemStack[] itemStackArray;
            vjvn vjvn2 = (vjvn)iurq._a(random, vjvnArray);
            for (ItemStack itemStack : itemStackArray = vjvn2._a(random, tileEntityDispenser)) {
                tileEntityDispenser.setInventorySlotContents(random.nextInt(tileEntityDispenser.getSizeInventory()), itemStack);
            }
        }
    }

    public static vjvn[] _a(vjvn[] vjvnArray, vjvn ... vjvnArray2) {
        vjvn[] vjvnArray3 = new vjvn[vjvnArray.length + vjvnArray2.length];
        int n = 0;
        for (int i = 0; i < vjvnArray.length; ++i) {
            vjvnArray3[n++] = vjvnArray[i];
        }
        vjvn[] vjvnArray4 = vjvnArray2;
        int n2 = vjvnArray2.length;
        for (int i = 0; i < n2; ++i) {
            vjvn vjvn2 = vjvnArray4[i];
            vjvnArray3[n++] = vjvn2;
        }
        return vjvnArray3;
    }

    public ItemStack[] _a(Random random, IInventory iInventory) {
        return ChestGenHooks.generateStacks(random, this._a, this._b, this._c);
    }
}

