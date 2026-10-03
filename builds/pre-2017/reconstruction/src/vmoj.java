/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class vmoj
implements lpso {
    public final ItemStack _a;
    public final List _b;

    public vmoj(ItemStack itemStack, List list2) {
        this._a = itemStack;
        this._b = list2;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this._a;
    }

    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world) {
        ArrayList arrayList = new ArrayList(this._b);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                ItemStack itemStack = inventoryCrafting.getStackInRowAndColumn(j, i);
                if (itemStack == null) continue;
                boolean bl = false;
                for (ItemStack itemStack2 : arrayList) {
                    if (itemStack._d != itemStack2._d || itemStack2._j() != Short.MAX_VALUE && itemStack._j() != itemStack2._j()) continue;
                    bl = true;
                    arrayList.remove(itemStack2);
                    break;
                }
                if (bl) continue;
                return false;
            }
        }
        return arrayList.isEmpty();
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        return this._a._l();
    }

    @Override
    public int getRecipeSize() {
        return this._b.size();
    }
}

