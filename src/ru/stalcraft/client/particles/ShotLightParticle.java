/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.particles;

import ru.stalcraft.client.effects.particles.Particle;
import ru.stalcraft.client.effects.particles.ParticleIcon;
import ru.stalcraft.client.particles.ShotParticleEmitter;

public class ShotLightParticle
extends Particle {
    private ShotParticleEmitter parent;

    public ShotLightParticle(ShotParticleEmitter parent, ParticleIcon icon) {
        super(parent, 0.15f, 0.15f, icon);
        this.parent = parent;
        this.setPosition(parent.centerX, parent.centerY, parent.centerZ);
        this.prevBurn = 1.0f;
        this.burn = 1.0f;
        this.speedFactor = 0.3f;
        this.rotation = this.prevRotation = parent.world.s.nextFloat() * 360.0f;
        this.alpha = 0.0f;
    }

    @Override
    public void tick() {
        super.tick();
        if (((nn)((Object)this.parent.emmiter)).ac <= 2) {
            this.alpha = 1.0f;
        }
        if (((nn)((Object)this.parent.emmiter)).ac > 2) {
            this.alpha = 0.0f;
        }
    }

    public int compareTo(Object arg0) {
        return 0;
    }
}

