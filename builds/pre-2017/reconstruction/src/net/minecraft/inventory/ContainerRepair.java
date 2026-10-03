/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.apache.commons.lang3.StringUtils;

public class ContainerRepair
extends Container {
    public IInventory _a = new InventoryCraftResult();
    public IInventory _b = new netm(this, "Repair", true, 2);
    public World _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g;
    public int _h;
    public String _i;
    public final EntityPlayer _j;

    public ContainerRepair(InventoryPlayer inventoryPlayer, World world, int n, int n2, int n3, EntityPlayer entityPlayer) {
        int n4;
        this._c = world;
        this._d = n;
        this._e = n2;
        this._f = n3;
        this._j = entityPlayer;
        this.addSlotToContainer(new Slot(this._b, 0, 27, 47));
        this.addSlotToContainer(new Slot(this._b, 1, 76, 47));
        this.addSlotToContainer(new cvvn(this, this._a, 2, 134, 47, world, n, n2, n3));
        for (n4 = 0; n4 < 3; ++n4) {
            for (int i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(inventoryPlayer, i + n4 * 9 + 9, 8 + i * 18, 84 + n4 * 18));
            }
        }
        for (n4 = 0; n4 < 9; ++n4) {
            this.addSlotToContainer(new Slot(inventoryPlayer, n4, 8 + n4 * 18, 142));
        }
    }

    @Override
    public void onCraftMatrixChanged(IInventory iInventory) {
        super.onCraftMatrixChanged(iInventory);
        if (iInventory == this._b) {
            this._a();
        }
    }

    public void _a() {
        ItemStack itemStack = this._b.getStackInSlot(0);
        this._g = 0;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        if (itemStack == null) {
            this._a.setInventorySlotContents(0, null);
            this._g = 0;
        } else {
            int n4;
            Enchantment enchantment;
            Iterator iterator2;
            int n5;
            int n6;
            int n7;
            int n8;
            ItemStack itemStack2 = itemStack._l();
            ItemStack itemStack3 = this._b.getStackInSlot(1);
            Map map = zhty._a(itemStack2);
            boolean bl = false;
            int n9 = n2 + itemStack._C() + (itemStack3 == null ? 0 : itemStack3._C());
            this._h = 0;
            if (itemStack3 != null) {
                boolean bl2 = bl = itemStack3._d == Item.enchantedBook.itemID && Item.enchantedBook._a(itemStack3)._d() > 0;
                if (itemStack2._f() && Item.itemsList[itemStack2._d].getIsRepairable(itemStack, itemStack3)) {
                    n8 = Math.min(itemStack2._i(), itemStack2._k() / 4);
                    if (n8 <= 0) {
                        this._a.setInventorySlotContents(0, null);
                        this._g = 0;
                        return;
                    }
                    for (n7 = 0; n8 > 0 && n7 < itemStack3._b; ++n7) {
                        n6 = itemStack2._i() - n8;
                        itemStack2._b(n6);
                        n += Math.max(1, n8 / 100) + map.size();
                        n8 = Math.min(itemStack2._i(), itemStack2._k() / 4);
                    }
                    this._h = n7;
                } else {
                    if (!(bl || itemStack2._d == itemStack3._d && itemStack2._f())) {
                        this._a.setInventorySlotContents(0, null);
                        this._g = 0;
                        return;
                    }
                    if (itemStack2._f() && !bl) {
                        n8 = itemStack._k() - itemStack._i();
                        n7 = itemStack3._k() - itemStack3._i();
                        n6 = n7 + itemStack2._k() * 12 / 100;
                        int n10 = n8 + n6;
                        n5 = itemStack2._k() - n10;
                        if (n5 < 0) {
                            n5 = 0;
                        }
                        if (n5 < itemStack2._j()) {
                            itemStack2._b(n5);
                            n += Math.max(1, n6 / 100);
                        }
                    }
                    Map map2 = zhty._a(itemStack3);
                    iterator2 = map2.keySet().iterator();
                    while (iterator2.hasNext()) {
                        int n11;
                        n6 = (Integer)iterator2.next();
                        enchantment = Enchantment._a[n6];
                        n5 = map.containsKey(n6) ? (Integer)map.get(n6) : 0;
                        n4 = (Integer)map2.get(n6);
                        int n12 = n5 == n4 ? ++n4 : Math.max(n4, n5);
                        n4 = n12;
                        int n13 = n4 - n5;
                        boolean bl3 = enchantment._a(itemStack);
                        if (this._j.capabilities._d || itemStack._d == ItemEnchantedBook.enchantedBook.itemID) {
                            bl3 = true;
                        }
                        Iterator iterator3 = map.keySet().iterator();
                        while (iterator3.hasNext()) {
                            n11 = (Integer)iterator3.next();
                            if (n11 == n6 || enchantment._a(Enchantment._a[n11])) continue;
                            bl3 = false;
                            n += n13;
                        }
                        if (!bl3) continue;
                        if (n4 > enchantment._c()) {
                            n4 = enchantment._c();
                        }
                        map.put(n6, n4);
                        n11 = 0;
                        switch (enchantment._a()) {
                            case 1: {
                                n11 = 8;
                                break;
                            }
                            case 2: {
                                n11 = 4;
                            }
                            default: {
                                break;
                            }
                            case 5: {
                                n11 = 2;
                                break;
                            }
                            case 10: {
                                n11 = 1;
                            }
                        }
                        if (bl) {
                            n11 = Math.max(1, n11 / 2);
                        }
                        n += n11 * n13;
                    }
                }
            }
            if (StringUtils.isBlank(this._i)) {
                if (itemStack._u()) {
                    n3 = itemStack._f() ? 7 : itemStack._b * 5;
                    n += n3;
                    itemStack2._t();
                }
            } else if (!this._i.equals(itemStack._s())) {
                n3 = itemStack._f() ? 7 : itemStack._b * 5;
                n += n3;
                if (itemStack._u()) {
                    n9 += n3 / 2;
                }
                itemStack2._a(this._i);
            }
            n8 = 0;
            iterator2 = map.keySet().iterator();
            while (iterator2.hasNext()) {
                n6 = (Integer)iterator2.next();
                enchantment = Enchantment._a[n6];
                n5 = (Integer)map.get(n6);
                n4 = 0;
                ++n8;
                switch (enchantment._a()) {
                    case 1: {
                        n4 = 8;
                        break;
                    }
                    case 2: {
                        n4 = 4;
                    }
                    default: {
                        break;
                    }
                    case 5: {
                        n4 = 2;
                        break;
                    }
                    case 10: {
                        n4 = 1;
                    }
                }
                if (bl) {
                    n4 = Math.max(1, n4 / 2);
                }
                n9 += n8 + n5 * n4;
            }
            if (bl) {
                n9 = Math.max(1, n9 / 2);
            }
            if (bl && itemStack2 != null && !Item.itemsList[itemStack2._d].isBookEnchantable(itemStack2, itemStack3)) {
                itemStack2 = null;
            }
            this._g = n9 + n;
            if (n <= 0) {
                itemStack2 = null;
            }
            if (n3 == n && n3 > 0 && this._g >= 40) {
                this._g = 39;
            }
            if (this._g >= 40 && !this._j.capabilities._d) {
                itemStack2 = null;
            }
            if (itemStack2 != null) {
                n7 = itemStack2._C();
                if (itemStack3 != null && n7 < itemStack3._C()) {
                    n7 = itemStack3._C();
                }
                if (itemStack2._u()) {
                    n7 -= 9;
                }
                if (n7 < 0) {
                    n7 = 0;
                }
                itemStack2._d(n7 += 2);
                zhty._a(map, itemStack2);
            }
            this._a.setInventorySlotContents(0, itemStack2);
            this.detectAndSendChanges();
        }
    }

    @Override
    public void func_75132_a(ICrafting iCrafting) {
        super.func_75132_a(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this._g);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void updateProgressBar(int n, int n2) {
        if (n == 0) {
            this._g = n2;
        }
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);
        if (!this._c.isRemote) {
            for (int i = 0; i < this._b.getSizeInventory(); ++i) {
                ItemStack itemStack = this._b.getStackInSlotOnClosing(i);
                if (itemStack == null) continue;
                entityPlayer.dropPlayerItem(itemStack);
            }
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this._c.getBlockId(this._d, this._e, this._f) != Block.anvil.blockID ? false : entityPlayer.getDistanceSq((double)this._d + 0.5, (double)this._e + 0.5, (double)this._f + 0.5) <= 64.0;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
            if (n == 2) {
                if (!this.mergeItemStack(itemStack2, 3, 39, true)) {
                    return null;
                }
                slot.onSlotChange(itemStack2, itemStack);
            } else if (n != 0 && n != 1 ? n >= 3 && n < 39 && !this.mergeItemStack(itemStack2, 0, 2, false) : !this.mergeItemStack(itemStack2, 3, 39, false)) {
                return null;
            }
            if (itemStack2._b == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
            if (itemStack2._b == itemStack._b) {
                return null;
            }
            slot.onPickupFromSlot(entityPlayer, itemStack2);
        }
        return itemStack;
    }

    public void _a(String string) {
        this._i = string;
        if (this.getSlot(2).getHasStack()) {
            ItemStack itemStack = this.getSlot(2).getStack();
            if (StringUtils.isBlank(string)) {
                itemStack._t();
            } else {
                itemStack._a(this._i);
            }
        }
        this._a();
    }

    public static IInventory _a(ContainerRepair containerRepair) {
        return containerRepair._b;
    }

    public static int _b(ContainerRepair containerRepair) {
        return containerRepair._h;
    }
}

