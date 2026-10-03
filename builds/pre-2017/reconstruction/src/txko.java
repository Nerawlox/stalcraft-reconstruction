/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class txko {
    public void _a(CraftingManager craftingManager) {
        int n;
        for (n = 0; n < 16; ++n) {
            craftingManager._b(new ItemStack(Block.cloth, 1, uziv._b(n)), new ItemStack(Item.dyePowder, 1, n), new ItemStack(Item.itemsList[Block.cloth.blockID], 1, 0));
            craftingManager._a(new ItemStack(Block.stainedClay, 8, uziv._b(n)), "###", "#X#", "###", Character.valueOf('#'), new ItemStack(Block.hardenedClay), Character.valueOf('X'), new ItemStack(Item.dyePowder, 1, n));
        }
        craftingManager._b(new ItemStack(Item.dyePowder, 2, 11), Block.plantYellow);
        craftingManager._b(new ItemStack(Item.dyePowder, 2, 1), Block.plantRed);
        craftingManager._b(new ItemStack(Item.dyePowder, 3, 15), Item.bone);
        craftingManager._b(new ItemStack(Item.dyePowder, 2, 9), new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.dyePowder, 1, 15));
        craftingManager._b(new ItemStack(Item.dyePowder, 2, 14), new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.dyePowder, 1, 11));
        craftingManager._b(new ItemStack(Item.dyePowder, 2, 10), new ItemStack(Item.dyePowder, 1, 2), new ItemStack(Item.dyePowder, 1, 15));
        craftingManager._b(new ItemStack(Item.dyePowder, 2, 8), new ItemStack(Item.dyePowder, 1, 0), new ItemStack(Item.dyePowder, 1, 15));
        craftingManager._b(new ItemStack(Item.dyePowder, 2, 7), new ItemStack(Item.dyePowder, 1, 8), new ItemStack(Item.dyePowder, 1, 15));
        craftingManager._b(new ItemStack(Item.dyePowder, 3, 7), new ItemStack(Item.dyePowder, 1, 0), new ItemStack(Item.dyePowder, 1, 15), new ItemStack(Item.dyePowder, 1, 15));
        craftingManager._b(new ItemStack(Item.dyePowder, 2, 12), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.dyePowder, 1, 15));
        craftingManager._b(new ItemStack(Item.dyePowder, 2, 6), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.dyePowder, 1, 2));
        craftingManager._b(new ItemStack(Item.dyePowder, 2, 5), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.dyePowder, 1, 1));
        craftingManager._b(new ItemStack(Item.dyePowder, 2, 13), new ItemStack(Item.dyePowder, 1, 5), new ItemStack(Item.dyePowder, 1, 9));
        craftingManager._b(new ItemStack(Item.dyePowder, 3, 13), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.dyePowder, 1, 9));
        craftingManager._b(new ItemStack(Item.dyePowder, 4, 13), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.dyePowder, 1, 15));
        for (n = 0; n < 16; ++n) {
            craftingManager._a(new ItemStack(Block.carpet, 3, n), "##", Character.valueOf('#'), new ItemStack(Block.cloth, 1, n));
        }
    }
}

