/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.inventory;

import codechicken.lib.inventory.InventoryRange;
import com.google.common.base.Objects;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class InventoryUtils {
    public static final ForgeDirection[] chestSides = new ForgeDirection[]{ForgeDirection.WEST, ForgeDirection.EAST, ForgeDirection.NORTH, ForgeDirection.SOUTH};

    public static ItemStack decrStackSize(IInventory iInventory, int n, int n2) {
        ItemStack itemStack = iInventory.getStackInSlot(n);
        if (itemStack != null) {
            if (itemStack._b <= n2) {
                ItemStack itemStack2 = itemStack;
                iInventory.setInventorySlotContents(n, null);
                iInventory.onInventoryChanged();
                return itemStack2;
            }
            ItemStack itemStack3 = itemStack._a(n2);
            if (itemStack._b == 0) {
                iInventory.setInventorySlotContents(n, null);
            }
            iInventory.onInventoryChanged();
            return itemStack3;
        }
        return null;
    }

    public static ItemStack getStackInSlotOnClosing(IInventory iInventory, int n) {
        ItemStack itemStack = iInventory.getStackInSlot(n);
        iInventory.setInventorySlotContents(n, null);
        return itemStack;
    }

    public static int incrStackSize(ItemStack itemStack, ItemStack itemStack2) {
        if (InventoryUtils.canStack(itemStack, itemStack2)) {
            return InventoryUtils.incrStackSize(itemStack, itemStack2._b);
        }
        return 0;
    }

    public static int incrStackSize(ItemStack itemStack, int n) {
        int n2 = itemStack._b + n;
        if (n2 <= itemStack._d()) {
            return n;
        }
        if (itemStack._b < itemStack._d()) {
            return itemStack._d() - itemStack._b;
        }
        return 0;
    }

    public static NBTTagList writeItemStacksToTag(ItemStack[] itemStackArray) {
        return InventoryUtils.writeItemStacksToTag(itemStackArray, 64);
    }

    public static NBTTagList writeItemStacksToTag(ItemStack[] itemStackArray, int n) {
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < itemStackArray.length; ++i) {
            if (itemStackArray[i] == null) continue;
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Slot", (short)i);
            itemStackArray[i]._b(nBTTagCompound);
            if (n > Short.MAX_VALUE) {
                nBTTagCompound._a("Quantity", itemStackArray[i]._b);
            } else if (n > 127) {
                nBTTagCompound._a("Quantity", (short)itemStackArray[i]._b);
            }
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public static void readItemStacksFromTag(ItemStack[] itemStackArray, NBTTagList nBTTagList) {
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            short s = nBTTagCompound._e("Slot");
            itemStackArray[s] = ItemStack._a(nBTTagCompound);
            if (!nBTTagCompound._c("Quantity")) continue;
            NBTBase nBTBase = nBTTagCompound._b("Quantity");
            if (nBTBase instanceof hdfw) {
                itemStackArray[s]._b = ((hdfw)nBTBase)._c;
                continue;
            }
            if (!(nBTBase instanceof ixnt)) continue;
            itemStackArray[s]._b = ((ixnt)nBTBase)._c;
        }
    }

    public static ItemStack copyStack(ItemStack itemStack, int n) {
        if (itemStack == null) {
            return null;
        }
        itemStack = itemStack._l();
        itemStack._b = n;
        return itemStack;
    }

    public static int getInsertibleQuantity(InventoryRange inventoryRange, ItemStack itemStack) {
        int n = 0;
        itemStack = InventoryUtils.copyStack(itemStack, Integer.MAX_VALUE);
        for (int n2 : inventoryRange.slots) {
            n += InventoryUtils.fitStackInSlot(inventoryRange, n2, itemStack);
        }
        return n;
    }

    public static int getInsertibleQuantity(IInventory iInventory, ItemStack itemStack) {
        return InventoryUtils.getInsertibleQuantity(new InventoryRange(iInventory), itemStack);
    }

    public static int fitStackInSlot(InventoryRange inventoryRange, int n, ItemStack itemStack) {
        ItemStack itemStack2 = inventoryRange.inv.getStackInSlot(n);
        if (!InventoryUtils.canStack(itemStack2, itemStack) || !inventoryRange.canInsertItem(n, itemStack)) {
            return 0;
        }
        int n2 = itemStack2 != null ? InventoryUtils.incrStackSize(itemStack2, inventoryRange.inv.getInventoryStackLimit() - itemStack2._b) : inventoryRange.inv.getInventoryStackLimit();
        return Math.min(n2, itemStack._b);
    }

    public static int fitStackInSlot(IInventory iInventory, int n, ItemStack itemStack) {
        return InventoryUtils.fitStackInSlot(new InventoryRange(iInventory), n, itemStack);
    }

    public static int insertItem(InventoryRange inventoryRange, ItemStack itemStack, boolean bl) {
        itemStack = itemStack._l();
        for (int i = 0; i < 2; ++i) {
            for (int n : inventoryRange.slots) {
                ItemStack itemStack2 = inventoryRange.inv.getStackInSlot(n);
                int n2 = InventoryUtils.fitStackInSlot(inventoryRange, n, itemStack);
                if (n2 == 0) continue;
                if (itemStack2 != null) {
                    itemStack._b -= n2;
                    if (!bl) {
                        itemStack2._b += n2;
                        inventoryRange.inv.setInventorySlotContents(n, itemStack2);
                    }
                } else if (i == 1) {
                    if (!bl) {
                        inventoryRange.inv.setInventorySlotContents(n, InventoryUtils.copyStack(itemStack, n2));
                    }
                    itemStack._b -= n2;
                }
                if (itemStack._b != 0) continue;
                return 0;
            }
        }
        return itemStack._b;
    }

    public static int insertItem(IInventory iInventory, ItemStack itemStack, boolean bl) {
        return InventoryUtils.insertItem(new InventoryRange(iInventory), itemStack, bl);
    }

    public static ItemStack getExtractableStack(InventoryRange inventoryRange, int n) {
        ItemStack itemStack = inventoryRange.inv.getStackInSlot(n);
        if (itemStack == null || !inventoryRange.canExtractItem(n, itemStack)) {
            return null;
        }
        return itemStack;
    }

    public static ItemStack getExtractableStack(IInventory iInventory, int n) {
        return InventoryUtils.getExtractableStack(new InventoryRange(iInventory), n);
    }

    public static boolean areStacksIdentical(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack == null || itemStack2 == null) {
            return itemStack == itemStack2;
        }
        return itemStack._d == itemStack2._d && itemStack._j() == itemStack2._j() && itemStack._b == itemStack2._b && Objects.equal(itemStack._q(), itemStack2._q());
    }

    public static IInventory getInventory(World world, int n, int n2, int n3) {
        TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
        if (!(tileEntity instanceof IInventory)) {
            return null;
        }
        if (tileEntity instanceof TileEntityChest) {
            return InventoryUtils.getChest((TileEntityChest)tileEntity);
        }
        return (IInventory)((Object)tileEntity);
    }

    public static IInventory getChest(TileEntityChest tileEntityChest) {
        for (ForgeDirection forgeDirection : chestSides) {
            if (tileEntityChest.worldObj.getBlockId(tileEntityChest.xCoord + forgeDirection.offsetX, tileEntityChest.yCoord + forgeDirection.offsetY, tileEntityChest.zCoord + forgeDirection.offsetZ) != tileEntityChest.getBlockType().blockID) continue;
            return new huew("container.chestDouble", (TileEntityChest)tileEntityChest.worldObj.getBlockTileEntity(tileEntityChest.xCoord + forgeDirection.offsetX, tileEntityChest.yCoord + forgeDirection.offsetY, tileEntityChest.zCoord + forgeDirection.offsetZ), tileEntityChest);
        }
        return tileEntityChest;
    }

    public static boolean canStack(ItemStack itemStack, ItemStack itemStack2) {
        return itemStack == null || itemStack2 == null || itemStack._d == itemStack2._d && (!itemStack2._g() || itemStack2._j() == itemStack._j()) && ItemStack._a(itemStack2, itemStack) && itemStack._e();
    }

    public static void consumeItem(IInventory iInventory, int n) {
        ItemStack itemStack = iInventory.getStackInSlot(n);
        Item item = itemStack._a();
        if (item.hasContainerItem()) {
            ItemStack itemStack2 = item.getContainerItemStack(itemStack);
            iInventory.setInventorySlotContents(n, itemStack2);
        } else {
            iInventory.decrStackSize(n, 1);
        }
    }

    public static int stackSize(IInventory iInventory, int n) {
        ItemStack itemStack = iInventory.getStackInSlot(n);
        return itemStack == null ? 0 : itemStack._b;
    }

    public static void dropOnClose(EntityPlayer entityPlayer, IInventory iInventory) {
        for (int i = 0; i < iInventory.getSizeInventory(); ++i) {
            ItemStack itemStack = iInventory.getStackInSlotOnClosing(i);
            if (itemStack == null) continue;
            entityPlayer.dropPlayerItem(itemStack);
        }
    }

    public static int actualDamage(ItemStack itemStack) {
        return Item.diamond.getDamage(itemStack);
    }
}

