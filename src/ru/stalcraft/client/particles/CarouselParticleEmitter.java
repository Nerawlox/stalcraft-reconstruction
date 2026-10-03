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
import ru.stalcraft.client.particles.CarouselParticle;
import ru.stalcraft.client.particles.CarouselTornadoParticle;
import ru.stalcraft.client.particles.GraviSplashParticle;
import ru.stalcraft.tile.TileEntityCarousel;

public class CarouselParticleEmitter
extends ParticleEmitter {
    private static final int TORNADO_PARTICLES_NUMBER = 100;
    private static final int DUST_PARTICLES_NUMBER = 750;
    private static final int LEAF_PARTICLES_NUMBER = 100;
    private int notSpawnedDustParticles = 750;
    private int notSpawnedLeafParticles = 100;
    private static ParticleIcon[] dustTextureCoords;
    private static ParticleIcon[] leafTextureCoords;
    private static ParticleIcon blastTextureCoords;

    public CarouselParticleEmitter(TileEntityCarousel carousel) {
        super(carousel);
        super.setCenter(this.centerX + 0.5, this.centerY + 4.5, this.centerZ + 0.5);
        super.setSize(-3.0, -5.0, -3.0, 3.0, 4.0, 3.0);
    }

    @Override
    public void tick() {
        int i2;
        TileEntityCarousel tile = (TileEntityCarousel)this.emmiter;
        if (tile.activeTimer >= 0) {
            int leafParticlesToSpawn;
            i2 = this.notSpawnedDustParticles / 15 + this.notSpawnedDustParticles % 15;
            for (leafParticlesToSpawn = 0; leafParticlesToSpawn < i2; ++leafParticlesToSpawn) {
                this.particles.add(new CarouselParticle(this, dustTextureCoords[this.world.s.nextInt(dustTextureCoords.length)], false, 1.8f));
            }
            this.notSpawnedDustParticles -= i2;
            leafParticlesToSpawn = this.notSpawnedLeafParticles / 15 + this.notSpawnedLeafParticles % 15;
            for (int i1 = 0; i1 < leafParticlesToSpawn; ++i1) {
                this.particles.add(new CarouselParticle(this, leafTextureCoords[this.world.s.nextInt(leafTextureCoords.length)], true, 1.8f));
            }
            this.notSpawnedLeafParticles -= leafParticlesToSpawn;
        } else if (tile.ticksSinceActive == 80) {
            super.reset();
        }
        if (tile.activeTimer < 0) {
            for (i2 = 0; i2 < 3; ++i2) {
                this.particles.add(new CarouselTornadoParticle(this, dustTextureCoords[this.world.s.nextInt(dustTextureCoords.length)]));
            }
        }
        this.renderDistanceSq = GuiSettingsStalker.particleRenderDistance * GuiSettingsStalker.particleRenderDistance;
        super.tick();
    }

    @Override
    public void reset() {
        super.reset();
        this.notSpawnedDustParticles = 750;
        this.notSpawnedLeafParticles = 100;
    }

    @Override
    public boolean isValid() {
        return this.mc.f != null && this.mc.f.g.contains(this.emmiter);
    }

    public void spawnSplashParticle(of target) {
        GraviSplashParticle particle = new GraviSplashParticle(this, blastTextureCoords);
        this.particles.add(particle);
        particle.setPosition(target.u, target.v + (double)(target.P / 2.0f), target.w);
    }

    public static void registerIcons(mt ir2) {
        dustTextureCoords = new ParticleIcon[8];
        for (int i2 = 0; i2 < 8; ++i2) {
            CarouselParticleEmitter.dustTextureCoords[i2] = (ParticleIcon)ir2.a("stalker:dust/dust" + (i2 + 1));
        }
        leafTextureCoords = new ParticleIcon[2];
        CarouselParticleEmitter.leafTextureCoords[0] = (ParticleIcon)ir2.a("stalker:leaf/leaf1");
        CarouselParticleEmitter.leafTextureCoords[1] = (ParticleIcon)ir2.a("stalker:leaf/leaf2");
        blastTextureCoords = (ParticleIcon)ir2.a("stalker:funnel/funnel_blast");
    }
}

