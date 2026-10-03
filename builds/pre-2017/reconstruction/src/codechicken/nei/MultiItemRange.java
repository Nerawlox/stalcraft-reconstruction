/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.ReflectionManager;
import codechicken.nei.ItemRange;
import codechicken.nei.ItemVisibilityHash;
import java.util.ArrayList;
import java.util.Collection;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class MultiItemRange {
    public ArrayList<ItemRange> ranges = new ArrayList();
    public byte state;
    protected int lastslotclicked = -1;
    protected long lastslotclicktime;

    public boolean isItemInRange(int n, int n2) {
        for (ItemRange itemRange : this.ranges) {
            if (!itemRange.isItemInRange(n, n2)) continue;
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = false;
        for (ItemRange itemRange : this.ranges) {
            if (bl) {
                stringBuilder.append(',');
            } else {
                bl = true;
            }
            stringBuilder.append(itemRange.toString());
        }
        return stringBuilder.toString();
    }

    public MultiItemRange(String string) {
        String[] stringArray;
        for (String string2 : stringArray = string.split(",")) {
            this.ranges.add(new ItemRange(string2));
        }
    }

    public MultiItemRange() {
    }

    public MultiItemRange add(ItemRange itemRange) {
        this.ranges.add(itemRange);
        return this;
    }

    public MultiItemRange add(Collection<?> collection) {
        for (Object obj : collection) {
            try {
                ReflectionManager.callMethod(this.getClass(), (Object)this, "add", obj);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return this;
    }

    public MultiItemRange add(MultiItemRange multiItemRange) {
        return this.add(multiItemRange.ranges);
    }

    public MultiItemRange add(int n) {
        return this.add(new ItemRange(n));
    }

    public MultiItemRange add(int n, int n2, int n3) {
        return this.add(new ItemRange(n, n2, n3));
    }

    public MultiItemRange add(int n, int n2) {
        return this.add(new ItemRange(n, n2));
    }

    public MultiItemRange add(Item item, int n, int n2) {
        return this.add(item.itemID, n, n2);
    }

    public MultiItemRange add(Block block, int n, int n2) {
        return this.add(block.blockID, n, n2);
    }

    public MultiItemRange add(Item item) {
        return this.add(item.itemID);
    }

    public MultiItemRange add(Block block) {
        return this.add(block.blockID);
    }

    public MultiItemRange add(ItemStack itemStack) {
        if (itemStack._a().isDamageable()) {
            return this.add(itemStack._d);
        }
        return this.add(itemStack._d, itemStack._j(), itemStack._j());
    }

    public int getNumSlots() {
        int n = 0;
        for (ItemRange itemRange : this.ranges) {
            n += itemRange.encompasseditems.size();
        }
        return n;
    }

    public void slotClicked(int n, int n2, boolean bl) {
        int n3 = 0;
        for (ItemRange itemRange : this.ranges) {
            if (n3 + itemRange.encompasseditems.size() <= n) {
                n3 += itemRange.encompasseditems.size();
                continue;
            }
            for (int i = 0; i < itemRange.encompasseditems.size(); ++i) {
                if (n == n3) {
                    itemRange.onClick(i, n2, bl);
                    return;
                }
                ++n3;
            }
        }
    }

    public void hideAllItems() {
        for (ItemRange itemRange : this.ranges) {
            itemRange.hideAllItems();
        }
    }

    public void showAllItems() {
        for (ItemRange itemRange : this.ranges) {
            itemRange.showAllItems();
        }
    }

    public int getWidth() {
        return 18;
    }

    public void resetHashes() {
        for (ItemRange itemRange : this.ranges) {
            itemRange.resetHashes();
        }
    }

    public void updateState(ItemVisibilityHash itemVisibilityHash) {
        boolean bl = false;
        boolean bl2 = false;
        for (ItemRange itemRange : this.ranges) {
            if (itemRange.encompasseditems.size() == 0) continue;
            itemRange.updateState(itemVisibilityHash);
            byte by = itemRange.state;
            if (by == 1) {
                this.state = 1;
                return;
            }
            if (by == 0) {
                if (bl) {
                    this.state = 1;
                    return;
                }
                bl2 = true;
                continue;
            }
            if (bl2) {
                this.state = 1;
                return;
            }
            bl = true;
        }
        this.state = bl ? (byte)2 : (byte)0;
    }

    public void addItemIfInRange(int n, int n2, NBTTagCompound nBTTagCompound) {
        for (ItemRange itemRange : this.ranges) {
            if (itemRange.addItemIfInRange(n, n2, nBTTagCompound)) break;
        }
    }
}

