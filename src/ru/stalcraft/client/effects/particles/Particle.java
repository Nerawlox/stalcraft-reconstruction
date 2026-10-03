/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 */
package ru.stalcraft.client.effects.particles;

import java.util.List;
import ru.stalcraft.client.effects.particles.ParticleEmitter;
import ru.stalcraft.client.effects.particles.ParticleIcon;

public abstract class Particle
implements Comparable {
    public final asx boundingBox;
    public ParticleEmitter parent;
    public double posX;
    public double posY;
    public double posZ;
    public double prevPosX;
    public double prevPosY;
    public double prevPosZ;
    public float motionX;
    public float motionY;
    public float motionZ;
    public float speedFactor = 1.0f;
    public float rotation;
    public float prevRotation;
    public float rotationSpeed;
    protected boolean clip = true;
    public boolean onGround;
    public int ticksExisted;
    public boolean isDead;
    private int posVboId = 0;
    public float alpha = 1.0f;
    public float prevAlpha = 1.0f;
    public ParticleIcon icon;
    public float textureSize;
    public float prevTextureSize;
    public float collisionSize;
    protected float halfCollisionSize;
    public double lastDistanceSq;
    public float burn = 0.0f;
    public float prevBurn = 0.0f;

    public Particle(ParticleEmitter parent, float collisionSize, float size, ParticleIcon icon) {
        this.parent = parent;
        this.boundingBox = asx.a((double)0.0, (double)0.0, (double)0.0, (double)0.0, (double)0.0, (double)0.0);
        this.halfCollisionSize = collisionSize / 2.0f;
        this.setCollisionSize(collisionSize);
        this.textureSize = size;
        this.icon = icon;
    }

    public void tick() {
        ++this.ticksExisted;
        this.prevAlpha = this.alpha;
        this.prevBurn = this.burn;
        this.prevTextureSize = this.textureSize;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.prevRotation = this.rotation;
        this.motionX *= this.speedFactor;
        this.motionY *= this.speedFactor;
        this.motionZ *= this.speedFactor;
        this.rotation += this.rotationSpeed;
        this.move(this.motionX, this.motionY, this.motionZ);
    }

    public void move(double x2, double y2, double z2) {
        if (this.clip) {
            this.clippedMove(this.motionX, this.motionY, this.motionZ);
        } else {
            this.simpleMove(this.motionX, this.motionY, this.motionZ);
        }
    }

    public void updateDistance(double cameraX, double cameraY, double cameraZ, float frame) {
        double deltaX = this.prevPosX + (this.posX - this.prevPosX) * (double)frame - cameraX;
        double deltaY = this.prevPosY + (this.posY - this.prevPosY) * (double)frame - cameraY;
        double deltaZ = this.prevPosZ + (this.posZ - this.prevPosZ) * (double)frame - cameraZ;
        this.lastDistanceSq = deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ;
    }

    protected void setCollisionSize(float size) {
        if (size != this.collisionSize) {
            this.collisionSize = size;
            this.boundingBox.d = this.boundingBox.a + (double)this.collisionSize;
            this.boundingBox.f = this.boundingBox.c + (double)this.collisionSize;
            this.boundingBox.e = this.boundingBox.b + (double)this.collisionSize;
        }
    }

    public void setPosition(double x2, double y2, double z2) {
        this.prevPosX = this.posX = x2;
        this.prevPosY = this.posY = y2;
        this.prevPosZ = this.posZ = z2;
        this.updateBounds();
    }

    public void moveTo(double x2, double y2, double z2) {
        this.posX = x2;
        this.posY = y2;
        this.posZ = z2;
        this.updateBounds();
    }

    protected void simpleMove(double moveX, double moveY, double moveZ) {
        this.posX += moveX;
        this.posY += moveY;
        this.posZ += moveZ;
        this.updateBounds();
    }

    protected void updateBounds() {
        this.boundingBox.b(this.posX - (double)this.halfCollisionSize, this.posY - (double)this.halfCollisionSize, this.posZ - (double)this.halfCollisionSize, this.posX + (double)this.halfCollisionSize, this.posY + (double)this.halfCollisionSize, this.posZ + (double)this.halfCollisionSize);
    }

    protected void clippedMove(double moveX, double moveY, double moveZ) {
        int j2;
        double tempX = this.posX;
        double tempY = this.posY;
        double tempZ = this.posZ;
        double tempMoveX = moveX;
        double tempMoveY = moveY;
        double tempMoveZ = moveZ;
        asx axisalignedbb = this.boundingBox.c();
        List list = this.parent.getCollidingBoundingBoxes(this.boundingBox.a(moveX, moveY, moveZ));
        for (j2 = 0; j2 < list.size(); ++j2) {
            moveY = ((asx)list.get(j2)).b(this.boundingBox, moveY);
        }
        this.boundingBox.d(0.0, moveY, 0.0);
        for (j2 = 0; j2 < list.size(); ++j2) {
            moveX = ((asx)list.get(j2)).a(this.boundingBox, moveX);
        }
        this.boundingBox.d(moveX, 0.0, 0.0);
        for (j2 = 0; j2 < list.size(); ++j2) {
            moveZ = ((asx)list.get(j2)).c(this.boundingBox, moveZ);
        }
        this.boundingBox.d(0.0, 0.0, moveZ);
        this.posX = (float)((this.boundingBox.a + this.boundingBox.d) / 2.0);
        this.posY = (float)(this.boundingBox.b + (double)this.collisionSize / 2.0);
        this.posZ = (float)((this.boundingBox.c + this.boundingBox.f) / 2.0);
        boolean bl2 = this.onGround = tempMoveY != moveY && tempMoveY < 0.0;
        if (tempMoveX != moveX) {
            this.motionX = 0.0f;
        }
        if (tempMoveY != moveY) {
            this.motionY = 0.0f;
        }
        if (tempMoveZ != moveZ) {
            this.motionZ = 0.0f;
        }
    }

    public boolean shouldRender(float frame) {
        return true;
    }

    public float getLightmaskBrightness() {
        int z2;
        int x2 = ls.c(this.posX);
        if (this.parent.world.f(x2, 0, z2 = ls.c(this.posZ))) {
            double d0 = (this.boundingBox.e - this.boundingBox.b) * 0.5;
            int y2 = ls.c(this.posY + d0);
            float brigtness = (float)this.parent.world.n(x2, y2, z2) / 16.0f;
            return brigtness;
        }
        return 0.0f;
    }

    public int getTessellatorBrightness() {
        int j2;
        int i2 = ls.c(this.posX);
        if (this.parent.world.f(i2, 0, j2 = ls.c(this.posZ))) {
            double d0 = (this.boundingBox.e - this.boundingBox.b) * 0.5;
            int k2 = ls.c(this.posY + d0);
            return this.parent.world.h(i2, k2, j2, 0);
        }
        return 0;
    }

    public int compareTo(Particle anotherParticle) {
        return this.lastDistanceSq > anotherParticle.lastDistanceSq ? -1 : (this.lastDistanceSq < anotherParticle.lastDistanceSq ? 1 : 0);
    }
}

