/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.entity;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityBullet
extends Entity {
    private Vec3 fromVec;
    private Vec3 toVec;
    private double distanceSq;
    private static final float SPEED = 30.0f;

    public EntityBullet(World world) {
        super(world);
        this.yOffset = 0.1f;
        this.setSize(0.6f, 0.6f);
        this.renderDistanceWeight = 4.0;
    }

    public EntityBullet(World world, Vec3 vec3, Vec3 vec32) {
        this(world);
        this.fromVec = vec3;
        this.toVec = vec32;
        Vec3 vec33 = vec3._a(vec32);
        this.distanceSq = vec33._c * vec33._c + vec33._d * vec33._d + vec33._e * vec33._e;
        double d = Math.sqrt(this.distanceSq);
        this.motionX = vec33._c / d * 30.0;
        this.motionY = vec33._d / d * 30.0;
        this.motionZ = vec33._e / d * 30.0;
        this.ticksExisted = 1;
        this.lastTickPosX = vec3._c + this.motionX;
        this.lastTickPosY = vec3._d + this.motionY;
        this.lastTickPosZ = vec3._e + this.motionZ;
        this.setPosition(vec3._c + this.motionX, vec3._d + this.motionY, vec3._e + this.motionZ);
    }

    @Override
    protected void entityInit() {
    }

    public EntityBullet(Entity entity, float f, boolean bl, float f2, float f3, String string, double d, float f4, float f5, boolean bl2) {
        this(entity.worldObj);
        this.setLocationAndAngles(entity.posX, entity.posY + (double)entity.getEyeHeight() - (entity.isSneaking() ? 0.09 : 0.0), entity.posZ, f4, f5);
        if (bl) {
            this.posX -= (double)(sajh._b(this.rotationYaw / 180.0f * (float)Math.PI) * 0.245f);
            this.posZ -= (double)(sajh._a(this.rotationYaw / 180.0f * (float)Math.PI) * 0.245f);
        }
        float f6 = -sajh._a(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI) * f3;
        float f7 = sajh._b(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI) * f3;
        float f8 = -sajh._a(this.rotationPitch / 180.0f * (float)Math.PI) * f3;
        float f9 = (entity.worldObj.rand.nextFloat() - 0.5f) * f2 * (float)Math.PI / 90.0f;
        Vec3 vec3 = Vec3._a(entity.worldObj.rand.nextFloat() - 0.5f, entity.worldObj.rand.nextFloat() - 0.5f, entity.worldObj.rand.nextFloat() - 0.5f);
        vec3._a();
        float f10 = sajh._a(f9);
        float f11 = sajh._b(f9);
        float f12 = 1.0f - f11;
        double[] dArray = new double[]{(double)f12 * vec3._c * vec3._c + (double)f11, (double)f12 * vec3._c * vec3._d - vec3._e * (double)f10, (double)f12 * vec3._e * vec3._c + vec3._d * (double)f10, (double)f12 * vec3._c * vec3._d + vec3._e * (double)f10, (double)f12 * vec3._d * vec3._d + (double)f11, (double)f12 * vec3._d * vec3._e - vec3._c * (double)f10, (double)f12 * vec3._e * vec3._c - vec3._d * (double)f10, (double)f12 * vec3._d * vec3._e + vec3._c * (double)f10, (double)f12 * vec3._e * vec3._e + (double)f11};
        this.motionX = dArray[0] * (double)f6 + dArray[1] * (double)f8 + dArray[2] * (double)f7;
        this.motionY = dArray[3] * (double)f6 + dArray[4] * (double)f8 + dArray[5] * (double)f7;
        this.motionZ = dArray[6] * (double)f6 + dArray[7] * (double)f8 + dArray[8] * (double)f7;
        this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
    }

    public EntityBullet(Entity entity, double d, double d2, double d3, float f, float f2, float f3, float f4, String string, double d4, boolean bl) {
        this(entity.worldObj);
        this.setLocationAndAngles(d, d2, d3, f, f2);
        this.motionX = (double)(-sajh._a(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI)) * (double)f4;
        this.motionZ = (double)(sajh._b(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI)) * (double)f4;
        this.motionY = (double)(-sajh._a(this.rotationPitch / 180.0f * (float)Math.PI)) * (double)f4;
        this.setLocationAndAngles(d, d2, d3, this.rotationYaw, this.rotationPitch);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.setDead();
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        this.setPosition(this.posX, this.posY, this.posZ);
        if (!this.isInRange(0.0f)) {
            this.setDead();
        }
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public int getBrightnessForRender(float f) {
        return 0xF000F0;
    }

    @Override
    public float getBrightness(float f) {
        return 1.0f;
    }

    public boolean isInRange(float f) {
        double d = this.lastTickPosX + (this.posX - this.lastTickPosX) * (double)f;
        double d2 = this.lastTickPosY + (this.posY - this.lastTickPosY) * (double)f;
        double d3 = this.lastTickPosZ + (this.posZ - this.lastTickPosZ) * (double)f;
        double d4 = this.fromVec._d(d, d2, d3);
        return d4 < this.distanceSq;
    }
}

