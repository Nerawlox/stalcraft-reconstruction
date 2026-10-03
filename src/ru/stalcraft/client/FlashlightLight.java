/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client;

import atomicstryker.dynamiclights.client.IDynamicLightSource;
import ru.stalcraft.entity.EntityFlashlight;

public class FlashlightLight
implements IDynamicLightSource {
    private EntityFlashlight entity;

    public FlashlightLight(EntityFlashlight shot) {
        this.entity = shot;
    }

    @Override
    public nn getAttachmentEntity() {
        return this.entity;
    }

    @Override
    public int getLightLevel() {
        return 15;
    }
}

