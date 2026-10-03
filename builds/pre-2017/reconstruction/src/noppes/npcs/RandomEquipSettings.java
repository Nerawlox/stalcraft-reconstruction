/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import cpw.mods.fml.common.FMLLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.controllers.RandomEquipState;

public class RandomEquipSettings
implements IInventory {
    public boolean enabled = false;
    public Map<Integer, Skin> skins = new HashMap<Integer, Skin>();
    public Map<Integer, ItemStack> stacks = new HashMap<Integer, ItemStack>();
    public Map<Integer, Float> weights = new HashMap<Integer, Float>();

    public void reShuffleEquip(EntityNPCInterface entityNPCInterface) {
        RandomEquipState randomEquipState = entityNPCInterface.randomEquipState;
        if (this.enabled) {
            String string = this.selectWeightedSkin();
            randomEquipState.skin = string != null ? string : entityNPCInterface.display.texture;
            randomEquipState.weapon = this.selectWeightedItem(0, 12);
            randomEquipState.armor = this.selectWeightedItem(12, 12);
            randomEquipState.applied = true;
        } else {
            randomEquipState.applied = false;
            randomEquipState.skin = null;
            randomEquipState.weapon = null;
            randomEquipState.armor = null;
        }
    }

    private String selectWeightedSkin() {
        HashMap<String, Float> hashMap = new HashMap<String, Float>();
        for (Skin skin : this.skins.values()) {
            if (skin.texture.isEmpty()) continue;
            hashMap.put(skin.texture, Float.valueOf(skin.weight));
        }
        return (String)this.selectWeighted(hashMap);
    }

    private ItemStack selectWeightedItem(int n, int n2) {
        HashMap<ItemStack, Float> hashMap = new HashMap<ItemStack, Float>();
        for (int i = n; i < n + n2; ++i) {
            if (!this.stacks.containsKey(i)) continue;
            hashMap.put(this.stacks.get(i), this.weights.getOrDefault(i, Float.valueOf(1.0f)));
        }
        return (ItemStack)this.selectWeighted(hashMap);
    }

    private <T> T selectWeighted(Map<T, Float> map) {
        float f = 0.0f;
        Iterator<Object> iterator2 = map.values().iterator();
        while (iterator2.hasNext()) {
            float f2 = iterator2.next().floatValue();
            f += f2;
        }
        f *= ThreadLocalRandom.current().nextFloat();
        for (Map.Entry entry : map.entrySet()) {
            if (!((f -= ((Float)entry.getValue()).floatValue()) <= 0.0f)) continue;
            return (T)entry.getKey();
        }
        return null;
    }

    public void writeToNbt(NBTTagCompound nBTTagCompound) {
        Object object;
        NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
        nBTTagCompound2._a("Enabled", this.enabled);
        NBTTagList nBTTagList = new NBTTagList();
        for (Map.Entry<Integer, Skin> object22 : this.skins.entrySet()) {
            NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
            nBTTagCompound3._a("Id", (int)object22.getKey());
            nBTTagCompound3._a("Skin", object22.getValue().texture);
            nBTTagCompound3._a("Weight", object22.getValue().weight);
            nBTTagList._a(nBTTagCompound3);
        }
        nBTTagCompound2._a("Skins", nBTTagList);
        NBTTagList nBTTagList2 = new NBTTagList();
        for (int n : this.stacks.keySet()) {
            NBTTagCompound nBTTagCompound4 = new NBTTagCompound();
            nBTTagCompound4._a("Slot", n);
            object = this.stacks.get(n);
            ((ItemStack)object)._b(nBTTagCompound4);
            nBTTagList2._a(nBTTagCompound4);
        }
        nBTTagCompound2._a("Stacks", nBTTagList2);
        NBTTagList nBTTagList3 = new NBTTagList();
        for (int n : this.weights.keySet()) {
            object = new NBTTagCompound();
            ((NBTTagCompound)object)._a("Slot", n);
            ((NBTTagCompound)object)._a("Weight", this.weights.get(n).floatValue());
            nBTTagList3._a((NBTBase)object);
        }
        nBTTagCompound2._a("Stacks", nBTTagList2);
        nBTTagCompound2._a("Weights", nBTTagList3);
        nBTTagCompound._a("RandomEquipSettings", nBTTagCompound2);
    }

    public void readFromNbt(NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("RandomEquipSettings");
        this.skins.clear();
        this.enabled = nBTTagCompound2._o("Enabled");
        NBTTagList nBTTagList = nBTTagCompound2._n("Skins");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound3 = (NBTTagCompound)nBTTagList._b(i);
            int n = nBTTagCompound3._f("Id");
            String string = nBTTagCompound3._j("Skin");
            float f = nBTTagCompound3._h("Weight");
            this.skins.put(n, new Skin(string, f));
        }
        this.stacks.clear();
        NBTTagList nBTTagList2 = nBTTagCompound2._n("Stacks");
        for (int i = 0; i < nBTTagList2._d(); ++i) {
            NBTTagCompound nBTTagCompound4 = (NBTTagCompound)nBTTagList2._b(i);
            int n = nBTTagCompound4._f("Slot");
            ItemStack itemStack = ItemStack._a(nBTTagCompound4);
            if (itemStack != null) {
                this.stacks.put(n, itemStack);
                continue;
            }
            FMLLog.warning("Failed to load ItemStack with id %d from stored random equip settings", nBTTagCompound4._e("id"));
        }
        this.weights.clear();
        NBTTagList nBTTagList3 = nBTTagCompound2._n("Weights");
        for (int i = 0; i < nBTTagList3._d(); ++i) {
            NBTTagCompound nBTTagCompound5 = (NBTTagCompound)nBTTagList3._b(i);
            int n = nBTTagCompound5._f("Slot");
            float f = nBTTagCompound5._h("Weight");
            this.weights.put(n, Float.valueOf(f));
        }
    }

    @Override
    public int getSizeInventory() {
        return 24;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return this.stacks.get(n);
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (this.stacks.containsKey(n)) {
            if (this.stacks.get((Object)Integer.valueOf((int)n))._b <= n2) {
                ItemStack itemStack = this.stacks.get(n);
                this.stacks.remove(n);
                this.onInventoryChanged();
                return itemStack;
            }
            ItemStack itemStack = this.stacks.get(n)._a(n2);
            if (this.stacks.get((Object)Integer.valueOf((int)n))._b == 0) {
                this.stacks.remove(n);
            }
            return itemStack;
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        if (this.stacks.containsKey(n) && this.stacks.get(n) != null) {
            ItemStack itemStack = this.stacks.get(n);
            this.stacks.remove(n);
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        if (itemStack == null) {
            this.stacks.remove(n);
        } else {
            this.stacks.put(n, itemStack);
        }
    }

    @Override
    public String getInvName() {
        return "Random Equip";
    }

    @Override
    public boolean isInvNameLocalized() {
        return false;
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
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return n < 12 || itemStack._a() instanceof ItemArmor;
    }

    public static class Skin {
        public String texture;
        public float weight;

        public Skin(String string, float f) {
            this.texture = string;
            this.weight = f;
        }
    }
}

