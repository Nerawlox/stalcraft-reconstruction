/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.sajh;

public class ezsf
extends ncyh {
    private eiqn _h;
    public float _a;
    public float _b;
    public float _c;
    public float _d;
    public float _e;
    public float _f;
    public float _g;
    private boolean _i;

    public ezsf(eiqn eiqn2, ejcz ejcz2, boolean bl, float f) {
        super(eiqn2, bl ? 0.06f : 0.6f, bl ? 0.06f : 1.0f, ejcz2);
        this._h = eiqn2;
        Random random = eiqn2.world.field_73012_v;
        this.rotation = random.nextFloat() * 360.0f;
        this._a = random.nextFloat() * 360.0f;
        this._b = random.nextFloat() * 360.0f;
        this._e = random.nextFloat() * 3.0f;
        float f2 = random.nextFloat() * f;
        this._f = (f2 - this._e) / 120.0f;
        double d = (double)(-sajh._a(this._a / 180.0f * (float)Math.PI) * sajh._b(this._b / 180.0f * (float)Math.PI) * this._e) + eiqn2.centerX;
        double d2 = (double)(sajh._b(this._a / 180.0f * (float)Math.PI) * sajh._b(this._b / 180.0f * (float)Math.PI) * this._e) + eiqn2.centerZ;
        this.setPosition(d, eiqn2.centerY - 4.0, d2);
        this._c = 1.5f + random.nextFloat() / 2.0f;
        this._d = random.nextFloat() / 10.0f;
        this.rotationSpeed = (eiqn2.world.field_73012_v.nextFloat() - 0.5f) * 15.0f;
        this._g = 0.04f + random.nextFloat() / 50.0f;
        this.speedFactor = 0.9f;
        this._i = bl;
    }

    @Override
    public void tick() {
        super.tick();
        this.motionY = (float)((double)this.motionY - 0.02);
        if (this._h._a._d >= 0) {
            this._a();
        }
        if (!this._i && this._h._a._d == -1) {
            this.alpha = Math.max((float)(80 - this._h._a._e) / 80.0f, 0.0f);
            this.textureSize *= 0.97f;
        }
        if (this.onGround) {
            this.rotationSpeed = (float)((double)this.rotationSpeed * 0.75);
        }
    }

    private void _a() {
        this._e += this._f;
        this._b = (this._b + this._d) % 360.0f;
        float f = -sajh._a(this._b / 180.0f * (float)Math.PI) * this._e + (float)this._h.centerY;
        this.motionY = (float)((double)this._g > Math.abs((double)f - this.posY) ? (double)f - this.posY : (double)this._g);
        this._g *= 0.992f;
        if (this.ticksExisted > 30 && this.ticksExisted < 150) {
            this._c *= 1.03f;
        }
        this._a = (this._a + this._c) % 360.0f;
        float f2 = -sajh._a(this._a / 180.0f * (float)Math.PI) * sajh._b(this._b / 180.0f * (float)Math.PI) * this._e + (float)this._h._a.field_70329_l + 0.5f;
        float f3 = sajh._b(this._a / 180.0f * (float)Math.PI) * sajh._b(this._b / 180.0f * (float)Math.PI) * this._e + (float)this._h._a.field_70327_n + 0.5f;
        this.motionX = f2 - (float)this.posX;
        this.motionZ = f3 - (float)this.posZ;
    }
}

