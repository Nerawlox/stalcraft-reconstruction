/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.particles;

import java.util.Random;
import ru.stalcraft.client.effects.particles.Particle;
import ru.stalcraft.client.effects.particles.ParticleIcon;
import ru.stalcraft.client.particles.CarouselParticleEmitter;
import ru.stalcraft.tile.TileEntityCarousel;

public class CarouselParticle
extends Particle {
    private CarouselParticleEmitter parent;
    public float yawTarget;
    public float pitchTarget;
    public float rotationCircleSpeed;
    public float rotationRiseSpeed;
    public float distance;
    public float radiusMoveSpeed;
    public float motionYFactor;
    private boolean isLeaf;

    public CarouselParticle(CarouselParticleEmitter parent, ParticleIcon icon, boolean isLeaf, float maxTargetDistance) {
        super(parent, isLeaf ? 0.15f : 0.6f, 1.0f, icon);
        this.parent = parent;
        Random rand = parent.world.s;
        this.rotation = rand.nextFloat() * 360.0f;
        this.yawTarget = rand.nextFloat() * 360.0f;
        this.pitchTarget = rand.nextFloat() * 360.0f;
        this.distance = rand.nextFloat() * 3.0f;
        float targetDistance = rand.nextFloat() * maxTargetDistance;
        this.radiusMoveSpeed = (targetDistance - this.distance) / 120.0f;
        double x2 = (double)(-ls.a(this.yawTarget / 180.0f * (float)Math.PI) * ls.b(this.pitchTarget / 180.0f * (float)Math.PI) * this.distance) + parent.centerX + 0.5;
        double z2 = (double)(ls.b(this.yawTarget / 180.0f * (float)Math.PI) * ls.b(this.pitchTarget / 180.0f * (float)Math.PI) * this.distance) + parent.centerZ + 0.5;
        this.setPosition(x2, parent.centerY - 4.0, z2);
        this.rotationCircleSpeed = 1.5f + rand.nextFloat() / 2.0f;
        this.rotationRiseSpeed = rand.nextFloat() / 10.0f;
        this.rotationSpeed = (parent.world.s.nextFloat() - 0.5f) * 15.0f;
        this.motionYFactor = 0.04f + rand.nextFloat() / 50.0f;
        this.speedFactor = 0.9f;
        this.isLeaf = isLeaf;
        if (isLeaf) {
            this.textureSize = 0.15f;
            this.prevTextureSize = 0.15f;
        }
    }

    @Override
    public void tick() {
        super.tick();
        this.motionY = (float)((double)this.motionY - 0.02);
        TileEntityCarousel tile = (TileEntityCarousel)this.parent.emmiter;
        if (tile.activeTimer >= 0) {
            this.doTickBeforeActivation();
        }
        if (!this.isLeaf && tile.activeTimer == -1) {
            this.alpha = Math.max((float)(80 - tile.ticksSinceActive) / 80.0f, 0.0f);
            this.textureSize *= 0.97f;
        }
        if (this.onGround) {
            this.rotationSpeed = (float)((double)this.rotationSpeed * 0.75);
        }
    }

    private void doTickBeforeActivation() {
        this.distance += this.radiusMoveSpeed;
        this.pitchTarget = (this.pitchTarget + this.rotationRiseSpeed) % 360.0f;
        float endY = -ls.a(this.pitchTarget / 180.0f * (float)Math.PI) * this.distance + (float)this.parent.centerY;
        this.motionY = (float)((double)this.motionYFactor > Math.abs((double)endY - this.posY) ? (double)endY - this.posY : (double)this.motionYFactor);
        this.motionYFactor *= 0.992f;
        if (this.ticksExisted > 30 && this.ticksExisted < 150) {
            this.rotationCircleSpeed *= 1.03f;
        }
        this.yawTarget = (this.yawTarget + this.rotationCircleSpeed) % 360.0f;
        float endX = -ls.a(this.yawTarget / 180.0f * (float)Math.PI) * ls.b(this.pitchTarget / 180.0f * (float)Math.PI) * this.distance + (float)this.parent.emmiter.getPosX() + 0.5f;
        float endZ = ls.b(this.yawTarget / 180.0f * (float)Math.PI) * ls.b(this.pitchTarget / 180.0f * (float)Math.PI) * this.distance + (float)this.parent.emmiter.getPosZ() + 0.5f;
        this.motionX = endX - (float)this.posX;
        this.motionZ = endZ - (float)this.posZ;
    }

    public int compareTo(Object arg0) {
        return 0;
    }
}

