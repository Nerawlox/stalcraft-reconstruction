/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.stalker.misc.qlgf;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.util.tdpx;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemExpireEvent;

public class EntityItem
extends Entity {
    public int age;
    public int delayBeforeCanPickup;
    public int health = 5;
    public float hoverStart = (float)(Math.random() * Math.PI * 2.0);
    public int lifespan = 6000;

    public EntityItem(World world, double d, double d2, double d3) {
        super(world);
        this.setSize(0.25f, 0.25f);
        this.yOffset = this.height / 2.0f;
        this.setPosition(d, d2, d3);
        this.rotationYaw = (float)(Math.random() * 360.0);
        this.motionX = (float)(Math.random() * (double)0.2f - (double)0.1f);
        this.motionY = 0.2f;
        this.motionZ = (float)(Math.random() * (double)0.2f - (double)0.1f);
    }

    public EntityItem(World world, double d, double d2, double d3, ItemStack itemStack) {
        this(world, d, d2, d3);
        this.setEntityItemStack(itemStack);
        this.lifespan = itemStack._a() == null ? 6000 : itemStack._a().getEntityLifespan(itemStack, world);
    }

    @Override
    public boolean canTriggerWalking() {
        return false;
    }

    public EntityItem(World world) {
        super(world);
        this.setSize(0.25f, 0.25f);
        this.yOffset = this.height / 2.0f;
    }

    @Override
    public void entityInit() {
        this.getDataWatcher()._a(10, 5);
    }

    @Override
    public void onUpdate() {
        boolean bl;
        GloomyHooks.onUpdate(this);
        ItemStack itemStack = this.getDataWatcher()._f(10);
        if (itemStack != null && itemStack._a() != null && itemStack._a().onEntityItemUpdate(this)) {
            qlgf._a(this);
            return;
        }
        super.onUpdate();
        if (this.delayBeforeCanPickup > 0) {
            --this.delayBeforeCanPickup;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= (double)0.04f;
        this.noClip = this.pushOutOfBlocks(this.posX, (this.boundingBox._c + this.boundingBox._f) / 2.0, this.posZ);
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        boolean bl2 = bl = (int)this.prevPosX != (int)this.posX || (int)this.prevPosY != (int)this.posY || (int)this.prevPosZ != (int)this.posZ;
        if (bl || this.ticksExisted % 25 == 0) {
            if (this.worldObj.getBlockMaterial(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ)) == Material._i) {
                this.motionY = 0.2f;
                this.motionX = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f;
                this.motionZ = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f;
                this.playSound("random.fizz", 0.4f, 2.0f + this.rand.nextFloat() * 0.4f);
            }
            if (!this.worldObj.isRemote) {
                this.searchForOtherItemsNearby();
            }
        }
        float f = 0.98f;
        if (this.onGround) {
            f = 0.58800006f;
            int n = this.worldObj.getBlockId(sajh._c(this.posX), sajh._c(this.boundingBox._c) - 1, sajh._c(this.posZ));
            if (n > 0) {
                f = Block.blocksList[n].slipperiness * 0.98f;
            }
        }
        this.motionX *= (double)f;
        this.motionY *= (double)0.98f;
        this.motionZ *= (double)f;
        if (this.onGround) {
            this.motionY *= -0.5;
        }
        ++this.age;
        ItemStack itemStack2 = this.getDataWatcher()._f(10);
        if (!this.worldObj.isRemote && this.age >= this.lifespan) {
            if (itemStack2 != null) {
                ItemExpireEvent itemExpireEvent = new ItemExpireEvent(this, itemStack2._a() == null ? 6000 : itemStack2._a().getEntityLifespan(itemStack2, this.worldObj));
                if (MinecraftForge.EVENT_BUS.post(itemExpireEvent)) {
                    this.lifespan += itemExpireEvent.extraLife;
                } else {
                    this.setDead();
                }
            } else {
                this.setDead();
            }
        }
        if (itemStack2 != null && itemStack2._b <= 0) {
            this.setDead();
        }
        qlgf._a(this);
    }

    public void searchForOtherItemsNearby() {
        for (EntityItem entityItem : this.worldObj.getEntitiesWithinAABB(EntityItem.class, this.boundingBox._b(0.5, 0.0, 0.5))) {
            this.combineItems(entityItem);
        }
    }

    public boolean combineItems(EntityItem entityItem) {
        if (entityItem == this) {
            return false;
        }
        if (entityItem.isEntityAlive() && this.isEntityAlive()) {
            ItemStack itemStack = this.getEntityItem();
            ItemStack itemStack2 = entityItem.getEntityItem();
            if (itemStack2._a() != itemStack._a()) {
                return false;
            }
            if (itemStack2._p() ^ itemStack._p()) {
                return false;
            }
            if (itemStack2._p() && !itemStack2._q().equals(itemStack._q())) {
                return false;
            }
            if (itemStack2._a().getHasSubtypes() && itemStack2._j() != itemStack._j()) {
                return false;
            }
            if (itemStack2._b < itemStack._b) {
                return entityItem.combineItems(this);
            }
            if (itemStack2._b + itemStack._b > itemStack2._d()) {
                return false;
            }
            itemStack2._b += itemStack._b;
            entityItem.delayBeforeCanPickup = Math.max(entityItem.delayBeforeCanPickup, this.delayBeforeCanPickup);
            entityItem.age = Math.min(entityItem.age, this.age);
            entityItem.setEntityItemStack(itemStack2);
            this.setDead();
            return true;
        }
        return false;
    }

    public void setAgeToCreativeDespawnTime() {
        this.age = 4800;
    }

    @Override
    public boolean handleWaterMovement() {
        return this.worldObj.handleMaterialAcceleration(this.boundingBox, Material._h, this);
    }

    @Override
    public void dealFireDamage(int n) {
        this.attackEntityFrom(DamageSource.inFire, n);
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        boolean bl = qlgf._a(this, damageSource, f);
        if (bl) {
            return false;
        }
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (this.getEntityItem() != null && this.getEntityItem()._d == Item.netherStar.itemID && damageSource.isExplosion()) {
            return false;
        }
        this.setBeenAttacked();
        this.health = (int)((float)this.health - f);
        if (this.health <= 0) {
            this.setDead();
        }
        return false;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Health", (short)((byte)this.health));
        nBTTagCompound._a("Age", (short)this.age);
        nBTTagCompound._a("Lifespan", this.lifespan);
        if (this.getEntityItem() != null) {
            nBTTagCompound._a("Item", this.getEntityItem()._b(new NBTTagCompound()));
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.health = nBTTagCompound._e("Health") & 0xFF;
        this.age = nBTTagCompound._e("Age");
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("Item");
        this.setEntityItemStack(ItemStack._a(nBTTagCompound2));
        ItemStack itemStack = this.getDataWatcher()._f(10);
        if (itemStack == null || itemStack._b <= 0) {
            this.setDead();
        }
        if (nBTTagCompound._c("Lifespan")) {
            this.lifespan = nBTTagCompound._f("Lifespan");
        }
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityPlayer) {
        qlgf._a(this, entityPlayer);
    }

    @Override
    public String getEntityName() {
        return tdpx._a("item." + this.getEntityItem()._m());
    }

    @Override
    public boolean canAttackWithItem() {
        return false;
    }

    @Override
    public void travelToDimension(int n) {
        super.travelToDimension(n);
        if (!this.worldObj.isRemote) {
            this.searchForOtherItemsNearby();
        }
    }

    public ItemStack getEntityItem() {
        ItemStack itemStack = this.getDataWatcher()._f(10);
        if (itemStack == null) {
            if (this.worldObj != null) {
                this.worldObj.getWorldLogAgent()._c("Item entity " + this.entityId + " has no item?!");
            }
            return new ItemStack(Block.stone);
        }
        return itemStack;
    }

    public void setEntityItemStack(ItemStack itemStack) {
        this.getDataWatcher()._b(10, itemStack);
        this.getDataWatcher()._h(10);
    }

    @Override
    public void setPositionAndRotation2(double d, double d2, double d3, float f, float f2, int n) {
    }

    @Override
    public float getShadowSize() {
        return 10.0f;
    }

    @Override
    public boolean interactFirst(EntityPlayer entityPlayer) {
        qlgf._b(this, entityPlayer);
        return true;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean pushOutOfBlocks(double d, double d2, double d3) {
        boolean bl = GloomyHooks.pushOutOfBlocks(this, d, d2, d3);
        if (bl) {
            return false;
        }
        return super.pushOutOfBlocks(d, d2, d3);
    }

    @Override
    public boolean shouldRenderInPass(int n) {
        boolean bl = GloomyHooks.shouldRenderInPass(this, n);
        return bl;
    }
}

