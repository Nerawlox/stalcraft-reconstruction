/*
 * Decompiled with CFR 0.152.
 */
import atomicstryker.dynamiclights.client.IDynamicLightSource;
import gloomyfolken.mods.weapon.entity.EntityFlashlight;
import net.minecraft.entity.Entity;

public class gpzl
implements IDynamicLightSource {
    private EntityFlashlight _a;

    public gpzl(EntityFlashlight entityFlashlight) {
        this._a = entityFlashlight;
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

