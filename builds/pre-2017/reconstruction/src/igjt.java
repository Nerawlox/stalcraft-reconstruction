/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class igjt {
    public String[][] _a = new String[][]{{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
    public Object[][] _b = new Object[][]{{Item.leather, Block.fire, Item.ingotIron, Item.diamond, Item.ingotGold}, {Item.helmetLeather, Item.helmetChain, Item.helmetIron, Item.helmetDiamond, Item.helmetGold}, {Item.plateLeather, Item.plateChain, Item.plateIron, Item.plateDiamond, Item.plateGold}, {Item.legsLeather, Item.legsChain, Item.legsIron, Item.legsDiamond, Item.legsGold}, {Item.bootsLeather, Item.bootsChain, Item.bootsIron, Item.bootsDiamond, Item.bootsGold}};

    public void _a(CraftingManager craftingManager) {
        for (int i = 0; i < this._b[0].length; ++i) {
            Object object = this._b[0][i];
            for (int j = 0; j < this._b.length - 1; ++j) {
                Item item = (Item)this._b[j + 1][i];
                craftingManager._a(new ItemStack(item), this._a[j], Character.valueOf('X'), object);
            }
        }
    }
}

