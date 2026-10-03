/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import java.util.Random;

public class dwpy
extends ncyh {
    public int _a;
    private static final float _c = 0.2f;
    public float _b = 1.0f;
    private float _d;

    public dwpy(vkbp vkbp2, ejcz ejcz2) {
        super(vkbp2, 0.0f, 0.0f, ejcz2);
        this.parent = vkbp2;
        Random random = vkbp2.world.rand;
        this.burn = 0.95f;
        this.prevBurn = 0.95f;
        this.prevAlpha = this.alpha = Math.min(1.0f, (float)Math.pow(random.nextFloat(), 3.2) + 0.1f);
        this._d = this.alpha;
        this._d -= 0.1f;
    }

    @Override
    public void tick() {
        super.tick();
        this.textureSize *= this._b;
        this.motionX += eidj._a._h * 0.3f + (this.parent.world.rand.nextFloat() - 0.5f) * 0.01f;
        this.motionY = 0.2f;
        this.motionZ += eidj._a._i * 0.3f + (this.parent.world.rand.nextFloat() - 0.5f) * 0.01f;
        if (this.ticksExisted < 3) {
            this.alpha -= 0.05f;
        }
        if (this._a - this.ticksExisted < 5) {
            this.alpha = Math.max(0.0f, (float)(this._a - this.ticksExisted) * 0.25f * this._d);
        }
        if (this.ticksExisted >= this._a) {
            this.isDead = true;
        }
    }

    @Override
    public int getBrightness(int n, int n2, int n3) {
        return 0xF000F0;
    }
}

