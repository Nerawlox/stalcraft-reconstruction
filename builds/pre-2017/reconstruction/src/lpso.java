/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface lpso {
    public boolean matches(InventoryCrafting var1, World var2);

    public ItemStack getCraftingResult(InventoryCrafting var1);

    public int getRecipeSize();

    public ItemStack getRecipeOutput();
}

