/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.entity.EntityBolt;

public class wnfb
extends ejdy {
    public wnfb(tvlv tvlv2, EntityBolt entityBolt) {
        super(tvlv2, 0.0f, dwpk._i);
        this.setPosition(entityBolt.field_70165_t, entityBolt.field_70163_u, entityBolt.field_70161_v);
        this.alpha = 0.7f;
        this.prevAlpha = 0.7f;
    }

    @Override
    public void tick() {
        super.tick();
        this.alpha -= 0.05f;
        this.textureSize += 0.2f;
        if (this.alpha <= 0.0f) {
            this.isDead = true;
        }
    }
}

