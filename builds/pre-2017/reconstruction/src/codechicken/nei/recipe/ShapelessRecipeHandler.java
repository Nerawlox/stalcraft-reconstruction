/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.core.ReflectionManager;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.ShapedRecipeHandler;
import codechicken.nei.recipe.TemplateRecipeHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ShapelessRecipeHandler
extends ShapedRecipeHandler {
    public int[][] stackorder = new int[][]{{0, 0}, {1, 0}, {0, 1}, {1, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};

    @Override
    public String getRecipeName() {
        return NEIClientUtils.translate("recipe.shapeless", new Object[0]);
    }

    @Override
    public void loadCraftingRecipes(String string, Object ... objectArray) {
        if (string.equals("crafting") && this.getClass() == ShapelessRecipeHandler.class) {
            List list = CraftingManager._a()._b();
            for (lpso lpso2 : list) {
                CachedShapelessRecipe cachedShapelessRecipe = null;
                if (lpso2 instanceof vmoj) {
                    cachedShapelessRecipe = new CachedShapelessRecipe((vmoj)lpso2);
                } else if (lpso2 instanceof ShapelessOreRecipe) {
                    cachedShapelessRecipe = this.forgeShapelessRecipe((ShapelessOreRecipe)lpso2);
                }
                if (cachedShapelessRecipe == null) continue;
                this.arecipes.add(cachedShapelessRecipe);
            }
        } else {
            super.loadCraftingRecipes(string, objectArray);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack itemStack) {
        List list = CraftingManager._a()._b();
        for (lpso lpso2 : list) {
            if (!NEIServerUtils.areStacksSameTypeCrafting(lpso2.getRecipeOutput(), itemStack)) continue;
            CachedShapelessRecipe cachedShapelessRecipe = null;
            if (lpso2 instanceof vmoj) {
                cachedShapelessRecipe = new CachedShapelessRecipe((vmoj)lpso2);
            } else if (lpso2 instanceof ShapelessOreRecipe) {
                cachedShapelessRecipe = this.forgeShapelessRecipe((ShapelessOreRecipe)lpso2);
            }
            if (cachedShapelessRecipe == null) continue;
            this.arecipes.add(cachedShapelessRecipe);
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack itemStack) {
        List list = CraftingManager._a()._b();
        for (lpso lpso2 : list) {
            CachedShapelessRecipe cachedShapelessRecipe = null;
            if (lpso2 instanceof vmoj) {
                cachedShapelessRecipe = new CachedShapelessRecipe((vmoj)lpso2);
            } else if (lpso2 instanceof ShapelessOreRecipe) {
                cachedShapelessRecipe = this.forgeShapelessRecipe((ShapelessOreRecipe)lpso2);
            }
            if (cachedShapelessRecipe == null || !cachedShapelessRecipe.contains(cachedShapelessRecipe.ingredients, itemStack)) continue;
            cachedShapelessRecipe.setIngredientPermutation(cachedShapelessRecipe.ingredients, itemStack);
            this.arecipes.add(cachedShapelessRecipe);
        }
    }

    public CachedShapelessRecipe forgeShapelessRecipe(ShapelessOreRecipe shapelessOreRecipe) {
        ArrayList arrayList;
        try {
            arrayList = ReflectionManager.getField(ShapelessOreRecipe.class, ArrayList.class, (Object)shapelessOreRecipe, 1);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        for (int i = 0; i < arrayList.size(); ++i) {
            if (!(arrayList.get(i) instanceof List) || !((List)arrayList.get(i)).isEmpty()) continue;
            return null;
        }
        return new CachedShapelessRecipe(arrayList, shapelessOreRecipe.getRecipeOutput());
    }

    @Override
    public boolean isRecipe2x2(int n) {
        return this.getIngredientStacks(n).size() <= 4;
    }

    public class CachedShapelessRecipe
    extends TemplateRecipeHandler.CachedRecipe {
        public ArrayList<PositionedStack> ingredients;
        public PositionedStack result;

        public CachedShapelessRecipe() {
            super(ShapelessRecipeHandler.this);
            this.ingredients = new ArrayList();
        }

        public CachedShapelessRecipe(ItemStack itemStack) {
            this();
            this.setResult(itemStack);
        }

        public CachedShapelessRecipe(vmoj vmoj2) {
            this(vmoj2.getRecipeOutput());
            this.setIngredients(vmoj2);
        }

        public CachedShapelessRecipe(Object[] objectArray, ItemStack itemStack) {
            this(Arrays.asList(objectArray), itemStack);
        }

        public CachedShapelessRecipe(List<?> list, ItemStack itemStack) {
            this(itemStack);
            this.setIngredients(list);
        }

        public void setIngredients(List<?> list) {
            this.ingredients.clear();
            for (int i = 0; i < list.size(); ++i) {
                PositionedStack positionedStack = new PositionedStack(list.get(i), 25 + ShapelessRecipeHandler.this.stackorder[i][0] * 18, 6 + ShapelessRecipeHandler.this.stackorder[i][1] * 18);
                positionedStack.setMaxSize(1);
                this.ingredients.add(positionedStack);
            }
        }

        public void setIngredients(vmoj vmoj2) {
            List list;
            try {
                list = ReflectionManager.getField(vmoj.class, List.class, (Object)vmoj2, 1);
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return;
            }
            this.setIngredients(list);
        }

        public void setResult(ItemStack itemStack) {
            this.result = new PositionedStack(itemStack, 119, 24);
        }

        @Override
        public List<PositionedStack> getIngredients() {
            return this.getCycledIngredients(ShapelessRecipeHandler.this.cycleticks / 20, this.ingredients);
        }

        @Override
        public PositionedStack getResult() {
            return this.result;
        }
    }
}

