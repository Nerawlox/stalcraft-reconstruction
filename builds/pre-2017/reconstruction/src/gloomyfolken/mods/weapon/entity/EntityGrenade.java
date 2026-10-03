/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.entity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.entity.EntityAdvancedThrowable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenade
extends EntityAdvancedThrowable {
    private float explosionSize;
    private boolean explosionOnCollide;
    private scai grenadeType = scai._a;
    private int grenadeItemId = -1;

    public EntityGrenade(World world) {
        super(world);
        this.prevRotationZ = -90.0f;
        this.zRotation = -90.0f;
    }

    public EntityGrenade(World world, EntityLivingBase entityLivingBase, float f, yurw yurw2, boolean bl) {
        super(world, entityLivingBase, f, yurw2._d, yurw2._l());
        this.explosionSize = yurw2._c;
        this.explosionOnCollide = yurw2._f;
        this.useYawPitch = bl;
        this.grenadeType = yurw2._e;
        this.grenadeItemId = yurw2.itemID;
        this.prevRotationZ = -90.0f;
        this.zRotation = -90.0f;
    }

    public EntityGrenade setGrenadeType(scai scai2) {
        this.grenadeType = scai2;
        return this;
    }

    @Override
    protected float getGroundFrictionFactor() {
        return 0.8f;
    }

    @Override
    protected float getJumpFactor() {
        return 0.1f;
    }

    @Override
    public void updatePos() {
        super.updatePos();
        if (this.onGround) {
            this.motionX *= 0.125;
            this.motionZ *= 0.125;
            if (this.explosionOnCollide) {
                this.setDead();
            }
        }
    }

    @Override
    public void setDead() {
        if (!this.isDead && !this.worldObj.isRemote) {
            this.createExplosion();
        }
        super.setDead();
    }

    private void createExplosion() {
        InvokeSideOnly.frontend(() -> {});
    }

    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition) {
        super.onImpact(movingObjectPosition);
        if (this.useYawPitch) {
            this.useYawPitch = false;
            if (!this.worldObj.isRemote) {
                InvokeSideOnly.frontend(() -> {});
            }
        }
        if (this.explosionOnCollide) {
            this.setDead();
        }
    }

    @Override
    protected void onCantMove() {
        if (this.explosionOnCollide) {
            this.setDead();
        }
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.explosionSize = nBTTagCompound._h("explosion_size");
        this.explosionOnCollide = nBTTagCompound._o("explosion_on_collide");
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("explosion_size", this.explosionSize);
        nBTTagCompound._a("explosion_on_collide", this.explosionOnCollide);
    }

    @Override
    public void writeSpawnData(ByteArrayDataOutput byteArrayDataOutput) {
        super.writeSpawnData(byteArrayDataOutput);
        byteArrayDataOutput.writeBoolean(this.useYawPitch);
    }

    @Override
    public void readSpawnData(ByteArrayDataInput byteArrayDataInput) {
        super.readSpawnData(byteArrayDataInput);
        this.useYawPitch = byteArrayDataInput.readBoolean();
    }
}

