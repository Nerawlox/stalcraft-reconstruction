/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.minecart.MinecartInteractEvent;

public abstract class EntityMinecartContainer
extends EntityMinecart
implements IInventory {
    public ItemStack[] minecartContainerItems = new ItemStack[36];
    public boolean dropContentsWhenDead = true;

    public EntityMinecartContainer(World world) {
        super(world);
    }

    public EntityMinecartContainer(World world, double d, double d2, double d3) {
        super(world, d, d2, d3);
    }

    @Override
    public void killMinecart(DamageSource damageSource) {
        super.killMinecart(damageSource);
        for (int i = 0; i < this.getSizeInventory(); ++i) {
            ItemStack itemStack = this.getStackInSlot(i);
            if (itemStack == null) continue;
            float f = this.rand.nextFloat() * 0.8f + 0.1f;
            float f2 = this.rand.nextFloat() * 0.8f + 0.1f;
            float f3 = this.rand.nextFloat() * 0.8f + 0.1f;
            while (itemStack._b > 0) {
                int n = this.rand.nextInt(21) + 10;
                if (n > itemStack._b) {
                    n = itemStack._b;
                }
                itemStack._b -= n;
                EntityItem entityItem = new EntityItem(this.worldObj, this.posX + (double)f, this.posY + (double)f2, this.posZ + (double)f3, new ItemStack(itemStack._d, n, itemStack._j()));
                float f4 = 0.05f;
                entityItem.motionX = (float)this.rand.nextGaussian() * f4;
                entityItem.motionY = (float)this.rand.nextGaussian() * f4 + 0.2f;
                entityItem.motionZ = (float)this.rand.nextGaussian() * f4;
                this.worldObj.spawnEntityInWorld(entityItem);
            }
        }
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return this.minecartContainerItems[n];
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (this.minecartContainerItems[n] != null) {
            if (this.minecartContainerItems[n]._b <= n2) {
                ItemStack itemStack = this.minecartContainerItems[n];
                this.minecartContainerItems[n] = null;
                return itemStack;
            }
            ItemStack itemStack = this.minecartContainerItems[n]._a(n2);
            if (this.minecartContainerItems[n]._b == 0) {
                this.minecartContainerItems[n] = null;
            }
            return itemStack;
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        if (this.minecartContainerItems[n] != null) {
            ItemStack itemStack = this.minecartContainerItems[n];
            this.minecartContainerItems[n] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this.minecartContainerItems[n] = itemStack;
        if (itemStack != null && itemStack._b > this.getInventoryStackLimit()) {
            itemStack._b = this.getInventoryStackLimit();
        }
    }

    @Override
    public void onInventoryChanged() {
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this.isDead ? false : entityPlayer.getDistanceSqToEntity(this) <= 64.0;
    }

    @Override
    public void openChest() {
    }

    @Override
    public void closeChest() {
    }

    @Override
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return true;
    }

    @Override
    public String getInvName() {
        return this.isInvNameLocalized() ? this.func_95999_t() : "container.minecart";
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public void travelToDimension(int n) {
        this.dropContentsWhenDead = false;
        super.travelToDimension(n);
    }

    @Override
    public void setDead() {
        if (this.dropContentsWhenDead) {
            for (int i = 0; i < this.getSizeInventory(); ++i) {
                ItemStack itemStack = this.getStackInSlot(i);
                if (itemStack == null) continue;
                float f = this.rand.nextFloat() * 0.8f + 0.1f;
                float f2 = this.rand.nextFloat() * 0.8f + 0.1f;
                float f3 = this.rand.nextFloat() * 0.8f + 0.1f;
                while (itemStack._b > 0) {
                    int n = this.rand.nextInt(21) + 10;
                    if (n > itemStack._b) {
                        n = itemStack._b;
                    }
                    itemStack._b -= n;
                    EntityItem entityItem = new EntityItem(this.worldObj, this.posX + (double)f, this.posY + (double)f2, this.posZ + (double)f3, new ItemStack(itemStack._d, n, itemStack._j()));
                    if (itemStack._p()) {
                        entityItem.getEntityItem()._d((NBTTagCompound)itemStack._q()._c());
                    }
                    float f4 = 0.05f;
                    entityItem.motionX = (float)this.rand.nextGaussian() * f4;
                    entityItem.motionY = (float)this.rand.nextGaussian() * f4 + 0.2f;
                    entityItem.motionZ = (float)this.rand.nextGaussian() * f4;
                    this.worldObj.spawnEntityInWorld(entityItem);
                }
            }
        }
        super.setDead();
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this.minecartContainerItems.length; ++i) {
            if (this.minecartContainerItems[i] == null) continue;
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("Slot", (byte)i);
            this.minecartContainerItems[i]._b(nBTTagCompound2);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("Items", nBTTagList);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        NBTTagList nBTTagList = nBTTagCompound._n("Items");
        this.minecartContainerItems = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            int n = nBTTagCompound2._d("Slot") & 0xFF;
            if (n < 0 || n >= this.minecartContainerItems.length) continue;
            this.minecartContainerItems[n] = ItemStack._a(nBTTagCompound2);
        }
    }

    @Override
    public boolean interactFirst(EntityPlayer entityPlayer) {
        if (MinecraftForge.EVENT_BUS.post(new MinecartInteractEvent(this, entityPlayer))) {
            return true;
        }
        if (!this.worldObj.isRemote) {
            entityPlayer.displayGUIChest(this);
        }
        return true;
    }

    @Override
    public void applyDrag() {
        int n = 15 - Container.calcRedstoneFromInventory(this);
        float f = 0.98f + (float)n * 0.001f;
        this.motionX *= (double)f;
        this.motionY *= 0.0;
        this.motionZ *= (double)f;
    }
}

