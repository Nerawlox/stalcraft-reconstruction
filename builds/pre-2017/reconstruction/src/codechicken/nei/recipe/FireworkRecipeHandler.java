/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.core.gui.GuiDraw;
import codechicken.nei.InventoryCraftingDummy;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.ShapelessRecipeHandler;
import codechicken.nei.recipe.TemplateRecipeHandler;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FireworkRecipeHandler
extends ShapelessRecipeHandler {
    private InventoryCrafting inventoryCrafting = new InventoryCraftingDummy();
    private gadn recipeFireworks = new gadn();
    public ArrayList<CachedFireworkRecipe> mfireworks = new ArrayList();

    public FireworkRecipeHandler() {
        this.stackorder = new int[][]{{0, 0}, {1, 0}, {2, 0}, {0, 1}, {1, 1}, {2, 1}, {0, 2}, {1, 2}, {2, 2}};
        this.loadAllFireworks();
    }

    private void loadAllFireworks() {
        Item[] itemArray = new Item[]{null, Item.fireballCharge, Item.goldNugget, Item.feather, Item.skull};
        Item[] itemArray2 = new Item[]{null, Item.diamond, Item.glowstone};
        for (Item item : itemArray) {
            for (Item item2 : itemArray2) {
                this.genRecipe(Item.gunpowder, item, item2, Item.dyePowder, Item.dyePowder, 0);
            }
        }
        this.genRecipe(Item.gunpowder, Item.paper, Item.fireworkCharge, 2);
        this.genRecipe(Item.gunpowder, Item.gunpowder, Item.paper, Item.fireworkCharge, 2);
        this.genRecipe(Item.gunpowder, Item.gunpowder, Item.gunpowder, Item.paper, Item.fireworkCharge, 2);
        for (int i = 0; i < 9; ++i) {
            this.inventoryCrafting.setInventorySlotContents(i, null);
        }
        this.inventoryCrafting.setInventorySlotContents(0, new ItemStack(Item.gunpowder));
        this.inventoryCrafting.setInventorySlotContents(1, new ItemStack(Item.dyePowder));
        this.recipeFireworks.matches(this.inventoryCrafting, null);
        ItemStack itemStack = this.recipeFireworks.getCraftingResult(null);
        this.genRecipe(itemStack, Item.dyePowder, Item.dyePowder, 1);
    }

    private void genRecipe(Object ... objectArray) {
        int n;
        int n2 = 0;
        for (n = 0; n < objectArray.length - 2; ++n) {
            if (objectArray[n] == null) continue;
            ++n2;
        }
        for (n = 0; n < objectArray.length - 1; ++n) {
            if (!(objectArray[n] instanceof Item)) continue;
            objectArray[n] = new ItemStack((Item)objectArray[n], 1, Short.MAX_VALUE);
        }
        Object[] objectArray2 = new Object[n2];
        int n3 = 0;
        for (int i = 0; i < objectArray.length - 2; ++i) {
            if (objectArray[i] == null) continue;
            objectArray2[n3++] = objectArray[i];
        }
        this.mfireworks.add(new CachedFireworkRecipe(objectArray2, objectArray[objectArray.length - 2], (Integer)objectArray[objectArray.length - 1]));
    }

    @Override
    public void loadCraftingRecipes(ItemStack itemStack) {
        for (CachedFireworkRecipe cachedFireworkRecipe : this.mfireworks) {
            if (cachedFireworkRecipe.result.item._d != itemStack._d) continue;
            cachedFireworkRecipe.cycle();
            this.arecipes.add(cachedFireworkRecipe);
        }
    }

    @Override
    public void loadCraftingRecipes(String string, Object ... objectArray) {
        if (string.equals("crafting") && this.getClass() == FireworkRecipeHandler.class) {
            this.arecipes.addAll(this.mfireworks);
        } else {
            super.loadCraftingRecipes(string, objectArray);
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack itemStack) {
        for (CachedFireworkRecipe cachedFireworkRecipe : this.mfireworks) {
            if (!cachedFireworkRecipe.contains(cachedFireworkRecipe.ingredients, itemStack)) continue;
            cachedFireworkRecipe.cycle();
            this.arecipes.add(cachedFireworkRecipe);
        }
    }

    @Override
    public void onUpdate() {
        if (!NEIClientUtils.shiftKey()) {
            ++this.cycleticks;
            if (this.cycleticks % 20 == 0) {
                for (TemplateRecipeHandler.CachedRecipe cachedRecipe : this.arecipes) {
                    ((CachedFireworkRecipe)cachedRecipe).cycle();
                }
            }
        }
    }

    @Override
    public String getRecipeName() {
        return NEIClientUtils.translate("recipe.firework", new Object[0]);
    }

    @Override
    public List<String> handleTooltip(GuiRecipe guiRecipe, List<String> list, int n) {
        list = super.handleTooltip(guiRecipe, list, n);
        Point point = GuiDraw.getMousePosition();
        Point point2 = new Point(point.x - guiRecipe.guiLeft, point.y - guiRecipe.guiTop);
        Point point3 = guiRecipe.getRecipePosition(n);
        if (list.isEmpty() && guiRecipe.manager.getStackMouseOver() == null && new Rectangle(point3.x, point3.y, 166, 55).contains(point2)) {
            list.add(NEIClientUtils.translate("recipe.firework.tooltip" + ((CachedFireworkRecipe)this.arecipes.get((int)n)).recipeType, new Object[0]));
        }
        return list;
    }

    public class CachedFireworkRecipe
    extends ShapelessRecipeHandler.CachedShapelessRecipe {
        LinkedList<Object> itemList;
        public Object[] baseIngredients;
        public Object extraIngred;
        public int recipeType;

        public CachedFireworkRecipe(Object[] objectArray, Object object, int n) {
            super(new ItemStack(Item.firework));
            this.itemList = new LinkedList();
            this.baseIngredients = objectArray;
            this.extraIngred = object;
            this.recipeType = n;
            this.cycle();
        }

        public void cycle() {
            int n;
            this.itemList.clear();
            Object[] objectArray = this.baseIngredients;
            int n2 = objectArray.length;
            for (n = 0; n < n2; ++n) {
                Object object = objectArray[n];
                this.itemList.add(object);
            }
            int n3 = FireworkRecipeHandler.this.cycleticks / 40 % (10 - this.itemList.size());
            for (n2 = 0; n2 < n3; ++n2) {
                this.itemList.add(this.extraIngred);
            }
            this.setIngredients(this.itemList);
            List<PositionedStack> list = this.getIngredients();
            for (n = 0; n < 9; ++n) {
                FireworkRecipeHandler.this.inventoryCrafting.setInventorySlotContents(n, n < list.size() ? list.get((int)n).item : null);
            }
            if (!FireworkRecipeHandler.this.recipeFireworks.matches(FireworkRecipeHandler.this.inventoryCrafting, null)) {
                throw new RuntimeException("Invalid Recipe?");
            }
            this.setResult(FireworkRecipeHandler.this.recipeFireworks.getCraftingResult(null));
        }
    }
}

