/*
 * Decompiled with CFR 0.152.
 */
package atomicstryker.dynamiclights.client;

import net.minecraft.entity.Entity;

public interface IDynamicLightSource {
    public Entity getAttachmentEntity();

    public int getLightLevel();
}

