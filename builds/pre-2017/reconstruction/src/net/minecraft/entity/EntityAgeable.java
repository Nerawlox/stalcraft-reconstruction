/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.jgro;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public abstract class EntityAgeable
extends EntityCreature {
    public float field_98056_d = -1.0f;
    public float field_98057_e;

    public EntityAgeable(World world) {
        super(world);
    }

    public abstract EntityAgeable createChild(EntityAgeable var1);

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        ItemStack itemStack = entityPlayer.inventory._a();
        if (itemStack != null && itemStack._d == Item.monsterPlacer.itemID) {
            EntityAgeable entityAgeable;
            Class clazz;
            if (!this.worldObj.isRemote && (clazz = jgro._a(itemStack._j())) != null && clazz.isAssignableFrom(this.getClass()) && (entityAgeable = this.createChild(this)) != null) {
                entityAgeable.setGrowingAge(-24000);
                entityAgeable.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
                this.worldObj.spawnEntityInWorld(entityAgeable);
                if (itemStack._u()) {
                    entityAgeable.setCustomNameTag(itemStack._s());
                }
                if (!entityPlayer.capabilities._d) {
                    --itemStack._b;
                    if (itemStack._b <= 0) {
                        entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory._c, null);
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(12, new Integer(0));
    }

    public int getGrowingAge() {
        return this.dataWatcher._c(12);
    }

    public void addGrowth(int n) {
        int n2 = this.getGrowingAge();
        if ((n2 += n * 20) > 0) {
            n2 = 0;
        }
        this.setGrowingAge(n2);
    }

    public void setGrowingAge(int n) {
        this.dataWatcher._b(12, n);
        this.setScaleForAge(this.isChild());
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("Age", this.getGrowingAge());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.setGrowingAge(nBTTagCompound._f("Age"));
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.worldObj.isRemote) {
            this.setScaleForAge(this.isChild());
        } else {
            int n = this.getGrowingAge();
            if (n < 0) {
                this.setGrowingAge(++n);
            } else if (n > 0) {
                this.setGrowingAge(--n);
            }
        }
    }

    @Override
    public boolean isChild() {
        return this.getGrowingAge() < 0;
    }

    public void setScaleForAge(boolean bl) {
        this.setScale(bl ? 0.5f : 1.0f);
    }

    @Override
    public final void setSize(float f, float f2) {
        boolean bl = this.field_98056_d > 0.0f;
        this.field_98056_d = f;
        this.field_98057_e = f2;
        if (!bl) {
            this.setScale(1.0f);
        }
    }

    public final void setScale(float f) {
        super.setSize(this.field_98056_d * f, this.field_98057_e * f);
    }
}

