/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class PositionedStack {
    public int relx;
    public int rely;
    public ItemStack[] items;
    public ItemStack item;
    private boolean permutated = false;

    public PositionedStack(Object object, int n, int n2, boolean bl) {
        this.items = NEIServerUtils.extractRecipeItems(object);
        this.relx = n;
        this.rely = n2;
        if (bl) {
            this.generatePermutations();
        } else {
            this.setPermutationToRender(0);
        }
    }

    public PositionedStack(Object object, int n, int n2) {
        this(object, n, n2, true);
    }

    public void generatePermutations() {
        if (this.permutated) {
            return;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (ItemStack itemStack : this.items) {
            if (itemStack == null || itemStack._a() == null) continue;
            if (itemStack._j() == Short.MAX_VALUE) {
                List<ItemStack> list = NEIClientUtils.getValidItems(itemStack._d);
                if (!list.isEmpty()) {
                    for (ItemStack itemStack2 : list) {
                        arrayList.add(itemStack2._l());
                    }
                    continue;
                }
                ItemStack itemStack3 = new ItemStack(itemStack._d, itemStack._b, 0);
                itemStack3._e = itemStack._e;
                arrayList.add(itemStack3);
                continue;
            }
            arrayList.add(itemStack._l());
        }
        this.items = arrayList.toArray(new ItemStack[0]);
        if (this.items.length == 0) {
            this.items = new ItemStack[]{new ItemStack(Block.fire)};
        }
        this.permutated = true;
        this.setPermutationToRender(0);
    }

    public void setMaxSize(int n) {
        for (ItemStack itemStack : this.items) {
            if (itemStack._b <= n) continue;
            itemStack._b = n;
        }
    }

    public PositionedStack copy() {
        return new PositionedStack(this.items, this.relx, this.rely);
    }

    public void setPermutationToRender(int n) {
        this.item = this.items[n]._l();
        if (this.item._j() == -1) {
            this.item._b(0);
        }
    }

    public boolean contains(ItemStack itemStack) {
        for (ItemStack itemStack2 : this.items) {
            if (!NEIServerUtils.areStacksSameTypeCrafting(itemStack2, itemStack)) continue;
            return true;
        }
        return false;
    }

    public boolean contains(int n) {
        for (ItemStack itemStack : this.items) {
            if (itemStack._d != n) continue;
            return true;
        }
        return false;
    }
}

