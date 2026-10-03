/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.roles;

import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.amxi;
import gloomyfolken.mods.money.zwat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NBTTags;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.NpcMiscInventory;
import noppes.npcs.NpcSynchronizer;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.roles.RoleInterface;
import org.apache.commons.lang3.tuple.Pair;

public class RoleTrader
extends RoleInterface {
    private static final List<String> PRIORITIES = Arrays.asList("weapon", "weapon_skin", "weapon_upgrade", "forend", "handgrip", "sight_mount", "sight", "side_att", "barrel_att", "butt", "magazine", "launcher", "melee_weapon", "armor", "armor_skin", "armor_upgrade", "backpack", "tradepack", "bullet", "landmine", "grenade", "medicine", "block", "command_item", "custom", "custom_renderer", "artefakt", "blueprint");
    public int[] sellPrices;
    public int[] buyPrices;
    public NpcMiscInventory inventorySold = new NpcMiscInventory(63);
    public NpcMiscInventory inventoryBought = new NpcMiscInventory(210);
    public boolean checkNbtOnBuy = false;

    public RoleTrader(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        this.sellPrices = new int[63];
        this.buyPrices = new int[210];
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < 63; ++i) {
            nBTTagList._a(new hdfw("price", this.sellPrices[i]));
        }
        NBTTagList nBTTagList2 = new NBTTagList();
        for (int i = 0; i < 210; ++i) {
            nBTTagList2._a(new hdfw("price", this.buyPrices[i]));
        }
        nBTTagCompound._a("sell_prices", nBTTagList);
        nBTTagCompound._a("buy_prices", nBTTagList2);
        nBTTagCompound._a("TraderSold", this.inventorySold.getToNBT());
        nBTTagCompound._a("TraderBought", this.inventoryBought.getToNBT());
        nBTTagCompound._a("checkNbt", this.checkNbtOnBuy);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.checkNbtOnBuy = nBTTagCompound._o("checkNbt");
        NBTTagList nBTTagList = nBTTagCompound._n("sell_prices");
        for (int i = 0; i < 63 && i < nBTTagList._d(); ++i) {
            this.sellPrices[i] = ((hdfw)nBTTagList._b((int)i))._c;
        }
        NBTTagList nBTTagList2 = nBTTagCompound._n("buy_prices");
        for (int i = 0; i < 210 && i < nBTTagList2._d(); ++i) {
            this.buyPrices[i] = ((hdfw)nBTTagList2._b((int)i))._c;
        }
        this.inventorySold.setFromNBT(nBTTagCompound._m("TraderSold"));
        this.inventoryBought.setFromNBT(nBTTagCompound._m("TraderBought"));
        HashMap<Integer, ItemStack> hashMap = NBTTags.getItemStackList(nBTTagCompound._m("TraderCurrency")._n("NpcMiscInv"));
        for (Map.Entry<Integer, ItemStack> entry : hashMap.entrySet()) {
            if (entry.getValue() == null) continue;
            int n = zwat._a(entry.getValue()._d);
            int n2 = n * entry.getValue()._b;
            if (n2 > 0) {
                this.sellPrices[entry.getKey().intValue()] = n2;
                continue;
            }
            ItemStack itemStack = this.inventorySold.items.get(entry.getKey());
            if (itemStack == null) continue;
            n = zwat._a(itemStack._d);
            n2 = n * entry.getValue()._b;
            if (n2 > 0) {
                int n3 = -1;
                for (int i = 0; i < 210; ++i) {
                    if (this.inventoryBought.items.get(i) != null) continue;
                    n3 = i;
                    break;
                }
                if (n3 >= 0) {
                    this.inventoryBought.items.put(n3, entry.getValue());
                    this.buyPrices[n3] = n2;
                }
            }
            this.inventorySold.items.remove(entry.getKey());
        }
    }

    public void onUpdateByPlayer(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer, NBTTagCompound nBTTagCompound) {
        int n = 63;
        int n2 = 210;
        NpcMiscInventory npcMiscInventory = new NpcMiscInventory(n);
        npcMiscInventory.setFromNBT(nBTTagCompound._m("TraderSold"));
        NpcMiscInventory npcMiscInventory2 = new NpcMiscInventory(n2);
        npcMiscInventory2.setFromNBT(nBTTagCompound._m("TraderBought"));
        int[] nArray = new int[n];
        NBTTagList nBTTagList = nBTTagCompound._n("sell_prices");
        for (int i = 0; i < n && i < nBTTagList._d(); ++i) {
            nArray[i] = ((hdfw)nBTTagList._b((int)i))._c;
        }
        int[] nArray2 = new int[n2];
        NBTTagList nBTTagList2 = nBTTagCompound._n("buy_prices");
        for (int i = 0; i < n2 && i < nBTTagList2._d(); ++i) {
            nArray2[i] = ((hdfw)nBTTagList2._b((int)i))._c;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (nArray[i] != this.sellPrices[i] || !ItemStack._b(npcMiscInventory.getStackInSlot(i), this.inventorySold.getStackInSlot(i))) {
                arrayList2.add(i);
            }
            if (nArray2[i] == this.buyPrices[i] && ItemStack._b(npcMiscInventory2.getStackInSlot(i), this.inventoryBought.getStackInSlot(i))) continue;
            arrayList.add(i);
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder().append(entityPlayer.username).append(" updated trader npc at (").append(entityNPCInterface.posX).append(", ").append(entityNPCInterface.posY).append(", ").append(entityNPCInterface.posZ).append("). Changed:\n");
            if (arrayList2.size() > 0) {
                stringBuilder.append("Sold items:\n").append(this.genDiff(arrayList2, this.inventorySold, npcMiscInventory, this.sellPrices, nArray));
            }
            if (arrayList.size() > 0) {
                stringBuilder.append("Bought items:\n").append(this.genDiff(arrayList, this.inventoryBought, npcMiscInventory2, this.buyPrices, nArray2));
            }
            CustomNpcs.npcsLog.info(stringBuilder.toString());
        }
    }

    private String genDiff(List<Integer> list, IInventory iInventory, IInventory iInventory2, int[] nArray, int[] nArray2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int n : list) {
            ItemStack itemStack = iInventory.getStackInSlot(n);
            String string = itemStack != null ? itemStack._d + "x" + itemStack._b : "empty";
            ItemStack itemStack2 = iInventory2.getStackInSlot(n);
            String string2 = itemStack2 != null ? itemStack2._d + "x" + itemStack2._b : "empty";
            stringBuilder.append("Slot #").append(n % 21).append("/").append(n / 21 + 1).append(" from ").append("[").append(string).append(" for ").append(nArray[n]).append("] to [").append(string2).append(" for ").append(nArray2[n]).append("]\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        this.npc.performInteractReplica(entityPlayer);
        NoppesUtilServer.sendOpenGui(entityPlayer, EnumGuiType.PlayerTrader, this.npc);
        return false;
    }

    public int getBuyPrice(ItemStack itemStack) {
        for (Map.Entry<Integer, ItemStack> entry : this.inventoryBought.items.entrySet()) {
            boolean bl;
            if (entry.getValue() == null || !(bl = this.checkNbtOnBuy ? ncwh._a(itemStack, entry.getValue(), true) : itemStack._d == entry.getValue()._d)) continue;
            int n = itemStack._b * this.buyPrices[entry.getKey()];
            if (itemStack._a() instanceof amxi) {
                return ((amxi)((Object)itemStack._a()))._a(itemStack, n);
            }
            if (itemStack._h()) {
                float f = (float)(itemStack._k() - itemStack._j()) / (float)itemStack._k();
                n = (int)((float)n * f);
            }
            return n;
        }
        return 0;
    }

    public void sort(boolean bl, boolean bl2) {
        this.sortInventory(this.inventorySold, this.sellPrices, 63, bl, bl2);
        this.sortInventory(this.inventoryBought, this.buyPrices, 210, bl, bl2);
        if (!this.npc.worldObj.isRemote) {
            this.npc.sync();
            NpcSynchronizer.instance.onEntityUpdate(this.npc);
        }
    }

    private void sortInventory(NpcMiscInventory npcMiscInventory, int[] nArray, int n, boolean bl, boolean bl2) {
        int n2;
        ArrayList<Pair<ItemStack, Integer>> arrayList = new ArrayList<Pair<ItemStack, Integer>>();
        for (n2 = 0; n2 < n; ++n2) {
            ItemStack itemStack = npcMiscInventory.items.get(n2);
            if (itemStack != null) {
                arrayList.add(Pair.of(itemStack, nArray[n2]));
            }
            nArray[n2] = 0;
        }
        arrayList.sort((pair, pair2) -> RoleTrader.traderSorting(pair, pair2, bl));
        if (bl2) {
            npcMiscInventory.items.clear();
        }
        n2 = 0;
        for (Pair pair3 : arrayList) {
            if (bl2) {
                npcMiscInventory.items.put(n2, (ItemStack)pair3.getLeft());
            }
            nArray[n2] = (Integer)pair3.getRight();
            ++n2;
        }
    }

    private static int traderSorting(Pair<ItemStack, Integer> pair, Pair<ItemStack, Integer> pair2, boolean bl) {
        String string;
        ItemStack itemStack = pair2.getLeft();
        ItemStack itemStack2 = pair.getLeft();
        rpaa rpaa2 = GloomyCore.instance.itemsLoader._a.get(itemStack._d);
        rpaa rpaa3 = GloomyCore.instance.itemsLoader._a.get(itemStack2._d);
        String string2 = rpaa2 == null ? null : rpaa2._f;
        String string3 = string = rpaa3 == null ? null : rpaa3._f;
        if (string2 != null && string == null) {
            return 1;
        }
        if (string2 == null && string != null) {
            return -1;
        }
        if (string2 == null || string2.equals(string)) {
            return Integer.compare(pair2.getRight(), pair.getRight()) * (bl ? -1 : 1);
        }
        return -Integer.compare(PRIORITIES.indexOf(string2), PRIORITIES.indexOf(string));
    }
}

