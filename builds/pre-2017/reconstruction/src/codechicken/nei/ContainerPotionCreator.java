/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.inventory.ContainerExtended;
import codechicken.core.inventory.SlotHandleClicks;
import codechicken.lib.inventory.InventoryNBT;
import codechicken.lib.inventory.InventoryUtils;
import codechicken.lib.packet.PacketCustom;
import codechicken.nei.NEICPH;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;

public class ContainerPotionCreator
extends ContainerExtended {
    InventoryPlayer playerInv;
    InventoryBasic potionInv;
    IInventory potionStoreInv;

    public ContainerPotionCreator(InventoryPlayer inventoryPlayer, IInventory iInventory) {
        this.playerInv = inventoryPlayer;
        this.potionInv = new InventoryBasic("Potion", true, 1);
        this.potionStoreInv = iInventory;
        this.addSlotToContainer(new SlotPotion(this.potionInv, 0, 25, 102));
        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new SlotPotionStore(iInventory, i, 8 + i * 18, 14));
        }
        this.bindPlayerInventory(inventoryPlayer, 8, 125);
    }

    @Override
    public boolean doMergeStackAreas(int n, ItemStack itemStack) {
        if (n < 10) {
            return this.mergeItemStack(itemStack, 10, 46, true);
        }
        return this.mergeItemStack(itemStack, 0, 1, false);
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);
        if (!entityPlayer.worldObj.isRemote) {
            InventoryUtils.dropOnClose(entityPlayer, this.potionInv);
        }
    }

    @Override
    public void handleInputPacket(PacketCustom packetCustom) {
        ItemStack itemStack = this.potionInv.getStackInSlot(0);
        if (itemStack == null) {
            return;
        }
        NBTTagList nBTTagList = itemStack._q()._n("CustomPotionEffects");
        if (packetCustom.readBoolean()) {
            PotionEffect potionEffect = new PotionEffect(packetCustom.readUByte(), packetCustom.readInt(), packetCustom.readUByte());
            for (int i = 0; i < nBTTagList._d(); ++i) {
                PotionEffect potionEffect2 = PotionEffect._b((NBTTagCompound)nBTTagList._b(i));
                if (potionEffect2._a() != potionEffect._a()) continue;
                nBTTagList._c.set(i, potionEffect._a(new NBTTagCompound()));
                return;
            }
            nBTTagList._a(potionEffect._a(new NBTTagCompound()));
        } else {
            int n = packetCustom.readUByte();
            int n2 = 0;
            while (n2 < nBTTagList._d()) {
                PotionEffect potionEffect = PotionEffect._b((NBTTagCompound)nBTTagList._b(n2));
                if (potionEffect._a() == n) {
                    nBTTagList._a(n2);
                    continue;
                }
                ++n2;
            }
        }
    }

    public void setPotionEffect(int n, int n2, int n3) {
        PacketCustom packetCustom = NEICPH.createContainerPacket();
        packetCustom.writeBoolean(true);
        packetCustom.writeByte(n);
        packetCustom.writeInt(n2);
        packetCustom.writeByte(n3);
        packetCustom.sendToServer();
    }

    public void removePotionEffect(int n) {
        PacketCustom packetCustom = NEICPH.createContainerPacket();
        packetCustom.writeBoolean(false);
        packetCustom.writeByte(n);
        packetCustom.sendToServer();
    }

    public static class InventoryPotionStore
    extends InventoryNBT {
        public InventoryPotionStore() {
            super(9, NEIClientConfig.global.nbt._m("potionStore"));
        }

        @Override
        public void onInventoryChanged() {
            super.onInventoryChanged();
            NEIClientConfig.global.nbt._a("potionStore", this.tag);
            NEIClientConfig.global.saveNBT();
        }
    }

    public class SlotPotionStore
    extends SlotHandleClicks {
        public SlotPotionStore(IInventory iInventory, int n, int n2, int n3) {
            super(iInventory, n, n2, n3);
        }

        @Override
        public ItemStack slotClick(ContainerExtended containerExtended, EntityPlayer entityPlayer, int n, int n2) {
            ItemStack itemStack = entityPlayer.inventory._g();
            if (n == 0 && n2 == 1) {
                NEIClientUtils.cheatItem(this.getStack(), n, -1);
            } else if (n == 1) {
                this.putStack(null);
            } else if (itemStack != null) {
                if (this.isItemValid(itemStack)) {
                    this.putStack(InventoryUtils.copyStack(itemStack, 1));
                    entityPlayer.inventory._d(null);
                }
            } else if (this.getHasStack()) {
                entityPlayer.inventory._d(this.getStack());
            }
            return null;
        }

        @Override
        public boolean isItemValid(ItemStack itemStack) {
            return itemStack._a() instanceof ItemPotion;
        }
    }

    public class SlotPotion
    extends Slot {
        public SlotPotion(IInventory iInventory, int n, int n2, int n3) {
            super(iInventory, n, n2, n3);
        }

        @Override
        public boolean isItemValid(ItemStack itemStack) {
            return itemStack._a() instanceof ItemPotion;
        }

        @Override
        public void onSlotChanged() {
            super.onSlotChanged();
            if (this.getHasStack()) {
                ItemStack itemStack = this.getStack();
                if (!itemStack._p()) {
                    itemStack._d(new NBTTagCompound("tag"));
                }
                if (!itemStack._q()._c("CustomPotionEffects")) {
                    itemStack._q()._a("CustomPotionEffects", new NBTTagList());
                }
            }
        }
    }
}

