/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.particles;

import java.util.Random;
import ru.stalcraft.client.effects.particles.Particle;
import ru.stalcraft.client.effects.particles.ParticleEmitter;
import ru.stalcraft.client.effects.particles.ParticleIcon;

public class KisselBubbleParticle
extends Particle {
    public KisselBubbleParticle(ParticleEmitter parent, float size, ParticleIcon icon) {
        super(parent, size, size, icon);
        Random rand = parent.world.s;
        this.setPosition(parent.centerX + rand.nextDouble() - 0.5, parent.centerY, parent.centerZ + rand.nextDouble() - 0.5);
        this.motionY = 0.01f + rand.nextFloat() * 0.005f;
        this.burn = 0.2f + rand.nextFloat() * 0.1f;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.textureSize == 0.0f) {
            this.isDead = true;
        } else if (this.parent.world.s.nextInt(20) == 0) {
            this.textureSize = 0.0f;
        }
    }

    public int compareTo(Object arg0) {
        return 0;
    }
}

