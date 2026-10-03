/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.entity;

import atomicstryker.dynamiclights.client.DynamicLights;
import ru.stalcraft.Logger;
import ru.stalcraft.client.LighterLight;
import ru.stalcraft.tile.TileEntityLighter;

public class EntityLighterLight
extends nn {
    public TileEntityLighter tile;

    public EntityLighterLight(TileEntityLighter tile) {
        super(tile.k);
        this.tile = tile;
        this.a(0.0f, 0.0f);
        this.Z = true;
        this.b((double)tile.l + 0.5, (double)tile.m + 0.5, (double)tile.n + 0.5);
        DynamicLights.addLightSource(new LighterLight(this));
    }

    @Override
    public void l_() {
        super.l_();
        Logger.debug("tick");
        if (this.tile.r() || this.tile.activeTimer <= 0) {
            this.x();
        }
    }

    @Override
    protected void a() {
    }

    @Override
    protected void a(by nbttagcompound) {
    }

    @Override
    protected void b(by nbttagcompound) {
    }
}

