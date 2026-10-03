/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 */
package ru.stalcraft.client.effects.particles.attributes;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import ru.stalcraft.client.effects.particles.Particle;

public abstract class Attribute {
    private static final int INITIAL_BUFFER_CAPACITY = 10000;
    public final String name;
    public final int floatsPerParticle;
    public int vboId;
    public FloatBuffer buffer;
    public int location;

    public Attribute(String attributeName, int floatsPerParticle) {
        this.name = attributeName;
        this.floatsPerParticle = floatsPerParticle;
    }

    public abstract void writeToBuffer(Particle var1, float var2);

    public void prepareBuffer(int numberOfParticles) {
        if (this.buffer == null) {
            this.buffer = BufferUtils.createFloatBuffer((int)(Math.max(10000, numberOfParticles) * this.floatsPerParticle));
        } else if (this.buffer.capacity() < numberOfParticles * this.floatsPerParticle) {
            this.buffer = BufferUtils.createFloatBuffer((int)(numberOfParticles * this.floatsPerParticle));
        } else {
            this.buffer.clear();
        }
    }
}

