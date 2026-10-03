/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client;

import atomicstryker.dynamiclights.client.IDynamicLightSource;
import ru.stalcraft.entity.EntityShot;

public class ShotLight
implements IDynamicLightSource {
    private EntityShot entity;

    public ShotLight(EntityShot shot) {
        this.entity = shot;
    }

    @Override
    public nn getAttachmentEntity() {
        return this.entity;
    }

    @Override
    public int getLightLevel() {
        return 12;
    }
}

