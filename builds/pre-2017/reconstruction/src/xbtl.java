/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class xbtl
implements lpso {
    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world) {
        ItemStack itemStack = null;
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
            ItemStack itemStack2 = inventoryCrafting.getStackInSlot(i);
            if (itemStack2 == null) continue;
            if (itemStack2._a() instanceof ItemArmor) {
                ItemArmor itemArmor = (ItemArmor)itemStack2._a();
                if (itemArmor.getArmorMaterial() == EnumArmorMaterial._a && itemStack == null) {
                    itemStack = itemStack2;
                    continue;
                }
                return false;
            }
            if (itemStack2._d == Item.dyePowder.itemID) {
                arrayList.add(itemStack2);
                continue;
            }
            return false;
        }
        return itemStack != null && !arrayList.isEmpty();
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        float f;
        float f2;
        int n;
        int n2;
        ItemStack itemStack = null;
        int[] nArray = new int[3];
        int n3 = 0;
        int n4 = 0;
        ItemArmor itemArmor = null;
        for (n2 = 0; n2 < inventoryCrafting.getSizeInventory(); ++n2) {
            ItemStack itemStack2 = inventoryCrafting.getStackInSlot(n2);
            if (itemStack2 == null) continue;
            if (itemStack2._a() instanceof ItemArmor) {
                itemArmor = (ItemArmor)itemStack2._a();
                if (itemArmor.getArmorMaterial() == EnumArmorMaterial._a && itemStack == null) {
                    itemStack = itemStack2._l();
                    itemStack._b = 1;
                    if (!itemArmor.hasColor(itemStack2)) continue;
                    n = itemArmor.getColor(itemStack);
                    f2 = (float)(n >> 16 & 0xFF) / 255.0f;
                    f = (float)(n >> 8 & 0xFF) / 255.0f;
                    float f3 = (float)(n & 0xFF) / 255.0f;
                    n3 = (int)((float)n3 + Math.max(f2, Math.max(f, f3)) * 255.0f);
                    nArray[0] = (int)((float)nArray[0] + f2 * 255.0f);
                    nArray[1] = (int)((float)nArray[1] + f * 255.0f);
                    nArray[2] = (int)((float)nArray[2] + f3 * 255.0f);
                    ++n4;
                    continue;
                }
                return null;
            }
            if (itemStack2._d == Item.dyePowder.itemID) {
                float[] fArray = EntitySheep.fleeceColorTable[uziv._a(itemStack2._j())];
                int n5 = (int)(fArray[0] * 255.0f);
                int n6 = (int)(fArray[1] * 255.0f);
                int n7 = (int)(fArray[2] * 255.0f);
                n3 += Math.max(n5, Math.max(n6, n7));
                nArray[0] = nArray[0] + n5;
                nArray[1] = nArray[1] + n6;
                nArray[2] = nArray[2] + n7;
                ++n4;
                continue;
            }
            return null;
        }
        if (itemArmor == null) {
            return null;
        }
        n2 = nArray[0] / n4;
        int n8 = nArray[1] / n4;
        n = nArray[2] / n4;
        f2 = (float)n3 / (float)n4;
        f = Math.max(n2, Math.max(n8, n));
        n2 = (int)((float)n2 * f2 / f);
        n8 = (int)((float)n8 * f2 / f);
        n = (int)((float)n * f2 / f);
        int n9 = n2;
        n9 = (n9 << 8) + n8;
        n9 = (n9 << 8) + n;
        itemArmor.func_82813_b(itemStack, n9);
        return itemStack;
    }

    @Override
    public int getRecipeSize() {
        return 10;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }
}

