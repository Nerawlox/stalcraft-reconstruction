/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.sajh;

@Deprecated
public class uyae
extends ncyh {
    private kkfz _a;
    private boolean _b = false;
    private int _c = 1;
    private int _d = 0;
    private int _e = 0;
    private static final float _f = (float)Math.PI / 180;

    public uyae(kkfz kkfz2, ejcz ejcz2) {
        super(kkfz2, 0.0f, 1.4f, ejcz2);
        this._a = kkfz2;
        mqkr mqkr2 = (mqkr)kkfz2.particleSource;
        this.setPosition(kkfz2.centerX, kkfz2.centerY - 2.5, kkfz2.centerZ);
        this.alpha = 0.0f;
    }

    @Override
    public void tick() {
        super.tick();
        Random random = this._a.world.rand;
        this.burn = 0.2f + random.nextFloat() * 0.1f;
        this._e = (this._e + 2 * this._c) % 360;
        ++this._d;
        if (random.nextInt(20) == 0) {
            this.rotationSpeed = (random.nextFloat() - 0.5f) * 10.0f;
        }
        if (this._b && (random.nextInt(10) == 0 && this._d > 2 || this._a._b._d >= 0)) {
            this._b = false;
            this._d = 0;
            this.textureSize = 0.0f;
        } else if (!this._b && random.nextInt(5) == 0 && this._d > 2 && this._a._b._d < 0) {
            this._b = true;
            this.prevRotation = this.rotation = random.nextFloat() * 360.0f;
            this._e = random.nextInt(360);
            this._d = 0;
            int n = this._c = random.nextBoolean() ? 1 : -1;
        }
        if (this._b) {
            this.moveTo(this._a.centerX + (double)sajh._b((float)Math.PI / 180 * (float)(this._e + 2 * this._c)), this._a.centerY - 2.0, this._a.centerZ + (double)sajh._a((float)Math.PI / 180 * (float)(this._e + 2 * this._c)));
            this.textureSize = Math.min(1.4f, this.textureSize + 0.1f);
        } else {
            this.setPosition(this._a.centerX + (double)sajh._b((float)Math.PI / 180 * (float)(this._e + 2 * this._c)), this._a.centerY - 2.0, this._a.centerZ + (double)sajh._a((float)Math.PI / 180 * (float)(this._e + 2 * this._c)));
        }
        this.alpha = this._b ? Math.min(1.0f, (float)this._d * 0.5f) : Math.max(0.0f, 1.0f - (float)this._d * 0.5f);
    }
}

