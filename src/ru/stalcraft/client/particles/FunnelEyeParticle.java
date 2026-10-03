/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.particles;

import java.util.Random;
import ru.stalcraft.client.effects.particles.Particle;
import ru.stalcraft.client.effects.particles.ParticleIcon;
import ru.stalcraft.client.particles.FunnelParticleEmitter;
import ru.stalcraft.tile.TileEntityFunnel;

public class FunnelEyeParticle
extends Particle {
    private FunnelParticleEmitter parent;
    private boolean isEyeVisible = false;
    private int rotationFactor = 1;
    private int eyeStateChangeTimer = 0;
    private int eyeAngle = 0;
    private static final float DEG_TO_RAD = (float)Math.PI / 180;

    public FunnelEyeParticle(FunnelParticleEmitter parent, ParticleIcon icon) {
        super(parent, 0.0f, 1.4f, icon);
        this.parent = parent;
        TileEntityFunnel funnel = (TileEntityFunnel)parent.emmiter;
        this.clip = false;
        this.setPosition(parent.centerX, parent.centerY - 2.5, parent.centerZ);
        this.alpha = 0.0f;
    }

    @Override
    public void tick() {
        super.tick();
        Random rand = this.parent.world.s;
        this.burn = 0.2f + rand.nextFloat() * 0.1f;
        this.eyeAngle = (this.eyeAngle + 2 * this.rotationFactor) % 360;
        ++this.eyeStateChangeTimer;
        if (rand.nextInt(20) == 0) {
            this.rotationSpeed = (rand.nextFloat() - 0.5f) * 10.0f;
        }
        if (this.isEyeVisible && (rand.nextInt(10) == 0 && this.eyeStateChangeTimer > 2 || ((TileEntityFunnel)this.parent.emmiter).activeTimer >= 0)) {
            this.isEyeVisible = false;
            this.eyeStateChangeTimer = 0;
            this.textureSize = 0.0f;
        } else if (!this.isEyeVisible && rand.nextInt(5) == 0 && this.eyeStateChangeTimer > 2 && ((TileEntityFunnel)this.parent.emmiter).activeTimer < 0) {
            this.isEyeVisible = true;
            this.prevRotation = this.rotation = rand.nextFloat() * 360.0f;
            this.eyeAngle = rand.nextInt(360);
            this.eyeStateChangeTimer = 0;
            int n2 = this.rotationFactor = rand.nextBoolean() ? 1 : -1;
        }
        if (this.isEyeVisible) {
            this.moveTo(this.parent.centerX + (double)ls.b((float)Math.PI / 180 * (float)(this.eyeAngle + 2 * this.rotationFactor)), this.parent.centerY - 2.0, this.parent.centerZ + (double)ls.a((float)Math.PI / 180 * (float)(this.eyeAngle + 2 * this.rotationFactor)));
            this.textureSize = Math.min(1.4f, this.textureSize + 0.1f);
        } else {
            this.setPosition(this.parent.centerX + (double)ls.b((float)Math.PI / 180 * (float)(this.eyeAngle + 2 * this.rotationFactor)), this.parent.centerY - 2.0, this.parent.centerZ + (double)ls.a((float)Math.PI / 180 * (float)(this.eyeAngle + 2 * this.rotationFactor)));
        }
        this.alpha = this.isEyeVisible ? Math.min(1.0f, (float)this.eyeStateChangeTimer * 0.5f) : Math.max(0.0f, 1.0f - (float)this.eyeStateChangeTimer * 0.5f);
    }

    public int compareTo(Object arg0) {
        return 0;
    }
}

