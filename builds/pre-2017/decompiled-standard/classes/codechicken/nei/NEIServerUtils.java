/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.CommonUtils;
import codechicken.core.ServerUtils;
import codechicken.lib.inventory.InventoryUtils;
import codechicken.lib.packet.PacketCustom;
import codechicken.nei.ClientHandler;
import codechicken.nei.NEIActions;
import codechicken.nei.NEIServerConfig;
import codechicken.nei.PlayerSave;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.eidj;
import net.minecraft.util.zwat;

public class NEIServerUtils {
    public static boolean isRaining(ozlu ozlu2) {
        return ozlu2.func_72912_H()._p();
    }

    public static void toggleRaining(ozlu ozlu2, boolean bl) {
        boolean bl2;
        boolean bl3 = bl2 = !ozlu2.func_72896_J();
        if (!bl2) {
            ((yfgy)ozlu2).field_73011_w._D();
        } else {
            ozlu2.func_72913_w();
        }
        if (bl) {
            ServerUtils.sendChatToAll("Rain turned " + (bl2 ? "on" : "off"));
        }
    }

    public static void healPlayer(EntityPlayer entityPlayer) {
        entityPlayer.func_70691_i(20.0f);
        entityPlayer.func_71024_bL()._a(20, 1.0f);
        entityPlayer.func_70066_B();
    }

    public static long getTime(ozlu ozlu2) {
        return ozlu2.func_72912_H()._g();
    }

    public static void setTime(long l, ozlu ozlu2) {
        ozlu2.func_72912_H()._b(l);
    }

    public static void setSlotContents(EntityPlayer entityPlayer, int n, cvzo cvzo2, boolean bl) {
        if (n == -999) {
            entityPlayer.field_71071_by._d(cvzo2);
        } else if (bl) {
            entityPlayer.field_71070_bA.func_75141_a(n, cvzo2);
        } else {
            entityPlayer.field_71071_by.func_70299_a(n, cvzo2);
        }
    }

    public static cvzo getSlotContents(EntityPlayer entityPlayer, int n, boolean bl) {
        if (n == -999) {
            return entityPlayer.field_71071_by._g();
        }
        if (bl) {
            return entityPlayer.field_71070_bA.func_75139_a(n).func_75211_c();
        }
        return entityPlayer.field_71071_by.func_70301_a(n);
    }

    public static void deleteAllItems(EntityPlayerMP entityPlayerMP) {
        for (yeso yeso2 : entityPlayerMP.field_71070_bA.field_75151_b) {
            yeso2.func_75215_d(null);
        }
        entityPlayerMP.func_71110_a(entityPlayerMP.field_71070_bA, entityPlayerMP.field_71070_bA.func_75138_a());
    }

    public static void setHourForward(ozlu ozlu2, int n, boolean bl) {
        long l = NEIServerUtils.getTime(ozlu2) / 24000L * 24000L;
        long l2 = l + 24000L + (long)(n * 1000);
        NEIServerUtils.setTime(l2, ozlu2);
        if (bl) {
            ServerUtils.sendChatToAll("Day " + NEIServerUtils.getTime(ozlu2) / 24000L + ". " + n + ":00");
        }
    }

    public static void advanceDisabledTimes(ozlu ozlu2) {
        int n;
        int n2 = CommonUtils.getDimension(ozlu2);
        int n3 = n = (int)(NEIServerUtils.getTime(ozlu2) % 24000L) / 1000;
        while (NEIServerConfig.isActionDisabled(n2, NEIActions.timeZones[n3 / 6])) {
            n3 = (n3 / 6 + 1) % 4 * 6;
        }
        if (n3 != n) {
            NEIServerUtils.setHourForward(ozlu2, n3, false);
        }
    }

    public static boolean canItemFitInInventory(EntityPlayer entityPlayer, cvzo cvzo2) {
        int n;
        for (n = 0; n < entityPlayer.field_71071_by.func_70302_i_() - 4; ++n) {
            if (entityPlayer.field_71071_by.func_70301_a(n) != null) continue;
            return true;
        }
        if (!cvzo2._h()) {
            if (cvzo2._d() == 1) {
                return false;
            }
            for (n = 0; n < entityPlayer.field_71071_by.func_70302_i_(); ++n) {
                cvzo cvzo3 = entityPlayer.field_71071_by.func_70301_a(n);
                if (cvzo3 == null || cvzo3._d != cvzo2._d || !cvzo3._e() || cvzo3._b >= cvzo3._d() || cvzo3._b >= entityPlayer.field_71071_by.func_70297_j_() || cvzo3._g() && cvzo3._j() != cvzo2._j()) continue;
                return true;
            }
        }
        return false;
    }

    public static int getSlotForStack(jjgc jjgc2, int n, int n2, cvzo cvzo2) {
        yeso yeso2;
        int n3;
        for (n3 = n; n3 < n2; ++n3) {
            int n4;
            yeso2 = jjgc2.func_75139_a(n3);
            if (!yeso2.func_75216_d() || !cvzo2._e() || (n4 = yeso2.func_75211_c()._b) >= yeso2.func_75219_a() || n4 >= cvzo2._d() || !NEIServerUtils.areStacksSameType(yeso2.func_75211_c(), cvzo2)) continue;
            return n3;
        }
        for (n3 = n; n3 < n2; ++n3) {
            yeso2 = jjgc2.func_75139_a(n3);
            if (yeso2.func_75216_d()) continue;
            return n3;
        }
        return -1;
    }

    public static int getSlotForStack(mssh mssh2, int n, int n2, cvzo cvzo2) {
        int n3;
        for (n3 = n; n3 < n2; ++n3) {
            int n4;
            cvzo cvzo3 = mssh2.func_70301_a(n3);
            if (cvzo3 == null || !cvzo2._e() || (n4 = cvzo3._b) >= mssh2.func_70297_j_() || n4 >= cvzo2._d() || !NEIServerUtils.areStacksSameType(cvzo3, cvzo2)) continue;
            return n3;
        }
        for (n3 = n; n3 < n2; ++n3) {
            if (mssh2.func_70301_a(n3) != null) continue;
            return n3;
        }
        return -1;
    }

    public static void sendNotice(String string, String string2) {
        NEIServerUtils.sendNotice(string, string2, -1);
    }

    public static void sendNotice(String string, String string2, int n) {
        if (NEIServerConfig.canPlayerPerformAction("CONSOLE", string2)) {
            Logger.getLogger("Minecraft").info(string.replaceAll("\u00a7.", ""));
        }
        for (EntityPlayerMP entityPlayerMP : ServerUtils.mc().__ag()._e) {
            if (!NEIServerConfig.canPlayerPerformAction(entityPlayerMP.field_71092_bJ, string2)) continue;
            ServerUtils.sendChatTo(entityPlayerMP, string);
        }
    }

    public static boolean areStacksSameType(cvzo cvzo2, cvzo cvzo3) {
        if (cvzo2 == null || cvzo3 == null) {
            return cvzo2 == cvzo3;
        }
        return InventoryUtils.canStack(cvzo2, cvzo3);
    }

    public static boolean areStacksSameTypeCrafting(cvzo cvzo2, cvzo cvzo3) {
        if (cvzo2 == null || cvzo3 == null) {
            return false;
        }
        return cvzo2._d == cvzo3._d && (cvzo2._j() == cvzo3._j() || cvzo2._j() == Short.MAX_VALUE || cvzo3._j() == Short.MAX_VALUE || cvzo2._a().func_77645_m());
    }

    public static int compareStacks(cvzo cvzo2, cvzo cvzo3) {
        if (cvzo2 == cvzo3) {
            return 0;
        }
        if (cvzo2 == null || cvzo3 == null) {
            return cvzo2 == null ? -1 : 1;
        }
        if (cvzo2._d != cvzo3._d) {
            return cvzo2._d - cvzo3._d;
        }
        if (cvzo2._b != cvzo3._b) {
            return cvzo2._b - cvzo3._b;
        }
        return cvzo2._j() - cvzo3._j();
    }

    public static boolean areStacksIdentical(cvzo cvzo2, cvzo cvzo3) {
        return NEIServerUtils.compareStacks(cvzo2, cvzo3) == 0;
    }

    public static void givePlayerItem(EntityPlayerMP entityPlayerMP, cvzo cvzo2, boolean bl, LinkedList<String> linkedList, boolean bl2) {
        if (cvzo2._a() == null) {
            ServerUtils.sendChatTo(entityPlayerMP, "\u00a7fNo such item.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl3 = true;
        for (String string : linkedList) {
            if (!bl3) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(string.trim());
            bl3 = false;
        }
        String string = stringBuilder.toString();
        int n = 0;
        if (!bl2) {
            n = cvzo2._b;
        } else if (bl) {
            entityPlayerMP.field_71071_by._c(cvzo2);
        } else {
            int n2;
            int n3 = cvzo2._d();
            for (n = 0; n < cvzo2._b; n += n2) {
                n2 = Math.min(cvzo2._b - n, n3);
                int n4 = NEIServerUtils.getSlotForStack(entityPlayerMP.field_71071_by, 0, 36, cvzo2);
                if (n4 == -1) break;
                cvzo cvzo3 = entityPlayerMP.field_71071_by.func_70301_a(n4);
                int n5 = cvzo3 != null ? cvzo3._b : 0;
                n2 = Math.min(n2, entityPlayerMP.field_71071_by.func_70297_j_() - n5);
                entityPlayerMP.field_71071_by.func_70299_a(n4, NEIServerUtils.copyStack(cvzo2, n2 + n5));
            }
        }
        if (bl) {
            NEIServerUtils.sendNotice("Giving " + entityPlayerMP.field_71092_bJ + " infinite \u00a7f" + (String)string, "notify-item");
        } else {
            NEIServerUtils.sendNotice("Giving " + entityPlayerMP.field_71092_bJ + " " + n + " of \u00a7f" + (String)string, "notify-item");
        }
        entityPlayerMP.field_71070_bA.func_75142_b();
    }

    public static cvzo copyStack(cvzo cvzo2, int n) {
        if (cvzo2 == null) {
            return null;
        }
        cvzo2._b += n;
        return cvzo2._a(n);
    }

    public static cvzo copyStack(cvzo cvzo2) {
        if (cvzo2 == null) {
            return null;
        }
        return NEIServerUtils.copyStack(cvzo2, cvzo2._b);
    }

    public static void toggleMagnetMode(EntityPlayerMP entityPlayerMP) {
        PlayerSave playerSave;
        playerSave.enableAction("magnet", !(playerSave = NEIServerConfig.forPlayer(entityPlayerMP.field_71092_bJ)).isActionEnabled("magnet"));
    }

    public static int getCreativeMode(EntityPlayerMP entityPlayerMP) {
        if (NEIServerConfig.forPlayer(entityPlayerMP.field_71092_bJ).isActionEnabled("creative+")) {
            return 2;
        }
        if (entityPlayerMP.field_71134_c._b()) {
            return 1;
        }
        if (entityPlayerMP.field_71134_c._a()._c()) {
            return 3;
        }
        return 0;
    }

    public static xtby getGameType(int n) {
        switch (n) {
            case 0: {
                return xtby._b;
            }
            case 1: 
            case 2: {
                return xtby._c;
            }
            case 3: {
                return xtby._d;
            }
        }
        return null;
    }

    public static void setGamemode(EntityPlayerMP entityPlayerMP, int n) {
        if (n < 0 || n >= NEIActions.gameModes.length || NEIActions.nameActionMap.containsKey(NEIActions.gameModes[n]) && !NEIServerConfig.canPlayerPerformAction(entityPlayerMP.field_71092_bJ, NEIActions.gameModes[n])) {
            return;
        }
        entityPlayerMP.field_71134_c._a(NEIServerUtils.getGameType(n));
        NEIServerConfig.forPlayer(entityPlayerMP.field_71092_bJ).enableAction("creative+", n == 2);
        new PacketCustom("NEI", 14).writeByte(n).sendToPlayer(entityPlayerMP);
        entityPlayerMP.func_70006_a(zwat._e("nei.chat.gamemode." + n));
    }

    public static void cycleCreativeInv(EntityPlayerMP entityPlayerMP, int n) {
        int n2;
        int n3;
        int n4;
        eidj eidj2 = entityPlayerMP.field_71071_by;
        cvzo[][] cvzoArray = new cvzo[10][9];
        PlayerSave playerSave = NEIServerConfig.forPlayer(entityPlayerMP.field_71092_bJ);
        for (n4 = 0; n4 < 9; ++n4) {
            cvzoArray[9][n4] = eidj2._a[n4];
        }
        for (n4 = 0; n4 < 3; ++n4) {
            for (n3 = 0; n3 < 9; ++n3) {
                cvzoArray[n4 + 6][n3] = eidj2._a[(n4 + 1) * 9 + n3];
            }
        }
        for (n4 = 0; n4 < 6; ++n4) {
            for (n3 = 0; n3 < 9; ++n3) {
                cvzoArray[n4][n3] = playerSave.creativeInv[n4 * 9 + n3];
            }
        }
        cvzo[][] cvzoArrayArray = new cvzo[10][];
        for (n3 = 0; n3 < 10; ++n3) {
            cvzoArrayArray[(n3 + n + 10) % 10] = cvzoArray[n3];
        }
        for (n3 = 0; n3 < 9; ++n3) {
            eidj2._a[n3] = cvzoArrayArray[9][n3];
        }
        for (n3 = 0; n3 < 3; ++n3) {
            for (n2 = 0; n2 < 9; ++n2) {
                eidj2._a[(n3 + 1) * 9 + n2] = cvzoArrayArray[n3 + 6][n2];
            }
        }
        for (n3 = 0; n3 < 6; ++n3) {
            for (n2 = 0; n2 < 9; ++n2) {
                playerSave.creativeInv[n3 * 9 + n2] = cvzoArrayArray[n3][n2];
            }
        }
        playerSave.setDirty();
    }

    public static List<int[]> getEnchantments(cvzo cvzo2) {
        bsyv bsyv2;
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        if (cvzo2 != null && (bsyv2 = cvzo2._r()) != null) {
            for (int i = 0; i < bsyv2._d(); ++i) {
                qoac qoac2 = (qoac)bsyv2._b(i);
                arrayList.add(new int[]{qoac2._e("id"), qoac2._e("lvl")});
            }
        }
        return arrayList;
    }

    public static boolean stackHasEnchantment(cvzo cvzo2, int n) {
        List<int[]> list = NEIServerUtils.getEnchantments(cvzo2);
        for (int[] nArray : list) {
            if (nArray[0] != n) continue;
            return true;
        }
        return false;
    }

    public static int getEnchantmentLevel(cvzo cvzo2, int n) {
        List<int[]> list = NEIServerUtils.getEnchantments(cvzo2);
        for (int[] nArray : list) {
            if (nArray[0] != n) continue;
            return nArray[1];
        }
        return -1;
    }

    public static boolean doesEnchantmentConflict(List<int[]> list, zhqo zhqo2) {
        for (int[] nArray : list) {
            if (zhqo2._a(zhqo._a[nArray[0]])) continue;
            return true;
        }
        return false;
    }

    public static RuntimeException throwCME(String string) {
        if (CommonUtils.isClient()) {
            return ClientHandler.throwCME(string);
        }
        throw new RuntimeException(string);
    }

    public static cvzo[] extractRecipeItems(Object object) {
        if (object instanceof cvzo) {
            return new cvzo[]{(cvzo)object};
        }
        if (object instanceof cvzo[]) {
            return (cvzo[])object;
        }
        if (object instanceof List) {
            return ((List)object).toArray(new cvzo[0]);
        }
        throw new ClassCastException("not an ItemStack, ItemStack[] or List<ItemStack?");
    }
}

