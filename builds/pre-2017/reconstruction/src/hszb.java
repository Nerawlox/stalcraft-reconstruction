/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.money.zwat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class hszb {
    public static final hszb _a = new hszb();
    private Map<Integer, hsvw> _b = new HashMap<Integer, hsvw>();

    public hsvw _a(int n) {
        return this._b.get(n);
    }

    public void _a(hsvw hsvw2) {
        if (this._b.put(hsvw2._d(), hsvw2) != null) {
            throw new IllegalArgumentException("Duplicating recipe with id " + hsvw2._d() + ": " + hsvw2);
        }
    }

    private List<Float> _c(EntityPlayer entityPlayer, hsvw hsvw2, int n) {
        zwyn zwyn2 = (zwyn)entityPlayer.inventoryContainer;
        ArrayList<Float> arrayList = new ArrayList<Float>();
        for (int i = 0; i < n; ++i) {
            float f = 0.0f;
            float f2 = 0.0f;
            for (ItemStack itemStack : hsvw2._i()) {
                int n2 = itemStack._b;
                for (Slot slot : zwyn2.getOwnedSlots()) {
                    ItemStack itemStack2 = slot.getStack();
                    if (itemStack2 == null || itemStack2._d != itemStack._d) continue;
                    f += itemStack2._f() ? (float)itemStack2._j() : 1.0f;
                    f2 += itemStack2._f() ? (float)itemStack2._k() : 1.0f;
                    if (itemStack2._b < n2) {
                        n2 -= itemStack2._b;
                        itemStack2._b = 0;
                        slot.putStack(null);
                        continue;
                    }
                    itemStack2._b -= n2;
                    n2 = 0;
                }
                if (n2 <= 0) continue;
                throw new IllegalStateException("Unable to consume sufficient amount of items");
            }
            arrayList.add(Float.valueOf(f / f2));
        }
        zwyn2.detectAndSendChanges();
        return arrayList;
    }

    public boolean _a(EntityPlayer entityPlayer, hsvw hsvw2, int n) {
        if (!magc._a(entityPlayer)._a(hsvw2)) {
            return false;
        }
        if (!this._b(entityPlayer, hsvw2, n)) {
            return false;
        }
        long l = hsvw2._b();
        return l <= 0L || zwat._a(entityPlayer)._a() >= l;
    }

    public boolean _b(EntityPlayer entityPlayer, hsvw hsvw2, int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Ingredients multiplier can't be lower than 1");
        }
        List<ItemStack> list = hsvw2._i();
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        zwyn zwyn2 = (zwyn)entityPlayer.inventoryContainer;
        for (ItemStack itemStack : list) {
            int n2 = itemStack._b * n;
            for (Slot slot : zwyn2.getOwnedSlots()) {
                ItemStack itemStack2 = slot.getStack();
                if (itemStack2 == null || itemStack2._d != itemStack._d) continue;
                int n3 = hashMap.getOrDefault(slot.getSlotIndex(), itemStack2._b);
                if (n3 < n2) {
                    n2 -= n3;
                    hashMap.put(slot.getSlotIndex(), 0);
                    continue;
                }
                hashMap.put(slot.getSlotIndex(), n3 - n2);
                n2 = 0;
            }
            if (n2 <= 0) continue;
            return false;
        }
        return true;
    }

    public Map<Integer, hsvw> _a() {
        return this._b;
    }
}

