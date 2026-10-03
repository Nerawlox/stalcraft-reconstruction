/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class qoax {
    public Object[][] _a = new Object[][]{{Block.blockGold, new ItemStack(Item.ingotGold, 9)}, {Block.blockIron, new ItemStack(Item.ingotIron, 9)}, {Block.blockDiamond, new ItemStack(Item.diamond, 9)}, {Block.blockEmerald, new ItemStack(Item.emerald, 9)}, {Block.blockLapis, new ItemStack(Item.dyePowder, 9, 4)}, {Block.blockRedstone, new ItemStack(Item.redstone, 9)}, {Block.coalBlock, new ItemStack(Item.coal, 9, 0)}, {Block.hay, new ItemStack(Item.wheat, 9)}};

    public void _a(CraftingManager craftingManager) {
        for (int i = 0; i < this._a.length; ++i) {
            Block block = (Block)this._a[i][0];
            ItemStack itemStack = (ItemStack)this._a[i][1];
            craftingManager._a(new ItemStack(block), "###", "###", "###", Character.valueOf('#'), itemStack);
            craftingManager._a(itemStack, "#", Character.valueOf('#'), block);
        }
        craftingManager._a(new ItemStack(Item.ingotGold), "###", "###", "###", Character.valueOf('#'), Item.goldNugget);
        craftingManager._a(new ItemStack(Item.goldNugget, 9), "#", Character.valueOf('#'), Item.ingotGold);
    }
}

