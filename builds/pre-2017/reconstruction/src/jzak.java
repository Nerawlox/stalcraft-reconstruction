/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.misc.pidb;
import gloomyfolken.mods.stalker.misc.tupg;
import java.util.ArrayList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class jzak
extends zwyn {
    public ArrayList<ccvh> armorSlots;
    public ArrayList<ydiu> artefaktSlots;
    protected ndjp backpackSlot;

    public jzak(EntityLivingBase entityLivingBase, IInventory ... iInventoryArray) {
        super(entityLivingBase, iInventoryArray);
    }

    @Override
    public void init() {
        rpbk rpbk2;
        int n;
        this.armorSlots = new ArrayList();
        this.artefaktSlots = new ArrayList();
        zwyn.kjui kjui2 = new zwyn.kjui();
        this.addCommonSlot(kjui2, 26, 26);
        this.addCommonSlot(kjui2, 26, 44);
        this.addCommonSlot(kjui2, 62, 26);
        this.addCommonSlot(kjui2, 62, 44);
        for (n = 0; n < 4; ++n) {
            for (int i = 0; i < 8; ++i) {
                this.addCommonSlot(kjui2, 125 + n * 18, 16 + i * 18);
            }
        }
        for (n = 0; n < 4; ++n) {
            kjui2._a();
            rpbk2 = new bagk(this, kjui2._b(), kjui2._b, 44, 62 - n * 18, 3 - n);
            this.addSlotToContainer(rpbk2);
            this.armorSlots.add((ccvh)rpbk2);
        }
        for (n = 0; n < 5; ++n) {
            kjui2._a();
            rpbk2 = new ydiu(this, kjui2._b(), kjui2._b, 8 + n * 18, 108);
            this.artefaktSlots.add((ydiu)rpbk2);
            this.addSlotToContainer(rpbk2);
        }
        for (n = 0; n < 3; ++n) {
            kjui2._a();
            this.addSlotToContainer(new vlar(this, kjui2._b(), kjui2._b, 26 + n * 18, 131));
        }
        for (n = 0; n < 4; ++n) {
            kjui2._a();
            this.addSlotToContainer(new dgnj(this, kjui2._b(), kjui2._b, 17 + n * 18, 85));
        }
        kjui2._a();
        this.backpackSlot = new ndjp(this, kjui2._b(), kjui2._b, 44, 155);
        this.addSlotToContainer(this.backpackSlot);
        this.ownedSlots = this.inventorySlots;
    }

    @Override
    public boolean hasCraftSlots() {
        return false;
    }

    private rpbk addCommonSlot(zwyn.kjui kjui2, int n, int n2) {
        kjui2._a();
        rpbk rpbk2 = new rpbk(this, kjui2._b(), kjui2._b, n, n2);
        this.addSlotToContainer(rpbk2);
        return rpbk2;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        return null;
    }

    @Override
    public ItemStack slotClick(int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (n >= 0 && !this.isSlotActive(this.getSlot(n))) {
            return null;
        }
        return super.slotClick(n, n2, n3, entityPlayer);
    }

    @Override
    public boolean func_94530_a(ItemStack itemStack, Slot slot) {
        return super.func_94530_a(itemStack, slot);
    }

    public boolean hasBackpack() {
        return this.backpackSlot.getHasStack();
    }

    @Override
    public Slot getSlot(int n) {
        return n < this.inventorySlots.size() && n >= 0 ? (Slot)this.inventorySlots.get(n) : null;
    }

    @Override
    public void putStackInSlot(int n, ItemStack itemStack) {
        Slot slot = this.getSlot(n);
        if (slot != null) {
            slot.putStack(itemStack);
        }
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
    }

    public int getArtefaktSlots() {
        ItemStack itemStack = this.owner.func_71124_b(3);
        if (itemStack != null && itemStack._a() instanceof dgmz) {
            return ((dgmz)itemStack._a())._n;
        }
        return 0;
    }

    @Override
    public void onItemsChanged() {
        if (this.isOwnerPlayer) {
            ccxr ccxr2 = ncwh._a((EntityPlayer)this.owner);
            tupg tupg2 = tupg._a(this.player);
            tupg2._c();
            tupg2._e();
            if (!ccxr2._a.worldObj.isRemote) {
                InvokeSideOnly.frontend(() -> {});
            }
        }
    }

    public ArrayList<ccvh> getArmorSlots() {
        return this.armorSlots;
    }

    public EntityLivingBase getOwner() {
        return this.owner;
    }

    @Override
    public boolean isSlotActive(Slot slot) {
        if (this.artefaktSlots.indexOf(slot) >= this.getArtefaktSlots()) {
            return false;
        }
        ItemStack itemStack = this.getArmorSlots().get(2).getStack();
        return !this.isOwnerPlayer || itemStack == null || slot != this.backpackSlot || !(itemStack._a() instanceof dgmz) || ((dgmz)itemStack._a())._k(this.backpackSlot.getStack());
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        InventoryPlayer inventoryPlayer = entityPlayer.inventory;
        if (!entityPlayer.worldObj.isRemote && inventoryPlayer._g() != null && (entityPlayer.getHealth() > 0.0f || pidb._a(inventoryPlayer._g(), entityPlayer))) {
            InvokeSideOnly.frontend(() -> {});
        }
        super.onContainerClosed(entityPlayer);
    }
}

