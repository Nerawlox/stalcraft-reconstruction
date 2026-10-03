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
    public void writeEntityToNBT(qoac qoac2) {
        bsyv bsyv2 = new bsyv();
        for (int i = 0; i < 63; ++i) {
            bsyv2._a(new hdfw("price", this.sellPrices[i]));
        }
        bsyv bsyv3 = new bsyv();
        for (int i = 0; i < 210; ++i) {
            bsyv3._a(new hdfw("price", this.buyPrices[i]));
        }
        qoac2._a("sell_prices", bsyv2);
        qoac2._a("buy_prices", bsyv3);
        qoac2._a("TraderSold", this.inventorySold.getToNBT());
        qoac2._a("TraderBought", this.inventoryBought.getToNBT());
        qoac2._a("checkNbt", this.checkNbtOnBuy);
    }

    @Override
    public void readEntityFromNBT(qoac qoac2) {
        this.checkNbtOnBuy = qoac2._o("checkNbt");
        bsyv bsyv2 = qoac2._n("sell_prices");
        for (int i = 0; i < 63 && i < bsyv2._d(); ++i) {
            this.sellPrices[i] = ((hdfw)bsyv2._b((int)i))._c;
        }
        bsyv bsyv3 = qoac2._n("buy_prices");
        for (int i = 0; i < 210 && i < bsyv3._d(); ++i) {
            this.buyPrices[i] = ((hdfw)bsyv3._b((int)i))._c;
        }
        this.inventorySold.setFromNBT(qoac2._m("TraderSold"));
        this.inventoryBought.setFromNBT(qoac2._m("TraderBought"));
        HashMap<Integer, cvzo> hashMap = NBTTags.getItemStackList(qoac2._m("TraderCurrency")._n("NpcMiscInv"));
        for (Map.Entry<Integer, cvzo> entry : hashMap.entrySet()) {
            if (entry.getValue() == null) continue;
            int n = zwat._a(entry.getValue()._d);
            int n2 = n * entry.getValue()._b;
            if (n2 > 0) {
                this.sellPrices[entry.getKey().intValue()] = n2;
                continue;
            }
            cvzo cvzo2 = this.inventorySold.items.get(entry.getKey());
            if (cvzo2 == null) continue;
            n = zwat._a(cvzo2._d);
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

    public void onUpdateByPlayer(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer, qoac qoac2) {
        int n = 63;
        int n2 = 210;
        NpcMiscInventory npcMiscInventory = new NpcMiscInventory(n);
        npcMiscInventory.setFromNBT(qoac2._m("TraderSold"));
        NpcMiscInventory npcMiscInventory2 = new NpcMiscInventory(n2);
        npcMiscInventory2.setFromNBT(qoac2._m("TraderBought"));
        int[] nArray = new int[n];
        bsyv bsyv2 = qoac2._n("sell_prices");
        for (int i = 0; i < n && i < bsyv2._d(); ++i) {
            nArray[i] = ((hdfw)bsyv2._b((int)i))._c;
        }
        int[] nArray2 = new int[n2];
        bsyv bsyv3 = qoac2._n("buy_prices");
        for (int i = 0; i < n2 && i < bsyv3._d(); ++i) {
            nArray2[i] = ((hdfw)bsyv3._b((int)i))._c;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (nArray[i] != this.sellPrices[i] || !cvzo._b(npcMiscInventory.func_70301_a(i), this.inventorySold.func_70301_a(i))) {
                arrayList2.add(i);
            }
            if (nArray2[i] == this.buyPrices[i] && cvzo._b(npcMiscInventory2.func_70301_a(i), this.inventoryBought.func_70301_a(i))) continue;
            arrayList.add(i);
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder().append(entityPlayer.field_71092_bJ).append(" updated trader npc at (").append(entityNPCInterface.field_70165_t).append(", ").append(entityNPCInterface.field_70163_u).append(", ").append(entityNPCInterface.field_70161_v).append("). Changed:\n");
            if (arrayList2.size() > 0) {
                stringBuilder.append("Sold items:\n").append(this.genDiff(arrayList2, this.inventorySold, npcMiscInventory, this.sellPrices, nArray));
            }
            if (arrayList.size() > 0) {
                stringBuilder.append("Bought items:\n").append(this.genDiff(arrayList, this.inventoryBought, npcMiscInventory2, this.buyPrices, nArray2));
            }
            CustomNpcs.npcsLog.info(stringBuilder.toString());
        }
    }

    private String genDiff(List<Integer> list, mssh mssh2, mssh mssh3, int[] nArray, int[] nArray2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int n : list) {
            cvzo cvzo2 = mssh2.func_70301_a(n);
            String string = cvzo2 != null ? cvzo2._d + "x" + cvzo2._b : "empty";
            cvzo cvzo3 = mssh3.func_70301_a(n);
            String string2 = cvzo3 != null ? cvzo3._d + "x" + cvzo3._b : "empty";
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

    public int getBuyPrice(cvzo cvzo2) {
        for (Map.Entry<Integer, cvzo> entry : this.inventoryBought.items.entrySet()) {
            boolean bl;
            if (entry.getValue() == null || !(bl = this.checkNbtOnBuy ? ncwh._a(cvzo2, entry.getValue(), true) : cvzo2._d == entry.getValue()._d)) continue;
            int n = cvzo2._b * this.buyPrices[entry.getKey()];
            if (cvzo2._a() instanceof amxi) {
                return ((amxi)((Object)cvzo2._a()))._a(cvzo2, n);
            }
            if (cvzo2._h()) {
                float f = (float)(cvzo2._k() - cvzo2._j()) / (float)cvzo2._k();
                n = (int)((float)n * f);
            }
            return n;
        }
        return 0;
    }

    public void sort(boolean bl, boolean bl2) {
        this.sortInventory(this.inventorySold, this.sellPrices, 63, bl, bl2);
        this.sortInventory(this.inventoryBought, this.buyPrices, 210, bl, bl2);
        if (!this.npc.field_70170_p.field_72995_K) {
            this.npc.sync();
            NpcSynchronizer.instance.onEntityUpdate(this.npc);
        }
    }

    private void sortInventory(NpcMiscInventory npcMiscInventory, int[] nArray, int n, boolean bl, boolean bl2) {
        int n2;
        ArrayList<Pair<cvzo, Integer>> arrayList = new ArrayList<Pair<cvzo, Integer>>();
        for (n2 = 0; n2 < n; ++n2) {
            cvzo cvzo2 = npcMiscInventory.items.get(n2);
            if (cvzo2 != null) {
                arrayList.add(Pair.of(cvzo2, nArray[n2]));
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
                npcMiscInventory.items.put(n2, (cvzo)pair3.getLeft());
            }
            nArray[n2] = (Integer)pair3.getRight();
            ++n2;
        }
    }

    private static int traderSorting(Pair<cvzo, Integer> pair, Pair<cvzo, Integer> pair2, boolean bl) {
        String string;
        cvzo cvzo2 = pair2.getLeft();
        cvzo cvzo3 = pair.getLeft();
        rpaa rpaa2 = GloomyCore.instance.itemsLoader._a.get(cvzo2._d);
        rpaa rpaa3 = GloomyCore.instance.itemsLoader._a.get(cvzo3._d);
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

