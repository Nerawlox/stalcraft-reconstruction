/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.effects.particles.attributes;

import ru.stalcraft.client.effects.particles.Particle;
import ru.stalcraft.client.effects.particles.attributes.Attribute;

public class PositionAttribute
extends Attribute {
    public PositionAttribute() {
        super("modelPosition", 3);
    }

    @Override
    public void writeToBuffer(Particle particle, float frame) {
        this.buffer.put((float)(particle.prevPosX + (particle.posX - particle.prevPosX) * (double)frame - bgl.b));
        this.buffer.put((float)(particle.prevPosY + (particle.posY - particle.prevPosY) * (double)frame - bgl.c));
        this.buffer.put((float)(particle.prevPosZ + (particle.posZ - particle.prevPosZ) * (double)frame - bgl.d));
    }
}

