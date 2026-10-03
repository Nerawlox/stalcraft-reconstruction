/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.tile;

import ru.stalcraft.client.particles.SteamParticleEmitter;
import ru.stalcraft.tile.TileEntityAnomaly;

public class TileEntitySteam
extends TileEntityAnomaly {
    @Override
    protected Class getEmitterClass() {
        return SteamParticleEmitter.class;
    }
}

