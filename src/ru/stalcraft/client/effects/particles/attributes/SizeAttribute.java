/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.effects.particles.attributes;

import ru.stalcraft.client.effects.particles.Particle;
import ru.stalcraft.client.effects.particles.attributes.Attribute;

public class SizeAttribute
extends Attribute {
    public SizeAttribute() {
        super("size", 1);
    }

    @Override
    public void writeToBuffer(Particle particle, float frame) {
        this.buffer.put(particle.prevTextureSize + (particle.textureSize - particle.prevTextureSize) * frame);
    }
}

