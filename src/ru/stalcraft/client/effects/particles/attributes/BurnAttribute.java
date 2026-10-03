/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.effects.particles.attributes;

import ru.stalcraft.client.effects.particles.Particle;
import ru.stalcraft.client.effects.particles.attributes.Attribute;

public class BurnAttribute
extends Attribute {
    public BurnAttribute() {
        super("burn", 1);
    }

    @Override
    public void writeToBuffer(Particle particle, float frame) {
        this.buffer.put(particle.prevBurn + (particle.burn - particle.prevBurn) * frame);
    }
}

