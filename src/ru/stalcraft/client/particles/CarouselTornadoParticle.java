/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.particles;

import java.util.Random;
import ru.stalcraft.client.effects.particles.Particle;
import ru.stalcraft.client.effects.particles.ParticleEmitter;
import ru.stalcraft.client.effects.particles.ParticleIcon;

public class CarouselTornadoParticle
extends Particle {
    public float yawTarget;
    public float rotationCircleSpeed;
    public float distance;
    public float radiusMoveSpeed;
    public float motionYFactor;

    public CarouselTornadoParticle(ParticleEmitter parent, ParticleIcon icon) {
        super(parent, 0.5f, 0.7f, icon);
        Random rand = parent.world.s;
        this.yawTarget = rand.nextFloat() * 360.0f;
        this.distance = rand.nextFloat() * 0.7f + 0.25f;
        float targetDistance = rand.nextFloat() * 1.5f;
        this.radiusMoveSpeed = (targetDistance - this.distance) / 40.0f;
        double x2 = (double)(-ls.a(this.yawTarget / 180.0f * (float)Math.PI) * this.distance) + parent.centerX;
        double z2 = (double)(ls.b(this.yawTarget / 180.0f * (float)Math.PI) * this.distance) + parent.centerZ;
        this.setPosition(x2, parent.centerY - (double)4.3f, z2);
        this.rotationCircleSpeed = 5.0f + rand.nextFloat() * 5.0f;
        this.rotationSpeed = (parent.world.s.nextFloat() - 0.5f) * 15.0f;
        this.motionY = 0.012f + rand.nextFloat() / 50.0f;
        this.alpha = 0.2f;
    }

    @Override
    public void tick() {
        super.tick();
        this.textureSize *= 1.03f;
        this.alpha -= 0.005f;
        this.distance += this.radiusMoveSpeed;
        if (this.ticksExisted > 30 && this.ticksExisted < 150) {
            this.rotationCircleSpeed *= 1.03f;
        }
        this.yawTarget = (this.yawTarget + this.rotationCircleSpeed) % 360.0f;
        float endX = -ls.a(this.yawTarget / 180.0f * (float)Math.PI) * this.distance + (float)this.parent.centerX;
        float endZ = ls.b(this.yawTarget / 180.0f * (float)Math.PI) * this.distance + (float)this.parent.centerZ;
        this.motionX = endX - (float)this.posX;
        this.motionZ = endZ - (float)this.posZ;
        if (this.ticksExisted > 40) {
            this.isDead = true;
        }
    }

    public int compareTo(Object arg0) {
        return 0;
    }
}

