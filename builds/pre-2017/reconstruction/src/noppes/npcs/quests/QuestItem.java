/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.quests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.NpcMiscInventory;
import noppes.npcs.quests.QuestInterface;

public class QuestItem
extends QuestInterface {
    public NpcMiscInventory items = new NpcMiscInventory(3);

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.items.setFromNBT(nBTTagCompound._m("Items"));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Items", this.items.getToNBT());
    }

    @Override
    public boolean isCompleted(EntityPlayer entityPlayer) {
        HashMap hashMap = this.getProcessSet(entityPlayer);
        for (ItemStack itemStack : this.items.items.values()) {
            boolean bl = false;
            for (ItemStack itemStack2 : hashMap.values()) {
                if (!ncwh._a(itemStack, itemStack2, false, true) || itemStack2._b < itemStack._b) continue;
                bl = true;
                break;
            }
            if (bl) continue;
            return false;
        }
        return true;
    }

    public HashMap getProcessSet(EntityPlayer entityPlayer) {
        HashMap<Integer, ItemStack> hashMap = new HashMap<Integer, ItemStack>();
        for (int n : this.items.items.keySet()) {
            ItemStack itemStack = this.items.items.get(n);
            if (itemStack == null) continue;
            ItemStack itemStack2 = itemStack._l();
            itemStack2._b = 0;
            hashMap.put(n, itemStack2);
        }
        for (ItemStack itemStack2 : entityPlayer.inventory._a) {
            if (itemStack2 == null) continue;
            for (ItemStack itemStack : hashMap.values()) {
                if (!ncwh._a(itemStack, itemStack2, false, true)) continue;
                itemStack._b += itemStack2._b;
            }
        }
        return hashMap;
    }

    @Override
    public void handleComplete(EntityPlayer entityPlayer) {
        block0: for (ItemStack itemStack : this.items.items.values()) {
            int n = itemStack._b;
            for (int i = 0; i < entityPlayer.inventory._a.length; ++i) {
                ItemStack itemStack2 = entityPlayer.inventory._a[i];
                if (itemStack2 == null || !ncwh._a(itemStack2, itemStack, false, true)) continue;
                int n2 = itemStack2._b;
                if (n - n2 >= 0) {
                    entityPlayer.inventory.setInventorySlotContents(i, null);
                    itemStack2._a(n2);
                } else {
                    itemStack2._a(n);
                }
                if ((n -= n2) <= 0) continue block0;
            }
        }
    }

    @Override
    public Vector getQuestLogStatus(EntityPlayer entityPlayer) {
        Vector<String> vector = new Vector<String>();
        HashMap hashMap = this.getProcessSet(entityPlayer);
        Iterator iterator2 = hashMap.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            ItemStack itemStack = (ItemStack)hashMap.get(n);
            ItemStack itemStack2 = this.items.items.get(n);
            if (itemStack == null) continue;
            String string = itemStack._b + "";
            if (itemStack._b > itemStack2._b) {
                string = itemStack2._b + "";
            }
            string = string + "/" + itemStack2._b + "";
            String string2 = itemStack._u() ? itemStack._s() : String.format("{%s.name}", itemStack._a().getUnlocalizedNameInefficiently(itemStack));
            vector.add(string2.trim() + ": " + string);
        }
        return vector;
    }
}

