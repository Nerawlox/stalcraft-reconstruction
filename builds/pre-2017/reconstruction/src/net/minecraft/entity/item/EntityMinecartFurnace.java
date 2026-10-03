/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.minecart.MinecartInteractEvent;

public class EntityMinecartFurnace
extends EntityMinecart {
    public int fuel;
    public double pushX;
    public double pushZ;

    public EntityMinecartFurnace(World world) {
        super(world);
    }

    public EntityMinecartFurnace(World world, double d, double d2, double d3) {
        super(world, d, d2, d3);
    }

    @Override
    public int getMinecartType() {
        return 2;
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(16, new Byte(0));
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.fuel > 0) {
            --this.fuel;
        }
        if (this.fuel <= 0) {
            this.pushZ = 0.0;
            this.pushX = 0.0;
        }
        this.setMinecartPowered(this.fuel > 0);
        if (this.isMinecartPowered() && this.rand.nextInt(4) == 0) {
            this.worldObj.spawnParticle("largesmoke", this.posX, this.posY + 0.8, this.posZ, 0.0, 0.0, 0.0);
        }
    }

    @Override
    public void killMinecart(DamageSource damageSource) {
        super.killMinecart(damageSource);
        if (!damageSource.isExplosion()) {
            this.entityDropItem(new ItemStack(Block.furnaceIdle, 1), 0.0f);
        }
    }

    @Override
    public void updateOnTrack(int n, int n2, int n3, double d, double d2, int n4, int n5) {
        super.updateOnTrack(n, n2, n3, d, d2, n4, n5);
        double d3 = this.pushX * this.pushX + this.pushZ * this.pushZ;
        if (d3 > 1.0E-4 && this.motionX * this.motionX + this.motionZ * this.motionZ > 0.001) {
            d3 = sajh._a(d3);
            this.pushX /= d3;
            this.pushZ /= d3;
            if (this.pushX * this.motionX + this.pushZ * this.motionZ < 0.0) {
                this.pushX = 0.0;
                this.pushZ = 0.0;
            } else {
                this.pushX = this.motionX;
                this.pushZ = this.motionZ;
            }
        }
    }

    @Override
    public void applyDrag() {
        double d = this.pushX * this.pushX + this.pushZ * this.pushZ;
        if (d > 1.0E-4) {
            d = sajh._a(d);
            this.pushX /= d;
            this.pushZ /= d;
            double d2 = 0.05;
            this.motionX *= (double)0.8f;
            this.motionY *= 0.0;
            this.motionZ *= (double)0.8f;
            this.motionX += this.pushX * d2;
            this.motionZ += this.pushZ * d2;
        } else {
            this.motionX *= (double)0.98f;
            this.motionY *= 0.0;
            this.motionZ *= (double)0.98f;
        }
        super.applyDrag();
    }

    @Override
    public boolean interactFirst(EntityPlayer entityPlayer) {
        if (MinecraftForge.EVENT_BUS.post(new MinecartInteractEvent(this, entityPlayer))) {
            return true;
        }
        ItemStack itemStack = entityPlayer.inventory._a();
        if (itemStack != null && itemStack._d == Item.coal.itemID) {
            if (!entityPlayer.capabilities._d && --itemStack._b == 0) {
                entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory._c, null);
            }
            this.fuel += 3600;
        }
        this.pushX = this.posX - entityPlayer.posX;
        this.pushZ = this.posZ - entityPlayer.posZ;
        return true;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("PushX", this.pushX);
        nBTTagCompound._a("PushZ", this.pushZ);
        nBTTagCompound._a("Fuel", (short)this.fuel);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.pushX = nBTTagCompound._i("PushX");
        this.pushZ = nBTTagCompound._i("PushZ");
        this.fuel = nBTTagCompound._e("Fuel");
    }

    public boolean isMinecartPowered() {
        return (this.dataWatcher._a(16) & 1) != 0;
    }

    public void setMinecartPowered(boolean bl) {
        if (bl) {
            this.dataWatcher._b(16, (byte)(this.dataWatcher._a(16) | 1));
        } else {
            this.dataWatcher._b(16, (byte)(this.dataWatcher._a(16) & 0xFFFFFFFE));
        }
    }

    @Override
    public Block getDefaultDisplayTile() {
        return Block.furnaceBurning;
    }

    @Override
    public int getDefaultDisplayTileData() {
        return 2;
    }
}

