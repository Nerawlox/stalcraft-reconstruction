/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityEnderman
extends EntityMob {
    public static final UUID attackingSpeedBoostModifierUUID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
    public static final AttributeModifier attackingSpeedBoostModifier = new AttributeModifier(attackingSpeedBoostModifierUUID, "Attacking speed boost", 6.2f, 0)._a(false);
    public static boolean[] carriableBlocks = new boolean[256];
    public int teleportDelay;
    public int stareTimer;
    public Entity lastEntityToAttack;
    public boolean isAggressive;

    public EntityEnderman(World world) {
        super(world);
        this.setSize(0.6f, 2.9f);
        this.stepHeight = 1.0f;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(40.0);
        this.getEntityAttribute(sajz._d)._a(0.3f);
        this.getEntityAttribute(sajz._e)._a(7.0);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(16, new Byte(0));
        this.dataWatcher._a(17, new Byte(0));
        this.dataWatcher._a(18, new Byte(0));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("carried", (short)this.getCarried());
        nBTTagCompound._a("carriedData", (short)this.getCarryingData());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.setCarried(nBTTagCompound._e("carried"));
        this.setCarryingData(nBTTagCompound._e("carriedData"));
    }

    @Override
    public Entity findPlayerToAttack() {
        EntityPlayer entityPlayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0);
        if (entityPlayer != null) {
            if (this.shouldAttackPlayer(entityPlayer)) {
                this.isAggressive = true;
                if (this.stareTimer == 0) {
                    this.worldObj.playSoundAtEntity(entityPlayer, "mob.endermen.stare", 1.0f, 1.0f);
                }
                if (this.stareTimer++ == 5) {
                    this.stareTimer = 0;
                    this.setScreaming(true);
                    return entityPlayer;
                }
            } else {
                this.stareTimer = 0;
            }
        }
        return null;
    }

    public boolean shouldAttackPlayer(EntityPlayer entityPlayer) {
        ItemStack itemStack = entityPlayer.inventory._b[3];
        if (itemStack != null && itemStack._d == Block.pumpkin.blockID) {
            return false;
        }
        Vec3 vec3 = entityPlayer.getLook(1.0f)._a();
        Vec3 vec32 = this.worldObj.getWorldVec3Pool()._a(this.posX - entityPlayer.posX, this.boundingBox._c + (double)(this.height / 2.0f) - (entityPlayer.posY + (double)entityPlayer.getEyeHeight()), this.posZ - entityPlayer.posZ);
        double d = vec32._b();
        double d2 = vec3._b(vec32 = vec32._a());
        return d2 > 1.0 - 0.025 / d ? entityPlayer.canEntityBeSeen(this) : false;
    }

    @Override
    public void onLivingUpdate() {
        float f;
        if (this.isWet()) {
            this.attackEntityFrom(DamageSource.drown, 1.0f);
        }
        if (this.lastEntityToAttack != this.entityToAttack) {
            hubf hubf2 = this.getEntityAttribute(sajz._d);
            hubf2._b(attackingSpeedBoostModifier);
            if (this.entityToAttack != null) {
                hubf2._a(attackingSpeedBoostModifier);
            }
        }
        this.lastEntityToAttack = this.entityToAttack;
        if (!this.worldObj.isRemote && this.worldObj.getGameRules()._b("mobGriefing")) {
            int n;
            int n2;
            int n3;
            if (this.getCarried() == 0) {
                int n4;
                if (this.rand.nextInt(20) == 0 && carriableBlocks[n3 = this.worldObj.getBlockId(n4 = sajh._c(this.posX - 2.0 + this.rand.nextDouble() * 4.0), n2 = sajh._c(this.posY + this.rand.nextDouble() * 3.0), n = sajh._c(this.posZ - 2.0 + this.rand.nextDouble() * 4.0))]) {
                    this.setCarried(this.worldObj.getBlockId(n4, n2, n));
                    this.setCarryingData(this.worldObj.getBlockMetadata(n4, n2, n));
                    this.worldObj.setBlock(n4, n2, n, 0);
                }
            } else if (this.rand.nextInt(2000) == 0) {
                int n5 = sajh._c(this.posX - 1.0 + this.rand.nextDouble() * 2.0);
                n2 = sajh._c(this.posY + this.rand.nextDouble() * 2.0);
                n = sajh._c(this.posZ - 1.0 + this.rand.nextDouble() * 2.0);
                n3 = this.worldObj.getBlockId(n5, n2, n);
                int n6 = this.worldObj.getBlockId(n5, n2 - 1, n);
                if (n3 == 0 && n6 > 0 && Block.blocksList[n6].renderAsNormalBlock()) {
                    this.worldObj.setBlock(n5, n2, n, this.getCarried(), this.getCarryingData(), 3);
                    this.setCarried(0);
                }
            }
        }
        for (int i = 0; i < 2; ++i) {
            this.worldObj.spawnParticle("portal", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, (this.rand.nextDouble() - 0.5) * 2.0, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5) * 2.0);
        }
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote && (f = this.getBrightness(1.0f)) > 0.5f && this.worldObj.canBlockSeeTheSky(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ)) && this.rand.nextFloat() * 30.0f < (f - 0.4f) * 2.0f) {
            this.entityToAttack = null;
            this.setScreaming(false);
            this.isAggressive = false;
            this.teleportRandomly();
        }
        if (this.isWet() || this.isBurning()) {
            this.entityToAttack = null;
            this.setScreaming(false);
            this.isAggressive = false;
            this.teleportRandomly();
        }
        if (this.isScreaming() && !this.isAggressive && this.rand.nextInt(100) == 0) {
            this.setScreaming(false);
        }
        this.isJumping = false;
        if (this.entityToAttack != null) {
            this.faceEntity(this.entityToAttack, 100.0f, 100.0f);
        }
        if (!this.worldObj.isRemote && this.isEntityAlive()) {
            if (this.entityToAttack != null) {
                if (this.entityToAttack instanceof EntityPlayer && this.shouldAttackPlayer((EntityPlayer)this.entityToAttack)) {
                    if (this.entityToAttack.getDistanceSqToEntity(this) < 16.0) {
                        this.teleportRandomly();
                    }
                    this.teleportDelay = 0;
                } else if (this.entityToAttack.getDistanceSqToEntity(this) > 256.0 && this.teleportDelay++ >= 30 && this.teleportToEntity(this.entityToAttack)) {
                    this.teleportDelay = 0;
                }
            } else {
                this.setScreaming(false);
                this.teleportDelay = 0;
            }
        }
        super.onLivingUpdate();
    }

    public boolean teleportRandomly() {
        double d = this.posX + (this.rand.nextDouble() - 0.5) * 64.0;
        double d2 = this.posY + (double)(this.rand.nextInt(64) - 32);
        double d3 = this.posZ + (this.rand.nextDouble() - 0.5) * 64.0;
        return this.teleportTo(d, d2, d3);
    }

    public boolean teleportToEntity(Entity entity) {
        Vec3 vec3 = this.worldObj.getWorldVec3Pool()._a(this.posX - entity.posX, this.boundingBox._c + (double)(this.height / 2.0f) - entity.posY + (double)entity.getEyeHeight(), this.posZ - entity.posZ);
        vec3 = vec3._a();
        double d = 16.0;
        double d2 = this.posX + (this.rand.nextDouble() - 0.5) * 8.0 - vec3._c * d;
        double d3 = this.posY + (double)(this.rand.nextInt(16) - 8) - vec3._d * d;
        double d4 = this.posZ + (this.rand.nextDouble() - 0.5) * 8.0 - vec3._e * d;
        return this.teleportTo(d2, d3, d4);
    }

    public boolean teleportTo(double d, double d2, double d3) {
        int n;
        int n2;
        int n3;
        int n4;
        EnderTeleportEvent enderTeleportEvent = new EnderTeleportEvent(this, d, d2, d3, 0.0f);
        if (MinecraftForge.EVENT_BUS.post(enderTeleportEvent)) {
            return false;
        }
        double d4 = this.posX;
        double d5 = this.posY;
        double d6 = this.posZ;
        this.posX = enderTeleportEvent.targetX;
        this.posY = enderTeleportEvent.targetY;
        this.posZ = enderTeleportEvent.targetZ;
        boolean bl = false;
        int n5 = sajh._c(this.posX);
        if (this.worldObj.blockExists(n5, n4 = sajh._c(this.posY), n3 = sajh._c(this.posZ))) {
            n2 = 0;
            while (n2 == 0 && n4 > 0) {
                n = this.worldObj.getBlockId(n5, n4 - 1, n3);
                if (n != 0 && Block.blocksList[n].blockMaterial._c()) {
                    n2 = 1;
                    continue;
                }
                this.posY -= 1.0;
                --n4;
            }
            if (n2 != 0) {
                this.setPosition(this.posX, this.posY, this.posZ);
                if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox)) {
                    bl = true;
                }
            }
        }
        if (!bl) {
            this.setPosition(d4, d5, d6);
            return false;
        }
        n2 = 128;
        for (n = 0; n < n2; ++n) {
            double d7 = (double)n / ((double)n2 - 1.0);
            float f = (this.rand.nextFloat() - 0.5f) * 0.2f;
            float f2 = (this.rand.nextFloat() - 0.5f) * 0.2f;
            float f3 = (this.rand.nextFloat() - 0.5f) * 0.2f;
            double d8 = d4 + (this.posX - d4) * d7 + (this.rand.nextDouble() - 0.5) * (double)this.width * 2.0;
            double d9 = d5 + (this.posY - d5) * d7 + this.rand.nextDouble() * (double)this.height;
            double d10 = d6 + (this.posZ - d6) * d7 + (this.rand.nextDouble() - 0.5) * (double)this.width * 2.0;
            this.worldObj.spawnParticle("portal", d8, d9, d10, f, f2, f3);
        }
        this.worldObj.playSoundEffect(d4, d5, d6, "mob.endermen.portal", 1.0f, 1.0f);
        this.playSound("mob.endermen.portal", 1.0f, 1.0f);
        return true;
    }

    @Override
    public String getLivingSound() {
        return this.isScreaming() ? "mob.endermen.scream" : "mob.endermen.idle";
    }

    @Override
    public String getHurtSound() {
        return "mob.endermen.hit";
    }

    @Override
    public String getDeathSound() {
        return "mob.endermen.death";
    }

    @Override
    public int getDropItemId() {
        return Item.enderPearl.itemID;
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
        int n2 = this.getDropItemId();
        if (n2 > 0) {
            int n3 = this.rand.nextInt(2 + n);
            for (int i = 0; i < n3; ++i) {
                this.dropItem(n2, 1);
            }
        }
    }

    public void setCarried(int n) {
        this.dataWatcher._b(16, (byte)(n & 0xFF));
    }

    public int getCarried() {
        return this.dataWatcher._a(16);
    }

    public void setCarryingData(int n) {
        this.dataWatcher._b(17, (byte)(n & 0xFF));
    }

    public int getCarryingData() {
        return this.dataWatcher._a(17);
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        this.setScreaming(true);
        if (damageSource instanceof EntityDamageSource && damageSource.getEntity() instanceof EntityPlayer) {
            this.isAggressive = true;
        }
        if (damageSource instanceof EntityDamageSourceIndirect) {
            this.isAggressive = false;
            for (int i = 0; i < 64; ++i) {
                if (!this.teleportRandomly()) continue;
                return true;
            }
            return super.attackEntityFrom(damageSource, f);
        }
        return super.attackEntityFrom(damageSource, f);
    }

    public boolean isScreaming() {
        return this.dataWatcher._a(18) > 0;
    }

    public void setScreaming(boolean bl) {
        this.dataWatcher._b(18, (byte)(bl ? 1 : 0));
    }

    static {
        EntityEnderman.carriableBlocks[Block.grass.blockID] = true;
        EntityEnderman.carriableBlocks[Block.dirt.blockID] = true;
        EntityEnderman.carriableBlocks[Block.sand.blockID] = true;
        EntityEnderman.carriableBlocks[Block.gravel.blockID] = true;
        EntityEnderman.carriableBlocks[Block.plantYellow.blockID] = true;
        EntityEnderman.carriableBlocks[Block.plantRed.blockID] = true;
        EntityEnderman.carriableBlocks[Block.mushroomBrown.blockID] = true;
        EntityEnderman.carriableBlocks[Block.mushroomRed.blockID] = true;
        EntityEnderman.carriableBlocks[Block.tnt.blockID] = true;
        EntityEnderman.carriableBlocks[Block.cactus.blockID] = true;
        EntityEnderman.carriableBlocks[Block.blockClay.blockID] = true;
        EntityEnderman.carriableBlocks[Block.pumpkin.blockID] = true;
        EntityEnderman.carriableBlocks[Block.melon.blockID] = true;
        EntityEnderman.carriableBlocks[Block.mycelium.blockID] = true;
    }
}

