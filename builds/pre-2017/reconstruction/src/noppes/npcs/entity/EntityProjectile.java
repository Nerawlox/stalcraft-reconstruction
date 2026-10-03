/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.owak;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import noppes.npcs.DataStats;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumParticleType;
import noppes.npcs.constants.EnumPotionType;

public class EntityProjectile
extends Entity
implements owak {
    public int throwableShake = 0;
    public int arrowShake = 0;
    public boolean canBePickedUp = false;
    public boolean destroyedOnEntityHit = true;
    public EntityItem entityitem;
    public int ticksInAir = 0;
    public float damage = 5.0f;
    public int punch = 0;
    public boolean accelerate = false;
    public boolean explosive = false;
    public int explosiveRadius = 0;
    public EnumPotionType effect = EnumPotionType.None;
    public int duration = 5;
    public int amplify = 0;
    protected boolean inGround = false;
    private int xTile = -1;
    private int yTile = -1;
    private int zTile = -1;
    private int inTile = 0;
    private int inData = 0;
    private EntityLivingBase thrower;
    private EntityNPCInterface npc;
    private String throwerName = null;
    private int ticksInGround;
    private double accelerationX;
    private double accelerationY;
    private double accelerationZ;

    public EntityProjectile(World world) {
        super(world);
        this.setSize(0.25f, 0.25f);
    }

    public EntityProjectile(World world, EntityLivingBase entityLivingBase, ItemStack itemStack, boolean bl) {
        super(world);
        this.thrower = entityLivingBase;
        this.setThrownItem(itemStack);
        this.dataWatcher._b(27, (byte)(this.getItemId() == Item.arrow.itemID ? 1 : 0));
        this.setSize(this.dataWatcher._c(23) / 10, this.dataWatcher._c(23) / 10);
        this.setLocationAndAngles(entityLivingBase.posX, entityLivingBase.posY + (double)entityLivingBase.getEyeHeight(), entityLivingBase.posZ, entityLivingBase.rotationYaw, entityLivingBase.rotationPitch);
        this.posX -= (double)(sajh._b(this.rotationYaw / 180.0f * (float)Math.PI) * 0.16f);
        this.posY -= 0.3;
        this.posZ -= (double)(sajh._a(this.rotationYaw / 180.0f * (float)Math.PI) * 0.16f);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0f;
        if (bl) {
            this.npc = (EntityNPCInterface)this.thrower;
            this.getStatProperties(this.npc.stats);
        }
    }

    @Override
    protected void entityInit() {
        this.dataWatcher._a(21, 5);
        this.dataWatcher._a(22, String.valueOf(""));
        this.dataWatcher._a(23, (Object)5);
        this.dataWatcher._a(24, (Object)0);
        this.dataWatcher._a(25, (Object)10);
        this.dataWatcher._a(26, (Object)0);
        this.dataWatcher._a(27, (Object)0);
        this.dataWatcher._a(28, (Object)0);
        this.dataWatcher._a(29, (Object)0);
        this.dataWatcher._a(30, (Object)0);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean isInRangeToRenderDist(double d) {
        double d2 = this.boundingBox._b() * 4.0;
        return d < (d2 *= 64.0) * d2;
    }

    public void setThrownItem(ItemStack itemStack) {
        this.dataWatcher._b(21, itemStack);
    }

    @Override
    public void setThrowableHeading(double d, double d2, double d3, float f, float f2) {
        float f3 = sajh._a(d * d + d2 * d2 + d3 * d3);
        float f4 = sajh._a(d * d + d3 * d3);
        float f5 = (float)(Math.atan2(d, d3) * 180.0 / Math.PI);
        float f6 = this.hasGravity() ? f : (float)(Math.atan2(d2, f4) * 180.0 / Math.PI);
        this.prevRotationYaw = this.rotationYaw = f5;
        this.prevRotationPitch = this.rotationPitch = f6;
        this.motionX = sajh._a(f5 / 180.0f * (float)Math.PI) * sajh._b(f6 / 180.0f * (float)Math.PI);
        this.motionZ = sajh._b(f5 / 180.0f * (float)Math.PI) * sajh._b(f6 / 180.0f * (float)Math.PI);
        this.motionY = sajh._a((f6 + 1.0f) / 180.0f * (float)Math.PI);
        this.motionX += this.rand.nextGaussian() * (double)0.0075f * (double)f2;
        this.motionZ += this.rand.nextGaussian() * (double)0.0075f * (double)f2;
        this.motionY += this.rand.nextGaussian() * (double)0.0075f * (double)f2;
        this.motionX *= (double)this.getSpeed();
        this.motionZ *= (double)this.getSpeed();
        this.motionY *= (double)this.getSpeed();
        this.accelerationX = d / (double)f3 * 0.1;
        this.accelerationY = d2 / (double)f3 * 0.1;
        this.accelerationZ = d3 / (double)f3 * 0.1;
        this.ticksInGround = 0;
    }

    public float getAngleForXYZ(double d, double d2, double d3, double d4, boolean bl) {
        float f = this.getGravityVelocity();
        float f2 = this.getSpeed() * this.getSpeed();
        double d5 = (double)f * d4;
        double d6 = (double)f * d4 * d4 + 2.0 * d2 * (double)f2;
        double d7 = (double)(f2 * f2) - (double)f * d6;
        if (d7 < 0.0) {
            return 30.0f;
        }
        float f3 = bl ? f2 + sajh._a(d7) : f2 - sajh._a(d7);
        float f4 = (float)(Math.atan2(f3, d5) * 180.0 / Math.PI);
        return f4;
    }

    public void shoot(float f) {
        double d = -sajh._a(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI);
        double d2 = sajh._b(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI);
        double d3 = -sajh._a(this.rotationPitch / 180.0f * (float)Math.PI);
        this.setThrowableHeading(d, d3, d2, -this.rotationPitch, f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void setVelocity(double d, double d2, double d3) {
        this.motionX = d;
        this.motionY = d2;
        this.motionZ = d3;
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            float f = sajh._a(d * d + d3 * d3);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(d, d3) * 180.0 / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(d2, f) * 180.0 / Math.PI);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void setPositionAndRotation2(double d, double d2, double d3, float f, float f2, int n) {
        if (!this.worldObj.isRemote || !this.inGround) {
            this.setPosition(d, d2, d3);
            this.setRotation(f, f2);
        }
    }

    protected float getGravityVelocity() {
        return 0.03f;
    }

    @Override
    public void onUpdate() {
        Object object;
        super.onUpdate();
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            float f = sajh._a(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, f) * 180.0 / Math.PI);
            if (this.isRotating()) {
                this.rotationPitch -= 20.0f;
            }
        }
        if (this.effect == EnumPotionType.Fire && !this.inGround) {
            this.setFire(1);
        }
        int n = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
        int n2 = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
        if ((this.isArrow() || this.sticksToWalls()) && n > 0) {
            Block.blocksList[n].setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
            object = Block.blocksList[n].getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
            if (object != null && ((AxisAlignedBB)object)._a(this.worldObj.getWorldVec3Pool()._a(this.posX, this.posY, this.posZ))) {
                this.inGround = true;
            }
        }
        if (this.arrowShake > 0) {
            --this.arrowShake;
        }
        if (this.inGround) {
            if (n == this.inTile && n2 == this.inData) {
                ++this.ticksInGround;
                if (this.ticksInGround == 1200) {
                    this.setDead();
                }
            } else {
                this.inGround = false;
                this.motionX *= (double)(this.rand.nextFloat() * 0.2f);
                this.motionY *= (double)(this.rand.nextFloat() * 0.2f);
                this.motionZ *= (double)(this.rand.nextFloat() * 0.2f);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        } else {
            ++this.ticksInAir;
            if (this.ticksInAir == 1200) {
                this.setDead();
            }
            object = this.worldObj.getWorldVec3Pool()._a(this.posX, this.posY, this.posZ);
            Vec3 vec3 = this.worldObj.getWorldVec3Pool()._a(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            MovingObjectPosition movingObjectPosition = this.worldObj.func_72831_a((Vec3)object, vec3, false, true);
            object = this.worldObj.getWorldVec3Pool()._a(this.posX, this.posY, this.posZ);
            vec3 = this.worldObj.getWorldVec3Pool()._a(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            if (movingObjectPosition != null) {
                vec3 = this.worldObj.getWorldVec3Pool()._a(movingObjectPosition._h._c, movingObjectPosition._h._d, movingObjectPosition._h._e);
            }
            if (!this.worldObj.isRemote) {
                Entity entity = null;
                List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox._a(this.motionX, this.motionY, this.motionZ)._b(1.0, 1.0, 1.0));
                double d = 0.0;
                EntityLivingBase entityLivingBase = this.getThrower();
                for (int i = 0; i < list.size(); ++i) {
                    double d2;
                    float f;
                    AxisAlignedBB axisAlignedBB;
                    MovingObjectPosition movingObjectPosition2;
                    Entity entity2 = (Entity)list.get(i);
                    if (!entity2.canBeCollidedWith() || entity2 == this.thrower && this.ticksInAir < 5 || (movingObjectPosition2 = (axisAlignedBB = entity2.boundingBox._b(f = 0.3f, f, f))._a((Vec3)object, vec3)) == null || !((d2 = ((Vec3)object)._d(movingObjectPosition2._h)) < d) && d != 0.0) continue;
                    entity = entity2;
                    d = d2;
                }
                if (entity != null) {
                    movingObjectPosition = new MovingObjectPosition(entity);
                }
                if (movingObjectPosition != null && movingObjectPosition._i != null && movingObjectPosition._i instanceof EntityPlayer) {
                    EntityPlayer entityPlayer = (EntityPlayer)movingObjectPosition._i;
                    if (this.thrower instanceof EntityNPCInterface && this.npc.getFaction().isFriendlyToPlayer(entityPlayer)) {
                        movingObjectPosition = null;
                    }
                }
            }
            if (movingObjectPosition != null) {
                if (movingObjectPosition._c == EnumMovingObjectType._a && this.worldObj.getBlockId(movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f) == Block.portal.blockID) {
                    this.setInPortal();
                } else {
                    this.dataWatcher._b(29, (byte)0);
                    this.onImpact(movingObjectPosition);
                }
            }
            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            float f = sajh._a(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / Math.PI);
            this.rotationPitch = (float)(Math.atan2(this.motionY, f) * 180.0 / Math.PI);
            while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
                this.prevRotationPitch -= 360.0f;
            }
            while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
                this.prevRotationPitch += 360.0f;
            }
            while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
                this.prevRotationYaw -= 360.0f;
            }
            while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
                this.prevRotationYaw += 360.0f;
            }
            float f2 = this.isArrow() ? 0.0f : 225.0f;
            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) + f2 * 0.2f;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2f;
            if (this.isRotating()) {
                int n3 = this.isBlock() ? 10 : 20;
                this.rotationPitch -= (float)(this.ticksInAir * n3) * this.getSpeed();
            }
            float f3 = this.getMotionFactor();
            float f4 = this.getGravityVelocity();
            if (this.isInWater()) {
                for (int i = 0; i < 4; ++i) {
                    float f5 = 0.25f;
                    this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f5, this.posY - this.motionY * (double)f5, this.posZ - this.motionZ * (double)f5, this.motionX, this.motionY, this.motionZ);
                }
                f3 = 0.8f;
            }
            this.motionX *= (double)f3;
            this.motionY *= (double)f3;
            this.motionZ *= (double)f3;
            if (this.hasGravity()) {
                this.motionY -= (double)f4;
            }
            if (this.accelerate) {
                this.motionX += this.accelerationX;
                this.motionY += this.accelerationY;
                this.motionZ += this.accelerationZ;
            }
            if (!this.dataWatcher._e(22).equals("")) {
                this.worldObj.spawnParticle(this.dataWatcher._e(22), this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
            }
            this.setPosition(this.posX, this.posY, this.posZ);
            this.doBlockCollisions();
        }
    }

    public boolean isBlock() {
        ItemStack itemStack = this.getItemDisplay();
        return itemStack == null ? false : itemStack._a() instanceof ItemBlock;
    }

    private int getItemId() {
        ItemStack itemStack = this.getItemDisplay();
        return itemStack == null ? 0 : itemStack._d;
    }

    protected float getMotionFactor() {
        return this.accelerate ? 0.95f : 1.0f;
    }

    protected void onImpact(MovingObjectPosition movingObjectPosition) {
        int n;
        int n2;
        Object object;
        float f;
        if (movingObjectPosition._i != null) {
            f = this.damage;
            if (f == 0.0f) {
                f = 0.001f;
            }
            if (movingObjectPosition._i.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), f)) {
                float f2;
                if (movingObjectPosition._i instanceof EntityLivingBase && (this.isArrow() || this.sticksToWalls())) {
                    object = (EntityLivingBase)movingObjectPosition._i;
                    if (!this.worldObj.isRemote) {
                        ((EntityLivingBase)object).setArrowCountInEntity(((EntityLivingBase)object).getArrowCountInEntity() + 1);
                    }
                    if (this.destroyedOnEntityHit && !(movingObjectPosition._i instanceof EntityEnderman)) {
                        this.setDead();
                    }
                }
                if (this.isBlock()) {
                    this.worldObj.playAuxSFX(2001, (int)movingObjectPosition._i.posX, (int)movingObjectPosition._i.posY, (int)movingObjectPosition._i.posZ, this.getItemId());
                } else if (!this.isArrow() && !this.sticksToWalls()) {
                    for (n2 = 0; n2 < 8; ++n2) {
                        this.worldObj.spawnParticle("iconcrack_" + this.getItemId(), this.posX, this.posY, this.posZ, this.rand.nextGaussian() * 0.15, this.rand.nextGaussian() * 0.2, this.rand.nextGaussian() * 0.15);
                    }
                }
                if (this.punch > 0 && (f2 = sajh._a(this.motionX * this.motionX + this.motionZ * this.motionZ)) > 0.0f) {
                    movingObjectPosition._i.addVelocity(this.motionX * (double)this.punch * (double)0.6f / (double)f2, 0.1, this.motionZ * (double)this.punch * (double)0.6f / (double)f2);
                }
                if (this.effect != EnumPotionType.None && movingObjectPosition._i instanceof EntityLivingBase) {
                    if (this.effect != EnumPotionType.Fire) {
                        n2 = this.getPotionEffect(this.effect);
                        ((EntityLivingBase)movingObjectPosition._i).addPotionEffect(new PotionEffect(n2, this.duration * 20, this.amplify));
                    } else {
                        movingObjectPosition._i.setFire(this.duration);
                    }
                }
            } else if (this.hasGravity() && (this.isArrow() || this.sticksToWalls())) {
                this.motionX *= (double)-0.1f;
                this.motionY *= (double)-0.1f;
                this.motionZ *= (double)-0.1f;
                this.rotationYaw += 180.0f;
                this.prevRotationYaw += 180.0f;
                this.ticksInAir = 0;
            }
        } else if (!this.isArrow() && !this.sticksToWalls()) {
            if (this.isBlock()) {
                this.worldObj.playAuxSFX(2001, movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f, this.getItemId());
            } else {
                for (n = 0; n < 8; ++n) {
                    this.worldObj.spawnParticle("iconcrack_" + this.getItemId(), this.posX, this.posY, this.posZ, this.rand.nextGaussian() * 0.15, this.rand.nextGaussian() * 0.2, this.rand.nextGaussian() * 0.15);
                }
            }
        } else {
            this.xTile = movingObjectPosition._d;
            this.yTile = movingObjectPosition._e;
            this.zTile = movingObjectPosition._f;
            this.inTile = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
            this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
            this.motionX = (float)(movingObjectPosition._h._c - this.posX);
            this.motionY = (float)(movingObjectPosition._h._d - this.posY);
            this.motionZ = (float)(movingObjectPosition._h._e - this.posZ);
            f = sajh._a(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
            this.posX -= this.motionX / (double)f * (double)0.05f;
            this.posY -= this.motionY / (double)f * (double)0.05f;
            this.posZ -= this.motionZ / (double)f * (double)0.05f;
            this.inGround = true;
            if (this.isArrow()) {
                this.playSound("random.bowhit", 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
            } else {
                this.playSound("random.break", 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
            }
            this.arrowShake = 7;
            if (!this.hasGravity()) {
                this.dataWatcher._b(26, (byte)1);
            }
            if (this.inTile != 0) {
                Block.blocksList[this.inTile].onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);
            }
        }
        if (this.explosive) {
            if (this.explosiveRadius == 0 && this.effect != EnumPotionType.None) {
                if (this.effect == EnumPotionType.Fire) {
                    n = movingObjectPosition._d;
                    n2 = movingObjectPosition._e;
                    int n3 = movingObjectPosition._f;
                    switch (movingObjectPosition._g) {
                        case 0: {
                            --n2;
                            break;
                        }
                        case 1: {
                            ++n2;
                            break;
                        }
                        case 2: {
                            --n3;
                            break;
                        }
                        case 3: {
                            ++n3;
                            break;
                        }
                        case 4: {
                            --n;
                            break;
                        }
                        case 5: {
                            ++n;
                        }
                    }
                    if (this.worldObj.isAirBlock(n, n2, n3)) {
                        this.worldObj.setBlock(n, n2, n3, Block.fire.blockID);
                    }
                } else {
                    object = this.boundingBox._b(4.0, 2.0, 4.0);
                    List list = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, (AxisAlignedBB)object);
                    if (list != null && !list.isEmpty()) {
                        for (EntityLivingBase entityLivingBase : list) {
                            int n4;
                            double d = this.getDistanceSqToEntity(entityLivingBase);
                            if (!(d < 16.0)) continue;
                            double d2 = 1.0 - Math.sqrt(d) / 4.0;
                            if (entityLivingBase == movingObjectPosition._i) {
                                d2 = 1.0;
                            }
                            if (Potion._a[n4 = this.getPotionEffect(this.effect)]._b()) {
                                Potion._a[n4]._a(this.getThrower(), entityLivingBase, this.amplify, d2);
                                continue;
                            }
                            int n5 = (int)(d2 * (double)this.duration + 0.5);
                            if (n5 <= 20) continue;
                            entityLivingBase.addPotionEffect(new PotionEffect(n4, n5, this.amplify));
                        }
                    }
                    this.worldObj.playAuxSFX(2002, (int)Math.round(this.posX), (int)Math.round(this.posY), (int)Math.round(this.posZ), this.getPotionColor(this.effect));
                }
            } else {
                this.worldObj.newExplosion(null, this.posX, this.posY, this.posZ, this.explosiveRadius, this.effect == EnumPotionType.Fire, this.worldObj.getGameRules()._b("mobGriefing"));
                if (this.explosiveRadius != 0 && (this.isArrow() || this.sticksToWalls())) {
                    this.setDead();
                }
            }
        }
        if (!(this.worldObj.isRemote || this.isArrow() || this.sticksToWalls())) {
            this.setDead();
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("xTile", (short)this.xTile);
        nBTTagCompound._a("yTile", (short)this.yTile);
        nBTTagCompound._a("zTile", (short)this.zTile);
        nBTTagCompound._a("inTile", (byte)this.inTile);
        nBTTagCompound._a("inData", (byte)this.inData);
        nBTTagCompound._a("shake", (byte)this.throwableShake);
        nBTTagCompound._a("inGround", (byte)(this.inGround ? 1 : 0));
        nBTTagCompound._a("isArrow", (byte)(this.isArrow() ? 1 : 0));
        nBTTagCompound._a("direction", this.newDoubleNBTList(this.motionX, this.motionY, this.motionZ));
        nBTTagCompound._a("canBePickedUp", this.canBePickedUp);
        if ((this.throwerName == null || this.throwerName.length() == 0) && this.thrower != null && this.thrower instanceof EntityPlayer) {
            this.throwerName = this.thrower.getEntityName();
        }
        nBTTagCompound._a("ownerName", this.throwerName == null ? "" : this.throwerName);
        if (this.getItemDisplay() != null) {
            nBTTagCompound._a("Item", this.getItemDisplay()._b(new NBTTagCompound()));
        }
        nBTTagCompound._a("damagev2", this.damage);
        nBTTagCompound._a("punch", this.punch);
        nBTTagCompound._a("size", this.dataWatcher._c(23));
        nBTTagCompound._a("velocity", this.dataWatcher._c(25));
        nBTTagCompound._a("explosiveRadius", this.explosiveRadius);
        nBTTagCompound._a("effectDuration", this.duration);
        nBTTagCompound._a("gravity", this.hasGravity());
        nBTTagCompound._a("accelerate", this.accelerate);
        nBTTagCompound._a("glows", this.dataWatcher._a(24));
        nBTTagCompound._a("explosive", this.explosive);
        nBTTagCompound._a("PotionEffect", this.effect.ordinal());
        nBTTagCompound._a("trail", this.dataWatcher._e(22));
        nBTTagCompound._a("Render3D", this.dataWatcher._a(28));
        nBTTagCompound._a("Spins", this.dataWatcher._a(29));
        nBTTagCompound._a("Sticks", this.dataWatcher._a(30));
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        ItemStack itemStack;
        NBTBase nBTBase;
        this.xTile = nBTTagCompound._e("xTile");
        this.yTile = nBTTagCompound._e("yTile");
        this.zTile = nBTTagCompound._e("zTile");
        this.inTile = nBTTagCompound._d("inTile") & 0xFF;
        this.inData = nBTTagCompound._d("inData") & 0xFF;
        this.throwableShake = nBTTagCompound._d("shake") & 0xFF;
        this.inGround = nBTTagCompound._d("inGround") == 1;
        this.dataWatcher._b(27, nBTTagCompound._d("isArrow"));
        this.throwerName = nBTTagCompound._j("ownerName");
        this.canBePickedUp = nBTTagCompound._o("canBePickedUp");
        this.damage = nBTTagCompound._h("damagev2");
        this.punch = nBTTagCompound._f("punch");
        this.explosiveRadius = nBTTagCompound._f("explosiveRadius");
        this.duration = nBTTagCompound._f("effectDuration");
        this.accelerate = nBTTagCompound._o("accelerate");
        this.explosive = nBTTagCompound._o("explosive");
        this.effect = EnumPotionType.values()[nBTTagCompound._f("PotionEffect") % EnumPotionType.values().length];
        this.dataWatcher._b(22, nBTTagCompound._j("trail"));
        this.dataWatcher._b(23, nBTTagCompound._f("size"));
        this.dataWatcher._b(24, (byte)(nBTTagCompound._o("glows") ? 1 : 0));
        this.dataWatcher._b(25, nBTTagCompound._f("velocity"));
        this.dataWatcher._b(26, (byte)(nBTTagCompound._o("gravity") ? 1 : 0));
        this.dataWatcher._b(28, (byte)(nBTTagCompound._o("Render3D") ? 1 : 0));
        this.dataWatcher._b(29, (byte)(nBTTagCompound._o("Spins") ? 1 : 0));
        this.dataWatcher._b(30, (byte)(nBTTagCompound._o("Sticks") ? 1 : 0));
        if (this.throwerName != null && this.throwerName.length() == 0) {
            this.throwerName = null;
        }
        if (nBTTagCompound._c("direction")) {
            nBTBase = nBTTagCompound._n("direction");
            this.motionX = ((qoae)((NBTTagList)nBTBase)._b((int)0))._c;
            this.motionY = ((qoae)((NBTTagList)nBTBase)._b((int)1))._c;
            this.motionZ = ((qoae)((NBTTagList)nBTBase)._b((int)2))._c;
        }
        if ((itemStack = ItemStack._a((NBTTagCompound)(nBTBase = nBTTagCompound._m("Item")))) == null) {
            this.setDead();
        } else {
            this.dataWatcher._b(21, itemStack);
        }
    }

    public EntityLivingBase getThrower() {
        if (this.thrower == null && this.throwerName != null && this.throwerName.length() > 0) {
            this.thrower = this.worldObj.getPlayerEntityByName(this.throwerName);
        }
        return this.thrower;
    }

    private int getPotionEffect(EnumPotionType enumPotionType) {
        switch (NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[enumPotionType.ordinal()]) {
            case 1: {
                return Potion._u._H;
            }
            case 2: {
                return Potion._s._H;
            }
            case 3: {
                return Potion._t._H;
            }
            case 4: {
                return Potion._d._H;
            }
            case 5: {
                return Potion._k._H;
            }
            case 6: {
                return Potion._q._H;
            }
            case 7: {
                return Potion._v._H;
            }
        }
        return 0;
    }

    private int getPotionColor(EnumPotionType enumPotionType) {
        switch (NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[enumPotionType.ordinal()]) {
            case 1: {
                return 32660;
            }
            case 2: {
                return 32660;
            }
            case 3: {
                return 32696;
            }
            case 4: {
                return 32698;
            }
            case 5: {
                return 32732;
            }
            case 6: {
                return Potion._q._H;
            }
            case 7: {
                return 32732;
            }
        }
        return 0;
    }

    public void getStatProperties(DataStats dataStats) {
        this.damage = dataStats.pDamage;
        this.punch = dataStats.pImpact;
        this.accelerate = dataStats.pXlr8;
        this.explosive = dataStats.pExplode;
        this.explosiveRadius = dataStats.pArea;
        this.effect = dataStats.pEffect;
        this.duration = dataStats.pDur;
        this.amplify = dataStats.pEffAmp;
        this.setParticleEffect(dataStats.pTrail);
        this.dataWatcher._b(23, dataStats.pSize);
        this.dataWatcher._b(24, (byte)(dataStats.pGlows ? 1 : 0));
        this.setSpeed(dataStats.pSpeed);
        this.setHasGravity(dataStats.pPhysics);
        this.setIs3D(dataStats.pRender3D);
        this.setRotating(dataStats.pSpin);
        this.setStickInWall(dataStats.pStick);
    }

    public void setParticleEffect(EnumParticleType enumParticleType) {
        this.dataWatcher._b(22, enumParticleType.particleName);
    }

    public void setHasGravity(boolean bl) {
        this.dataWatcher._b(26, (byte)(bl ? 1 : 0));
    }

    public void setIs3D(boolean bl) {
        this.dataWatcher._b(28, (byte)(bl ? 1 : 0));
    }

    public void setStickInWall(boolean bl) {
        this.dataWatcher._b(30, (byte)(bl ? 1 : 0));
    }

    public ItemStack getItemDisplay() {
        return this.dataWatcher._f(21);
    }

    @Override
    public float getBrightness(float f) {
        return this.dataWatcher._a(24) == 1 ? 1.0f : super.getBrightness(f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getBrightnessForRender(float f) {
        return this.dataWatcher._a(24) == 1 ? 0xF000F0 : super.getBrightnessForRender(f);
    }

    public boolean hasGravity() {
        return this.dataWatcher._a(26) == 1;
    }

    public float getSpeed() {
        return (float)this.dataWatcher._c(25) / 10.0f;
    }

    public void setSpeed(int n) {
        this.dataWatcher._b(25, n);
    }

    public boolean isArrow() {
        return this.dataWatcher._a(27) == 1;
    }

    public boolean isRotating() {
        return this.dataWatcher._a(29) == 1;
    }

    public void setRotating(boolean bl) {
        this.dataWatcher._b(29, (byte)(bl ? 1 : 0));
    }

    public boolean glows() {
        return this.dataWatcher._a(24) == 1;
    }

    public boolean is3D() {
        return this.dataWatcher._a(28) == 1 || this.isBlock();
    }

    public boolean sticksToWalls() {
        return this.is3D() && this.dataWatcher._a(30) == 1;
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityPlayer) {
        if (!this.worldObj.isRemote && this.canBePickedUp && this.inGround && this.arrowShake <= 0 && entityPlayer.inventory._c(this.getItemDisplay())) {
            this.inGround = false;
            this.playSound("random.pop", 0.2f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            entityPlayer.onItemPickup(this, 1);
            this.setDead();
        }
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    static class NamelessClass1971811639 {
        static final int[] $SwitchMap$noppes$npcs$constants$EnumPotionType = new int[EnumPotionType.values().length];

        NamelessClass1971811639() {
        }

        static {
            try {
                NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[EnumPotionType.Poison.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[EnumPotionType.Hunger.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[EnumPotionType.Weakness.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[EnumPotionType.Slowness.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[EnumPotionType.Nausea.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[EnumPotionType.Blindness.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1971811639.$SwitchMap$noppes$npcs$constants$EnumPotionType[EnumPotionType.Wither.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}

