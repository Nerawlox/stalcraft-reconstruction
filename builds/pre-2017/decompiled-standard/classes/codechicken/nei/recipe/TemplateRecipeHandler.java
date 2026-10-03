/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.core.gui.GuiDraw;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.DefaultOverlayRenderer;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.api.IStackPositioner;
import codechicken.nei.forge.GuiContainerManager;
import codechicken.nei.forge.IContainerInputHandler;
import codechicken.nei.forge.IContainerTooltipHandler;
import codechicken.nei.recipe.GuiCraftingRecipe;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.GuiUsageRecipe;
import codechicken.nei.recipe.ICraftingHandler;
import codechicken.nei.recipe.IUsageHandler;
import codechicken.nei.recipe.RecipeInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.lwjgl.opengl.GL11;

public abstract class TemplateRecipeHandler
implements ICraftingHandler,
IUsageHandler {
    public int cycleticks = Math.abs((int)System.currentTimeMillis());
    public ArrayList<CachedRecipe> arecipes = new ArrayList();
    public LinkedList<RecipeTransferRect> transferRects = new LinkedList();

    public TemplateRecipeHandler() {
        this.loadTransferRects();
        RecipeTransferRectHandler.registerRectsToGuis(this.getRecipeTransferRectGuis(), this.transferRects);
    }

    public void loadTransferRects() {
    }

    public void loadCraftingRecipes(String string, Object ... objectArray) {
        if (string.equals("item")) {
            this.loadCraftingRecipes((cvzo)objectArray[0]);
        }
    }

    public void loadCraftingRecipes(cvzo cvzo2) {
    }

    public void loadUsageRecipes(String string, Object ... objectArray) {
        if (string.equals("item")) {
            this.loadUsageRecipes((cvzo)objectArray[0]);
        }
    }

    public void loadUsageRecipes(cvzo cvzo2) {
    }

    public abstract String getGuiTexture();

    public String getOverlayIdentifier() {
        return null;
    }

    public void drawExtras(int n) {
    }

    public void drawProgressBar(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.drawProgressBar(n, n2, n3, n4, n5, n6, (float)(this.cycleticks % n7) / (float)n7, n8);
    }

    public void drawProgressBar(int n, int n2, int n3, int n4, int n5, int n6, float f, int n7) {
        if (n7 > 3) {
            f = 1.0f - f;
            n7 %= 4;
        }
        int n8 = (int)(f * (float)(n7 % 2 == 0 ? n5 : n6));
        switch (n7) {
            case 0: {
                GuiDraw.drawTexturedModalRect(n, n2, n3, n4, n8, n6);
                break;
            }
            case 1: {
                GuiDraw.drawTexturedModalRect(n, n2, n3, n4, n5, n8);
                break;
            }
            case 2: {
                GuiDraw.drawTexturedModalRect(n + n5 - n8, n2, n3 + n5 - n8, n4, n8, n6);
                break;
            }
            case 3: {
                GuiDraw.drawTexturedModalRect(n, n2 + n6 - n8, n3, n4 + n6 - n8, n5, n8);
            }
        }
    }

    public List<Class<? extends zybc>> getRecipeTransferRectGuis() {
        Class<? extends zybc> clazz = this.getGuiClass();
        if (clazz != null) {
            LinkedList<Class<? extends zybc>> linkedList = new LinkedList<Class<? extends zybc>>();
            linkedList.add(clazz);
            return linkedList;
        }
        return null;
    }

    public Class<? extends zybc> getGuiClass() {
        return null;
    }

    public TemplateRecipeHandler newInstance() {
        try {
            return (TemplateRecipeHandler)this.getClass().newInstance();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public ICraftingHandler getRecipeHandler(String string, Object ... objectArray) {
        TemplateRecipeHandler templateRecipeHandler = this.newInstance();
        templateRecipeHandler.loadCraftingRecipes(string, objectArray);
        return templateRecipeHandler;
    }

    @Override
    public IUsageHandler getUsageHandler(String string, Object ... objectArray) {
        TemplateRecipeHandler templateRecipeHandler = this.newInstance();
        templateRecipeHandler.loadUsageRecipes(string, objectArray);
        return templateRecipeHandler;
    }

    @Override
    public int numRecipes() {
        return this.arecipes.size();
    }

    @Override
    public void drawBackground(int n) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GuiDraw.changeTexture(this.getGuiTexture());
        GuiDraw.drawTexturedModalRect(0, 0, 5, 11, 166, 65);
    }

    @Override
    public void drawForeground(int n) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        GuiDraw.changeTexture(this.getGuiTexture());
        this.drawExtras(n);
    }

    @Override
    public List<PositionedStack> getIngredientStacks(int n) {
        return this.arecipes.get(n).getIngredients();
    }

    @Override
    public PositionedStack getResultStack(int n) {
        return this.arecipes.get(n).getResult();
    }

    @Override
    public List<PositionedStack> getOtherStacks(int n) {
        return this.arecipes.get(n).getOtherStacks();
    }

    @Override
    public void onUpdate() {
        if (!NEIClientUtils.shiftKey()) {
            ++this.cycleticks;
        }
    }

    @Override
    public boolean hasOverlay(zybc zybc2, jjgc jjgc2, int n) {
        return RecipeInfo.hasDefaultOverlay(zybc2, this.getOverlayIdentifier()) || RecipeInfo.hasOverlayHandler(zybc2, this.getOverlayIdentifier());
    }

    @Override
    public IRecipeOverlayRenderer getOverlayRenderer(zybc zybc2, int n) {
        IStackPositioner iStackPositioner = RecipeInfo.getStackPositioner(zybc2, this.getOverlayIdentifier());
        if (iStackPositioner == null) {
            return null;
        }
        return new DefaultOverlayRenderer(this.getIngredientStacks(n), iStackPositioner);
    }

    @Override
    public IOverlayHandler getOverlayHandler(zybc zybc2, int n) {
        return RecipeInfo.getOverlayHandler(zybc2, this.getOverlayIdentifier());
    }

    @Override
    public int recipiesPerPage() {
        return 2;
    }

    @Override
    public List<String> handleTooltip(GuiRecipe guiRecipe, List<String> list2, int n) {
        if (guiRecipe.manager.shouldShowTooltip() && list2.size() == 0) {
            Point point = guiRecipe.getRecipePosition(n);
            list2 = TemplateRecipeHandler.transferRectTooltip(guiRecipe, this.transferRects, point.x, point.y, list2);
        }
        return list2;
    }

    @Override
    public List<String> handleItemTooltip(GuiRecipe guiRecipe, cvzo cvzo2, List<String> list2, int n) {
        return list2;
    }

    @Override
    public boolean keyTyped(GuiRecipe guiRecipe, char c, int n, int n2) {
        if (n == NEIClientConfig.getKeyBinding("gui.recipe")) {
            return this.transferRect(guiRecipe, n2, false);
        }
        if (n == NEIClientConfig.getKeyBinding("gui.usage")) {
            return this.transferRect(guiRecipe, n2, true);
        }
        return false;
    }

    @Override
    public boolean mouseClicked(GuiRecipe guiRecipe, int n, int n2) {
        if (n == 0) {
            return this.transferRect(guiRecipe, n2, false);
        }
        if (n == 1) {
            return this.transferRect(guiRecipe, n2, true);
        }
        return false;
    }

    private boolean transferRect(GuiRecipe guiRecipe, int n, boolean bl) {
        Point point = guiRecipe.getRecipePosition(n);
        return TemplateRecipeHandler.transferRect(guiRecipe, this.transferRects, point.x, point.y, bl);
    }

    private static boolean transferRect(zybc zybc2, Collection<RecipeTransferRect> collection, int n, int n2, boolean bl) {
        Point point = GuiDraw.getMousePosition();
        Point point2 = new Point(point.x - zybc2.field_74198_m - n, point.y - zybc2.field_74197_n - n2);
        for (RecipeTransferRect recipeTransferRect : collection) {
            if (!recipeTransferRect.rect.contains(point2) || !(bl ? GuiUsageRecipe.openRecipeGui(recipeTransferRect.outputId, recipeTransferRect.results) : GuiCraftingRecipe.openRecipeGui(recipeTransferRect.outputId, recipeTransferRect.results))) continue;
            return true;
        }
        return false;
    }

    private static List<String> transferRectTooltip(zybc zybc2, Collection<RecipeTransferRect> collection, int n, int n2, List<String> list2) {
        Point point = GuiDraw.getMousePosition();
        Point point2 = new Point(point.x - zybc2.field_74198_m - n, point.y - zybc2.field_74197_n - n2);
        for (RecipeTransferRect recipeTransferRect : collection) {
            if (!recipeTransferRect.rect.contains(point2)) continue;
            list2.add("Recipes");
            break;
        }
        return list2;
    }

    static {
        GuiContainerManager.addInputHandler(new RecipeTransferRectHandler());
        GuiContainerManager.addTooltipHandler(new RecipeTransferRectHandler());
    }

    public static class RecipeTransferRectHandler
    implements IContainerInputHandler,
    IContainerTooltipHandler {
        private static HashMap<Class<? extends zybc>, HashSet<RecipeTransferRect>> guiMap = new HashMap();

        public static void registerRectsToGuis(List<Class<? extends zybc>> list2, List<RecipeTransferRect> list3) {
            if (list2 == null) {
                return;
            }
            for (Class<? extends zybc> clazz : list2) {
                HashSet<RecipeTransferRect> hashSet = guiMap.get(clazz);
                if (hashSet == null) {
                    hashSet = new HashSet();
                    guiMap.put(clazz, hashSet);
                }
                hashSet.addAll(list3);
            }
        }

        public boolean canHandle(zybc zybc2) {
            return guiMap.containsKey(zybc2.getClass());
        }

        @Override
        public boolean lastKeyTyped(zybc zybc2, char c, int n) {
            if (!this.canHandle(zybc2)) {
                return false;
            }
            if (n == NEIClientConfig.getKeyBinding("gui.recipe")) {
                return this.transferRect(zybc2, false);
            }
            if (n == NEIClientConfig.getKeyBinding("gui.usage")) {
                return this.transferRect(zybc2, true);
            }
            return false;
        }

        @Override
        public boolean mouseClicked(zybc zybc2, int n, int n2, int n3) {
            if (!this.canHandle(zybc2)) {
                return false;
            }
            if (n3 == 0) {
                return this.transferRect(zybc2, false);
            }
            if (n3 == 1) {
                return this.transferRect(zybc2, true);
            }
            return false;
        }

        private boolean transferRect(zybc zybc2, boolean bl) {
            int[] nArray = RecipeInfo.getGuiOffset(zybc2);
            return TemplateRecipeHandler.transferRect(zybc2, RecipeTransferRectHandler.guiMap.get(zybc2.getClass()), nArray[0], nArray[1], bl);
        }

        @Override
        public void onKeyTyped(zybc zybc2, char c, int n) {
        }

        @Override
        public void onMouseClicked(zybc zybc2, int n, int n2, int n3) {
        }

        @Override
        public void onMouseUp(zybc zybc2, int n, int n2, int n3) {
        }

        @Override
        public boolean keyTyped(zybc zybc2, char c, int n) {
            return false;
        }

        @Override
        public boolean mouseScrolled(zybc zybc2, int n, int n2, int n3) {
            return false;
        }

        @Override
        public void onMouseScrolled(zybc zybc2, int n, int n2, int n3) {
        }

        @Override
        public List<String> handleTooltipFirst(zybc zybc2, int n, int n2, List<String> list2) {
            if (!this.canHandle(zybc2)) {
                return list2;
            }
            if (zybc2.manager.shouldShowTooltip() && list2.size() == 0) {
                int[] nArray = RecipeInfo.getGuiOffset(zybc2);
                list2 = TemplateRecipeHandler.transferRectTooltip(zybc2, RecipeTransferRectHandler.guiMap.get(zybc2.getClass()), nArray[0], nArray[1], list2);
            }
            return list2;
        }

        @Override
        public List<String> handleItemTooltip(zybc zybc2, cvzo cvzo2, List<String> list2) {
            return list2;
        }

        @Override
        public void onMouseDragged(zybc zybc2, int n, int n2, int n3, long l) {
        }
    }

    public static class RecipeTransferRect {
        Rectangle rect;
        String outputId;
        Object[] results;

        public RecipeTransferRect(Rectangle rectangle, String string, Object ... objectArray) {
            this.rect = rectangle;
            this.outputId = string;
            this.results = objectArray;
        }

        public boolean equals(Object object) {
            if (!(object instanceof RecipeTransferRect)) {
                return false;
            }
            return this.rect.equals(((RecipeTransferRect)object).rect);
        }

        public int hashCode() {
            return this.rect.hashCode();
        }
    }

    public abstract class CachedRecipe {
        final long offset = System.currentTimeMillis();

        public abstract PositionedStack getResult();

        public List<PositionedStack> getIngredients() {
            ArrayList<PositionedStack> arrayList = new ArrayList<PositionedStack>();
            PositionedStack positionedStack = this.getIngredient();
            if (positionedStack != null) {
                arrayList.add(positionedStack);
            }
            return arrayList;
        }

        public PositionedStack getIngredient() {
            return null;
        }

        public List<PositionedStack> getOtherStacks() {
            ArrayList<PositionedStack> arrayList = new ArrayList<PositionedStack>();
            PositionedStack positionedStack = this.getOtherStack();
            if (positionedStack != null) {
                arrayList.add(positionedStack);
            }
            return arrayList;
        }

        public PositionedStack getOtherStack() {
            return null;
        }

        public List<PositionedStack> getCycledIngredients(int n, List<PositionedStack> list2) {
            for (int i = 0; i < list2.size(); ++i) {
                this.randomRenderPermutation(list2.get(i), n + i);
            }
            return list2;
        }

        public void randomRenderPermutation(PositionedStack positionedStack, long l) {
            Random random = new Random(l + this.offset);
            positionedStack.setPermutationToRender(Math.abs(random.nextInt()) % positionedStack.items.length);
        }

        public void setIngredientPermutation(Collection<PositionedStack> collection, cvzo cvzo2) {
            block0: for (PositionedStack positionedStack : collection) {
                for (int i = 0; i < positionedStack.items.length; ++i) {
                    if (!NEIServerUtils.areStacksSameTypeCrafting(cvzo2, positionedStack.items[i])) continue;
                    positionedStack.item = positionedStack.items[i];
                    positionedStack.item._b(cvzo2._j());
                    positionedStack.items = new cvzo[]{positionedStack.item};
                    positionedStack.setPermutationToRender(0);
                    continue block0;
                }
            }
        }

        public boolean contains(Collection<PositionedStack> collection, cvzo cvzo2) {
            for (PositionedStack positionedStack : collection) {
                if (!positionedStack.contains(cvzo2)) continue;
                return true;
            }
            return false;
        }

        public boolean contains(Collection<PositionedStack> collection, int n) {
            for (PositionedStack positionedStack : collection) {
                if (!positionedStack.contains(n)) continue;
                return true;
            }
            return false;
        }
    }
}

