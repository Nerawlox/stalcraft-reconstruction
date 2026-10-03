/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.anticheat.pidb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumEntitySize;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.eidj;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.jgro;
import net.minecraft.entity.kjui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.util.tdpx;
import net.minecraft.util.turb;
import net.minecraft.util.ugqx;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterBlood;
import poersch.minecraft.bettergrassandleaves.renderer.BetterBloodRenderer;

public abstract class Entity
implements IBetterBlood {
    public static int nextEntityID;
    public int entityId;
    public double renderDistanceWeight = 1.0;
    public boolean preventEntitySpawning;
    public Entity riddenByEntity;
    public Entity ridingEntity;
    public boolean forceSpawn;
    public World worldObj;
    public double prevPosX;
    public double prevPosY;
    public double prevPosZ;
    public double posX;
    public double posY;
    public double posZ;
    public double motionX;
    public double motionY;
    public double motionZ;
    public float rotationYaw;
    public float rotationPitch;
    public float prevRotationYaw;
    public float prevRotationPitch;
    public final AxisAlignedBB boundingBox;
    public boolean onGround;
    public boolean isCollidedHorizontally;
    public boolean isCollidedVertically;
    public boolean isCollided;
    public boolean velocityChanged;
    public boolean isInWeb;
    public boolean field_70135_K = true;
    public boolean isDead;
    public float yOffset;
    public float width = 0.6f;
    public float height = 1.8f;
    public float prevDistanceWalkedModified;
    public float distanceWalkedModified;
    public float distanceWalkedOnStepModified;
    public float fallDistance;
    public int nextStepDistance = 1;
    public double lastTickPosX;
    public double lastTickPosY;
    public double lastTickPosZ;
    public float ySize;
    public float stepHeight;
    public boolean noClip;
    public float entityCollisionReduction;
    public Random rand;
    public int ticksExisted;
    public int fireResistance = 1;
    public int fire;
    public boolean inWater;
    public int hurtResistantTime;
    public boolean firstUpdate = true;
    public boolean isImmuneToFire;
    public DataWatcher dataWatcher;
    public double entityRiderPitchDelta;
    public double entityRiderYawDelta;
    public boolean addedToChunk;
    public int chunkCoordX;
    public int chunkCoordY;
    public int chunkCoordZ;
    @SideOnly(value=Side.CLIENT)
    public int serverPosX;
    @SideOnly(value=Side.CLIENT)
    public int serverPosY;
    @SideOnly(value=Side.CLIENT)
    public int serverPosZ;
    public boolean ignoreFrustumCheck;
    public boolean isAirBorne;
    public int timeUntilPortal;
    public boolean inPortal;
    public int portalCounter;
    public int dimension;
    public int teleportDirection;
    public boolean invulnerable;
    public UUID entityUniqueID;
    public EnumEntitySize myEntitySize;
    public NBTTagCompound customEntityData;
    public boolean captureDrops = false;
    public ArrayList<EntityItem> capturedDrops = new ArrayList();
    public UUID persistentID;
    public HashMap<String, IExtendedEntityProperties> extendedProperties;
    public int colorBetterBlood;

    public Entity(World world) {
        this.entityId = nextEntityID++;
        this.boundingBox = AxisAlignedBB._a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        this.rand = new Random();
        this.dataWatcher = new DataWatcher();
        this.entityUniqueID = UUID.randomUUID();
        this.myEntitySize = EnumEntitySize._b;
        this.worldObj = world;
        this.setPosition(0.0, 0.0, 0.0);
        if (world != null) {
            this.dimension = world.provider._i;
        }
        this.dataWatcher._a(0, (Object)0);
        this.dataWatcher._a(1, (Object)300);
        this.entityInit();
        this.extendedProperties = new HashMap();
        MinecraftForge.EVENT_BUS.post(new EntityEvent.EntityConstructing(this));
        for (IExtendedEntityProperties iExtendedEntityProperties : this.extendedProperties.values()) {
            iExtendedEntityProperties.init(this, world);
        }
    }

    public abstract void entityInit();

    public DataWatcher getDataWatcher() {
        return this.dataWatcher;
    }

    public boolean equals(Object object) {
        return object instanceof Entity ? ((Entity)object).entityId == this.entityId : false;
    }

    public int hashCode() {
        return this.entityId;
    }

    @SideOnly(value=Side.CLIENT)
    public void preparePlayerToSpawn() {
        if (this.worldObj != null) {
            while (this.posY > 0.0) {
                this.setPosition(this.posX, this.posY, this.posZ);
                if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty()) break;
                this.posY += 1.0;
            }
            this.motionZ = 0.0;
            this.motionY = 0.0;
            this.motionX = 0.0;
            this.rotationPitch = 0.0f;
        }
    }

    public void setDead() {
        this.isDead = true;
    }

    public void setSize(float f, float f2) {
        float f3;
        if (f != this.width || f2 != this.height) {
            f3 = this.width;
            this.width = f;
            this.height = f2;
            this.boundingBox._e = this.boundingBox._b + (double)this.width;
            this.boundingBox._g = this.boundingBox._d + (double)this.width;
            this.boundingBox._f = this.boundingBox._c + (double)this.height;
            if (this.width > f3 && !this.firstUpdate && !this.worldObj.isRemote) {
                this.moveEntity(f3 - this.width, 0.0, f3 - this.width);
            }
        }
        this.myEntitySize = (double)(f3 = f % 2.0f) < 0.375 ? EnumEntitySize._a : ((double)f3 < 0.75 ? EnumEntitySize._b : ((double)f3 < 1.0 ? EnumEntitySize._c : ((double)f3 < 1.375 ? EnumEntitySize._d : ((double)f3 < 1.75 ? EnumEntitySize._e : EnumEntitySize._f))));
    }

    public void setRotation(float f, float f2) {
        this.rotationYaw = f % 360.0f;
        this.rotationPitch = f2 % 360.0f;
    }

    public void setPosition(double d, double d2, double d3) {
        this.posX = d;
        this.posY = d2;
        this.posZ = d3;
        float f = this.width / 2.0f;
        float f2 = this.height;
        this.boundingBox._b(d - (double)f, d2 - (double)this.yOffset + (double)this.ySize, d3 - (double)f, d + (double)f, d2 - (double)this.yOffset + (double)this.ySize + (double)f2, d3 + (double)f);
    }

    @SideOnly(value=Side.CLIENT)
    public void setAngles(float f, float f2) {
        float f3 = this.rotationPitch;
        float f4 = this.rotationYaw;
        this.rotationYaw = (float)((double)this.rotationYaw + (double)f * 0.15);
        this.rotationPitch = (float)((double)this.rotationPitch - (double)f2 * 0.15);
        if (this.rotationPitch < -90.0f) {
            this.rotationPitch = -90.0f;
        }
        if (this.rotationPitch > 90.0f) {
            this.rotationPitch = 90.0f;
        }
        this.prevRotationPitch += this.rotationPitch - f3;
        this.prevRotationYaw += this.rotationYaw - f4;
    }

    public void onUpdate() {
        this.onEntityUpdate();
    }

    public void onEntityUpdate() {
        int n;
        int n2;
        int n3;
        int n4;
        this.worldObj.theProfiler._a("entityBaseTick");
        if (this.ridingEntity != null && this.ridingEntity.isDead) {
            this.ridingEntity = null;
        }
        this.prevDistanceWalkedModified = this.distanceWalkedModified;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.prevRotationPitch = this.rotationPitch;
        this.prevRotationYaw = this.rotationYaw;
        if (!this.worldObj.isRemote && this.worldObj instanceof WorldServer) {
            this.worldObj.theProfiler._a("portal");
            MinecraftServer minecraftServer = ((WorldServer)this.worldObj).getMinecraftServer();
            n4 = this.getMaxInPortalTime();
            if (this.inPortal) {
                if (minecraftServer._E()) {
                    if (this.ridingEntity == null && this.portalCounter++ >= n4) {
                        this.portalCounter = n4;
                        this.timeUntilPortal = this.getPortalCooldown();
                        n3 = this.worldObj.provider._i == -1 ? 0 : -1;
                        this.travelToDimension(n3);
                    }
                    this.inPortal = false;
                }
            } else {
                if (this.portalCounter > 0) {
                    this.portalCounter -= 4;
                }
                if (this.portalCounter < 0) {
                    this.portalCounter = 0;
                }
            }
            if (this.timeUntilPortal > 0) {
                --this.timeUntilPortal;
            }
            this.worldObj.theProfiler._b();
        }
        if (this.isSprinting() && !this.isInWater() && (n2 = this.worldObj.getBlockId(n = sajh._c(this.posX), n4 = sajh._c(this.posY - (double)0.2f - (double)this.yOffset), n3 = sajh._c(this.posZ))) > 0) {
            this.worldObj.spawnParticle("tilecrack_" + n2 + "_" + this.worldObj.getBlockMetadata(n, n4, n3), this.posX + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, this.boundingBox._c + 0.1, this.posZ + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, -this.motionX * 4.0, 1.5, -this.motionZ * 4.0);
        }
        this.handleWaterMovement();
        if (this.worldObj.isRemote) {
            this.fire = 0;
        } else if (this.fire > 0) {
            if (this.isImmuneToFire) {
                this.fire -= 4;
                if (this.fire < 0) {
                    this.fire = 0;
                }
            } else {
                if (this.fire % 20 == 0) {
                    this.attackEntityFrom(DamageSource.onFire, 1.0f);
                }
                --this.fire;
            }
        }
        if (this.handleLavaMovement()) {
            this.setOnFireFromLava();
            this.fallDistance *= 0.5f;
        }
        if (this.posY < -64.0) {
            this.kill();
        }
        if (!this.worldObj.isRemote) {
            this.setFlag(0, this.fire > 0);
        }
        this.firstUpdate = false;
        this.worldObj.theProfiler._b();
    }

    public int getMaxInPortalTime() {
        return 0;
    }

    public void setOnFireFromLava() {
        if (!this.isImmuneToFire) {
            this.attackEntityFrom(DamageSource.lava, 4.0f);
            this.setFire(15);
        }
    }

    public void setFire(int n) {
        int n2 = n * 20;
        if (this.fire < (n2 = EnchantmentProtection._a(this, n2))) {
            this.fire = n2;
        }
    }

    public void extinguish() {
        this.fire = 0;
    }

    public void kill() {
        this.setDead();
    }

    public boolean isOffsetPositionInLiquid(double d, double d2, double d3) {
        AxisAlignedBB axisAlignedBB = this.boundingBox._c(d, d2, d3);
        List list2 = this.worldObj.getCollidingBoundingBoxes(this, axisAlignedBB);
        return !list2.isEmpty() ? false : !this.worldObj.isAnyLiquid(axisAlignedBB);
    }

    public void moveEntity(double d, double d2, double d3) {
        if (this.noClip) {
            this.boundingBox._d(d, d2, d3);
            this.posX = (this.boundingBox._b + this.boundingBox._e) / 2.0;
            this.posY = this.boundingBox._c + (double)this.yOffset - (double)this.ySize;
            this.posZ = (this.boundingBox._d + this.boundingBox._g) / 2.0;
        } else {
            int n;
            double d4;
            double d5;
            double d6;
            int n2;
            int n3;
            boolean bl;
            this.worldObj.theProfiler._a("move");
            this.ySize *= 0.4f;
            double d7 = this.posX;
            double d8 = this.posY;
            double d9 = this.posZ;
            if (this.isInWeb) {
                this.isInWeb = false;
                d *= 0.25;
                d2 *= (double)0.05f;
                d3 *= 0.25;
                this.motionX = 0.0;
                this.motionY = 0.0;
                this.motionZ = 0.0;
            }
            double d10 = d;
            double d11 = d2;
            double d12 = d3;
            AxisAlignedBB axisAlignedBB = this.boundingBox._c();
            boolean bl2 = bl = this.onGround && this.isSneaking() && this instanceof EntityPlayer;
            if (bl) {
                double d13 = 0.05;
                while (d != 0.0 && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox._c(d, -1.0, 0.0)).isEmpty()) {
                    d = d < d13 && d >= -d13 ? 0.0 : (d > 0.0 ? (d -= d13) : (d += d13));
                    d10 = d;
                }
                while (d3 != 0.0 && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox._c(0.0, -1.0, d3)).isEmpty()) {
                    d3 = d3 < d13 && d3 >= -d13 ? 0.0 : (d3 > 0.0 ? (d3 -= d13) : (d3 += d13));
                    d12 = d3;
                }
                while (d != 0.0 && d3 != 0.0 && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox._c(d, -1.0, d3)).isEmpty()) {
                    d = d < d13 && d >= -d13 ? 0.0 : (d > 0.0 ? (d -= d13) : (d += d13));
                    d3 = d3 < d13 && d3 >= -d13 ? 0.0 : (d3 > 0.0 ? (d3 -= d13) : (d3 += d13));
                    d10 = d;
                    d12 = d3;
                }
            }
            List list2 = this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox._a(d, d2, d3));
            for (n3 = 0; n3 < list2.size(); ++n3) {
                d2 = ((AxisAlignedBB)list2.get(n3))._b(this.boundingBox, d2);
            }
            this.boundingBox._d(0.0, d2, 0.0);
            if (!this.field_70135_K && d11 != d2) {
                d3 = 0.0;
                d2 = 0.0;
                d = 0.0;
            }
            n3 = this.onGround || d11 != d2 && d11 < 0.0 ? 1 : 0;
            for (n2 = 0; n2 < list2.size(); ++n2) {
                d = ((AxisAlignedBB)list2.get(n2))._a(this.boundingBox, d);
            }
            this.boundingBox._d(d, 0.0, 0.0);
            if (!this.field_70135_K && d10 != d) {
                d3 = 0.0;
                d2 = 0.0;
                d = 0.0;
            }
            for (n2 = 0; n2 < list2.size(); ++n2) {
                d3 = ((AxisAlignedBB)list2.get(n2))._c(this.boundingBox, d3);
            }
            this.boundingBox._d(0.0, 0.0, d3);
            if (!this.field_70135_K && d12 != d3) {
                d3 = 0.0;
                d2 = 0.0;
                d = 0.0;
            }
            if (this.stepHeight > 0.0f && n3 != 0 && (bl || this.ySize < 0.05f) && (d10 != d || d12 != d3)) {
                d6 = d;
                d5 = d2;
                d4 = d3;
                d = d10;
                d2 = this.stepHeight;
                d3 = d12;
                AxisAlignedBB axisAlignedBB2 = this.boundingBox._c();
                this.boundingBox._c(axisAlignedBB);
                list2 = this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox._a(d10, d2, d12));
                for (n = 0; n < list2.size(); ++n) {
                    d2 = ((AxisAlignedBB)list2.get(n))._b(this.boundingBox, d2);
                }
                this.boundingBox._d(0.0, d2, 0.0);
                if (!this.field_70135_K && d11 != d2) {
                    d3 = 0.0;
                    d2 = 0.0;
                    d = 0.0;
                }
                for (n = 0; n < list2.size(); ++n) {
                    d = ((AxisAlignedBB)list2.get(n))._a(this.boundingBox, d);
                }
                this.boundingBox._d(d, 0.0, 0.0);
                if (!this.field_70135_K && d10 != d) {
                    d3 = 0.0;
                    d2 = 0.0;
                    d = 0.0;
                }
                for (n = 0; n < list2.size(); ++n) {
                    d3 = ((AxisAlignedBB)list2.get(n))._c(this.boundingBox, d3);
                }
                this.boundingBox._d(0.0, 0.0, d3);
                if (!this.field_70135_K && d12 != d3) {
                    d3 = 0.0;
                    d2 = 0.0;
                    d = 0.0;
                }
                if (!this.field_70135_K && d11 != d2) {
                    d3 = 0.0;
                    d2 = 0.0;
                    d = 0.0;
                } else {
                    d2 = -this.stepHeight;
                    for (n = 0; n < list2.size(); ++n) {
                        d2 = ((AxisAlignedBB)list2.get(n))._b(this.boundingBox, d2);
                    }
                    this.boundingBox._d(0.0, d2, 0.0);
                }
                if (d6 * d6 + d4 * d4 >= d * d + d3 * d3) {
                    d = d6;
                    d2 = d5;
                    d3 = d4;
                    this.boundingBox._c(axisAlignedBB2);
                }
            }
            this.worldObj.theProfiler._b();
            this.worldObj.theProfiler._a("rest");
            this.posX = (this.boundingBox._b + this.boundingBox._e) / 2.0;
            this.posY = this.boundingBox._c + (double)this.yOffset - (double)this.ySize;
            this.posZ = (this.boundingBox._d + this.boundingBox._g) / 2.0;
            this.isCollidedHorizontally = d10 != d || d12 != d3;
            this.isCollidedVertically = d11 != d2;
            this.onGround = d11 != d2 && d11 < 0.0;
            this.isCollided = this.isCollidedHorizontally || this.isCollidedVertically;
            this.updateFallState(d2, this.onGround);
            if (d10 != d) {
                this.motionX = 0.0;
            }
            if (d11 != d2) {
                this.motionY = 0.0;
            }
            if (d12 != d3) {
                this.motionZ = 0.0;
            }
            d6 = this.posX - d7;
            d5 = this.posY - d8;
            d4 = this.posZ - d9;
            if (this.canTriggerWalking() && !bl && this.ridingEntity == null) {
                int n4;
                int n5;
                int n6 = sajh._c(this.posX);
                int n7 = this.worldObj.getBlockId(n6, n = sajh._c(this.posY - (double)0.2f - (double)this.yOffset), n5 = sajh._c(this.posZ));
                if (n7 == 0 && ((n4 = this.worldObj.blockGetRenderType(n6, n - 1, n5)) == 11 || n4 == 32 || n4 == 21)) {
                    n7 = this.worldObj.getBlockId(n6, n - 1, n5);
                }
                if (n7 != Block.ladder.blockID) {
                    d5 = 0.0;
                }
                this.distanceWalkedModified = (float)((double)this.distanceWalkedModified + (double)sajh._a(d6 * d6 + d4 * d4) * 0.6);
                this.distanceWalkedOnStepModified = (float)((double)this.distanceWalkedOnStepModified + (double)sajh._a(d6 * d6 + d5 * d5 + d4 * d4) * 0.6);
                if (this.distanceWalkedOnStepModified > (float)this.nextStepDistance && n7 > 0) {
                    this.nextStepDistance = (int)this.distanceWalkedOnStepModified + 1;
                    if (this.isInWater()) {
                        float f = sajh._a(this.motionX * this.motionX * (double)0.2f + this.motionY * this.motionY + this.motionZ * this.motionZ * (double)0.2f) * 0.35f;
                        if (f > 1.0f) {
                            f = 1.0f;
                        }
                        this.playSound("liquid.swim", f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
                    }
                    this.playStepSound(n6, n, n5, n7);
                    Block.blocksList[n7].onEntityWalking(this.worldObj, n6, n, n5, this);
                }
            }
            try {
                this.doBlockCollisions();
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Checking entity tile collision");
                CrashReportCategory crashReportCategory = crashReport.makeCategory("Entity being checked for collision");
                this.addEntityCrashInfo(crashReportCategory);
                throw new turb(crashReport);
            }
            boolean bl3 = this.isWet();
            if (this.worldObj.isBoundingBoxBurning(this.boundingBox._e(0.001, 0.001, 0.001))) {
                this.dealFireDamage(1);
                if (!bl3) {
                    ++this.fire;
                    if (this.fire == 0) {
                        this.setFire(8);
                    }
                }
            } else if (this.fire <= 0) {
                this.fire = -this.fireResistance;
            }
            if (bl3 && this.fire > 0) {
                this.playSound("random.fizz", 0.7f, 1.6f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
                this.fire = -this.fireResistance;
            }
            this.worldObj.theProfiler._b();
        }
    }

    public void doBlockCollisions() {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6 = sajh._c(this.boundingBox._b + 0.001);
        if (this.worldObj.checkChunksExist(n6, n5 = sajh._c(this.boundingBox._c + 0.001), n4 = sajh._c(this.boundingBox._d + 0.001), n3 = sajh._c(this.boundingBox._e - 0.001), n2 = sajh._c(this.boundingBox._f - 0.001), n = sajh._c(this.boundingBox._g - 0.001))) {
            for (int i = n6; i <= n3; ++i) {
                for (int j = n5; j <= n2; ++j) {
                    for (int k = n4; k <= n; ++k) {
                        int n7 = this.worldObj.getBlockId(i, j, k);
                        if (n7 <= 0) continue;
                        try {
                            Block.blocksList[n7].onEntityCollidedWithBlock(this.worldObj, i, j, k, this);
                            continue;
                        }
                        catch (Throwable throwable) {
                            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Colliding entity with tile");
                            CrashReportCategory crashReportCategory = crashReport.makeCategory("Tile being collided with");
                            CrashReportCategory._a(crashReportCategory, i, j, k, n7, this.worldObj.getBlockMetadata(i, j, k));
                            throw new turb(crashReport);
                        }
                    }
                }
            }
        }
    }

    public void playStepSound(int n, int n2, int n3, int n4) {
        StepSound stepSound = Block.blocksList[n4].stepSound;
        if (this.worldObj.getBlockId(n, n2 + 1, n3) == Block.snow.blockID) {
            stepSound = Block.snow.stepSound;
            this.playSound(stepSound._d(), stepSound._a() * 0.15f, stepSound._b());
        } else if (!Block.blocksList[n4].blockMaterial._d()) {
            this.playSound(stepSound._d(), stepSound._a() * 0.15f, stepSound._b());
        }
    }

    public void playSound(String string, float f, float f2) {
        this.worldObj.playSoundAtEntity(this, string, f, f2);
    }

    public boolean canTriggerWalking() {
        return true;
    }

    public void updateFallState(double d, boolean bl) {
        if (bl) {
            if (this.fallDistance > 0.0f) {
                this.fall(this.fallDistance);
                this.fallDistance = 0.0f;
            }
        } else if (d < 0.0) {
            this.fallDistance = (float)((double)this.fallDistance - d);
        }
    }

    public AxisAlignedBB getBoundingBox() {
        return null;
    }

    public void dealFireDamage(int n) {
        if (!this.isImmuneToFire) {
            this.attackEntityFrom(DamageSource.inFire, n);
        }
    }

    public final boolean isImmuneToFire() {
        return this.isImmuneToFire;
    }

    public void fall(float f) {
        if (this.riddenByEntity != null) {
            this.riddenByEntity.fall(f);
        }
    }

    public boolean isWet() {
        return this.inWater || this.worldObj.canLightningStrikeAt(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ)) || this.worldObj.canLightningStrikeAt(sajh._c(this.posX), sajh._c(this.posY + (double)this.height), sajh._c(this.posZ));
    }

    public boolean isInWater() {
        return this.inWater;
    }

    public boolean handleWaterMovement() {
        if (this.worldObj.handleMaterialAcceleration(this.boundingBox._b(0.0, -0.4f, 0.0)._e(0.001, 0.001, 0.001), Material._h, this)) {
            if (!this.inWater && !this.firstUpdate) {
                float f;
                float f2;
                float f3 = sajh._a(this.motionX * this.motionX * (double)0.2f + this.motionY * this.motionY + this.motionZ * this.motionZ * (double)0.2f) * 0.2f;
                if (f3 > 1.0f) {
                    f3 = 1.0f;
                }
                this.playSound("liquid.splash", f3, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
                float f4 = sajh._c(this.boundingBox._c);
                int n = 0;
                while ((float)n < 1.0f + this.width * 20.0f) {
                    f2 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
                    f = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
                    this.worldObj.spawnParticle("bubble", this.posX + (double)f2, f4 + 1.0f, this.posZ + (double)f, this.motionX, this.motionY - (double)(this.rand.nextFloat() * 0.2f), this.motionZ);
                    ++n;
                }
                n = 0;
                while ((float)n < 1.0f + this.width * 20.0f) {
                    f2 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
                    f = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
                    this.worldObj.spawnParticle("splash", this.posX + (double)f2, f4 + 1.0f, this.posZ + (double)f, this.motionX, this.motionY, this.motionZ);
                    ++n;
                }
            }
            this.fallDistance = 0.0f;
            this.inWater = true;
            this.fire = 0;
        } else {
            this.inWater = false;
        }
        return this.inWater;
    }

    public boolean isInsideOfMaterial(Material material) {
        int n;
        int n2;
        double d = this.posY + (double)this.getEyeHeight();
        int n3 = sajh._c(this.posX);
        int n4 = this.worldObj.getBlockId(n3, n2 = sajh._d(sajh._c(d)), n = sajh._c(this.posZ));
        Block block = Block.blocksList[n4];
        if (block != null && block.blockMaterial == material) {
            double d2 = block.getFilledPercentage(this.worldObj, n3, n2, n);
            if (d2 < 0.0) {
                return d > (double)n2 + (1.0 - (d2 *= -1.0));
            }
            return d < (double)n2 + d2;
        }
        return false;
    }

    public float getEyeHeight() {
        return 0.0f;
    }

    public boolean handleLavaMovement() {
        return this.worldObj.isMaterialInBB(this.boundingBox._b(-0.1f, -0.4f, -0.1f), Material._i);
    }

    public void moveFlying(float f, float f2, float f3) {
        float f4 = f * f + f2 * f2;
        if (f4 >= 1.0E-4f) {
            if ((f4 = sajh._c(f4)) < 1.0f) {
                f4 = 1.0f;
            }
            f4 = f3 / f4;
            float f5 = sajh._a(this.rotationYaw * (float)Math.PI / 180.0f);
            float f6 = sajh._b(this.rotationYaw * (float)Math.PI / 180.0f);
            this.motionX += (double)((f *= f4) * f6 - (f2 *= f4) * f5);
            this.motionZ += (double)(f2 * f6 + f * f5);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public int getBrightnessForRender(float f) {
        int n;
        int n2 = sajh._c(this.posX);
        if (this.worldObj.blockExists(n2, 0, n = sajh._c(this.posZ))) {
            double d = (this.boundingBox._f - this.boundingBox._c) * 0.66;
            int n3 = sajh._c(this.posY - (double)this.yOffset + d);
            return this.worldObj.getLightBrightnessForSkyBlocks(n2, n3, n, 0);
        }
        return 0;
    }

    public float getBrightness(float f) {
        int n;
        int n2 = sajh._c(this.posX);
        if (this.worldObj.blockExists(n2, 0, n = sajh._c(this.posZ))) {
            double d = (this.boundingBox._f - this.boundingBox._c) * 0.66;
            int n3 = sajh._c(this.posY - (double)this.yOffset + d);
            return this.worldObj.getLightBrightness(n2, n3, n);
        }
        return 0.0f;
    }

    public void setWorld(World world) {
        this.worldObj = world;
    }

    public void setPositionAndRotation(double d, double d2, double d3, float f, float f2) {
        this.prevPosX = this.posX = d;
        this.prevPosY = this.posY = d2;
        this.prevPosZ = this.posZ = d3;
        this.prevRotationYaw = this.rotationYaw = f;
        this.prevRotationPitch = this.rotationPitch = f2;
        this.ySize = 0.0f;
        double d4 = this.prevRotationYaw - f;
        if (d4 < -180.0) {
            this.prevRotationYaw += 360.0f;
        }
        if (d4 >= 180.0) {
            this.prevRotationYaw -= 360.0f;
        }
        this.setPosition(this.posX, this.posY, this.posZ);
        this.setRotation(f, f2);
    }

    public void setLocationAndAngles(double d, double d2, double d3, float f, float f2) {
        this.prevPosX = this.posX = d;
        this.lastTickPosX = this.posX;
        this.prevPosY = this.posY = d2 + (double)this.yOffset;
        this.lastTickPosY = this.posY;
        this.prevPosZ = this.posZ = d3;
        this.lastTickPosZ = this.posZ;
        this.rotationYaw = f;
        this.rotationPitch = f2;
        this.setPosition(this.posX, this.posY, this.posZ);
    }

    public float getDistanceToEntity(Entity entity) {
        float f = (float)(this.posX - entity.posX);
        float f2 = (float)(this.posY - entity.posY);
        float f3 = (float)(this.posZ - entity.posZ);
        return sajh._c(f * f + f2 * f2 + f3 * f3);
    }

    public double getDistanceSq(double d, double d2, double d3) {
        double d4 = this.posX - d;
        double d5 = this.posY - d2;
        double d6 = this.posZ - d3;
        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    public double getDistance(double d, double d2, double d3) {
        double d4 = this.posX - d;
        double d5 = this.posY - d2;
        double d6 = this.posZ - d3;
        return sajh._a(d4 * d4 + d5 * d5 + d6 * d6);
    }

    public double getDistanceSqToEntity(Entity entity) {
        double d = this.posX - entity.posX;
        double d2 = this.posY - entity.posY;
        double d3 = this.posZ - entity.posZ;
        return d * d + d2 * d2 + d3 * d3;
    }

    public void onCollideWithPlayer(EntityPlayer entityPlayer) {
    }

    public void applyEntityCollision(Entity entity) {
        pidb._a(this, entity);
    }

    public void addVelocity(double d, double d2, double d3) {
        this.motionX += d;
        this.motionY += d2;
        this.motionZ += d3;
        this.isAirBorne = true;
    }

    public void setBeenAttacked() {
        this.velocityChanged = true;
    }

    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        this.setBeenAttacked();
        return false;
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean canBePushed() {
        return false;
    }

    public void addToPlayerScore(Entity entity, int n) {
    }

    @SideOnly(value=Side.CLIENT)
    public boolean isInRangeToRenderVec3D(Vec3 vec3) {
        double d = this.posX - vec3._c;
        double d2 = this.posY - vec3._d;
        double d3 = this.posZ - vec3._e;
        double d4 = d * d + d2 * d2 + d3 * d3;
        return this.isInRangeToRenderDist(d4);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean isInRangeToRenderDist(double d) {
        double d2 = this.boundingBox._b();
        return d < (d2 *= 64.0 * this.renderDistanceWeight) * d2;
    }

    public boolean writeMountToNBT(NBTTagCompound nBTTagCompound) {
        String string = this.getEntityString();
        if (!this.isDead && string != null) {
            nBTTagCompound._a("id", string);
            this.writeToNBT(nBTTagCompound);
            return true;
        }
        return false;
    }

    public boolean writeToNBTOptional(NBTTagCompound nBTTagCompound) {
        String string = this.getEntityString();
        if (!this.isDead && string != null && this.riddenByEntity == null) {
            nBTTagCompound._a("id", string);
            this.writeToNBT(nBTTagCompound);
            return true;
        }
        return false;
    }

    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        try {
            nBTTagCompound._a("Pos", this.newDoubleNBTList(this.posX, this.posY + (double)this.ySize, this.posZ));
            nBTTagCompound._a("Motion", this.newDoubleNBTList(this.motionX, this.motionY, this.motionZ));
            nBTTagCompound._a("Rotation", this.newFloatNBTList(this.rotationYaw, this.rotationPitch));
            nBTTagCompound._a("FallDistance", this.fallDistance);
            nBTTagCompound._a("Fire", (short)this.fire);
            nBTTagCompound._a("Air", (short)this.getAir());
            nBTTagCompound._a("OnGround", this.onGround);
            nBTTagCompound._a("Dimension", this.dimension);
            nBTTagCompound._a("Invulnerable", this.invulnerable);
            nBTTagCompound._a("PortalCooldown", this.timeUntilPortal);
            nBTTagCompound._a("UUIDMost", this.entityUniqueID.getMostSignificantBits());
            nBTTagCompound._a("UUIDLeast", this.entityUniqueID.getLeastSignificantBits());
            if (this.customEntityData != null) {
                nBTTagCompound._a("ForgeData", this.customEntityData);
            }
            Object object = this.extendedProperties.keySet().iterator();
            while (object.hasNext()) {
                String string = object.next();
                try {
                    IExtendedEntityProperties iExtendedEntityProperties = this.extendedProperties.get(string);
                    iExtendedEntityProperties.saveNBTData(nBTTagCompound);
                }
                catch (Throwable throwable) {
                    FMLLog.severe("Failed to save extended properties for %s.  This is a mod issue.", string);
                    throwable.printStackTrace();
                }
            }
            this.writeEntityToNBT(nBTTagCompound);
            if (this.ridingEntity != null && this.ridingEntity.writeMountToNBT((NBTTagCompound)(object = new NBTTagCompound("Riding")))) {
                nBTTagCompound._a("Riding", (NBTBase)object);
            }
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Saving entity NBT");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Entity being saved");
            this.addEntityCrashInfo(crashReportCategory);
            throw new turb(crashReport);
        }
    }

    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        try {
            NBTTagList nBTTagList = nBTTagCompound._n("Pos");
            NBTTagList nBTTagList2 = nBTTagCompound._n("Motion");
            NBTTagList nBTTagList3 = nBTTagCompound._n("Rotation");
            this.motionX = ((qoae)nBTTagList2._b((int)0))._c;
            this.motionY = ((qoae)nBTTagList2._b((int)1))._c;
            this.motionZ = ((qoae)nBTTagList2._b((int)2))._c;
            if (Math.abs(this.motionX) > 10.0) {
                this.motionX = 0.0;
            }
            if (Math.abs(this.motionY) > 10.0) {
                this.motionY = 0.0;
            }
            if (Math.abs(this.motionZ) > 10.0) {
                this.motionZ = 0.0;
            }
            this.lastTickPosX = this.posX = ((qoae)nBTTagList._b((int)0))._c;
            this.prevPosX = this.posX;
            this.lastTickPosY = this.posY = ((qoae)nBTTagList._b((int)1))._c;
            this.prevPosY = this.posY;
            this.lastTickPosZ = this.posZ = ((qoae)nBTTagList._b((int)2))._c;
            this.prevPosZ = this.posZ;
            this.prevRotationYaw = this.rotationYaw = ((jjly)nBTTagList3._b((int)0))._c;
            this.prevRotationPitch = this.rotationPitch = ((jjly)nBTTagList3._b((int)1))._c;
            this.fallDistance = nBTTagCompound._h("FallDistance");
            this.fire = nBTTagCompound._e("Fire");
            this.setAir(nBTTagCompound._e("Air"));
            this.onGround = nBTTagCompound._o("OnGround");
            this.dimension = nBTTagCompound._f("Dimension");
            this.invulnerable = nBTTagCompound._o("Invulnerable");
            this.timeUntilPortal = nBTTagCompound._f("PortalCooldown");
            if (nBTTagCompound._c("UUIDMost") && nBTTagCompound._c("UUIDLeast")) {
                this.entityUniqueID = new UUID(nBTTagCompound._g("UUIDMost"), nBTTagCompound._g("UUIDLeast"));
            }
            this.setPosition(this.posX, this.posY, this.posZ);
            this.setRotation(this.rotationYaw, this.rotationPitch);
            if (nBTTagCompound._c("ForgeData")) {
                this.customEntityData = nBTTagCompound._m("ForgeData");
            }
            for (String string : this.extendedProperties.keySet()) {
                try {
                    IExtendedEntityProperties iExtendedEntityProperties = this.extendedProperties.get(string);
                    iExtendedEntityProperties.loadNBTData(nBTTagCompound);
                }
                catch (Throwable throwable) {
                    FMLLog.severe("Failed to load extended properties for %s.  This is a mod issue.", string);
                    throwable.printStackTrace();
                }
            }
            if (nBTTagCompound._c("PersistentIDMSB") && nBTTagCompound._c("PersistentIDLSB")) {
                this.entityUniqueID = new UUID(nBTTagCompound._g("PersistentIDMSB"), nBTTagCompound._g("PersistentIDLSB"));
            }
            this.readEntityFromNBT(nBTTagCompound);
            if (this.shouldSetPosAfterLoading()) {
                this.setPosition(this.posX, this.posY, this.posZ);
            }
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Loading entity NBT");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Entity being loaded");
            this.addEntityCrashInfo(crashReportCategory);
            throw new turb(crashReport);
        }
    }

    public boolean shouldSetPosAfterLoading() {
        return true;
    }

    public final String getEntityString() {
        return jgro._b(this);
    }

    public abstract void readEntityFromNBT(NBTTagCompound var1);

    public abstract void writeEntityToNBT(NBTTagCompound var1);

    public void onChunkLoad() {
    }

    public NBTTagList newDoubleNBTList(double ... dArray) {
        NBTTagList nBTTagList = new NBTTagList();
        double[] dArray2 = dArray;
        int n = dArray.length;
        for (int i = 0; i < n; ++i) {
            double d = dArray2[i];
            nBTTagList._a(new qoae(null, d));
        }
        return nBTTagList;
    }

    public NBTTagList newFloatNBTList(float ... fArray) {
        NBTTagList nBTTagList = new NBTTagList();
        float[] fArray2 = fArray;
        int n = fArray.length;
        for (int i = 0; i < n; ++i) {
            float f = fArray2[i];
            nBTTagList._a(new jjly(null, f));
        }
        return nBTTagList;
    }

    @SideOnly(value=Side.CLIENT)
    public float getShadowSize() {
        return this.height / 2.0f;
    }

    public EntityItem dropItem(int n, int n2) {
        return this.dropItemWithOffset(n, n2, 0.0f);
    }

    public EntityItem dropItemWithOffset(int n, int n2, float f) {
        return this.entityDropItem(new ItemStack(n, n2, 0), f);
    }

    public EntityItem entityDropItem(ItemStack itemStack, float f) {
        if (itemStack._b == 0) {
            return null;
        }
        EntityItem entityItem = new EntityItem(this.worldObj, this.posX, this.posY + (double)f, this.posZ, itemStack);
        entityItem.delayBeforeCanPickup = 10;
        if (this.captureDrops) {
            this.capturedDrops.add(entityItem);
        } else {
            this.worldObj.spawnEntityInWorld(entityItem);
        }
        return entityItem;
    }

    public boolean isEntityAlive() {
        return !this.isDead;
    }

    public boolean isEntityInsideOpaqueBlock() {
        for (int i = 0; i < 8; ++i) {
            int n;
            int n2;
            float f = ((float)((i >> 0) % 2) - 0.5f) * this.width * 0.8f;
            float f2 = ((float)((i >> 1) % 2) - 0.5f) * 0.1f;
            float f3 = ((float)((i >> 2) % 2) - 0.5f) * this.width * 0.8f;
            int n3 = sajh._c(this.posX + (double)f);
            if (!this.worldObj.isBlockNormalCube(n3, n2 = sajh._c(this.posY + (double)this.getEyeHeight() + (double)f2), n = sajh._c(this.posZ + (double)f3))) continue;
            return true;
        }
        return false;
    }

    public boolean interactFirst(EntityPlayer entityPlayer) {
        return false;
    }

    public AxisAlignedBB getCollisionBox(Entity entity) {
        return null;
    }

    public void updateRidden() {
        if (this.ridingEntity.isDead) {
            this.ridingEntity = null;
        } else {
            this.motionX = 0.0;
            this.motionY = 0.0;
            this.motionZ = 0.0;
            this.onUpdate();
            if (this.ridingEntity != null) {
                this.ridingEntity.updateRiderPosition();
                this.entityRiderYawDelta += (double)(this.ridingEntity.rotationYaw - this.ridingEntity.prevRotationYaw);
                this.entityRiderPitchDelta += (double)(this.ridingEntity.rotationPitch - this.ridingEntity.prevRotationPitch);
                while (this.entityRiderYawDelta >= 180.0) {
                    this.entityRiderYawDelta -= 360.0;
                }
                while (this.entityRiderYawDelta < -180.0) {
                    this.entityRiderYawDelta += 360.0;
                }
                while (this.entityRiderPitchDelta >= 180.0) {
                    this.entityRiderPitchDelta -= 360.0;
                }
                while (this.entityRiderPitchDelta < -180.0) {
                    this.entityRiderPitchDelta += 360.0;
                }
                double d = this.entityRiderYawDelta * 0.5;
                double d2 = this.entityRiderPitchDelta * 0.5;
                float f = 10.0f;
                if (d > (double)f) {
                    d = f;
                }
                if (d < (double)(-f)) {
                    d = -f;
                }
                if (d2 > (double)f) {
                    d2 = f;
                }
                if (d2 < (double)(-f)) {
                    d2 = -f;
                }
                this.entityRiderYawDelta -= d;
                this.entityRiderPitchDelta -= d2;
            }
        }
    }

    public void updateRiderPosition() {
        if (this.riddenByEntity != null) {
            this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ);
        }
    }

    public double getYOffset() {
        return this.yOffset;
    }

    public double getMountedYOffset() {
        return (double)this.height * 0.75;
    }

    public void mountEntity(Entity entity) {
        this.entityRiderPitchDelta = 0.0;
        this.entityRiderYawDelta = 0.0;
        if (entity == null) {
            if (this.ridingEntity != null) {
                this.setLocationAndAngles(this.ridingEntity.posX, this.ridingEntity.boundingBox._c + (double)this.ridingEntity.height, this.ridingEntity.posZ, this.rotationYaw, this.rotationPitch);
                this.ridingEntity.riddenByEntity = null;
            }
            this.ridingEntity = null;
        } else {
            if (this.ridingEntity != null) {
                this.ridingEntity.riddenByEntity = null;
            }
            this.ridingEntity = entity;
            entity.riddenByEntity = this;
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void setPositionAndRotation2(double d, double d2, double d3, float f, float f2, int n) {
        this.setPosition(d, d2, d3);
        this.setRotation(f, f2);
        List list2 = this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox._e(0.03125, 0.0, 0.03125));
        if (!list2.isEmpty()) {
            double d4 = 0.0;
            for (int i = 0; i < list2.size(); ++i) {
                AxisAlignedBB axisAlignedBB = (AxisAlignedBB)list2.get(i);
                if (!(axisAlignedBB._f > d4)) continue;
                d4 = axisAlignedBB._f;
            }
            this.setPosition(d, d2 += d4 - this.boundingBox._c, d3);
        }
    }

    public float getCollisionBorderSize() {
        return 0.1f;
    }

    public Vec3 getLookVec() {
        return null;
    }

    public void setInPortal() {
        if (this.timeUntilPortal > 0) {
            this.timeUntilPortal = this.getPortalCooldown();
        } else {
            double d = this.prevPosX - this.posX;
            double d2 = this.prevPosZ - this.posZ;
            if (!this.worldObj.isRemote && !this.inPortal) {
                this.teleportDirection = ugqx._a(d, d2);
            }
            this.inPortal = true;
        }
    }

    public int getPortalCooldown() {
        return 900;
    }

    @SideOnly(value=Side.CLIENT)
    public void setVelocity(double d, double d2, double d3) {
        this.motionX = d;
        this.motionY = d2;
        this.motionZ = d3;
    }

    @SideOnly(value=Side.CLIENT)
    public void handleHealthUpdate(byte by) {
    }

    @SideOnly(value=Side.CLIENT)
    public void performHurtAnimation() {
    }

    public ItemStack[] func_70035_c() {
        return null;
    }

    public void setCurrentItemOrArmor(int n, ItemStack itemStack) {
    }

    public boolean isBurning() {
        return !this.isImmuneToFire && (this.fire > 0 || this.getFlag(0));
    }

    public boolean isRiding() {
        return this.ridingEntity != null && this.ridingEntity.shouldRiderSit();
    }

    public boolean isSneaking() {
        return this.getFlag(1);
    }

    public void setSneaking(boolean bl) {
        this.setFlag(1, bl);
    }

    public boolean isSprinting() {
        return this.getFlag(3);
    }

    public void setSprinting(boolean bl) {
        this.setFlag(3, bl);
    }

    public boolean isInvisible() {
        return this.getFlag(5);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean isInvisibleToPlayer(EntityPlayer entityPlayer) {
        return this.isInvisible();
    }

    public void setInvisible(boolean bl) {
        this.setFlag(5, bl);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean isEating() {
        return this.getFlag(4);
    }

    public void setEating(boolean bl) {
        this.setFlag(4, bl);
    }

    public boolean getFlag(int n) {
        return (this.dataWatcher._a(0) & 1 << n) != 0;
    }

    public void setFlag(int n, boolean bl) {
        byte by = this.dataWatcher._a(0);
        if (bl) {
            this.dataWatcher._b(0, (byte)(by | 1 << n));
        } else {
            this.dataWatcher._b(0, (byte)(by & ~(1 << n)));
        }
    }

    public int getAir() {
        return this.dataWatcher._b(1);
    }

    public void setAir(int n) {
        this.dataWatcher._b(1, (short)n);
    }

    public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
        this.dealFireDamage(5);
        ++this.fire;
        if (this.fire == 0) {
            this.setFire(8);
        }
    }

    public void onKillEntity(EntityLivingBase entityLivingBase) {
    }

    public boolean pushOutOfBlocks(double d, double d2, double d3) {
        int n = sajh._c(d);
        int n2 = sajh._c(d2);
        int n3 = sajh._c(d3);
        double d4 = d - (double)n;
        double d5 = d2 - (double)n2;
        double d6 = d3 - (double)n3;
        List list2 = this.worldObj.getCollidingBlockBounds(this.boundingBox);
        if (list2.isEmpty() && !this.worldObj.isBlockFullCube(n, n2, n3)) {
            return false;
        }
        boolean bl = !this.worldObj.isBlockFullCube(n - 1, n2, n3);
        boolean bl2 = !this.worldObj.isBlockFullCube(n + 1, n2, n3);
        boolean bl3 = !this.worldObj.isBlockFullCube(n, n2 - 1, n3);
        boolean bl4 = !this.worldObj.isBlockFullCube(n, n2 + 1, n3);
        boolean bl5 = !this.worldObj.isBlockFullCube(n, n2, n3 - 1);
        boolean bl6 = !this.worldObj.isBlockFullCube(n, n2, n3 + 1);
        int n4 = 3;
        double d7 = 9999.0;
        if (bl && d4 < d7) {
            d7 = d4;
            n4 = 0;
        }
        if (bl2 && 1.0 - d4 < d7) {
            d7 = 1.0 - d4;
            n4 = 1;
        }
        if (bl4 && 1.0 - d5 < d7) {
            d7 = 1.0 - d5;
            n4 = 3;
        }
        if (bl5 && d6 < d7) {
            d7 = d6;
            n4 = 4;
        }
        if (bl6 && 1.0 - d6 < d7) {
            d7 = 1.0 - d6;
            n4 = 5;
        }
        float f = this.rand.nextFloat() * 0.2f + 0.1f;
        if (n4 == 0) {
            this.motionX = -f;
        }
        if (n4 == 1) {
            this.motionX = f;
        }
        if (n4 == 2) {
            this.motionY = -f;
        }
        if (n4 == 3) {
            this.motionY = f;
        }
        if (n4 == 4) {
            this.motionZ = -f;
        }
        if (n4 == 5) {
            this.motionZ = f;
        }
        return true;
    }

    public void setInWeb() {
        this.isInWeb = true;
        this.fallDistance = 0.0f;
    }

    public String getEntityName() {
        String string = jgro._b(this);
        if (string == null) {
            string = "generic";
        }
        return tdpx._a("entity." + string + ".name");
    }

    public Entity[] getParts() {
        return null;
    }

    public boolean isEntityEqual(Entity entity) {
        return this == entity;
    }

    public float getRotationYawHead() {
        return 0.0f;
    }

    @SideOnly(value=Side.CLIENT)
    public void setRotationYawHead(float f) {
    }

    public boolean canAttackWithItem() {
        return true;
    }

    public boolean hitByEntity(Entity entity) {
        return false;
    }

    public String toString() {
        return String.format("%s['%s'/%d, l='%s', x=%.2f, y=%.2f, z=%.2f]", this.getClass().getSimpleName(), this.getEntityName(), this.entityId, this.worldObj == null ? "~NULL~" : this.worldObj.getWorldInfo()._k(), this.posX, this.posY, this.posZ);
    }

    public boolean isEntityInvulnerable() {
        return this.invulnerable;
    }

    public void copyLocationAndAnglesFrom(Entity entity) {
        this.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
    }

    public void copyDataFrom(Entity entity, boolean bl) {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        entity.writeToNBT(nBTTagCompound);
        this.readFromNBT(nBTTagCompound);
        this.timeUntilPortal = entity.timeUntilPortal;
        this.teleportDirection = entity.teleportDirection;
    }

    public void travelToDimension(int n) {
        if (!this.worldObj.isRemote && !this.isDead) {
            this.worldObj.theProfiler._a("changeDimension");
            MinecraftServer minecraftServer = MinecraftServer._I();
            int n2 = this.dimension;
            WorldServer worldServer = minecraftServer._a(n2);
            WorldServer worldServer2 = minecraftServer._a(n);
            this.dimension = n;
            if (n2 == 1 && n == 1) {
                worldServer2 = minecraftServer._a(0);
                this.dimension = 0;
            }
            this.worldObj.removeEntity(this);
            this.isDead = false;
            this.worldObj.theProfiler._a("reposition");
            minecraftServer.__ag()._a(this, n2, worldServer, worldServer2);
            this.worldObj.theProfiler._c("reloading");
            Entity entity = jgro._a(jgro._b(this), (World)worldServer2);
            if (entity != null) {
                entity.copyDataFrom(this, true);
                if (n2 == 1 && n == 1) {
                    ChunkCoordinates chunkCoordinates = worldServer2.getSpawnPoint();
                    chunkCoordinates._b = this.worldObj.getTopSolidOrLiquidBlock(chunkCoordinates._a, chunkCoordinates._c);
                    entity.setLocationAndAngles(chunkCoordinates._a, chunkCoordinates._b, chunkCoordinates._c, entity.rotationYaw, entity.rotationPitch);
                }
                worldServer2.spawnEntityInWorld(entity);
            }
            this.isDead = true;
            this.worldObj.theProfiler._b();
            worldServer.resetUpdateEntityTick();
            worldServer2.resetUpdateEntityTick();
            this.worldObj.theProfiler._b();
        }
    }

    public float getBlockExplosionResistance(Explosion explosion, World world, int n, int n2, int n3, Block block) {
        return block.getExplosionResistance(this, world, n, n2, n3, this.posX, this.posY + (double)this.getEyeHeight(), this.posZ);
    }

    public boolean shouldExplodeBlock(Explosion explosion, World world, int n, int n2, int n3, int n4, float f) {
        return true;
    }

    public int getMaxSafePointTries() {
        return 3;
    }

    public int getTeleportDirection() {
        return this.teleportDirection;
    }

    public boolean doesEntityNotTriggerPressurePlate() {
        return false;
    }

    public void addEntityCrashInfo(CrashReportCategory crashReportCategory) {
        crashReportCategory._a("Entity Type", new eidj(this));
        crashReportCategory._a("Entity ID", this.entityId);
        crashReportCategory._a("Entity Name", new kjui(this));
        crashReportCategory._a("Entity's Exact location", String.format("%.2f, %.2f, %.2f", this.posX, this.posY, this.posZ));
        crashReportCategory._a("Entity's Block location", CrashReportCategory._a(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ)));
        crashReportCategory._a("Entity's Momentum", String.format("%.2f, %.2f, %.2f", this.motionX, this.motionY, this.motionZ));
    }

    @SideOnly(value=Side.CLIENT)
    public boolean canRenderOnFire() {
        return this.isBurning();
    }

    public UUID getUniqueID() {
        return this.entityUniqueID;
    }

    public boolean isPushedByWater() {
        return true;
    }

    public String getTranslatedEntityName() {
        return this.getEntityName();
    }

    public NBTTagCompound getEntityData() {
        if (this.customEntityData == null) {
            this.customEntityData = new NBTTagCompound();
        }
        return this.customEntityData;
    }

    public boolean shouldRiderSit() {
        return true;
    }

    public ItemStack getPickedResult(MovingObjectPosition movingObjectPosition) {
        if (this instanceof EntityPainting) {
            return new ItemStack(Item.painting);
        }
        if (this instanceof EntityMinecart) {
            return ((EntityMinecart)this).getCartItem();
        }
        if (this instanceof EntityBoat) {
            return new ItemStack(Item.boat);
        }
        if (this instanceof EntityItemFrame) {
            ItemStack itemStack = ((EntityItemFrame)this).getDisplayedItem();
            if (itemStack == null) {
                return new ItemStack(Item.itemFrame);
            }
            return itemStack._l();
        }
        if (this instanceof EntityLeashKnot) {
            return new ItemStack(Item.leash);
        }
        int n = jgro._a(this);
        if (n > 0 && jgro._f.containsKey(n)) {
            return new ItemStack(Item.monsterPlacer, 1, n);
        }
        return null;
    }

    public UUID getPersistentID() {
        return this.entityUniqueID;
    }

    public final void resetEntityId() {
        this.entityId = nextEntityID++;
    }

    public boolean shouldRenderInPass(int n) {
        return n == 0;
    }

    public boolean isCreatureType(EnumCreatureType enumCreatureType, boolean bl) {
        return enumCreatureType._a().isAssignableFrom(this.getClass());
    }

    public String registerExtendedProperties(String string, IExtendedEntityProperties iExtendedEntityProperties) {
        if (string == null) {
            FMLLog.warning("Someone is attempting to register extended properties using a null identifier.  This is not allowed.  Aborting.  This may have caused instability.", new Object[0]);
            return "";
        }
        if (iExtendedEntityProperties == null) {
            FMLLog.warning("Someone is attempting to register null extended properties.  This is not allowed.  Aborting.  This may have caused instability.", new Object[0]);
            return "";
        }
        String string2 = string;
        int n = 1;
        while (this.extendedProperties.containsKey(string)) {
            string = String.format("%s%d", string2, n++);
        }
        if (string2 != string) {
            FMLLog.info("An attempt was made to register exended properties using an existing key.  The duplicate identifier (%s) has been remapped to %s.", string2, string);
        }
        this.extendedProperties.put(string, iExtendedEntityProperties);
        return string;
    }

    public IExtendedEntityProperties getExtendedProperties(String string) {
        return this.extendedProperties.get(string);
    }

    public boolean canRiderInteract() {
        return false;
    }

    public boolean shouldDismountInWater(Entity entity) {
        return this instanceof EntityLivingBase;
    }

    @Override
    public int getColorBetterBlood() {
        if (this.colorBetterBlood == 0) {
            this.colorBetterBlood = BetterBloodRenderer.getColorBetterBlood(this.getClass());
        }
        return this.colorBetterBlood;
    }
}

