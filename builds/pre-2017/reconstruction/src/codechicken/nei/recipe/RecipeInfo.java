/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.nei.OffsetPositioner;
import codechicken.nei.api.API;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IStackPositioner;
import codechicken.nei.recipe.BrewingOverlayHandler;
import codechicken.nei.recipe.BrewingRecipeHandler;
import codechicken.nei.recipe.DefaultOverlayHandler;
import codechicken.nei.recipe.FireworkRecipeHandler;
import codechicken.nei.recipe.FuelRecipeHandler;
import codechicken.nei.recipe.FurnaceRecipeHandler;
import codechicken.nei.recipe.ProfilerRecipeHandler;
import codechicken.nei.recipe.ShapedRecipeHandler;
import codechicken.nei.recipe.ShapelessRecipeHandler;
import com.google.common.base.Objects;
import java.util.HashMap;
import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.gui.inventory.GuiFurnace;

public class RecipeInfo {
    static HashMap<OverlayKey, IOverlayHandler> overlayMap = new HashMap();
    static HashMap<OverlayKey, IStackPositioner> positionerMap = new HashMap();
    static HashMap<Class<? extends GuiContainer>, int[]> offsets = new HashMap();

    public static void registerOverlayHandler(Class<? extends GuiContainer> clazz, IOverlayHandler iOverlayHandler, String string) {
        overlayMap.put(new OverlayKey(clazz, string), iOverlayHandler);
    }

    public static void registerGuiOverlay(Class<? extends GuiContainer> clazz, String string, IStackPositioner iStackPositioner) {
        positionerMap.put(new OverlayKey(clazz, string), iStackPositioner);
        if (iStackPositioner instanceof OffsetPositioner && !offsets.containsKey(clazz)) {
            OffsetPositioner offsetPositioner = (OffsetPositioner)iStackPositioner;
            RecipeInfo.setGuiOffset(clazz, offsetPositioner.offsetx, offsetPositioner.offsety);
        }
    }

    public static void setGuiOffset(Class<? extends GuiContainer> clazz, int n, int n2) {
        offsets.put(clazz, new int[]{n, n2});
    }

    public static boolean hasDefaultOverlay(GuiContainer guiContainer, String string) {
        return positionerMap.containsKey(new OverlayKey(guiContainer.getClass(), string));
    }

    public static boolean hasOverlayHandler(GuiContainer guiContainer, String string) {
        return overlayMap.containsKey(new OverlayKey(guiContainer.getClass(), string));
    }

    public static IOverlayHandler getOverlayHandler(GuiContainer guiContainer, String string) {
        return overlayMap.get(new OverlayKey(guiContainer.getClass(), string));
    }

    public static IStackPositioner getStackPositioner(GuiContainer guiContainer, String string) {
        return positionerMap.get(new OverlayKey(guiContainer.getClass(), string));
    }

    public static int[] getGuiOffset(GuiContainer guiContainer) {
        int[] nArray;
        int[] nArray2 = offsets.get(guiContainer.getClass());
        if (nArray2 == null) {
            int[] nArray3 = new int[2];
            nArray3[0] = 5;
            nArray = nArray3;
            nArray3[1] = 11;
        } else {
            nArray = nArray2;
        }
        return nArray;
    }

    public static void load() {
        API.registerRecipeHandler(new ShapedRecipeHandler());
        API.registerUsageHandler(new ShapedRecipeHandler());
        API.registerRecipeHandler(new ShapelessRecipeHandler());
        API.registerUsageHandler(new ShapelessRecipeHandler());
        API.registerRecipeHandler(new FireworkRecipeHandler());
        API.registerUsageHandler(new FireworkRecipeHandler());
        API.registerRecipeHandler(new FurnaceRecipeHandler());
        API.registerUsageHandler(new FurnaceRecipeHandler());
        API.registerRecipeHandler(new BrewingRecipeHandler());
        API.registerUsageHandler(new BrewingRecipeHandler());
        API.registerRecipeHandler(new FuelRecipeHandler());
        API.registerUsageHandler(new FuelRecipeHandler());
        API.registerGuiOverlay(GuiCrafting.class, "crafting");
        API.registerGuiOverlay(cebg.class, "crafting2x2", 63, 20);
        API.registerGuiOverlay(GuiFurnace.class, "smelting");
        API.registerGuiOverlay(GuiFurnace.class, "fuel");
        API.registerGuiOverlay(GuiBrewingStand.class, "brewing");
        API.registerGuiOverlayHandler(GuiCrafting.class, new DefaultOverlayHandler(), "crafting");
        API.registerGuiOverlayHandler(cebg.class, new DefaultOverlayHandler(63, 20), "crafting2x2");
        API.registerGuiOverlayHandler(GuiBrewingStand.class, new BrewingOverlayHandler(), "brewing");
        API.registerRecipeHandler(new ProfilerRecipeHandler(true));
        API.registerUsageHandler(new ProfilerRecipeHandler(false));
    }

    private static class OverlayKey {
        String ident;
        Class<? extends GuiContainer> guiClass;

        public OverlayKey(Class<? extends GuiContainer> clazz, String string) {
            this.guiClass = clazz;
            this.ident = string;
        }

        public boolean equals(Object object) {
            if (!(object instanceof OverlayKey)) {
                return false;
            }
            OverlayKey overlayKey = (OverlayKey)object;
            return Objects.equal(this.ident, overlayKey.ident) && this.guiClass == overlayKey.guiClass;
        }

        public int hashCode() {
            return Objects.hashCode(this.ident, this.guiClass);
        }
    }
}

