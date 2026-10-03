/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.lib.inventory.InventoryRange;
import codechicken.lib.inventory.InventoryUtils;
import codechicken.nei.ClientHandler;
import codechicken.nei.FastTransferManager;
import codechicken.nei.ItemList;
import codechicken.nei.LayoutManager;
import codechicken.nei.NEIActions;
import codechicken.nei.NEICPH;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.api.GuiInfo;
import codechicken.nei.api.IInfiniteItemHandler;
import codechicken.nei.api.INEIGuiHandler;
import codechicken.nei.api.ItemInfo;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import org.lwjgl.input.Keyboard;

public class NEIClientUtils
extends NEIServerUtils {
    public static Minecraft mc() {
        return Minecraft._E();
    }

    public static String translate(String string, Object ... objectArray) {
        return ClientHandler.lang.translate(string, objectArray);
    }

    public static void addChatMessage(String string) {
        if (NEIClientUtils.mc()._J != null) {
            NEIClientUtils.mc()._J.getChatGUI()._a(string);
        }
    }

    public static void deleteHeldItem() {
        NEIClientUtils.deleteSlotStack(-999);
    }

    public static void dropHeldItem() {
        NEIClientUtils.mc()._j._a(((GuiContainer)NEIClientUtils.mc()._B).inventorySlots.windowId, -999, 0, 0, NEIClientUtils.mc()._t);
    }

    public static void deleteSlotStack(int n) {
        NEIClientUtils.setSlotContents(n, null, true);
    }

    public static void decreaseSlotStack(int n) {
        ItemStack itemStack;
        ItemStack itemStack2 = itemStack = n == -999 ? NEIClientUtils.getHeldItem() : NEIClientUtils.mc()._t.openContainer.getSlot(n).getStack();
        if (itemStack == null) {
            return;
        }
        if (itemStack._b == 1) {
            NEIClientUtils.deleteSlotStack(n);
        } else {
            itemStack = itemStack._l();
            --itemStack._b;
            NEIClientUtils.setSlotContents(n, itemStack, true);
        }
    }

    public static void deleteEverything() {
        NEICPH.sendDeleteAllItems();
    }

    public static void deleteItemsOfType(ItemStack itemStack) {
        Container container = NEIClientUtils.getGuiContainer().inventorySlots;
        for (int i = 0; i < container.inventorySlots.size(); ++i) {
            ItemStack itemStack2;
            Slot slot = container.getSlot(i);
            if (slot == null || (itemStack2 = slot.getStack()) == null || itemStack2._d != itemStack._d || itemStack2._j() != itemStack._j()) continue;
            NEIClientUtils.setSlotContents(i, null, true);
            slot.putStack(null);
        }
    }

    public static ItemStack getHeldItem() {
        return NEIClientUtils.mc()._t.inventory._g();
    }

    public static void setSlotContents(int n, ItemStack itemStack, boolean bl) {
        NEICPH.sendSetSlot(n, itemStack, bl);
        if (n == -999) {
            NEIClientUtils.mc()._t.inventory._d(itemStack);
        }
    }

    public static void cheatItem(ItemStack itemStack, int n, int n2) {
        if (!NEIClientConfig.canPerformAction("item") || itemStack._p() && !NEIClientConfig.canPerformAction("itemnbt")) {
            return;
        }
        if (n2 == -1 && n == 0 && NEIClientUtils.shiftKey()) {
            for (IInfiniteItemHandler iInfiniteItemHandler : ItemInfo.infiniteHandlers) {
                ItemStack itemStack2;
                if (!iInfiniteItemHandler.canHandleItem(itemStack) || (itemStack2 = iInfiniteItemHandler.getInfiniteItem(itemStack)) == null) continue;
                NEIClientUtils.giveStack(itemStack2, itemStack2._b, true);
                return;
            }
            NEIClientUtils.cheatItem(itemStack, n, 0);
        } else if (n == 1) {
            NEIClientUtils.giveStack(itemStack, 1);
        } else if (n2 == 1 && itemStack._b < itemStack._d()) {
            NEIClientUtils.giveStack(itemStack, itemStack._d() - itemStack._b);
        } else {
            int n3 = NEIClientConfig.getItemQuantity();
            if (n3 == 0) {
                n3 = itemStack._d();
            }
            NEIClientUtils.giveStack(itemStack, n3);
        }
    }

    public static void giveStack(ItemStack itemStack) {
        NEIClientUtils.giveStack(itemStack, itemStack._b);
    }

    public static void giveStack(ItemStack itemStack, int n) {
        NEIClientUtils.giveStack(itemStack, n, false);
    }

    public static void giveStack(ItemStack itemStack, int n, boolean bl) {
        ItemStack itemStack2 = NEIClientUtils.copyStack(itemStack, n);
        if (NEIClientConfig.hasSMPCounterPart()) {
            ItemStack itemStack3 = NEIClientUtils.copyStack(itemStack2, 1);
            if (!bl && !NEIClientUtils.canItemFitInInventory(NEIClientUtils.mc()._t, itemStack2) && NEIClientUtils.mc()._B instanceof GuiContainer) {
                int n2;
                int n3;
                GuiContainer guiContainer = NEIClientUtils.getGuiContainer();
                int n4 = itemStack3._d();
                for (n2 = 0; n2 < itemStack2._b; n2 += n3) {
                    INEIGuiHandler iNEIGuiHandler;
                    n3 = Math.min(itemStack2._b - n2, n4);
                    int n5 = -1;
                    Object object = GuiInfo.guiHandlers.iterator();
                    while (object.hasNext() && (n5 = (iNEIGuiHandler = (INEIGuiHandler)object.next()).getItemSpawnSlot(guiContainer, itemStack3)) < 0) {
                    }
                    if (n5 == -1) break;
                    object = guiContainer.inventorySlots.getSlot(n5);
                    int n6 = ((Slot)object).getHasStack() ? ((Slot)object).getStack()._b : 0;
                    n3 = Math.min(n3, ((Slot)object).getSlotStackLimit() - n6);
                    ItemStack itemStack4 = NEIClientUtils.copyStack(itemStack3, n3 + n6);
                    ((Slot)object).putStack(itemStack4);
                    NEIClientUtils.setSlotContents(n5, itemStack4, true);
                }
                NEICPH.sendSpawnItem(NEIClientUtils.copyStack(itemStack3, n2), bl, false);
            } else {
                NEICPH.sendSpawnItem(itemStack2, bl, true);
            }
        } else {
            int n7;
            for (int i = 0; i < itemStack2._b; i += n7) {
                n7 = Math.min(itemStack2._b - i, itemStack2._d());
                NEIClientUtils.sendCommand(NEIClientConfig.getStringSetting("command.item"), NEIClientUtils.mc()._t.username, itemStack2._d, n7, itemStack2._j());
            }
        }
    }

    public static void updateUnlimitedItems() {
        ItemStack itemStack = NEIClientUtils.getHeldItem();
        if (itemStack != null && itemStack._b > 64) {
            itemStack._b = 1;
        }
        ItemStack[] itemStackArray = NEIClientUtils.mc()._t.inventory._a;
        for (int i = 0; i < itemStackArray.length; ++i) {
            ItemStack itemStack2 = itemStackArray[i];
            if (itemStack2 == null) continue;
            if (itemStack2._b < 0 || itemStack2._b > 64) {
                itemStack2._b = 111;
            }
            if (itemStack2._j() <= -32000 || itemStack2._j() >= -30000) continue;
            itemStack2._b(-32000);
        }
    }

    public static boolean isValidItem(ItemStack itemStack) {
        for (ItemStack itemStack2 : NEIClientUtils.getValidItems(itemStack._d)) {
            if (!NEIClientUtils.areStacksIdentical(itemStack2, itemStack)) continue;
            return true;
        }
        return false;
    }

    public static boolean canItemFitInInventory(EntityPlayer entityPlayer, ItemStack itemStack) {
        return InventoryUtils.getInsertibleQuantity(new InventoryRange(entityPlayer.inventory, 0, 36), itemStack) > 0;
    }

    public static boolean shiftKey() {
        return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
    }

    public static boolean controlKey() {
        return Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157);
    }

    public static int getGamemode() {
        if (NEIClientConfig.invCreativeMode()) {
            return 2;
        }
        if (NEIClientUtils.mc()._j._i()) {
            return 1;
        }
        if (NEIClientUtils.mc()._j._k._c()) {
            return 3;
        }
        return 0;
    }

    public static boolean isValidGamemode(String string) {
        return string.equals("survival") || NEIClientConfig.canPerformAction(string) && Arrays.asList(NEIClientConfig.getStringArrSetting("inventory.gamemodes")).contains(string);
    }

    public static int getNextGamemode() {
        int n;
        int n2 = n = NEIClientUtils.getGamemode();
        while ((n2 = (n2 + 1) % NEIActions.gameModes.length) != n && !NEIClientUtils.isValidGamemode(NEIActions.gameModes[n2])) {
        }
        return n2;
    }

    public static void cycleGamemode() {
        int n;
        int n2 = NEIClientUtils.getGamemode();
        if (n2 == (n = NEIClientUtils.getNextGamemode())) {
            return;
        }
        if (NEIClientConfig.hasSMPCounterPart()) {
            NEICPH.sendGamemode(n);
        } else {
            NEIClientUtils.sendCommand(NEIClientConfig.getStringSetting("command.creative"), new Object[]{NEIClientUtils.getGameType(n), NEIClientUtils.mc()._t.username});
        }
    }

    public static long getTime() {
        return NEIClientUtils.mc()._r.getWorldInfo()._g();
    }

    public static void setTime(long l) {
        NEIClientUtils.mc()._r.getWorldInfo()._b(l);
    }

    public static void setHourForward(int n) {
        long l = NEIClientUtils.getTime() / 24000L * 24000L;
        long l2 = l + 24000L + (long)(n * 1000);
        if (NEIClientConfig.hasSMPCounterPart()) {
            NEICPH.sendSetTime(n);
        } else {
            NEIClientUtils.sendCommand(NEIClientConfig.getStringSetting("command.time"), l2);
        }
    }

    public static void sendCommand(String string, Object ... objectArray) {
        if (string.length() == 0) {
            return;
        }
        NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        numberFormat.setGroupingUsed(false);
        MessageFormat messageFormat = new MessageFormat(string);
        for (int i = 0; i < objectArray.length; ++i) {
            if (!(objectArray[i] instanceof Integer) && !(objectArray[i] instanceof Long)) continue;
            messageFormat.setFormatByArgumentIndex(i, numberFormat);
        }
        NEIClientUtils.mc()._t.sendChatMessage(messageFormat.format(objectArray));
    }

    public static boolean isRaining() {
        return NEIClientUtils.mc()._r.getWorldInfo()._p();
    }

    public static void toggleRaining() {
        if (NEIClientConfig.hasSMPCounterPart()) {
            NEICPH.sendToggleRain();
        } else {
            NEIClientUtils.sendCommand(NEIClientConfig.getStringSetting("command.rain"), NEIClientUtils.isRaining() ? 0 : 1);
        }
    }

    public static void healPlayer() {
        if (NEIClientConfig.hasSMPCounterPart()) {
            NEICPH.sendHeal();
        } else {
            NEIClientUtils.sendCommand(NEIClientConfig.getStringSetting("command.heal"), NEIClientUtils.mc()._t.username);
        }
    }

    public static void toggleMagnetMode() {
        if (NEIClientConfig.hasSMPCounterPart()) {
            NEICPH.sendToggleMagnetMode();
        }
    }

    public static ArrayList<int[]> concatIntegersToRanges(List<Integer> list2) {
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        if (list2.size() == 0) {
            return arrayList;
        }
        Collections.sort(list2);
        int n = -1;
        int n2 = 0;
        for (Integer n3 : list2) {
            if (n == -1) {
                n = n2 = n3.intValue();
                continue;
            }
            if (n2 + 1 != n3) {
                arrayList.add(new int[]{n, n2});
                n = n2 = n3.intValue();
                continue;
            }
            n2 = n3;
        }
        arrayList.add(new int[]{n, n2});
        return arrayList;
    }

    public static ArrayList<int[]> addIntegersToRanges(List<int[]> list2, List<Integer> list3) {
        for (int[] nArray : list2) {
            for (int i = nArray[0]; i <= nArray[1]; ++i) {
                list3.add(i);
            }
        }
        return NEIClientUtils.concatIntegersToRanges(list3);
    }

    public static boolean safeKeyDown(int n) {
        try {
            return Keyboard.isKeyDown(n);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return false;
        }
    }

    public static void setItemQuantity(int n) {
        NEIClientConfig.world.nbt._a("quantity", n);
        NEIClientConfig.world.saveNBT();
        LayoutManager.quantity.setText(Integer.toString(n));
    }

    public static GuiContainer getGuiContainer() {
        if (NEIClientUtils.mc()._B instanceof GuiContainer) {
            return (GuiContainer)NEIClientUtils.mc()._B;
        }
        return null;
    }

    public static void overlayScreen(GuiScreen guiScreen) {
        if (NEIClientUtils.mc()._B instanceof GuiContainer) {
            FastTransferManager.clickSlot(NEIClientUtils.getGuiContainer(), -999);
        }
        NEIClientUtils.mc()._B = null;
        NEIClientUtils.mc()._a(guiScreen);
    }

    public static boolean altKey() {
        return Keyboard.isKeyDown(56) || Keyboard.isKeyDown(184);
    }

    public static List<ItemStack> getValidItems(int n) {
        List<ItemStack> list2 = ItemList.itemMap[n];
        if (list2 == null) {
            return Collections.emptyList();
        }
        return list2;
    }
}

