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
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Keyboard;

public class NEIClientUtils
extends NEIServerUtils {
    public static xpzm mc() {
        return xpzm._E();
    }

    public static String translate(String string, Object ... objectArray) {
        return ClientHandler.lang.translate(string, objectArray);
    }

    public static void addChatMessage(String string) {
        if (NEIClientUtils.mc()._J != null) {
            NEIClientUtils.mc()._J.func_73827_b()._a(string);
        }
    }

    public static void deleteHeldItem() {
        NEIClientUtils.deleteSlotStack(-999);
    }

    public static void dropHeldItem() {
        NEIClientUtils.mc()._j._a(((zybc)NEIClientUtils.mc()._B).field_74193_d.field_75152_c, -999, 0, 0, NEIClientUtils.mc()._t);
    }

    public static void deleteSlotStack(int n) {
        NEIClientUtils.setSlotContents(n, null, true);
    }

    public static void decreaseSlotStack(int n) {
        cvzo cvzo2;
        cvzo cvzo3 = cvzo2 = n == -999 ? NEIClientUtils.getHeldItem() : NEIClientUtils.mc()._t.field_71070_bA.func_75139_a(n).func_75211_c();
        if (cvzo2 == null) {
            return;
        }
        if (cvzo2._b == 1) {
            NEIClientUtils.deleteSlotStack(n);
        } else {
            cvzo2 = cvzo2._l();
            --cvzo2._b;
            NEIClientUtils.setSlotContents(n, cvzo2, true);
        }
    }

    public static void deleteEverything() {
        NEICPH.sendDeleteAllItems();
    }

    public static void deleteItemsOfType(cvzo cvzo2) {
        jjgc jjgc2 = NEIClientUtils.getGuiContainer().field_74193_d;
        for (int i = 0; i < jjgc2.field_75151_b.size(); ++i) {
            cvzo cvzo3;
            yeso yeso2 = jjgc2.func_75139_a(i);
            if (yeso2 == null || (cvzo3 = yeso2.func_75211_c()) == null || cvzo3._d != cvzo2._d || cvzo3._j() != cvzo2._j()) continue;
            NEIClientUtils.setSlotContents(i, null, true);
            yeso2.func_75215_d(null);
        }
    }

    public static cvzo getHeldItem() {
        return NEIClientUtils.mc()._t.field_71071_by._g();
    }

    public static void setSlotContents(int n, cvzo cvzo2, boolean bl) {
        NEICPH.sendSetSlot(n, cvzo2, bl);
        if (n == -999) {
            NEIClientUtils.mc()._t.field_71071_by._d(cvzo2);
        }
    }

    public static void cheatItem(cvzo cvzo2, int n, int n2) {
        if (!NEIClientConfig.canPerformAction("item") || cvzo2._p() && !NEIClientConfig.canPerformAction("itemnbt")) {
            return;
        }
        if (n2 == -1 && n == 0 && NEIClientUtils.shiftKey()) {
            for (IInfiniteItemHandler iInfiniteItemHandler : ItemInfo.infiniteHandlers) {
                cvzo cvzo3;
                if (!iInfiniteItemHandler.canHandleItem(cvzo2) || (cvzo3 = iInfiniteItemHandler.getInfiniteItem(cvzo2)) == null) continue;
                NEIClientUtils.giveStack(cvzo3, cvzo3._b, true);
                return;
            }
            NEIClientUtils.cheatItem(cvzo2, n, 0);
        } else if (n == 1) {
            NEIClientUtils.giveStack(cvzo2, 1);
        } else if (n2 == 1 && cvzo2._b < cvzo2._d()) {
            NEIClientUtils.giveStack(cvzo2, cvzo2._d() - cvzo2._b);
        } else {
            int n3 = NEIClientConfig.getItemQuantity();
            if (n3 == 0) {
                n3 = cvzo2._d();
            }
            NEIClientUtils.giveStack(cvzo2, n3);
        }
    }

    public static void giveStack(cvzo cvzo2) {
        NEIClientUtils.giveStack(cvzo2, cvzo2._b);
    }

    public static void giveStack(cvzo cvzo2, int n) {
        NEIClientUtils.giveStack(cvzo2, n, false);
    }

    public static void giveStack(cvzo cvzo2, int n, boolean bl) {
        cvzo cvzo3 = NEIClientUtils.copyStack(cvzo2, n);
        if (NEIClientConfig.hasSMPCounterPart()) {
            cvzo cvzo4 = NEIClientUtils.copyStack(cvzo3, 1);
            if (!bl && !NEIClientUtils.canItemFitInInventory(NEIClientUtils.mc()._t, cvzo3) && NEIClientUtils.mc()._B instanceof zybc) {
                int n2;
                int n3;
                zybc zybc2 = NEIClientUtils.getGuiContainer();
                int n4 = cvzo4._d();
                for (n2 = 0; n2 < cvzo3._b; n2 += n3) {
                    INEIGuiHandler iNEIGuiHandler;
                    n3 = Math.min(cvzo3._b - n2, n4);
                    int n5 = -1;
                    Object object = GuiInfo.guiHandlers.iterator();
                    while (object.hasNext() && (n5 = (iNEIGuiHandler = (INEIGuiHandler)object.next()).getItemSpawnSlot(zybc2, cvzo4)) < 0) {
                    }
                    if (n5 == -1) break;
                    object = zybc2.field_74193_d.func_75139_a(n5);
                    int n6 = ((yeso)object).func_75216_d() ? ((yeso)object).func_75211_c()._b : 0;
                    n3 = Math.min(n3, ((yeso)object).func_75219_a() - n6);
                    cvzo cvzo5 = NEIClientUtils.copyStack(cvzo4, n3 + n6);
                    ((yeso)object).func_75215_d(cvzo5);
                    NEIClientUtils.setSlotContents(n5, cvzo5, true);
                }
                NEICPH.sendSpawnItem(NEIClientUtils.copyStack(cvzo4, n2), bl, false);
            } else {
                NEICPH.sendSpawnItem(cvzo3, bl, true);
            }
        } else {
            int n7;
            for (int i = 0; i < cvzo3._b; i += n7) {
                n7 = Math.min(cvzo3._b - i, cvzo3._d());
                NEIClientUtils.sendCommand(NEIClientConfig.getStringSetting("command.item"), NEIClientUtils.mc()._t.field_71092_bJ, cvzo3._d, n7, cvzo3._j());
            }
        }
    }

    public static void updateUnlimitedItems() {
        cvzo cvzo2 = NEIClientUtils.getHeldItem();
        if (cvzo2 != null && cvzo2._b > 64) {
            cvzo2._b = 1;
        }
        cvzo[] cvzoArray = NEIClientUtils.mc()._t.field_71071_by._a;
        for (int i = 0; i < cvzoArray.length; ++i) {
            cvzo cvzo3 = cvzoArray[i];
            if (cvzo3 == null) continue;
            if (cvzo3._b < 0 || cvzo3._b > 64) {
                cvzo3._b = 111;
            }
            if (cvzo3._j() <= -32000 || cvzo3._j() >= -30000) continue;
            cvzo3._b(-32000);
        }
    }

    public static boolean isValidItem(cvzo cvzo2) {
        for (cvzo cvzo3 : NEIClientUtils.getValidItems(cvzo2._d)) {
            if (!NEIClientUtils.areStacksIdentical(cvzo3, cvzo2)) continue;
            return true;
        }
        return false;
    }

    public static boolean canItemFitInInventory(EntityPlayer entityPlayer, cvzo cvzo2) {
        return InventoryUtils.getInsertibleQuantity(new InventoryRange(entityPlayer.field_71071_by, 0, 36), cvzo2) > 0;
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
            NEIClientUtils.sendCommand(NEIClientConfig.getStringSetting("command.creative"), new Object[]{NEIClientUtils.getGameType(n), NEIClientUtils.mc()._t.field_71092_bJ});
        }
    }

    public static long getTime() {
        return NEIClientUtils.mc()._r.func_72912_H()._g();
    }

    public static void setTime(long l) {
        NEIClientUtils.mc()._r.func_72912_H()._b(l);
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
        NEIClientUtils.mc()._t.func_71165_d(messageFormat.format(objectArray));
    }

    public static boolean isRaining() {
        return NEIClientUtils.mc()._r.func_72912_H()._p();
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
            NEIClientUtils.sendCommand(NEIClientConfig.getStringSetting("command.heal"), NEIClientUtils.mc()._t.field_71092_bJ);
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

    public static zybc getGuiContainer() {
        if (NEIClientUtils.mc()._B instanceof zybc) {
            return (zybc)NEIClientUtils.mc()._B;
        }
        return null;
    }

    public static void overlayScreen(gqjz gqjz2) {
        if (NEIClientUtils.mc()._B instanceof zybc) {
            FastTransferManager.clickSlot(NEIClientUtils.getGuiContainer(), -999);
        }
        NEIClientUtils.mc()._B = null;
        NEIClientUtils.mc()._a(gqjz2);
    }

    public static boolean altKey() {
        return Keyboard.isKeyDown(56) || Keyboard.isKeyDown(184);
    }

    public static List<cvzo> getValidItems(int n) {
        List<cvzo> list2 = ItemList.itemMap[n];
        if (list2 == null) {
            return Collections.emptyList();
        }
        return list2;
    }
}

