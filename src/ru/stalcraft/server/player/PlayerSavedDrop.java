/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cl
 *  ud
 */
package ru.stalcraft.server.player;

import java.util.ArrayList;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.player.PlayerServerInfo;

public class PlayerSavedDrop {
    public static void initDrop(uf p2) {
        by tag = new by();
        ud inventory = p2.bn;
        cg stacksList = new cg();
        tag.a("Slots", stacksList);
        for (int i2 = 0; i2 < inventory.j_(); ++i2) {
            ye stack = inventory.a(i2);
            if (stack == null || !PlayerSavedDrop.isNoDrop(stack) && !PlayerSavedDrop.checkNodropBag(p2, i2)) continue;
            by stackTag = new by();
            stackTag.a("Slot", (byte)i2);
            stack.b(stackTag);
            stacksList.a(stackTag);
            inventory.a(i2, null);
        }
        PlayerServerInfo par5 = (PlayerServerInfo)PlayerUtils.getInfo(p2);
        cg par7 = new cg();
        tag.a("StalkerInventory", par7);
        for (int i3 = 0; i3 < par5.stInv.j_(); ++i3) {
            ye stack = par5.stInv.a(i3);
            if (stack == null || !PlayerSavedDrop.isNoDrop(stack)) continue;
            by stackTag = new by();
            stackTag.a("Slot", (byte)i3);
            stack.b(stackTag);
            par7.a(stackTag);
            par5.stInv.a(i3, null);
        }
        by entityData = p2.getEntityData();
        if (!entityData.b("PlayerPersisted")) {
            entityData.a("PlayerPersisted", (cl)new by());
        }
        entityData.l("PlayerPersisted").a("drops", tag);
    }

    private static boolean checkNodropBag(uf player, int slot) {
        ye bag2 = null;
        if (slot >= 9 && slot <= 12) {
            bag2 = player.o(2);
        }
        if (slot >= 13 && slot <= 16) {
            bag2 = player.o(1);
        }
        if (slot >= 17 && slot <= 22) {
            bag2 = player.bn.a[34];
        }
        if (slot >= 23 && slot <= 32) {
            bag2 = player.bn.a[35];
        }
        return bag2 != null && PlayerSavedDrop.isNoDrop(bag2);
    }

    public static void retrieveDrops(uf p2) {
        by tag = p2.getEntityData().l("PlayerPersisted").l("drops");
        if (tag.d()) {
            return;
        }
        ArrayList<ye> notAdded = new ArrayList<ye>();
        cg stacksList = tag.m("Slots");
        for (int j2 = 0; j2 < stacksList.c(); ++j2) {
            by stackTag = (by)stacksList.b(j2);
            int slot = stackTag.c("Slot") & 0xFF;
            ye stack = ye.a(stackTag);
            if (p2.bn.a(slot) == null) {
                p2.bn.a(slot, stack);
                continue;
            }
            notAdded.add(stack);
        }
        PlayerServerInfo par5 = (PlayerServerInfo)PlayerUtils.getInfo(p2);
        cg par6 = tag.m("StalkerInventory");
        for (int i2 = 0; i2 < par6.c(); ++i2) {
            by stackTag = (by)par6.b(i2);
            int slot = stackTag.c("Slot") & 0xFF;
            ye stack = ye.a(stackTag);
            if (par5.stInv.a(slot) == null) {
                par5.stInv.a(slot, stack);
                continue;
            }
            PlayerUtils.getTag(stack).a("stalker_slot", slot);
            notAdded.add(stack);
        }
        for (ye stack : notAdded) {
            PlayerSavedDrop.addItem(p2, stack);
        }
        p2.getEntityData().l("PlayerPersisted").o("drops");
    }

    public static void addItem(uf player, ye stack) {
        if (!player.bn.a(stack)) {
            ss entityitem = new ss(player.q, player.u, player.v, player.w, stack);
            entityitem.b = 5;
            player.q.d(entityitem);
        }
    }

    private static void dropItem(uf p2, ye stack) {
        p2.a(stack, true);
    }

    public static boolean isNoDrop(ye stack) {
        return stack.e != null && stack.e.e("no_drop") != 0;
    }

    public static boolean isPersonal(ye stack) {
        return stack.e != null && stack.e.e("personal") != 0;
    }
}

