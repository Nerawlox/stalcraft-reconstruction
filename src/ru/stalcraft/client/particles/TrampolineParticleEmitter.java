/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mt
 */
package ru.stalcraft.client.particles;

import java.util.ArrayList;
import java.util.Iterator;
import ru.stalcraft.client.effects.particles.ParticleEmitter;
import ru.stalcraft.client.effects.particles.ParticleIcon;
import ru.stalcraft.client.gui.GuiSettingsStalker;
import ru.stalcraft.client.particles.TrampolineDustParticle;
import ru.stalcraft.client.particles.TrampolineStoneParticle;
import ru.stalcraft.tile.TileEntityTrampoline;

public class TrampolineParticleEmitter
extends ParticleEmitter {
    private static final int PARTICLES_COUNT = 50;
    private static final int DUST_PARTICLES_COUNT = 250;
    private static ParticleIcon[] stoneIcons;
    private static ParticleIcon[] dustIcons;
    private ArrayList stones;

    public TrampolineParticleEmitter(TileEntityTrampoline trampoline) {
        super(trampoline);
        super.setCenter(this.centerX + 0.5, this.centerY, this.centerZ + 0.5);
        super.setSize(-2.0, -2.0, -2.0, 2.0, 3.0, 2.0);
        this.stones = new ArrayList();
        for (int i2 = 0; i2 < 50; ++i2) {
            this.stones.add(new TrampolineStoneParticle(this, stoneIcons[this.world.s.nextInt(stoneIcons.length)]));
        }
        this.particles.addAll(this.stones);
    }

    @Override
    public void tick() {
        super.tick();
        this.renderDistanceSq = GuiSettingsStalker.particleRenderDistance * GuiSettingsStalker.particleRenderDistance;
    }

    @Override
    public boolean isValid() {
        return this.mc.f != null && this.mc.f.g.contains(this.emmiter);
    }

    @Override
    public void reset() {
        super.reset();
        this.particles.addAll(this.stones);
    }

    public static void registerIcons(mt ir2) {
        stoneIcons = new ParticleIcon[8];
        dustIcons = new ParticleIcon[8];
        for (int i2 = 0; i2 < 8; ++i2) {
            TrampolineParticleEmitter.stoneIcons[i2] = (ParticleIcon)ir2.a("stalker:stone/stone" + (i2 + 1));
            TrampolineParticleEmitter.dustIcons[i2] = (ParticleIcon)ir2.a("stalker:dust/dust" + (i2 + 1));
        }
    }

    public void onActivate() {
        Iterator it2 = this.stones.iterator();
        for (int i2 = 0; i2 < 250; ++i2) {
            this.particles.add(new TrampolineDustParticle(this, dustIcons[this.world.s.nextInt(dustIcons.length)]));
        }
        TrampolineStoneParticle stone = null;
        while (it2.hasNext()) {
            stone = (TrampolineStoneParticle)it2.next();
            stone.jump();
        }
    }
}

