/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import com.google.common.collect.HashMultimap;
import gloomyfolken.mods.core.misc.sajh;
import gloomyfolken.mods.money.zwat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NBTTags;
import noppes.npcs.RandomEquipSettings;

public class DataInventory
implements mssh {
    public HashMap<Integer, cvzo> items = new HashMap();
    public HashMap<Integer, Double> dropchance = new HashMap();
    public HashMap<Integer, cvzo> weapons = new HashMap();
    public HashMap<Integer, cvzo> armor = new HashMap();
    public Map<Integer, Integer> dropGroups = new HashMap<Integer, Integer>();
    public int minExp = 0;
    public int maxExp = 0;
    private EntityNPCInterface npc;
    public RandomEquipSettings randomEquipSettings = new RandomEquipSettings();
    private HashMap<Integer, cvzo> inventorySnapshot = new HashMap();

    public DataInventory(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
    }

    public qoac writeEntityToNBT(qoac qoac2) {
        qoac2._a("MinExp", this.minExp);
        qoac2._a("MaxExp", this.maxExp);
        qoac2._a("NpcInv", NBTTags.nbtItemStackList(this.items));
        qoac2._a("Armor", NBTTags.nbtItemStackList(this.armor));
        qoac2._a("Weapons", NBTTags.nbtItemStackList(this.weapons));
        qoac2._a("DropChance", NBTTags.nbtIntegerDoubleMap(this.dropchance));
        qoac2._a("DropGroups", NBTTags.nbtIntegerIntegerMap(this.dropGroups));
        this.randomEquipSettings.writeToNbt(qoac2);
        return qoac2;
    }

    public void readEntityFromNBT(qoac qoac2) {
        this.minExp = qoac2._f("MinExp");
        this.maxExp = qoac2._f("MaxExp");
        this.items = NBTTags.getItemStackList(qoac2._n("NpcInv"));
        this.setArmor(NBTTags.getItemStackList(qoac2._n("Armor")));
        this.setWeapons(NBTTags.getItemStackList(qoac2._n("Weapons")));
        this.dropchance = this.readChances(qoac2._n("DropChance"));
        this.dropGroups = NBTTags.getIntegerIntegerMap(qoac2._n("DropGroups"));
        this.npc.updateTasks();
        this.inventorySnapshot = new HashMap();
        this.items.forEach((n, cvzo2) -> this.inventorySnapshot.put((Integer)n, cvzo2 != null ? cvzo2._l() : null));
        this.randomEquipSettings.readFromNbt(qoac2);
    }

    public void onUpdateByPlayer(EntityPlayer entityPlayer, qoac qoac2) {
        HashMap<Integer, Double> hashMap = this.readChances(qoac2._n("DropChance"));
        HashMap<Integer, cvzo> hashMap2 = NBTTags.getItemStackList(qoac2._n("NpcInv"));
        StringBuilder stringBuilder = null;
        for (int i = 0; i < 24; ++i) {
            cvzo cvzo2;
            if (Objects.equals(hashMap.getOrDefault(i, 100.0), this.dropchance.getOrDefault(i, 100.0)) && cvzo._b(hashMap2.get(i), this.inventorySnapshot.get(i))) continue;
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder().append(entityPlayer.field_71092_bJ).append(" updated npc's drop inventory at (").append(this.npc.field_70165_t).append(", ").append(this.npc.field_70163_u).append(", ").append(this.npc.field_70161_v).append("). Changed:\n");
            }
            String string = (cvzo2 = this.inventorySnapshot.get(i)) != null ? cvzo2._d + "x" + cvzo2._b : "empty";
            cvzo cvzo3 = hashMap2.get(i);
            String string2 = cvzo3 != null ? cvzo3._d + "x" + cvzo3._b : "empty";
            stringBuilder.append("Slot #").append(i).append(" from ").append("[").append(string).append(" with chance ").append(this.dropchance.get(i)).append("] to [").append(string2).append(" with chance ").append(hashMap.get(i)).append("]\n");
        }
        if (stringBuilder != null) {
            CustomNpcs.npcsLog.info(stringBuilder.toString());
        }
    }

    private HashMap<Integer, Double> readChances(bsyv bsyv2) {
        HashMap<Integer, Double> hashMap = new HashMap<Integer, Double>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            int n = qoac2._f("Slot");
            if (qoac2._c("Integer")) {
                hashMap.put(n, Double.valueOf(qoac2._f("Integer")));
                continue;
            }
            hashMap.put(n, qoac2._i("Double"));
        }
        return hashMap;
    }

    public HashMap getWeapons() {
        return this.weapons;
    }

    public void setWeapons(HashMap<Integer, cvzo> hashMap) {
        this.weapons = hashMap;
    }

    public HashMap getArmor() {
        if (this.npc.randomEquipState.applied) {
            HashMap<Integer, cvzo> hashMap = new HashMap<Integer, cvzo>(this.armor);
            hashMap.put(1, this.npc.randomEquipState.armor);
            return hashMap;
        }
        return this.armor;
    }

    public void setArmor(HashMap<Integer, cvzo> hashMap) {
        this.armor = hashMap;
    }

    public cvzo getWeapon() {
        return this.npc.randomEquipState.applied ? this.npc.randomEquipState.weapon : (cvzo)this.getWeapons().get(0);
    }

    public cvzo getFirearm() {
        cvzo cvzo2 = this.getWeapon();
        if (cvzo2 != null && cvzo2._a() instanceof wolf) {
            return cvzo2;
        }
        return null;
    }

    public cvzo getOffHand() {
        return (cvzo)this.getWeapons().get(2);
    }

    public Map<Integer, cvzo> getDropStuff() {
        ArrayList arrayList;
        HashMap<Integer, cvzo> hashMap = new HashMap<Integer, cvzo>();
        HashMultimap<Integer, Object> hashMultimap = HashMultimap.create();
        int n = 0;
        for (int n2 : this.items.keySet()) {
            arrayList = this.items.get(n2);
            if (arrayList == null) continue;
            int n3 = this.dropGroups.getOrDefault(n2, 0);
            double d = this.dropchance.getOrDefault(n2, 100.0);
            boolean bl = this.npc.field_70170_p.field_73012_v.nextDouble() * 100.0 + d >= 100.0;
            if (!bl) continue;
            boolean bl2 = zwat._a((cvzo)((Object)arrayList)) > 0L;
            arrayList = sajh._e._a(((cvzo)((Object)arrayList))._l(), this.npc.func_70023_ak(), bl2);
            if (n3 == 0) {
                hashMap.put(n++, (cvzo)((Object)arrayList));
                continue;
            }
            hashMultimap.put(n3, arrayList);
        }
        for (int n2 : hashMultimap.keySet()) {
            arrayList = new ArrayList(hashMultimap.get(n2));
            if (arrayList.isEmpty()) continue;
            cvzo cvzo2 = (cvzo)arrayList.get(this.npc.field_70170_p.field_73012_v.nextInt(arrayList.size()));
            hashMap.put(n++, cvzo2);
        }
        return hashMap;
    }

    public void dropStuff(boolean bl) {
        if (!this.npc.field_70170_p.field_72995_K) {
            Collection<cvzo> collection = this.getDropStuff().values();
            for (cvzo cvzo2 : collection) {
                this.npc.dropPlayerItemWithRandomChoice(cvzo2._l(), true);
            }
            if (bl) {
                int n = this.minExp;
                if (this.maxExp - this.minExp > 0) {
                    n += this.npc.field_70170_p.field_73012_v.nextInt(this.maxExp - this.minExp);
                }
                while (n > 0) {
                    int n2 = EntityXPOrb.func_70527_a(n);
                    n -= n2;
                    this.npc.field_70170_p.func_72838_d(new EntityXPOrb(this.npc.field_70170_p, this.npc.field_70165_t, this.npc.field_70163_u, this.npc.field_70161_v, n2));
                }
            }
        }
    }

    public cvzo armorItemInSlot(int n) {
        if (this.npc.randomEquipState.applied && n == 1) {
            return this.npc.randomEquipState.armor;
        }
        return this.armor.get(n);
    }

    @Override
    public int func_70302_i_() {
        return 15;
    }

    @Override
    public cvzo func_70301_a(int n) {
        return n < 4 ? this.armorItemInSlot(n) : (n < 7 ? (cvzo)this.getWeapons().get(n - 4) : this.items.get(n - 7));
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        HashMap<Integer, cvzo> hashMap;
        int n3 = 0;
        if (n >= 7) {
            hashMap = this.items;
            n -= 7;
        } else if (n >= 4) {
            hashMap = this.getWeapons();
            n -= 4;
            n3 = 1;
        } else {
            hashMap = this.armor;
            n3 = 2;
        }
        cvzo cvzo2 = null;
        if (hashMap.get(n) != null) {
            if (hashMap.get((Object)Integer.valueOf((int)n))._b <= n2) {
                cvzo2 = hashMap.get(n);
                hashMap.put(n, null);
            } else {
                cvzo2 = hashMap.get(n)._a(n2);
                if (hashMap.get((Object)Integer.valueOf((int)n))._b == 0) {
                    hashMap.put(n, null);
                }
            }
        }
        if (n3 == 1) {
            this.setWeapons(hashMap);
        }
        if (n3 == 2) {
            this.setArmor(hashMap);
        }
        return cvzo2;
    }

    @Override
    public cvzo func_70304_b(int n) {
        HashMap<Integer, cvzo> hashMap;
        int n2 = 0;
        if (n >= 7) {
            hashMap = this.items;
            n -= 7;
        } else if (n >= 4) {
            hashMap = this.getWeapons();
            n -= 4;
            n2 = 1;
        } else {
            hashMap = this.armor;
            n2 = 2;
        }
        if (hashMap.get(n) != null) {
            cvzo cvzo2 = hashMap.get(n);
            hashMap.put(n, null);
            if (n2 == 1) {
                this.setWeapons(hashMap);
            }
            if (n2 == 2) {
                this.setArmor(hashMap);
            }
            return cvzo2;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        HashMap<Integer, cvzo> hashMap;
        int n2 = 0;
        if (n >= 7) {
            hashMap = this.items;
            n -= 7;
        } else if (n >= 4) {
            hashMap = this.getWeapons();
            n -= 4;
            n2 = 1;
        } else {
            hashMap = this.armor;
            n2 = 2;
        }
        hashMap.put(n, cvzo2);
        if (n2 == 1) {
            this.setWeapons(hashMap);
        }
        if (n2 == 2) {
            this.setArmor(hashMap);
        }
    }

    @Override
    public String func_70303_b() {
        return "NPC Inventory";
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public void func_70296_d() {
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void func_70295_k_() {
    }

    @Override
    public void func_70305_f() {
    }

    @Override
    public boolean func_94042_c() {
        return true;
    }

    @Override
    public boolean func_94041_b(int n, cvzo cvzo2) {
        return true;
    }
}

