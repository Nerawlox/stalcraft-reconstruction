/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class xbtf
implements lpso {
    public final int _a;
    public final int _b;
    public final ItemStack[] _c;
    public ItemStack _d;
    public final int _e;
    public boolean _f;

    public xbtf(int n, int n2, ItemStack[] itemStackArray, ItemStack itemStack) {
        this._e = itemStack._d;
        this._a = n;
        this._b = n2;
        this._c = itemStackArray;
        this._d = itemStack;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this._d;
    }

    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world) {
        for (int i = 0; i <= 3 - this._a; ++i) {
            for (int j = 0; j <= 3 - this._b; ++j) {
                if (this._a(inventoryCrafting, i, j, true)) {
                    return true;
                }
                if (!this._a(inventoryCrafting, i, j, false)) continue;
                return true;
            }
        }
        return false;
    }

    public boolean _a(InventoryCrafting inventoryCrafting, int n, int n2, boolean bl) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                ItemStack itemStack;
                int n3 = i - n;
                int n4 = j - n2;
                ItemStack itemStack2 = null;
                if (n3 >= 0 && n4 >= 0 && n3 < this._a && n4 < this._b) {
                    itemStack2 = bl ? this._c[this._a - n3 - 1 + n4 * this._a] : this._c[n3 + n4 * this._a];
                }
                if ((itemStack = inventoryCrafting.getStackInRowAndColumn(i, j)) == null && itemStack2 == null) continue;
                if (itemStack == null && itemStack2 != null || itemStack != null && itemStack2 == null) {
                    return false;
                }
                if (itemStack2._d != itemStack._d) {
                    return false;
                }
                if (itemStack2._j() == Short.MAX_VALUE || itemStack2._j() == itemStack._j()) continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        ItemStack itemStack = this.getRecipeOutput()._l();
        if (this._f) {
            for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
                ItemStack itemStack2 = inventoryCrafting.getStackInSlot(i);
                if (itemStack2 == null || !itemStack2._p()) continue;
                itemStack._d((NBTTagCompound)itemStack2._e._c());
            }
        }
        return itemStack;
    }

    @Override
    public int getRecipeSize() {
        return this._a * this._b;
    }

    public xbtf _a() {
        this._f = true;
        return this;
    }
}

