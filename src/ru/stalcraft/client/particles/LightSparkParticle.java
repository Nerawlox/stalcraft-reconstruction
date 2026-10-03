/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.util.vector.Vector2f
 */
package ru.stalcraft.client.particles;

import java.util.Random;
import org.lwjgl.util.vector.Vector2f;
import ru.stalcraft.client.effects.particles.Particle;
import ru.stalcraft.client.effects.particles.ParticleIcon;
import ru.stalcraft.client.particles.LighterParticleEmitter;

public class LightSparkParticle
extends Particle {
    private static final float Y_VELOCITY = -0.03f;
    private static final float SIZE_FACTOR = 1.08f;
    private int removingStart;
    private float alphaFactor;
    private float renderStartFrame;
    private int lifetime;

    public LightSparkParticle(LighterParticleEmitter parent, ParticleIcon icon) {
        super(parent, 0.1f, 0.2f, icon);
        this.parent = parent;
        Random rand = parent.world.s;
        this.setPosition(parent.centerX, parent.centerY, parent.centerZ);
        Vector2f vec = new Vector2f(rand.nextFloat() - 0.5f, rand.nextFloat() - 0.5f);
        vec.normalise();
        float speed = rand.nextFloat() * 0.05f;
        this.motionX = vec.x * speed;
        this.motionZ = vec.y * speed;
        this.motionY = rand.nextFloat() * 0.15f + 0.3f;
        this.alphaFactor = 0.8f - rand.nextFloat() / 10.0f;
        this.removingStart = 10 + rand.nextInt(3);
        this.renderStartFrame = rand.nextFloat();
        this.lifetime = rand.nextInt(5) + 5;
        this.burn = 1.0f;
        this.prevBurn = 1.0f;
    }

    @Override
    public void tick() {
        super.tick();
        this.motionY += -0.03f;
        if (this.lifetime - this.ticksExisted < 5) {
            this.alpha = Math.max(0.0f, (float)(this.lifetime - this.ticksExisted) * 0.25f);
        }
        if (this.ticksExisted >= this.lifetime || this.onGround) {
            this.isDead = true;
        }
    }

    public int compareTo(Object arg0) {
        return super.compareTo((Particle)arg0);
    }
}

