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
    public Class<? extends zybc> getGuiClass() {
        return iwql.class;
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
    public void loadCraftingRecipes(cvzo cvzo2) {
        if (cvzo2._d != tgdv.field_77726_bs.field_77779_bT) {
            return;
        }
        int n = cvzo2._j();
        for (CachedBrewingRecipe cachedBrewingRecipe : apotions) {
            if (cachedBrewingRecipe.result.item._j() != n) continue;
            this.arecipes.add(cachedBrewingRecipe);
        }
    }

    @Override
    public void loadUsageRecipes(cvzo cvzo2) {
        if (cvzo2._d != tgdv.field_77726_bs.field_77779_bT && !ingredientIDs.contains(cvzo2._d)) {
            return;
        }
        for (CachedBrewingRecipe cachedBrewingRecipe : apotions) {
            if (!NEIServerUtils.areStacksSameType(cachedBrewingRecipe.ingredient.item, cvzo2) && !NEIServerUtils.areStacksSameType(cachedBrewingRecipe.precursorPotion.item, cvzo2)) continue;
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
                if (zyyc._b(object22)) continue;
                for (Integer n : ingredientIDs) {
                    int list = hdoy._a((int)object22, tgdv.field_77698_e[n].func_77666_t());
                    if (zyyc._b(list)) {
                        this.addPotion(n, object22, list, treeSet, (HashSet<Integer>)object3);
                        continue;
                    }
                    List n3 = tgdv.field_77726_bs._a(object22);
                    object = tgdv.field_77726_bs._a(list);
                    if (object22 > 0 && n3 == object || n3 != null && (n3.equals(object) || object == null) || object22 == list || this.levelModifierChanged(object22, list)) continue;
                    this.addPotion(n, object22, list, treeSet, (HashSet<Integer>)object3);
                }
            }
        } while ((hashSet = object3).size() > 0);
        treeSet.add(0);
        API.setItemDamageVariants(tgdv.field_77726_bs.field_77779_bT, treeSet);
        API.addSetRange("Items.Potions", new MultiItemRange().add(tgdv.field_77726_bs));
        API.addSetRange("Items.Potions.Splash", new MultiItemRange().add(tgdv.field_77726_bs, 16384, 32768));
        object3 = new MultiItemRange();
        MultiItemRange multiItemRange = new MultiItemRange();
        MultiItemRange multiItemRange2 = new MultiItemRange();
        for (int n : treeSet) {
            List list = tgdv.field_77726_bs._a(n);
            int n2 = 0;
            if (list != null && !list.isEmpty() && (object = list.iterator()).hasNext()) {
                supr supr2 = (supr)object.next();
                n2 = hdpq._a[supr2._a()]._f() ? -1 : 1;
            }
            if (n2 == 0) {
                multiItemRange2.add(tgdv.field_77726_bs, n, n);
                continue;
            }
            if (n2 == 1) {
                ((MultiItemRange)object3).add(tgdv.field_77726_bs, n, n);
                continue;
            }
            if (n2 != -1) continue;
            multiItemRange.add(tgdv.field_77726_bs, n, n);
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
            this.precursorPotion = new PositionedStack(new cvzo(tgdv.field_77726_bs.field_77779_bT, 1, n2), 51, 35);
            this.ingredient = new PositionedStack(new cvzo(n, 1, 0), 74, 6);
            this.result = new PositionedStack(new cvzo(tgdv.field_77726_bs.field_77779_bT, 1, n3), 97, 35);
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

