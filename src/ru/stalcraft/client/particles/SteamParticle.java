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
import ru.stalcraft.client.particles.SteamParticleEmitter;

public class SteamParticle
extends Particle {
    private static final float Y_MOTION = 0.2f;
    private static final float SIZE_FACTOR = 1.07f;
    private int removingStart;
    private float renderStartFrame;
    private int lifetime;
    private float baseAlpha;

    public SteamParticle(SteamParticleEmitter parent, ParticleIcon icon) {
        super(parent, 0.3f, 0.5f, icon);
        this.parent = parent;
        Random rand = parent.world.s;
        Vector2f vec = new Vector2f(rand.nextFloat() - 0.5f, rand.nextFloat() - 0.5f);
        vec.normalise();
        float distance = rand.nextFloat() * 0.5f;
        this.setPosition(parent.centerX + (double)(vec.x * distance), parent.centerY - 0.25 + (double)(rand.nextFloat() * 0.2f), parent.centerZ + (double)(vec.y * distance));
        this.motionY = 0.2f * (rand.nextFloat() / 2.0f + 0.5f);
        this.move(0.0, this.motionY, 0.0);
        this.removingStart = 10 + rand.nextInt(3);
        this.renderStartFrame = rand.nextFloat();
        this.lifetime = (int)(39.0f * (rand.nextFloat() / 2.0f + 0.5f));
        this.prevRotation = this.rotation = (float)rand.nextInt(360);
        this.baseAlpha = 0.3f + rand.nextFloat() * 0.2f;
    }

    @Override
    public void tick() {
        super.tick();
        this.textureSize *= 1.07f;
        this.alpha = (1.0f - (float)this.ticksExisted / (float)this.lifetime) * this.baseAlpha;
        this.motionX += EffectsEngine.instance.xWind + (this.parent.world.s.nextFloat() - 0.5f) * 0.01f;
        this.motionY = 0.2f;
        this.motionZ += EffectsEngine.instance.zWind + (this.parent.world.s.nextFloat() - 0.5f) * 0.01f;
        if (this.ticksExisted >= this.lifetime) {
            this.isDead = true;
        }
    }

    public int compareTo(Object arg0) {
        return 0;
    }
}

