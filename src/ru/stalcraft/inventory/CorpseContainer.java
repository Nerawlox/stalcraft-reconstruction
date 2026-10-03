/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  we
 */
package ru.stalcraft.inventory;

import java.util.ArrayList;
import java.util.Iterator;
import ru.stalcraft.entity.EntityCorpse;
import ru.stalcraft.inventory.ArtefaktSlot;
import ru.stalcraft.inventory.CorpseInventory;
import ru.stalcraft.inventory.ICustomContainer;
import ru.stalcraft.inventory.SlotArmor;
import ru.stalcraft.inventory.SlotBackpack;
import ru.stalcraft.inventory.SlotDetector;
import ru.stalcraft.inventory.SlotMedicine;
import ru.stalcraft.inventory.StalkerSlot;
import ru.stalcraft.player.PlayerUtils;

public class CorpseContainer
extends uy
implements ICustomContainer {
    public boolean isLocalWorld = false;
    private boolean hasBackpackSlots = false;
    public ArrayList backpackSlots = new ArrayList();
    public ArrayList armorSlots = new ArrayList();
    private SlotBackpack backpackSlot;
    private EntityCorpse corpse;
    private CorpseInventory corpseInventory;

    public CorpseContainer(EntityCorpse corpse, boolean par2) {
        int i2;
        this.isLocalWorld = par2;
        this.corpse = corpse;
        this.corpseInventory = corpse.inventory;
        this.a(new StalkerSlot(this, this, this.corpseInventory, 0, 26, 26));
        this.a(new StalkerSlot(this, this, this.corpseInventory, 1, 26, 44));
        this.a(new StalkerSlot(this, this, this.corpseInventory, 2, 62, 26));
        this.a(new StalkerSlot(this, this, this.corpseInventory, 3, 62, 44));
        for (i2 = 0; i2 < 4; ++i2) {
            for (int j2 = 0; j2 < 8; ++j2) {
                this.a(new StalkerSlot(this, this, this.corpseInventory, i2 * 8 + j2 + 4, 125 + i2 * 18, 16 + j2 * 18));
            }
        }
        for (i2 = 0; i2 < 4; ++i2) {
            SlotArmor slot = new SlotArmor(this, this, this.corpseInventory, 39 - i2, 44, 8 + i2 * 18, i2);
            this.a(slot);
            this.armorSlots.add(slot);
        }
        for (i2 = 0; i2 < 5; ++i2) {
            this.a(new ArtefaktSlot(this, this, this.corpseInventory, 40 + i2, 8 + i2 * 18, 108));
        }
        for (i2 = 0; i2 < 3; ++i2) {
            this.a(new SlotDetector(this, this, this.corpseInventory, i2 + 45, 26 + i2 * 18, 131));
        }
        for (i2 = 0; i2 < 4; ++i2) {
            this.a(new SlotMedicine(this, this, this.corpseInventory, i2 + 48, 17 + i2 * 18, 85));
        }
        this.backpackSlot = new SlotBackpack(this, this, this.corpseInventory, 52, 44, 155);
        this.a(this.backpackSlot);
        for (i2 = 0; i2 < 8; ++i2) {
            StalkerSlot var6 = new StalkerSlot(this, this, this.corpseInventory, i2 + 53, 201, 16 + i2 * 18);
            this.backpackSlots.add(var6);
            this.a(var6);
        }
        this.hasBackpackSlots = this.hasBackpack();
        corpse.openedContainers.add(this);
    }

    @Override
    public boolean a(uf par1EntityPlayer) {
        return true;
    }

    @Override
    public ye b(uf par1EntityPlayer, int par2) {
        return null;
    }

    @Override
    public ye a(int par1, int par2, int par3, uf par4EntityPlayer) {
        if (par1 >= 0 && !this.hasBackpack() && this.a(par1) != null && this.backpackSlots.contains(this.a(par1))) {
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
    public boolean a(ye par1ItemStack, we par2Slot) {
        return super.a(par1ItemStack, par2Slot);
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
                Iterator var15 = this.b.iterator();
                while (var15.hasNext()) {
                    ye i$ = (ye)var15.next();
                    if (i$ == null || !inBackpack.contains(i$)) continue;
                    var15.remove();
                }
                for (ye stack : inBackpack) {
                    if (this.corpseInventory.addItemStackToInventory(stack)) continue;
                    float f2 = 0.7f;
                    double d0 = (double)(this.corpse.q.s.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
                    double d1 = (double)(this.corpse.q.s.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
                    double d2 = (double)(this.corpse.q.s.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
                    ss entityitem = new ss(this.corpse.q, this.corpse.u + d0, this.corpse.v + d1, this.corpse.w + d2, stack);
                    entityitem.b = 10;
                    this.corpse.q.d(entityitem);
                }
                this.b();
            }
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
        return this.corpse;
    }

    @Override
    public boolean isSlotActive(we slot) {
        return this.hasBackpack() || !this.getBackpackSlots().contains(slot);
    }

    @Override
    public void b(uf par1EntityPlayer) {
        super.b(par1EntityPlayer);
        this.corpse.openedContainers.remove(this);
    }
}

