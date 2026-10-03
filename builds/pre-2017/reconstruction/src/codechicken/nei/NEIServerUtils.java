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
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class NEIServerUtils {
    public static boolean isRaining(World world) {
        return world.getWorldInfo()._p();
    }

    public static void toggleRaining(World world, boolean bl) {
        boolean bl2;
        boolean bl3 = bl2 = !world.isRaining();
        if (!bl2) {
            ((WorldServer)world).provider._D();
        } else {
            world.func_72913_w();
        }
        if (bl) {
            ServerUtils.sendChatToAll("Rain turned " + (bl2 ? "on" : "off"));
        }
    }

    public static void healPlayer(EntityPlayer entityPlayer) {
        entityPlayer.heal(20.0f);
        entityPlayer.getFoodStats()._a(20, 1.0f);
        entityPlayer.extinguish();
    }

    public static long getTime(World world) {
        return world.getWorldInfo()._g();
    }

    public static void setTime(long l, World world) {
        world.getWorldInfo()._b(l);
    }

    public static void setSlotContents(EntityPlayer entityPlayer, int n, ItemStack itemStack, boolean bl) {
        if (n == -999) {
            entityPlayer.inventory._d(itemStack);
        } else if (bl) {
            entityPlayer.openContainer.putStackInSlot(n, itemStack);
        } else {
            entityPlayer.inventory.setInventorySlotContents(n, itemStack);
        }
    }

    public static ItemStack getSlotContents(EntityPlayer entityPlayer, int n, boolean bl) {
        if (n == -999) {
            return entityPlayer.inventory._g();
        }
        if (bl) {
            return entityPlayer.openContainer.getSlot(n).getStack();
        }
        return entityPlayer.inventory.getStackInSlot(n);
    }

    public static void deleteAllItems(EntityPlayerMP entityPlayerMP) {
        for (Slot slot : entityPlayerMP.openContainer.inventorySlots) {
            slot.putStack(null);
        }
        entityPlayerMP.func_71110_a(entityPlayerMP.openContainer, entityPlayerMP.openContainer.getInventory());
    }

    public static void setHourForward(World world, int n, boolean bl) {
        long l = NEIServerUtils.getTime(world) / 24000L * 24000L;
        long l2 = l + 24000L + (long)(n * 1000);
        NEIServerUtils.setTime(l2, world);
        if (bl) {
            ServerUtils.sendChatToAll("Day " + NEIServerUtils.getTime(world) / 24000L + ". " + n + ":00");
        }
    }

    public static void advanceDisabledTimes(World world) {
        int n;
        int n2 = CommonUtils.getDimension(world);
        int n3 = n = (int)(NEIServerUtils.getTime(world) % 24000L) / 1000;
        while (NEIServerConfig.isActionDisabled(n2, NEIActions.timeZones[n3 / 6])) {
            n3 = (n3 / 6 + 1) % 4 * 6;
        }
        if (n3 != n) {
            NEIServerUtils.setHourForward(world, n3, false);
        }
    }

    public static boolean canItemFitInInventory(EntityPlayer entityPlayer, ItemStack itemStack) {
        int n;
        for (n = 0; n < entityPlayer.inventory.getSizeInventory() - 4; ++n) {
            if (entityPlayer.inventory.getStackInSlot(n) != null) continue;
            return true;
        }
        if (!itemStack._h()) {
            if (itemStack._d() == 1) {
                return false;
            }
            for (n = 0; n < entityPlayer.inventory.getSizeInventory(); ++n) {
                ItemStack itemStack2 = entityPlayer.inventory.getStackInSlot(n);
                if (itemStack2 == null || itemStack2._d != itemStack._d || !itemStack2._e() || itemStack2._b >= itemStack2._d() || itemStack2._b >= entityPlayer.inventory.getInventoryStackLimit() || itemStack2._g() && itemStack2._j() != itemStack._j()) continue;
                return true;
            }
        }
        return false;
    }

    public static int getSlotForStack(Container container, int n, int n2, ItemStack itemStack) {
        Slot slot;
        int n3;
        for (n3 = n; n3 < n2; ++n3) {
            int n4;
            slot = container.getSlot(n3);
            if (!slot.getHasStack() || !itemStack._e() || (n4 = slot.getStack()._b) >= slot.getSlotStackLimit() || n4 >= itemStack._d() || !NEIServerUtils.areStacksSameType(slot.getStack(), itemStack)) continue;
            return n3;
        }
        for (n3 = n; n3 < n2; ++n3) {
            slot = container.getSlot(n3);
            if (slot.getHasStack()) continue;
            return n3;
        }
        return -1;
    }

    public static int getSlotForStack(IInventory iInventory, int n, int n2, ItemStack itemStack) {
        int n3;
        for (n3 = n; n3 < n2; ++n3) {
            int n4;
            ItemStack itemStack2 = iInventory.getStackInSlot(n3);
            if (itemStack2 == null || !itemStack._e() || (n4 = itemStack2._b) >= iInventory.getInventoryStackLimit() || n4 >= itemStack._d() || !NEIServerUtils.areStacksSameType(itemStack2, itemStack)) continue;
            return n3;
        }
        for (n3 = n; n3 < n2; ++n3) {
            if (iInventory.getStackInSlot(n3) != null) continue;
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
            if (!NEIServerConfig.canPlayerPerformAction(entityPlayerMP.username, string2)) continue;
            ServerUtils.sendChatTo(entityPlayerMP, string);
        }
    }

    public static boolean areStacksSameType(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack == null || itemStack2 == null) {
            return itemStack == itemStack2;
        }
        return InventoryUtils.canStack(itemStack, itemStack2);
    }

    public static boolean areStacksSameTypeCrafting(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack == null || itemStack2 == null) {
            return false;
        }
        return itemStack._d == itemStack2._d && (itemStack._j() == itemStack2._j() || itemStack._j() == Short.MAX_VALUE || itemStack2._j() == Short.MAX_VALUE || itemStack._a().isDamageable());
    }

    public static int compareStacks(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack == itemStack2) {
            return 0;
        }
        if (itemStack == null || itemStack2 == null) {
            return itemStack == null ? -1 : 1;
        }
        if (itemStack._d != itemStack2._d) {
            return itemStack._d - itemStack2._d;
        }
        if (itemStack._b != itemStack2._b) {
            return itemStack._b - itemStack2._b;
        }
        return itemStack._j() - itemStack2._j();
    }

    public static boolean areStacksIdentical(ItemStack itemStack, ItemStack itemStack2) {
        return NEIServerUtils.compareStacks(itemStack, itemStack2) == 0;
    }

    public static void givePlayerItem(EntityPlayerMP entityPlayerMP, ItemStack itemStack, boolean bl, LinkedList<String> linkedList, boolean bl2) {
        if (itemStack._a() == null) {
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
            n = itemStack._b;
        } else if (bl) {
            entityPlayerMP.inventory._c(itemStack);
        } else {
            int n2;
            int n3 = itemStack._d();
            for (n = 0; n < itemStack._b; n += n2) {
                n2 = Math.min(itemStack._b - n, n3);
                int n4 = NEIServerUtils.getSlotForStack(entityPlayerMP.inventory, 0, 36, itemStack);
                if (n4 == -1) break;
                ItemStack itemStack2 = entityPlayerMP.inventory.getStackInSlot(n4);
                int n5 = itemStack2 != null ? itemStack2._b : 0;
                n2 = Math.min(n2, entityPlayerMP.inventory.getInventoryStackLimit() - n5);
                entityPlayerMP.inventory.setInventorySlotContents(n4, NEIServerUtils.copyStack(itemStack, n2 + n5));
            }
        }
        if (bl) {
            NEIServerUtils.sendNotice("Giving " + entityPlayerMP.username + " infinite \u00a7f" + (String)string, "notify-item");
        } else {
            NEIServerUtils.sendNotice("Giving " + entityPlayerMP.username + " " + n + " of \u00a7f" + (String)string, "notify-item");
        }
        entityPlayerMP.openContainer.detectAndSendChanges();
    }

    public static ItemStack copyStack(ItemStack itemStack, int n) {
        if (itemStack == null) {
            return null;
        }
        itemStack._b += n;
        return itemStack._a(n);
    }

    public static ItemStack copyStack(ItemStack itemStack) {
        if (itemStack == null) {
            return null;
        }
        return NEIServerUtils.copyStack(itemStack, itemStack._b);
    }

    public static void toggleMagnetMode(EntityPlayerMP entityPlayerMP) {
        PlayerSave playerSave;
        playerSave.enableAction("magnet", !(playerSave = NEIServerConfig.forPlayer(entityPlayerMP.username)).isActionEnabled("magnet"));
    }

    public static int getCreativeMode(EntityPlayerMP entityPlayerMP) {
        if (NEIServerConfig.forPlayer(entityPlayerMP.username).isActionEnabled("creative+")) {
            return 2;
        }
        if (entityPlayerMP.theItemInWorldManager._b()) {
            return 1;
        }
        if (entityPlayerMP.theItemInWorldManager._a()._c()) {
            return 3;
        }
        return 0;
    }

    public static EnumGameType getGameType(int n) {
        switch (n) {
            case 0: {
                return EnumGameType._b;
            }
            case 1: 
            case 2: {
                return EnumGameType._c;
            }
            case 3: {
                return EnumGameType._d;
            }
        }
        return null;
    }

    public static void setGamemode(EntityPlayerMP entityPlayerMP, int n) {
        if (n < 0 || n >= NEIActions.gameModes.length || NEIActions.nameActionMap.containsKey(NEIActions.gameModes[n]) && !NEIServerConfig.canPlayerPerformAction(entityPlayerMP.username, NEIActions.gameModes[n])) {
            return;
        }
        entityPlayerMP.theItemInWorldManager._a(NEIServerUtils.getGameType(n));
        NEIServerConfig.forPlayer(entityPlayerMP.username).enableAction("creative+", n == 2);
        new PacketCustom("NEI", 14).writeByte(n).sendToPlayer(entityPlayerMP);
        entityPlayerMP.sendChatToPlayer(ChatMessageComponent._e("nei.chat.gamemode." + n));
    }

    public static void cycleCreativeInv(EntityPlayerMP entityPlayerMP, int n) {
        int n2;
        int n3;
        int n4;
        InventoryPlayer inventoryPlayer = entityPlayerMP.inventory;
        ItemStack[][] itemStackArray = new ItemStack[10][9];
        PlayerSave playerSave = NEIServerConfig.forPlayer(entityPlayerMP.username);
        for (n4 = 0; n4 < 9; ++n4) {
            itemStackArray[9][n4] = inventoryPlayer._a[n4];
        }
        for (n4 = 0; n4 < 3; ++n4) {
            for (n3 = 0; n3 < 9; ++n3) {
                itemStackArray[n4 + 6][n3] = inventoryPlayer._a[(n4 + 1) * 9 + n3];
            }
        }
        for (n4 = 0; n4 < 6; ++n4) {
            for (n3 = 0; n3 < 9; ++n3) {
                itemStackArray[n4][n3] = playerSave.creativeInv[n4 * 9 + n3];
            }
        }
        ItemStack[][] itemStackArrayArray = new ItemStack[10][];
        for (n3 = 0; n3 < 10; ++n3) {
            itemStackArrayArray[(n3 + n + 10) % 10] = itemStackArray[n3];
        }
        for (n3 = 0; n3 < 9; ++n3) {
            inventoryPlayer._a[n3] = itemStackArrayArray[9][n3];
        }
        for (n3 = 0; n3 < 3; ++n3) {
            for (n2 = 0; n2 < 9; ++n2) {
                inventoryPlayer._a[(n3 + 1) * 9 + n2] = itemStackArrayArray[n3 + 6][n2];
            }
        }
        for (n3 = 0; n3 < 6; ++n3) {
            for (n2 = 0; n2 < 9; ++n2) {
                playerSave.creativeInv[n3 * 9 + n2] = itemStackArrayArray[n3][n2];
            }
        }
        playerSave.setDirty();
    }

    public static List<int[]> getEnchantments(ItemStack itemStack) {
        NBTTagList nBTTagList;
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        if (itemStack != null && (nBTTagList = itemStack._r()) != null) {
            for (int i = 0; i < nBTTagList._d(); ++i) {
                NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
                arrayList.add(new int[]{nBTTagCompound._e("id"), nBTTagCompound._e("lvl")});
            }
        }
        return arrayList;
    }

    public static boolean stackHasEnchantment(ItemStack itemStack, int n) {
        List<int[]> list = NEIServerUtils.getEnchantments(itemStack);
        for (int[] nArray : list) {
            if (nArray[0] != n) continue;
            return true;
        }
        return false;
    }

    public static int getEnchantmentLevel(ItemStack itemStack, int n) {
        List<int[]> list = NEIServerUtils.getEnchantments(itemStack);
        for (int[] nArray : list) {
            if (nArray[0] != n) continue;
            return nArray[1];
        }
        return -1;
    }

    public static boolean doesEnchantmentConflict(List<int[]> list, Enchantment enchantment) {
        for (int[] nArray : list) {
            if (enchantment._a(Enchantment._a[nArray[0]])) continue;
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

    public static ItemStack[] extractRecipeItems(Object object) {
        if (object instanceof ItemStack) {
            return new ItemStack[]{(ItemStack)object};
        }
        if (object instanceof ItemStack[]) {
            return (ItemStack[])object;
        }
        if (object instanceof List) {
            return ((List)object).toArray(new ItemStack[0]);
        }
        throw new ClassCastException("not an ItemStack, ItemStack[] or List<ItemStack?");
    }
}

