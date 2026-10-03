/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.nei.MultiItemRange;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.API;
import codechicken.nei.recipe.TemplateRecipeHandler;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;

public class BrewingRecipeHandler
extends TemplateRecipeHandler {
    public static final HashSet<Integer> ingredientIDs = new HashSet();
    public static final HashSet<CachedBrewingRecipe> apotions = new HashSet();

    @Override
    public void loadTransferRects() {
        this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(58, 3, 14, 30), "brewing", new Object[0]));
        this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(92, 3, 14, 30), "brewing", new Object[0]));
        this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(68, 23, 28, 18), "brewing", new Object[0]));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiBrewingStand.class;
    }

    @Override
    public String getRecipeName() {
        return NEIClientUtils.translate("recipe.brewing", new Object[0]);
    }

    @Override
    public void loadCraftingRecipes(String string, Object ... objectArray) {
        if (string.equals("brewing") && this.getClass() == BrewingRecipeHandler.class) {
            for (CachedBrewingRecipe cachedBrewingRecipe : apotions) {
                this.arecipes.add(cachedBrewingRecipe);
            }
        } else {
            super.loadCraftingRecipes(string, objectArray);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack itemStack) {
        if (itemStack._d != Item.potion.itemID) {
            return;
        }
        int n = itemStack._j();
        for (CachedBrewingRecipe cachedBrewingRecipe : apotions) {
            if (cachedBrewingRecipe.result.item._j() != n) continue;
            this.arecipes.add(cachedBrewingRecipe);
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack itemStack) {
        if (itemStack._d != Item.potion.itemID && !ingredientIDs.contains(itemStack._d)) {
            return;
        }
        for (CachedBrewingRecipe cachedBrewingRecipe : apotions) {
            if (!NEIServerUtils.areStacksSameType(cachedBrewingRecipe.ingredient.item, itemStack) && !NEIServerUtils.areStacksSameType(cachedBrewingRecipe.precursorPotion.item, itemStack)) continue;
            this.arecipes.add(cachedBrewingRecipe);
        }
    }

    @Override
    public String getGuiTexture() {
        return "textures/gui/container/brewing_stand.png";
    }

    @Override
    public void drawExtras(int n) {
        this.drawProgressBar(92, 5, 176, 0, 8, 30, 120, 1);
        this.drawProgressBar(60, 1, 185, -2, 12, 30, 35, 3);
    }

    public void searchPotions() {
        Object object;
        Object object3;
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        hashSet.add(0);
        do {
            object3 = new HashSet();
            for (Integer object22 : hashSet) {
                if (ItemPotion._b(object22)) continue;
                for (Integer n : ingredientIDs) {
                    int list = PotionHelper._a((int)object22, Item.itemsList[n].getPotionEffect());
                    if (ItemPotion._b(list)) {
                        this.addPotion(n, object22, list, treeSet, (HashSet<Integer>)object3);
                        continue;
                    }
                    List n3 = Item.potion._a(object22);
                    object = Item.potion._a(list);
                    if (object22 > 0 && n3 == object || n3 != null && (n3.equals(object) || object == null) || object22 == list || this.levelModifierChanged(object22, list)) continue;
                    this.addPotion(n, object22, list, treeSet, (HashSet<Integer>)object3);
                }
            }
        } while ((hashSet = object3).size() > 0);
        treeSet.add(0);
        API.setItemDamageVariants(Item.potion.itemID, treeSet);
        API.addSetRange("Items.Potions", new MultiItemRange().add(Item.potion));
        API.addSetRange("Items.Potions.Splash", new MultiItemRange().add(Item.potion, 16384, 32768));
        object3 = new MultiItemRange();
        MultiItemRange multiItemRange = new MultiItemRange();
        MultiItemRange multiItemRange2 = new MultiItemRange();
        for (int n : treeSet) {
            List list = Item.potion._a(n);
            int n2 = 0;
            if (list != null && !list.isEmpty() && (object = list.iterator()).hasNext()) {
                PotionEffect potionEffect = (PotionEffect)object.next();
                n2 = Potion._a[potionEffect._a()]._f() ? -1 : 1;
            }
            if (n2 == 0) {
                multiItemRange2.add(Item.potion, n, n);
                continue;
            }
            if (n2 == 1) {
                ((MultiItemRange)object3).add(Item.potion, n, n);
                continue;
            }
            if (n2 != -1) continue;
            multiItemRange.add(Item.potion, n, n);
        }
        API.addSetRange("Items.Potions.Positive", (MultiItemRange)object3);
        API.addSetRange("Items.Potions.Negative", multiItemRange);
        API.addSetRange("Items.Potions.Neutral", multiItemRange2);
    }

    private boolean levelModifierChanged(int n, int n2) {
        int n3 = n & 0xE0;
        int n4 = n2 & 0xE0;
        return n3 != 0 && n3 != n4;
    }

    private void addPotion(int n, int n2, int n3, TreeSet<Integer> treeSet, HashSet<Integer> hashSet) {
        apotions.add(new CachedBrewingRecipe(n, n2, n3));
        if (treeSet.add(n3)) {
            hashSet.add(n3);
        }
    }

    @Override
    public String getOverlayIdentifier() {
        return "brewing";
    }

    public class CachedBrewingRecipe
    extends TemplateRecipeHandler.CachedRecipe {
        int hashcode;
        PositionedStack precursorPotion;
        PositionedStack result;
        PositionedStack ingredient;

        public CachedBrewingRecipe(int n, int n2, int n3) {
            super(BrewingRecipeHandler.this);
            this.precursorPotion = new PositionedStack(new ItemStack(Item.potion.itemID, 1, n2), 51, 35);
            this.ingredient = new PositionedStack(new ItemStack(n, 1, 0), 74, 6);
            this.result = new PositionedStack(new ItemStack(Item.potion.itemID, 1, n3), 97, 35);
            this.calculateHashcode();
        }

        @Override
        public PositionedStack getResult() {
            return this.result;
        }

        public ArrayList<PositionedStack> getIngredients() {
            ArrayList<PositionedStack> arrayList = new ArrayList<PositionedStack>();
            arrayList.add(this.ingredient);
            arrayList.add(this.precursorPotion);
            return arrayList;
        }

        private void calculateHashcode() {
            this.hashcode = this.result.item._j() << 16 + this.precursorPotion.item._j();
            this.hashcode = 31 * this.hashcode + (this.ingredient.item._d << 16 + this.ingredient.item._j());
        }

        public boolean equals(Object object) {
            if (!(object instanceof CachedBrewingRecipe)) {
                return false;
            }
            CachedBrewingRecipe cachedBrewingRecipe = (CachedBrewingRecipe)object;
            return this.result.item._j() == cachedBrewingRecipe.result.item._j() && this.precursorPotion.item._j() == cachedBrewingRecipe.precursorPotion.item._j() && NEIServerUtils.areStacksSameType(this.ingredient.item, cachedBrewingRecipe.ingredient.item);
        }

        public int hashCode() {
            return this.hashcode;
        }
    }
}

