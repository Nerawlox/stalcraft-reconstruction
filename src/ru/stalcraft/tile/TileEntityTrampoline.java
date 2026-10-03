/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
package ru.stalcraft.tile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ru.stalcraft.client.particles.TrampolineParticleEmitter;
import ru.stalcraft.tile.TileEntityAnomaly;

public class TileEntityTrampoline
extends TileEntityAnomaly {
    @Override
    protected Class getEmitterClass() {
        return TrampolineParticleEmitter.class;
    }

    @SideOnly(value=Side.CLIENT)
    public void onActivate() {
        ((TrampolineParticleEmitter)this.getParticleEmitter()).onActivate();
    }
}

