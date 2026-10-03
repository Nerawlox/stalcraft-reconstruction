/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  atc
 */
package ru.stalcraft.client.particles;

import java.util.Random;
import ru.stalcraft.client.effects.particles.Particle;
import ru.stalcraft.client.effects.particles.ParticleIcon;
import ru.stalcraft.client.particles.TrampolineParticleEmitter;

public class TrampolineDustParticle
extends Particle {
    private static final float SIZE_FACTOR = 1.01f;
    private float lifetime;

    public TrampolineDustParticle(TrampolineParticleEmitter parent, ParticleIcon icon) {
        super(parent, 0.3f, 0.5f, icon);
        Random rand = parent.world.s;
        this.rotation = rand.nextFloat() * 360.0f;
        float yawTarget = rand.nextFloat() * 360.0f;
        float distance = rand.nextFloat() * 0.5f;
        float speed = rand.nextFloat() * 0.1f + 0.1f;
        atc motionVec = atc.a((double)rand.nextFloat(), (double)(rand.nextFloat() * 4.0f), (double)rand.nextFloat()).a();
        double x2 = (double)(-ls.a(yawTarget / 180.0f * (float)Math.PI) * distance) + parent.centerX;
        double z2 = (double)(ls.b(yawTarget / 180.0f * (float)Math.PI) * distance) + parent.centerZ;
        this.setPosition(x2, parent.centerY, z2);
        this.rotationSpeed = (parent.world.s.nextFloat() - 0.5f) * 15.0f;
        this.motionX = (float)motionVec.c * speed * (float)(rand.nextBoolean() ? 1 : -1);
        this.motionY = (float)motionVec.d * speed;
        this.motionZ = (float)motionVec.e * speed * (float)(rand.nextBoolean() ? 1 : -1);
        this.lifetime = 50 + rand.nextInt(50);
        this.speedFactor = 0.93f;
    }

    @Override
    public void tick() {
        super.tick();
        this.motionY = (float)((double)this.motionY - 0.005);
        this.textureSize *= 1.01f;
        this.alpha = 1.0f - (float)this.ticksExisted / this.lifetime;
        if (this.onGround) {
            this.rotationSpeed = (float)((double)this.rotationSpeed * 0.75);
        }
        if ((float)this.ticksExisted >= this.lifetime) {
            this.isDead = true;
        }
    }

    public int compareTo(Object arg0) {
        return 0;
    }
}

