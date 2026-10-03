/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.entity.item.EntityMinecartEmpty;
import net.minecraft.entity.item.EntityMinecartFurnace;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.IMinecartCollisionHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.minecart.MinecartCollisionEvent;
import net.minecraftforge.event.entity.minecart.MinecartUpdateEvent;

public abstract class EntityMinecart
extends Entity {
    public boolean isInReverse;
    public final IUpdatePlayerListBox field_82344_g;
    public String entityName;
    public static final int[][][] matrix = new int[][][]{new int[][]{{0, 0, -1}, {0, 0, 1}}, new int[][]{{-1, 0, 0}, {1, 0, 0}}, new int[][]{{-1, -1, 0}, {1, 0, 0}}, new int[][]{{-1, 0, 0}, {1, -1, 0}}, new int[][]{{0, 0, -1}, {0, -1, 1}}, new int[][]{{0, -1, -1}, {0, 0, 1}}, new int[][]{{0, 0, 1}, {1, 0, 0}}, new int[][]{{0, 0, 1}, {-1, 0, 0}}, new int[][]{{0, 0, -1}, {-1, 0, 0}}, new int[][]{{0, 0, -1}, {1, 0, 0}}};
    public int turnProgress;
    public double minecartX;
    public double minecartY;
    public double minecartZ;
    public double minecartYaw;
    public double minecartPitch;
    @SideOnly(value=Side.CLIENT)
    public double velocityX;
    @SideOnly(value=Side.CLIENT)
    public double velocityY;
    @SideOnly(value=Side.CLIENT)
    public double velocityZ;
    public static float defaultMaxSpeedAirLateral = 0.4f;
    public static float defaultMaxSpeedAirVertical = -1.0f;
    public static double defaultDragAir = 0.95f;
    public boolean canUseRail = true;
    public boolean canBePushed = true;
    public static IMinecartCollisionHandler collisionHandler = null;
    public float currentSpeedRail = this.getMaxCartSpeedOnRail();
    public float maxSpeedAirLateral = defaultMaxSpeedAirLateral;
    public float maxSpeedAirVertical = defaultMaxSpeedAirVertical;
    public double dragAir = defaultDragAir;

    public EntityMinecart(World world) {
        super(world);
        this.preventEntitySpawning = true;
        this.setSize(0.98f, 0.7f);
        this.yOffset = this.height / 2.0f;
        this.field_82344_g = world != null ? world.getMinecartSoundUpdater(this) : null;
    }

    public static EntityMinecart createMinecart(World world, double d, double d2, double d3, int n) {
        switch (n) {
            case 1: {
                return new EntityMinecartChest(world, d, d2, d3);
            }
            case 2: {
                return new EntityMinecartFurnace(world, d, d2, d3);
            }
            case 3: {
                return new EntityMinecartTNT(world, d, d2, d3);
            }
            case 4: {
                return new EntityMinecartMobSpawner(world, d, d2, d3);
            }
            case 5: {
                return new EntityMinecartHopper(world, d, d2, d3);
            }
        }
        return new EntityMinecartEmpty(world, d, d2, d3);
    }

    @Override
    public boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void entityInit() {
        this.dataWatcher._a(17, new Integer(0));
        this.dataWatcher._a(18, new Integer(1));
        this.dataWatcher._a(19, new Float(0.0f));
        this.dataWatcher._a(20, new Integer(0));
        this.dataWatcher._a(21, new Integer(6));
        this.dataWatcher._a(22, (Object)0);
    }

    @Override
    public AxisAlignedBB getCollisionBox(Entity entity) {
        if (EntityMinecart.getCollisionHandler() != null) {
            return EntityMinecart.getCollisionHandler().getCollisionBox(this, entity);
        }
        return entity.canBePushed() ? entity.boundingBox : null;
    }

    @Override
    public AxisAlignedBB getBoundingBox() {
        if (EntityMinecart.getCollisionHandler() != null) {
            return EntityMinecart.getCollisionHandler().getBoundingBox(this);
        }
        return null;
    }

    @Override
    public boolean canBePushed() {
        return this.canBePushed;
    }

    public EntityMinecart(World world, double d, double d2, double d3) {
        this(world);
        this.setPosition(d, d2, d3);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = d;
        this.prevPosY = d2;
        this.prevPosZ = d3;
    }

    @Override
    public double getMountedYOffset() {
        return (double)this.height * 0.0 - (double)0.3f;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (!this.worldObj.isRemote && !this.isDead) {
            boolean bl;
            if (this.isEntityInvulnerable()) {
                return false;
            }
            this.setRollingDirection(-this.getRollingDirection());
            this.setRollingAmplitude(10);
            this.setBeenAttacked();
            this.setDamage(this.getDamage() + f * 10.0f);
            boolean bl2 = bl = damageSource.getEntity() instanceof EntityPlayer && ((EntityPlayer)damageSource.getEntity()).capabilities._d;
            if (bl || this.getDamage() > 40.0f) {
                if (this.riddenByEntity != null) {
                    this.riddenByEntity.mountEntity(this);
                }
                if (bl && !this.isInvNameLocalized()) {
                    this.setDead();
                } else {
                    this.killMinecart(damageSource);
                }
            }
            return true;
        }
        return true;
    }

    public void killMinecart(DamageSource damageSource) {
        this.setDead();
        ItemStack itemStack = new ItemStack(Item.minecartEmpty, 1);
        if (this.entityName != null) {
            itemStack._a(this.entityName);
        }
        this.entityDropItem(itemStack, 0.0f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void performHurtAnimation() {
        this.setRollingDirection(-this.getRollingDirection());
        this.setRollingAmplitude(10);
        this.setDamage(this.getDamage() + this.getDamage() * 10.0f);
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    @Override
    public void setDead() {
        super.setDead();
        if (this.field_82344_g != null) {
            this.field_82344_g._a();
        }
    }

    @Override
    public void onUpdate() {
        int n;
        int n2;
        if (this.field_82344_g != null) {
            this.field_82344_g._a();
        }
        if (this.getRollingAmplitude() > 0) {
            this.setRollingAmplitude(this.getRollingAmplitude() - 1);
        }
        if (this.getDamage() > 0.0f) {
            this.setDamage(this.getDamage() - 1.0f);
        }
        if (this.posY < -64.0) {
            this.kill();
        }
        if (!this.worldObj.isRemote && this.worldObj instanceof WorldServer) {
            this.worldObj.theProfiler._a("portal");
            MinecraftServer minecraftServer = ((WorldServer)this.worldObj).getMinecraftServer();
            n2 = this.getMaxInPortalTime();
            if (this.inPortal) {
                if (minecraftServer._E()) {
                    if (this.ridingEntity == null && this.portalCounter++ >= n2) {
                        this.portalCounter = n2;
                        this.timeUntilPortal = this.getPortalCooldown();
                        n = this.worldObj.provider._i == -1 ? 0 : -1;
                        this.travelToDimension(n);
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
        if (this.worldObj.isRemote) {
            if (this.turnProgress > 0) {
                double d = this.posX + (this.minecartX - this.posX) / (double)this.turnProgress;
                double d2 = this.posY + (this.minecartY - this.posY) / (double)this.turnProgress;
                double d3 = this.posZ + (this.minecartZ - this.posZ) / (double)this.turnProgress;
                double d4 = sajh._f(this.minecartYaw - (double)this.rotationYaw);
                this.rotationYaw = (float)((double)this.rotationYaw + d4 / (double)this.turnProgress);
                this.rotationPitch = (float)((double)this.rotationPitch + (this.minecartPitch - (double)this.rotationPitch) / (double)this.turnProgress);
                --this.turnProgress;
                this.setPosition(d, d2, d3);
                this.setRotation(this.rotationYaw, this.rotationPitch);
            } else {
                this.setPosition(this.posX, this.posY, this.posZ);
                this.setRotation(this.rotationYaw, this.rotationPitch);
            }
        } else {
            double d;
            double d5;
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            this.motionY -= (double)0.04f;
            int n3 = sajh._c(this.posX);
            if (BlockRailBase._a(this.worldObj, n3, (n2 = sajh._c(this.posY)) - 1, n = sajh._c(this.posZ))) {
                --n2;
            }
            double d6 = 0.4;
            double d7 = 0.0078125;
            int n4 = this.worldObj.getBlockId(n3, n2, n);
            if (this.canUseRail() && BlockRailBase._a(n4)) {
                BlockRailBase blockRailBase = (BlockRailBase)Block.blocksList[n4];
                float f = blockRailBase._a(this.worldObj, this, n3, n2, n);
                d5 = Math.min(f, this.getCurrentCartSpeedCapOnRail());
                int n5 = blockRailBase._a((IBlockAccess)this.worldObj, this, n3, n2, n);
                this.updateOnTrack(n3, n2, n, d5, this.getSlopeAdjustment(), n4, n5);
                if (n4 == Block.railActivator.blockID) {
                    this.onActivatorRailPass(n3, n2, n, (this.worldObj.getBlockMetadata(n3, n2, n) & 8) != 0);
                }
            } else {
                this.func_94088_b(this.onGround ? d6 : (double)this.getMaxSpeedAirLateral());
            }
            this.doBlockCollisions();
            this.rotationPitch = 0.0f;
            double d8 = this.prevPosX - this.posX;
            d5 = this.prevPosZ - this.posZ;
            if (d8 * d8 + d5 * d5 > 0.001) {
                this.rotationYaw = (float)(Math.atan2(d5, d8) * 180.0 / Math.PI);
                if (this.isInReverse) {
                    this.rotationYaw += 180.0f;
                }
            }
            if ((d = (double)sajh._g(this.rotationYaw - this.prevRotationYaw)) < -170.0 || d >= 170.0) {
                this.rotationYaw += 180.0f;
                this.isInReverse = !this.isInReverse;
            }
            this.setRotation(this.rotationYaw, this.rotationPitch);
            AxisAlignedBB axisAlignedBB = EntityMinecart.getCollisionHandler() != null ? EntityMinecart.getCollisionHandler().getMinecartCollisionBox(this) : this.boundingBox._b(0.2, 0.0, 0.2);
            List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, axisAlignedBB);
            if (list2 != null && !list2.isEmpty()) {
                for (int i = 0; i < list2.size(); ++i) {
                    Entity entity = (Entity)list2.get(i);
                    if (entity == this.riddenByEntity || !entity.canBePushed() || !(entity instanceof EntityMinecart)) continue;
                    entity.applyEntityCollision(this);
                }
            }
            if (this.riddenByEntity != null && this.riddenByEntity.isDead) {
                if (this.riddenByEntity.ridingEntity == this) {
                    this.riddenByEntity.ridingEntity = null;
                }
                this.riddenByEntity = null;
            }
            MinecraftForge.EVENT_BUS.post(new MinecartUpdateEvent(this, n3, n2, n));
        }
    }

    public void onActivatorRailPass(int n, int n2, int n3, boolean bl) {
    }

    public void func_94088_b(double d) {
        if (this.motionX < -d) {
            this.motionX = -d;
        }
        if (this.motionX > d) {
            this.motionX = d;
        }
        if (this.motionZ < -d) {
            this.motionZ = -d;
        }
        if (this.motionZ > d) {
            this.motionZ = d;
        }
        double d2 = this.motionY;
        if (this.getMaxSpeedAirVertical() > 0.0f && this.motionY > (double)this.getMaxSpeedAirVertical()) {
            d2 = this.getMaxSpeedAirVertical();
            if (Math.abs(this.motionX) < (double)0.3f && Math.abs(this.motionZ) < (double)0.3f) {
                this.motionY = d2 = (double)0.15f;
            }
        }
        if (this.onGround) {
            this.motionX *= 0.5;
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
        }
        this.moveEntity(this.motionX, d2, this.motionZ);
        if (!this.onGround) {
            this.motionX *= this.getDragAir();
            this.motionY *= this.getDragAir();
            this.motionZ *= this.getDragAir();
        }
    }

    public void updateOnTrack(int n, int n2, int n3, double d, double d2, int n4, int n5) {
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        this.fallDistance = 0.0f;
        Vec3 vec3 = this.func_70489_a(this.posX, this.posY, this.posZ);
        this.posY = n2;
        boolean bl = false;
        boolean bl2 = false;
        if (n4 == Block.railPowered.blockID) {
            bl = (this.worldObj.getBlockMetadata(n, n2, n3) & 8) != 0;
            boolean bl3 = bl2 = !bl;
        }
        if (((BlockRailBase)Block.blocksList[n4])._a()) {
            n5 &= 7;
        }
        if (n5 >= 2 && n5 <= 5) {
            this.posY = n2 + 1;
        }
        if (n5 == 2) {
            this.motionX -= d2;
        }
        if (n5 == 3) {
            this.motionX += d2;
        }
        if (n5 == 4) {
            this.motionZ += d2;
        }
        if (n5 == 5) {
            this.motionZ -= d2;
        }
        int[][] nArray = matrix[n5];
        double d8 = nArray[1][0] - nArray[0][0];
        double d9 = nArray[1][2] - nArray[0][2];
        double d10 = Math.sqrt(d8 * d8 + d9 * d9);
        double d11 = this.motionX * d8 + this.motionZ * d9;
        if (d11 < 0.0) {
            d8 = -d8;
            d9 = -d9;
        }
        if ((d7 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ)) > 2.0) {
            d7 = 2.0;
        }
        this.motionX = d7 * d8 / d10;
        this.motionZ = d7 * d9 / d10;
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase && (d6 = (double)((EntityLivingBase)this.riddenByEntity).moveForward) > 0.0) {
            d5 = -Math.sin(this.riddenByEntity.rotationYaw * (float)Math.PI / 180.0f);
            d4 = Math.cos(this.riddenByEntity.rotationYaw * (float)Math.PI / 180.0f);
            d3 = this.motionX * this.motionX + this.motionZ * this.motionZ;
            if (d3 < 0.01) {
                this.motionX += d5 * 0.1;
                this.motionZ += d4 * 0.1;
                bl2 = false;
            }
        }
        if (bl2 && this.shouldDoRailFunctions()) {
            d6 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            if (d6 < 0.03) {
                this.motionX *= 0.0;
                this.motionY *= 0.0;
                this.motionZ *= 0.0;
            } else {
                this.motionX *= 0.5;
                this.motionY *= 0.0;
                this.motionZ *= 0.5;
            }
        }
        d6 = 0.0;
        d5 = (double)n + 0.5 + (double)nArray[0][0] * 0.5;
        d4 = (double)n3 + 0.5 + (double)nArray[0][2] * 0.5;
        d3 = (double)n + 0.5 + (double)nArray[1][0] * 0.5;
        double d12 = (double)n3 + 0.5 + (double)nArray[1][2] * 0.5;
        d8 = d3 - d5;
        d9 = d12 - d4;
        if (d8 == 0.0) {
            this.posX = (double)n + 0.5;
            d6 = this.posZ - (double)n3;
        } else if (d9 == 0.0) {
            this.posZ = (double)n3 + 0.5;
            d6 = this.posX - (double)n;
        } else {
            double d13 = this.posX - d5;
            double d14 = this.posZ - d4;
            d6 = (d13 * d8 + d14 * d9) * 2.0;
        }
        this.posX = d5 + d8 * d6;
        this.posZ = d4 + d9 * d6;
        this.setPosition(this.posX, this.posY + (double)this.yOffset, this.posZ);
        this.moveMinecartOnRail(n, n2, n3, d);
        if (nArray[0][1] != 0 && sajh._c(this.posX) - n == nArray[0][0] && sajh._c(this.posZ) - n3 == nArray[0][2]) {
            this.setPosition(this.posX, this.posY + (double)nArray[0][1], this.posZ);
        } else if (nArray[1][1] != 0 && sajh._c(this.posX) - n == nArray[1][0] && sajh._c(this.posZ) - n3 == nArray[1][2]) {
            this.setPosition(this.posX, this.posY + (double)nArray[1][1], this.posZ);
        }
        this.applyDrag();
        Vec3 vec32 = this.func_70489_a(this.posX, this.posY, this.posZ);
        if (vec32 != null && vec3 != null) {
            double d15 = (vec3._d - vec32._d) * 0.05;
            d7 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            if (d7 > 0.0) {
                this.motionX = this.motionX / d7 * (d7 + d15);
                this.motionZ = this.motionZ / d7 * (d7 + d15);
            }
            this.setPosition(this.posX, vec32._d, this.posZ);
        }
        int n6 = sajh._c(this.posX);
        int n7 = sajh._c(this.posZ);
        if (n6 != n || n7 != n3) {
            d7 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.motionX = d7 * (double)(n6 - n);
            this.motionZ = d7 * (double)(n7 - n3);
        }
        if (this.shouldDoRailFunctions()) {
            ((BlockRailBase)Block.blocksList[n4])._b(this.worldObj, this, n, n2, n3);
        }
        if (bl && this.shouldDoRailFunctions()) {
            double d16 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            if (d16 > 0.01) {
                double d17 = 0.06;
                this.motionX += this.motionX / d16 * d17;
                this.motionZ += this.motionZ / d16 * d17;
            } else if (n5 == 1) {
                if (this.worldObj.isBlockNormalCube(n - 1, n2, n3)) {
                    this.motionX = 0.02;
                } else if (this.worldObj.isBlockNormalCube(n + 1, n2, n3)) {
                    this.motionX = -0.02;
                }
            } else if (n5 == 0) {
                if (this.worldObj.isBlockNormalCube(n, n2, n3 - 1)) {
                    this.motionZ = 0.02;
                } else if (this.worldObj.isBlockNormalCube(n, n2, n3 + 1)) {
                    this.motionZ = -0.02;
                }
            }
        }
    }

    public void applyDrag() {
        if (this.riddenByEntity != null) {
            this.motionX *= (double)0.997f;
            this.motionY *= 0.0;
            this.motionZ *= (double)0.997f;
        } else {
            this.motionX *= (double)0.96f;
            this.motionY *= 0.0;
            this.motionZ *= (double)0.96f;
        }
    }

    @SideOnly(value=Side.CLIENT)
    public Vec3 func_70495_a(double d, double d2, double d3, double d4) {
        int n;
        int n2;
        int n3;
        int n4 = sajh._c(d);
        if (BlockRailBase._a(this.worldObj, n4, (n3 = sajh._c(d2)) - 1, n2 = sajh._c(d3))) {
            --n3;
        }
        if (!BlockRailBase._a(n = this.worldObj.getBlockId(n4, n3, n2))) {
            return null;
        }
        int n5 = ((BlockRailBase)Block.blocksList[n])._a((IBlockAccess)this.worldObj, this, n4, n3, n2);
        d2 = n3;
        if (n5 >= 2 && n5 <= 5) {
            d2 = n3 + 1;
        }
        int[][] nArray = matrix[n5];
        double d5 = nArray[1][0] - nArray[0][0];
        double d6 = nArray[1][2] - nArray[0][2];
        double d7 = Math.sqrt(d5 * d5 + d6 * d6);
        if (nArray[0][1] != 0 && sajh._c(d += (d5 /= d7) * d4) - n4 == nArray[0][0] && sajh._c(d3 += (d6 /= d7) * d4) - n2 == nArray[0][2]) {
            d2 += (double)nArray[0][1];
        } else if (nArray[1][1] != 0 && sajh._c(d) - n4 == nArray[1][0] && sajh._c(d3) - n2 == nArray[1][2]) {
            d2 += (double)nArray[1][1];
        }
        return this.func_70489_a(d, d2, d3);
    }

    public Vec3 func_70489_a(double d, double d2, double d3) {
        int n;
        int n2;
        int n3;
        int n4 = sajh._c(d);
        if (BlockRailBase._a(this.worldObj, n4, (n3 = sajh._c(d2)) - 1, n2 = sajh._c(d3))) {
            --n3;
        }
        if (BlockRailBase._a(n = this.worldObj.getBlockId(n4, n3, n2))) {
            int n5 = ((BlockRailBase)Block.blocksList[n])._a((IBlockAccess)this.worldObj, this, n4, n3, n2);
            d2 = n3;
            if (n5 >= 2 && n5 <= 5) {
                d2 = n3 + 1;
            }
            int[][] nArray = matrix[n5];
            double d4 = 0.0;
            double d5 = (double)n4 + 0.5 + (double)nArray[0][0] * 0.5;
            double d6 = (double)n3 + 0.5 + (double)nArray[0][1] * 0.5;
            double d7 = (double)n2 + 0.5 + (double)nArray[0][2] * 0.5;
            double d8 = (double)n4 + 0.5 + (double)nArray[1][0] * 0.5;
            double d9 = (double)n3 + 0.5 + (double)nArray[1][1] * 0.5;
            double d10 = (double)n2 + 0.5 + (double)nArray[1][2] * 0.5;
            double d11 = d8 - d5;
            double d12 = (d9 - d6) * 2.0;
            double d13 = d10 - d7;
            if (d11 == 0.0) {
                d = (double)n4 + 0.5;
                d4 = d3 - (double)n2;
            } else if (d13 == 0.0) {
                d3 = (double)n2 + 0.5;
                d4 = d - (double)n4;
            } else {
                double d14 = d - d5;
                double d15 = d3 - d7;
                d4 = (d14 * d11 + d15 * d13) * 2.0;
            }
            d = d5 + d11 * d4;
            d2 = d6 + d12 * d4;
            d3 = d7 + d13 * d4;
            if (d12 < 0.0) {
                d2 += 1.0;
            }
            if (d12 > 0.0) {
                d2 += 0.5;
            }
            return this.worldObj.getWorldVec3Pool()._a(d, d2, d3);
        }
        return null;
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound._o("CustomDisplayTile")) {
            this.setDisplayTile(nBTTagCompound._f("DisplayTile"));
            this.setDisplayTileData(nBTTagCompound._f("DisplayData"));
            this.setDisplayTileOffset(nBTTagCompound._f("DisplayOffset"));
        }
        if (nBTTagCompound._c("CustomName") && nBTTagCompound._j("CustomName").length() > 0) {
            this.entityName = nBTTagCompound._j("CustomName");
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        if (this.hasDisplayTile()) {
            nBTTagCompound._a("CustomDisplayTile", true);
            nBTTagCompound._a("DisplayTile", this.getDisplayTile() == null ? 0 : this.getDisplayTile().blockID);
            nBTTagCompound._a("DisplayData", this.getDisplayTileData());
            nBTTagCompound._a("DisplayOffset", this.getDisplayTileOffset());
        }
        if (this.entityName != null && this.entityName.length() > 0) {
            nBTTagCompound._a("CustomName", this.entityName);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public float getShadowSize() {
        return 0.0f;
    }

    @Override
    public void applyEntityCollision(Entity entity) {
        MinecraftForge.EVENT_BUS.post(new MinecartCollisionEvent(this, entity));
        if (EntityMinecart.getCollisionHandler() != null) {
            EntityMinecart.getCollisionHandler().onEntityCollision(this, entity);
            return;
        }
        if (!this.worldObj.isRemote && entity != this.riddenByEntity) {
            double d;
            double d2;
            double d3;
            if (entity instanceof EntityLivingBase && !(entity instanceof EntityPlayer) && !(entity instanceof EntityIronGolem) && this.canBeRidden() && this.motionX * this.motionX + this.motionZ * this.motionZ > 0.01 && this.riddenByEntity == null && entity.ridingEntity == null) {
                entity.mountEntity(this);
            }
            if ((d3 = (d2 = entity.posX - this.posX) * d2 + (d = entity.posZ - this.posZ) * d) >= (double)1.0E-4f) {
                d3 = sajh._a(d3);
                d2 /= d3;
                d /= d3;
                double d4 = 1.0 / d3;
                if (d4 > 1.0) {
                    d4 = 1.0;
                }
                d2 *= d4;
                d *= d4;
                d2 *= (double)0.1f;
                d *= (double)0.1f;
                d2 *= (double)(1.0f - this.entityCollisionReduction);
                d *= (double)(1.0f - this.entityCollisionReduction);
                d2 *= 0.5;
                d *= 0.5;
                if (entity instanceof EntityMinecart) {
                    Vec3 vec3;
                    double d5 = entity.posX - this.posX;
                    double d6 = entity.posZ - this.posZ;
                    Vec3 vec32 = this.worldObj.getWorldVec3Pool()._a(d5, 0.0, d6)._a();
                    double d7 = Math.abs(vec32._b(vec3 = this.worldObj.getWorldVec3Pool()._a(sajh._b(this.rotationYaw * (float)Math.PI / 180.0f), 0.0, sajh._a(this.rotationYaw * (float)Math.PI / 180.0f))._a()));
                    if (d7 < (double)0.8f) {
                        return;
                    }
                    double d8 = entity.motionX + this.motionX;
                    double d9 = entity.motionZ + this.motionZ;
                    if (((EntityMinecart)entity).isPoweredCart() && !this.isPoweredCart()) {
                        this.motionX *= (double)0.2f;
                        this.motionZ *= (double)0.2f;
                        this.addVelocity(entity.motionX - d2, 0.0, entity.motionZ - d);
                        entity.motionX *= (double)0.95f;
                        entity.motionZ *= (double)0.95f;
                    } else if (!((EntityMinecart)entity).isPoweredCart() && this.isPoweredCart()) {
                        entity.motionX *= (double)0.2f;
                        entity.motionZ *= (double)0.2f;
                        entity.addVelocity(this.motionX + d2, 0.0, this.motionZ + d);
                        this.motionX *= (double)0.95f;
                        this.motionZ *= (double)0.95f;
                    } else {
                        this.motionX *= (double)0.2f;
                        this.motionZ *= (double)0.2f;
                        this.addVelocity((d8 /= 2.0) - d2, 0.0, (d9 /= 2.0) - d);
                        entity.motionX *= (double)0.2f;
                        entity.motionZ *= (double)0.2f;
                        entity.addVelocity(d8 + d2, 0.0, d9 + d);
                    }
                } else {
                    this.addVelocity(-d2, 0.0, -d);
                    entity.addVelocity(d2 / 4.0, 0.0, d / 4.0);
                }
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void setPositionAndRotation2(double d, double d2, double d3, float f, float f2, int n) {
        this.minecartX = d;
        this.minecartY = d2;
        this.minecartZ = d3;
        this.minecartYaw = f;
        this.minecartPitch = f2;
        this.turnProgress = n + 2;
        this.motionX = this.velocityX;
        this.motionY = this.velocityY;
        this.motionZ = this.velocityZ;
    }

    public void setDamage(float f) {
        this.dataWatcher._b(19, Float.valueOf(f));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void setVelocity(double d, double d2, double d3) {
        this.velocityX = this.motionX = d;
        this.velocityY = this.motionY = d2;
        this.velocityZ = this.motionZ = d3;
    }

    public float getDamage() {
        return this.dataWatcher._d(19);
    }

    public void setRollingAmplitude(int n) {
        this.dataWatcher._b(17, n);
    }

    public int getRollingAmplitude() {
        return this.dataWatcher._c(17);
    }

    public void setRollingDirection(int n) {
        this.dataWatcher._b(18, n);
    }

    public int getRollingDirection() {
        return this.dataWatcher._c(18);
    }

    public abstract int getMinecartType();

    public Block getDisplayTile() {
        if (!this.hasDisplayTile()) {
            return this.getDefaultDisplayTile();
        }
        int n = this.getDataWatcher()._c(20) & 0xFFFF;
        return n > 0 && n < Block.blocksList.length ? Block.blocksList[n] : null;
    }

    public Block getDefaultDisplayTile() {
        return null;
    }

    public int getDisplayTileData() {
        return !this.hasDisplayTile() ? this.getDefaultDisplayTileData() : this.getDataWatcher()._c(20) >> 16;
    }

    public int getDefaultDisplayTileData() {
        return 0;
    }

    public int getDisplayTileOffset() {
        return !this.hasDisplayTile() ? this.getDefaultDisplayTileOffset() : this.getDataWatcher()._c(21);
    }

    public int getDefaultDisplayTileOffset() {
        return 6;
    }

    public void setDisplayTile(int n) {
        this.getDataWatcher()._b(20, n & 0xFFFF | this.getDisplayTileData() << 16);
        this.setHasDisplayTile(true);
    }

    public void setDisplayTileData(int n) {
        Block block = this.getDisplayTile();
        int n2 = block == null ? 0 : block.blockID;
        this.getDataWatcher()._b(20, n2 & 0xFFFF | n << 16);
        this.setHasDisplayTile(true);
    }

    public void setDisplayTileOffset(int n) {
        this.getDataWatcher()._b(21, n);
        this.setHasDisplayTile(true);
    }

    public boolean hasDisplayTile() {
        return this.getDataWatcher()._a(22) == 1;
    }

    public void setHasDisplayTile(boolean bl) {
        this.getDataWatcher()._b(22, (byte)(bl ? 1 : 0));
    }

    public void setMinecartName(String string) {
        this.entityName = string;
    }

    @Override
    public String getEntityName() {
        return this.entityName != null ? this.entityName : super.getEntityName();
    }

    public boolean isInvNameLocalized() {
        return this.entityName != null;
    }

    public String func_95999_t() {
        return this.entityName;
    }

    public void moveMinecartOnRail(int n, int n2, int n3, double d) {
        double d2 = this.motionX;
        double d3 = this.motionZ;
        if (this.riddenByEntity != null) {
            d2 *= 0.75;
            d3 *= 0.75;
        }
        if (d2 < -d) {
            d2 = -d;
        }
        if (d2 > d) {
            d2 = d;
        }
        if (d3 < -d) {
            d3 = -d;
        }
        if (d3 > d) {
            d3 = d;
        }
        this.moveEntity(d2, 0.0, d3);
    }

    public static IMinecartCollisionHandler getCollisionHandler() {
        return collisionHandler;
    }

    public static void setCollisionHandler(IMinecartCollisionHandler iMinecartCollisionHandler) {
        collisionHandler = iMinecartCollisionHandler;
    }

    public ItemStack getCartItem() {
        if (this instanceof EntityMinecartChest) {
            return new ItemStack(Item.minecartCrate);
        }
        if (this instanceof EntityMinecartTNT) {
            return new ItemStack(Item.field_94582_cb);
        }
        if (this instanceof EntityMinecartFurnace) {
            return new ItemStack(Item.minecartPowered);
        }
        if (this instanceof EntityMinecartHopper) {
            return new ItemStack(Item.minecartHopper);
        }
        return new ItemStack(Item.minecartEmpty);
    }

    public boolean canUseRail() {
        return this.canUseRail;
    }

    public void setCanUseRail(boolean bl) {
        this.canUseRail = bl;
    }

    public boolean shouldDoRailFunctions() {
        return true;
    }

    public boolean isPoweredCart() {
        return this.getMinecartType() == 2;
    }

    public boolean canBeRidden() {
        return this instanceof EntityMinecartEmpty;
    }

    public float getMaxCartSpeedOnRail() {
        return 1.2f;
    }

    public final float getCurrentCartSpeedCapOnRail() {
        return this.currentSpeedRail;
    }

    public final void setCurrentCartSpeedCapOnRail(float f) {
        this.currentSpeedRail = f = Math.min(f, this.getMaxCartSpeedOnRail());
    }

    public float getMaxSpeedAirLateral() {
        return this.maxSpeedAirLateral;
    }

    public void setMaxSpeedAirLateral(float f) {
        this.maxSpeedAirLateral = f;
    }

    public float getMaxSpeedAirVertical() {
        return this.maxSpeedAirVertical;
    }

    public void setMaxSpeedAirVertical(float f) {
        this.maxSpeedAirVertical = f;
    }

    public double getDragAir() {
        return this.dragAir;
    }

    public void setDragAir(double d) {
        this.dragAir = d;
    }

    public double getSlopeAdjustment() {
        return 0.0078125;
    }
}

