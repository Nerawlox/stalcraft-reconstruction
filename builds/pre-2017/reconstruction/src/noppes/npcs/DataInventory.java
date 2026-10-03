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
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NBTTags;
import noppes.npcs.RandomEquipSettings;

public class DataInventory
implements IInventory {
    public HashMap<Integer, ItemStack> items = new HashMap();
    public HashMap<Integer, Double> dropchance = new HashMap();
    public HashMap<Integer, ItemStack> weapons = new HashMap();
    public HashMap<Integer, ItemStack> armor = new HashMap();
    public Map<Integer, Integer> dropGroups = new HashMap<Integer, Integer>();
    public int minExp = 0;
    public int maxExp = 0;
    private EntityNPCInterface npc;
    public RandomEquipSettings randomEquipSettings = new RandomEquipSettings();
    private HashMap<Integer, ItemStack> inventorySnapshot = new HashMap();

    public DataInventory(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
    }

    public NBTTagCompound writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("MinExp", this.minExp);
        nBTTagCompound._a("MaxExp", this.maxExp);
        nBTTagCompound._a("NpcInv", NBTTags.nbtItemStackList(this.items));
        nBTTagCompound._a("Armor", NBTTags.nbtItemStackList(this.armor));
        nBTTagCompound._a("Weapons", NBTTags.nbtItemStackList(this.weapons));
        nBTTagCompound._a("DropChance", NBTTags.nbtIntegerDoubleMap(this.dropchance));
        nBTTagCompound._a("DropGroups", NBTTags.nbtIntegerIntegerMap(this.dropGroups));
        this.randomEquipSettings.writeToNbt(nBTTagCompound);
        return nBTTagCompound;
    }

    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.minExp = nBTTagCompound._f("MinExp");
        this.maxExp = nBTTagCompound._f("MaxExp");
        this.items = NBTTags.getItemStackList(nBTTagCompound._n("NpcInv"));
        this.setArmor(NBTTags.getItemStackList(nBTTagCompound._n("Armor")));
        this.setWeapons(NBTTags.getItemStackList(nBTTagCompound._n("Weapons")));
        this.dropchance = this.readChances(nBTTagCompound._n("DropChance"));
        this.dropGroups = NBTTags.getIntegerIntegerMap(nBTTagCompound._n("DropGroups"));
        this.npc.updateTasks();
        this.inventorySnapshot = new HashMap();
        this.items.forEach((n, itemStack) -> this.inventorySnapshot.put((Integer)n, itemStack != null ? itemStack._l() : null));
        this.randomEquipSettings.readFromNbt(nBTTagCompound);
    }

    public void onUpdateByPlayer(EntityPlayer entityPlayer, NBTTagCompound nBTTagCompound) {
        HashMap<Integer, Double> hashMap = this.readChances(nBTTagCompound._n("DropChance"));
        HashMap<Integer, ItemStack> hashMap2 = NBTTags.getItemStackList(nBTTagCompound._n("NpcInv"));
        StringBuilder stringBuilder = null;
        for (int i = 0; i < 24; ++i) {
            ItemStack itemStack;
            if (Objects.equals(hashMap.getOrDefault(i, 100.0), this.dropchance.getOrDefault(i, 100.0)) && ItemStack._b(hashMap2.get(i), this.inventorySnapshot.get(i))) continue;
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder().append(entityPlayer.username).append(" updated npc's drop inventory at (").append(this.npc.posX).append(", ").append(this.npc.posY).append(", ").append(this.npc.posZ).append("). Changed:\n");
            }
            String string = (itemStack = this.inventorySnapshot.get(i)) != null ? itemStack._d + "x" + itemStack._b : "empty";
            ItemStack itemStack2 = hashMap2.get(i);
            String string2 = itemStack2 != null ? itemStack2._d + "x" + itemStack2._b : "empty";
            stringBuilder.append("Slot #").append(i).append(" from ").append("[").append(string).append(" with chance ").append(this.dropchance.get(i)).append("] to [").append(string2).append(" with chance ").append(hashMap.get(i)).append("]\n");
        }
        if (stringBuilder != null) {
            CustomNpcs.npcsLog.info(stringBuilder.toString());
        }
    }

    private HashMap<Integer, Double> readChances(NBTTagList nBTTagList) {
        HashMap<Integer, Double> hashMap = new HashMap<Integer, Double>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            int n = nBTTagCompound._f("Slot");
            if (nBTTagCompound._c("Integer")) {
                hashMap.put(n, Double.valueOf(nBTTagCompound._f("Integer")));
                continue;
            }
            hashMap.put(n, nBTTagCompound._i("Double"));
        }
        return hashMap;
    }

    public HashMap getWeapons() {
        return this.weapons;
    }

    public void setWeapons(HashMap<Integer, ItemStack> hashMap) {
        this.weapons = hashMap;
    }

    public HashMap getArmor() {
        if (this.npc.randomEquipState.applied) {
            HashMap<Integer, ItemStack> hashMap = new HashMap<Integer, ItemStack>(this.armor);
            hashMap.put(1, this.npc.randomEquipState.armor);
            return hashMap;
        }
        return this.armor;
    }

    public void setArmor(HashMap<Integer, ItemStack> hashMap) {
        this.armor = hashMap;
    }

    public ItemStack getWeapon() {
        return this.npc.randomEquipState.applied ? this.npc.randomEquipState.weapon : (ItemStack)this.getWeapons().get(0);
    }

    public ItemStack getFirearm() {
        ItemStack itemStack = this.getWeapon();
        if (itemStack != null && itemStack._a() instanceof wolf) {
            return itemStack;
        }
        return null;
    }

    public ItemStack getOffHand() {
        return (ItemStack)this.getWeapons().get(2);
    }

    public Map<Integer, ItemStack> getDropStuff() {
        ArrayList arrayList;
        HashMap<Integer, ItemStack> hashMap = new HashMap<Integer, ItemStack>();
        HashMultimap<Integer, Object> hashMultimap = HashMultimap.create();
        int n = 0;
        for (int n2 : this.items.keySet()) {
            arrayList = this.items.get(n2);
            if (arrayList == null) continue;
            int n3 = this.dropGroups.getOrDefault(n2, 0);
            double d = this.dropchance.getOrDefault(n2, 100.0);
            boolean bl = this.npc.worldObj.rand.nextDouble() * 100.0 + d >= 100.0;
            if (!bl) continue;
            boolean bl2 = zwat._a((ItemStack)((Object)arrayList)) > 0L;
            arrayList = sajh._e._a(((ItemStack)((Object)arrayList))._l(), this.npc.getEntityName(), bl2);
            if (n3 == 0) {
                hashMap.put(n++, (ItemStack)((Object)arrayList));
                continue;
            }
            hashMultimap.put(n3, arrayList);
        }
        for (int n2 : hashMultimap.keySet()) {
            arrayList = new ArrayList(hashMultimap.get(n2));
            if (arrayList.isEmpty()) continue;
            ItemStack itemStack = (ItemStack)arrayList.get(this.npc.worldObj.rand.nextInt(arrayList.size()));
            hashMap.put(n++, itemStack);
        }
        return hashMap;
    }

    public void dropStuff(boolean bl) {
        if (!this.npc.worldObj.isRemote) {
            Collection<ItemStack> collection = this.getDropStuff().values();
            for (ItemStack itemStack : collection) {
                this.npc.dropPlayerItemWithRandomChoice(itemStack._l(), true);
            }
            if (bl) {
                int n = this.minExp;
                if (this.maxExp - this.minExp > 0) {
                    n += this.npc.worldObj.rand.nextInt(this.maxExp - this.minExp);
                }
                while (n > 0) {
                    int n2 = EntityXPOrb.getXPSplit(n);
                    n -= n2;
                    this.npc.worldObj.spawnEntityInWorld(new EntityXPOrb(this.npc.worldObj, this.npc.posX, this.npc.posY, this.npc.posZ, n2));
                }
            }
        }
    }

    public ItemStack armorItemInSlot(int n) {
        if (this.npc.randomEquipState.applied && n == 1) {
            return this.npc.randomEquipState.armor;
        }
        return this.armor.get(n);
    }

    @Override
    public int getSizeInventory() {
        return 15;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return n < 4 ? this.armorItemInSlot(n) : (n < 7 ? (ItemStack)this.getWeapons().get(n - 4) : this.items.get(n - 7));
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        HashMap<Integer, ItemStack> hashMap;
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
        ItemStack itemStack = null;
        if (hashMap.get(n) != null) {
            if (hashMap.get((Object)Integer.valueOf((int)n))._b <= n2) {
                itemStack = hashMap.get(n);
                hashMap.put(n, null);
            } else {
                itemStack = hashMap.get(n)._a(n2);
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
        return itemStack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        HashMap<Integer, ItemStack> hashMap;
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
            ItemStack itemStack = hashMap.get(n);
            hashMap.put(n, null);
            if (n2 == 1) {
                this.setWeapons(hashMap);
            }
            if (n2 == 2) {
                this.setArmor(hashMap);
            }
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        HashMap<Integer, ItemStack> hashMap;
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
        hashMap.put(n, itemStack);
        if (n2 == 1) {
            this.setWeapons(hashMap);
        }
        if (n2 == 2) {
            this.setArmor(hashMap);
        }
    }

    @Override
    public String getInvName() {
        return "NPC Inventory";
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public void onInventoryChanged() {
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void openChest() {
    }

    @Override
    public void closeChest() {
    }

    @Override
    public boolean isInvNameLocalized() {
        return true;
    }

    @Override
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return true;
    }
}

