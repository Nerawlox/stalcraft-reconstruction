/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class wprm {
    public String[][] _a = new String[][]{{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
    public Object[][] _b = new Object[][]{{Block.planks, Block.cobblestone, Item.ingotIron, Item.diamond, Item.ingotGold}, {Item.pickaxeWood, Item.pickaxeStone, Item.pickaxeIron, Item.pickaxeDiamond, Item.pickaxeGold}, {Item.shovelWood, Item.shovelStone, Item.shovelIron, Item.shovelDiamond, Item.shovelGold}, {Item.axeWood, Item.axeStone, Item.axeIron, Item.axeDiamond, Item.axeGold}, {Item.hoeWood, Item.hoeStone, Item.hoeIron, Item.hoeDiamond, Item.hoeGold}};

    public void _a(CraftingManager craftingManager) {
        for (int i = 0; i < this._b[0].length; ++i) {
            Object object = this._b[0][i];
            for (int j = 0; j < this._b.length - 1; ++j) {
                Item item = (Item)this._b[j + 1][i];
                craftingManager._a(new ItemStack(item), this._a[j], Character.valueOf('#'), Item.stick, Character.valueOf('X'), object);
            }
        }
        craftingManager._a(new ItemStack(Item.shears), " #", "# ", Character.valueOf('#'), Item.ingotIron);
    }
}

