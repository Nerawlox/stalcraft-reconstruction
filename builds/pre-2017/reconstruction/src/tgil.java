/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class tgil {
    public void _a(CraftingManager craftingManager) {
        craftingManager._b(new ItemStack(Item.bowlSoup), Block.mushroomBrown, Block.mushroomRed, Item.bowlEmpty);
        craftingManager._a(new ItemStack(Item.cookie, 8), "#X#", Character.valueOf('X'), new ItemStack(Item.dyePowder, 1, 3), Character.valueOf('#'), Item.wheat);
        craftingManager._a(new ItemStack(Block.melon), "MMM", "MMM", "MMM", Character.valueOf('M'), Item.melon);
        craftingManager._a(new ItemStack(Item.melonSeeds), "M", Character.valueOf('M'), Item.melon);
        craftingManager._a(new ItemStack(Item.pumpkinSeeds, 4), "M", Character.valueOf('M'), Block.pumpkin);
        craftingManager._b(new ItemStack(Item.pumpkinPie), Block.pumpkin, Item.sugar, Item.egg);
        craftingManager._b(new ItemStack(Item.fermentedSpiderEye), Item.spiderEye, Block.mushroomBrown, Item.sugar);
        craftingManager._b(new ItemStack(Item.blazePowder, 2), Item.blazeRod);
        craftingManager._b(new ItemStack(Item.magmaCream), Item.blazePowder, Item.slimeBall);
    }
}

