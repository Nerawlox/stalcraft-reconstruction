/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;

public class kkcn
extends ncyh {
    private kkfz _h;
    public float _a;
    public float _b;
    public float _c;
    public float _d;
    public float _e;
    public float _f;
    public float _g;
    private boolean _i;

    public kkcn(kkfz kkfz2, ejcz ejcz2, boolean bl, float f) {
        super(kkfz2, bl ? 0.06f : 0.6f, bl ? 0.1f : 1.0f, ejcz2);
        this._h = kkfz2;
        Random random = kkfz2.world.rand;
        this.rotation = random.nextFloat() * 360.0f;
        this._a = random.nextFloat() * 360.0f;
        this._b = random.nextFloat() * 360.0f;
        this._e = random.nextFloat() * 3.0f;
        float f2 = random.nextFloat() * f;
        this._f = (f2 - this._e) / 120.0f;
        double d = (double)(-sajh._a(this._a / 180.0f * (float)Math.PI) * sajh._b(this._b / 180.0f * (float)Math.PI) * this._e) + kkfz2.centerX;
        double d2 = (double)(sajh._b(this._a / 180.0f * (float)Math.PI) * sajh._b(this._b / 180.0f * (float)Math.PI) * this._e) + kkfz2.centerZ;
        this.setPosition(d, kkfz2.centerY - 4.0, d2);
        this._c = 1.5f + random.nextFloat() / 2.0f;
        this._d = random.nextFloat() / 10.0f;
        this.rotationSpeed = (kkfz2.world.rand.nextFloat() - 0.5f) * 15.0f;
        this._g = 0.07f + random.nextFloat() / 30.0f;
        this.speedFactor = 0.9f;
        this._i = bl;
    }

    @Override
    public void tick() {
        super.tick();
        this.motionY = (float)((double)this.motionY - 0.02);
        if (this._h._b._d < 120) {
            this._a();
        } else if (this._h._b._d == 120) {
            this._b();
        }
        if (!this._i && this._h._b._d > 120) {
            this.alpha = Math.max((float)(200 - this._h._b._d) / 80.0f, 0.0f);
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
        if (this.ticksExisted > 30) {
            this._c *= 1.03f;
        }
        this._a = (this._a + this._c) % 360.0f;
        float f2 = -sajh._a(this._a / 180.0f * (float)Math.PI) * sajh._b(this._b / 180.0f * (float)Math.PI) * this._e + (float)this._h._b.xCoord + 0.5f;
        float f3 = sajh._b(this._a / 180.0f * (float)Math.PI) * sajh._b(this._b / 180.0f * (float)Math.PI) * this._e + (float)this._h._b.zCoord + 0.5f;
        this.motionX = f2 - (float)this.posX;
        this.motionZ = f3 - (float)this.posZ;
    }

    private void _b() {
        Vec3 vec3 = Vec3._a(this.posX - (double)this._h._b.xCoord - 0.5, this.posY - 4.0 - (double)this._h._b.yCoord - 0.5, this.posZ - (double)this._h._b.zCoord - 0.5)._a();
        this.motionX = (float)vec3._c * 0.3f;
        this.motionY = (float)vec3._d * 0.3f;
        this.motionZ = (float)vec3._e * 0.3f;
    }
}

