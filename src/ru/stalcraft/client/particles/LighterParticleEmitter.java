/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mt
 */
package ru.stalcraft.client.particles;

import ru.stalcraft.client.effects.particles.ParticleEmitter;
import ru.stalcraft.client.effects.particles.ParticleIcon;
import ru.stalcraft.client.gui.GuiSettingsStalker;
import ru.stalcraft.client.particles.LightSparkParticle;
import ru.stalcraft.client.particles.LighterParticle;
import ru.stalcraft.tile.TileEntityLighter;

public class LighterParticleEmitter
extends ParticleEmitter {
    private static final int MAX_PARTICLES_ACTIVE = 3000;
    public static final int PARTICLE_LIFE = 20;
    private static ParticleIcon[] icons;
    private static ParticleIcon sparkIcon;

    public LighterParticleEmitter(TileEntityLighter lighter) {
        super(lighter);
        super.setCenter(this.centerX + 0.5, (double)((float)this.centerY) + 0.25, this.centerZ + 0.5);
        super.setSize(-2.0, -3.0, -2.0, 2.0, 7.0, 2.0);
    }

    @Override
    public void tick() {
        super.tick();
        if (((TileEntityLighter)this.emmiter).activeTimer > 0) {
            int particlesCount = 30;
            for (int i2 = 0; i2 < particlesCount; ++i2) {
                this.particles.add(new LighterParticle(this, icons[this.world.s.nextInt(icons.length)]));
            }
        } else if (this.world.s.nextInt(5) == 0) {
            this.particles.add(new LightSparkParticle(this, sparkIcon));
        }
        this.renderDistanceSq = GuiSettingsStalker.particleRenderDistance * GuiSettingsStalker.particleRenderDistance;
    }

    @Override
    public boolean isValid() {
        return this.mc.f != null && this.mc.f.g.contains(this.emmiter);
    }

    public static void registerIcons(mt ir2) {
        icons = new ParticleIcon[3];
        for (int i2 = 0; i2 < 3; ++i2) {
            LighterParticleEmitter.icons[i2] = (ParticleIcon)ir2.a("stalker:lighter/fire");
        }
        sparkIcon = (ParticleIcon)ir2.a("stalker:lighter/spark");
    }
}

