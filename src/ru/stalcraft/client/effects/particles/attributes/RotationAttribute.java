/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.effects.particles.attributes;

import ru.stalcraft.client.effects.particles.Particle;
import ru.stalcraft.client.effects.particles.ParticlesRenderer;
import ru.stalcraft.client.effects.particles.attributes.Attribute;

public class RotationAttribute
extends Attribute {
    public RotationAttribute() {
        super("rotation", 1);
    }

    @Override
    public void writeToBuffer(Particle particle, float frame) {
        this.buffer.put(ParticlesRenderer.interpolateRotation(particle.prevRotation, particle.rotation, frame));
    }
}

