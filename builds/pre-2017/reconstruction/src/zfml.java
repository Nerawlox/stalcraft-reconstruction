/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;

public class zfml
extends ejdy {
    private vkbp _b;
    public int _a;

    public zfml(vkbp vkbp2, ejcz ejcz2) {
        super(vkbp2, 1.0f, ejcz2);
        this._b = vkbp2;
        this.setCollisionSize(1.0f);
        this.prevAlpha = 0.5f;
        this.alpha = 0.5f;
    }

    @Override
    public void tick() {
        super.tick();
        this.motionX += eidj._a._h * 0.02f + (this._b.world.rand.nextFloat() - 0.5f) * 0.0025f;
        this.motionZ += eidj._a._i * 0.02f + (this._b.world.rand.nextFloat() - 0.5f) * 0.0025f;
        this.textureSize *= 1.01f;
        if (this._a - this.ticksExisted < 20) {
            this.alpha -= 0.05f;
            this.textureSize *= 1.01f;
        }
        if (this.ticksExisted > this._a) {
            this.isDead = true;
        }
    }
}

