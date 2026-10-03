/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.effects.particles.attributes;

import ru.stalcraft.client.effects.particles.Particle;
import ru.stalcraft.client.effects.particles.attributes.Attribute;

public class TextureCoordsIdAttribute
extends Attribute {
    public TextureCoordsIdAttribute() {
        super("textureCoordsIdFloat", 1);
    }

    @Override
    public void writeToBuffer(Particle particle, float frame) {
        this.buffer.put(particle.icon.index);
    }
}

