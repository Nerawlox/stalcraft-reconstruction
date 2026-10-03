/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.entity;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.weapon.ugqx;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

@ezey(_a={eidj.CLIENT})
public class EntityShell
extends EntityThrowable {
    private static final float MOTION_FACTOR = 0.999f;
    private static final float ROTATION_FACTOR = 0.999f;
    private static final float ENTITY_SIZE = 0.05f;
    public float xRotation = 0.0f;
    public float yRotation = 0.0f;
    public float zRotation = 0.0f;
    public float xRotationSpeed = 0.0f;
    public float yRotationSpeed = 0.0f;
    public float zRotationSpeed = 0.0f;
    protected boolean collided = false;
    protected double prevY;
    public boolean renderOnGround;
    public final String model;
    public final ResourceLocation texture;
    public boolean hideUntilLeaveFrustum;
    public long lastRenderedFrame;
    private static final int LIFETIME = 250;

    public EntityShell(World world, EntityLivingBase entityLivingBase, wolf wolf2) {
        super(world);
        boolean bl = entityLivingBase == Minecraft._E()._t;
        boolean bl2 = bl && ugqx._a((EntityPlayer)entityLivingBase)._l();
        this.setLocationAndAngles(entityLivingBase.posX, entityLivingBase.posY + (double)entityLivingBase.getEyeHeight() - (entityLivingBase instanceof EntityPlayer ? 0.4 : 0.1), entityLivingBase.posZ, entityLivingBase.rotationYawHead, entityLivingBase.rotationPitch);
        if (!bl2) {
            this.posX -= (double)(sajh._b(this.rotationYaw / 180.0f * (float)Math.PI) * 0.35f);
            this.posZ -= (double)(sajh._a(this.rotationYaw / 180.0f * (float)Math.PI) * 0.35f);
        }
        double d = -sajh._a(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI);
        double d2 = -sajh._a(this.rotationPitch / 180.0f * (float)Math.PI);
        double d3 = sajh._b(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI);
        double d4 = sajh._a((this.rotationPitch + 90.0f) / 180.0f * (float)Math.PI);
        Vec3 vec3 = Vec3._a(d, d2, d3)._a();
        this.posX += vec3._c * 0.15;
        this.posY += vec3._d * 0.15;
        this.posZ += vec3._e * 0.15;
        if (bl2) {
            this.posX += (double)((wolf2.__af._c + 1.0f) / 2.0f) * vec3._c;
            this.posY += (double)((wolf2.__af._c + 1.0f) / 2.0f) * vec3._d;
            this.posZ += (double)((wolf2.__af._c + 1.0f) / 2.0f) * vec3._e;
        } else if (bl) {
            this.posX += vec3._c * 0.5;
            this.posY += vec3._d * 0.5;
            this.posZ += vec3._e * 0.5;
        }
        vec3._b((float)Math.toRadians(-90.0));
        this.motionY = d4 * wolf2.__aa._d;
        double d5 = wolf2.__aa._c;
        this.motionX = vec3._c * d5;
        this.motionZ = vec3._e * d5;
        this.motionY *= 1.0 + (Math.random() - 0.5) / 4.0;
        this.motionX *= 1.0 + (Math.random() - 0.5) / 4.0;
        this.motionZ *= 1.0 + (Math.random() - 0.5) / 4.0;
        this.posX += this.motionX / 2.0;
        this.posZ += this.motionZ / 2.0;
        this.xRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        this.yRotationSpeed = (float)Math.random() * 10.0f + 10.0f;
        this.zRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        this.setSize(0.05f, 0.05f);
        this.height = 0.05f;
        this.model = wolf2._V;
        this.texture = wolf2._W;
        this.yRotation = 180.0f - entityLivingBase.rotationYawHead;
        this.hideUntilLeaveFrustum = bl && Minecraft._E()._M.thirdPersonView == 0;
    }

    public EntityShell(World world, double d, double d2, double d3, float f, float f2, float f3, String string, String string2) {
        super(world);
        this.setLocationAndAngles(d, d2 - 0.3, d3, f, f2);
        double d4 = sajh._a((this.rotationPitch + 90.0f) / 180.0f * (float)Math.PI);
        this.motionY = d4 * 0.25;
        this.motionX = (double)(-sajh._a((f += 90.0f) / 180.0f * (float)Math.PI) * sajh._b(f2 / 180.0f * (float)Math.PI)) * 0.15;
        this.motionZ = (double)(sajh._b(f / 180.0f * (float)Math.PI) * sajh._b(f2 / 180.0f * (float)Math.PI)) * 0.15;
        this.posX += (double)(-sajh._a(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI)) * (double)f3;
        this.posZ += (double)(sajh._b(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI)) * (double)f3;
        this.posY += (double)(-sajh._a(this.rotationPitch / 180.0f * (float)Math.PI)) * (double)f3;
        this.posX += this.motionX / 2.0;
        this.posY += this.motionY / 2.0;
        this.posZ += this.motionZ / 2.0;
        this.motionY *= 1.0 + (Math.random() - 0.5) / 4.0;
        this.motionX *= 1.0 + (Math.random() - 0.5) / 4.0;
        this.motionZ *= 1.0 + (Math.random() - 0.5) / 4.0;
        this.xRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        this.yRotationSpeed = (float)Math.random() * 10.0f + 10.0f;
        this.zRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        this.setSize(0.05f, 0.05f);
        this.height = 0.05f;
        this.model = string;
        this.texture = new ResourceLocation("weapons", "models/sleeves/" + string2);
        this.yRotation = 180.0f - f;
        this.hideUntilLeaveFrustum = false;
    }

    @Override
    protected float getGravityVelocity() {
        return 0.07f;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        float f = this.posY == this.prevY ? 0.94905f : 0.999f;
        this.xRotationSpeed *= f;
        this.yRotationSpeed *= f;
        this.zRotationSpeed *= f;
        this.xRotation = (this.xRotation + this.xRotationSpeed) % 360.0f;
        this.yRotation = (this.yRotation + this.yRotationSpeed) % 360.0f;
        this.zRotation = (this.zRotation + this.zRotationSpeed) % 360.0f;
        this.prevY = this.posY;
        if (this.ticksExisted > 250) {
            this.setDead();
        }
    }

    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition) {
        if (movingObjectPosition._i == null && Block.blocksList[this.worldObj.getBlockId(movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f)].getCollisionBoundingBoxFromPool(this.worldObj, movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f) == null) {
            return;
        }
        if (movingObjectPosition._c.ordinal() == 0) {
            this.pushOff(movingObjectPosition._h, movingObjectPosition._g);
        } else {
            this.hitEntity(movingObjectPosition._i);
        }
    }

    protected void hitEntity(Entity entity) {
        this.motionX *= -0.5;
        this.motionY *= -0.5;
        this.motionZ *= -0.5;
        this.xRotationSpeed *= 0.5f;
        this.yRotationSpeed *= 0.5f;
        this.zRotationSpeed *= 0.5f;
        this.calculateNewImpact();
    }

    protected void pushOff(Vec3 vec3, int n) {
        boolean bl;
        boolean bl2 = bl = Math.abs(this.motionY) > (double)0.2f || n == 0;
        if (n == 0 || n == 1) {
            if (bl) {
                this.motionX *= (double)0.8f;
                this.motionY *= -0.5;
                this.motionZ *= (double)0.8f;
                this.renderOnGround = false;
            } else {
                this.motionX *= (double)0.8f;
                this.motionY = 0.0;
                this.posY = vec3._d + 0.01;
                this.motionZ *= (double)0.8f;
                this.xRotationSpeed = 0.0f;
                this.zRotationSpeed = 0.0f;
                this.xRotation = 0.0f;
                this.zRotation = 0.0f;
                this.renderOnGround = true;
            }
        } else if (n == 2 || n == 3) {
            this.motionX *= 0.5;
            this.motionY *= (double)0.8f;
            this.motionZ *= -0.5;
        } else {
            this.motionX *= -0.5;
            this.motionY *= (double)0.8f;
            this.motionZ *= 0.5;
        }
        if (!bl) {
            this.xRotationSpeed *= 0.5f;
            this.yRotationSpeed *= 0.5f;
            this.zRotationSpeed *= 0.5f;
        } else {
            this.xRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
            this.yRotationSpeed = (float)Math.random() * 10.0f + 10.0f;
            this.zRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        }
        this.calculateNewImpact();
    }

    protected void calculateNewImpact() {
        Vec3 vec3 = this.worldObj.getWorldVec3Pool()._a(this.posX, this.posY, this.posZ);
        Vec3 vec32 = this.worldObj.getWorldVec3Pool()._a(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        MovingObjectPosition movingObjectPosition = this.worldObj.func_72933_a(vec3, vec32);
        vec3 = this.worldObj.getWorldVec3Pool()._a(this.posX, this.posY, this.posZ);
        vec32 = this.worldObj.getWorldVec3Pool()._a(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        if (movingObjectPosition != null) {
            vec32 = this.worldObj.getWorldVec3Pool()._a(movingObjectPosition._h._c, movingObjectPosition._h._d, movingObjectPosition._h._e);
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
                if (!entity2.canBeCollidedWith() || entity2 == entityLivingBase && this.ticksExisted < 5 || (movingObjectPosition2 = (axisAlignedBB = entity2.boundingBox._b(f = 0.3f, f, f))._a(vec3, vec32)) == null || !((d2 = vec3._d(movingObjectPosition2._h)) < d) && d != 0.0) continue;
                entity = entity2;
                d = d2;
            }
            if (entity != null) {
                movingObjectPosition = new MovingObjectPosition(entity);
            }
        }
        if (movingObjectPosition != null) {
            if (movingObjectPosition._c == EnumMovingObjectType._a && this.worldObj.getBlockId(movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f) == Block.portal.blockID) {
                this.setInPortal();
            } else {
                this.onImpact(movingObjectPosition);
            }
        }
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void setPositionAndRotation2(double d, double d2, double d3, float f, float f2, int n) {
    }
}

