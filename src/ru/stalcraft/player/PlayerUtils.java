/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 */
package ru.stalcraft.player;

import cpw.mods.fml.relauncher.Side;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import ru.stalcraft.Logger;
import ru.stalcraft.inventory.StalkerInventory;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerStalkerCapabilities;

public class PlayerUtils {
    private static final int[] noteIds = new int[]{26978, 26979, 26977, 26976, 26974};
    private static final int[] noteValues = new int[]{1000, 500, 100, 50, 10};
    private static Class classPlayerInfoServer;
    private static Class classPlayerInfoClient;

    public static void createInfo(uf par1) {
        try {
            Class par2 = null;
            par2 = par1.q.I ? classPlayerInfoClient : classPlayerInfoServer;
            if (par2 == null) {
                throw new RuntimeException("[STALKER][" + (par1.q.I ? Side.CLIENT : Side.SERVER) + "] Not is loaded player info!!!!!");
            }
            Constructor par3 = par2.getConstructor(uf.class);
            try {
                Object t2 = par3.newInstance(par1);
            }
            catch (InstantiationException e2) {
                e2.printStackTrace();
            }
            catch (IllegalAccessException e3) {
                e3.printStackTrace();
            }
            catch (IllegalArgumentException e4) {
                e4.printStackTrace();
            }
            catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
        }
        catch (NoSuchMethodException e6) {
            e6.printStackTrace();
        }
        catch (SecurityException e7) {
            e7.printStackTrace();
        }
    }

    public static void registerPlayerInfo(Class par1, Side par2) {
        if (par2.isClient()) {
            classPlayerInfoClient = par1;
        } else {
            classPlayerInfoServer = par1;
        }
    }

    public static PlayerInfo getInfo(uf player) {
        try {
            return ((PlayerStalkerCapabilities)player.bG).getInfo();
        }
        catch (Exception var2) {
            return null;
        }
    }

    public static boolean hasItem(uf p2, int id) {
        return p2.bn.e(id) || PlayerUtils.getInfo((uf)p2).stInv.hasItem(id);
    }

    public static int countItems(uf p2, int itemID) {
        int count = 0;
        for (ye i$ : p2.bn.a) {
            if (i$ == null || i$.d != itemID) continue;
            count += i$.b;
        }
        for (ye i$ : p2.bn.b) {
            if (i$ == null || i$.d != itemID) continue;
            count += i$.b;
        }
        StalkerInventory var8 = PlayerUtils.getInfo((uf)p2).stInv;
        for (ye stack : var8.mainInventory) {
            if (stack == null || stack.d != itemID) continue;
            count += stack.b;
        }
        return count;
    }

    public static int consumeItems(uf p2, int itemID, int maxCount, boolean consumeNotMax) {
        if (!consumeNotMax && PlayerUtils.countItems(p2, itemID) < maxCount) {
            return 0;
        }
        int consumed = 0;
        int consumed1 = consumed + PlayerUtils.consumeInStackArray(p2.bn.a, maxCount - consumed, itemID);
        consumed1 += PlayerUtils.consumeInStackArray(p2.bn.b, maxCount - consumed1, itemID);
        consumed1 += PlayerUtils.consumeInStackArray(PlayerUtils.getInfo((uf)p2).stInv.mainInventory, maxCount - consumed1, itemID);
        if (!p2.q.I) {
            jv playerMP = (jv)p2;
            playerMP.a(p2.bo);
        }
        return consumed1;
    }

    public static void addItem(uf player, ye stack) {
        if ((player.aN() <= 0.0f || player.bn.a(stack) || PlayerUtils.getInfo((uf)player).stInv.addItemStackToInventory(stack)) && !player.q.I) {
            ss entityitem = new ss(player.q, player.u, player.v, player.w, stack);
            entityitem.b = 5;
            player.q.d(entityitem);
        }
    }

    public static void addMoney(uf player, int sum) {
        for (int i2 = 0; i2 < noteIds.length; ++i2) {
            if (yc.g[noteIds[i2]] == null) continue;
            int notesCount = sum / noteValues[i2];
            sum -= notesCount * noteValues[i2];
            while (notesCount > 0) {
                int stackSize = notesCount % 64;
                if (stackSize == 0) {
                    stackSize = 64;
                }
                PlayerUtils.addItem(player, new ye(noteIds[i2], stackSize, 0));
                notesCount -= stackSize;
            }
        }
        if (sum > 0) {
            Logger.console("[WARNING] " + sum + " $ remaining for player " + player.bu);
        }
    }

    private static int consumeInStackArray(ye[] stacks, int maxCount, int itemID) {
        int consumed = 0;
        int slot = -1;
        while (consumed < maxCount && ++slot < stacks.length) {
            ye stack = stacks[slot];
            if (stack == null || stack.d != itemID) continue;
            if (stack.b <= maxCount - consumed) {
                consumed += stack.b;
                stacks[slot] = null;
                continue;
            }
            stack.b -= maxCount - consumed;
            consumed = maxCount;
        }
        return consumed;
    }

    public static by getTag(ye stack) {
        if (!stack.p()) {
            stack.d(new by());
        }
        return stack.q();
    }
}

