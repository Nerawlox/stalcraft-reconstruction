/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.api;

import codechicken.lib.inventory.ItemKey;
import codechicken.nei.DropDownFile;
import codechicken.nei.KeyManager;
import codechicken.nei.LayoutManager;
import codechicken.nei.MultiItemRange;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.OffsetPositioner;
import codechicken.nei.SubSetRangeTag;
import codechicken.nei.api.GuiInfo;
import codechicken.nei.api.IHighlightHandler;
import codechicken.nei.api.IInfiniteItemHandler;
import codechicken.nei.api.INEIGuiHandler;
import codechicken.nei.api.INEIModeHandler;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IStackPositioner;
import codechicken.nei.api.ItemInfo;
import codechicken.nei.api.LayoutStyle;
import codechicken.nei.api.NEIInfo;
import codechicken.nei.config.Option;
import codechicken.nei.config.OptionKeyBind;
import codechicken.nei.recipe.GuiCraftingRecipe;
import codechicken.nei.recipe.GuiUsageRecipe;
import codechicken.nei.recipe.ICraftingHandler;
import codechicken.nei.recipe.IUsageHandler;
import codechicken.nei.recipe.RecipeInfo;
import java.util.ArrayList;
import java.util.Collection;

public class API {
    public static void registerRecipeHandler(ICraftingHandler iCraftingHandler) {
        GuiCraftingRecipe.registerRecipeHandler(iCraftingHandler);
    }

    public static void registerUsageHandler(IUsageHandler iUsageHandler) {
        GuiUsageRecipe.registerUsageHandler(iUsageHandler);
    }

    public static void registerGuiOverlay(Class<? extends zybc> clazz, String string) {
        API.registerGuiOverlay(clazz, string, 5, 11);
    }

    public static void registerGuiOverlay(Class<? extends zybc> clazz, String string, int n, int n2) {
        API.registerGuiOverlay(clazz, string, new OffsetPositioner(n, n2));
    }

    public static void registerGuiOverlay(Class<? extends zybc> clazz, String string, IStackPositioner iStackPositioner) {
        RecipeInfo.registerGuiOverlay(clazz, string, iStackPositioner);
    }

    public static void registerGuiOverlayHandler(Class<? extends zybc> clazz, IOverlayHandler iOverlayHandler, String string) {
        RecipeInfo.registerOverlayHandler(clazz, iOverlayHandler, string);
    }

    public static void setGuiOffset(Class<? extends zybc> clazz, int n, int n2) {
        RecipeInfo.setGuiOffset(clazz, n, n2);
    }

    public static void registerNEIGuiHandler(INEIGuiHandler iNEIGuiHandler) {
        GuiInfo.guiHandlers.add(iNEIGuiHandler);
    }

    public static void hideItem(int n) {
        ItemInfo.excludeIds.add(n);
    }

    public static void hideItems(Collection<Integer> collection) {
        ItemInfo.excludeIds.addAll(collection);
    }

    public static void setOverrideName(int n, int n2, String string) {
        ItemInfo.fallbackNames.put(new ItemKey(n, n2), string);
    }

    public static void setItemDamageVariants(int n, ArrayList<int[]> arrayList) {
        ItemInfo.damageVariants.put(n, arrayList);
    }

    public static void setItemDamageVariants(int n, Collection<Integer> collection) {
        API.setItemDamageVariants(n, NEIClientUtils.concatIntegersToRanges(new ArrayList<Integer>(collection)));
    }

    public static void setMaxDamageException(int n, int n2) {
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        arrayList.add(new int[]{0, n2});
        API.setItemDamageVariants(n, arrayList);
    }

    public static void addNBTItem(cvzo cvzo2) {
        ArrayList<cvzo> arrayList = ItemInfo.itemcompounds.get(cvzo2._d);
        if (arrayList == null) {
            arrayList = new ArrayList();
            ItemInfo.itemcompounds.put(cvzo2._d, arrayList);
        }
        arrayList.add(cvzo2);
    }

    public static void addSetRange(String string, MultiItemRange multiItemRange) {
        SubSetRangeTag subSetRangeTag = DropDownFile.dropDownInstance.getTag(string);
        subSetRangeTag.saveTag = false;
        subSetRangeTag.setRange(multiItemRange);
        DropDownFile.dropDownInstance.updateState();
    }

    public static SubSetRangeTag getRangeTag(String string) {
        return DropDownFile.dropDownInstance.getTag(string);
    }

    public static void addToRange(String string, MultiItemRange multiItemRange) {
        SubSetRangeTag subSetRangeTag = DropDownFile.dropDownInstance.getTag(string);
        if (subSetRangeTag.validranges == null) {
            subSetRangeTag.setRange(multiItemRange);
        } else {
            subSetRangeTag.validranges.add(multiItemRange);
        }
    }

    public static void addKeyBind(String string, int n) {
        NEIClientConfig.setDefaultKeyBinding(string, n);
        KeyManager.keyStates.put(string, new KeyManager.KeyState());
        API.addOption(new OptionKeyBind(string));
    }

    public static void addOption(Option option) {
        NEIClientConfig.getOptionList().addOption(option);
    }

    public static void addLayoutStyle(int n, LayoutStyle layoutStyle) {
        LayoutManager.layoutStyles.put(n, layoutStyle);
    }

    public static void addInfiniteItemHandler(IInfiniteItemHandler iInfiniteItemHandler) {
        ItemInfo.infiniteHandlers.addFirst(iInfiniteItemHandler);
    }

    public static void registerHighlightIdentifier(int n, IHighlightHandler iHighlightHandler) {
        ArrayList<IHighlightHandler> arrayList = ItemInfo.highlightIdentifiers.get(n);
        if (arrayList == null) {
            arrayList = new ArrayList();
            ItemInfo.highlightIdentifiers.put(n, arrayList);
        }
        arrayList.add(iHighlightHandler);
    }

    public static void addFastTransferExemptSlot(Class<? extends yeso> clazz) {
        ItemInfo.fastTransferExemptions.add(clazz);
    }

    public static void registerHighlightHandler(IHighlightHandler iHighlightHandler, ItemInfo.Layout ... layoutArray) {
        ItemInfo.registerHighlightHandler(iHighlightHandler, layoutArray);
    }

    public static void registerModeHandler(INEIModeHandler iNEIModeHandler) {
        NEIInfo.modeHandlers.add(iNEIModeHandler);
    }
}

