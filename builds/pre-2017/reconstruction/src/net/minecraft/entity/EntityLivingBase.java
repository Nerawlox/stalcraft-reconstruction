/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.stalker.misc.qlgf;
import gloomyfolken.mods.stalker.player.ugqx;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.ServersideAttributeMap;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.ForgeHooks;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRendererList;

public abstract class EntityLivingBase
extends Entity {
    public static final UUID sprintingSpeedBoostModifierUUID = UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D");
    public static final AttributeModifier sprintingSpeedBoostModifier = new AttributeModifier(sprintingSpeedBoostModifierUUID, "Sprinting speed boost", 0.3f, 2)._a(false);
    public BaseAttributeMap attributeMap;
    public final CombatTracker _combatTracker = new CombatTracker(this);
    public final HashMap activePotionsMap = new HashMap();
    public final ItemStack[] previousEquipment = new ItemStack[5];
    public boolean isSwingInProgress;
    public int swingProgressInt;
    public int arrowHitTimer;
    public float prevHealth;
    public int hurtTime;
    public int maxHurtTime;
    public float attackedAtYaw;
    public int deathTime;
    public int attackTime;
    public float prevSwingProgress;
    public float swingProgress;
    public float prevLimbSwingAmount;
    public float limbSwingAmount;
    public float limbSwing;
    public int maxHurtResistantTime = 20;
    public float prevCameraPitch;
    public float cameraPitch;
    public float field_70769_ao;
    public float field_70770_ap;
    public float renderYawOffset;
    public float prevRenderYawOffset;
    public float rotationYawHead;
    public float prevRotationYawHead;
    public float jumpMovementFactor = 0.02f;
    public EntityPlayer attackingPlayer;
    public int recentlyHit;
    public boolean dead;
    public int entityAge;
    public float field_70768_au;
    public float field_110154_aX;
    public float field_70764_aw;
    public float field_70763_ax;
    public float field_70741_aB;
    public int scoreValue;
    public float lastDamage;
    public boolean isJumping;
    public float moveStrafing;
    public float moveForward;
    public float randomYawVelocity;
    public int newPosRotationIncrements;
    public double newPosX;
    public double newPosY;
    public double newPosZ;
    public double newRotationYaw;
    public double newRotationPitch;
    public boolean potionsNeedUpdate = true;
    public EntityLivingBase entityLivingToAttack;
    public int revengeTimer;
    public EntityLivingBase lastAttacker;
    public int lastAttackerTime;
    public float landMovementFactor;
    public int jumpTicks;
    public float field_110151_bq;

    public EntityLivingBase(World world) {
        super(world);
        this.applyEntityAttributes();
        this.setHealth(this.getMaxHealth());
        this.preventEntitySpawning = true;
        this.field_70770_ap = (float)(Math.random() + 1.0) * 0.01f;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.field_70769_ao = (float)Math.random() * 12398.0f;
        this.rotationYawHead = this.rotationYaw = (float)(Math.random() * Math.PI * 2.0);
        this.stepHeight = 0.5f;
        GloomyHooks.setRenderDistanceWeight(this);
        GloomyHooks.onEntityLivingBaseInit(this, world);
    }

    @Override
    public void entityInit() {
        this.dataWatcher._a(7, (Object)0);
        this.dataWatcher._a(8, (Object)0);
        this.dataWatcher._a(9, (Object)0);
        this.dataWatcher._a(6, Float.valueOf(1.0f));
    }

    public void applyEntityAttributes() {
        this.getAttributeMap()._b(sajz._a);
        this.getAttributeMap()._b(sajz._c);
        this.getAttributeMap()._b(sajz._d);
        if (!this.isAIEnabled()) {
            this.getEntityAttribute(sajz._d)._a(0.1f);
        }
    }

    @Override
    public void updateFallState(double d, boolean bl) {
        if (!this.isInWater()) {
            this.handleWaterMovement();
        }
        if (bl && this.fallDistance > 0.0f) {
            int n;
            int n2;
            int n3;
            int n4 = sajh._c(this.posX);
            int n5 = this.worldObj.getBlockId(n4, n3 = sajh._c(this.posY - (double)0.2f - (double)this.yOffset), n2 = sajh._c(this.posZ));
            if (n5 == 0 && ((n = this.worldObj.blockGetRenderType(n4, n3 - 1, n2)) == 11 || n == 32 || n == 21)) {
                n5 = this.worldObj.getBlockId(n4, n3 - 1, n2);
            }
            if (n5 > 0) {
                Block.blocksList[n5].onFallenUpon(this.worldObj, n4, n3, n2, this, this.fallDistance);
            }
        }
        super.updateFallState(d, bl);
    }

    public boolean canBreatheUnderwater() {
        return false;
    }

    @Override
    public void onEntityUpdate() {
        boolean bl;
        this.prevSwingProgress = this.swingProgress;
        super.onEntityUpdate();
        this.worldObj.theProfiler._a("livingEntityBaseTick");
        if (this.isEntityAlive() && this.isEntityInsideOpaqueBlock()) {
            this.attackEntityFrom(DamageSource.inWall, 1.0f);
        }
        if (this.isImmuneToFire() || this.worldObj.isRemote) {
            this.extinguish();
        }
        boolean bl2 = bl = this instanceof EntityPlayer && ((EntityPlayer)this).capabilities._a;
        if (this.isEntityAlive() && this.isInsideOfMaterial(Material._h)) {
            if (!(this.canBreatheUnderwater() || this.isPotionActive(Potion._o._H) || bl)) {
                this.setAir(this.decreaseAirSupply(this.getAir()));
                if (this.getAir() == -20) {
                    this.setAir(0);
                    for (int i = 0; i < 8; ++i) {
                        float f = this.rand.nextFloat() - this.rand.nextFloat();
                        float f2 = this.rand.nextFloat() - this.rand.nextFloat();
                        float f3 = this.rand.nextFloat() - this.rand.nextFloat();
                        this.worldObj.spawnParticle("bubble", this.posX + (double)f, this.posY + (double)f2, this.posZ + (double)f3, this.motionX, this.motionY, this.motionZ);
                    }
                    this.attackEntityFrom(DamageSource.drown, 2.0f);
                }
            }
            this.extinguish();
            if (!this.worldObj.isRemote && this.isRiding() && this.ridingEntity != null && this.ridingEntity.shouldDismountInWater(this)) {
                this.mountEntity(null);
            }
        } else {
            this.setAir(300);
        }
        this.prevCameraPitch = this.cameraPitch;
        if (this.attackTime > 0) {
            --this.attackTime;
        }
        if (this.hurtTime > 0) {
            --this.hurtTime;
        }
        if (this.hurtResistantTime > 0) {
            --this.hurtResistantTime;
        }
        if (this.getHealth() <= 0.0f) {
            this.onDeathUpdate();
        }
        if (this.recentlyHit > 0) {
            --this.recentlyHit;
        } else {
            this.attackingPlayer = null;
        }
        if (this.lastAttacker != null && !this.lastAttacker.isEntityAlive()) {
            this.lastAttacker = null;
        }
        if (this.entityLivingToAttack != null && !this.entityLivingToAttack.isEntityAlive()) {
            this.setRevengeTarget(null);
        }
        this.updatePotionEffects();
        this.field_70763_ax = this.field_70764_aw;
        this.prevRenderYawOffset = this.renderYawOffset;
        this.prevRotationYawHead = this.rotationYawHead;
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
        this.worldObj.theProfiler._b();
    }

    public boolean isChild() {
        return false;
    }

    public void onDeathUpdate() {
        ++this.deathTime;
        if (this.deathTime == 20) {
            int n;
            if (!this.worldObj.isRemote && (this.recentlyHit > 0 || this.isPlayer()) && !this.isChild() && this.worldObj.getGameRules()._b("doMobLoot")) {
                int n2;
                for (n = this.getExperiencePoints(this.attackingPlayer); n > 0; n -= n2) {
                    n2 = EntityXPOrb.getXPSplit(n);
                    this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, n2));
                }
            }
            this.setDead();
            for (n = 0; n < 20; ++n) {
                double d = this.rand.nextGaussian() * 0.02;
                double d2 = this.rand.nextGaussian() * 0.02;
                double d3 = this.rand.nextGaussian() * 0.02;
                this.worldObj.spawnParticle("explode", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, d, d2, d3);
            }
        }
    }

    public int decreaseAirSupply(int n) {
        int n2 = zhty._b(this);
        return n2 > 0 && this.rand.nextInt(n2 + 1) > 0 ? n : n - 1;
    }

    public int getExperiencePoints(EntityPlayer entityPlayer) {
        return 0;
    }

    public boolean isPlayer() {
        return false;
    }

    public Random getRNG() {
        return this.rand;
    }

    public EntityLivingBase getAITarget() {
        return this.entityLivingToAttack;
    }

    public int func_142015_aE() {
        return this.revengeTimer;
    }

    public void setRevengeTarget(EntityLivingBase entityLivingBase) {
        this.entityLivingToAttack = entityLivingBase;
        this.revengeTimer = this.ticksExisted;
        ForgeHooks.onLivingSetAttackTarget(this, entityLivingBase);
    }

    public EntityLivingBase getLastAttacker() {
        return this.lastAttacker;
    }

    public int getLastAttackerTime() {
        return this.lastAttackerTime;
    }

    public void setLastAttacker(Entity entity) {
        this.lastAttacker = entity instanceof EntityLivingBase ? (EntityLivingBase)entity : null;
        this.lastAttackerTime = this.ticksExisted;
    }

    public int getAge() {
        return this.entityAge;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("HealF", this.getHealth());
        nBTTagCompound._a("Health", (short)Math.ceil(this.getHealth()));
        nBTTagCompound._a("HurtTime", (short)this.hurtTime);
        nBTTagCompound._a("DeathTime", (short)this.deathTime);
        nBTTagCompound._a("AttackTime", (short)this.attackTime);
        nBTTagCompound._a("AbsorptionAmount", this.getAbsorptionAmount());
        for (ItemStack itemStack : this.func_70035_c()) {
            if (itemStack == null) continue;
            this.attributeMap._a(itemStack._D());
        }
        nBTTagCompound._a("Attributes", sajz._a(this.getAttributeMap()));
        for (ItemStack itemStack : this.func_70035_c()) {
            if (itemStack == null) continue;
            this.attributeMap._b(itemStack._D());
        }
        if (!this.activePotionsMap.isEmpty()) {
            NBTTagList nBTTagList = new NBTTagList();
            for (PotionEffect potionEffect : this.activePotionsMap.values()) {
                nBTTagList._a(potionEffect._a(new NBTTagCompound()));
            }
            nBTTagCompound._a("ActiveEffects", nBTTagList);
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        NBTBase nBTBase;
        this.setAbsorptionAmount(nBTTagCompound._h("AbsorptionAmount"));
        if (nBTTagCompound._c("Attributes") && this.worldObj != null && !this.worldObj.isRemote) {
            sajz._a(this.getAttributeMap(), nBTTagCompound._n("Attributes"), this.worldObj == null ? null : this.worldObj.getWorldLogAgent());
        }
        if (nBTTagCompound._c("ActiveEffects")) {
            nBTBase = nBTTagCompound._n("ActiveEffects");
            for (int i = 0; i < ((NBTTagList)nBTBase)._d(); ++i) {
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)((NBTTagList)nBTBase)._b(i);
                PotionEffect potionEffect = PotionEffect._b(nBTTagCompound2);
                this.activePotionsMap.put(potionEffect._a(), potionEffect);
            }
        }
        if (nBTTagCompound._c("HealF")) {
            this.setHealth(nBTTagCompound._h("HealF"));
        } else {
            nBTBase = nBTTagCompound._b("Health");
            if (nBTBase == null) {
                this.setHealth(this.getMaxHealth());
            } else if (nBTBase._a() == 5) {
                this.setHealth(((jjly)nBTBase)._c);
            } else if (nBTBase._a() == 2) {
                this.setHealth(((ixnt)nBTBase)._c);
            }
        }
        this.hurtTime = nBTTagCompound._e("HurtTime");
        this.deathTime = nBTTagCompound._e("DeathTime");
        this.attackTime = nBTTagCompound._e("AttackTime");
    }

    public void updatePotionEffects() {
        boolean bl;
        Iterator iterator2 = this.activePotionsMap.keySet().iterator();
        while (iterator2.hasNext()) {
            Integer n = (Integer)iterator2.next();
            PotionEffect potionEffect = (PotionEffect)this.activePotionsMap.get(n);
            if (!potionEffect._a(this)) {
                if (this.worldObj.isRemote) continue;
                iterator2.remove();
                this.onFinishedPotionEffect(potionEffect);
                continue;
            }
            if (potionEffect._b() % 600 != 0) continue;
            this.onChangedPotionEffect(potionEffect, false);
        }
        if (this.potionsNeedUpdate) {
            if (!this.worldObj.isRemote) {
                if (this.activePotionsMap.isEmpty()) {
                    this.dataWatcher._b(8, (byte)0);
                    this.dataWatcher._b(7, 0);
                    this.setInvisible(false);
                } else {
                    int n = PotionHelper._a(this.activePotionsMap.values());
                    this.dataWatcher._b(8, (byte)(PotionHelper._b(this.activePotionsMap.values()) ? 1 : 0));
                    this.dataWatcher._b(7, n);
                    this.setInvisible(this.isPotionActive(Potion._p._H));
                }
            }
            this.potionsNeedUpdate = false;
        }
        int n = this.dataWatcher._c(7);
        boolean bl2 = bl = this.dataWatcher._a(8) > 0;
        if (n > 0) {
            boolean bl3 = false;
            if (!this.isInvisible()) {
                bl3 = this.rand.nextBoolean();
            } else {
                boolean bl4 = bl3 = this.rand.nextInt(15) == 0;
            }
            if (bl) {
                bl3 &= this.rand.nextInt(5) == 0;
            }
            if (bl3 && n > 0) {
                double d = (double)(n >> 16 & 0xFF) / 255.0;
                double d2 = (double)(n >> 8 & 0xFF) / 255.0;
                double d3 = (double)(n >> 0 & 0xFF) / 255.0;
                this.worldObj.spawnParticle(bl ? "mobSpellAmbient" : "mobSpell", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - (double)this.yOffset, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, d, d2, d3);
            }
        }
    }

    public void clearActivePotions() {
        Iterator iterator2 = this.activePotionsMap.keySet().iterator();
        while (iterator2.hasNext()) {
            Integer n = (Integer)iterator2.next();
            PotionEffect potionEffect = (PotionEffect)this.activePotionsMap.get(n);
            if (this.worldObj.isRemote) continue;
            iterator2.remove();
            this.onFinishedPotionEffect(potionEffect);
        }
    }

    public Collection getActivePotionEffects() {
        return this.activePotionsMap.values();
    }

    public boolean isPotionActive(int n) {
        return this.activePotionsMap.containsKey(n);
    }

    public boolean isPotionActive(Potion potion) {
        return this.activePotionsMap.containsKey(potion._H);
    }

    public PotionEffect getActivePotionEffect(Potion potion) {
        return (PotionEffect)this.activePotionsMap.get(potion._H);
    }

    public void addPotionEffect(PotionEffect potionEffect) {
        if (this.isPotionApplicable(potionEffect)) {
            if (this.activePotionsMap.containsKey(potionEffect._a())) {
                ((PotionEffect)this.activePotionsMap.get(potionEffect._a()))._a(potionEffect);
                this.onChangedPotionEffect((PotionEffect)this.activePotionsMap.get(potionEffect._a()), true);
            } else {
                this.activePotionsMap.put(potionEffect._a(), potionEffect);
                this.onNewPotionEffect(potionEffect);
            }
        }
    }

    public boolean isPotionApplicable(PotionEffect potionEffect) {
        int n;
        return this.getCreatureAttribute() != EnumCreatureAttribute._b || (n = potionEffect._a()) != Potion._l._H && n != Potion._u._H;
    }

    public boolean isEntityUndead() {
        return this.getCreatureAttribute() == EnumCreatureAttribute._b;
    }

    public void removePotionEffectClient(int n) {
        this.activePotionsMap.remove(n);
    }

    public void removePotionEffect(int n) {
        PotionEffect potionEffect = (PotionEffect)this.activePotionsMap.remove(n);
        if (potionEffect != null) {
            this.onFinishedPotionEffect(potionEffect);
        }
    }

    public void onNewPotionEffect(PotionEffect potionEffect) {
        this.potionsNeedUpdate = true;
        if (!this.worldObj.isRemote) {
            Potion._a[potionEffect._a()]._b(this, this.getAttributeMap(), potionEffect._c());
        }
    }

    public void onChangedPotionEffect(PotionEffect potionEffect, boolean bl) {
        this.potionsNeedUpdate = true;
        if (bl && !this.worldObj.isRemote) {
            Potion._a[potionEffect._a()]._a(this, this.getAttributeMap(), potionEffect._c());
            Potion._a[potionEffect._a()]._b(this, this.getAttributeMap(), potionEffect._c());
        }
    }

    public void onFinishedPotionEffect(PotionEffect potionEffect) {
        this.potionsNeedUpdate = true;
        if (!this.worldObj.isRemote) {
            Potion._a[potionEffect._a()]._a(this, this.getAttributeMap(), potionEffect._c());
        }
    }

    public void heal(float f) {
        qlgf._a(this, f);
    }

    public final float getHealth() {
        return this.dataWatcher._d(6);
    }

    public void setHealth(float f) {
        this.dataWatcher._b(6, Float.valueOf(sajh._a(f, 0.0f, this.getMaxHealth())));
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (ForgeHooks.onLivingAttack(this, damageSource, f)) {
            GloomyHooks.attackEntityFrom(this, damageSource, f);
            return false;
        }
        if (this.isEntityInvulnerable()) {
            GloomyHooks.attackEntityFrom(this, damageSource, f);
            return false;
        }
        if (this.worldObj.isRemote) {
            GloomyHooks.attackEntityFrom(this, damageSource, f);
            return false;
        }
        this.entityAge = 0;
        if (this.getHealth() <= 0.0f) {
            GloomyHooks.attackEntityFrom(this, damageSource, f);
            return false;
        }
        if (damageSource.isFireDamage() && this.isPotionActive(Potion._n)) {
            GloomyHooks.attackEntityFrom(this, damageSource, f);
            return false;
        }
        if ((damageSource == DamageSource.anvil || damageSource == DamageSource.fallingBlock) && this.func_71124_b(4) != null) {
            this.func_71124_b(4)._a((int)(f * 4.0f + this.rand.nextFloat() * f * 2.0f), this);
            f *= 0.75f;
        }
        this.limbSwingAmount = 1.5f;
        boolean bl = true;
        if ((float)this.hurtResistantTime > (float)this.maxHurtResistantTime / 2.0f) {
            if (f <= this.lastDamage) {
                GloomyHooks.attackEntityFrom(this, damageSource, f);
                return false;
            }
            this.damageEntity(damageSource, f - this.lastDamage);
            this.lastDamage = f;
            bl = false;
        } else {
            this.lastDamage = f;
            this.prevHealth = this.getHealth();
            this.hurtResistantTime = this.maxHurtResistantTime;
            this.damageEntity(damageSource, f);
            this.maxHurtTime = 10;
            this.hurtTime = 10;
        }
        this.attackedAtYaw = 0.0f;
        Entity entity = damageSource.getEntity();
        if (entity != null) {
            EntityWolf entityWolf;
            if (entity instanceof EntityLivingBase) {
                this.setRevengeTarget((EntityLivingBase)entity);
            }
            if (entity instanceof EntityPlayer) {
                this.recentlyHit = 100;
                this.attackingPlayer = (EntityPlayer)entity;
            } else if (entity instanceof EntityWolf && (entityWolf = (EntityWolf)entity).isTamed()) {
                this.recentlyHit = 100;
                this.attackingPlayer = null;
            }
        }
        if (bl) {
            this.worldObj.setEntityState(this, (byte)2);
            if (damageSource != DamageSource.drown) {
                this.setBeenAttacked();
            }
            if (entity != null) {
                double d = entity.posX - this.posX;
                double d2 = entity.posZ - this.posZ;
                while (d * d + d2 * d2 < 1.0E-4) {
                    d = (Math.random() - Math.random()) * 0.01;
                    d2 = (Math.random() - Math.random()) * 0.01;
                }
                this.attackedAtYaw = (float)(Math.atan2(d2, d) * 180.0 / Math.PI) - this.rotationYaw;
                this.knockBack(entity, f, d, d2);
            } else {
                this.attackedAtYaw = (int)(Math.random() * 2.0) * 180;
            }
        }
        if (this.getHealth() <= 0.0f) {
            if (bl) {
                this.playSound(this.getDeathSound(), this.getSoundVolume(), this.getSoundPitch());
            }
            this.onDeath(damageSource);
        } else if (bl) {
            this.playSound(this.getHurtSound(), this.getSoundVolume(), this.getSoundPitch());
        }
        GloomyHooks.attackEntityFrom(this, damageSource, f);
        return true;
    }

    public void renderBrokenItemStack(ItemStack itemStack) {
        this.playSound("random.break", 0.8f, 0.8f + this.worldObj.rand.nextFloat() * 0.4f);
        for (int i = 0; i < 5; ++i) {
            Vec3 vec3 = this.worldObj.getWorldVec3Pool()._a(((double)this.rand.nextFloat() - 0.5) * 0.1, Math.random() * 0.1 + 0.1, 0.0);
            vec3._a(-this.rotationPitch * (float)Math.PI / 180.0f);
            vec3._b(-this.rotationYaw * (float)Math.PI / 180.0f);
            Vec3 vec32 = this.worldObj.getWorldVec3Pool()._a(((double)this.rand.nextFloat() - 0.5) * 0.3, (double)(-this.rand.nextFloat()) * 0.6 - 0.3, 0.6);
            vec32._a(-this.rotationPitch * (float)Math.PI / 180.0f);
            vec32._b(-this.rotationYaw * (float)Math.PI / 180.0f);
            vec32 = vec32._c(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ);
            this.worldObj.spawnParticle("iconcrack_" + itemStack._a().itemID, vec32._c, vec32._d, vec32._e, vec3._c, vec3._d + 0.05, vec3._e);
        }
    }

    public void onDeath(DamageSource damageSource) {
        if (ForgeHooks.onLivingDeath(this, damageSource)) {
            return;
        }
        Entity entity = damageSource.getEntity();
        EntityLivingBase entityLivingBase = this.func_94060_bK();
        if (this.scoreValue >= 0 && entityLivingBase != null) {
            entityLivingBase.addToPlayerScore(this, this.scoreValue);
        }
        if (entity != null) {
            entity.onKillEntity(this);
        }
        this.dead = true;
        if (!this.worldObj.isRemote) {
            int n = 0;
            if (entity instanceof EntityPlayer) {
                n = zhty._f((EntityLivingBase)entity);
            }
            this.captureDrops = true;
            this.capturedDrops.clear();
            int n2 = 0;
            if (!this.isChild() && this.worldObj.getGameRules()._b("doMobLoot")) {
                this.dropFewItems(this.recentlyHit > 0, n);
                this.dropEquipment(this.recentlyHit > 0, n);
                if (this.recentlyHit > 0 && (n2 = this.rand.nextInt(200) - n) < 5) {
                    this.dropRareDrop(n2 <= 0 ? 1 : 0);
                }
            }
            this.captureDrops = false;
            if (!ForgeHooks.onLivingDrops(this, damageSource, this.capturedDrops, n, this.recentlyHit > 0, n2)) {
                for (EntityItem entityItem : this.capturedDrops) {
                    this.worldObj.spawnEntityInWorld(entityItem);
                }
            }
        }
        this.worldObj.setEntityState(this, (byte)3);
    }

    public void dropEquipment(boolean bl, int n) {
    }

    public String getHurtSound() {
        return "damage.hit";
    }

    public String getDeathSound() {
        return "damage.hit";
    }

    public void dropRareDrop(int n) {
    }

    public void dropFewItems(boolean bl, int n) {
    }

    public boolean isOnLadder() {
        int n = sajh._c(this.posX);
        int n2 = sajh._c(this.boundingBox._c);
        int n3 = sajh._c(this.posZ);
        int n4 = this.worldObj.getBlockId(n, n2, n3);
        return ForgeHooks.isLivingOnLadder(Block.blocksList[n4], this.worldObj, n, n2, n3, this);
    }

    @Override
    public boolean isEntityAlive() {
        return !this.isDead && this.getHealth() > 0.0f;
    }

    @Override
    public void fall(float f) {
        if ((f = ForgeHooks.onLivingFall(this, f)) <= 0.0f) {
            return;
        }
        super.fall(f);
        PotionEffect potionEffect = this.getActivePotionEffect(Potion._j);
        float f2 = potionEffect != null ? (float)(potionEffect._c() + 1) : 0.0f;
        int n = sajh._f(f - 3.0f - f2);
        if (n > 0) {
            if (n > 4) {
                this.playSound("damage.fallbig", 1.0f, 1.0f);
            } else {
                this.playSound("damage.fallsmall", 1.0f, 1.0f);
            }
            this.attackEntityFrom(DamageSource.fall, n);
            int n2 = this.worldObj.getBlockId(sajh._c(this.posX), sajh._c(this.posY - (double)0.2f - (double)this.yOffset), sajh._c(this.posZ));
            if (n2 > 0) {
                StepSound stepSound = Block.blocksList[n2].stepSound;
                this.playSound(stepSound._d(), stepSound._a() * 0.5f, stepSound._b() * 0.75f);
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void performHurtAnimation() {
        this.maxHurtTime = 10;
        this.hurtTime = 10;
        this.attackedAtYaw = 0.0f;
    }

    public int getTotalArmorValue() {
        int n = 0;
        for (ItemStack itemStack : this.func_70035_c()) {
            if (itemStack == null || !(itemStack._a() instanceof ItemArmor)) continue;
            int n2 = ((ItemArmor)itemStack._a()).damageReduceAmount;
            n += n2;
        }
        return n;
    }

    public void damageArmor(float f) {
    }

    public float applyArmorCalculations(DamageSource damageSource, float f) {
        if (!damageSource.isUnblockable()) {
            int n = 25 - this.getTotalArmorValue();
            float f2 = f * (float)n;
            this.damageArmor(f);
            f = f2 / 25.0f;
        }
        return f;
    }

    public float applyPotionDamageCalculations(DamageSource damageSource, float f) {
        float f2;
        int n;
        int n2;
        if (this instanceof EntityZombie) {
            // empty if block
        }
        if (this.isPotionActive(Potion._m) && damageSource != DamageSource.outOfWorld) {
            n2 = (this.getActivePotionEffect(Potion._m)._c() + 1) * 5;
            n = 25 - n2;
            f2 = f * (float)n;
            f = f2 / 25.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        n2 = zhty._a(this.func_70035_c(), damageSource);
        if (n2 > 20) {
            n2 = 20;
        }
        if (n2 > 0 && n2 <= 20) {
            n = 25 - n2;
            f2 = f * (float)n;
            f = f2 / 25.0f;
        }
        return f;
    }

    public void damageEntity(DamageSource damageSource, float f) {
        if (!this.isEntityInvulnerable()) {
            if ((f = ForgeHooks.onLivingHurt(this, damageSource, f)) <= 0.0f) {
                return;
            }
            f = this.applyArmorCalculations(damageSource, f);
            float f2 = f = this.applyPotionDamageCalculations(damageSource, f);
            f = Math.max(f - this.getAbsorptionAmount(), 0.0f);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (f2 - f));
            if (f != 0.0f) {
                float f3 = this.getHealth();
                this.setHealth(f3 - f);
                this.func_110142_aN()._a(damageSource, f3, f);
                this.setAbsorptionAmount(this.getAbsorptionAmount() - f);
            }
        }
    }

    public CombatTracker func_110142_aN() {
        return this._combatTracker;
    }

    public EntityLivingBase func_94060_bK() {
        return this._combatTracker._c() != null ? this._combatTracker._c() : (this.attackingPlayer != null ? this.attackingPlayer : (this.entityLivingToAttack != null ? this.entityLivingToAttack : null));
    }

    public final float getMaxHealth() {
        return (float)this.getEntityAttribute(sajz._a)._e();
    }

    public final int getArrowCountInEntity() {
        return this.dataWatcher._a(9);
    }

    public final void setArrowCountInEntity(int n) {
        this.dataWatcher._b(9, (byte)n);
    }

    public int getArmSwingAnimationEnd() {
        return this.isPotionActive(Potion._e) ? 6 - (1 + this.getActivePotionEffect(Potion._e)._c()) * 1 : (this.isPotionActive(Potion._f) ? 6 + (1 + this.getActivePotionEffect(Potion._f)._c()) * 2 : 6);
    }

    public void swingItem() {
        Item item;
        ugqx._a(this);
        ItemStack itemStack = this.getHeldItem();
        if (itemStack != null && itemStack._a() != null && (item = itemStack._a()).onEntitySwing(this, itemStack)) {
            return;
        }
        if (!this.isSwingInProgress || this.swingProgressInt >= this.getArmSwingAnimationEnd() / 2 || this.swingProgressInt < 0) {
            this.swingProgressInt = -1;
            this.isSwingInProgress = true;
            if (this.worldObj instanceof WorldServer) {
                ((WorldServer)this.worldObj).getEntityTracker()._a(this, new Packet18Animation(this, 1));
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void handleHealthUpdate(byte by) {
        if (by == 2) {
            this.limbSwingAmount = 1.5f;
            this.hurtResistantTime = this.maxHurtResistantTime;
            this.maxHurtTime = 10;
            this.hurtTime = 10;
            this.attackedAtYaw = 0.0f;
            this.playSound(this.getHurtSound(), this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            this.attackEntityFrom(DamageSource.generic, 0.0f);
        } else if (by == 3) {
            this.playSound(this.getDeathSound(), this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            this.setHealth(0.0f);
            this.onDeath(DamageSource.generic);
        } else {
            super.handleHealthUpdate(by);
        }
    }

    @Override
    public void kill() {
        this.attackEntityFrom(DamageSource.outOfWorld, 4.0f);
    }

    public void updateArmSwingProgress() {
        int n = this.getArmSwingAnimationEnd();
        if (this.isSwingInProgress) {
            ++this.swingProgressInt;
            if (this.swingProgressInt >= n) {
                this.swingProgressInt = 0;
                this.isSwingInProgress = false;
            }
        } else {
            this.swingProgressInt = 0;
        }
        this.swingProgress = (float)this.swingProgressInt / (float)n;
    }

    public hubf getEntityAttribute(Attribute attribute) {
        return this.getAttributeMap()._a(attribute);
    }

    public BaseAttributeMap getAttributeMap() {
        if (this.attributeMap == null) {
            this.attributeMap = new ServersideAttributeMap();
        }
        return this.attributeMap;
    }

    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute._a;
    }

    public abstract ItemStack getHeldItem();

    public abstract ItemStack func_71124_b(int var1);

    @Override
    public abstract void setCurrentItemOrArmor(int var1, ItemStack var2);

    @Override
    public void setSprinting(boolean bl) {
        super.setSprinting(bl);
        hubf hubf2 = this.getEntityAttribute(sajz._d);
        if (hubf2._a(sprintingSpeedBoostModifierUUID) != null) {
            hubf2._b(sprintingSpeedBoostModifier);
        }
        if (bl) {
            hubf2._a(sprintingSpeedBoostModifier);
        }
    }

    @Override
    public abstract ItemStack[] func_70035_c();

    public float getSoundVolume() {
        return 1.0f;
    }

    public float getSoundPitch() {
        return this.isChild() ? (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.5f : (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f;
    }

    public boolean isMovementBlocked() {
        return this.getHealth() <= 0.0f;
    }

    public void setPositionAndUpdate(double d, double d2, double d3) {
        this.setLocationAndAngles(d, d2, d3, this.rotationYaw, this.rotationPitch);
    }

    public void dismountEntity(Entity entity) {
        double d = entity.posX;
        double d2 = entity.boundingBox._c + (double)entity.height;
        double d3 = entity.posZ;
        for (double d4 = -1.5; d4 < 2.0; d4 += 1.0) {
            for (double d5 = -1.5; d5 < 2.0; d5 += 1.0) {
                if (d4 == 0.0 && d5 == 0.0) continue;
                int n = (int)(this.posX + d4);
                int n2 = (int)(this.posZ + d5);
                AxisAlignedBB axisAlignedBB = this.boundingBox._c(d4, 1.0, d5);
                if (!this.worldObj.getCollidingBlockBounds(axisAlignedBB).isEmpty()) continue;
                if (this.worldObj.doesBlockHaveSolidTopSurface(n, (int)this.posY, n2)) {
                    this.setPositionAndUpdate(this.posX + d4, this.posY + 1.0, this.posZ + d5);
                    return;
                }
                if (!this.worldObj.doesBlockHaveSolidTopSurface(n, (int)this.posY - 1, n2) && this.worldObj.getBlockMaterial(n, (int)this.posY - 1, n2) != Material._h) continue;
                d = this.posX + d4;
                d2 = this.posY + 1.0;
                d3 = this.posZ + d5;
            }
        }
        this.setPositionAndUpdate(d, d2, d3);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean getAlwaysRenderNameTagForRender() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public Icon getItemIcon(ItemStack itemStack, int n) {
        return itemStack._b();
    }

    public void jump() {
        this.motionY = 0.42f;
        if (this.isPotionActive(Potion._j)) {
            this.motionY += (double)((float)(this.getActivePotionEffect(Potion._j)._c() + 1) * 0.1f);
        }
        if (this.isSprinting()) {
            float f = this.rotationYaw * ((float)Math.PI / 180);
            this.motionX -= (double)(sajh._a(f) * 0.2f);
            this.motionZ += (double)(sajh._b(f) * 0.2f);
        }
        this.isAirBorne = true;
        ForgeHooks.onLivingJump(this);
    }

    public void moveEntityWithHeading(float f, float f2) {
        float f3;
        double d;
        if (!(!this.isInWater() || this instanceof EntityPlayer && ((EntityPlayer)this).capabilities._b)) {
            d = this.posY;
            this.moveFlying(f, f2, this.isAIEnabled() ? 0.04f : 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double)0.8f;
            this.motionY *= (double)0.8f;
            this.motionZ *= (double)0.8f;
            this.motionY -= 0.02;
            if (this.isCollidedHorizontally && this.isOffsetPositionInLiquid(this.motionX, this.motionY + (double)0.6f - this.posY + d, this.motionZ)) {
                this.motionY = 0.3f;
            }
        } else if (!(!this.handleLavaMovement() || this instanceof EntityPlayer && ((EntityPlayer)this).capabilities._b)) {
            d = this.posY;
            this.moveFlying(f, f2, 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5;
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
            this.motionY -= 0.02;
            if (this.isCollidedHorizontally && this.isOffsetPositionInLiquid(this.motionX, this.motionY + (double)0.6f - this.posY + d, this.motionZ)) {
                this.motionY = 0.3f;
            }
        } else {
            float f4 = 0.91f;
            if (this.onGround) {
                f4 = 0.54600006f;
                int n = this.worldObj.getBlockId(sajh._c(this.posX), sajh._c(this.boundingBox._c) - 1, sajh._c(this.posZ));
                if (n > 0) {
                    f4 = Block.blocksList[n].slipperiness * 0.91f;
                }
            }
            float f5 = 0.16277136f / (f4 * f4 * f4);
            f3 = this.onGround ? this.getAIMoveSpeed() * f5 : this.jumpMovementFactor;
            this.moveFlying(f, f2, f3);
            f4 = 0.91f;
            if (this.onGround) {
                f4 = 0.54600006f;
                int n = this.worldObj.getBlockId(sajh._c(this.posX), sajh._c(this.boundingBox._c) - 1, sajh._c(this.posZ));
                if (n > 0) {
                    f4 = Block.blocksList[n].slipperiness * 0.91f;
                }
            }
            if (this.isOnLadder()) {
                boolean bl;
                float f6 = 0.15f;
                if (this.motionX < (double)(-f6)) {
                    this.motionX = -f6;
                }
                if (this.motionX > (double)f6) {
                    this.motionX = f6;
                }
                if (this.motionZ < (double)(-f6)) {
                    this.motionZ = -f6;
                }
                if (this.motionZ > (double)f6) {
                    this.motionZ = f6;
                }
                this.fallDistance = 0.0f;
                if (this.motionY < -0.15) {
                    this.motionY = -0.15;
                }
                boolean bl2 = bl = this.isSneaking() && this instanceof EntityPlayer;
                if (bl && this.motionY < 0.0) {
                    this.motionY = 0.0;
                }
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            if (this.isCollidedHorizontally && this.isOnLadder()) {
                this.motionY = 0.2;
            }
            this.motionY = !(!this.worldObj.isRemote || this.worldObj.blockExists((int)this.posX, 0, (int)this.posZ) && this.worldObj.getChunkFromBlockCoords((int)((int)this.posX), (int)((int)this.posZ))._f) ? (this.posY > 0.0 ? -0.1 : 0.0) : (this.motionY -= 0.08);
            this.motionY *= (double)0.98f;
            this.motionX *= (double)f4;
            this.motionZ *= (double)f4;
        }
        this.prevLimbSwingAmount = this.limbSwingAmount;
        d = this.posX - this.prevPosX;
        double d2 = this.posZ - this.prevPosZ;
        f3 = sajh._a(d * d + d2 * d2) * 4.0f;
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        this.limbSwingAmount += (f3 - this.limbSwingAmount) * 0.4f;
        this.limbSwing += this.limbSwingAmount;
    }

    public boolean isAIEnabled() {
        return false;
    }

    public float getAIMoveSpeed() {
        return this.isAIEnabled() ? this.landMovementFactor : 0.1f;
    }

    public void setAIMoveSpeed(float f) {
        this.landMovementFactor = f;
    }

    public boolean attackEntityAsMob(Entity entity) {
        this.setLastAttacker(entity);
        return false;
    }

    public boolean isPlayerSleeping() {
        return false;
    }

    @Override
    public void onUpdate() {
        if (ForgeHooks.onLivingUpdate(this)) {
            return;
        }
        super.onUpdate();
        if (!this.worldObj.isRemote) {
            int n = this.getArrowCountInEntity();
            if (n > 0) {
                if (this.arrowHitTimer <= 0) {
                    this.arrowHitTimer = 20 * (30 - n);
                }
                --this.arrowHitTimer;
                if (this.arrowHitTimer <= 0) {
                    this.setArrowCountInEntity(n - 1);
                }
            }
            for (int i = 0; i < 5; ++i) {
                ItemStack itemStack = this.previousEquipment[i];
                ItemStack itemStack2 = this.func_71124_b(i);
                if (ItemStack._b(itemStack2, itemStack)) continue;
                ((WorldServer)this.worldObj).getEntityTracker()._a(this, new hdms(this.entityId, i, itemStack2));
                if (itemStack != null) {
                    this.attributeMap._a(itemStack._D());
                }
                if (itemStack2 != null) {
                    this.attributeMap._b(itemStack2._D());
                }
                this.previousEquipment[i] = itemStack2 == null ? null : itemStack2._l();
            }
        }
        this.onLivingUpdate();
        double d = this.posX - this.prevPosX;
        double d2 = this.posZ - this.prevPosZ;
        float f = (float)(d * d + d2 * d2);
        float f2 = this.renderYawOffset;
        float f3 = 0.0f;
        this.field_70768_au = this.field_110154_aX;
        float f4 = 0.0f;
        if (f > 0.0025000002f) {
            f4 = 1.0f;
            f3 = (float)Math.sqrt(f) * 3.0f;
            f2 = (float)Math.atan2(d2, d) * 180.0f / (float)Math.PI - 90.0f;
        }
        if (this.swingProgress > 0.0f) {
            f2 = this.rotationYaw;
        }
        if (!this.onGround) {
            f4 = 0.0f;
        }
        this.field_110154_aX += (f4 - this.field_110154_aX) * 0.3f;
        this.worldObj.theProfiler._a("headTurn");
        f3 = this.func_110146_f(f2, f3);
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._a("rangeChecks");
        while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
            this.prevRotationYaw -= 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
            this.prevRotationYaw += 360.0f;
        }
        while (this.renderYawOffset - this.prevRenderYawOffset < -180.0f) {
            this.prevRenderYawOffset -= 360.0f;
        }
        while (this.renderYawOffset - this.prevRenderYawOffset >= 180.0f) {
            this.prevRenderYawOffset += 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
            this.prevRotationPitch -= 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
            this.prevRotationPitch += 360.0f;
        }
        while (this.rotationYawHead - this.prevRotationYawHead < -180.0f) {
            this.prevRotationYawHead -= 360.0f;
        }
        while (this.rotationYawHead - this.prevRotationYawHead >= 180.0f) {
            this.prevRotationYawHead += 360.0f;
        }
        this.worldObj.theProfiler._b();
        this.field_70764_aw += f3;
    }

    public float func_110146_f(float f, float f2) {
        boolean bl;
        float f3 = sajh._g(f - this.renderYawOffset);
        this.renderYawOffset += f3 * 0.3f;
        float f4 = sajh._g(this.rotationYaw - this.renderYawOffset);
        boolean bl2 = bl = f4 < -90.0f || f4 >= 90.0f;
        if (f4 < -75.0f) {
            f4 = -75.0f;
        }
        if (f4 >= 75.0f) {
            f4 = 75.0f;
        }
        this.renderYawOffset = this.rotationYaw - f4;
        if (f4 * f4 > 2500.0f) {
            this.renderYawOffset += f4 * 0.2f;
        }
        if (bl) {
            f2 *= -1.0f;
        }
        return f2;
    }

    public void onLivingUpdate() {
        if (this.jumpTicks > 0) {
            --this.jumpTicks;
        }
        if (this.newPosRotationIncrements > 0) {
            double d = this.posX + (this.newPosX - this.posX) / (double)this.newPosRotationIncrements;
            double d2 = this.posY + (this.newPosY - this.posY) / (double)this.newPosRotationIncrements;
            double d3 = this.posZ + (this.newPosZ - this.posZ) / (double)this.newPosRotationIncrements;
            double d4 = sajh._f(this.newRotationYaw - (double)this.rotationYaw);
            this.rotationYaw = (float)((double)this.rotationYaw + d4 / (double)this.newPosRotationIncrements);
            this.rotationPitch = (float)((double)this.rotationPitch + (this.newRotationPitch - (double)this.rotationPitch) / (double)this.newPosRotationIncrements);
            --this.newPosRotationIncrements;
            this.setPosition(d, d2, d3);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        } else if (!this.isClientWorld()) {
            this.motionX *= 0.98;
            this.motionY *= 0.98;
            this.motionZ *= 0.98;
        }
        if (Math.abs(this.motionX) < 0.005) {
            this.motionX = 0.0;
        }
        if (Math.abs(this.motionY) < 0.005) {
            this.motionY = 0.0;
        }
        if (Math.abs(this.motionZ) < 0.005) {
            this.motionZ = 0.0;
        }
        this.worldObj.theProfiler._a("ai");
        if (this.isMovementBlocked()) {
            this.isJumping = false;
            this.moveStrafing = 0.0f;
            this.moveForward = 0.0f;
            this.randomYawVelocity = 0.0f;
        } else if (this.isClientWorld()) {
            if (this.isAIEnabled()) {
                this.worldObj.theProfiler._a("newAi");
                this.updateAITasks();
                this.worldObj.theProfiler._b();
            } else {
                this.worldObj.theProfiler._a("oldAi");
                this.updateEntityActionState();
                this.worldObj.theProfiler._b();
                this.rotationYawHead = this.rotationYaw;
            }
        }
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._a("jump");
        if (this.isJumping) {
            if (!this.isInWater() && !this.handleLavaMovement()) {
                if (this.onGround && this.jumpTicks == 0) {
                    this.jump();
                    this.jumpTicks = 10;
                }
            } else {
                this.motionY += (double)0.04f;
            }
        } else {
            this.jumpTicks = 0;
        }
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._a("travel");
        this.moveStrafing *= 0.98f;
        this.moveForward *= 0.98f;
        this.randomYawVelocity *= 0.9f;
        this.moveEntityWithHeading(this.moveStrafing, this.moveForward);
        this.worldObj.theProfiler._b();
        this.worldObj.theProfiler._a("push");
        if (!this.worldObj.isRemote) {
            this.collideWithNearbyEntities();
        }
        this.worldObj.theProfiler._b();
    }

    public void updateAITasks() {
    }

    public void collideWithNearbyEntities() {
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox._b(0.2f, 0.0, 0.2f));
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity)list.get(i);
                if (!entity.canBePushed()) continue;
                this.collideWithEntity(entity);
            }
        }
    }

    public void collideWithEntity(Entity entity) {
        entity.applyEntityCollision(this);
    }

    @Override
    public void updateRidden() {
        super.updateRidden();
        this.field_70768_au = this.field_110154_aX;
        this.field_110154_aX = 0.0f;
        this.fallDistance = 0.0f;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void setPositionAndRotation2(double d, double d2, double d3, float f, float f2, int n) {
        this.yOffset = 0.0f;
        this.newPosX = d;
        this.newPosY = d2;
        this.newPosZ = d3;
        this.newRotationYaw = f;
        this.newRotationPitch = f2;
        this.newPosRotationIncrements = n;
    }

    public void updateAITick() {
    }

    public void updateEntityActionState() {
        ++this.entityAge;
    }

    public void setJumping(boolean bl) {
        this.isJumping = bl;
    }

    public void onItemPickup(Entity entity, int n) {
        if (!entity.isDead && !this.worldObj.isRemote) {
            EntityTracker entityTracker = ((WorldServer)this.worldObj).getEntityTracker();
            if (entity instanceof EntityItem) {
                entityTracker._a(entity, new bbyg(entity.entityId, this.entityId));
            }
            if (entity instanceof EntityArrow) {
                entityTracker._a(entity, new bbyg(entity.entityId, this.entityId));
            }
            if (entity instanceof EntityXPOrb) {
                entityTracker._a(entity, new bbyg(entity.entityId, this.entityId));
            }
        }
    }

    public boolean canEntityBeSeen(Entity entity) {
        return this.worldObj.func_72933_a(this.worldObj.getWorldVec3Pool()._a(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ), this.worldObj.getWorldVec3Pool()._a(entity.posX, entity.posY + (double)entity.getEyeHeight(), entity.posZ)) == null;
    }

    @Override
    public Vec3 getLookVec() {
        return this.getLook(1.0f);
    }

    public Vec3 getLook(float f) {
        if (f == 1.0f) {
            float f2 = sajh._b(-this.rotationYaw * ((float)Math.PI / 180) - (float)Math.PI);
            float f3 = sajh._a(-this.rotationYaw * ((float)Math.PI / 180) - (float)Math.PI);
            float f4 = -sajh._b(-this.rotationPitch * ((float)Math.PI / 180));
            float f5 = sajh._a(-this.rotationPitch * ((float)Math.PI / 180));
            return this.worldObj.getWorldVec3Pool()._a(f3 * f4, f5, f2 * f4);
        }
        float f6 = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * f;
        float f7 = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * f;
        float f8 = sajh._b(-f7 * ((float)Math.PI / 180) - (float)Math.PI);
        float f9 = sajh._a(-f7 * ((float)Math.PI / 180) - (float)Math.PI);
        float f10 = -sajh._b(-f6 * ((float)Math.PI / 180));
        float f11 = sajh._a(-f6 * ((float)Math.PI / 180));
        return this.worldObj.getWorldVec3Pool()._a(f9 * f10, f11, f8 * f10);
    }

    @SideOnly(value=Side.CLIENT)
    public float getSwingProgress(float f) {
        float f2 = this.swingProgress - this.prevSwingProgress;
        if (f2 < 0.0f) {
            f2 += 1.0f;
        }
        return this.prevSwingProgress + f2 * f;
    }

    @SideOnly(value=Side.CLIENT)
    public Vec3 getPosition(float f) {
        if (f == 1.0f) {
            return this.worldObj.getWorldVec3Pool()._a(this.posX, this.posY, this.posZ);
        }
        double d = this.prevPosX + (this.posX - this.prevPosX) * (double)f;
        double d2 = this.prevPosY + (this.posY - this.prevPosY) * (double)f;
        double d3 = this.prevPosZ + (this.posZ - this.prevPosZ) * (double)f;
        return this.worldObj.getWorldVec3Pool()._a(d, d2, d3);
    }

    @SideOnly(value=Side.CLIENT)
    public MovingObjectPosition rayTrace(double d, float f) {
        Vec3 vec3 = this.getPosition(f);
        Vec3 vec32 = this.getLook(f);
        Vec3 vec33 = vec3._c(vec32._c * d, vec32._d * d, vec32._e * d);
        return this.worldObj.func_72933_a(vec3, vec33);
    }

    public boolean isClientWorld() {
        return !this.worldObj.isRemote;
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    @Override
    public boolean canBePushed() {
        return !this.isDead;
    }

    @Override
    public float getEyeHeight() {
        return this.height * 0.85f;
    }

    @Override
    public void setBeenAttacked() {
        this.velocityChanged = this.rand.nextDouble() >= this.getEntityAttribute(sajz._c)._e();
    }

    @Override
    public float getRotationYawHead() {
        return this.rotationYawHead;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void setRotationYawHead(float f) {
        this.rotationYawHead = f;
    }

    public float getAbsorptionAmount() {
        return this.field_110151_bq;
    }

    public void setAbsorptionAmount(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.field_110151_bq = f;
    }

    public Team getTeam() {
        return null;
    }

    public boolean isOnSameTeam(EntityLivingBase entityLivingBase) {
        return this.isOnTeam(entityLivingBase.getTeam());
    }

    public boolean isOnTeam(Team team) {
        return this.getTeam() != null ? this.getTeam()._a(team) : false;
    }

    public void curePotionEffects(ItemStack itemStack) {
        Iterator iterator2 = this.activePotionsMap.keySet().iterator();
        if (this.worldObj.isRemote) {
            return;
        }
        while (iterator2.hasNext()) {
            Integer n = (Integer)iterator2.next();
            PotionEffect potionEffect = (PotionEffect)this.activePotionsMap.get(n);
            if (!potionEffect._a(itemStack)) continue;
            iterator2.remove();
            this.onFinishedPotionEffect(potionEffect);
        }
    }

    public boolean shouldRiderFaceForward(EntityPlayer entityPlayer) {
        return this instanceof EntityPig;
    }

    public void knockBack(Entity entity, float f, double d, double d2) {
        GloomyHooks.knockBack(this, entity, f, d, d2);
    }

    @Override
    public boolean hitByEntity(Entity entity) {
        BlockRendererList.hitByEntity(this, entity);
        return super.hitByEntity(entity);
    }
}

