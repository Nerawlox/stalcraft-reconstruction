/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.core.Profiler;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.IRecipeHandler;
import codechicken.nei.recipe.IUsageHandler;
import codechicken.nei.recipe.ProfilerRecipeHandler;
import java.util.ArrayList;
import net.minecraft.client.xpzm;

public class GuiUsageRecipe
extends GuiRecipe {
    public ArrayList<IUsageHandler> currenthandlers;
    public static ArrayList<IUsageHandler> usagehandlers = new ArrayList();

    private GuiUsageRecipe(zybc zybc2, ArrayList<IUsageHandler> arrayList) {
        super(zybc2);
        this.currenthandlers = arrayList;
    }

    public static void registerUsageHandler(IUsageHandler iUsageHandler) {
        for (IUsageHandler iUsageHandler2 : usagehandlers) {
            if (iUsageHandler2.getClass() != iUsageHandler.getClass()) continue;
            return;
        }
        usagehandlers.add(iUsageHandler);
    }

    public static boolean openRecipeGui(String string, Object ... objectArray) {
        xpzm xpzm2 = NEIClientUtils.mc();
        if (!(xpzm2._B instanceof zybc)) {
            return false;
        }
        zybc zybc2 = (zybc)xpzm2._B;
        Profiler profiler = ProfilerRecipeHandler.getProfiler();
        ArrayList<IUsageHandler> arrayList = new ArrayList<IUsageHandler>();
        for (IUsageHandler iUsageHandler : usagehandlers) {
            profiler.start(iUsageHandler.getRecipeName());
            IUsageHandler iUsageHandler2 = iUsageHandler.getUsageHandler(string, objectArray);
            if (iUsageHandler2.numRecipes() <= 0) continue;
            arrayList.add(iUsageHandler2);
        }
        profiler.end();
        if (arrayList.isEmpty()) {
            return false;
        }
        NEIClientUtils.overlayScreen(new GuiUsageRecipe(zybc2, arrayList));
        return true;
    }

    @Override
    public ArrayList<? extends IRecipeHandler> getCurrentRecipeHandlers() {
        return this.currenthandlers;
    }
}

