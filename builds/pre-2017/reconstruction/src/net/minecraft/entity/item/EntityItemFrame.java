/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityItemFrame
extends EntityHanging {
    public float itemDropChance = 1.0f;

    public EntityItemFrame(World world) {
        super(world);
    }

    public EntityItemFrame(World world, int n, int n2, int n3, int n4) {
        super(world, n, n2, n3, n4);
        this.setDirection(n4);
    }

    @Override
    public void entityInit() {
        this.getDataWatcher()._a(2, 5);
        this.getDataWatcher()._a(3, (Object)0);
    }

    @Override
    public int getWidthPixels() {
        return 9;
    }

    @Override
    public int getHeightPixels() {
        return 9;
    }

    @Override
    public boolean isInRangeToRenderDist(double d) {
        double d2 = 16.0;
        return d < (d2 *= 64.0 * this.renderDistanceWeight) * d2;
    }

    @Override
    public void onBroken(Entity entity) {
        ItemStack itemStack = this.getDisplayedItem();
        if (entity instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            if (entityPlayer.capabilities._d) {
                this.removeFrameFromMap(itemStack);
                return;
            }
        }
        this.entityDropItem(new ItemStack(Item.itemFrame), 0.0f);
        if (itemStack != null && this.rand.nextFloat() < this.itemDropChance) {
            itemStack = itemStack._l();
            this.removeFrameFromMap(itemStack);
            this.entityDropItem(itemStack, 0.0f);
        }
    }

    public void removeFrameFromMap(ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }
        if (itemStack._d == Item.map.itemID) {
            thdd thdd2 = ((ItemMap)itemStack._a())._a(itemStack, this.worldObj);
            thdd2._h.remove("frame-" + this.entityId);
        }
        itemStack._a((EntityItemFrame)null);
    }

    public ItemStack getDisplayedItem() {
        return this.getDataWatcher()._f(2);
    }

    public void setDisplayedItem(ItemStack itemStack) {
        itemStack = itemStack._l();
        itemStack._b = 1;
        itemStack._a(this);
        this.getDataWatcher()._b(2, itemStack);
        this.getDataWatcher()._h(2);
    }

    public int getRotation() {
        return this.getDataWatcher()._a(3);
    }

    public void setItemRotation(int n) {
        this.getDataWatcher()._b(3, (byte)(n % 4));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        if (this.getDisplayedItem() != null) {
            nBTTagCompound._a("Item", this.getDisplayedItem()._b(new NBTTagCompound()));
            nBTTagCompound._a("ItemRotation", (byte)this.getRotation());
            nBTTagCompound._a("ItemDropChance", this.itemDropChance);
        }
        super.writeEntityToNBT(nBTTagCompound);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("Item");
        if (nBTTagCompound2 != null && !nBTTagCompound2._e()) {
            this.setDisplayedItem(ItemStack._a(nBTTagCompound2));
            this.setItemRotation(nBTTagCompound._d("ItemRotation"));
            if (nBTTagCompound._c("ItemDropChance")) {
                this.itemDropChance = nBTTagCompound._h("ItemDropChance");
            }
        }
        super.readEntityFromNBT(nBTTagCompound);
    }

    @Override
    public boolean interactFirst(EntityPlayer entityPlayer) {
        if (this.getDisplayedItem() == null) {
            ItemStack itemStack = entityPlayer.getHeldItem();
            if (itemStack != null && !this.worldObj.isRemote) {
                this.setDisplayedItem(itemStack);
                if (!entityPlayer.capabilities._d && --itemStack._b <= 0) {
                    entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory._c, null);
                }
            }
        } else if (!this.worldObj.isRemote) {
            this.setItemRotation(this.getRotation() + 1);
        }
        return true;
    }
}

