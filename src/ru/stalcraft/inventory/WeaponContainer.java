/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aaf
 *  mo
 *  ud
 *  vi
 *  vk
 *  wc
 *  we
 */
package ru.stalcraft.inventory;

import java.util.ArrayList;
import java.util.Iterator;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.inventory.ICustomContainer;
import ru.stalcraft.inventory.SlotWeaponUpgrade;
import ru.stalcraft.inventory.StalkerSlot;
import ru.stalcraft.inventory.WeaponInventory;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.player.IPlayerServerInfo;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;

public class WeaponContainer
extends uy
implements ICustomContainer {
    public vk craftMatrix = new vk((uy)this, 2, 2);
    public mo craftResult = new wc();
    public boolean isLocalWorld = false;
    protected final uf player;
    public final PlayerInfo info;
    private boolean hasBackpackSlots = false;
    public ArrayList backpackSlots = new ArrayList();
    private ArrayList hotbarSlots = new ArrayList();
    private SlotWeaponUpgrade flashlightSlot;
    private SlotWeaponUpgrade silencerSlot;
    private SlotWeaponUpgrade sightSlot;
    private WeaponInventory weaponInventory;
    public ye updatedWeapon;

    public WeaponContainer(ud par1InventoryPlayer, boolean par2, uf par3EntityPlayer, int weaponSlotId) {
        int i2;
        this.player = par3EntityPlayer;
        this.info = PlayerUtils.getInfo(par3EntityPlayer);
        ye weapon = weaponSlotId > par1InventoryPlayer.j_() ? this.info.stInv.a(weaponSlotId - par1InventoryPlayer.j_()) : par1InventoryPlayer.a(weaponSlotId);
        this.isLocalWorld = par2;
        for (i2 = 0; i2 < 4; ++i2) {
            this.a(new StalkerSlot(this, this, (mo)par1InventoryPlayer, i2, 29 + i2 * 18, 141));
        }
        for (i2 = 0; i2 < 4; ++i2) {
            for (int j2 = 0; j2 < 8; ++j2) {
                this.a(new StalkerSlot(this, this, (mo)par1InventoryPlayer, i2 * 8 + j2 + 4, 125 + i2 * 18, 16 + j2 * 18));
            }
        }
        for (i2 = 0; i2 < 8; ++i2) {
            StalkerSlot slot = new StalkerSlot(this, this, this.info.stInv, i2 + 13, 201, 16 + i2 * 18);
            this.backpackSlots.add(slot);
            this.a(slot);
        }
        this.weaponInventory = new WeaponInventory();
        this.flashlightSlot = new SlotWeaponUpgrade(this, this, this.weaponInventory, 0, 101, 79, StalkerMain.flashlight.cv);
        this.silencerSlot = new SlotWeaponUpgrade(this, this, this.weaponInventory, 1, 53, 10, StalkerMain.silencer.cv);
        this.sightSlot = new SlotWeaponUpgrade(this, this, this.weaponInventory, 2, 13, 36, StalkerMain.sight.cv);
        this.a(this.flashlightSlot);
        this.a(this.silencerSlot);
        this.a(this.sightSlot);
        this.a((mo)this.craftMatrix);
        this.hasBackpackSlots = this.hasBackpack();
        this.switchToWeaponUpgrade(weapon);
    }

    public void switchToWeaponUpgrade(ye stack) {
        this.updatedWeapon = stack;
        by tag = PlayerUtils.getTag(this.updatedWeapon);
        if (tag.n("flashlight")) {
            this.weaponInventory.contents[0] = new ye(StalkerMain.flashlight, 1, 0);
        }
        if (tag.n("silencer")) {
            this.weaponInventory.contents[1] = new ye(StalkerMain.silencer, 1, 0);
        }
        if (tag.n("sight")) {
            this.weaponInventory.contents[2] = new ye(StalkerMain.sight, 1, 0);
        }
    }

    @Override
    public void a(mo par1IInventory) {
        if (this.player != null) {
            this.craftResult.a(0, aaf.a().a(this.craftMatrix, this.player.q));
        }
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
        return par1 >= 0 && this.a(par1) != null && !this.isSlotActive(this.a(par1)) ? null : super.a(par1, par2, par3, par4EntityPlayer);
    }

    @Override
    public boolean a(ye par1ItemStack, we par2Slot) {
        return par2Slot.f != this.craftResult && super.a(par1ItemStack, par2Slot);
    }

    @Override
    public boolean hasBackpack() {
        return this.info.stInv.mainInventory[12] != null;
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
                    PlayerUtils.addItem(this.player, stack);
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
    public of getOwner() {
        return this.player;
    }

    @Override
    public void b() {
        boolean hasItemsChanged = false;
        for (int tag = 0; tag < this.c.size(); ++tag) {
            ye itemstack = ((we)this.c.get(tag)).d();
            ye itemstack1 = (ye)this.b.get(tag);
            if (ye.b(itemstack1, itemstack)) continue;
            hasItemsChanged = true;
            itemstack1 = itemstack == null ? null : itemstack.m();
            this.b.set(tag, itemstack1);
            for (int j2 = 0; j2 < this.e.size(); ++j2) {
                ((vi)this.e.get(j2)).a((uy)this, tag, itemstack1);
            }
        }
        if (hasItemsChanged) {
            if (this.info instanceof IPlayerServerInfo) {
                IPlayerServerInfo par2 = (IPlayerServerInfo)((Object)this.info);
                par2.updateWeightSpeed();
            }
            by var6 = PlayerUtils.getTag(this.updatedWeapon);
            var6.a("flashlight", this.flashlightSlot.e());
            var6.a("silencer", this.silencerSlot.e());
            var6.a("sight", this.sightSlot.e());
        }
    }

    @Override
    public boolean isSlotActive(we slot) {
        if (!this.hasBackpack() && this.backpackSlots.contains(slot)) {
            return false;
        }
        if ((slot == this.flashlightSlot || slot == this.sightSlot || slot == this.silencerSlot) && this.updatedWeapon != null) {
            ItemWeapon weapon = (ItemWeapon)this.updatedWeapon.b();
            if (slot == this.flashlightSlot && !weapon.flashlight || slot == this.sightSlot && !weapon.sight || slot == this.silencerSlot && !weapon.silencer) {
                return false;
            }
        }
        return true;
    }

    public void tryExtractAmmo() {
        by tag;
        if (this.updatedWeapon != null && (tag = PlayerUtils.getTag(this.updatedWeapon)).e("cage") > 0) {
            ItemWeapon item = (ItemWeapon)this.updatedWeapon.b();
            PlayerUtils.addItem(this.player, new ye(item.bulletId, tag.e("cage"), 0));
            PlayerUtils.getTag(this.updatedWeapon).a("cage", 0);
            ((jv)this.player).a(this);
        }
    }

    @Override
    public void b(uf par1EntityPlayer) {
        super.b(par1EntityPlayer);
        if (!par1EntityPlayer.q.I) {
            IPlayerServerInfo par2 = (IPlayerServerInfo)((Object)PlayerUtils.getInfo(par1EntityPlayer));
            par2.addItemSafe(par1EntityPlayer, this.updatedWeapon);
        }
    }

    @Override
    public ArrayList getArmorSlots() {
        return new ArrayList();
    }
}

