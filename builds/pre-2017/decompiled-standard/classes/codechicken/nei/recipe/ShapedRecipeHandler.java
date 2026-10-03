/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.core.ReflectionManager;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.DefaultOverlayRenderer;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.api.IStackPositioner;
import codechicken.nei.recipe.RecipeInfo;
import codechicken.nei.recipe.TemplateRecipeHandler;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ShapedRecipeHandler
extends TemplateRecipeHandler {
    @Override
    public void loadTransferRects() {
        this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(84, 23, 24, 18), "crafting", new Object[0]));
    }

    @Override
    public Class<? extends zybc> getGuiClass() {
        return htnm.class;
    }

    @Override
    public String getRecipeName() {
        return NEIClientUtils.translate("recipe.shaped", new Object[0]);
    }

    @Override
    public void loadCraftingRecipes(String string, Object ... objectArray) {
        if (string.equals("crafting") && this.getClass() == ShapedRecipeHandler.class) {
            List list2 = igjl._a()._b();
            for (lpso lpso2 : list2) {
                CachedShapedRecipe cachedShapedRecipe = null;
                if (lpso2 instanceof xbtf) {
                    cachedShapedRecipe = new CachedShapedRecipe((xbtf)lpso2);
                } else if (lpso2 instanceof ShapedOreRecipe) {
                    cachedShapedRecipe = this.forgeShapedRecipe((ShapedOreRecipe)lpso2);
                }
                if (cachedShapedRecipe == null) continue;
                cachedShapedRecipe.computeVisuals();
                this.arecipes.add(cachedShapedRecipe);
            }
        } else {
            super.loadCraftingRecipes(string, objectArray);
        }
    }

    @Override
    public void loadCraftingRecipes(cvzo cvzo2) {
        List list2 = igjl._a()._b();
        for (lpso lpso2 : list2) {
            if (!NEIServerUtils.areStacksSameTypeCrafting(lpso2.func_77571_b(), cvzo2)) continue;
            CachedShapedRecipe cachedShapedRecipe = null;
            if (lpso2 instanceof xbtf) {
                cachedShapedRecipe = new CachedShapedRecipe((xbtf)lpso2);
            } else if (lpso2 instanceof ShapedOreRecipe) {
                cachedShapedRecipe = this.forgeShapedRecipe((ShapedOreRecipe)lpso2);
            }
            if (cachedShapedRecipe == null) continue;
            cachedShapedRecipe.computeVisuals();
            this.arecipes.add(cachedShapedRecipe);
        }
    }

    @Override
    public void loadUsageRecipes(cvzo cvzo2) {
        List list2 = igjl._a()._b();
        for (lpso lpso2 : list2) {
            CachedShapedRecipe cachedShapedRecipe = null;
            if (lpso2 instanceof xbtf) {
                cachedShapedRecipe = new CachedShapedRecipe((xbtf)lpso2);
            } else if (lpso2 instanceof ShapedOreRecipe) {
                cachedShapedRecipe = this.forgeShapedRecipe((ShapedOreRecipe)lpso2);
            }
            if (cachedShapedRecipe == null || !cachedShapedRecipe.contains(cachedShapedRecipe.ingredients, cvzo2._d)) continue;
            cachedShapedRecipe.computeVisuals();
            if (!cachedShapedRecipe.contains(cachedShapedRecipe.ingredients, cvzo2)) continue;
            cachedShapedRecipe.setIngredientPermutation(cachedShapedRecipe.ingredients, cvzo2);
            this.arecipes.add(cachedShapedRecipe);
        }
    }

    public CachedShapedRecipe forgeShapedRecipe(ShapedOreRecipe shapedOreRecipe) {
        Object[] objectArray;
        int n;
        int n2;
        try {
            n2 = ReflectionManager.getField(ShapedOreRecipe.class, Integer.class, (Object)shapedOreRecipe, 4);
            n = ReflectionManager.getField(ShapedOreRecipe.class, Integer.class, (Object)shapedOreRecipe, 5);
            objectArray = ReflectionManager.getField(ShapedOreRecipe.class, Object[].class, (Object)shapedOreRecipe, 3);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        for (int i = 0; i < objectArray.length; ++i) {
            if (!(objectArray[i] instanceof List) || !((List)objectArray[i]).isEmpty()) continue;
            return null;
        }
        return new CachedShapedRecipe(n2, n, objectArray, shapedOreRecipe.func_77571_b());
    }

    @Override
    public String getGuiTexture() {
        return "textures/gui/container/crafting_table.png";
    }

    @Override
    public String getOverlayIdentifier() {
        return "crafting";
    }

    @Override
    public boolean hasOverlay(zybc zybc2, jjgc jjgc2, int n) {
        return super.hasOverlay(zybc2, jjgc2, n) || this.isRecipe2x2(n) && RecipeInfo.hasDefaultOverlay(zybc2, "crafting2x2");
    }

    @Override
    public IRecipeOverlayRenderer getOverlayRenderer(zybc zybc2, int n) {
        IRecipeOverlayRenderer iRecipeOverlayRenderer = super.getOverlayRenderer(zybc2, n);
        if (iRecipeOverlayRenderer != null) {
            return iRecipeOverlayRenderer;
        }
        IStackPositioner iStackPositioner = RecipeInfo.getStackPositioner(zybc2, "crafting2x2");
        if (iStackPositioner == null) {
            return null;
        }
        return new DefaultOverlayRenderer(this.getIngredientStacks(n), iStackPositioner);
    }

    @Override
    public IOverlayHandler getOverlayHandler(zybc zybc2, int n) {
        IOverlayHandler iOverlayHandler = super.getOverlayHandler(zybc2, n);
        if (iOverlayHandler != null) {
            return iOverlayHandler;
        }
        return RecipeInfo.getOverlayHandler(zybc2, "crafting2x2");
    }

    public boolean isRecipe2x2(int n) {
        for (PositionedStack positionedStack : this.getIngredientStacks(n)) {
            if (positionedStack.relx <= 43 && positionedStack.rely <= 24) continue;
            return false;
        }
        return true;
    }

    public class CachedShapedRecipe
    extends TemplateRecipeHandler.CachedRecipe {
        public ArrayList<PositionedStack> ingredients;
        public PositionedStack result;

        public CachedShapedRecipe(int n, int n2, Object[] objectArray, cvzo cvzo2) {
            this.result = new PositionedStack(cvzo2, 119, 24);
            this.ingredients = new ArrayList();
            this.setIngredients(n, n2, objectArray);
        }

        public CachedShapedRecipe(xbtf xbtf2) {
            this(xbtf2._a, xbtf2._b, xbtf2._c, xbtf2.func_77571_b());
        }

        public void setIngredients(int n, int n2, Object[] objectArray) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n2; ++j) {
                    if (objectArray[j * n + i] == null) continue;
                    PositionedStack positionedStack = new PositionedStack(objectArray[j * n + i], 25 + i * 18, 6 + j * 18, false);
                    positionedStack.setMaxSize(1);
                    this.ingredients.add(positionedStack);
                }
            }
        }

        @Override
        public List<PositionedStack> getIngredients() {
            return this.getCycledIngredients(ShapedRecipeHandler.this.cycleticks / 20, this.ingredients);
        }

        @Override
        public PositionedStack getResult() {
            return this.result;
        }

        public void computeVisuals() {
            for (PositionedStack positionedStack : this.ingredients) {
                positionedStack.generatePermutations();
            }
            this.result.generatePermutations();
        }
    }
}

