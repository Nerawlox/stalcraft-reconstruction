/*
 * Decompiled with CFR 0.152.
 */
public class uhci
extends ejdy {
    private static final float _a = 0.5f;

    public uhci(eiul eiul2, ejcz ejcz2) {
        super(eiul2, 0.0f, ejcz2);
        this.setPosition(eiul2.centerX, eiul2.centerY, eiul2.centerZ);
        this.alpha = 0.5f;
        this.prevAlpha = 0.5f;
    }

    @Override
    public void tick() {
        super.tick();
        this.textureSize += 0.1f;
        this.alpha -= 0.02f;
        if (this.alpha <= 0.0f) {
            this.textureSize = 0.0f;
            this.prevTextureSize = 0.0f;
            this.alpha = 0.5f;
            this.prevAlpha = 0.5f;
        }
        this.posY = this._a().centerY + (double)(this.textureSize / 2.0f);
    }

    public eiul _a() {
        return (eiul)this.parent;
    }

    @Override
    public /* synthetic */ tvlv getParent() {
        return this._a();
    }
}

