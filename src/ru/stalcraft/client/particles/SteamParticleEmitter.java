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
import ru.stalcraft.client.particles.SteamParticle;
import ru.stalcraft.tile.TileEntitySteam;

public class SteamParticleEmitter
extends ParticleEmitter {
    private static final int MAX_PARTICLES_ACTIVE = 500;
    public static final int PARTICLE_LIFE = 40;
    private static ParticleIcon[] icons;

    public SteamParticleEmitter(TileEntitySteam steam) {
        super(steam);
        super.setCenter(this.centerX + 0.5, this.centerY, this.centerZ + 0.5);
        super.setSize(-2.0, -3.0, -2.0, 2.0, 7.0, 2.0);
    }

    @Override
    public void tick() {
        super.tick();
        for (int i2 = 0; i2 < 12; ++i2) {
            this.particles.add(new SteamParticle(this, icons[this.world.s.nextInt(icons.length)]));
        }
        this.renderDistanceSq = GuiSettingsStalker.particleRenderDistance * GuiSettingsStalker.particleRenderDistance;
    }

    @Override
    public boolean isValid() {
        return this.mc.f != null && this.mc.f.g.contains(this.emmiter);
    }

    public static void registerIcons(mt ir2) {
        icons = new ParticleIcon[1];
        SteamParticleEmitter.icons[0] = (ParticleIcon)ir2.a("stalker:steam/steam1");
    }
}

