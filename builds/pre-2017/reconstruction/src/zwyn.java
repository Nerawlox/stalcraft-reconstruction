/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;

public class zwyn
extends Container {
    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    public final boolean isLocalWorld;
    public final EntityLivingBase owner;
    public final boolean isOwnerPlayer;
    public EntityPlayer player;
    public IInventory[] inventories;
    public NBTTagCompound containerData = new NBTTagCompound();
    protected List<Slot> ownedSlots = new ArrayList<Slot>();

    public zwyn(EntityLivingBase entityLivingBase, IInventory ... iInventoryArray) {
        this.isLocalWorld = entityLivingBase.worldObj.isRemote;
        this.owner = entityLivingBase;
        this.isOwnerPlayer = entityLivingBase instanceof EntityPlayer;
        this.inventories = iInventoryArray;
        if (this.isOwnerPlayer) {
            this.player = (EntityPlayer)entityLivingBase;
        }
        this.init();
    }

    public void init() {
        Slot slot;
        int n;
        int n2;
        if (this.hasCraftSlots() && this.isOwnerPlayer) {
            this.craftMatrix = new InventoryCrafting(this, 2, 2);
            this.craftResult = new InventoryCraftResult();
            this.addSlotToContainer(new pkzb(this.player, this.craftMatrix, this.craftResult, 0, 144, 36));
            for (n2 = 0; n2 < 2; ++n2) {
                for (n = 0; n < 2; ++n) {
                    this.addSlotToContainer(new Slot(this.craftMatrix, n + n2 * 2, 88 + n * 18, 26 + n2 * 18));
                }
            }
        }
        IInventory iInventory = this.inventories[0];
        for (n2 = 0; n2 < 9; ++n2) {
            slot = new Slot(iInventory, n2, 8 + n2 * 18, 142);
            this.ownedSlots.add(slot);
            this.addSlotToContainer(slot);
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                slot = new Slot(iInventory, n + (n2 + 1) * 9, 8 + n * 18, 84 + n2 * 18);
                this.ownedSlots.add(slot);
                this.addSlotToContainer(slot);
            }
        }
        for (n2 = 0; n2 < 4; ++n2) {
            slot = new ccvh(this, iInventory, iInventory.getSizeInventory() - 1 - n2, 8, 8 + n2 * 18, n2);
            this.addSlotToContainer(slot);
            this.ownedSlots.add(slot);
        }
        if (this.hasCraftSlots() && this.isOwnerPlayer) {
            this.onCraftMatrixChanged(this.craftMatrix);
        }
    }

    public List<Slot> getOwnedSlots() {
        return this.ownedSlots;
    }

    public void onArmorChanged() {
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            int n2;
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
            if (n == 0) {
                if (!this.mergeItemStack(itemStack2, 5, 41, true)) {
                    return null;
                }
                slot.onSlotChange(itemStack2, itemStack);
            } else if (n >= 1 && n < 5 ? !this.mergeItemStack(itemStack2, 5, 41, false) : (n >= 41 && n < 45 ? !this.mergeItemStack(itemStack2, 5, 41, false) : (itemStack._a() instanceof ItemArmor && !((Slot)this.inventorySlots.get(41 + ((ItemArmor)itemStack._a()).armorType)).getHasStack() ? !this.mergeItemStack(itemStack2, n2 = 41 + ((ItemArmor)itemStack._a()).armorType, n2 + 1, false) : (n >= 5 && n < 32 ? !this.mergeItemStack(itemStack2, 32, 41, false) : (n >= 32 && n < 41 ? !this.mergeItemStack(itemStack2, 5, 32, false) : !this.mergeItemStack(itemStack2, 5, 41, false)))))) {
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

    @Override
    public void onCraftMatrixChanged(IInventory iInventory) {
        if (this.player != null) {
            ItemStack itemStack = CraftingManager._a()._a(this.craftMatrix, this.player.worldObj);
            this.craftResult.setInventorySlotContents(0, itemStack);
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        jhla.kjui kjui2 = new jhla.kjui(this.owner, this, entityPlayer);
        MinecraftForge.EVENT_BUS.post(kjui2);
        switch (kjui2.getResult()) {
            case ALLOW: {
                return true;
            }
            case DENY: {
                return false;
            }
        }
        return entityPlayer == this.owner;
    }

    @Override
    public ItemStack slotClick(int n, int n2, int n3, EntityPlayer entityPlayer) {
        jhla.ezey ezey2 = new jhla.ezey(this.owner, this, entityPlayer, n, n2, n3);
        MinecraftForge.EVENT_BUS.post(ezey2);
        if (ezey2.isCanceled()) {
            return null;
        }
        return super.slotClick(n, n2, n3, entityPlayer);
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        if (this.hasCraftSlots() && this.isOwnerPlayer) {
            for (int i = 0; i < 4; ++i) {
                ItemStack itemStack = this.craftMatrix.getStackInSlotOnClosing(i);
                if (itemStack == null) continue;
                entityPlayer.dropPlayerItem(itemStack);
            }
            this.craftResult.setInventorySlotContents(0, null);
        }
        super.onContainerClosed(entityPlayer);
        MinecraftForge.EVENT_BUS.post(new jhla.pidb(this.owner, this, entityPlayer));
    }

    @Override
    public void detectAndSendChanges() {
        boolean bl = false;
        HashMap<Integer, ItemStack> hashMap = new HashMap<Integer, ItemStack>();
        HashMap<Integer, ItemStack> hashMap2 = new HashMap<Integer, ItemStack>();
        for (int i = 0; i < this.inventorySlots.size(); ++i) {
            ItemStack itemStack = ((Slot)this.inventorySlots.get(i)).getStack();
            ItemStack itemStack2 = (ItemStack)this.inventoryItemStacks.get(i);
            if (ItemStack._b(itemStack2, itemStack)) continue;
            bl = true;
            hashMap.put(i, itemStack == null ? null : itemStack._l());
            hashMap2.put(i, itemStack2);
            itemStack2 = itemStack == null ? null : itemStack._l();
            this.inventoryItemStacks.set(i, itemStack2);
            for (int j = 0; j < this.crafters.size(); ++j) {
                ((ICrafting)this.crafters.get(j)).sendSlotContents(this, i, itemStack2);
            }
        }
        if (bl) {
            this.onItemsChanged();
            MinecraftForge.EVENT_BUS.post(new jhla.eidj(this.owner, this, hashMap, hashMap2));
        }
    }

    public void onItemsChanged() {
    }

    public boolean isSlotActive(Slot slot) {
        return true;
    }

    public boolean hasCraftSlots() {
        return true;
    }

    public class kjui {
        public int _a;
        public int _b = -1;

        public kjui _a() {
            if (this._a >= zwyn.this.inventories.length) {
                throw new RuntimeException("Not enough slots!");
            }
            IInventory iInventory = zwyn.this.inventories[this._a];
            if (++this._b >= iInventory.getSizeInventory()) {
                this._b = 0;
                ++this._a;
            }
            return this;
        }

        public IInventory _b() {
            return zwyn.this.inventories[this._a];
        }
    }
}

