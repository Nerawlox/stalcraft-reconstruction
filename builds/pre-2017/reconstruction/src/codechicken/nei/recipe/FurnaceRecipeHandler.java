/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.nei.ItemList;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

public class FurnaceRecipeHandler
extends TemplateRecipeHandler {
    public static ArrayList<FuelPair> afuels;
    public static TreeSet<Integer> efuels;

    @Override
    public void loadTransferRects() {
        this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(50, 23, 18, 18), "fuel", new Object[0]));
        this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(74, 23, 24, 18), "smelting", new Object[0]));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiFurnace.class;
    }

    @Override
    public String getRecipeName() {
        return NEIClientUtils.translate("recipe.furnace", new Object[0]);
    }

    @Override
    public TemplateRecipeHandler newInstance() {
        if (afuels == null) {
            FurnaceRecipeHandler.findFuels();
        }
        return super.newInstance();
    }

    @Override
    public void loadCraftingRecipes(String string, Object ... objectArray) {
        if (string.equals("smelting") && this.getClass() == FurnaceRecipeHandler.class) {
            ItemStack itemStack;
            HashMap hashMap = (HashMap)yewu._a()._b();
            HashMap hashMap2 = (HashMap)yewu._a()._c();
            for (Map.Entry entry : hashMap.entrySet()) {
                itemStack = (ItemStack)entry.getValue();
                this.arecipes.add(new SmeltingPair(new ItemStack((Integer)entry.getKey(), 1, -1), itemStack));
            }
            if (hashMap2 == null) {
                return;
            }
            for (Map.Entry entry : hashMap2.entrySet()) {
                itemStack = (ItemStack)entry.getValue();
                this.arecipes.add(new SmeltingPair(new ItemStack((Integer)((List)entry.getKey()).get(0), 1, (int)((Integer)((List)entry.getKey()).get(1))), itemStack));
            }
        } else {
            super.loadCraftingRecipes(string, objectArray);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack itemStack) {
        ItemStack itemStack2;
        HashMap hashMap = (HashMap)yewu._a()._b();
        HashMap hashMap2 = (HashMap)yewu._a()._c();
        for (Map.Entry entry : hashMap.entrySet()) {
            itemStack2 = (ItemStack)entry.getValue();
            if (!NEIServerUtils.areStacksSameType(itemStack2, itemStack)) continue;
            this.arecipes.add(new SmeltingPair(new ItemStack((Integer)entry.getKey(), 1, -1), itemStack2));
        }
        if (hashMap2 == null) {
            return;
        }
        for (Map.Entry entry : hashMap2.entrySet()) {
            itemStack2 = (ItemStack)entry.getValue();
            if (!NEIServerUtils.areStacksSameType(itemStack2, itemStack)) continue;
            this.arecipes.add(new SmeltingPair(new ItemStack((Integer)((List)entry.getKey()).get(0), 1, (int)((Integer)((List)entry.getKey()).get(1))), itemStack2));
        }
    }

    @Override
    public void loadUsageRecipes(String string, Object ... objectArray) {
        if (string.equals("fuel") && this.getClass() == FurnaceRecipeHandler.class) {
            this.loadCraftingRecipes("smelting", new Object[0]);
        } else {
            super.loadUsageRecipes(string, objectArray);
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack itemStack) {
        ItemStack itemStack2;
        HashMap hashMap = (HashMap)yewu._a()._b();
        HashMap hashMap2 = (HashMap)yewu._a()._c();
        for (Map.Entry entry : hashMap.entrySet()) {
            itemStack2 = (ItemStack)entry.getValue();
            if (itemStack._d != (Integer)entry.getKey()) continue;
            this.arecipes.add(new SmeltingPair(itemStack, itemStack2));
        }
        if (hashMap2 == null) {
            return;
        }
        for (Map.Entry entry : hashMap2.entrySet()) {
            itemStack2 = (ItemStack)entry.getValue();
            if (itemStack._d != (Integer)((List)entry.getKey()).get(0) || itemStack._j() != ((Integer)((List)entry.getKey()).get(1)).intValue()) continue;
            this.arecipes.add(new SmeltingPair(itemStack, itemStack2));
        }
    }

    @Override
    public String getGuiTexture() {
        return "textures/gui/container/furnace.png";
    }

    @Override
    public void drawExtras(int n) {
        this.drawProgressBar(51, 25, 176, 0, 14, 14, 48, 7);
        this.drawProgressBar(74, 23, 176, 14, 24, 16, 48, 0);
    }

    private static void removeFuels() {
        efuels = new TreeSet();
        efuels.add(Block.mushroomCapBrown.blockID);
        efuels.add(Block.mushroomCapRed.blockID);
        efuels.add(Block.signPost.blockID);
        efuels.add(Block.signWall.blockID);
        efuels.add(Block.doorWood.blockID);
        efuels.add(Block.lockedChest.blockID);
    }

    private static void findFuels() {
        afuels = new ArrayList();
        for (ItemStack itemStack : ItemList.items) {
            int n;
            if (efuels.contains(itemStack._d) || (n = TileEntityFurnace._a(itemStack)) <= 0) continue;
            afuels.add(new FuelPair(itemStack._l(), n));
        }
    }

    @Override
    public String getOverlayIdentifier() {
        return "smelting";
    }

    static {
        FurnaceRecipeHandler.removeFuels();
    }

    public static class FuelPair {
        public PositionedStack stack;
        public int burnTime;

        public FuelPair(ItemStack itemStack, int n) {
            this.stack = new PositionedStack(itemStack, 51, 42, false);
            this.burnTime = n;
        }
    }

    public class SmeltingPair
    extends TemplateRecipeHandler.CachedRecipe {
        PositionedStack ingred;
        PositionedStack result;

        public SmeltingPair(ItemStack itemStack, ItemStack itemStack2) {
            super(FurnaceRecipeHandler.this);
            itemStack._b = 1;
            this.ingred = new PositionedStack(itemStack, 51, 6);
            this.result = new PositionedStack(itemStack2, 111, 24);
        }

        @Override
        public PositionedStack getIngredient() {
            int n = FurnaceRecipeHandler.this.cycleticks / 48;
            if (this.ingred.item._j() == -1) {
                PositionedStack positionedStack = this.ingred.copy();
                int n2 = 0;
                do {
                    positionedStack.item._b(++n2);
                } while (NEIClientUtils.isValidItem(positionedStack.item));
                positionedStack.item._b(n % n2);
                return positionedStack;
            }
            return this.ingred;
        }

        @Override
        public PositionedStack getResult() {
            return this.result;
        }

        @Override
        public PositionedStack getOtherStack() {
            return FurnaceRecipeHandler.afuels.get((int)(FurnaceRecipeHandler.this.cycleticks / 48 % FurnaceRecipeHandler.afuels.size())).stack;
        }
    }
}

