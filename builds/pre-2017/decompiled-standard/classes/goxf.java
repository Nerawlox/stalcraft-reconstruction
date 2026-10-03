/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.entity.EntityBolt;

public class goxf
extends ncyh {
    private tvlv _a;

    public goxf(tvlv tvlv2, EntityBolt entityBolt) {
        super(tvlv2, 0.0f, 1.4f, dwpk._i);
        this._a = tvlv2;
        if (entityBolt != null) {
            this.setPosition(entityBolt.field_70165_t, entityBolt.field_70163_u, entityBolt.field_70161_v);
        }
        this.alpha = 1.0f;
        this.prevAlpha = 1.0f;
        this.prevBurn = this.burn = 0.2f + tvlv2.world.field_73012_v.nextFloat() * 0.1f;
        this.rotation = tvlv2.world.field_73012_v.nextFloat() * 360.0f;
        this.textureSize = 0.0f;
    }

    @Override
    public void tick() {
        super.tick();
        this.alpha -= 0.06f;
        if (this.textureSize < 1.0f) {
            this.textureSize = (float)((double)this.textureSize + 0.1);
        }
        if (this.alpha < 0.05f) {
            this.isDead = true;
        }
    }
}

