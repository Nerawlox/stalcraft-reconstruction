/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aaf
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mo
 *  ud
 *  vi
 *  vk
 *  wc
 *  we
 */
package ru.stalcraft.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.client.gui.GuiWeaponUpgrade;
import ru.stalcraft.inventory.ArtefaktSlot;
import ru.stalcraft.inventory.ICustomContainer;
import ru.stalcraft.inventory.SlotArmor;
import ru.stalcraft.inventory.SlotBackpack;
import ru.stalcraft.inventory.SlotDetector;
import ru.stalcraft.inventory.SlotMedicine;
import ru.stalcraft.inventory.StalkerSlot;
import ru.stalcraft.inventory.WeaponContainer;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.player.IPlayerServerInfo;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.network.ServerPacketSender;

public class StalkerContainer
extends uy
implements ICustomContainer {
    public vk craftMatrix = new vk((uy)this, 2, 2);
    public mo craftResult = new wc();
    public boolean isLocalWorld = false;
    protected final uf player;
    public final PlayerInfo info;
    private boolean hasBackpackSlots = false;
    public ArrayList backpackSlots = new ArrayList();
    public ArrayList armorSlots = new ArrayList();
    public ArrayList leftSlots = new ArrayList();
    private ArrayList hotbarSlots = new ArrayList();
    private SlotBackpack backpackSlot;

    public StalkerContainer(ud par1InventoryPlayer, boolean par2, uf par3EntityPlayer) {
        int i2;
        this.isLocalWorld = par2;
        this.player = par3EntityPlayer;
        this.info = PlayerUtils.getInfo(par3EntityPlayer);
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
            SlotArmor var8 = new SlotArmor(this, this, (mo)par1InventoryPlayer, par1InventoryPlayer.j_() - 1 - i2, 44, 8 + i2 * 18, i2);
            this.a(var8);
            this.armorSlots.add(var8);
            this.leftSlots.add(var8);
        }
        for (i2 = 0; i2 < 5; ++i2) {
            ArtefaktSlot var9 = new ArtefaktSlot(this, this, this.info.stInv, i2, 8 + i2 * 18, 108);
            this.a(var9);
            this.leftSlots.add(var9);
        }
        for (i2 = 0; i2 < 3; ++i2) {
            SlotDetector var10 = new SlotDetector(this, this, this.info.stInv, i2 + 5, 26 + i2 * 18, 131);
            this.a(var10);
            this.leftSlots.add(var10);
        }
        for (i2 = 0; i2 < 4; ++i2) {
            SlotMedicine var11 = new SlotMedicine(this, this, this.info.stInv, i2 + 8, 17 + i2 * 18, 85);
            this.a(var11);
            this.leftSlots.add(var11);
        }
        this.backpackSlot = new SlotBackpack(this, this, this.info.stInv, 12, 44, 155);
        this.a(this.backpackSlot);
        this.leftSlots.add(this.backpackSlot);
        for (i2 = 0; i2 < 8; ++i2) {
            StalkerSlot var12 = new StalkerSlot(this, this, this.info.stInv, i2 + 13, 201, 16 + i2 * 18);
            this.backpackSlots.add(var12);
            this.a(var12);
        }
        this.a((mo)this.craftMatrix);
        this.hasBackpackSlots = this.hasBackpack();
    }

    @Override
    public void a(vi par1ICrafting) {
        if (!this.e.contains(par1ICrafting)) {
            this.e.add(par1ICrafting);
        }
        par1ICrafting.a((uy)this, this.a());
        this.b();
    }

    @Override
    public void a(mo par1IInventory) {
        if (this.player != null) {
            this.craftResult.a(0, aaf.a().a(this.craftMatrix, this.player.q));
        }
    }

    @Override
    public we a(int par1) {
        return par1 < this.c.size() ? (we)this.c.get(par1) : null;
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
        if (par1 >= 0 && this.a(par1) != null && !this.isSlotActive(this.a(par1))) {
            return null;
        }
        if (par2 == 1 && par1 >= 0 && par4EntityPlayer != this.info.player && this.a(par1) != null && this.a(par1).e()) {
            if (par4EntityPlayer.bn.a(this.a(par1).d())) {
                this.a(par1).c((ye)null);
            } else if (par4EntityPlayer.q.I) {
                par4EntityPlayer.a("\u0412\u0430\u0448 \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c \u0437\u0430\u043f\u043e\u043b\u043d\u0435\u043d!");
            }
            return null;
        }
        if (par1 >= 0 && par2 == 1 && this.a(par1) != null && this.a(par1).e() && this.a(par1).d().b() instanceof ItemWeapon) {
            we slot = this.a(par1);
            ye stack = slot.d();
            if (!par4EntityPlayer.q.I) {
                par4EntityPlayer.openGui(StalkerMain.instance, 1, this.player.q, par1, 0, 0);
                ServerPacketSender.sendWindowId(par4EntityPlayer, par4EntityPlayer.bp.d);
            }
            return null;
        }
        return super.a(par1, par2, par3, par4EntityPlayer);
    }

    @SideOnly(value=Side.CLIENT)
    private void displayUpgradeGui(WeaponContainer container) {
        atv.w().a(new GuiWeaponUpgrade(container));
    }

    @Override
    public boolean a(ye par1ItemStack, we par2Slot) {
        return par2Slot.f != this.craftResult && super.a(par1ItemStack, par2Slot);
    }

    @Override
    public boolean hasBackpack() {
        return this.backpackSlot.e();
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
    public ArrayList getArmorSlots() {
        return this.armorSlots;
    }

    @Override
    public of getOwner() {
        return this.player;
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
        if (hasItemsChanged && this.info instanceof IPlayerServerInfo) {
            IPlayerServerInfo par2 = (IPlayerServerInfo)((Object)this.info);
            par2.updateWeightSpeed();
        }
    }

    @Override
    public boolean isSlotActive(we slot) {
        return this.hasBackpack() || !this.backpackSlots.contains(slot);
    }
}

