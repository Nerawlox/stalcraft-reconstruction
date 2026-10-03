/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.particles;

import ru.stalcraft.client.effects.particles.Particle;
import ru.stalcraft.client.effects.particles.ParticleIcon;
import ru.stalcraft.client.particles.TrampolineParticleEmitter;

public class TrampolineStoneParticle
extends Particle {
    public TrampolineStoneParticle(TrampolineParticleEmitter parent, ParticleIcon icon) {
        super(parent, 0.03f, 0.05f, icon);
        this.setPosition(parent.centerX + parent.world.s.nextDouble() - 0.5, parent.centerY + (double)this.halfCollisionSize, parent.centerZ + parent.world.s.nextDouble() - 0.5);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.motionY == 0.0f && Math.random() > 0.99) {
            this.jump();
        }
        this.motionY = (float)((double)this.motionY - 0.05);
    }

    public void jump() {
        this.motionY += this.parent.world.s.nextFloat() / 4.0f;
    }

    public int compareTo(Object arg0) {
        return 0;
    }
}

