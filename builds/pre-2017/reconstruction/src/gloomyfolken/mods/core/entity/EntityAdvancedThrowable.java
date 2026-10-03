/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.entity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.entity.jxtc;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityAdvancedThrowable
extends Entity
implements IEntityAdditionalSpawnData {
    protected static final float MOTION_FACTOR = 0.999f;
    protected static final float ROTATION_FACTOR = 0.999f;
    protected static final float ENTITY_SIZE = 0.1f;
    public float xRotation = 0.0f;
    public float yRotation = 0.0f;
    public float zRotation = 0.0f;
    public float xRotationSpeed = 0.0f;
    public float yRotationSpeed = 0.0f;
    public float zRotationSpeed = 0.0f;
    public float prevRotationX;
    public float prevRotationY;
    public float prevRotationZ;
    protected boolean collided = false;
    protected double prevY;
    public EntityLivingBase shooter;
    public String modelName;
    public String textureName;
    public int lifetime;
    public boolean useYawPitch;
    protected Vec3 spawnPos = VecExtensionsKt.vec3();
    public boolean isFakeClientEntity;
    public int fakeEntityId = -1;
    public boolean visible = true;
    public boolean synced = false;
    private EntityAdvancedThrowable fakeEntity;
    private static int FAKE_ID_COUNTER = 0;
    private static HashMap<Integer, EntityAdvancedThrowable> fakeThrowables = new HashMap();
    private List<Vec3> fakePosHistory = new ArrayList<Vec3>();
    private boolean fakeDesynced = false;

    public EntityAdvancedThrowable(World world) {
        super(world);
        this.xRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        this.yRotationSpeed = (float)Math.random() * 10.0f + 10.0f;
        this.zRotationSpeed = ((float)Math.random() - 0.5f) * 10.0f;
        this.setSize(this.getEntitySize(), this.getEntitySize());
        this.renderDistanceWeight = 1000.0;
        this.yOffset = 0.0f;
    }

    public EntityAdvancedThrowable(World world, EntityLivingBase entityLivingBase, float f, int n, float f2) {
        this(world);
        this.lifetime = n;
        this.setInitialMotion(entityLivingBase, f, f2);
    }

    public void setAsFakeEntity() {
        this.isFakeClientEntity = true;
        if (this.fakeEntityId < 0) {
            this.fakeEntityId = FAKE_ID_COUNTER++;
            fakeThrowables.put(this.fakeEntityId, this);
        }
    }

    public void setAsGuideEntity(int n) {
        EntityAdvancedThrowable entityAdvancedThrowable = fakeThrowables.get(n);
        if (entityAdvancedThrowable != null) {
            this.fakeEntity = entityAdvancedThrowable;
            this.visible = false;
        }
    }

    private boolean isGuideEntity() {
        return this.fakeEntity != null;
    }

    public void setInitialMotion(EntityLivingBase entityLivingBase, float f, float f2) {
        jxtc jxtc2;
        this.shooter = entityLivingBase;
        this.rotationYaw = -entityLivingBase.rotationYawHead;
        this.rotationPitch = entityLivingBase.rotationPitch;
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
        if (entityLivingBase instanceof EntityPlayer && (jxtc2 = jxtc._a((EntityPlayer)entityLivingBase)) != null) {
            McExtensionsKt.setPos(this, jxtc2._a(0.0f));
            Vec3 vec3 = jxtc2._a(0.0f, f, f2);
            this.motionX = vec3._c;
            this.motionY = vec3._d;
            this.motionZ = vec3._e;
        }
        double d = 0.0;
        double d2 = 0.0;
        if (entityLivingBase instanceof EntityPlayerMP) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)entityLivingBase;
            d = entityLivingBase.posX - entityPlayerMP.playerNetServerHandler.lastPosX;
            d2 = entityLivingBase.posZ - entityPlayerMP.playerNetServerHandler.lastPosZ;
        }
        this.posX += d * 1.0;
        this.posZ += d2 * 1.0;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.spawnPos._c = this.posX;
        this.spawnPos._d = this.posY;
        this.spawnPos._e = this.posZ;
    }

    protected float getGroundFrictionFactor() {
        return 0.95f;
    }

    protected float getEntitySize() {
        return 0.01f;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.updatePos();
        if (this.worldObj.isRemote) {
            this.prevRotationX = this.xRotation;
            this.prevRotationY = this.yRotation;
            this.prevRotationZ = this.zRotation;
            this.updateRotation();
            if (this.isFakeClientEntity && !this.fakeDesynced) {
                if (this.ticksExisted == 1) {
                    this.fakePosHistory.add(McExtensionsKt.getPrevPos(this));
                }
                this.fakePosHistory.add(McExtensionsKt.getPos(this));
            } else if (this.isGuideEntity()) {
                this.updateGuidedEntity();
            }
        }
        this.prevY = this.posY;
        if (!this.worldObj.isRemote && this.ticksExisted > this.lifetime) {
            this.setDead();
        }
    }

    private void updateGuidedEntity() {
        Vec3 vec3 = McExtensionsKt.getPos(this);
        if (this.synced) {
            if (!this.fakeDesynced && this.fakeEntity.fakePosHistory.stream().noneMatch(vec32 -> vec32._d(vec3) < 0.5)) {
                this.fakeEntity.fakeDesynced = true;
                this.fakeDesynced = true;
            }
            if (this.fakeDesynced) {
                this.fakeEntity.setPosition(vec3._c, vec3._d, vec3._e);
            }
        }
    }

    private void removeGuidedEntity() {
        int n = this.fakeEntityId;
        if (this.isGuideEntity()) {
            n = this.fakeEntity.fakeEntityId;
            this.fakeEntity.setDead();
        }
        fakeThrowables.remove(n);
    }

    @Override
    public void setDead() {
        this.removeGuidedEntity();
        super.setDead();
    }

    protected void updateRotation() {
        float f = this.posY == this.prevY ? 0.94905f : 0.999f;
        this.xRotationSpeed *= f;
        this.yRotationSpeed *= f;
        this.zRotationSpeed *= f;
        this.xRotation = (this.xRotation + this.xRotationSpeed) % 360.0f;
        this.yRotation = (this.yRotation + this.yRotationSpeed) % 360.0f;
        this.zRotation = (this.zRotation + this.zRotationSpeed) % 360.0f;
    }

    public void updatePos() {
        Object object;
        int n;
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        Vec3 vec3 = this.worldObj.getWorldVec3Pool()._a(this.posX, this.posY, this.posZ);
        Vec3 vec32 = this.worldObj.getWorldVec3Pool()._a(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        MovingObjectPosition movingObjectPosition = this.worldObj.func_72831_a(vec3, vec32, false, true);
        vec3 = this.worldObj.getWorldVec3Pool()._a(this.posX, this.posY, this.posZ);
        vec32 = this.worldObj.getWorldVec3Pool()._a(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        if (movingObjectPosition != null) {
            vec32 = this.worldObj.getWorldVec3Pool()._a(movingObjectPosition._h._c, movingObjectPosition._h._d, movingObjectPosition._h._e);
        }
        Object object2 = null;
        List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox._a(this.motionX, this.motionY, this.motionZ)._b(1.0, 1.0, 1.0));
        double d = 0.0;
        EntityLivingBase entityLivingBase = this.shooter;
        for (n = 0; n < list2.size(); ++n) {
            double d2;
            float f;
            AxisAlignedBB axisAlignedBB;
            MovingObjectPosition movingObjectPosition2;
            object = (Entity)list2.get(n);
            if (!((Entity)object).canBeCollidedWith() || object == entityLivingBase && this.ticksExisted < 5 || (movingObjectPosition2 = (axisAlignedBB = ((Entity)object).boundingBox._b(f = 0.3f, f, f))._a(vec3, vec32)) == null || !((d2 = vec3._d(movingObjectPosition2._h)) < d) && d != 0.0) continue;
            object2 = object;
            d = d2;
        }
        if (object2 != null) {
            // empty if block
        }
        if (movingObjectPosition != null && movingObjectPosition._c == EnumMovingObjectType._a && (n = this.worldObj.getBlockId(movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f)) > 0 && !((object = Block.blocksList[n]) instanceof yufe)) {
            this.onImpact(movingObjectPosition);
        }
        double d3 = this.motionX;
        double d4 = this.motionY;
        double d5 = this.motionZ;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (d3 != this.motionX || d4 != this.motionY || d5 != this.motionZ) {
            this.onCantMove();
        }
        if (this.onGround) {
            this.motionX *= (double)this.getGroundFrictionFactor();
            this.motionZ *= (double)this.getGroundFrictionFactor();
        }
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
        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2f;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2f;
        float f2 = 0.99f;
        float f3 = 0.05f;
        if (this.isInWater()) {
            for (int i = 0; i < 4; ++i) {
                float f4 = 0.25f;
                this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f4, this.posY - this.motionY * (double)f4, this.posZ - this.motionZ * (double)f4, this.motionX, this.motionY, this.motionZ);
            }
            f2 = 0.8f;
        }
        this.motionX *= (double)f2;
        this.motionY *= (double)f2;
        this.motionZ *= (double)f2;
        this.motionY -= (double)f3;
        if (!this.worldObj.isRemote) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    protected void onCantMove() {
    }

    protected void onImpact(MovingObjectPosition movingObjectPosition) {
        if (movingObjectPosition._c.ordinal() == 0) {
            this.pushOff(movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f, movingObjectPosition._g);
        } else if (this.ticksExisted > 5 || movingObjectPosition._i != this.shooter) {
            this.hitEntity(movingObjectPosition._i);
        }
        this.calculateNewImpact();
    }

    protected void hitEntity(Entity entity) {
        this.motionX *= -0.5;
        this.motionY *= -0.5;
        this.motionZ *= -0.5;
    }

    protected void pushOff(int n, int n2, int n3, int n4) {
        boolean bl;
        boolean bl2 = bl = Math.abs(this.motionY) > (double)0.1f;
        if (n4 == 0 || n4 == 1) {
            if (bl) {
                this.motionX *= (double)0.8f;
                this.motionY *= (double)(-this.getJumpFactor());
                this.motionZ *= (double)0.8f;
            } else {
                this.motionX *= (double)this.getGroundFrictionFactor();
                this.motionY = 0.0;
                this.motionZ *= (double)this.getGroundFrictionFactor();
            }
        } else if (n4 == 2 || n4 == 3) {
            this.motionX *= 0.5;
            this.motionY *= 0.5;
            this.motionZ *= (double)(-this.getJumpFactor());
        } else {
            this.motionX *= (double)(-this.getJumpFactor());
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
        }
    }

    protected float getJumpFactor() {
        return 0.5f;
    }

    protected void calculateNewImpact() {
        Vec3 vec3 = this.worldObj.getWorldVec3Pool()._a(this.posX, this.posY, this.posZ);
        Vec3 vec32 = this.worldObj.getWorldVec3Pool()._a(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        MovingObjectPosition movingObjectPosition = this.worldObj.func_72831_a(vec3, vec32, false, true);
        vec3 = this.worldObj.getWorldVec3Pool()._a(this.posX, this.posY, this.posZ);
        vec32 = this.worldObj.getWorldVec3Pool()._a(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        if (movingObjectPosition != null) {
            vec32 = this.worldObj.getWorldVec3Pool()._a(movingObjectPosition._h._c, movingObjectPosition._h._d, movingObjectPosition._h._e);
        }
        if (!this.worldObj.isRemote) {
            Entity entity = null;
            List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox._a(this.motionX, this.motionY, this.motionZ)._b(1.0, 1.0, 1.0));
            double d = 0.0;
            EntityLivingBase entityLivingBase = this.shooter;
            for (int i = 0; i < list2.size(); ++i) {
                double d2;
                float f;
                AxisAlignedBB axisAlignedBB;
                MovingObjectPosition movingObjectPosition2;
                Entity entity2 = (Entity)list2.get(i);
                if (!entity2.canBeCollidedWith() || entity2 == entityLivingBase && this.ticksExisted < 5 || (movingObjectPosition2 = (axisAlignedBB = entity2.boundingBox._b(f = 0.3f, f, f))._a(vec3, vec32)) == null || !((d2 = vec3._d(movingObjectPosition2._h)) < d) && d != 0.0) continue;
                entity = entity2;
                d = d2;
            }
            if (entity != null) {
                movingObjectPosition = new MovingObjectPosition(entity);
            }
        }
        if (movingObjectPosition != null && movingObjectPosition._c == EnumMovingObjectType._a) {
            this.onImpact(movingObjectPosition);
        }
    }

    @Override
    protected void playStepSound(int n, int n2, int n3, int n4) {
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.modelName = nBTTagCompound._j("model_name");
        this.lifetime = nBTTagCompound._f("lifetime");
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("model_name", this.modelName);
        nBTTagCompound._a("lifetime", this.lifetime);
    }

    @Override
    protected void entityInit() {
    }

    @Override
    public void writeSpawnData(ByteArrayDataOutput byteArrayDataOutput) {
        byteArrayDataOutput.writeUTF(this.modelName);
        byteArrayDataOutput.writeBoolean(this.visible);
    }

    @Override
    public void readSpawnData(ByteArrayDataInput byteArrayDataInput) {
        this.modelName = byteArrayDataInput.readUTF();
        this.visible = byteArrayDataInput.readBoolean();
    }
}

