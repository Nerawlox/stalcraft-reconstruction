/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mo
 *  ud
 *  vi
 *  we
 */
package ru.stalcraft.inventory;

import java.util.ArrayList;
import java.util.Iterator;
import ru.stalcraft.inventory.ArtefaktSlot;
import ru.stalcraft.inventory.ICustomContainer;
import ru.stalcraft.inventory.SlotArmor;
import ru.stalcraft.inventory.SlotBackpack;
import ru.stalcraft.inventory.SlotDetector;
import ru.stalcraft.inventory.SlotMedicine;
import ru.stalcraft.inventory.StalkerSlot;
import ru.stalcraft.player.IPlayerServerInfo;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;

public class HandcuffsContainer
extends uy
implements ICustomContainer {
    public boolean isLocalWorld = false;
    public final uf inventoryOwner;
    public final PlayerInfo inventoryOwnerInfo;
    public final uf containerUser;
    private boolean hasBackpackSlots = false;
    public ArrayList backpackSlots = new ArrayList();
    public ArrayList armorSlots = new ArrayList();
    private ArrayList leftSlots = new ArrayList();
    private ArrayList hotbarSlots = new ArrayList();
    private SlotBackpack backpackSlot;

    public HandcuffsContainer(uf inventoryOwner, uf containerUser, boolean localWorld) {
        int i2;
        ud par1InventoryPlayer = inventoryOwner.bn;
        this.isLocalWorld = localWorld;
        this.inventoryOwner = inventoryOwner;
        this.inventoryOwnerInfo = PlayerUtils.getInfo(inventoryOwner);
        this.containerUser = containerUser;
        this.hotbarSlots.add(new StalkerSlot(this, this, (mo)par1InventoryPlayer, 0, 26, 26));
        this.hotbarSlots.add(new StalkerSlot(this, this, (mo)par1InventoryPlayer, 1, 26, 44));
        this.hotbarSlots.add(new StalkerSlot(this, this, (mo)par1InventoryPlayer, 2, 62, 26));
        this.hotbarSlots.add(new StalkerSlot(this, this, (mo)par1InventoryPlayer, 3, 62, 44));
        for (we slot1 : this.hotbarSlots) {
            this.a(slot1);
        }
        for (i2 = 0; i2 < 4; ++i2) {
            for (int j2 = 0; j2 < 8; ++j2) {
                this.a(new StalkerSlot(this, this, (mo)par1InventoryPlayer, i2 * 8 + j2 + 4, 125 + i2 * 18, 16 + j2 * 18));
            }
        }
        for (i2 = 0; i2 < 4; ++i2) {
            SlotArmor var9 = new SlotArmor(this, this, (mo)par1InventoryPlayer, par1InventoryPlayer.j_() - 1 - i2, 44, 8 + i2 * 18, i2);
            this.a(var9);
            this.armorSlots.add(var9);
            this.leftSlots.add(var9);
        }
        for (i2 = 0; i2 < 5; ++i2) {
            ArtefaktSlot var10 = new ArtefaktSlot(this, this, this.inventoryOwnerInfo.stInv, i2, 8 + i2 * 18, 108);
            this.a(var10);
            this.leftSlots.add(var10);
        }
        for (i2 = 0; i2 < 3; ++i2) {
            SlotDetector var11 = new SlotDetector(this, this, this.inventoryOwnerInfo.stInv, i2 + 5, 26 + i2 * 18, 131);
            this.a(var11);
            this.leftSlots.add(var11);
        }
        for (i2 = 0; i2 < 4; ++i2) {
            SlotMedicine var12 = new SlotMedicine(this, this, this.inventoryOwnerInfo.stInv, i2 + 8, 17 + i2 * 18, 85);
            this.a(var12);
            this.leftSlots.add(var12);
        }
        this.backpackSlot = new SlotBackpack(this, this, this.inventoryOwnerInfo.stInv, 12, 44, 155);
        this.a(this.backpackSlot);
        this.leftSlots.add(this.backpackSlot);
        for (i2 = 0; i2 < 8; ++i2) {
            StalkerSlot var13 = new StalkerSlot(this, this, this.inventoryOwnerInfo.stInv, i2 + 13, 201, 16 + i2 * 18);
            this.backpackSlots.add(var13);
            this.a(var13);
        }
        this.hasBackpackSlots = this.hasBackpack();
    }

    @Override
    public boolean a(uf par1EntityPlayer) {
        return par1EntityPlayer == this.containerUser;
    }

    @Override
    public ye b(uf par1EntityPlayer, int par2) {
        return null;
    }

    @Override
    public ye a(int par1, int par2, int par3, uf par4EntityPlayer) {
        if (par1 >= 0 && this.a(par1) != null && !this.isSlotActive(this.a(par1))) {
            return null;
        }
        if (par2 == 1 && par1 >= 0 && this.a(par1) != null && this.a(par1).e()) {
            PlayerUtils.addItem(par4EntityPlayer, this.a(par1).d());
            this.a(par1).c((ye)null);
            return null;
        }
        return super.a(par1, par2, par3, par4EntityPlayer);
    }

    @Override
    public boolean hasBackpack() {
        return this.backpackSlot.e();
    }

    @Override
    public we a(int par1) {
        return par1 < this.c.size() ? (we)this.c.get(par1) : null;
    }

    @Override
    public void a(int par1, ye par2ItemStack) {
        we slot = this.a(par1);
        if (slot != null) {
            slot.c(par2ItemStack);
        }
    }

    @Override
    public void handleBackpackChanged(boolean hasBackpack) {
        if (this.hasBackpackSlots != hasBackpack) {
            this.hasBackpackSlots = hasBackpack;
            if (!hasBackpack && !this.isLocalWorld) {
                ArrayList<ye> inBackpack = new ArrayList<ye>();
                for (int it2 = 53; it2 < 61; ++it2) {
                    if (!this.a(it2).e()) continue;
                    inBackpack.add(this.a(it2).d());
                    this.a(it2, (ye)null);
                }
                Iterator var7 = this.b.iterator();
                while (var7.hasNext()) {
                    ye i$ = (ye)var7.next();
                    if (i$ == null || !inBackpack.contains(i$)) continue;
                    var7.remove();
                }
                for (ye stack : inBackpack) {
                    PlayerUtils.addItem(this.inventoryOwner, stack);
                }
                this.b();
            }
        }
    }

    @Override
    public void b() {
        boolean hasItemsChanged = false;
        for (int i2 = 0; i2 < this.c.size(); ++i2) {
            ye itemstack = ((we)this.c.get(i2)).d();
            ye itemstack1 = (ye)this.b.get(i2);
            if (ye.b(itemstack1, itemstack)) continue;
            hasItemsChanged = true;
            itemstack1 = itemstack == null ? null : itemstack.m();
            this.b.set(i2, itemstack1);
            for (int j2 = 0; j2 < this.e.size(); ++j2) {
                ((vi)this.e.get(j2)).a((uy)this, i2, itemstack1);
            }
        }
        if (hasItemsChanged && this.inventoryOwnerInfo instanceof IPlayerServerInfo) {
            IPlayerServerInfo par2 = (IPlayerServerInfo)((Object)this.inventoryOwnerInfo);
            par2.updateWeightSpeed();
        }
    }

    @Override
    public ArrayList getBackpackSlots() {
        return this.backpackSlots;
    }

    @Override
    public ArrayList getArmorSlots() {
        return this.armorSlots;
    }

    @Override
    public of getOwner() {
        return this.inventoryOwner;
    }

    @Override
    public boolean isSlotActive(we slot) {
        return this.hasBackpack() || !this.backpackSlots.contains(slot);
    }
}

