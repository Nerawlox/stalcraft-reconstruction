/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.util.vector.Vector2f
 */
package ru.stalcraft.client.particles;

import java.util.Random;
import org.lwjgl.util.vector.Vector2f;
import ru.stalcraft.client.effects.EffectsEngine;
import ru.stalcraft.client.effects.particles.Particle;
import ru.stalcraft.client.effects.particles.ParticleIcon;
import ru.stalcraft.client.particles.LighterParticleEmitter;

public class LighterParticle
extends Particle {
    private static final float Y_MOTION = 0.2f;
    private static final float SIZE_FACTOR = 1.08f;
    private int removingStart;
    private float alphaFactor;
    private float renderStartFrame;
    private int lifetime;

    public LighterParticle(LighterParticleEmitter parent, ParticleIcon icon) {
        super(parent, 0.3f, 0.2f, icon);
        this.parent = parent;
        Random rand = parent.world.s;
        Vector2f vec = new Vector2f(rand.nextFloat() - 0.5f, rand.nextFloat() - 0.5f);
        vec.normalise();
        float distance = rand.nextFloat() * 0.1f;
        this.setPosition(parent.centerX + (double)(vec.x * distance), parent.centerY - 0.25 + (double)(rand.nextFloat() * 0.2f), parent.centerZ + (double)(vec.y * distance));
        this.motionY = 0.2f * (rand.nextFloat() / 2.0f + 0.5f);
        this.move(0.0, this.motionY, 0.0);
        this.alphaFactor = 0.8f - rand.nextFloat() / 10.0f;
        this.removingStart = 10 + rand.nextInt(3);
        this.renderStartFrame = rand.nextFloat();
        this.lifetime = (int)(19.0f * (rand.nextFloat() / 2.0f + 0.5f));
        this.burn = 1.0f;
        this.prevBurn = 1.0f;
    }

    @Override
    public void tick() {
        super.tick();
        this.textureSize *= 1.08f;
        this.motionX += EffectsEngine.instance.xWind + (this.parent.world.s.nextFloat() - 0.5f) * 0.03f;
        this.motionY = 0.2f;
        this.motionZ += EffectsEngine.instance.zWind + (this.parent.world.s.nextFloat() - 0.5f) * 0.03f;
        if (this.lifetime - this.ticksExisted < 5) {
            this.alpha = Math.max(0.0f, (float)(this.lifetime - this.ticksExisted) * 0.25f);
        }
        if (this.ticksExisted >= this.lifetime) {
            this.isDead = true;
        }
    }

    public int compareTo(Object arg0) {
        return 0;
    }
}

