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
import ru.stalcraft.client.particles.KisselBubbleParticle;
import ru.stalcraft.tile.TileEntityKissel;

public class KisselParticleEmitter
extends ParticleEmitter {
    private static ParticleIcon bubbleIcon;

    public KisselParticleEmitter(TileEntityKissel kissel) {
        super(kissel);
        super.setCenter(this.centerX + 0.5, (float)this.centerY + 0.1f, this.centerZ + 0.5);
        super.setSize(-1.0, -1.0, -1.0, 1.0, 2.0, 1.0);
    }

    @Override
    public void tick() {
        super.tick();
        this.particles.add(new KisselBubbleParticle(this, 0.05f + this.world.s.nextFloat() * 0.05f, bubbleIcon));
        this.renderDistanceSq = GuiSettingsStalker.particleRenderDistance * GuiSettingsStalker.particleRenderDistance;
    }

    public void spawnActiveParticles() {
        KisselBubbleParticle particle = null;
        for (int i2 = 0; i2 < 25; ++i2) {
            particle = new KisselBubbleParticle(this, 0.05f + this.world.s.nextFloat() * 0.05f, bubbleIcon);
            this.particles.add(particle);
            particle.motionY += 0.02f + this.world.s.nextFloat() * 0.01f;
        }
    }

    @Override
    public boolean isValid() {
        return this.mc.f != null && this.mc.f.g.contains(this.emmiter);
    }

    @Override
    public void reset() {
        super.reset();
    }

    public static void registerIcons(mt ir2) {
        bubbleIcon = (ParticleIcon)ir2.a("stalker:bubble");
    }

    public void onActivate() {
    }
}

