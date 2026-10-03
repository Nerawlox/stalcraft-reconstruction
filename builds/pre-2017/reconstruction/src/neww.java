/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class neww {
    public String[][] _a = new String[][]{{"X", "X", "#"}};
    public Object[][] _b = new Object[][]{{Block.planks, Block.cobblestone, Item.ingotIron, Item.diamond, Item.ingotGold}, {Item.swordWood, Item.swordStone, Item.swordIron, Item.swordDiamond, Item.swordGold}};

    public void _a(CraftingManager craftingManager) {
        for (int i = 0; i < this._b[0].length; ++i) {
            Object object = this._b[0][i];
            for (int j = 0; j < this._b.length - 1; ++j) {
                Item item = (Item)this._b[j + 1][i];
                craftingManager._a(new ItemStack(item), this._a[j], Character.valueOf('#'), Item.stick, Character.valueOf('X'), object);
            }
        }
        craftingManager._a(new ItemStack(Item.bow, 1), " #X", "# X", " #X", Character.valueOf('X'), Item.silk, Character.valueOf('#'), Item.stick);
        craftingManager._a(new ItemStack(Item.arrow, 4), "X", "#", "Y", Character.valueOf('Y'), Item.feather, Character.valueOf('X'), Item.flint, Character.valueOf('#'), Item.stick);
    }
}

