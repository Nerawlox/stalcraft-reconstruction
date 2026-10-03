/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.nei.NEIClientUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.FurnaceRecipeHandler;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.TemplateRecipeHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.item.ItemStack;

public class FuelRecipeHandler
extends FurnaceRecipeHandler {
    public static ArrayList<FurnaceRecipeHandler.SmeltingPair> mfurnace;

    public FuelRecipeHandler() {
        this.loadAllSmelting();
    }

    @Override
    public String getRecipeName() {
        return NEIClientUtils.translate("recipe.fuel", new Object[0]);
    }

    public void loadAllSmelting() {
        ItemStack itemStack;
        if (mfurnace != null) {
            return;
        }
        mfurnace = new ArrayList();
        HashMap hashMap = (HashMap)yewu._a()._b();
        HashMap hashMap2 = (HashMap)yewu._a()._c();
        for (Map.Entry entry : hashMap.entrySet()) {
            itemStack = (ItemStack)entry.getValue();
            int n = (Integer)entry.getKey();
            mfurnace.add(new FurnaceRecipeHandler.SmeltingPair(this, new ItemStack(n, 1, 0), itemStack));
        }
        if (hashMap2 == null) {
            return;
        }
        for (Map.Entry entry : hashMap2.entrySet()) {
            itemStack = (ItemStack)entry.getValue();
            mfurnace.add(new FurnaceRecipeHandler.SmeltingPair(this, new ItemStack((Integer)((List)entry.getKey()).get(0), 1, (int)((Integer)((List)entry.getKey()).get(1))), itemStack));
        }
    }

    @Override
    public void loadCraftingRecipes(String string, Object ... objectArray) {
        if (string.equals("fuel") && this.getClass() == FuelRecipeHandler.class) {
            for (FurnaceRecipeHandler.FuelPair fuelPair : FurnaceRecipeHandler.afuels) {
                this.arecipes.add(new CachedFuelRecipe(fuelPair));
            }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack itemStack) {
        for (FurnaceRecipeHandler.FuelPair fuelPair : FurnaceRecipeHandler.afuels) {
            if (!fuelPair.stack.contains(itemStack)) continue;
            this.arecipes.add(new CachedFuelRecipe(fuelPair));
        }
    }

    @Override
    public String getOverlayIdentifier() {
        return "fuel";
    }

    @Override
    public List<String> handleItemTooltip(GuiRecipe guiRecipe, ItemStack itemStack, List<String> list, int n) {
        CachedFuelRecipe cachedFuelRecipe = (CachedFuelRecipe)this.arecipes.get(n);
        FurnaceRecipeHandler.FuelPair fuelPair = cachedFuelRecipe.fuel;
        float f = (float)fuelPair.burnTime / 200.0f;
        if (guiRecipe.isMouseOver(fuelPair.stack, n) && f < 1.0f) {
            f = 1.0f / f;
            String string = Float.toString(f);
            if (f == (float)Math.round(f)) {
                string = Integer.toString((int)f);
            }
            list.add(NEIClientUtils.translate("recipe.fuel.required", string));
        } else if ((guiRecipe.isMouseOver(cachedFuelRecipe.getResult(), n) || guiRecipe.isMouseOver(cachedFuelRecipe.getIngredient(), n)) && f > 1.0f) {
            String string = Float.toString(f);
            if (f == (float)Math.round(f)) {
                string = Integer.toString((int)f);
            }
            list.add(NEIClientUtils.translate("recipe.fuel." + (guiRecipe.isMouseOver(cachedFuelRecipe.getResult(), n) ? "produced" : "processed"), string));
        }
        return list;
    }

    public class CachedFuelRecipe
    extends TemplateRecipeHandler.CachedRecipe {
        public FurnaceRecipeHandler.FuelPair fuel;

        public CachedFuelRecipe(FurnaceRecipeHandler.FuelPair fuelPair) {
            super(FuelRecipeHandler.this);
            this.fuel = fuelPair;
        }

        @Override
        public PositionedStack getIngredient() {
            return FuelRecipeHandler.mfurnace.get((int)(FuelRecipeHandler.this.cycleticks / 48 % FuelRecipeHandler.mfurnace.size())).ingred;
        }

        @Override
        public PositionedStack getResult() {
            return FuelRecipeHandler.mfurnace.get((int)(FuelRecipeHandler.this.cycleticks / 48 % FuelRecipeHandler.mfurnace.size())).result;
        }

        @Override
        public PositionedStack getOtherStack() {
            return this.fuel.stack;
        }
    }
}

