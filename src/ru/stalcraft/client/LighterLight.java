/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client;

import atomicstryker.dynamiclights.client.IDynamicLightSource;
import ru.stalcraft.entity.EntityLighterLight;

public class LighterLight
implements IDynamicLightSource {
    private EntityLighterLight entity;

    public LighterLight(EntityLighterLight entity) {
        this.entity = entity;
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

