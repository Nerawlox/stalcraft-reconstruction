/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anomaly;

import atomicstryker.dynamiclights.client.IDynamicLightSource;
import gloomyfolken.mods.anomaly.entity.EntityLighterLight;
import net.minecraft.entity.Entity;

public class tupg
implements IDynamicLightSource {
    private EntityLighterLight _a;

    public tupg(EntityLighterLight entityLighterLight) {
        this._a = entityLighterLight;
    }

    @Override
    public Entity getAttachmentEntity() {
        return this._a;
    }

    @Override
    public int getLightLevel() {
        return 15;
    }
}

