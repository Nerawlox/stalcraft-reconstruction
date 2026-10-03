/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.tile;

import ru.stalcraft.client.particles.KisselParticleEmitter;
import ru.stalcraft.tile.TileEntityAnomaly;

public class TileEntityKissel
extends TileEntityAnomaly {
    @Override
    protected Class getEmitterClass() {
        return KisselParticleEmitter.class;
    }
}

