/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityJumpHelper;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.entity.zwat;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;

public abstract class EntityLiving
extends EntityLivingBase {
    public int livingSoundTime;
    public int experienceValue;
    public EntityLookHelper lookHelper;
    public EntityMoveHelper moveHelper;
    public EntityJumpHelper jumpHelper;
    public zwat bodyHelper;
    public PathNavigate navigator;
    public final EntityAITasks tasks;
    public final EntityAITasks targetTasks;
    public EntityLivingBase attackTarget;
    public EntitySenses senses;
    public ItemStack[] equipment = new ItemStack[5];
    public float[] equipmentDropChances = new float[5];
    public boolean canPickUpLoot;
    public boolean persistenceRequired;
    public float defaultPitch;
    public Entity currentTarget;
    public int numTicksToChaseTarget;
    public boolean isLeashed;
    public Entity leashedToEntity;
    public NBTTagCompound field_110170_bx;

    public EntityLiving(World world) {
        super(world);
        this.tasks = new EntityAITasks(world != null && world.theProfiler != null ? world.theProfiler : null);
        this.targetTasks = new EntityAITasks(world != null && world.theProfiler != null ? world.theProfiler : null);
        this.lookHelper = new EntityLookHelper(this);
        this.moveHelper = new EntityMoveHelper(this);
        this.jumpHelper = new EntityJumpHelper(this);
        this.bodyHelper = new zwat(this);
        this.navigator = new PathNavigate(this, world);
        this.senses = new EntitySenses(this);
        for (int i = 0; i < this.equipmentDropChances.length; ++i) {
            this.equipmentDropChances[i] = 0.085f;
        }
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap()._b(sajz._b)._a(16.0);
    }

    public EntityLookHelper getLookHelper() {
        return this.lookHelper;
    }

    public EntityMoveHelper getMoveHelper() {
        return this.moveHelper;
    }

    public EntityJumpHelper getJumpHelper() {
        return this.jumpHelper;
    }

    public PathNavigate getNavigator() {
        return this.navigator;
    }

    public EntitySenses getEntitySenses() {
        return this.senses;
    }

    public EntityLivingBase getAttackTarget() {
        return this.attackTarget;
    }

    public void setAttackTarget(EntityLivingBase entityLivingBase) {
        this.attackTarget = entityLivingBase;
        ForgeHooks.onLivingSetAttackTarget(this, entityLivingBase);
    }

    public boolean canAttackClass(Class clazz) {
        return EntityCreeper.class != clazz && EntityGhast.class != clazz;
    }

    public void eatGrassBonus() {
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(11, (Object)0);
        this.dataWatcher._a(10, "");
    }

    public int getTalkInterval() {
        return 80;
    }

    public void playLivingSound() {
        String string = this.getLivingSound();
        if (string != null) {
            this.playSound(string, this.getSoundVolume(), this.getSoundPitch());
        }
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        this.worldObj.theProfiler._a("mobBaseTick");
        if (this.isEntityAlive() && this.rand.nextInt(1000) < this.livingSoundTime++) {
            this.livingSoundTime = -this.getTalkInterval();
            this.playLivingSound();
        }
        this.worldObj.theProfiler._b();
    }

    @Override
    public int getExperiencePoints(EntityPlayer entityPlayer) {
        if (this.experienceValue > 0) {
            int n = this.experienceValue;
            ItemStack[] itemStackArray = this.func_70035_c();
            for (int i = 0; i < itemStackArray.length; ++i) {
                if (itemStackArray[i] == null || !(this.equipmentDropChances[i] <= 1.0f)) continue;
                n += 1 + this.rand.nextInt(3);
            }
            return n;
        }
        return this.experienceValue;
    }

    public void spawnExplosionParticle() {
        for (int i = 0; i < 20; ++i) {
            double d = this.rand.nextGaussian() * 0.02;
            double d2 = this.rand.nextGaussian() * 0.02;
            double d3 = this.rand.nextGaussian() * 0.02;
            double d4 = 10.0;
            this.worldObj.spawnParticle("explode", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width - d * d4, this.posY + (double)(this.rand.nextFloat() * this.height) - d2 * d4, this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width - d3 * d4, d, d2, d3);
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote) {
            this.func_110159_bB();
        }
    }

    @Override
    public float func_110146_f(float f, float f2) {
        if (this.isAIEnabled()) {
            this.bodyHelper._a();
            return f2;
        }
        return super.func_110146_f(f, f2);
    }

    public String getLivingSound() {
        return null;
    }

    public int getDropItemId() {
        return 0;
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
        int n2 = this.getDropItemId();
        if (n2 > 0) {
            int n3 = this.rand.nextInt(3);
            if (n > 0) {
                n3 += this.rand.nextInt(n + 1);
            }
            for (int i = 0; i < n3; ++i) {
                this.dropItem(n2, 1);
            }
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2;
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("CanPickUpLoot", this.canPickUpLoot());
        nBTTagCompound._a("PersistenceRequired", this.persistenceRequired);
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this.equipment.length; ++i) {
            nBTTagCompound2 = new NBTTagCompound();
            if (this.equipment[i] != null) {
                this.equipment[i]._b(nBTTagCompound2);
            }
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("Equipment", nBTTagList);
        NBTTagList nBTTagList2 = new NBTTagList();
        for (int i = 0; i < this.equipmentDropChances.length; ++i) {
            nBTTagList2._a(new jjly(i + "", this.equipmentDropChances[i]));
        }
        nBTTagCompound._a("DropChances", nBTTagList2);
        nBTTagCompound._a("CustomName", this.getCustomNameTag());
        nBTTagCompound._a("CustomNameVisible", this.getAlwaysRenderNameTag());
        nBTTagCompound._a("Leashed", this.isLeashed);
        if (this.leashedToEntity != null) {
            nBTTagCompound2 = new NBTTagCompound("Leash");
            if (this.leashedToEntity instanceof EntityLivingBase) {
                nBTTagCompound2._a("UUIDMost", this.leashedToEntity.getUniqueID().getMostSignificantBits());
                nBTTagCompound2._a("UUIDLeast", this.leashedToEntity.getUniqueID().getLeastSignificantBits());
            } else if (this.leashedToEntity instanceof EntityHanging) {
                EntityHanging entityHanging = (EntityHanging)this.leashedToEntity;
                nBTTagCompound2._a("X", entityHanging.xPosition);
                nBTTagCompound2._a("Y", entityHanging.yPosition);
                nBTTagCompound2._a("Z", entityHanging.zPosition);
            }
            nBTTagCompound._a("Leash", (NBTBase)nBTTagCompound2);
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        int n;
        NBTTagList nBTTagList;
        super.readEntityFromNBT(nBTTagCompound);
        this.setCanPickUpLoot(nBTTagCompound._o("CanPickUpLoot"));
        this.persistenceRequired = nBTTagCompound._o("PersistenceRequired");
        if (nBTTagCompound._c("CustomName") && nBTTagCompound._j("CustomName").length() > 0) {
            this.setCustomNameTag(nBTTagCompound._j("CustomName"));
        }
        this.setAlwaysRenderNameTag(nBTTagCompound._o("CustomNameVisible"));
        if (nBTTagCompound._c("Equipment")) {
            nBTTagList = nBTTagCompound._n("Equipment");
            for (n = 0; n < this.equipment.length; ++n) {
                this.equipment[n] = ItemStack._a((NBTTagCompound)nBTTagList._b(n));
            }
        }
        if (nBTTagCompound._c("DropChances")) {
            nBTTagList = nBTTagCompound._n("DropChances");
            for (n = 0; n < nBTTagList._d(); ++n) {
                this.equipmentDropChances[n] = ((jjly)nBTTagList._b((int)n))._c;
            }
        }
        this.isLeashed = nBTTagCompound._o("Leashed");
        if (this.isLeashed && nBTTagCompound._c("Leash")) {
            this.field_110170_bx = nBTTagCompound._m("Leash");
        }
    }

    public void setMoveForward(float f) {
        this.moveForward = f;
    }

    @Override
    public void setAIMoveSpeed(float f) {
        super.setAIMoveSpeed(f);
        this.setMoveForward(f);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.worldObj.theProfiler._a("looting");
        if (!this.worldObj.isRemote && this.canPickUpLoot() && !this.dead && this.worldObj.getGameRules()._b("mobGriefing")) {
            List list = this.worldObj.getEntitiesWithinAABB(EntityItem.class, this.boundingBox._b(1.0, 0.0, 1.0));
            for (EntityItem entityItem : list) {
                ItemStack itemStack;
                int n;
                if (entityItem.isDead || entityItem.getEntityItem() == null || (n = EntityLiving.getArmorPosition(itemStack = entityItem.getEntityItem())) <= -1) continue;
                boolean bl = true;
                ItemStack itemStack2 = this.func_71124_b(n);
                if (itemStack2 != null) {
                    Item item;
                    Item item2;
                    if (n == 0) {
                        if (itemStack._a() instanceof ItemSword && !(itemStack2._a() instanceof ItemSword)) {
                            bl = true;
                        } else if (itemStack._a() instanceof ItemSword && itemStack2._a() instanceof ItemSword) {
                            item2 = (ItemSword)itemStack._a();
                            item = (ItemSword)itemStack2._a();
                            bl = ((ItemSword)item2).func_82803_g() == ((ItemSword)item).func_82803_g() ? itemStack._j() > itemStack2._j() || itemStack._p() && !itemStack2._p() : ((ItemSword)item2).func_82803_g() > ((ItemSword)item).func_82803_g();
                        } else {
                            bl = false;
                        }
                    } else if (itemStack._a() instanceof ItemArmor && !(itemStack2._a() instanceof ItemArmor)) {
                        bl = true;
                    } else if (itemStack._a() instanceof ItemArmor && itemStack2._a() instanceof ItemArmor) {
                        item2 = (ItemArmor)itemStack._a();
                        item = (ItemArmor)itemStack2._a();
                        bl = ((ItemArmor)item2).damageReduceAmount == ((ItemArmor)item).damageReduceAmount ? itemStack._j() > itemStack2._j() || itemStack._p() && !itemStack2._p() : ((ItemArmor)item2).damageReduceAmount > ((ItemArmor)item).damageReduceAmount;
                    } else {
                        bl = false;
                    }
                }
                if (!bl) continue;
                if (itemStack2 != null && this.rand.nextFloat() - 0.1f < this.equipmentDropChances[n]) {
                    this.entityDropItem(itemStack2, 0.0f);
                }
                this.setCurrentItemOrArmor(n, itemStack);
                this.equipmentDropChances[n] = 2.0f;
                this.persistenceRequired = true;
                this.onItemPickup(entityItem, 1);
                entityItem.setDead();
            }
        }
        this.worldObj.theProfiler._b();
    }

    @Override
    public boolean isAIEnabled() {
        return false;
    }

    public boolean canDespawn() {
        return true;
    }

    public void despawnEntity() {
        Event.Result result = null;
        if (this.persistenceRequired) {
            this.entityAge = 0;
        } else if ((this.entityAge & 0x1F) == 31 && (result = ForgeEventFactory.canEntityDespawn(this)) != Event.Result.DEFAULT) {
            if (result == Event.Result.DENY) {
                this.entityAge = 0;
            } else {
                this.setDead();
            }
        } else {
            EntityPlayer entityPlayer = this.worldObj.getClosestPlayerToEntity(this, -1.0);
            if (entityPlayer != null) {
                double d = entityPlayer.posX - this.posX;
                double d2 = entityPlayer.posY - this.posY;
                double d3 = entityPlayer.posZ - this.posZ;
                double d4 = d * d + d2 * d2 + d3 * d3;
                if (this.canDespawn() && d4 > 16384.0) {
                    this.setDead();
                }
                if (this.entityAge > 600 && this.rand.nextInt(800) == 0 && d4 > 1024.0 && this.canDespawn()) {
                    this.setDead();
                } else if (d4 < 1024.0) {
                    this.entityAge = 0;
                }
            }
        }
    }

    @Override
    public void updateAITasks() {
        ++this.entityAge;
        this.worldObj.theProfiler._a("checkDespawn");
        this.despawnEntity();
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._a("sensing");
        this.senses._a();
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._a("targetSelector");
        this.targetTasks._a();
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._a("goalSelector");
        this.tasks._a();
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._a("navigation");
        this.navigator._e();
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._a("mob tick");
        this.updateAITick();
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._a("controls");
        this.worldObj.theProfiler._a("move");
        this.moveHelper._c();
        this.worldObj.theProfiler._c("look");
        this.lookHelper._a();
        this.worldObj.theProfiler._c("jump");
        this.jumpHelper._b();
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._b();
    }

    @Override
    public void updateEntityActionState() {
        super.updateEntityActionState();
        this.moveStrafing = 0.0f;
        this.moveForward = 0.0f;
        this.despawnEntity();
        float f = 8.0f;
        if (this.rand.nextFloat() < 0.02f) {
            EntityPlayer entityPlayer = this.worldObj.getClosestPlayerToEntity(this, f);
            if (entityPlayer != null) {
                this.currentTarget = entityPlayer;
                this.numTicksToChaseTarget = 10 + this.rand.nextInt(20);
            } else {
                this.randomYawVelocity = (this.rand.nextFloat() - 0.5f) * 20.0f;
            }
        }
        if (this.currentTarget != null) {
            this.faceEntity(this.currentTarget, 10.0f, this.getVerticalFaceSpeed());
            if (this.numTicksToChaseTarget-- <= 0 || this.currentTarget.isDead || this.currentTarget.getDistanceSqToEntity(this) > (double)(f * f)) {
                this.currentTarget = null;
            }
        } else {
            if (this.rand.nextFloat() < 0.05f) {
                this.randomYawVelocity = (this.rand.nextFloat() - 0.5f) * 20.0f;
            }
            this.rotationYaw += this.randomYawVelocity;
            this.rotationPitch = this.defaultPitch;
        }
        boolean bl = this.isInWater();
        boolean bl2 = this.handleLavaMovement();
        if (bl || bl2) {
            this.isJumping = this.rand.nextFloat() < 0.8f;
        }
    }

    public int getVerticalFaceSpeed() {
        return 40;
    }

    public void faceEntity(Entity entity, float f, float f2) {
        double d;
        double d2 = entity.posX - this.posX;
        double d3 = entity.posZ - this.posZ;
        if (entity instanceof EntityLivingBase) {
            EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
            d = entityLivingBase.posY + (double)entityLivingBase.getEyeHeight() - (this.posY + (double)this.getEyeHeight());
        } else {
            d = (entity.boundingBox._c + entity.boundingBox._f) / 2.0 - (this.posY + (double)this.getEyeHeight());
        }
        double d4 = sajh._a(d2 * d2 + d3 * d3);
        float f3 = (float)(Math.atan2(d3, d2) * 180.0 / Math.PI) - 90.0f;
        float f4 = (float)(-(Math.atan2(d, d4) * 180.0 / Math.PI));
        this.rotationPitch = this.updateRotation(this.rotationPitch, f4, f2);
        this.rotationYaw = this.updateRotation(this.rotationYaw, f3, f);
    }

    public float updateRotation(float f, float f2, float f3) {
        float f4 = sajh._g(f2 - f);
        if (f4 > f3) {
            f4 = f3;
        }
        if (f4 < -f3) {
            f4 = -f3;
        }
        return f + f4;
    }

    public boolean getCanSpawnHere() {
        return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    public float getRenderSizeModifier() {
        return 1.0f;
    }

    public int getMaxSpawnedInChunk() {
        return 4;
    }

    @Override
    public int getMaxSafePointTries() {
        if (this.getAttackTarget() == null) {
            return 3;
        }
        int n = (int)(this.getHealth() - this.getMaxHealth() * 0.33f);
        if ((n -= (3 - this.worldObj.difficultySetting) * 4) < 0) {
            n = 0;
        }
        return n + 3;
    }

    @Override
    public ItemStack getHeldItem() {
        return this.equipment[0];
    }

    @Override
    public ItemStack func_71124_b(int n) {
        return this.equipment[n];
    }

    public ItemStack func_130225_q(int n) {
        return this.equipment[n + 1];
    }

    @Override
    public void setCurrentItemOrArmor(int n, ItemStack itemStack) {
        this.equipment[n] = itemStack;
    }

    @Override
    public ItemStack[] func_70035_c() {
        return this.equipment;
    }

    @Override
    public void dropEquipment(boolean bl, int n) {
        for (int i = 0; i < this.func_70035_c().length; ++i) {
            boolean bl2;
            ItemStack itemStack = this.func_71124_b(i);
            boolean bl3 = bl2 = this.equipmentDropChances[i] > 1.0f;
            if (itemStack == null || !bl && !bl2 || !(this.rand.nextFloat() - (float)n * 0.01f < this.equipmentDropChances[i])) continue;
            if (!bl2 && itemStack._f()) {
                int n2 = Math.max(itemStack._k() - 25, 1);
                int n3 = itemStack._k() - this.rand.nextInt(this.rand.nextInt(n2) + 1);
                if (n3 > n2) {
                    n3 = n2;
                }
                if (n3 < 1) {
                    n3 = 1;
                }
                itemStack._b(n3);
            }
            this.entityDropItem(itemStack, 0.0f);
        }
    }

    public void addRandomArmor() {
        if (this.rand.nextFloat() < 0.15f * this.worldObj.getLocationTensionFactor(this.posX, this.posY, this.posZ)) {
            float f;
            int n = this.rand.nextInt(2);
            float f2 = f = this.worldObj.difficultySetting == 3 ? 0.1f : 0.25f;
            if (this.rand.nextFloat() < 0.095f) {
                ++n;
            }
            if (this.rand.nextFloat() < 0.095f) {
                ++n;
            }
            if (this.rand.nextFloat() < 0.095f) {
                ++n;
            }
            for (int i = 3; i >= 0; --i) {
                Item item;
                ItemStack itemStack = this.func_130225_q(i);
                if (i < 3 && this.rand.nextFloat() < f) break;
                if (itemStack != null || (item = EntityLiving.getArmorItemForSlot(i + 1, n)) == null) continue;
                this.setCurrentItemOrArmor(i + 1, new ItemStack(item));
            }
        }
    }

    public static int getArmorPosition(ItemStack itemStack) {
        if (itemStack._d != Block.pumpkin.blockID && itemStack._d != Item.skull.itemID) {
            if (itemStack._a() instanceof ItemArmor) {
                switch (((ItemArmor)itemStack._a()).armorType) {
                    case 0: {
                        return 4;
                    }
                    case 1: {
                        return 3;
                    }
                    case 2: {
                        return 2;
                    }
                    case 3: {
                        return 1;
                    }
                }
            }
            return 0;
        }
        return 4;
    }

    public static Item getArmorItemForSlot(int n, int n2) {
        switch (n) {
            case 4: {
                if (n2 == 0) {
                    return Item.helmetLeather;
                }
                if (n2 == 1) {
                    return Item.helmetGold;
                }
                if (n2 == 2) {
                    return Item.helmetChain;
                }
                if (n2 == 3) {
                    return Item.helmetIron;
                }
                if (n2 == 4) {
                    return Item.helmetDiamond;
                }
            }
            case 3: {
                if (n2 == 0) {
                    return Item.plateLeather;
                }
                if (n2 == 1) {
                    return Item.plateGold;
                }
                if (n2 == 2) {
                    return Item.plateChain;
                }
                if (n2 == 3) {
                    return Item.plateIron;
                }
                if (n2 == 4) {
                    return Item.plateDiamond;
                }
            }
            case 2: {
                if (n2 == 0) {
                    return Item.legsLeather;
                }
                if (n2 == 1) {
                    return Item.legsGold;
                }
                if (n2 == 2) {
                    return Item.legsChain;
                }
                if (n2 == 3) {
                    return Item.legsIron;
                }
                if (n2 == 4) {
                    return Item.legsDiamond;
                }
            }
            case 1: {
                if (n2 == 0) {
                    return Item.bootsLeather;
                }
                if (n2 == 1) {
                    return Item.bootsGold;
                }
                if (n2 == 2) {
                    return Item.bootsChain;
                }
                if (n2 == 3) {
                    return Item.bootsIron;
                }
                if (n2 != 4) break;
                return Item.bootsDiamond;
            }
        }
        return null;
    }

    public void enchantEquipment() {
        float f = this.worldObj.getLocationTensionFactor(this.posX, this.posY, this.posZ);
        if (this.getHeldItem() != null && this.rand.nextFloat() < 0.25f * f) {
            zhty._a(this.rand, this.getHeldItem(), (int)(5.0f + f * (float)this.rand.nextInt(18)));
        }
        for (int i = 0; i < 4; ++i) {
            ItemStack itemStack = this.func_130225_q(i);
            if (itemStack == null || !(this.rand.nextFloat() < 0.5f * f)) continue;
            zhty._a(this.rand, itemStack, (int)(5.0f + f * (float)this.rand.nextInt(18)));
        }
    }

    public EntityLivingData onSpawnWithEgg(EntityLivingData entityLivingData) {
        this.getEntityAttribute(sajz._b)._a(new AttributeModifier("Random spawn bonus", this.rand.nextGaussian() * 0.05, 1));
        return entityLivingData;
    }

    public boolean canBeSteered() {
        return false;
    }

    @Override
    public String getEntityName() {
        return this.hasCustomNameTag() ? this.getCustomNameTag() : super.getEntityName();
    }

    public void func_110163_bv() {
        this.persistenceRequired = true;
    }

    public void setCustomNameTag(String string) {
        this.dataWatcher._b(10, string);
    }

    public String getCustomNameTag() {
        return this.dataWatcher._e(10);
    }

    public boolean hasCustomNameTag() {
        return this.dataWatcher._e(10).length() > 0;
    }

    public void setAlwaysRenderNameTag(boolean bl) {
        this.dataWatcher._b(11, (byte)(bl ? 1 : 0));
    }

    public boolean getAlwaysRenderNameTag() {
        return this.dataWatcher._a(11) == 1;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean getAlwaysRenderNameTagForRender() {
        return this.getAlwaysRenderNameTag();
    }

    public void setEquipmentDropChance(int n, float f) {
        this.equipmentDropChances[n] = f;
    }

    public boolean canPickUpLoot() {
        return this.canPickUpLoot;
    }

    public void setCanPickUpLoot(boolean bl) {
        this.canPickUpLoot = bl;
    }

    public boolean isNoDespawnRequired() {
        return this.persistenceRequired;
    }

    @Override
    public final boolean interactFirst(EntityPlayer entityPlayer) {
        if (this.getLeashed() && this.getLeashedToEntity() == entityPlayer) {
            this.clearLeashed(true, !entityPlayer.capabilities._d);
            return true;
        }
        ItemStack itemStack = entityPlayer.inventory._a();
        if (itemStack != null && itemStack._d == Item.leash.itemID && this.allowLeashing()) {
            if (!(this instanceof EntityTameable) || !((EntityTameable)this).isTamed()) {
                this.setLeashedToEntity(entityPlayer, true);
                --itemStack._b;
                return true;
            }
            if (entityPlayer.getCommandSenderName().equalsIgnoreCase(((EntityTameable)this).getOwnerName())) {
                this.setLeashedToEntity(entityPlayer, true);
                --itemStack._b;
                return true;
            }
        }
        return this.interact(entityPlayer) ? true : super.interactFirst(entityPlayer);
    }

    public boolean interact(EntityPlayer entityPlayer) {
        return false;
    }

    public void func_110159_bB() {
        if (this.field_110170_bx != null) {
            this.recreateLeash();
        }
        if (this.isLeashed && (this.leashedToEntity == null || this.leashedToEntity.isDead)) {
            this.clearLeashed(true, true);
        }
    }

    public void clearLeashed(boolean bl, boolean bl2) {
        if (this.isLeashed) {
            this.isLeashed = false;
            this.leashedToEntity = null;
            if (!this.worldObj.isRemote && bl2) {
                this.dropItem(Item.leash.itemID, 1);
            }
            if (!this.worldObj.isRemote && bl && this.worldObj instanceof WorldServer) {
                ((WorldServer)this.worldObj).getEntityTracker()._a(this, new nwaj(1, this, null));
            }
        }
    }

    public boolean allowLeashing() {
        return !this.getLeashed() && !(this instanceof ezey);
    }

    public boolean getLeashed() {
        return this.isLeashed;
    }

    public Entity getLeashedToEntity() {
        return this.leashedToEntity;
    }

    public void setLeashedToEntity(Entity entity, boolean bl) {
        this.isLeashed = true;
        this.leashedToEntity = entity;
        if (!this.worldObj.isRemote && bl && this.worldObj instanceof WorldServer) {
            ((WorldServer)this.worldObj).getEntityTracker()._a(this, new nwaj(1, this, this.leashedToEntity));
        }
    }

    public void recreateLeash() {
        if (this.isLeashed && this.field_110170_bx != null) {
            if (this.field_110170_bx._c("UUIDMost") && this.field_110170_bx._c("UUIDLeast")) {
                UUID uUID = new UUID(this.field_110170_bx._g("UUIDMost"), this.field_110170_bx._g("UUIDLeast"));
                List list = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox._b(10.0, 10.0, 10.0));
                for (EntityLivingBase entityLivingBase : list) {
                    if (!entityLivingBase.getUniqueID().equals(uUID)) continue;
                    this.leashedToEntity = entityLivingBase;
                    break;
                }
            } else if (this.field_110170_bx._c("X") && this.field_110170_bx._c("Y") && this.field_110170_bx._c("Z")) {
                int n;
                int n2;
                int n3 = this.field_110170_bx._f("X");
                EntityLeashKnot entityLeashKnot = EntityLeashKnot.getKnotForBlock(this.worldObj, n3, n2 = this.field_110170_bx._f("Y"), n = this.field_110170_bx._f("Z"));
                if (entityLeashKnot == null) {
                    entityLeashKnot = EntityLeashKnot.func_110129_a(this.worldObj, n3, n2, n);
                }
                this.leashedToEntity = entityLeashKnot;
            } else {
                this.clearLeashed(false, true);
            }
        }
        this.field_110170_bx = null;
    }
}

