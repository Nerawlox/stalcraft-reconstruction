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
import ru.stalcraft.client.particles.FunnelEyeParticle;
import ru.stalcraft.client.particles.FunnelParticle;
import ru.stalcraft.client.particles.GraviSplashParticle;
import ru.stalcraft.tile.TileEntityFunnel;

public class FunnelParticleEmitter
extends ParticleEmitter {
    private static final int DUST_PARTICLES_NUMBER = 750;
    private static final int LEAF_PARTICLES_NUMBER = 100;
    public static final float dustSize = 1.0f;
    private int notSpawnedDustParticles = 750;
    private int notSpawnedLeafParticles = 100;
    private FunnelEyeParticle eye;
    private static ParticleIcon[] dustTextureCoords;
    private static ParticleIcon[] leafTextureCoords;
    private static ParticleIcon eyeTextureCoords;
    private static ParticleIcon blastTextureCoords;

    public FunnelParticleEmitter(TileEntityFunnel funnel) {
        super(funnel);
        super.setCenter(this.centerX + 0.5, this.centerY + 4.5, this.centerZ + 0.5);
        super.setSize(-3.0, -5.0, -3.0, 3.0, 4.0, 3.0);
        this.addEye();
    }

    @Override
    public void tick() {
        TileEntityFunnel tile = (TileEntityFunnel)this.emmiter;
        if (tile.activeTimer >= 0 && tile.activeTimer < 120) {
            int leafParticlesToSpawn;
            int dustParticlesToSpawn = this.notSpawnedDustParticles / 15 + this.notSpawnedDustParticles % 15;
            for (leafParticlesToSpawn = 0; leafParticlesToSpawn < dustParticlesToSpawn; ++leafParticlesToSpawn) {
                this.particles.add(new FunnelParticle(this, dustTextureCoords[this.world.s.nextInt(dustTextureCoords.length)], false, 0.5f));
            }
            this.notSpawnedDustParticles -= dustParticlesToSpawn;
            leafParticlesToSpawn = this.notSpawnedLeafParticles / 15 + this.notSpawnedLeafParticles % 15;
            for (int i2 = 0; i2 < leafParticlesToSpawn; ++i2) {
                this.particles.add(new FunnelParticle(this, leafTextureCoords[this.world.s.nextInt(leafTextureCoords.length)], true, 0.5f));
            }
            this.notSpawnedLeafParticles -= leafParticlesToSpawn;
        } else if (tile.activeTimer == 120) {
            this.particles.add(new GraviSplashParticle(this, blastTextureCoords));
        }
        this.renderDistanceSq = GuiSettingsStalker.particleRenderDistance * GuiSettingsStalker.particleRenderDistance;
        super.tick();
    }

    @Override
    public void reset() {
        super.reset();
        this.notSpawnedDustParticles = 750;
        this.notSpawnedLeafParticles = 100;
        this.particles.add(this.eye);
    }

    private void addEye() {
        this.eye = new FunnelEyeParticle(this, eyeTextureCoords);
        this.particles.add(this.eye);
    }

    @Override
    public boolean isValid() {
        return this.mc.f != null && this.mc.f.g.contains(this.emmiter);
    }

    public static void registerIcons(mt ir2) {
        dustTextureCoords = new ParticleIcon[8];
        for (int i2 = 0; i2 < 8; ++i2) {
            FunnelParticleEmitter.dustTextureCoords[i2] = (ParticleIcon)ir2.a("stalker:dust/dust" + (i2 + 1));
        }
        leafTextureCoords = new ParticleIcon[2];
        FunnelParticleEmitter.leafTextureCoords[0] = (ParticleIcon)ir2.a("stalker:leaf/leaf1");
        FunnelParticleEmitter.leafTextureCoords[1] = (ParticleIcon)ir2.a("stalker:leaf/leaf2");
        eyeTextureCoords = (ParticleIcon)ir2.a("stalker:funnel/funnel_eye");
        blastTextureCoords = (ParticleIcon)ir2.a("stalker:funnel/funnel_blast");
    }
}

